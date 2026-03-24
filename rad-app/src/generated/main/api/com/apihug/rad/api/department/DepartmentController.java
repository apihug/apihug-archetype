// @formatter:off
package com.apihug.rad.api.department;

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
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class DepartmentController {
  public static final String _SVC_NAME = "com.apihug.rad.api.department.DepartmentService";

  protected final DepartmentService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public DepartmentController(DepartmentService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/departments/departments}
   * 	<p>{@code 创建新部门}
   */
  @PostMapping("/api/departments/departments")
  public ResponseEntity<Result<DepartmentSummary>> createDepartment(
      @RequestBody @Valid CreateDepartmentRequest createDepartmentRequest) {
    final SimpleResultBuilder<DepartmentSummary> builder = new SimpleResultBuilder<DepartmentSummary>();
    createDepartmentRequest = createDepartmentRequest == null ? new CreateDepartmentRequest(): createDepartmentRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "createDepartmentRequest", createDepartmentRequest);
    try {
      aspect().before(Apis.CreateDepartment, _ctx);
      _service.createDepartment(builder, createDepartmentRequest);
      ResponseEntity<Result<DepartmentSummary>> res = builder.done();
      aspect().after(Apis.CreateDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.CreateDepartment, exception);
      aspect().exception(Apis.CreateDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/departments/departments/{departmentId}}
   * 	<p>{@code 获取部门详情}
   */
  @GetMapping("/api/departments/departments/{departmentId}")
  public ResponseEntity<Result<DepartmentDetail>> getDepartment(
      @PathVariable(name = "departmentId", required = true) Integer departmentId) {
    final SimpleResultBuilder<DepartmentDetail> builder = new SimpleResultBuilder<DepartmentDetail>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "departmentId", departmentId);
    try {
      aspect().before(Apis.GetDepartment, _ctx);
      _service.getDepartment(builder, departmentId);
      ResponseEntity<Result<DepartmentDetail>> res = builder.done();
      aspect().after(Apis.GetDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetDepartment, exception);
      aspect().exception(Apis.GetDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/departments/departments/{departmentId}}
   * 	<p>{@code 更新部门信息}
   */
  @PutMapping("/api/departments/departments/{departmentId}")
  public ResponseEntity<Result<String>> updateDepartment(
      @PathVariable(name = "departmentId", required = true) Integer departmentId,
      @RequestBody @Valid UpdateDepartmentRequest updateDepartmentRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updateDepartmentRequest = updateDepartmentRequest == null ? new UpdateDepartmentRequest(): updateDepartmentRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "departmentId", departmentId, "updateDepartmentRequest", updateDepartmentRequest);
    try {
      aspect().before(Apis.UpdateDepartment, _ctx);
      _service.updateDepartment(builder, departmentId, updateDepartmentRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdateDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdateDepartment, exception);
      aspect().exception(Apis.UpdateDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/departments/departments/{departmentId}}
   * 	<p>{@code 删除部门（软删除）}
   */
  @DeleteMapping("/api/departments/departments/{departmentId}")
  public ResponseEntity<Result<String>> deleteDepartment(
      @PathVariable(name = "departmentId", required = true) Integer departmentId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "departmentId", departmentId);
    try {
      aspect().before(Apis.DeleteDepartment, _ctx);
      _service.deleteDepartment(builder, departmentId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.DeleteDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.DeleteDepartment, exception);
      aspect().exception(Apis.DeleteDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/departments/departments/tree}
   * 	<p>{@code 获取部门树形结构}
   */
  @GetMapping("/api/departments/departments/tree")
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

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext CreateDepartment = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentService", "CreateDepartment", "/api/departments/departments", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetDepartment = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentService", "GetDepartment", "/api/departments/departments/{departmentId}", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext UpdateDepartment = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentService", "UpdateDepartment", "/api/departments/departments/{departmentId}", Priority.LOW, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext DeleteDepartment = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentService", "DeleteDepartment", "/api/departments/departments/{departmentId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext GetDepartmentTree = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentService", "GetDepartmentTree", "/api/departments/departments/tree", Priority.LOW, ServiceMethod.HttpMethod.GET);
  }
}
