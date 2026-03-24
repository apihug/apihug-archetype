// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新部门请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "UpdateDepartmentRequest",
    kind = Kind.MESSAGE
)
public class UpdateDepartmentRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String deptName;

  protected Integer sortOrder;

  @Size(
      max = 50
  )
  protected String managerId;

  protected DeptStatusEnum status;

  public String getDeptName() {
    return deptName;
  }

  public UpdateDepartmentRequest setDeptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public UpdateDepartmentRequest setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public String getManagerId() {
    return managerId;
  }

  public UpdateDepartmentRequest setManagerId(String managerId) {
    this.managerId = managerId;
    return this;
  }

  public DeptStatusEnum getStatus() {
    return status;
  }

  public UpdateDepartmentRequest setStatus(DeptStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdateDepartmentRequest[" , "]")
    	.add("deptName=" + deptName)
    	.add("sortOrder=" + sortOrder)
    	.add("managerId=" + managerId)
    	.add("status=" + status)
        .toString();
  }
}
