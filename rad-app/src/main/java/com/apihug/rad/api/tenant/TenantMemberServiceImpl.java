// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.tenant.MemberRoleEntity;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.MemberRoleEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantErrorEnum;
import com.apihug.rad.infra.tenant.TenantMemberErrorEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * Service layer implementation for tenant member management.
 * Orchestrates Customer, TenantMember, and Tenant domain operations.
 */
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "TenantMemberService",
    kind = Kind.RPC,
    line = 12,
    column = 1
)
@Template(type = Template.Type.SERVICE, usage = "Tenant member management", percentage = 90)
public class TenantMemberServiceImpl implements TenantMemberService {

  private final TenantMemberEntityRepository tenantMemberRepository;
  private final CustomerEntityRepository customerRepository;
  private final TenantEntityRepository tenantRepository;
  private final MemberRoleEntityRepository memberRoleRepository;
  private final RoleEntityRepository roleRepository;

  public TenantMemberServiceImpl(
      TenantMemberEntityRepository tenantMemberRepository,
      CustomerEntityRepository customerRepository,
      TenantEntityRepository tenantRepository,
      MemberRoleEntityRepository memberRoleRepository,
      RoleEntityRepository roleRepository) {
    this.tenantMemberRepository = tenantMemberRepository;
    this.customerRepository = customerRepository;
    this.tenantRepository = tenantRepository;
    this.memberRoleRepository = memberRoleRepository;
    this.roleRepository = roleRepository;
  }
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members}
   * 	<p>{@code 获取租户成员列表}
   * @see TenantMemberService#getTenantMembers
   */
  @Override
  public void getTenantMembers(PageableResultBuilder<TenantMemberSummary> builder, Integer tenantId,
      GetTenantMembersRequest getTenantMembersRequest, PageRequest pageParameter) {
    // 验证租户存在
    if (!tenantRepository.existsById(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build();
    }

    // 使用 trait 中的分页搜索方法
    Page<TenantMemberEntity> page = tenantMemberRepository.searchTenantMembers(
        tenantId.longValue(),
        getTenantMembersRequest.getStatus(),
        getTenantMembersRequest.getMemberRole(),
        pageParameter);

    // 批量加载客户信息，避免 N+1
    List<Long> customerIds = page.getContent().stream()
        .map(TenantMemberEntity::getCustomerId)
        .collect(Collectors.toList());
    Map<Long, CustomerEntity> customerMap = customerRepository.findAllById(customerIds).stream()
        .collect(Collectors.toMap(CustomerEntity::getId, c -> c));

    // 构建响应
    builder.setPageIndex(pageParameter.getPage())
           .setPageSize(pageParameter.getSize())
           .setTotalCount(page.getTotalElements())
           .setTotalPage(page.getTotalPages())
           .setData(page.getContent().stream()
               .map(m -> {
                 TenantMemberSummary summary = new TenantMemberSummary()
                     .setId(m.getId())
                     .setCustomerId(m.getCustomerId())
                     .setTenantId(m.getTenantId())
                     .setDepartmentId(m.getDepartmentId())
                     .setPosition(m.getPosition())
                     .setMemberType(m.getMemberType())
                     .setMemberRole(m.getMemberRole())
                     .setStatus(m.getStatus())
                     .setIsDefault(m.getIsDefault());
                 // 从批量加载的 Map 中获取客户信息
                 CustomerEntity c = customerMap.get(m.getCustomerId());
                 if (c != null) {
                   summary.setCustomerUsername(c.getUsername())
                       .setCustomerEmail(c.getEmail());
                 }
                 return summary;
               })
               .collect(Collectors.toList()));
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_ADD]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members}
   * 	<p>{@code 添加客户为租户成员}
   * @see TenantMemberService#addMemberToTenant
   */
  @Transactional
  @Override
  public void addMemberToTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      AddTenantMemberRequest addTenantMemberRequest) {
    Long tid = tenantId.longValue();
    Long customerId = addTenantMemberRequest.getCustomerId();

    // 验证租户存在
    if (!tenantRepository.existsById(tid)) {
      throw HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build();
    }

    // 验证客户存在
    if (!customerRepository.existsById(customerId)) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 验证成员关系不重复
    if (tenantMemberRepository.existsByCustomerIdAndTenantId(customerId, tid)) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_ALREADY_EXISTS).build();
    }

    // 创建成员关系
    TenantMemberEntity member = new TenantMemberEntity()
        .setCustomerId(customerId)
        .setTenantId(tid)
        .setIsDefault(addTenantMemberRequest.getIsDefault() != null
            ? addTenantMemberRequest.getIsDefault() : false)
        .setMemberType(addTenantMemberRequest.getMemberType() != null
            ? addTenantMemberRequest.getMemberType() : MemberTypeEnum.FULL_TIME)
        .setMemberRole(addTenantMemberRequest.getMemberRole() != null
            ? addTenantMemberRequest.getMemberRole() : MemberRoleEnum.MEMBER)
        .setStatus(TenantMemberStatusEnum.TM_ACTIVE)
        .setDepartmentId(addTenantMemberRequest.getDepartmentId())
        .setPosition(addTenantMemberRequest.getPosition());

    tenantMemberRepository.save(member);

    // 如果设为默认租户，更新客户的 defaultTenantId
    if (Boolean.TRUE.equals(addTenantMemberRequest.getIsDefault())) {
      customerRepository.findById(customerId)
          .ifPresent(c -> {
            c.setDefaultTenantId(tid);
            customerRepository.save(c);
          });
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_REMOVE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}}
   * 	<p>{@code 从租户移除成员}
   * @see TenantMemberService#removeMemberFromTenant
   */
  @Transactional
  @Override
  public void removeMemberFromTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId) {
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());

    // 验证成员属于该租户
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 设置为已退出状态（软删除）
    member.setStatus(TenantMemberStatusEnum.TM_INACTIVE);
    tenantMemberRepository.save(member);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_LOCK]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/toggle-lock}
   * 	<p>{@code 锁定/解锁租户成员}
   * @see TenantMemberService#toggleMemberLock
   */
  @Transactional
  @Override
  public void toggleMemberLock(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId) {
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());

    // 验证成员属于该租户
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 切换锁定状态
    if (member.getStatus() == TenantMemberStatusEnum.TM_LOCKED) {
      member.setStatus(TenantMemberStatusEnum.TM_ACTIVE);
    } else {
      member.setStatus(TenantMemberStatusEnum.TM_LOCKED);
    }

    tenantMemberRepository.save(member);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/role}
   * 	<p>{@code 更新成员在租户中的角色（拥有者/管理员/普通成员）}
   * @see TenantMemberService#updateMemberRole
   */
  @Transactional
  @Override
  public void updateMemberRole(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId, UpdateMemberRoleRequest updateMemberRoleRequest) {
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());

    // 验证成员属于该租户
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    member.setMemberRole(updateMemberRoleRequest.getMemberRole());
    tenantMemberRepository.save(member);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/department}
   * 	<p>{@code 将成员分配到指定部门}
   * @see TenantMemberService#assignMemberDepartment
   */
  @Transactional
  @Override
  public void assignMemberDepartment(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId, AssignMemberDepartmentRequest assignMemberDepartmentRequest) {
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());

    // 验证成员属于该租户
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    member.setDepartmentId(assignMemberDepartmentRequest.getDepartmentId());
    if (assignMemberDepartmentRequest.getPosition() != null) {
      member.setPosition(assignMemberDepartmentRequest.getPosition());
    }

    tenantMemberRepository.save(member);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/detail}
   * 	<p>{@code 获取租户成员详细信息（含客户账号信息和成员身份信息）}
   * @see TenantMemberService#getMemberDetail
   */
  @Override
  public void getMemberDetail(SimpleResultBuilder<TenantMemberDetail> builder, Integer tenantId,
      Integer memberId) {
    // 1. 查找成员关系
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());

    // 2. 验证成员属于该租户
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 3. 构建详情
    TenantMemberDetail detail = new TenantMemberDetail()
        .setId(member.getId())
        .setCustomerId(member.getCustomerId())
        .setTenantId(member.getTenantId())
        .setMemberType(member.getMemberType())
        .setMemberRole(member.getMemberRole())
        .setStatus(member.getStatus())
        .setDepartmentId(member.getDepartmentId())
        .setPosition(member.getPosition())
        .setIsDefault(member.getIsDefault())
        .setCreatedAt(member.getCreatedAt());

    // 4. 加载客户账号信息
    customerRepository.findById(member.getCustomerId())
        .ifPresent(c -> detail
            .setCustomerUsername(c.getUsername())
            .setCustomerEmail(c.getEmail())
            .setCustomerStatus(c.getStatus()));

    // 5. 加载租户信息
    tenantRepository.findById(member.getTenantId())
        .ifPresent(t -> detail
            .setTenantName(t.getTenantName())
            .setTenantCode(t.getTenantCode()));

    builder.payload(detail);
  }


