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
    line = 54,
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
   * 	<p>{@code /api/customer/current-user-info}
   * 	<p>{@code 获取当前客户完整信息（包含权限、角色、部门）}
   */
  @GetMapping("/api/customer/current-user-info")
  public ResponseEntity<Result<CurrentUserInfo>> getCurrentUserInfo() {
    final SimpleResultBuilder<CurrentUserInfo> builder = new SimpleResultBuilder<CurrentUserInfo>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetCurrentUserInfo, _ctx);
      _service.getCurrentUserInfo(builder);
      ResponseEntity<Result<CurrentUserInfo>> res = builder.done();
      aspect().after(Apis.GetCurrentUserInfo, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetCurrentUserInfo, exception);
      aspect().exception(Apis.GetCurrentUserInfo, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/user-organizations}
   * 	<p>{@code 获取客户的所有组织列表}
   */
  @GetMapping("/api/customer/user-organizations")
  public ResponseEntity<Result<OrganizationList>> getUserOrganizations() {
    final SimpleResultBuilder<OrganizationList> builder = new SimpleResultBuilder<OrganizationList>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetUserOrganizations, _ctx);
      _service.getUserOrganizations(builder);
      ResponseEntity<Result<OrganizationList>> res = builder.done();
      aspect().after(Apis.GetUserOrganizations, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetUserOrganizations, exception);
      aspect().exception(Apis.GetUserOrganizations, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/customer/switch-organization}
   * 	<p>{@code 切换到指定组织}
   */
  @PostMapping("/api/customer/switch-organization")
  public ResponseEntity<Result<LoginResponse>> switchOrganization(
      @RequestBody @Valid SwitchOrganizationRequest switchOrganizationRequest) {
    final SimpleResultBuilder<LoginResponse> builder = new SimpleResultBuilder<LoginResponse>();
    switchOrganizationRequest = switchOrganizationRequest == null ? new SwitchOrganizationRequest(): switchOrganizationRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "switchOrganizationRequest", switchOrganizationRequest);
    try {
      aspect().before(Apis.SwitchOrganization, _ctx);
      _service.switchOrganization(builder, switchOrganizationRequest);
      ResponseEntity<Result<LoginResponse>> res = builder.done();
      aspect().after(Apis.SwitchOrganization, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.SwitchOrganization, exception);
      aspect().exception(Apis.SwitchOrganization, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext Info = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "Info", "/api/customer/info", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetCurrentUserInfo = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "GetCurrentUserInfo", "/api/customer/current-user-info", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetUserOrganizations = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "GetUserOrganizations", "/api/customer/user-organizations", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext SwitchOrganization = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerService", "SwitchOrganization", "/api/customer/switch-organization", Priority.LOW, ServiceMethod.HttpMethod.POST);
  }
}
