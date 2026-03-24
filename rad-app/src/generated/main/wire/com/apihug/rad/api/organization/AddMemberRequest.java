// @formatter:off
package com.apihug.rad.api.organization;

import com.apihug.rad.infra.organization.EmployeeTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 添加员工到组织请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "AddMemberRequest",
    kind = Kind.MESSAGE
)
public class AddMemberRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Integer customerId;

  protected Long departmentId;

  @Size(
      max = 100
  )
  protected String position;

  protected EmployeeTypeEnum employeeType;

  protected Boolean isDefault;

  public Integer getCustomerId() {
    return customerId;
  }

  public AddMemberRequest setCustomerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public AddMemberRequest setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public AddMemberRequest setPosition(String position) {
    this.position = position;
    return this;
  }

  public EmployeeTypeEnum getEmployeeType() {
    return employeeType;
  }

  public AddMemberRequest setEmployeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public AddMemberRequest setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AddMemberRequest[" , "]")
    	.add("customerId=" + customerId)
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
    	.add("employeeType=" + employeeType)
    	.add("isDefault=" + isDefault)
        .toString();
  }
}
