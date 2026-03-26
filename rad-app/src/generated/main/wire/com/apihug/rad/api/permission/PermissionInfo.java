// @formatter:off
package com.apihug.rad.api.permission;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 权限信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/permission/api.proto",
    entity = "PermissionInfo",
    kind = Kind.MESSAGE
)
public class PermissionInfo {
  private static final long serialVersionUID = 0L;

  protected String permissionCode;

  protected String permissionName;

  public String getPermissionCode() {
    return permissionCode;
  }

  public PermissionInfo setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
    return this;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public PermissionInfo setPermissionName(String permissionName) {
    this.permissionName = permissionName;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "PermissionInfo[" , "]")
    	.add("permissionCode=" + permissionCode)
    	.add("permissionName=" + permissionName)
        .toString();
  }
}
