// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerService",
    kind = Kind.RPC,
    line = 54,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface CustomerService {
  /**
   * @apiNote
   * 	<p>{@code /api/customer/info}
   * 	<p>{@code 查询当前客户信息}
   */
  default void info(SimpleResultBuilder<CustomerInfo> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/current-user-info}
   * 	<p>{@code 获取当前客户完整信息（包含权限、角色、部门）}
   */
  default void getCurrentUserInfo(SimpleResultBuilder<CurrentUserInfo> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/user-organizations}
   * 	<p>{@code 获取客户的所有组织列表}
   */
  default void getUserOrganizations(SimpleResultBuilder<OrganizationList> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/switch-organization}
   * 	<p>{@code 切换到指定组织}
   */
  default void switchOrganization(SimpleResultBuilder<LoginResponse> builder,
      SwitchOrganizationRequest switchOrganizationRequest) {
    builder.notImplemented();
  }
}
