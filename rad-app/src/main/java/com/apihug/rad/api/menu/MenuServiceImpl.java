// @formatter:off
package com.apihug.rad.api.menu;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.infra.menu.MenuErrorEnum;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Platform menu management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "MenuService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
public class MenuServiceImpl implements MenuService {

  private final MenuEntityRepository menuRepository;

  public MenuServiceImpl(MenuEntityRepository menuRepository) {
    this.menuRepository = menuRepository;
  }

  /**
   * Authorization: ROLE_CREATE
   */
  @Override
  public void createMenu(SimpleResultBuilder<MenuSummary> builder,
      CreateMenuRequest createMenuRequest) {
    // 验证菜单代码唯一性
    if (menuRepository.existsByMenuCode(createMenuRequest.getMenuCode())) {
      throw HopeErrorDetailException.errorBuilder(MenuErrorEnum.MENU_CODE_EXISTS).build();
    }

    // 验证父菜单（如果 parent_id != 0）
    if (createMenuRequest.getParentId() != 0) {
      menuRepository.findById(createMenuRequest.getParentId())
          .orElseThrow(() -> HopeErrorDetailException.errorBuilder(MenuErrorEnum.INVALID_PARENT_MENU).build());
    }

    // 创建菜单实体
    MenuEntity entity = new MenuEntity()
        .setParentId(createMenuRequest.getParentId())
        .setMenuCode(createMenuRequest.getMenuCode())
        .setMenuName(createMenuRequest.getMenuName())
        .setPath(createMenuRequest.getPath())
        .setIcon(createMenuRequest.getIcon())
        .setSortOrder(createMenuRequest.getSortOrder())
        .setMenuType(createMenuRequest.getMenuType())
        .setPermissionCode(createMenuRequest.getPermissionCode())
        .setStatus(createMenuRequest.getStatus() != null
            ? createMenuRequest.getStatus()
            : MenuStatusEnum.ACTIVE);

    // 保存菜单
    MenuEntity saved = menuRepository.save(entity);

    // 返回摘要
    MenuSummary summary = new MenuSummary()
        .setId(saved.getId())
        .setParentId(saved.getParentId())
        .setMenuCode(saved.getMenuCode())
        .setMenuName(saved.getMenuName())
        .setPath(saved.getPath())
        .setMenuType(saved.getMenuType())
        .setStatus(saved.getStatus());

    builder.payload(summary);
  }

  /**
   * Get menu detail
   */
  @Override
  public void getMenu(SimpleResultBuilder<MenuDetail> builder, Integer menuId) {
    MenuEntity entity = menuRepository.findById(menuId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(MenuErrorEnum.MENU_NOT_FOUND).build());

    MenuDetail detail = buildMenuDetail(entity);
    builder.payload(detail);
  }

  /**
   * Update menu
   */
  @Override
  public void updateMenu(SimpleResultBuilder<String> builder, Integer menuId,
      UpdateMenuRequest updateMenuRequest) {
    MenuEntity entity = menuRepository.findById(menuId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(MenuErrorEnum.MENU_NOT_FOUND).build());

    // 更新字段
    if (updateMenuRequest.getMenuName() != null) {
      entity.setMenuName(updateMenuRequest.getMenuName());
    }
    if (updateMenuRequest.getPath() != null) {
      entity.setPath(updateMenuRequest.getPath());
    }
    if (updateMenuRequest.getIcon() != null) {
      entity.setIcon(updateMenuRequest.getIcon());
    }
    if (updateMenuRequest.getSortOrder() != null) {
      entity.setSortOrder(updateMenuRequest.getSortOrder());
    }
    if (updateMenuRequest.getMenuType() != null) {
      entity.setMenuType(updateMenuRequest.getMenuType());
    }
    if (updateMenuRequest.getPermissionCode() != null) {
      entity.setPermissionCode(updateMenuRequest.getPermissionCode());
    }
    if (updateMenuRequest.getStatus() != null) {
      entity.setStatus(updateMenuRequest.getStatus());
    }

    menuRepository.save(entity);
  }

