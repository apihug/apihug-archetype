// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 部门信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "DepartmentInfo",
    kind = Kind.MESSAGE
)
public class DepartmentInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String deptCode;

  @NotEmpty
  protected String deptName;

  protected Long parentId;

  public Long getId() {
    return id;
  }

  public DepartmentInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getDeptCode() {
    return deptCode;
  }

  public DepartmentInfo setDeptCode(String deptCode) {
    this.deptCode = deptCode;
    return this;
  }

  public String getDeptName() {
    return deptName;
  }

  public DepartmentInfo setDeptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public DepartmentInfo setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "DepartmentInfo[" , "]")
    	.add("id=" + id)
    	.add("deptCode=" + deptCode)
    	.add("deptName=" + deptName)
    	.add("parentId=" + parentId)
        .toString();
  }
}
