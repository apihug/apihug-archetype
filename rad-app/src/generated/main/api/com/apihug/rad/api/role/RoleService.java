// @formatter:off
package com.apihug.rad.api.role;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface RoleService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles}
   * 	<p>{@code 创建新角色}
   */
  default void createRole(SimpleResultBuilder<RoleSummary> builder,
      CreateRoleRequest createRoleRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 获取角色详情}
   */
  default void getRole(SimpleResultBuilder<RoleDetail> builder, Integer roleId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 更新角色信息}
   */
  default void updateRole(SimpleResultBuilder<String> builder, Integer roleId,
      UpdateRoleRequest updateRoleRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}}
   * 	<p>{@code 删除角色（软删除）}
   */
  default void deleteRole(SimpleResultBuilder<String> builder, Integer roleId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/search}
   * 	<p>{@code 搜索角色（分页）}
   */
  default void searchRoles(PageableResultBuilder<RoleSummary> builder,
      SearchRolesRequest searchRolesRequest, PageRequest pageParameter) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_ASSIGN_PERMISSION]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/menus}
   * 	<p>{@code 为角色分配菜单（全量覆盖，菜单中 BUTTON 类型的 permission_code 即为权限）}
   */
  default void assignMenusToRole(SimpleResultBuilder<String> builder, Integer roleId,
      AssignMenusRequest assignMenusRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ROLE_ASSIGN_PERMISSION]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/menus/{menuId}}
   * 	<p>{@code 移除角色的某个菜单关联}
   */
  default void removeMenuFromRole(SimpleResultBuilder<String> builder, Integer roleId,
      Integer menuId) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/roles/roles/{roleId}/menus}
   * 	<p>{@code 获取角色关联的菜单列表（含权限代码）}
   */
  default void getRoleMenus(SimpleResultBuilder<RoleMenuSummary> builder, Integer roleId) {
    builder.notImplemented();
  }
}
