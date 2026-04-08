// @formatter:off
package com.apihug.rad.api.tenant;

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
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "TenantMemberService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class TenantMemberController {
  public static final String _SVC_NAME = "com.apihug.rad.api.tenant.TenantMemberService";

  protected final TenantMemberService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public TenantMemberController(TenantMemberService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members}
   * 	<p>{@code 获取租户成员列表}
   */
  @GetMapping("/api/tenants/tenants/{tenantId}/members")
  public ResponseEntity<Result<Pageable<TenantMemberSummary>>> getTenantMembers(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @ParameterObject GetTenantMembersRequest getTenantMembersRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<TenantMemberSummary> builder = new PageableResultBuilder<TenantMemberSummary>();
    getTenantMembersRequest = getTenantMembersRequest == null ? new GetTenantMembersRequest(): getTenantMembersRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "getTenantMembersRequest", getTenantMembersRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.GetTenantMembers, _ctx);
      _service.getTenantMembers(builder, tenantId, getTenantMembersRequest, pageParameter);
      ResponseEntity<Result<Pageable<TenantMemberSummary>>> res = builder.done();
      aspect().after(Apis.GetTenantMembers, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetTenantMembers, exception);
      aspect().exception(Apis.GetTenantMembers, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_ADD]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members}
   * 	<p>{@code 添加客户为租户成员}
   */
  @PostMapping("/api/tenants/tenants/{tenantId}/members")
  public ResponseEntity<Result<String>> addMemberToTenant(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @RequestBody @Valid AddTenantMemberRequest addTenantMemberRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    addTenantMemberRequest = addTenantMemberRequest == null ? new AddTenantMemberRequest(): addTenantMemberRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "addTenantMemberRequest", addTenantMemberRequest);
    try {
      aspect().before(Apis.AddMemberToTenant, _ctx);
      _service.addMemberToTenant(builder, tenantId, addTenantMemberRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AddMemberToTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AddMemberToTenant, exception);
      aspect().exception(Apis.AddMemberToTenant, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_REMOVE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}}
   * 	<p>{@code 从租户移除成员}
   */
  @DeleteMapping("/api/tenants/tenants/{tenantId}/members/{memberId}")
  public ResponseEntity<Result<String>> removeMemberFromTenant(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId);
    try {
      aspect().before(Apis.RemoveMemberFromTenant, _ctx);
      _service.removeMemberFromTenant(builder, tenantId, memberId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.RemoveMemberFromTenant, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.RemoveMemberFromTenant, exception);
      aspect().exception(Apis.RemoveMemberFromTenant, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_LOCK]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/toggle-lock}
   * 	<p>{@code 锁定/解锁租户成员}
   */
  @PostMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/toggle-lock")
  public ResponseEntity<Result<String>> toggleMemberLock(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId);
    try {
      aspect().before(Apis.ToggleMemberLock, _ctx);
      _service.toggleMemberLock(builder, tenantId, memberId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.ToggleMemberLock, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.ToggleMemberLock, exception);
      aspect().exception(Apis.ToggleMemberLock, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/role}
   * 	<p>{@code 更新成员在租户中的角色（拥有者/管理员/普通成员）}
   */
  @PutMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/role")
  public ResponseEntity<Result<String>> updateMemberRole(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId,
      @RequestBody @Valid UpdateMemberRoleRequest updateMemberRoleRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updateMemberRoleRequest = updateMemberRoleRequest == null ? new UpdateMemberRoleRequest(): updateMemberRoleRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId, "updateMemberRoleRequest", updateMemberRoleRequest);
    try {
      aspect().before(Apis.UpdateMemberRole, _ctx);
      _service.updateMemberRole(builder, tenantId, memberId, updateMemberRoleRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdateMemberRole, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdateMemberRole, exception);
      aspect().exception(Apis.UpdateMemberRole, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/department}
   * 	<p>{@code 将成员分配到指定部门}
   */
  @PutMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/department")
  public ResponseEntity<Result<String>> assignMemberDepartment(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId,
      @RequestBody @Valid AssignMemberDepartmentRequest assignMemberDepartmentRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    assignMemberDepartmentRequest = assignMemberDepartmentRequest == null ? new AssignMemberDepartmentRequest(): assignMemberDepartmentRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId, "assignMemberDepartmentRequest", assignMemberDepartmentRequest);
    try {
      aspect().before(Apis.AssignMemberDepartment, _ctx);
      _service.assignMemberDepartment(builder, tenantId, memberId, assignMemberDepartmentRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AssignMemberDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AssignMemberDepartment, exception);
      aspect().exception(Apis.AssignMemberDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/detail}
   * 	<p>{@code 获取租户成员详细信息（含客户账号信息和成员身份信息）}
   */
  @GetMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/detail")
  public ResponseEntity<Result<TenantMemberDetail>> getMemberDetail(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId) {
    final SimpleResultBuilder<TenantMemberDetail> builder = new SimpleResultBuilder<TenantMemberDetail>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId);
    try {
      aspect().before(Apis.GetMemberDetail, _ctx);
      _service.getMemberDetail(builder, tenantId, memberId);
      ResponseEntity<Result<TenantMemberDetail>> res = builder.done();
      aspect().after(Apis.GetMemberDetail, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetMemberDetail, exception);
      aspect().exception(Apis.GetMemberDetail, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/roles}
   * 	<p>{@code 为租户成员分配 RBAC 角色（全量覆盖，替换已有角色）}
   */
  @PostMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/roles")
  public ResponseEntity<Result<String>> assignRolesToMember(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId,
      @RequestBody @Valid AssignRolesRequest assignRolesRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    assignRolesRequest = assignRolesRequest == null ? new AssignRolesRequest(): assignRolesRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId, "assignRolesRequest", assignRolesRequest);
    try {
      aspect().before(Apis.AssignRolesToMember, _ctx);
      _service.assignRolesToMember(builder, tenantId, memberId, assignRolesRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AssignRolesToMember, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AssignRolesToMember, exception);
      aspect().exception(Apis.AssignRolesToMember, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/roles}
   * 	<p>{@code 获取租户成员的 RBAC 角色列表}
   */
  @GetMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/roles")
  public ResponseEntity<Result<MemberRoleSummary>> getMemberRoles(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId) {
    final SimpleResultBuilder<MemberRoleSummary> builder = new SimpleResultBuilder<MemberRoleSummary>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId);
    try {
      aspect().before(Apis.GetMemberRoles, _ctx);
      _service.getMemberRoles(builder, tenantId, memberId);
      ResponseEntity<Result<MemberRoleSummary>> res = builder.done();
      aspect().after(Apis.GetMemberRoles, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetMemberRoles, exception);
      aspect().exception(Apis.GetMemberRoles, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: TENANT_MANAGER</li>
   * 	<li>Authorities: [TENANT_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/members/{memberId}/roles/{roleId}}
   * 	<p>{@code 移除租户成员的某个 RBAC 角色}
   */
  @DeleteMapping("/api/tenants/tenants/{tenantId}/members/{memberId}/roles/{roleId}")
  public ResponseEntity<Result<String>> removeRoleFromMember(
      @PathVariable(name = "tenantId", required = true) Integer tenantId,
      @PathVariable(name = "memberId", required = true) Integer memberId,
      @PathVariable(name = "roleId", required = true) Integer roleId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "tenantId", tenantId, "memberId", memberId, "roleId", roleId);
    try {
      aspect().before(Apis.RemoveRoleFromMember, _ctx);
      _service.removeRoleFromMember(builder, tenantId, memberId, roleId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.RemoveRoleFromMember, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.RemoveRoleFromMember, exception);
      aspect().exception(Apis.RemoveRoleFromMember, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext GetTenantMembers = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "GetTenantMembers", "/api/tenants/tenants/{tenantId}/members", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext AddMemberToTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "AddMemberToTenant", "/api/tenants/tenants/{tenantId}/members", Priority.MIDDLE, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext RemoveMemberFromTenant = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "RemoveMemberFromTenant", "/api/tenants/tenants/{tenantId}/members/{memberId}", Priority.HIGH, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext ToggleMemberLock = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "ToggleMemberLock", "/api/tenants/tenants/{tenantId}/members/{memberId}/toggle-lock", Priority.MIDDLE, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext UpdateMemberRole = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "UpdateMemberRole", "/api/tenants/tenants/{tenantId}/members/{memberId}/role", Priority.MIDDLE, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext AssignMemberDepartment = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "AssignMemberDepartment", "/api/tenants/tenants/{tenantId}/members/{memberId}/department", Priority.MIDDLE, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext GetMemberDetail = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "GetMemberDetail", "/api/tenants/tenants/{tenantId}/members/{memberId}/detail", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext AssignRolesToMember = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "AssignRolesToMember", "/api/tenants/tenants/{tenantId}/members/{memberId}/roles", Priority.MIDDLE, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetMemberRoles = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "GetMemberRoles", "/api/tenants/tenants/{tenantId}/members/{memberId}/roles", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext RemoveRoleFromMember = new ServiceMethodContext("com.apihug.rad.api.tenant.TenantMemberService", "RemoveRoleFromMember", "/api/tenants/tenants/{tenantId}/members/{memberId}/roles/{roleId}", Priority.HIGH, ServiceMethod.HttpMethod.DELETE);
  }
}
