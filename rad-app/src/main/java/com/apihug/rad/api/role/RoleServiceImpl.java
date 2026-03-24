// @formatter:off
package com.apihug.rad.api.role;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.RoleMenuEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.role.repository.RoleMenuEntityRepository;
import com.apihug.rad.infra.role.RoleErrorEnum;
import com.apihug.rad.infra.role.RoleStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.context.HopeContextHolder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * Service layer implementation for handling requests from the controller layer {@link com.apihug.rad.api.role.RoleController}.
 *
 * This class serves as the orchestrator between the web/controller layer and
 * multiple domain/data access layers, implementing the application's business
 * use cases through cross-domain coordination.
 *
 * ARCHITECTURAL GUIDELINES:
 *
 * 1. Data Access Responsibility:
 *  - Complex SQL queries, data composition, and database logic should NOT be
 *    implemented in this service class
 *  - Such database-specific operations must be delegated to the corresponding
 *    repository trait extensions within each domain
 *  - Each domain's repositories serve as the single source of truth for their
 *    respective data access logic
 *
 * 2. Cross-Domain Coordination:
 *  - This service may coordinate and aggregate data from MULTIPLE domain layers
 *  - When business use cases require data from different domains, this service
 *    is responsible for:
 *    a) Invoking the appropriate repositories from each domain
 *    b) Composing/aggregating the results into a cohesive response
 *    c) Managing transactional boundaries across domains when necessary
 *
 * 3. Service Layer Responsibility:
 *  - Act as a thin facade/mediator between controllers and multiple domain layers
 *  - Focus on request mapping, validation coordination, and transaction management
 *  - Delegate to domain-specific repositories for data operations
 *  - Maintain simplicity and clarity - avoid complex business logic here
 *
 * 4. Design Pattern:
 *  - Follow the Facade pattern to provide a unified interface to controllers
 *  - Keep the service layer focused on orchestration across domains, not on
 *    implementation details of any single domain
 */
@Template(type = Template.Type.SERVICE, usage = "Roles management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleService",
    kind = Kind.RPC,
    line = 13,
    column = 1
)
public class RoleServiceImpl implements RoleService {

  private final RoleEntityRepository roleRepository;
  private final RoleMenuEntityRepository roleMenuRepository;
  private final MenuEntityRepository menuRepository;

