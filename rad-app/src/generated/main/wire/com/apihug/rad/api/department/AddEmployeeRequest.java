// @formatter:off
package com.apihug.rad.api.department;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 添加员工请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "AddEmployeeRequest",
    kind = Kind.MESSAGE
)
public class AddEmployeeRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long employeeId;

  @Min(1)
  protected Long departmentId;

  @Size(
      max = 100
  )
  protected String position;

  public Long getEmployeeId() {
    return employeeId;
  }

  public AddEmployeeRequest setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public AddEmployeeRequest setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public AddEmployeeRequest setPosition(String position) {
    this.position = position;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AddEmployeeRequest[" , "]")
    	.add("employeeId=" + employeeId)
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
        .toString();
  }
}
