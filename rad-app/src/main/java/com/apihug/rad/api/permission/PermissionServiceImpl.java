// @formatter:off
package com.apihug.rad.api.permission;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.SimpleResultBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Permission management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/permission/api.proto",
    entity = "PermissionService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
public class PermissionServiceImpl implements PermissionService {

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/roles}
   * 	<p>{@code 获取用户的角色权限集合}
   */
  @Override
  public void getRolePermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    // 待实现：从数据库查询用户的角色权限
    List<PermissionInfo> permissions = new ArrayList<>();
    permissions.add(new PermissionInfo()
        .setPermissionCode("user:view")
        .setPermissionName("查看用户"));
    permissions.add(new PermissionInfo()
        .setPermissionCode("user:create")
        .setPermissionName("创建用户"));

    builder.payload(permissions);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/menus}
   * 	<p>{@code 获取用户的菜单权限集合}
   */
  @Override
  public void getMenuPermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    // 待实现：从数据库查询用户的菜单权限
    List<PermissionInfo> permissions = new ArrayList<>();
    permissions.add(new PermissionInfo()
        .setPermissionCode("menu:system")
        .setPermissionName("系统管理"));
    permissions.add(new PermissionInfo()
        .setPermissionCode("menu:user")
        .setPermissionName("用户管理"));

    builder.payload(permissions);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/permissions/all}
   * 	<p>{@code 获取用户的所有权限（聚合）}
   */
  @Override
  public void getAllPermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    // 获取角色权限
    List<PermissionInfo> rolePermissions = new ArrayList<>();
    rolePermissions.add(new PermissionInfo()
        .setPermissionCode("user:view")
        .setPermissionName("查看用户"));
    rolePermissions.add(new PermissionInfo()
        .setPermissionCode("user:create")
        .setPermissionName("创建用户"));

    // 获取菜单权限
    List<PermissionInfo> menuPermissions = new ArrayList<>();
    menuPermissions.add(new PermissionInfo()
        .setPermissionCode("menu:system")
        .setPermissionName("系统管理"));
    menuPermissions.add(new PermissionInfo()
        .setPermissionCode("menu:user")
        .setPermissionName("用户管理"));

    // 聚合权限（去重）
    List<PermissionInfo> allPermissions = new ArrayList<>();
    allPermissions.addAll(rolePermissions);
    allPermissions.addAll(menuPermissions);

    builder.payload(allPermissions);
  }
}
