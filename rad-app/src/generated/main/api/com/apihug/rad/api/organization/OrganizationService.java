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
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "OrganizationService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface OrganizationService {
  /**
   * @apiNote
   * 	<p>{@code /api/organizations/tree}
   * 	<p>{@code 获取组织树形结构}
   */
  default void getOrganizationTree(SimpleResultBuilder<OrganizationTreeNode> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/department-tree}
   * 	<p>{@code 获取当前组织的部门树形结构}
   */
  default void getDepartmentTree(SimpleResultBuilder<DepartmentTreeNode> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/user-departments}
   * 	<p>{@code 获取用户的部门列表}
   */
  default void getUserDepartments(SimpleResultBuilder<UserDepartmentList> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/my-organizations}
   * 	<p>{@code 获取当前用户所属的组织列表}
   */
  default void getUserOrganizations(PageableResultBuilder<OrganizationSummary> builder,
      PageRequest pageParameter) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/my-organizations/{organizationId}/default}
   * 	<p>{@code 设置用户的默认组织}
   */
  default void setDefaultOrganization(SimpleResultBuilder<String> builder, Integer organizationId,
      SetDefaultOrganizationRequest setDefaultOrganizationRequest) {
    builder.notImplemented();
  }
}
