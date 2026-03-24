// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 部门摘要信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentSummary",
    kind = Kind.MESSAGE
)
public class DepartmentSummary {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  protected Long parentId;

  @NotEmpty
  protected String deptCode;

  @NotEmpty
  protected String deptName;

  protected DeptStatusEnum status;

  public Long getId() {
    return id;
  }

  public DepartmentSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public DepartmentSummary setParentId(Long parentId) {
    this.parentId = parentId;
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

  public DeptStatusEnum getStatus() {
    return status;
  }

  public DepartmentSummary setStatus(DeptStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "DepartmentSummary[" , "]")
    	.add("id=" + id)
    	.add("parentId=" + parentId)
    	.add("deptCode=" + deptCode)
    	.add("deptName=" + deptName)
    	.add("status=" + status)
        .toString();
  }
}
