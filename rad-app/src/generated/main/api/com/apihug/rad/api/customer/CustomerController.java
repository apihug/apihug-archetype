// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.api.Result;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import jakarta.validation.Valid;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerService",
    kind = Kind.RPC,
    line = 56,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class CustomerController {
  public static final String _SVC_NAME = "com.apihug.rad.api.customer.CustomerService";

  protected final CustomerService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public CustomerController(CustomerService service) {
    this._service = service;
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/info}
   * 	<p>{@code 查询当前客户信息}
   */
  @GetMapping("/api/customer/info")
  public ResponseEntity<Result<CustomerInfo>> info() {
    final SimpleResultBuilder<CustomerInfo> builder = new SimpleResultBuilder<CustomerInfo>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Info, _ctx);
      _service.info(builder);
      ResponseEntity<Result<CustomerInfo>> res = builder.done();
      aspect().after(Apis.Info, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Info, exception);
      aspect().exception(Apis.Info, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/current-info}
   * 	<p>{@code 获取当前客户完整信息（包含权限、角色、部门、当前租户）}
   */
  @GetMapping("/api/customer/current-info")
  public ResponseEntity<Result<CurrentCustomerInfo>> getCurrentCustomerInfo() {
    final SimpleResultBuilder<CurrentCustomerInfo> builder = new SimpleResultBuilder<CurrentCustomerInfo>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetCurrentCustomerInfo, _ctx);
      _service.getCurrentCustomerInfo(builder);
      ResponseEntity<Result<CurrentCustomerInfo>> res = builder.done();
      aspect().after(Apis.GetCurrentCustomerInfo, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetCurrentCustomerInfo, exception);
      aspect().exception(Apis.GetCurrentCustomerInfo, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/tenants}
   * 	<p>{@code 获取客户加入的所有租户列表}
   */
  @GetMapping("/api/customer/tenants")
  public ResponseEntity<Result<TenantList>> getCustomerTenants() {
    final SimpleResultBuilder<TenantList> builder = new SimpleResultBuilder<TenantList>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetCustomerTenants, _ctx);
      _service.getCustomerTenants(builder);
      ResponseEntity<Result<TenantList>> res = builder.done();
      aspect().after(Apis.GetCustomerTenants, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetCustomerTenants, exception);
      aspect().exception(Apis.GetCustomerTenants, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/switch-tenant}
   * 	<p>{@code 切换到指定租户，重新签发 Token}
   */
  @PostMapping("/api/customer/switch-tenant")
  public ResponseEntity<Result<LoginResponse>> switchTenant(
      @RequestBody @Valid SwitchTenantRequest switchTenantRequest) {
    final SimpleResultBuilder<LoginResponse> builder = new SimpleResultBuilder<LoginResponse>();
    switchTenantRequest = switchTenantRequest == null ? new SwitchTenantRequest(): switchTenantRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "switchTenantRequest", switchTenantRequest);
    try {
      aspect().before(Apis.SwitchTenant, _ctx);
      _service.switchTenant(builder, switchTenantRequest);
      ResponseEntity<Result<LoginResponse>> res = builder.done();
      aspect().after(Apis.SwitchTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.SwitchTenant, exception);
      aspect().exception(Apis.SwitchTenant, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext Info = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "Info", "/api/customer/info", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetCurrentCustomerInfo = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "GetCurrentCustomerInfo", "/api/customer/current-info", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetCustomerTenants = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "GetCustomerTenants", "/api/customer/tenants", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext SwitchTenant = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "SwitchTenant", "/api/customer/switch-tenant", Priority.MIDDLE, ServiceMethod.HttpMethod.POST);
  }
}
