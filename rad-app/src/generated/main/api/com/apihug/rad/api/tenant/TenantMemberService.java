// @formatter:off
package com.apihug.rad.api.tenant;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "TenantMemberService",
    kind = Kind.RPC,
    line = 13,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface TenantMemberService {
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
   */
  default void getTenantMembers(PageableResultBuilder<TenantMemberSummary> builder,
      Integer tenantId, GetTenantMembersRequest getTenantMembersRequest,
      PageRequest pageParameter) {
    builder.notImplemented();
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
   */
  default void addMemberToTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      AddTenantMemberRequest addTenantMemberRequest) {
    builder.notImplemented();
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
   */
  default void removeMemberFromTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId) {
    builder.notImplemented();
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
   */
  default void toggleMemberLock(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId) {
    builder.notImplemented();
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
   */
  default void updateMemberRole(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId, UpdateMemberRoleRequest updateMemberRoleRequest) {
    builder.notImplemented();
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
   */
  default void assignMemberDepartment(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId, AssignMemberDepartmentRequest assignMemberDepartmentRequest) {
    builder.notImplemented();
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
   */
  default void getMemberDetail(SimpleResultBuilder<TenantMemberDetail> builder, Integer tenantId,
      Integer memberId) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/set-default}
   * 	<p>{@code 将指定租户设为客户的默认租户}
   */
  default void setDefaultTenant(SimpleResultBuilder<String> builder, Integer tenantId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/roles}
   * 	<p>{@code 为租户成员分配 RBAC 角色（全量覆盖，替换已有角色）}
   */
  default void assignRolesToMember(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId, AssignRolesRequest assignRolesRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/roles}
   * 	<p>{@code 获取租户成员的 RBAC 角色列表}
   */
  default void getMemberRoles(SimpleResultBuilder<MemberRoleSummary> builder, Integer tenantId,
      Integer memberId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenant-members/tenants/{tenantId}/members/{memberId}/roles/{roleId}}
   * 	<p>{@code 移除租户成员的某个 RBAC 角色}
   */
  default void removeRoleFromMember(SimpleResultBuilder<String> builder, Integer tenantId,
      Integer memberId, Integer roleId) {
    builder.notImplemented();
  }
}
