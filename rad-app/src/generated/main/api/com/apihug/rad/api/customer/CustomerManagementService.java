// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerManagementService",
    kind = Kind.RPC,
    line = 125,
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
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT</li>
   * 	<li>Authorities: [CUSTOMER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customers/customers/{customerId}}
   * 	<p>{@code 获取客户详情}
   */
  default void getCustomer(SimpleResultBuilder<CustomerDetail> builder, Integer customerId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [CUSTOMER_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customers/customers/{customerId}}
   * 	<p>{@code 更新客户信息}
   */
  default void updateCustomer(SimpleResultBuilder<String> builder, Integer customerId,
      UpdateCustomerRequest updateCustomerRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [CUSTOMER_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customers/customers/{customerId}}
   * 	<p>{@code 删除客户（软删除）}
   */
  default void deleteCustomer(SimpleResultBuilder<String> builder, Integer customerId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [CUSTOMER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customers/customers/search}
   * 	<p>{@code 搜索客户（分页）}
   */
  default void searchCustomers(PageableResultBuilder<CustomerSummary> builder,
      SearchCustomersRequest searchCustomersRequest, PageRequest pageParameter) {
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