  /**
   * Delete menu (soft delete)
   */
  @Override
  public void deleteMenu(SimpleResultBuilder<String> builder, Integer menuId) {
    MenuEntity entity = menuRepository.findById(menuId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(MenuErrorEnum.MENU_NOT_FOUND).build());

    // 检查是否有子菜单
    List<MenuEntity> children = menuRepository.findByParentId(entity.getId());
    if (!children.isEmpty()) {
      throw HopeErrorDetailException.errorBuilder(MenuErrorEnum.MENU_HAS_CHILDREN).build();
    }

    // 软删除
    entity.setDeleted(true)
        .setDeletedAt(LocalDateTime.now())
        .setDeletedBy(((Long) hope.common.spring.security.context.HopeContextHolder.customer().getId()));

    menuRepository.save(entity);
  }

  /**
   * Get menu tree
   */
  @Override
  public void getMenuTree(SimpleResultBuilder<MenuTreeNode> builder) {
    // 一次性加载所有菜单，避免递归 N+1，过滤软删除记录
    List<MenuEntity> allMenus = menuRepository.findAll().stream()
        .filter(m -> !Boolean.TRUE.equals(m.isDeleted()))
        .collect(Collectors.toList());

    // 按 parentId 分组
    Map<Long, List<MenuEntity>> childrenMap = allMenus.stream()
        .collect(Collectors.groupingBy(MenuEntity::getParentId));

    // 构建树形结构（根菜单 parentId = 0）
    MenuTreeNode root = new MenuTreeNode();
    root.setChildren(buildMenuChildren(childrenMap, 0L));
    builder.payload(root);
  }

  /**
   * Search menus
   */
  @Override
  public void searchMenus(PageableResultBuilder<MenuSummary> builder,
      SearchMenusRequest searchMenusRequest, PageRequest pageParameter) {
    Page<MenuEntity> page =
        menuRepository.searchMenus(
            searchMenusRequest.getKeyword(),
            searchMenusRequest.getMenuType(),
            searchMenusRequest.getStatus(),
            pageParameter
        );

    builder.setPageIndex(page.getNumber())
           .setPageSize(pageParameter.getSize())
           .setTotalCount(page.getTotalElements())
           .setTotalPage(page.getTotalPages())
           .setData(page.getContent().stream()
               .map(this::buildMenuSummary)
               .collect(Collectors.toList()));
  }

  // ========== Helper Methods ==========

  private MenuSummary buildMenuSummary(MenuEntity entity) {
    return new MenuSummary()
        .setId(entity.getId())
        .setParentId(entity.getParentId())
        .setMenuCode(entity.getMenuCode())
        .setMenuName(entity.getMenuName())
        .setPath(entity.getPath())
        .setMenuType(entity.getMenuType())
        .setStatus(entity.getStatus());
  }

  private MenuDetail buildMenuDetail(MenuEntity entity) {
    return new MenuDetail()
        .setId(entity.getId())
        .setParentId(entity.getParentId())
        .setMenuCode(entity.getMenuCode())
        .setMenuName(entity.getMenuName())
        .setPath(entity.getPath())
        .setIcon(entity.getIcon())
        .setSortOrder(entity.getSortOrder())
        .setMenuType(entity.getMenuType())
        .setPermissionCode(entity.getPermissionCode())
        .setStatus(entity.getStatus())
        .setCreatedAt(entity.getCreatedAt())
        .setUpdatedAt(entity.getUpdatedAt());
  }

  private MenuTreeNode buildMenuTreeNode(MenuEntity entity) {
    // 单独节点构建（已不再用于树构建，保留以备其他场景使用）
    MenuTreeNode node = new MenuTreeNode();
    node.setMenu(buildMenuSummary(entity));
    node.setChildren(List.of());
    return node;
  }

  /**
   * Build menu tree children from pre-loaded map
   */
  private List<MenuTreeNode> buildMenuChildren(
      Map<Long, List<MenuEntity>> childrenMap, Long parentId) {
    List<MenuEntity> children = childrenMap.getOrDefault(parentId, List.of());
    List<MenuTreeNode> nodes = new ArrayList<>();
    for (MenuEntity entity : children) {
      MenuTreeNode node = new MenuTreeNode();
      node.setMenu(buildMenuSummary(entity));
      node.setChildren(buildMenuChildren(childrenMap, entity.getId()));
      nodes.add(node);
    }
    return nodes;
  }
}
