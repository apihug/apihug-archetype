// @formatter:off
package com.apihug.rad.api.department;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 移除员工请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "RemoveEmployeeRequest",
    kind = Kind.MESSAGE
)
public class RemoveEmployeeRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long employeeId;

  public Long getEmployeeId() {
    return employeeId;
  }

  public RemoveEmployeeRequest setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RemoveEmployeeRequest[" , "]")
    	.add("employeeId=" + employeeId)
        .toString();
  }
}
