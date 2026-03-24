// @formatter:off
package com.apihug.rad.api.department;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 部门员工列表
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "DepartmentEmployeeList",
    kind = Kind.MESSAGE
)
public class DepartmentEmployeeList {
  private static final long serialVersionUID = 0L;

  protected Long departmentId;

  protected List<EmployeeInfo> employees;

  public Long getDepartmentId() {
    return departmentId;
  }

  public DepartmentEmployeeList setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public List<EmployeeInfo> getEmployees() {
    return employees;
  }

  public DepartmentEmployeeList setEmployees(List<EmployeeInfo> employees) {
    this.employees = employees;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "DepartmentEmployeeList[" , "]")
    	.add("departmentId=" + departmentId)
    	.add("employees=" + employees)
        .toString();
  }
}
