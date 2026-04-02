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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerAuthService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class CustomerAuthController {
  public static final String _SVC_NAME = "com.apihug.rad.api.customer.CustomerAuthService";

  protected final CustomerAuthService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public CustomerAuthController(CustomerAuthService service) {
    this._service = service;
  }

  /**
   * @apiNote
   * 	<p>{@code /api/auth/login}
   * 	<p>{@code 客户登录认证接口，验证用户名和密码，成功后返回访问令牌}
   */
  @PostMapping("/api/auth/login")
  public ResponseEntity<Result<LoginResponse>> login(
      @RequestBody @Valid LoginRequest loginRequest) {
    final SimpleResultBuilder<LoginResponse> builder = new SimpleResultBuilder<LoginResponse>();
    loginRequest = loginRequest == null ? new LoginRequest(): loginRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "loginRequest", loginRequest);
    try {
      aspect().before(Apis.Login, _ctx);
      _service.login(builder, loginRequest);
      ResponseEntity<Result<LoginResponse>> res = builder.done();
      aspect().after(Apis.Login, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Login, exception);
      aspect().exception(Apis.Login, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/auth/logout}
   * 	<p>{@code 客户退出登录接口，清除当前客户的会话信息}
   */
  @PostMapping("/api/auth/logout")
  public ResponseEntity<Result<String>> logout() {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Logout, _ctx);
      _service.logout(builder);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.Logout, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Logout, exception);
      aspect().exception(Apis.Logout, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext Login = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerAuthService", "Login", "/api/auth/login", Priority.CRITICAL, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext Logout = new ServiceMethodContext("com.apihug.rad.api.customer.CustomerAuthService", "Logout", "/api/auth/logout", Priority.CRITICAL, ServiceMethod.HttpMethod.POST);
  }
}
