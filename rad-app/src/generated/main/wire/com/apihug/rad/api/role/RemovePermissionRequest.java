// @formatter:off
package com.apihug.rad.api.role;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 移除权限请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RemovePermissionRequest",
    kind = Kind.MESSAGE
)
public class RemovePermissionRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long roleId;

  @Min(1)
  protected Long permissionId;

  public Long getRoleId() {
    return roleId;
  }

  public RemovePermissionRequest setRoleId(Long roleId) {
    this.roleId = roleId;
    return this;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public RemovePermissionRequest setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RemovePermissionRequest[" , "]")
    	.add("roleId=" + roleId)
    	.add("permissionId=" + permissionId)
        .toString();
  }
}
