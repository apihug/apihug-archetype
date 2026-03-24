// @formatter:off
package com.apihug.rad.api.menu;

import hope.common.api.PageRequest;
import hope.common.api.Pageable;
import hope.common.api.Result;
import hope.common.api.annotation.ParameterObject;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import hope.common.spring.helper.PageRequestGuardian;
import jakarta.validation.Valid;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "MenuService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class MenuController {
  public static final String _SVC_NAME = "com.apihug.rad.api.menu.MenuService";

  protected final MenuService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public MenuController(MenuService service) {
    this._service = service;
  }

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
  @PostMapping("/api/menus/menus")
  public ResponseEntity<Result<MenuSummary>> createMenu(
      @RequestBody @Valid CreateMenuRequest createMenuRequest) {
    final SimpleResultBuilder<MenuSummary> builder = new SimpleResultBuilder<MenuSummary>();
    createMenuRequest = createMenuRequest == null ? new CreateMenuRequest(): createMenuRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "createMenuRequest", createMenuRequest);
    try {
      aspect().before(Apis.CreateMenu, _ctx);
      _service.createMenu(builder, createMenuRequest);
      ResponseEntity<Result<MenuSummary>> res = builder.done();
      aspect().after(Apis.CreateMenu, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.CreateMenu, exception);
      aspect().exception(Apis.CreateMenu, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/menus/menus/{menuId}}
   * 	<p>{@code 获取菜单详情}
   */
  @GetMapping("/api/menus/menus/{menuId}")
  public ResponseEntity<Result<MenuDetail>> getMenu(
      @PathVariable(name = "menuId", required = true) Integer menuId) {
    final SimpleResultBuilder<MenuDetail> builder = new SimpleResultBuilder<MenuDetail>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "menuId", menuId);
    try {
      aspect().before(Apis.GetMenu, _ctx);
      _service.getMenu(builder, menuId);
      ResponseEntity<Result<MenuDetail>> res = builder.done();
      aspect().after(Apis.GetMenu, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetMenu, exception);
      aspect().exception(Apis.GetMenu, _ctx, exception);
      throw exception;
    }
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
  @PutMapping("/api/menus/menus/{menuId}")
  public ResponseEntity<Result<String>> updateMenu(
      @PathVariable(name = "menuId", required = true) Integer menuId,
      @RequestBody @Valid UpdateMenuRequest updateMenuRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updateMenuRequest = updateMenuRequest == null ? new UpdateMenuRequest(): updateMenuRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "menuId", menuId, "updateMenuRequest", updateMenuRequest);
    try {
      aspect().before(Apis.UpdateMenu, _ctx);
      _service.updateMenu(builder, menuId, updateMenuRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdateMenu, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdateMenu, exception);
      aspect().exception(Apis.UpdateMenu, _ctx, exception);
      throw exception;
    }
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
  @DeleteMapping("/api/menus/menus/{menuId}")
  public ResponseEntity<Result<String>> deleteMenu(
      @PathVariable(name = "menuId", required = true) Integer menuId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "menuId", menuId);
    try {
      aspect().before(Apis.DeleteMenu, _ctx);
      _service.deleteMenu(builder, menuId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.DeleteMenu, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.DeleteMenu, exception);
      aspect().exception(Apis.DeleteMenu, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/menus/menus/tree}
   * 	<p>{@code 获取菜单树形结构}
   */
  @GetMapping("/api/menus/menus/tree")
  public ResponseEntity<Result<MenuTreeNode>> getMenuTree() {
    final SimpleResultBuilder<MenuTreeNode> builder = new SimpleResultBuilder<MenuTreeNode>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.GetMenuTree, _ctx);
      _service.getMenuTree(builder);
      ResponseEntity<Result<MenuTreeNode>> res = builder.done();
      aspect().after(Apis.GetMenuTree, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetMenuTree, exception);
      aspect().exception(Apis.GetMenuTree, _ctx, exception);
      throw exception;
    }
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
  @PostMapping("/api/menus/menus/search")
  public ResponseEntity<Result<Pageable<MenuSummary>>> searchMenus(
      @RequestBody @Valid SearchMenusRequest searchMenusRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<MenuSummary> builder = new PageableResultBuilder<MenuSummary>();
    searchMenusRequest = searchMenusRequest == null ? new SearchMenusRequest(): searchMenusRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "searchMenusRequest", searchMenusRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.SearchMenus, _ctx);
      _service.searchMenus(builder, searchMenusRequest, pageParameter);
      ResponseEntity<Result<Pageable<MenuSummary>>> res = builder.done();
      aspect().after(Apis.SearchMenus, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.SearchMenus, exception);
      aspect().exception(Apis.SearchMenus, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext CreateMenu = new ServiceMethodContext("com.apihug.rad.api.menu.MenuService", "CreateMenu", "/api/menus/menus", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext GetMenu = new ServiceMethodContext("com.apihug.rad.api.menu.MenuService", "GetMenu", "/api/menus/menus/{menuId}", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext UpdateMenu = new ServiceMethodContext("com.apihug.rad.api.menu.MenuService", "UpdateMenu", "/api/menus/menus/{menuId}", Priority.LOW, ServiceMethod.HttpMethod.PUT);

    ServiceMethodContext DeleteMenu = new ServiceMethodContext("com.apihug.rad.api.menu.MenuService", "DeleteMenu", "/api/menus/menus/{menuId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext GetMenuTree = new ServiceMethodContext("com.apihug.rad.api.menu.MenuService", "GetMenuTree", "/api/menus/menus/tree", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext SearchMenus = new ServiceMethodContext("com.apihug.rad.api.menu.MenuService", "SearchMenus", "/api/menus/menus/search", Priority.LOW, ServiceMethod.HttpMethod.POST);
  }
}
