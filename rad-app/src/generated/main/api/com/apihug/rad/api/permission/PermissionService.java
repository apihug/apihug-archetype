// @formatter:off
package com.apihug.rad.api.permission;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.util.List;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/permission/api.proto",
    entity = "PermissionService",
    kind = Kind.RPC,
    line = 9,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface PermissionService {
  /**
   * @apiNote
   * 	<p>{@code /api/permissions/roles}
   * 	<p>{@code 获取当前客户的角色权限集合}
   */
  default void getRolePermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/menus}
   * 	<p>{@code 获取当前客户的菜单权限集合}
   */
  default void getMenuPermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/all}
   * 	<p>{@code 获取当前客户的所有权限（聚合）}
   */
  default void getAllPermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    builder.notImplemented();
  }
}
