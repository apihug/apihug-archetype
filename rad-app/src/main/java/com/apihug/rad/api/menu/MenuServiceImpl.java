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
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * Service layer implementation for handling requests from the controller layer {@link com.apihug.rad.api.menu.MenuController}.
 */
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
    builder.done();
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
    builder.done();
  }

  /**
   * Get menu tree
   */
  @Override
  public void getMenuTree(SimpleResultBuilder<MenuTreeNode> builder) {
    // 获取所有根菜单（parent_id = 0）
    List<MenuEntity> rootMenus = menuRepository.findByParentId(0L);
    
    // 构建树形结构
    MenuTreeNode root = new MenuTreeNode();
    List<MenuTreeNode> children = new ArrayList<>();
    
    for (MenuEntity rootMenu : rootMenus) {
      MenuTreeNode node = buildMenuTreeNode(rootMenu);
      children.add(node);
    }
    
    root.setChildren(children);
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
    MenuTreeNode node = new MenuTreeNode();
    node.setMenu(buildMenuSummary(entity));
    
    // 递归构建子菜单
    List<MenuEntity> children = menuRepository.findByParentId(entity.getId());
    List<MenuTreeNode> childNodes = new ArrayList<>();
    for (MenuEntity child : children) {
      childNodes.add(buildMenuTreeNode(child));
    }
    node.setChildren(childNodes);
    
    return node;
  }
}
