// @formatter:off
package com.apihug.rad.api.role;

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
 * 分配权限请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "AssignPermissionsRequest",
    kind = Kind.MESSAGE
)
public class AssignPermissionsRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  protected List<Long> permissionIds;

  public List<Long> getPermissionIds() {
    return permissionIds;
  }

  public AssignPermissionsRequest setPermissionIds(List<Long> permissionIds) {
    this.permissionIds = permissionIds;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AssignPermissionsRequest[" , "]")
    	.add("permissionIds=" + permissionIds)
        .toString();
  }
}
