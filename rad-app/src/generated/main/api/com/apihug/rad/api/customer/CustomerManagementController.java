// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.api.PageRequest;
import hope.common.api.Pageable;
import hope.common.api.Result;
import hope.common.api.annotation.ParameterObject;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import hope.common.spring.helper.PageRequestGuardian;
import jakarta.validation.Valid;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerManagementService",
    kind = Kind.RPC,
    line = 125,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class CustomerManagementController {
  public static final String _SVC_NAME = "com.apihug.rad.api.customer.CustomerManagementService";

  protected final CustomerManagementService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public CustomerManagementController(CustomerManagementService service) {
    this._service = service;
  }

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
  @PostMapping("/api/customers/customers")
  public ResponseEntity<Result<CustomerSummary>> createCustomer(
      @RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
    final SimpleResultBuilder<CustomerSummary> builder = new SimpleResultBuilder<CustomerSummary>();
    createCustomerRequest = createCustomerRequest == null ? new CreateCustomerRequest(): createCustomerRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "createCustomerRequest", createCustomerRequest);
    try {
      aspect().before(Apis.CreateCustomer, _ctx);
      _service.createCustomer(builder, createCustomerRequest);
      ResponseEntity<Result<CustomerSummary>> res = builder.done();
      aspect().after(Apis.CreateCustomer, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.CreateCustomer, exception);
      aspect().exception(Apis.CreateCustomer, _ctx, exception);
      throw exception;
    }
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
  @GetMapping("/api/customers/customers/{customerId}")
  public ResponseEntity<Result<CustomerDetail>> getCustomer(
      @PathVariable(name = "customerId", required = true) Integer customerId) {
    final SimpleResultBuilder<CustomerDetail> builder = new SimpleResultBuilder<CustomerDetail>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "customerId", customerId);
    try {
      aspect().before(Apis.GetCustomer, _ctx);
      _service.getCustomer(builder, customerId);
      ResponseEntity<Result<CustomerDetail>> res = builder.done();
      aspect().after(Apis.GetCustomer, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetCustomer, exception);
      aspect().exception(Apis.GetCustomer, _ctx, exception);
      throw exception;
    }
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
  @PutMapping("/api/customers/customers/{customerId}")
  public ResponseEntity<Result<String>> updateCustomer(
      @PathVariable(name = "customerId", required = true) Integer customerId,
      @RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updateCustomerRequest = updateCustomerRequest == null ? new UpdateCustomerRequest(): updateCustomerRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "customerId", customerId, "updateCustomerRequest", updateCustomerRequest);
    try {
      aspect().before(Apis.UpdateCustomer, _ctx);
      _service.updateCustomer(builder, customerId, updateCustomerRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdateCustomer, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdateCustomer, exception);
      aspect().exception(Apis.UpdateCustomer, _ctx, exception);
      throw exception;
    }
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
  @DeleteMapping("/api/customers/customers/{customerId}")
  public ResponseEntity<Result<String>> deleteCustomer(
      @PathVariable(name = "customerId", required = true) Integer customerId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "customerId", customerId);
    try {
      aspect().before(Apis.DeleteCustomer, _ctx);
      _service.deleteCustomer(builder, customerId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.DeleteCustomer, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.DeleteCustomer, exception);
      aspect().exception(Apis.DeleteCustomer, _ctx, exception);
      throw exception;
    }
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
  @PostMapping("/api/customers/customers/search")
  public ResponseEntity<Result<Pageable<CustomerSummary>>> searchCustomers(
      @RequestBody @Valid SearchCustomersRequest searchCustomersRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<CustomerSummary> builder = new PageableResultBuilder<CustomerSummary>();
    searchCustomersRequest = searchCustomersRequest == null ? new SearchCustomersRequest(): searchCustomersRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "searchCustomersRequest", searchCustomersRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.SearchCustomers, _ctx);
      _service.searchCustomers(builder, searchCustomersRequest, pageParameter);
      ResponseEntity<Result<Pageable<CustomerSummary>>> res = builder.done();
      aspect().after(Apis.SearchCustomers, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.SearchCustomers, exception);
      aspect().exception(Apis.SearchCustomers, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customers/auth/forgot-password}
   * 	<p>{@code 申请找回密码（发送重置邮件）}
   */
  @PostMapping("/api/customers/auth/forgot-password")
  public ResponseEntity<Result<String>> forgotPassword(
      @RequestBody @Valid ForgotPasswordRequest forgotPasswordRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    forgotPasswordRequest = forgotPasswordRequest == null ? new ForgotPasswordRequest(): forgotPasswordRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "forgotPasswordRequest", forgotPasswordRequest);
    try {
      aspect().before(Apis.ForgotPassword, _ctx);
      _service.forgotPassword(builder, forgotPasswordRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.ForgotPassword, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.ForgotPassword, exception);
      aspect().exception(Apis.ForgotPassword, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customers/auth/reset-password}
   * 	<p>{@code 重置密码（使用 token）}
   */
  @PostMapping("/api/customers/auth/reset-password")
  public ResponseEntity<Result<String>> resetPassword(
      @RequestBody @Valid ResetPasswordRequest resetPasswordRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    resetPasswordRequest = resetPasswordRequest == null ? new ResetPasswordRequest(): resetPasswordRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "resetPasswordRequest", resetPasswordRequest);
    try {
      aspect().before(Apis.ResetPassword, _ctx);
      _service.resetPassword(builder, resetPasswordRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.ResetPassword, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.ResetPassword, exception);
      aspect().exception(Apis.ResetPassword, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext CreateCustomer = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "CreateCustomer", "/api/customers/customers", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetCustomer = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "GetCustomer", "/api/customers/customers/{customerId}", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext UpdateCustomer = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "UpdateCustomer", "/api/customers/customers/{customerId}", Priority.LOW, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext DeleteCustomer = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "DeleteCustomer", "/api/customers/customers/{customerId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext SearchCustomers = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "SearchCustomers", "/api/customers/customers/search", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext ForgotPassword = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "ForgotPassword", "/api/customers/auth/forgot-password", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext ResetPassword = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerManagementService", "ResetPassword", "/api/customers/auth/reset-password", Priority.LOW, ServiceMethod.HttpMethod.POST);
  }
}
