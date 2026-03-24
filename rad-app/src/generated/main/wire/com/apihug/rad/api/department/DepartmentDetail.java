// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.infra.department.DeptStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 部门详情信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentDetail",
    kind = Kind.MESSAGE
)
public class DepartmentDetail {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  protected Long parentId;

  @NotEmpty
  protected String deptCode;

  @NotEmpty
  protected String deptName;

  protected Integer sortOrder;

  protected String managerId;

  protected DeptStatusEnum status;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  public Long getId() {
    return id;
  }

  public DepartmentDetail setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public DepartmentDetail setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getDeptCode() {
    return deptCode;
  }

  public DepartmentDetail setDeptCode(String deptCode) {
    this.deptCode = deptCode;
    return this;
  }

  public String getDeptName() {
    return deptName;
  }

  public DepartmentDetail setDeptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public DepartmentDetail setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public String getManagerId() {
    return managerId;
  }

  public DepartmentDetail setManagerId(String managerId) {
    this.managerId = managerId;
    return this;
  }

  public DeptStatusEnum getStatus() {
    return status;
  }

  public DepartmentDetail setStatus(DeptStatusEnum status) {
    this.status = status;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public DepartmentDetail setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "DepartmentDetail[" , "]")
    	.add("id=" + id)
    	.add("parentId=" + parentId)
    	.add("deptCode=" + deptCode)
    	.add("deptName=" + deptName)
    	.add("sortOrder=" + sortOrder)
    	.add("managerId=" + managerId)
    	.add("status=" + status)
    	.add("createdAt=" + createdAt)
        .toString();
  }
}
