// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 创建部门请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "CreateDepartmentRequest",
    kind = Kind.MESSAGE
)
public class CreateDepartmentRequest {
  private static final long serialVersionUID = 0L;

  @Min(0)
  protected Long parentId;

  @NotEmpty
  @Size(
      max = 50
  )
  protected String deptCode;

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

  public Long getParentId() {
    return parentId;
  }

  public CreateDepartmentRequest setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getDeptCode() {
    return deptCode;
  }

  public CreateDepartmentRequest setDeptCode(String deptCode) {
    this.deptCode = deptCode;
    return this;
  }

  public String getDeptName() {
    return deptName;
  }

  public CreateDepartmentRequest setDeptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public CreateDepartmentRequest setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public String getManagerId() {
    return managerId;
  }

  public CreateDepartmentRequest setManagerId(String managerId) {
    this.managerId = managerId;
    return this;
  }

  public DeptStatusEnum getStatus() {
    return status;
  }

  public CreateDepartmentRequest setStatus(DeptStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CreateDepartmentRequest[" , "]")
    	.add("parentId=" + parentId)
    	.add("deptCode=" + deptCode)
    	.add("deptName=" + deptName)
    	.add("sortOrder=" + sortOrder)
    	.add("managerId=" + managerId)
    	.add("status=" + status)
        .toString();
  }
}
