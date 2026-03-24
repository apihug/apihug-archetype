// @formatter:off
package com.apihug.rad.api.department;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "DepartmentEmployeeService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface DepartmentEmployeeService {
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
  default void addEmployeeToDepartment(SimpleResultBuilder<String> builder,
      AddEmployeeRequest addEmployeeRequest) {
    builder.notImplemented();
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
  default void removeEmployeeFromDepartment(SimpleResultBuilder<String> builder, Integer employeeId,
      RemoveEmployeeRequest removeEmployeeRequest) {
    builder.notImplemented();
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
  default void transferEmployee(SimpleResultBuilder<String> builder,
      TransferEmployeeRequest transferEmployeeRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/department-employees/departments/{departmentId}/employees}
   * 	<p>{@code 获取部门员工列表}
   */
  default void getDepartmentEmployees(SimpleResultBuilder<DepartmentEmployeeList> builder,
      Integer departmentId) {
    builder.notImplemented();
  }
}