/**
 * Authorization:
 *
 * <ul>
 * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
 * </ul>
 * @apiNote
 * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/roles}
 * 	<p>{@code 为租户成员分配 RBAC 角色（全量覆盖，替换已有角色）}
 * @see TenantMemberService#assignRolesToMember
 */
@Transactional
@Override
public void assignRolesToMember(SimpleResultBuilder<String> builder, Integer tenantId, Integer memberId, AssignRolesRequest assignRolesRequest) {
    // 验证成员存在且属于该租户
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 全量覆盖：先删除旧关联
    memberRoleRepository.deleteByMemberId(member.getId());

    // 批量插入新关联
    if (assignRolesRequest.getRoleIds() != null && !assignRolesRequest.getRoleIds().isEmpty()) {
      List<Long> roleIds = assignRolesRequest.getRoleIds();

      // 校验所有角色 ID 属于当前租户（防止跨租户角色分配）
      List<RoleEntity> roles = roleRepository.findAllById(roleIds);
      if (roles.size() != roleIds.size()
          || roles.stream().anyMatch(r -> !Long.valueOf(tenantId).equals(r.getTenantId()))) {
        throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
      }

      List<MemberRoleEntity> memberRoles = new ArrayList<>();
      for (Long roleId : roleIds) {
        MemberRoleEntity mr = new MemberRoleEntity()
            .setMemberId(member.getId())
            .setRoleId(roleId);
        memberRoles.add(mr);
      }
      memberRoleRepository.saveAll(memberRoles);
    }
}

	/**
 * Authorization:
 *
 * <ul>
 * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
 * </ul>
 * @apiNote
 * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/roles}
 * 	<p>{@code 获取租户成员的 RBAC 角色列表}
 * @see TenantMemberService#getMemberRoles
 */
