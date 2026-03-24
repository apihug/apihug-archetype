// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 用户部门列表
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "UserDepartmentList",
    kind = Kind.MESSAGE
)
public class UserDepartmentList {
  private static final long serialVersionUID = 0L;

  protected List<DepartmentInfo> departments;

  protected Long primaryDepartmentId;

  public List<DepartmentInfo> getDepartments() {
    return departments;
  }

  public UserDepartmentList setDepartments(List<DepartmentInfo> departments) {
    this.departments = departments;
    return this;
  }

  public Long getPrimaryDepartmentId() {
    return primaryDepartmentId;
  }

  public UserDepartmentList setPrimaryDepartmentId(Long primaryDepartmentId) {
    this.primaryDepartmentId = primaryDepartmentId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UserDepartmentList[" , "]")
    	.add("departments=" + departments)
    	.add("primaryDepartmentId=" + primaryDepartmentId)
        .toString();
  }
}
