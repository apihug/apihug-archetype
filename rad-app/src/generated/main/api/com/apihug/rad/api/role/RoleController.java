// @formatter:off
package com.apihug.rad.api.role;

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
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class RoleController {
  public static final String _SVC_NAME = "com.apihug.rad.api.role.RoleService";

  protected final RoleService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public RoleController(RoleService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles}
   * 	<p>{@code 创建新角色}
   */
  @PostMapping("/api/roles/roles")
  public ResponseEntity<Result<RoleSummary>> createRole(
      @RequestBody @Valid CreateRoleRequest createRoleRequest) {
    final SimpleResultBuilder<RoleSummary> builder = new SimpleResultBuilder<RoleSummary>();
    createRoleRequest = createRoleRequest == null ? new CreateRoleRequest(): createRoleRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "createRoleRequest", createRoleRequest);
    try {
      aspect().before(Apis.CreateRole, _ctx);
      _service.createRole(builder, createRoleRequest);
      ResponseEntity<Result<RoleSummary>> res = builder.done();
      aspect().after(Apis.CreateRole, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.CreateRole, exception);
      aspect().exception(Apis.CreateRole, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 获取角色详情}
   */
  @GetMapping("/api/roles/roles/{roleId}")
  public ResponseEntity<Result<RoleDetail>> getRole(
      @PathVariable(name = "roleId", required = true) Integer roleId) {
    final SimpleResultBuilder<RoleDetail> builder = new SimpleResultBuilder<RoleDetail>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "roleId", roleId);
    try {
      aspect().before(Apis.GetRole, _ctx);
      _service.getRole(builder, roleId);
      ResponseEntity<Result<RoleDetail>> res = builder.done();
      aspect().after(Apis.GetRole, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetRole, exception);
      aspect().exception(Apis.GetRole, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 更新角色信息}
   */
  @PutMapping("/api/roles/roles/{roleId}")
  public ResponseEntity<Result<String>> updateRole(
      @PathVariable(name = "roleId", required = true) Integer roleId,
      @RequestBody @Valid UpdateRoleRequest updateRoleRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updateRoleRequest = updateRoleRequest == null ? new UpdateRoleRequest(): updateRoleRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "roleId", roleId, "updateRoleRequest", updateRoleRequest);
    try {
      aspect().before(Apis.UpdateRole, _ctx);
      _service.updateRole(builder, roleId, updateRoleRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdateRole, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdateRole, exception);
      aspect().exception(Apis.UpdateRole, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 删除角色（软删除）}
   */
  @DeleteMapping("/api/roles/roles/{roleId}")
  public ResponseEntity<Result<String>> deleteRole(
      @PathVariable(name = "roleId", required = true) Integer roleId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "roleId", roleId);
    try {
      aspect().before(Apis.DeleteRole, _ctx);
      _service.deleteRole(builder, roleId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.DeleteRole, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.DeleteRole, exception);
      aspect().exception(Apis.DeleteRole, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/search}
   * 	<p>{@code 搜索角色（分页）}
   */
  @PostMapping("/api/roles/roles/search")
  public ResponseEntity<Result<Pageable<RoleSummary>>> searchRoles(
      @RequestBody @Valid SearchRolesRequest searchRolesRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<RoleSummary> builder = new PageableResultBuilder<RoleSummary>();
    searchRolesRequest = searchRolesRequest == null ? new SearchRolesRequest(): searchRolesRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "searchRolesRequest", searchRolesRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.SearchRoles, _ctx);
      _service.searchRoles(builder, searchRolesRequest, pageParameter);
      ResponseEntity<Result<Pageable<RoleSummary>>> res = builder.done();
      aspect().after(Apis.SearchRoles, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.SearchRoles, exception);
      aspect().exception(Apis.SearchRoles, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_ASSIGN_PERMISSION]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/permissions}
   * 	<p>{@code 为角色分配权限}
   */
  @PostMapping("/api/roles/roles/{roleId}/permissions")
  public ResponseEntity<Result<String>> assignPermissions(
      @PathVariable(name = "roleId", required = true) Integer roleId,
      @RequestBody @Valid AssignPermissionsRequest assignPermissionsRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    assignPermissionsRequest = assignPermissionsRequest == null ? new AssignPermissionsRequest(): assignPermissionsRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "roleId", roleId, "assignPermissionsRequest", assignPermissionsRequest);
    try {
      aspect().before(Apis.AssignPermissions, _ctx);
      _service.assignPermissions(builder, roleId, assignPermissionsRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AssignPermissions, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AssignPermissions, exception);
      aspect().exception(Apis.AssignPermissions, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_ASSIGN_PERMISSION]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/permissions/{permissionId}}
   * 	<p>{@code 移除角色权限}
   */
  @DeleteMapping("/api/roles/roles/{roleId}/permissions/{permissionId}")
  public ResponseEntity<Result<String>> removePermission(
      @PathVariable(name = "roleId", required = true) Integer roleId,
      @PathVariable(name = "permissionId", required = true) Integer permissionId,
      @ParameterObject RemovePermissionRequest removePermissionRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    removePermissionRequest = removePermissionRequest == null ? new RemovePermissionRequest(): removePermissionRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "roleId", roleId, "permissionId", permissionId, "removePermissionRequest", removePermissionRequest);
    try {
      aspect().before(Apis.RemovePermission, _ctx);
      _service.removePermission(builder, roleId, permissionId, removePermissionRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.RemovePermission, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.RemovePermission, exception);
      aspect().exception(Apis.RemovePermission, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/permissions}
   * 	<p>{@code 获取角色的权限列表}
   */
  @GetMapping("/api/roles/roles/{roleId}/permissions")
  public ResponseEntity<Result<RolePermissionSummary>> getRolePermissions(
      @PathVariable(name = "roleId", required = true) Integer roleId) {
    final SimpleResultBuilder<RolePermissionSummary> builder = new SimpleResultBuilder<RolePermissionSummary>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "roleId", roleId);
    try {
      aspect().before(Apis.GetRolePermissions, _ctx);
      _service.getRolePermissions(builder, roleId);
      ResponseEntity<Result<RolePermissionSummary>> res = builder.done();
      aspect().after(Apis.GetRolePermissions, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetRolePermissions, exception);
      aspect().exception(Apis.GetRolePermissions, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext CreateRole = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "CreateRole", "/api/roles/roles", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetRole = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "GetRole", "/api/roles/roles/{roleId}", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext UpdateRole = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "UpdateRole", "/api/roles/roles/{roleId}", Priority.LOW, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext DeleteRole = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "DeleteRole", "/api/roles/roles/{roleId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext SearchRoles = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "SearchRoles", "/api/roles/roles/search", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext AssignPermissions = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "AssignPermissions", "/api/roles/roles/{roleId}/permissions", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext RemovePermission = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "RemovePermission", "/api/roles/roles/{roleId}/permissions/{permissionId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext GetRolePermissions = new ServiceMethodContext("com.apihug.rad.api.role.RoleService", "GetRolePermissions", "/api/roles/roles/{roleId}/permissions", Priority.LOW, ServiceMethod.HttpMethod.GET);
  }
}