  public RoleServiceImpl(
      RoleEntityRepository roleRepository,
      RoleMenuEntityRepository roleMenuRepository,
      MenuEntityRepository menuRepository) {
    this.roleRepository = roleRepository;
    this.roleMenuRepository = roleMenuRepository;
    this.menuRepository = menuRepository;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles}
   * 	<p>{@code 创建新角色}
   * @see RoleService#createRole
   */
  @Override
  public void createRole(SimpleResultBuilder<RoleSummary> builder,
      CreateRoleRequest createRoleRequest) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    // 验证角色代码唯一性（租户内唯一）
    if (roleRepository.existsByRoleCodeAndTenantId(createRoleRequest.getRoleCode(), tenantId)) {
      throw HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_CODE_EXISTS).build();
    }

    // 创建角色实体
    RoleEntity entity = new RoleEntity()
        .setRoleCode(createRoleRequest.getRoleCode())
        .setRoleName(createRoleRequest.getRoleName())
        .setDescription(createRoleRequest.getDescription())
        .setStatus(createRoleRequest.getStatus() != null
            ? createRoleRequest.getStatus()
            : RoleStatusEnum.ACTIVE);

    // 保存角色
    RoleEntity saved = roleRepository.save(entity);

    // 返回摘要
    RoleSummary summary = new RoleSummary()
        .setId(saved.getId())
        .setRoleCode(saved.getRoleCode())
        .setRoleName(saved.getRoleName())
        .setStatus(saved.getStatus());

    builder.payload(summary);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 获取角色详情}
   * @see RoleService#getRole
   */
  @Override
  public void getRole(SimpleResultBuilder<RoleDetail> builder, Integer roleId) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    RoleEntity entity = roleRepository.findByIdAndTenantId(roleId.longValue(), tenantId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

    RoleDetail detail = new RoleDetail()
        .setId(entity.getId())
        .setRoleCode(entity.getRoleCode())
        .setRoleName(entity.getRoleName())
        .setDescription(entity.getDescription())
        .setStatus(entity.getStatus())
        .setCreatedAt(entity.getCreatedAt())
        .setUpdatedAt(entity.getUpdatedAt());

    builder.payload(detail);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 更新角色信息}
   * @see RoleService#updateRole
   */
  @Override
  public void updateRole(SimpleResultBuilder<String> builder, Integer roleId,
      UpdateRoleRequest updateRoleRequest) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    RoleEntity entity = roleRepository.findByIdAndTenantId(roleId.longValue(), tenantId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

    // 更新字段
    if (updateRoleRequest.getRoleName() != null) {
      entity.setRoleName(updateRoleRequest.getRoleName());
    }
    if (updateRoleRequest.getDescription() != null) {
      entity.setDescription(updateRoleRequest.getDescription());
    }
    if (updateRoleRequest.getStatus() != null) {
      entity.setStatus(updateRoleRequest.getStatus());
    }

    roleRepository.save(entity);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 删除角色（软删除）}
   * @see RoleService#deleteRole
   */
  @Override
  public void deleteRole(SimpleResultBuilder<String> builder, Integer roleId) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    RoleEntity entity = roleRepository.findByIdAndTenantId(roleId.longValue(), tenantId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

    // 软删除
    entity.setDeleted(true)
        .setDeletedAt(LocalDateTime.now())
        .setDeletedBy(((Long) HopeContextHolder.customer().getId()));

    roleRepository.save(entity);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/search}
   * 	<p>{@code 搜索角色（分页）}
   * @see RoleService#searchRoles
   */
  @Override
  public void searchRoles(PageableResultBuilder<RoleSummary> builder,
      SearchRolesRequest searchRolesRequest, PageRequest pageParameter) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    // 使用 Repository trait 中的搜索方法（租户隔离 + 数据库级分页）
    Page<RoleEntity> page =
        roleRepository.searchRoles(
            tenantId,
            searchRolesRequest.getKeyword(),
            searchRolesRequest.getStatus(),
            pageParameter
        );

    builder.setPageIndex(page.getNumber())
           .setPageSize(pageParameter.getSize())
           .setTotalCount(page.getTotalElements())
           .setTotalPage(page.getTotalPages())
           .setData(page.getContent().stream()
               .map(e -> new RoleSummary()
                   .setId(e.getId())
                   .setRoleCode(e.getRoleCode())
                   .setRoleName(e.getRoleName())
                   .setStatus(e.getStatus()))
               .collect(Collectors.toList()));
  }

  /**
   * Authorization:
   * <ul>
   * 	<li>Authorities: [ROLE_ASSIGN_PERMISSION]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/menus}
   * 	<p>{@code 为角色分配菜单（全量覆盖）}
   * @see RoleService#assignMenusToRole
   */
  @Override
  public void assignMenusToRole(SimpleResultBuilder<String> builder, Integer roleId,
      AssignMenusRequest assignMenusRequest) {
    // 验证角色存在（租户隔离）
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    RoleEntity role = roleRepository.findByIdAndTenantId(roleId.longValue(), tenantId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

    // 全量覆盖：先删除旧关联
    roleMenuRepository.deleteByRoleId(role.getId());

    // 批量插入新关联
    if (assignMenusRequest.getMenuIds() != null && !assignMenusRequest.getMenuIds().isEmpty()) {
      List<RoleMenuEntity> roleMenus = new ArrayList<>();
      for (Long menuId : assignMenusRequest.getMenuIds()) {
        RoleMenuEntity rm = new RoleMenuEntity()
            .setRoleId(role.getId())
            .setMenuId(menuId);
        roleMenus.add(rm);
      }
      roleMenuRepository.saveAll(roleMenus);
    }
  }

  /**
   * Authorization:
   * <ul>
   * 	<li>Authorities: [ROLE_ASSIGN_PERMISSION]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/menus/{menuId}}
   * 	<p>{@code 移除角色的某个菜单关联}
   * @see RoleService#removeMenuFromRole
   */
  @Override
  public void removeMenuFromRole(SimpleResultBuilder<String> builder, Integer roleId,
      Integer menuId) {
    // 验证角色存在（租户隔离）
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    roleRepository.findByIdAndTenantId(roleId.longValue(), tenantId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

    roleMenuRepository.deleteByRoleIdAndMenuId(roleId.longValue(), menuId.longValue());
  }

  /**
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/menus}
   * 	<p>{@code 获取角色关联的菜单列表}
   * @see RoleService#getRoleMenus
   */
  @Override
  public void getRoleMenus(SimpleResultBuilder<RoleMenuSummary> builder, Integer roleId) {
    // 验证角色存在（租户隔离）
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    roleRepository.findByIdAndTenantId(roleId.longValue(), tenantId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

    // 查找角色关联的菜单
    List<RoleMenuEntity> roleMenus = roleMenuRepository.findByRoleId(roleId.longValue());

    List<RoleMenuItem> menuItems = new ArrayList<>();
    if (!roleMenus.isEmpty()) {
      List<Long> menuIds = roleMenus.stream()
          .map(RoleMenuEntity::getMenuId)
          .collect(Collectors.toList());
      List<MenuEntity> menus = menuRepository.findAllById(menuIds);
      menuItems = menus.stream()
          .map(m -> new RoleMenuItem()
              .setId(m.getId())
              .setMenuCode(m.getMenuCode())
              .setMenuName(m.getMenuName())
              .setPermissionCode(m.getPermissionCode())
              .setMenuType(m.getMenuType() != null ? m.getMenuType().name() : null))
          .collect(Collectors.toList());
    }

    RoleMenuSummary summary = new RoleMenuSummary()
        .setRoleId(roleId.longValue())
        .setMenus(menuItems);
    builder.payload(summary);
  }
}