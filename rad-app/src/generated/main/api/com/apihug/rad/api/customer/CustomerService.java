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
    line = 52,
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
   * 	<p>{@code /api/customer/current-info}
   * 	<p>{@code 获取当前客户完整信息（包含权限、角色、部门、当前租户）}
   */
  default void getCurrentCustomerInfo(SimpleResultBuilder<CurrentCustomerInfo> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/tenants}
   * 	<p>{@code 获取客户加入的所有租户列表}
   */
  default void getCustomerTenants(SimpleResultBuilder<TenantList> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/switch-tenant}
   * 	<p>{@code 切换到指定租户，重新签发 Token}
   */
  default void switchTenant(SimpleResultBuilder<LoginResponse> builder,
      SwitchTenantRequest switchTenantRequest) {
    builder.notImplemented();
  }
}
