// @formatter:off
package com.apihug.rad.api.organization;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "CustomerOrganizationService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class CustomerOrganizationController {
  public static final String _SVC_NAME = "com.apihug.rad.api.organization.CustomerOrganizationService";

  protected final CustomerOrganizationService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public CustomerOrganizationController(CustomerOrganizationService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members}
   * 	<p>{@code 获取组织员工列表}
   */
  @GetMapping("/api/customer-organizations/organizations/{organizationId}/members")
  public ResponseEntity<Result<Pageable<CustomerOrganizationSummary>>> getOrganizationMembers(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @ParameterObject GetOrganizationMembersRequest getOrganizationMembersRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<CustomerOrganizationSummary> builder = new PageableResultBuilder<CustomerOrganizationSummary>();
    getOrganizationMembersRequest = getOrganizationMembersRequest == null ? new GetOrganizationMembersRequest(): getOrganizationMembersRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "getOrganizationMembersRequest", getOrganizationMembersRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.GetOrganizationMembers, _ctx);
      _service.getOrganizationMembers(builder, organizationId, getOrganizationMembersRequest, pageParameter);
      ResponseEntity<Result<Pageable<CustomerOrganizationSummary>>> res = builder.done();
      aspect().after(Apis.GetOrganizationMembers, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetOrganizationMembers, exception);
      aspect().exception(Apis.GetOrganizationMembers, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ADD]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members}
   * 	<p>{@code 添加员工到组织}
   */
  @PostMapping("/api/customer-organizations/organizations/{organizationId}/members")
  public ResponseEntity<Result<String>> addMemberToOrganization(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @RequestBody @Valid AddMemberRequest addMemberRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    addMemberRequest = addMemberRequest == null ? new AddMemberRequest(): addMemberRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "addMemberRequest", addMemberRequest);
    try {
      aspect().before(Apis.AddMemberToOrganization, _ctx);
      _service.addMemberToOrganization(builder, organizationId, addMemberRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AddMemberToOrganization, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AddMemberToOrganization, exception);
      aspect().exception(Apis.AddMemberToOrganization, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_REMOVE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}}
   * 	<p>{@code 从组织移除员工}
   */
  @DeleteMapping("/api/customer-organizations/organizations/{organizationId}/members/{customerId}")
  public ResponseEntity<Result<String>> removeMemberFromOrganization(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @PathVariable(name = "customerId", required = true) Integer customerId,
      @ParameterObject RemoveMemberRequest removeMemberRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    removeMemberRequest = removeMemberRequest == null ? new RemoveMemberRequest(): removeMemberRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "customerId", customerId, "removeMemberRequest", removeMemberRequest);
    try {
      aspect().before(Apis.RemoveMemberFromOrganization, _ctx);
      _service.removeMemberFromOrganization(builder, organizationId, customerId, removeMemberRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.RemoveMemberFromOrganization, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.RemoveMemberFromOrganization, exception);
      aspect().exception(Apis.RemoveMemberFromOrganization, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_LOCK]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock}
   * 	<p>{@code 锁定/解锁组织员工}
   */
  @PostMapping("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock")
  public ResponseEntity<Result<String>> toggleMemberLock(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @PathVariable(name = "customerId", required = true) Integer customerId,
      @RequestBody @Valid ToggleMemberLockRequest toggleMemberLockRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    toggleMemberLockRequest = toggleMemberLockRequest == null ? new ToggleMemberLockRequest(): toggleMemberLockRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "customerId", customerId, "toggleMemberLockRequest", toggleMemberLockRequest);
    try {
      aspect().before(Apis.ToggleMemberLock, _ctx);
      _service.toggleMemberLock(builder, organizationId, customerId, toggleMemberLockRequest);
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
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles}
   * 	<p>{@code 配置员工角色}
   */
  @PostMapping("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles")
  public ResponseEntity<Result<String>> assignMemberRoles(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @PathVariable(name = "customerId", required = true) Integer customerId,
      @RequestBody @Valid AssignMemberRolesRequest assignMemberRolesRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    assignMemberRolesRequest = assignMemberRolesRequest == null ? new AssignMemberRolesRequest(): assignMemberRolesRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "customerId", customerId, "assignMemberRolesRequest", assignMemberRolesRequest);
    try {
      aspect().before(Apis.AssignMemberRoles, _ctx);
      _service.assignMemberRoles(builder, organizationId, customerId, assignMemberRolesRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AssignMemberRoles, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AssignMemberRoles, exception);
      aspect().exception(Apis.AssignMemberRoles, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ASSIGN_MENU]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus}
   * 	<p>{@code 配置员工菜单权限}
   */
  @PostMapping("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus")
  public ResponseEntity<Result<String>> assignMemberMenus(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @PathVariable(name = "customerId", required = true) Integer customerId,
      @RequestBody @Valid AssignMemberMenusRequest assignMemberMenusRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    assignMemberMenusRequest = assignMemberMenusRequest == null ? new AssignMemberMenusRequest(): assignMemberMenusRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "customerId", customerId, "assignMemberMenusRequest", assignMemberMenusRequest);
    try {
      aspect().before(Apis.AssignMemberMenus, _ctx);
      _service.assignMemberMenus(builder, organizationId, customerId, assignMemberMenusRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AssignMemberMenus, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AssignMemberMenus, exception);
      aspect().exception(Apis.AssignMemberMenus, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext GetOrganizationMembers = new ServiceMethodContext("com.apihug.rad.api.organization.CustomerOrganizationService", "GetOrganizationMembers", "/api/customer-organizations/organizations/{organizationId}/members", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext AddMemberToOrganization = new ServiceMethodContext("com.apihug.rad.api.organization.CustomerOrganizationService", "AddMemberToOrganization", "/api/customer-organizations/organizations/{organizationId}/members", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext RemoveMemberFromOrganization = new ServiceMethodContext("com.apihug.rad.api.organization.CustomerOrganizationService", "RemoveMemberFromOrganization", "/api/customer-organizations/organizations/{organizationId}/members/{customerId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext ToggleMemberLock = new ServiceMethodContext("com.apihug.rad.api.organization.CustomerOrganizationService", "ToggleMemberLock", "/api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext AssignMemberRoles = new ServiceMethodContext("com.apihug.rad.api.organization.CustomerOrganizationService", "AssignMemberRoles", "/api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext AssignMemberMenus = new ServiceMethodContext("com.apihug.rad.api.organization.CustomerOrganizationService", "AssignMemberMenus", "/api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus", Priority.LOW, ServiceMethod.HttpMethod.POST);
  }
}
