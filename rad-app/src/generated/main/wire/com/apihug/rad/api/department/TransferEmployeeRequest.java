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
 * 员工调岗请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "TransferEmployeeRequest",
    kind = Kind.MESSAGE
)
public class TransferEmployeeRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long employeeId;

  @Min(1)
  protected Long fromDepartmentId;

  @Min(1)
  protected Long toDepartmentId;

  @Size(
      max = 100
  )
  protected String position;

  public Long getEmployeeId() {
    return employeeId;
  }

  public TransferEmployeeRequest setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public Long getFromDepartmentId() {
    return fromDepartmentId;
  }

  public TransferEmployeeRequest setFromDepartmentId(Long fromDepartmentId) {
    this.fromDepartmentId = fromDepartmentId;
    return this;
  }

  public Long getToDepartmentId() {
    return toDepartmentId;
  }

  public TransferEmployeeRequest setToDepartmentId(Long toDepartmentId) {
    this.toDepartmentId = toDepartmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public TransferEmployeeRequest setPosition(String position) {
    this.position = position;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TransferEmployeeRequest[" , "]")
    	.add("employeeId=" + employeeId)
    	.add("fromDepartmentId=" + fromDepartmentId)
    	.add("toDepartmentId=" + toDepartmentId)
    	.add("position=" + position)
        .toString();
  }
}
