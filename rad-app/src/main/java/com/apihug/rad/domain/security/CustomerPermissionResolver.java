package com.apihug.rad.domain.security;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.RoleMenuEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.role.repository.RoleMenuEntityRepository;
import com.apihug.rad.domain.tenant.MemberRoleEntity;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.MemberRoleEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import hope.common.meta.annotation.Template;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Core permission resolver service (internal, non-API).
 * Resolves the complete permission chain:
 * Customer -> TenantMember -> MemberRole -> RoleEntity -> RoleMenu -> MenuEntity.permission_code
 *
 */
@Template(type = Template.Type.SERVICE, usage = "Customer permission resolver", percentage = 100)
@Service
public class CustomerPermissionResolver {

  /** Wildcard indicating all permissions (like RuoYi's *:*:*) */
  public static final String ALL_PERMISSIONS = "*:*:*";
  /** Wildcard indicating super admin role */
  public static final String SUPER_ADMIN_ROLE = "*";

  private final TenantMemberEntityRepository tenantMemberRepository;
  private final MemberRoleEntityRepository memberRoleRepository;
  private final RoleEntityRepository roleRepository;
  private final RoleMenuEntityRepository roleMenuRepository;
  private final MenuEntityRepository menuRepository;

  public CustomerPermissionResolver(
      TenantMemberEntityRepository tenantMemberRepository,
      MemberRoleEntityRepository memberRoleRepository,
      RoleEntityRepository roleRepository,
      RoleMenuEntityRepository roleMenuRepository,
      MenuEntityRepository menuRepository) {
    this.tenantMemberRepository = tenantMemberRepository;
    this.memberRoleRepository = memberRoleRepository;
    this.roleRepository = roleRepository;
    this.roleMenuRepository = roleMenuRepository;
    this.menuRepository = menuRepository;
  }

  /**
   * Check if the given authorities set represents a super admin (OWNER).
   */
  public static boolean isSuperAdmin(Set<String> authorities) {
    return authorities != null && authorities.contains(ALL_PERMISSIONS);
  }

  /**
   * Check if the given roles set represents a super admin (OWNER).
   */
  public static boolean isSuperAdminRole(Set<String> roles) {
    return roles != null && roles.contains(SUPER_ADMIN_ROLE);
  }

  /**
   * Resolve all RBAC role codes for a customer in a specific tenant.
   *
   * @param customerId customer ID
   * @param tenantId   tenant ID
   * @return Set of role_code strings; OWNER returns Set.of("*")
   */
  public Set<String> resolveRoles(Long customerId, Long tenantId) {
    if (customerId == null || tenantId == null || tenantId <= 0) {
      return Collections.emptySet();
    }

    // Find TenantMember
    Optional<TenantMemberEntity> memberOpt =
        tenantMemberRepository.findByCustomerIdAndTenantId(customerId, tenantId);
    if (memberOpt.isEmpty()) {
      return Collections.emptySet();
    }

    TenantMemberEntity member = memberOpt.get();

    // OWNER gets super admin role
    if (member.getMemberRole() == MemberRoleEnum.OWNER) {
      return Set.of(SUPER_ADMIN_ROLE);
    }

    // Find assigned RBAC roles via SYS_MEMBER_ROLE
    List<MemberRoleEntity> memberRoles = memberRoleRepository.findByMemberId(member.getId());
    if (memberRoles.isEmpty()) {
      return Collections.emptySet();
    }

    List<Long> roleIds = memberRoles.stream()
        .map(MemberRoleEntity::getRoleId)
        .collect(Collectors.toList());

    // Load RoleEntities and collect role_codes
    List<RoleEntity> roles = roleRepository.findAllById(roleIds);
    return roles.stream()
        .map(RoleEntity::getRoleCode)
        .collect(Collectors.toSet());
  }

  /**
   * Resolve all atomic authorities for a customer in a specific tenant.
   * Follows the chain: TenantMember -> MemberRole -> RoleMenu -> Menu.permission_code
   *
   * @param customerId customer ID
   * @param tenantId   tenant ID
   * @return Set of authority strings (from MenuEntity.permission_code); OWNER returns Set.of("*:*:*")
   */
  public Set<String> resolveAuthorities(Long customerId, Long tenantId) {
    if (customerId == null || tenantId == null || tenantId <= 0) {
      return Collections.emptySet();
    }

    // Find TenantMember
    Optional<TenantMemberEntity> memberOpt =
        tenantMemberRepository.findByCustomerIdAndTenantId(customerId, tenantId);
    if (memberOpt.isEmpty()) {
      return Collections.emptySet();
    }

    TenantMemberEntity member = memberOpt.get();

    // OWNER gets all permissions
    if (member.getMemberRole() == MemberRoleEnum.OWNER) {
      //TODO This is Wrong, There are some platform ROLE
      return Set.of(ALL_PERMISSIONS);
    }

    // Find assigned RBAC roles via SYS_MEMBER_ROLE
    List<MemberRoleEntity> memberRoles = memberRoleRepository.findByMemberId(member.getId());
    if (memberRoles.isEmpty()) {
      return Collections.emptySet();
    }

    List<Long> roleIds = memberRoles.stream()
        .map(MemberRoleEntity::getRoleId)
        .collect(Collectors.toList());

    // Find all menus assigned to these roles via SYS_ROLE_MENU
    List<RoleMenuEntity> roleMenus = roleMenuRepository.findByRoleIdIn(roleIds);
    if (roleMenus.isEmpty()) {
      return Collections.emptySet();
    }

    List<Long> menuIds = roleMenus.stream()
        .map(RoleMenuEntity::getMenuId)
        .distinct()
        .collect(Collectors.toList());

    // Load MenuEntities and collect permission_codes (non-null, non-blank)
    List<MenuEntity> menus = menuRepository.findAllById(menuIds);
    return menus.stream()
        .map(MenuEntity::getPermissionCode)
        .filter(code -> code != null && !code.isBlank())
        .collect(Collectors.toSet());
  }
}
