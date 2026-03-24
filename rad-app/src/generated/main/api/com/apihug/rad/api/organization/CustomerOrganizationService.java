// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "CustomerOrganizationService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface CustomerOrganizationService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members}
   * 	<p>{@code 获取组织员工列表}
   */
  default void getOrganizationMembers(PageableResultBuilder<CustomerOrganizationSummary> builder,
      Integer organizationId, GetOrganizationMembersRequest getOrganizationMembersRequest,
      PageRequest pageParameter) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ADD]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members}
   * 	<p>{@code 添加员工到组织}
   */
  default void addMemberToOrganization(SimpleResultBuilder<String> builder, Integer organizationId,
      AddMemberRequest addMemberRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_REMOVE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}}
   * 	<p>{@code 从组织移除员工}
   */
  default void removeMemberFromOrganization(SimpleResultBuilder<String> builder,
      Integer organizationId, Integer customerId, RemoveMemberRequest removeMemberRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_LOCK]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock}
   * 	<p>{@code 锁定/解锁组织员工}
   */
  default void toggleMemberLock(SimpleResultBuilder<String> builder, Integer organizationId,
      Integer customerId, ToggleMemberLockRequest toggleMemberLockRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles}
   * 	<p>{@code 配置员工角色}
   */
  default void assignMemberRoles(SimpleResultBuilder<String> builder, Integer organizationId,
      Integer customerId, AssignMemberRolesRequest assignMemberRolesRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ASSIGN_MENU]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus}
   * 	<p>{@code 配置员工菜单权限}
   */
  default void assignMemberMenus(SimpleResultBuilder<String> builder, Integer organizationId,
      Integer customerId, AssignMemberMenusRequest assignMemberMenusRequest) {
    builder.notImplemented();
  }
}
