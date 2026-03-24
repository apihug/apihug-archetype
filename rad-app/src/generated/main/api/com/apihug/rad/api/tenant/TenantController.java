// @formatter:off
package com.apihug.rad.api.tenant;

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
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "TenantService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class TenantController {
  public static final String _SVC_NAME = "com.apihug.rad.api.tenant.TenantService";

  protected final TenantService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public TenantController(TenantService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants}
   * 	<p>{@code 创建新租户}
   */
  @PostMapping("/api/tenants/tenants")
  public ResponseEntity<Result<TenantSummary>> createTenant(
      @RequestBody @Valid CreateTenantRequest createTenantRequest) {
    final SimpleResultBuilder<TenantSummary> builder = new SimpleResultBuilder<TenantSummary>();
    createTenantRequest = createTenantRequest == null ? new CreateTenantRequest(): createTenantRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "createTenantRequest", createTenantRequest);
    try {
      aspect().before(Apis.CreateTenant, _ctx);
      _service.createTenant(builder, createTenantRequest);
      ResponseEntity<Result<TenantSummary>> res = builder.done();
      aspect().after(Apis.CreateTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.CreateTenant, exception);
      aspect().exception(Apis.CreateTenant, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}}
   * 	<p>{@code 获取租户详情}
   */
  @GetMapping("/api/tenants/tenants/{tenantId}")
  public ResponseEntity<Result<TenantDetail>> getTenant(
      @PathVariable(name = "tenantId", required = true) Integer tenantId) {
    final SimpleResultBuilder<TenantDetail> builder = new SimpleResultBuilder<TenantDetail>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId);
    try {
      aspect().before(Apis.GetTenant, _ctx);
      _service.getTenant(builder, tenantId);
      ResponseEntity<Result<TenantDetail>> res = builder.done();
      aspect().after(Apis.GetTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetTenant, exception);
      aspect().exception(Apis.GetTenant, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}}
   * 	<p>{@code 更新租户信息}
   */
  @PutMapping("/api/tenants/tenants/{tenantId}")
  public ResponseEntity<Result<String>> updateTenant(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @RequestBody @Valid UpdateTenantRequest updateTenantRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updateTenantRequest = updateTenantRequest == null ? new UpdateTenantRequest(): updateTenantRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "updateTenantRequest", updateTenantRequest);
    try {
      aspect().before(Apis.UpdateTenant, _ctx);
      _service.updateTenant(builder, tenantId, updateTenantRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdateTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdateTenant, exception);
      aspect().exception(Apis.UpdateTenant, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_DISABLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/disable}
   * 	<p>{@code 停用租户}
   */
  @DeleteMapping("/api/tenants/tenants/{tenantId}/disable")
  public ResponseEntity<Result<String>> disableTenant(
      @PathVariable(name = "tenantId", required = true) Integer tenantId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId);
    try {
      aspect().before(Apis.DisableTenant, _ctx);
      _service.disableTenant(builder, tenantId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.DisableTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.DisableTenant, exception);
      aspect().exception(Apis.DisableTenant, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_CONFIGURE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/configure}
   * 	<p>{@code 配置租户功能}
   */
  @PostMapping("/api/tenants/tenants/{tenantId}/configure")
  public ResponseEntity<Result<String>> configureTenant(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @RequestBody @Valid ConfigureTenantRequest configureTenantRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    configureTenantRequest = configureTenantRequest == null ? new ConfigureTenantRequest(): configureTenantRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "configureTenantRequest", configureTenantRequest);
    try {
      aspect().before(Apis.ConfigureTenant, _ctx);
      _service.configureTenant(builder, tenantId, configureTenantRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.ConfigureTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.ConfigureTenant, exception);
      aspect().exception(Apis.ConfigureTenant, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext CreateTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantService", "CreateTenant", "/api/tenants/tenants", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantService", "GetTenant", "/api/tenants/tenants/{tenantId}", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext UpdateTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantService", "UpdateTenant", "/api/tenants/tenants/{tenantId}", Priority.LOW, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext DisableTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantService", "DisableTenant", "/api/tenants/tenants/{tenantId}/disable", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext ConfigureTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantService", "ConfigureTenant", "/api/tenants/tenants/{tenantId}/configure", Priority.LOW, ServiceMethod.HttpMethod.POST);
  }
}
