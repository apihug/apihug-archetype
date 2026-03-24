// @formatter:off
package com.apihug.rad.api.role;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 角色权限摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RolePermissionSummary",
    kind = Kind.MESSAGE
)
public class RolePermissionSummary {
  private static final long serialVersionUID = 0L;

  protected Long roleId;

  protected List<PermissionInfo> permissions;

  public Long getRoleId() {
    return roleId;
  }

  public RolePermissionSummary setRoleId(Long roleId) {
    this.roleId = roleId;
    return this;
  }

  public List<PermissionInfo> getPermissions() {
    return permissions;
  }

  public RolePermissionSummary setPermissions(List<PermissionInfo> permissions) {
    this.permissions = permissions;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RolePermissionSummary[" , "]")
    	.add("roleId=" + roleId)
    	.add("permissions=" + permissions)
        .toString();
  }
}
