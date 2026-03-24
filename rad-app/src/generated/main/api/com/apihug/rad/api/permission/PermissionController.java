// @formatter:off
package com.apihug.rad.api.permission;

import hope.common.api.Result;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/permission/api.proto",
    entity = "PermissionService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class PermissionController {
  public static final String _SVC_NAME = "com.apihug.rad.api.permission.PermissionService";

  protected final PermissionService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public PermissionController(PermissionService service) {
    this._service = service;
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/roles}
   * 	<p>{@code 获取用户的角色权限集合}
   */
  @GetMapping("/api/permissions/roles")
  public ResponseEntity<Result<List<PermissionInfo>>> getRolePermissions() {
    final SimpleResultBuilder<List<PermissionInfo>> builder = new SimpleResultBuilder<List<PermissionInfo>>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetRolePermissions, _ctx);
      _service.getRolePermissions(builder);
      ResponseEntity<Result<List<PermissionInfo>>> res = builder.done();
      aspect().after(Apis.GetRolePermissions, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetRolePermissions, exception);
      aspect().exception(Apis.GetRolePermissions, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/menus}
   * 	<p>{@code 获取用户的菜单权限集合}
   */
  @GetMapping("/api/permissions/menus")
  public ResponseEntity<Result<List<PermissionInfo>>> getMenuPermissions() {
    final SimpleResultBuilder<List<PermissionInfo>> builder = new SimpleResultBuilder<List<PermissionInfo>>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetMenuPermissions, _ctx);
      _service.getMenuPermissions(builder);
      ResponseEntity<Result<List<PermissionInfo>>> res = builder.done();
      aspect().after(Apis.GetMenuPermissions, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetMenuPermissions, exception);
      aspect().exception(Apis.GetMenuPermissions, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/all}
   * 	<p>{@code 获取用户的所有权限（聚合）}
   */
  @GetMapping("/api/permissions/all")
  public ResponseEntity<Result<List<PermissionInfo>>> getAllPermissions() {
    final SimpleResultBuilder<List<PermissionInfo>> builder = new SimpleResultBuilder<List<PermissionInfo>>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetAllPermissions, _ctx);
      _service.getAllPermissions(builder);
      ResponseEntity<Result<List<PermissionInfo>>> res = builder.done();
      aspect().after(Apis.GetAllPermissions, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetAllPermissions, exception);
      aspect().exception(Apis.GetAllPermissions, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext GetRolePermissions = new ServiceMethodContext("com.apihug.rad.api.permission.PermissionService", "GetRolePermissions", "/api/permissions/roles", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetMenuPermissions = new ServiceMethodContext("com.apihug.rad.api.permission.PermissionService", "GetMenuPermissions", "/api/permissions/menus", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetAllPermissions = new ServiceMethodContext("com.apihug.rad.api.permission.PermissionService", "GetAllPermissions", "/api/permissions/all", Priority.LOW, ServiceMethod.HttpMethod.GET);
  }
}
