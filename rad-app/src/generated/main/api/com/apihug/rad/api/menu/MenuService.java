// @formatter:off
package com.apihug.rad.api.menu;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "MenuService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface MenuService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [MENU_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/menus/menus}
   * 	<p>{@code 创建新菜单}
   */
  default void createMenu(SimpleResultBuilder<MenuSummary> builder,
      CreateMenuRequest createMenuRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/menus/menus/{menuId}}
   * 	<p>{@code 获取菜单详情}
   */
  default void getMenu(SimpleResultBuilder<MenuDetail> builder, Integer menuId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [MENU_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/menus/menus/{menuId}}
   * 	<p>{@code 更新菜单信息}
   */
  default void updateMenu(SimpleResultBuilder<String> builder, Integer menuId,
      UpdateMenuRequest updateMenuRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [MENU_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/menus/menus/{menuId}}
   * 	<p>{@code 删除菜单（软删除）}
   */
  default void deleteMenu(SimpleResultBuilder<String> builder, Integer menuId) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/menus/menus/tree}
   * 	<p>{@code 获取菜单树形结构}
   */
  default void getMenuTree(SimpleResultBuilder<MenuTreeNode> builder) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [MENU_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/menus/menus/search}
   * 	<p>{@code 搜索菜单（分页）}
   */
  default void searchMenus(PageableResultBuilder<MenuSummary> builder,
      SearchMenusRequest searchMenusRequest, PageRequest pageParameter) {
    builder.notImplemented();
  }
}
