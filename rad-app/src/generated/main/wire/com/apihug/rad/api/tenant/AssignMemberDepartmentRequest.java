// @formatter:off
package com.apihug.rad.api.tenant;

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
 * 分配成员部门请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "AssignMemberDepartmentRequest",
    kind = Kind.MESSAGE
)
public class AssignMemberDepartmentRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long departmentId;

  @Size(
      max = 100
  )
  protected String position;

  public Long getDepartmentId() {
    return departmentId;
  }

  public AssignMemberDepartmentRequest setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public AssignMemberDepartmentRequest setPosition(String position) {
    this.position = position;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AssignMemberDepartmentRequest[" , "]")
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
        .toString();
  }
}