@Override
public void getMemberRoles(SimpleResultBuilder<MemberRoleSummary> builder, Integer tenantId, Integer memberId) {
    // 验证成员存在且属于该租户
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 查找成员的角色关联
    List<MemberRoleEntity> memberRoles = memberRoleRepository.findByMemberId(member.getId());

    List<MemberRoleItem> roleItems = new ArrayList<>();
    if (!memberRoles.isEmpty()) {
      List<Long> roleIds = memberRoles.stream()
          .map(MemberRoleEntity::getRoleId)
          .collect(Collectors.toList());
      List<RoleEntity> roles = roleRepository.findAllById(roleIds);
      roleItems = roles.stream()
          .map(r -> new MemberRoleItem()
              .setId(r.getId())
              .setRoleCode(r.getRoleCode())
              .setRoleName(r.getRoleName()))
          .collect(Collectors.toList());
    }

    MemberRoleSummary summary = new MemberRoleSummary()
        .setMemberId(member.getId())
        .setRoles(roleItems);
    builder.payload(summary);
}

	/**
 * Authorization:
 *
 * <ul>
 * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
 * </ul>
 * @apiNote
 * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/roles/{roleId}}
 * 	<p>{@code 移除租户成员的某个 RBAC 角色}
 * @see TenantMemberService#removeRoleFromMember
 */
@Transactional
@Override
public void removeRoleFromMember(SimpleResultBuilder<String> builder, Integer tenantId, Integer memberId, Integer roleId) {
    // 验证成员存在且属于该租户
    TenantMemberEntity member = tenantMemberRepository.findById(memberId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build());
    if (!member.getTenantId().equals(tenantId.longValue())) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    memberRoleRepository.deleteByMemberIdAndRoleId(member.getId(), roleId.longValue());
}


}
