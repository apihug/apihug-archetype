// @formatter:off
package com.apihug.rad.api.tenant;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 分配 RBAC 角色请求（全量覆盖）
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "AssignRolesRequest",
    kind = Kind.MESSAGE
)
public class AssignRolesRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  protected List<Long> roleIds;

  public List<Long> getRoleIds() {
    return roleIds;
  }

  public AssignRolesRequest setRoleIds(List<Long> roleIds) {
    this.roleIds = roleIds;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AssignRolesRequest[" , "]")
    	.add("roleIds=" + roleIds)
        .toString();
  }
}
