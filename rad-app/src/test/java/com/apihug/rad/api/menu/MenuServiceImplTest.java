package com.apihug.rad.api.menu;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import com.apihug.rad.infra.security.RadCustomer;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.context.HopeContextHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
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
    private MockedStatic<HopeContextHolder> holderMock;
    private static final Long TEST_TENANT_ID = 1L;

    @BeforeEach
    void setUp() {
        holderMock = mockStatic(HopeContextHolder.class);
        RadCustomer mockCustomer = mock(RadCustomer.class);
        lenient().when(mockCustomer.getTenantId()).thenReturn(TEST_TENANT_ID);
        lenient().when(mockCustomer.getId()).thenReturn(100L);
        holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);
        menuService = new MenuServiceImpl(menuRepository);
    }

    @AfterEach
    void tearDown() {
        holderMock.close();
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

        when(menuRepository.existsByMenuCodeAndTenantId("system_user", TEST_TENANT_ID)).thenReturn(false);
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

        when(menuRepository.existsByMenuCodeAndTenantId("existing", TEST_TENANT_ID)).thenReturn(true);

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

        when(menuRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(Optional.of(entity));

        menuService.getMenu(detailBuilder, menuId);

        verify(detailBuilder).payload(any(MenuDetail.class));
    }

    @Test
    @DisplayName("获取菜单详情 - 未找到")
    void testGetMenu_NotFound() {
        Integer menuId = 999;
        when(menuRepository.findByIdAndTenantId(999L, TEST_TENANT_ID)).thenReturn(Optional.empty());

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

        when(menuRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(Optional.of(existing));
        when(menuRepository.save(any(MenuEntity.class))).thenReturn(existing);

        menuService.updateMenu(stringBuilder, menuId, request);

        verify(menuRepository).save(any(MenuEntity.class));
    }

    @Test
    @DisplayName("更新菜单 - 未找到")
    void testUpdateMenu_NotFound() {
        Integer menuId = 999;
        when(menuRepository.findByIdAndTenantId(999L, TEST_TENANT_ID)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            menuService.updateMenu(stringBuilder, menuId, new UpdateMenuRequest()));
    }

    @Test
    @DisplayName("删除菜单 - 成功")
    void testDeleteMenu_Success() {
        Integer menuId = 1;
        MenuEntity entity = new MenuEntity().setId(1L);

        when(menuRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(Optional.of(entity));
        when(menuRepository.findByParentIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(Arrays.asList());
        when(menuRepository.save(any(MenuEntity.class))).thenAnswer(invocation -> {
            MenuEntity e = invocation.getArgument(0);
            e.setDeleted(true);
            return e;
        });

        menuService.deleteMenu(stringBuilder, menuId);

        assertTrue(entity.isDeleted());
    }

    @Test
    @DisplayName("删除菜单 - 有子菜单")
    void testDeleteMenu_HasChildren() {
        Integer menuId = 1;
        MenuEntity entity = new MenuEntity().setId(1L);
        List<MenuEntity> children = Arrays.asList(new MenuEntity().setId(2L));

        when(menuRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(Optional.of(entity));
        when(menuRepository.findByParentIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(children);

        HopeErrorDetailException exception = assertThrows(HopeErrorDetailException.class, () -> 
            menuService.deleteMenu(stringBuilder, menuId));
        
        verify(menuRepository, never()).save(any());
        assertNotNull(exception);
    }

    @Test
    @DisplayName("删除菜单 - 未找到")
    void testDeleteMenu_NotFound() {
        Integer menuId = 999;
        when(menuRepository.findByIdAndTenantId(999L, TEST_TENANT_ID)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            menuService.deleteMenu(stringBuilder, menuId));
    }

    @Test
    @DisplayName("获取菜单树 - 成功")
    void testGetMenuTree_Success() {
        List<MenuEntity> allMenus = Arrays.asList(
            new MenuEntity().setId(1L).setParentId(0L).setMenuCode("system"),
            new MenuEntity().setId(2L).setParentId(0L).setMenuCode("business")
        );

        when(menuRepository.findByTenantIdAndDeletedFalse(TEST_TENANT_ID)).thenReturn(allMenus);

        menuService.getMenuTree(treeNodeBuilder);

        verify(menuRepository).findByTenantIdAndDeletedFalse(TEST_TENANT_ID);
        verify(treeNodeBuilder).payload(any(MenuTreeNode.class));
    }

    @Test
    @DisplayName("获取菜单树 - 空树")
    void testGetMenuTree_Empty() {
        when(menuRepository.findByTenantIdAndDeletedFalse(TEST_TENANT_ID)).thenReturn(Arrays.asList());

        menuService.getMenuTree(treeNodeBuilder);

        verify(menuRepository).findByTenantIdAndDeletedFalse(TEST_TENANT_ID);
        verify(treeNodeBuilder).payload(any(MenuTreeNode.class));
    }

    @Test
    @DisplayName("搜索菜单 - 服务存在")
    void testSearchMenus_ServiceExists() {
        assertNotNull(menuService);
    }
}
