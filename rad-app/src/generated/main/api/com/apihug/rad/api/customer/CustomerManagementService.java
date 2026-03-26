// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerManagementService",
    kind = Kind.RPC,
    line = 122,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface CustomerManagementService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [CUSTOMER_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customers/customers}
   * 	<p>{@code 创建新客户}
   */
  default void createCustomer(SimpleResultBuilder<CustomerSummary> builder,
      CreateCustomerRequest createCustomerRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customers/auth/forgot-password}
   * 	<p>{@code 申请找回密码（发送重置邮件）}
   */
  default void forgotPassword(SimpleResultBuilder<String> builder,
      ForgotPasswordRequest forgotPasswordRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customers/auth/reset-password}
   * 	<p>{@code 重置密码（使用 token）}
   */
  default void resetPassword(SimpleResultBuilder<String> builder,
      ResetPasswordRequest resetPasswordRequest) {
    builder.notImplemented();
  }
}
