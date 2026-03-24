// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 分配员工角色请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "AssignMemberRolesRequest",
    kind = Kind.MESSAGE
)
public class AssignMemberRolesRequest {
  private static final long serialVersionUID = 0L;

  protected List<Integer> roleIds;

  public List<Integer> getRoleIds() {
    return roleIds;
  }

  public AssignMemberRolesRequest setRoleIds(List<Integer> roleIds) {
    this.roleIds = roleIds;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AssignMemberRolesRequest[" , "]")
    	.add("roleIds=" + roleIds)
        .toString();
  }
}
