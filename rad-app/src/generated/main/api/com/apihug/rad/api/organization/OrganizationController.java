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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "OrganizationService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class OrganizationController {
  public static final String _SVC_NAME = "com.apihug.rad.api.organization.OrganizationService";

  protected final OrganizationService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public OrganizationController(OrganizationService service) {
    this._service = service;
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/tree}
   * 	<p>{@code 获取组织树形结构}
   */
  @GetMapping("/api/organizations/tree")
  public ResponseEntity<Result<OrganizationTreeNode>> getOrganizationTree() {
    final SimpleResultBuilder<OrganizationTreeNode> builder = new SimpleResultBuilder<OrganizationTreeNode>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetOrganizationTree, _ctx);
      _service.getOrganizationTree(builder);
      ResponseEntity<Result<OrganizationTreeNode>> res = builder.done();
      aspect().after(Apis.GetOrganizationTree, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetOrganizationTree, exception);
      aspect().exception(Apis.GetOrganizationTree, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/department-tree}
   * 	<p>{@code 获取当前组织的部门树形结构}
   */
  @GetMapping("/api/organizations/department-tree")
  public ResponseEntity<Result<DepartmentTreeNode>> getDepartmentTree() {
    final SimpleResultBuilder<DepartmentTreeNode> builder = new SimpleResultBuilder<DepartmentTreeNode>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetDepartmentTree, _ctx);
      _service.getDepartmentTree(builder);
      ResponseEntity<Result<DepartmentTreeNode>> res = builder.done();
      aspect().after(Apis.GetDepartmentTree, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetDepartmentTree, exception);
      aspect().exception(Apis.GetDepartmentTree, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/user-departments}
   * 	<p>{@code 获取用户的部门列表}
   */
  @GetMapping("/api/organizations/user-departments")
  public ResponseEntity<Result<UserDepartmentList>> getUserDepartments() {
    final SimpleResultBuilder<UserDepartmentList> builder = new SimpleResultBuilder<UserDepartmentList>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetUserDepartments, _ctx);
      _service.getUserDepartments(builder);
      ResponseEntity<Result<UserDepartmentList>> res = builder.done();
      aspect().after(Apis.GetUserDepartments, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetUserDepartments, exception);
      aspect().exception(Apis.GetUserDepartments, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/my-organizations}
   * 	<p>{@code 获取当前用户所属的组织列表}
   */
  @GetMapping("/api/organizations/my-organizations")
  public ResponseEntity<Result<Pageable<OrganizationSummary>>> getUserOrganizations(
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<OrganizationSummary> builder = new PageableResultBuilder<OrganizationSummary>();
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "pageParameter", pageParameter);
    try {
      aspect().before(Apis.GetUserOrganizations, _ctx);
      _service.getUserOrganizations(builder, pageParameter);
      ResponseEntity<Result<Pageable<OrganizationSummary>>> res = builder.done();
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
   * 	<p>{@code /api/organizations/my-organizations/{organizationId}/default}
   * 	<p>{@code 设置用户的默认组织}
   */
  @PostMapping("/api/organizations/my-organizations/{organizationId}/default")
  public ResponseEntity<Result<String>> setDefaultOrganization(
      @PathVariable(name = "organizationId", required = true) Integer organizationId,
      @RequestBody @Valid SetDefaultOrganizationRequest setDefaultOrganizationRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    setDefaultOrganizationRequest = setDefaultOrganizationRequest == null ? new SetDefaultOrganizationRequest(): setDefaultOrganizationRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "organizationId", organizationId, "setDefaultOrganizationRequest", setDefaultOrganizationRequest);
    try {
      aspect().before(Apis.SetDefaultOrganization, _ctx);
      _service.setDefaultOrganization(builder, organizationId, setDefaultOrganizationRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.SetDefaultOrganization, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.SetDefaultOrganization, exception);
      aspect().exception(Apis.SetDefaultOrganization, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext GetOrganizationTree = new ServiceMethodContext("com.apihug.rad.api.organization.OrganizationService", "GetOrganizationTree", "/api/organizations/tree", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetDepartmentTree = new ServiceMethodContext("com.apihug.rad.api.organization.OrganizationService", "GetDepartmentTree", "/api/organizations/department-tree", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetUserDepartments = new ServiceMethodContext("com.apihug.rad.api.organization.OrganizationService", "GetUserDepartments", "/api/organizations/user-departments", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetUserOrganizations = new ServiceMethodContext("com.apihug.rad.api.organization.OrganizationService", "GetUserOrganizations", "/api/organizations/my-organizations", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext SetDefaultOrganization = new ServiceMethodContext("com.apihug.rad.api.organization.OrganizationService", "SetDefaultOrganization", "/api/organizations/my-organizations/{organizationId}/default", Priority.LOW, ServiceMethod.HttpMethod.POST);
  }
}
