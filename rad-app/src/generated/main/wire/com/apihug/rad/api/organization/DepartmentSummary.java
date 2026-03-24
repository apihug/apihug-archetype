// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 部门摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "DepartmentSummary",
    kind = Kind.MESSAGE
)
public class DepartmentSummary {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String deptCode;

  @NotEmpty
  protected String deptName;

  protected Long parentId;

  protected Integer sortOrder;

  protected String status;

  public Long getId() {
    return id;
  }

  public DepartmentSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public String getDeptCode() {
    return deptCode;
  }

  public DepartmentSummary setDeptCode(String deptCode) {
    this.deptCode = deptCode;
    return this;
  }

  public String getDeptName() {
    return deptName;
  }

  public DepartmentSummary setDeptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public DepartmentSummary setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public DepartmentSummary setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public DepartmentSummary setStatus(String status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "DepartmentSummary[" , "]")
    	.add("id=" + id)
    	.add("deptCode=" + deptCode)
    	.add("deptName=" + deptName)
    	.add("parentId=" + parentId)
    	.add("sortOrder=" + sortOrder)
    	.add("status=" + status)
        .toString();
  }
}
