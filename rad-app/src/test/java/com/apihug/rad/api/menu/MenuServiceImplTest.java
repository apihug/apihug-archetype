package com.apihug.rad.api.menu;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.SimpleResultBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("菜单管理 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class MenuServiceImplTest {

    @Mock
    private MenuEntityRepository menuRepository;

    @Mock
    private SimpleResultBuilder<MenuSummary> summaryBuilder;

    @Mock
    private SimpleResultBuilder<MenuDetail> detailBuilder;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    @Mock
    private SimpleResultBuilder<MenuTreeNode> treeNodeBuilder;

    private MenuServiceImpl menuService;

    @BeforeEach
    void setUp() {
        menuService = new MenuServiceImpl(menuRepository);
    }

    @Test
    @DisplayName("创建菜单 - 成功")
    void testCreateMenu_Success() {
        CreateMenuRequest request = new CreateMenuRequest()
            .setParentId(0L)
            .setMenuCode("system_user")
            .setMenuName("用户管理")
            .setPath("/system/user")
            .setIcon("lucide:users")
            .setSortOrder(10)
            .setMenuType(MenuTypeEnum.MENU)
            .setStatus(MenuStatusEnum.ACTIVE);

        MenuEntity savedEntity = new MenuEntity()
            .setId(1L)
            .setParentId(0L)
            .setMenuCode("system_user")
            .setMenuName("用户管理")
            .setStatus(MenuStatusEnum.ACTIVE);

        when(menuRepository.existsByMenuCode("system_user")).thenReturn(false);
        when(menuRepository.save(any(MenuEntity.class))).thenReturn(savedEntity);

        menuService.createMenu(summaryBuilder, request);

        ArgumentCaptor<MenuEntity> entityCaptor = ArgumentCaptor.forClass(MenuEntity.class);
        verify(menuRepository).save(entityCaptor.capture());
        MenuEntity captured = entityCaptor.getValue();
        assertEquals("system_user", captured.getMenuCode());
        verify(summaryBuilder).payload(any(MenuSummary.class));
    }

    @Test
    @DisplayName("创建菜单 - 代码已存在")
    void testCreateMenu_CodeExists() {
        CreateMenuRequest request = new CreateMenuRequest()
            .setMenuCode("existing")
            .setMenuName("现有菜单");

        when(menuRepository.existsByMenuCode("existing")).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () -> 
            menuService.createMenu(summaryBuilder, request));
        verify(menuRepository, never()).save(any());
    }

    @Test
    @DisplayName("获取菜单详情 - 成功")
    void testGetMenu_Success() {
        Integer menuId = 1;
        MenuEntity entity = new MenuEntity()
            .setId(1L)
            .setMenuCode("system_user")
            .setMenuName("用户管理");

        when(menuRepository.findById(1L)).thenReturn(Optional.of(entity));

        menuService.getMenu(detailBuilder, menuId);

        verify(detailBuilder).payload(any(MenuDetail.class));
    }

    @Test
    @DisplayName("获取菜单详情 - 未找到")
    void testGetMenu_NotFound() {
        Integer menuId = 999;
        when(menuRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            menuService.getMenu(detailBuilder, menuId));
    }

    @Test
    @DisplayName("更新菜单 - 成功")
    void testUpdateMenu_Success() {
        Integer menuId = 1;
        UpdateMenuRequest request = new UpdateMenuRequest()
            .setMenuName("新名称")
            .setSortOrder(20);

        MenuEntity existing = new MenuEntity().setId(1L);

        when(menuRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(menuRepository.save(any(MenuEntity.class))).thenReturn(existing);

        menuService.updateMenu(stringBuilder, menuId, request);

        verify(stringBuilder).done();
        verify(menuRepository).save(any(MenuEntity.class));
    }

    @Test
    @DisplayName("更新菜单 - 未找到")
    void testUpdateMenu_NotFound() {
        Integer menuId = 999;
        when(menuRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            menuService.updateMenu(stringBuilder, menuId, new UpdateMenuRequest()));
    }

    @Test
    @DisplayName("删除菜单 - 成功")
    void testDeleteMenu_Success() {
        Integer menuId = 1;
        MenuEntity entity = new MenuEntity().setId(1L);

        when(menuRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(menuRepository.findByParentId(1L)).thenReturn(Arrays.asList());
        when(menuRepository.save(any(MenuEntity.class))).thenAnswer(invocation -> {
            MenuEntity e = invocation.getArgument(0);
            e.setDeleted(true);
            return e;
        });

        menuService.deleteMenu(stringBuilder, menuId);

        verify(stringBuilder).done();
        assertTrue(entity.isDeleted());
    }

    @Test
    @DisplayName("删除菜单 - 有子菜单")
    void testDeleteMenu_HasChildren() {
        Integer menuId = 1;
        MenuEntity entity = new MenuEntity().setId(1L);
        List<MenuEntity> children = Arrays.asList(new MenuEntity().setId(2L));

        when(menuRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(menuRepository.findByParentId(1L)).thenReturn(children);

        HopeErrorDetailException exception = assertThrows(HopeErrorDetailException.class, () -> 
            menuService.deleteMenu(stringBuilder, menuId));
        
        verify(menuRepository, never()).save(any());
        assertNotNull(exception);
    }

    @Test
    @DisplayName("删除菜单 - 未找到")
    void testDeleteMenu_NotFound() {
        Integer menuId = 999;
        when(menuRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            menuService.deleteMenu(stringBuilder, menuId));
    }

    @Test
    @DisplayName("获取菜单树 - 成功")
    void testGetMenuTree_Success() {
        List<MenuEntity> rootMenus = Arrays.asList(
            new MenuEntity().setId(1L).setMenuCode("system"),
            new MenuEntity().setId(2L).setMenuCode("business")
        );

        when(menuRepository.findByParentId(0L)).thenReturn(rootMenus);
        when(menuRepository.findByParentId(1L)).thenReturn(Arrays.asList());
        when(menuRepository.findByParentId(2L)).thenReturn(Arrays.asList());

        menuService.getMenuTree(treeNodeBuilder);

        verify(menuRepository).findByParentId(0L);
        verify(treeNodeBuilder).payload(any(MenuTreeNode.class));
    }

    @Test
    @DisplayName("获取菜单树 - 空树")
    void testGetMenuTree_Empty() {
        when(menuRepository.findByParentId(0L)).thenReturn(Arrays.asList());

        menuService.getMenuTree(treeNodeBuilder);

        verify(menuRepository).findByParentId(0L);
        verify(treeNodeBuilder).payload(any(MenuTreeNode.class));
    }

    @Test
    @DisplayName("搜索菜单 - 服务存在")
    void testSearchMenus_ServiceExists() {
        assertNotNull(menuService);
    }
}
