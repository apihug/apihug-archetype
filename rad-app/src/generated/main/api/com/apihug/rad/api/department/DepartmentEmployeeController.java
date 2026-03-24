// @formatter:off
package com.apihug.rad.api.department;

import hope.common.api.Result;
import hope.common.api.annotation.ParameterObject;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "DepartmentEmployeeService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class DepartmentEmployeeController {
  public static final String _SVC_NAME = "com.apihug.rad.api.department.DepartmentEmployeeService";

  protected final DepartmentEmployeeService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public DepartmentEmployeeController(DepartmentEmployeeService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_ASSIGN_EMPLOYEE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/department-employees/department-employees}
   * 	<p>{@code 添加员工到部门}
   */
  @PostMapping("/api/department-employees/department-employees")
  public ResponseEntity<Result<String>> addEmployeeToDepartment(
      @RequestBody @Valid AddEmployeeRequest addEmployeeRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    addEmployeeRequest = addEmployeeRequest == null ? new AddEmployeeRequest(): addEmployeeRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "addEmployeeRequest", addEmployeeRequest);
    try {
      aspect().before(Apis.AddEmployeeToDepartment, _ctx);
      _service.addEmployeeToDepartment(builder, addEmployeeRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AddEmployeeToDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AddEmployeeToDepartment, exception);
      aspect().exception(Apis.AddEmployeeToDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_ASSIGN_EMPLOYEE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/department-employees/department-employees/{employeeId}}
   * 	<p>{@code 从部门移除员工}
   */
  @DeleteMapping("/api/department-employees/department-employees/{employeeId}")
  public ResponseEntity<Result<String>> removeEmployeeFromDepartment(
      @PathVariable(name = "employeeId", required = true) Integer employeeId,
      @ParameterObject RemoveEmployeeRequest removeEmployeeRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    removeEmployeeRequest = removeEmployeeRequest == null ? new RemoveEmployeeRequest(): removeEmployeeRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "employeeId", employeeId, "removeEmployeeRequest", removeEmployeeRequest);
    try {
      aspect().before(Apis.RemoveEmployeeFromDepartment, _ctx);
      _service.removeEmployeeFromDepartment(builder, employeeId, removeEmployeeRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.RemoveEmployeeFromDepartment, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.RemoveEmployeeFromDepartment, exception);
      aspect().exception(Apis.RemoveEmployeeFromDepartment, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_ASSIGN_EMPLOYEE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/department-employees/department-employees/transfer}
   * 	<p>{@code 员工调岗}
   */
  @PostMapping("/api/department-employees/department-employees/transfer")
  public ResponseEntity<Result<String>> transferEmployee(
      @RequestBody @Valid TransferEmployeeRequest transferEmployeeRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    transferEmployeeRequest = transferEmployeeRequest == null ? new TransferEmployeeRequest(): transferEmployeeRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "transferEmployeeRequest", transferEmployeeRequest);
    try {
      aspect().before(Apis.TransferEmployee, _ctx);
      _service.transferEmployee(builder, transferEmployeeRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.TransferEmployee, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.TransferEmployee, exception);
      aspect().exception(Apis.TransferEmployee, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/department-employees/departments/{departmentId}/employees}
   * 	<p>{@code 获取部门员工列表}
   */
  @GetMapping("/api/department-employees/departments/{departmentId}/employees")
  public ResponseEntity<Result<DepartmentEmployeeList>> getDepartmentEmployees(
      @PathVariable(name = "departmentId", required = true) Integer departmentId) {
    final SimpleResultBuilder<DepartmentEmployeeList> builder = new SimpleResultBuilder<DepartmentEmployeeList>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "departmentId", departmentId);
    try {
      aspect().before(Apis.GetDepartmentEmployees, _ctx);
      _service.getDepartmentEmployees(builder, departmentId);
      ResponseEntity<Result<DepartmentEmployeeList>> res = builder.done();
      aspect().after(Apis.GetDepartmentEmployees, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetDepartmentEmployees, exception);
      aspect().exception(Apis.GetDepartmentEmployees, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext AddEmployeeToDepartment = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentEmployeeService", "AddEmployeeToDepartment", "/api/department-employees/department-employees", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext RemoveEmployeeFromDepartment = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentEmployeeService", "RemoveEmployeeFromDepartment", "/api/department-employees/department-employees/{employeeId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext TransferEmployee = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentEmployeeService", "TransferEmployee", "/api/department-employees/department-employees/transfer", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetDepartmentEmployees = new ServiceMethodContext("com.apihug.rad.api.department.DepartmentEmployeeService", "GetDepartmentEmployees", "/api/department-employees/departments/{departmentId}/employees", Priority.LOW, ServiceMethod.HttpMethod.GET);
  }
}
