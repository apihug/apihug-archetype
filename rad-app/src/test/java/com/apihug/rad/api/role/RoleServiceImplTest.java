package com.apihug.rad.api.role;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.RoleMenuEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.role.repository.RoleMenuEntityRepository;
import com.apihug.rad.infra.role.RoleErrorEnum;
import com.apihug.rad.infra.role.RoleStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.security.context.HopeContextHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleEntityRepository roleRepository;

    @Mock
    private RoleMenuEntityRepository roleMenuRepository;

    @Mock
    private MenuEntityRepository menuRepository;

    @Mock
    private hope.common.spring.SimpleResultBuilder<RoleSummary> summaryBuilder;

    @Mock
    private hope.common.spring.SimpleResultBuilder<RoleDetail> detailBuilder;

    @Mock
    private hope.common.spring.SimpleResultBuilder<String> stringBuilder;

    @Mock
    private hope.common.spring.SimpleResultBuilder<RoleMenuSummary> menuSummaryBuilder;

    private RoleServiceImpl roleService;
    private MockedStatic<HopeContextHolder> holderMock;
    private static final Long TEST_TENANT_ID = 1L;

    @BeforeEach
    void setUp() {
        holderMock = mockStatic(HopeContextHolder.class);
        RadCustomer mockCustomer = mock(RadCustomer.class);
        lenient().when(mockCustomer.getTenantId()).thenReturn(TEST_TENANT_ID);
        lenient().when(mockCustomer.getId()).thenReturn(100L);
        holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);
        roleService = new RoleServiceImpl(roleRepository, roleMenuRepository, menuRepository);
    }

    @AfterEach
    void tearDown() {
        holderMock.close();
    }

    @Test
    void testCreateRole_Success() {
        // Arrange
        CreateRoleRequest request = new CreateRoleRequest()
            .setRoleCode("admin")
            .setRoleName("管理员")
            .setDescription("系统管理员")
            .setStatus(RoleStatusEnum.ACTIVE);

        RoleEntity savedEntity = new RoleEntity()
            .setId(1L)
            .setRoleCode("admin")
            .setRoleName("管理员")
            .setStatus(RoleStatusEnum.ACTIVE);

        when(roleRepository.existsByRoleCodeAndTenantId("admin", TEST_TENANT_ID)).thenReturn(false);
        when(roleRepository.save(any(RoleEntity.class))).thenReturn(savedEntity);

        // Act
        roleService.createRole(summaryBuilder, request);

        // Assert
        verify(summaryBuilder).payload(any(RoleSummary.class));
        verify(roleRepository).save(any(RoleEntity.class));
    }

    @Test
    void testCreateRole_CodeExists() {
        // Arrange
        CreateRoleRequest request = new CreateRoleRequest()
            .setRoleCode("existing")
            .setRoleName("现有角色");

        when(roleRepository.existsByRoleCodeAndTenantId("existing", TEST_TENANT_ID)).thenReturn(true);

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.createRole(summaryBuilder, request);
        });
        verify(roleRepository, never()).save(any());
    }

    @Test
    void testGetRole_Success() {
        // Arrange
        Integer roleId = 1;
        RoleEntity entity = new RoleEntity()
            .setId(1L)
            .setRoleCode("admin")
            .setRoleName("管理员");

        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(entity));

        // Act
        roleService.getRole(detailBuilder, roleId);

        // Assert
        verify(detailBuilder).payload(any(RoleDetail.class));
    }

    @Test
    void testGetRole_NotFound() {
        // Arrange
        Integer roleId = 999;
        when(roleRepository.findByIdAndTenantId(999L, TEST_TENANT_ID)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.getRole(detailBuilder, roleId);
        });
    }

    @Test
    void testUpdateRole_Success() {
        // Arrange
        Integer roleId = 1;
        UpdateRoleRequest request = new UpdateRoleRequest()
            .setRoleName("新名称")
            .setStatus(RoleStatusEnum.INACTIVE);

        RoleEntity existing = new RoleEntity()
            .setId(1L)
            .setRoleCode("admin")
            .setRoleName("管理员");

        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(existing));
        when(roleRepository.save(any(RoleEntity.class))).thenReturn(existing);

        // Act
        roleService.updateRole(stringBuilder, roleId, request);

        // Assert
        verify(roleRepository).save(any(RoleEntity.class));
    }

    @Test
    void testUpdateRole_NotFound() {
        // Arrange
        Integer roleId = 999;
        UpdateRoleRequest request = new UpdateRoleRequest();

        when(roleRepository.findByIdAndTenantId(999L, TEST_TENANT_ID)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.updateRole(stringBuilder, roleId, request);
        });
    }

    /*@Test
    void testDeleteRole_Success() {
        // Arrange
        Integer roleId = 1;
        RoleEntity entity = new RoleEntity()
            .setId(1L)
            .setRoleCode("admin");

        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(entity));
        when(roleRepository.save(any(RoleEntity.class))).thenReturn(entity);

        // Act
        roleService.deleteRole(stringBuilder, roleId);

        // Assert
        verify(roleRepository).save(any(RoleEntity.class));
        assertTrue(entity.isDeleted());
    }*/

    @Test
    void testDeleteRole_NotFound() {
        // Arrange
        Integer roleId = 999;
        when(roleRepository.findByIdAndTenantId(999L, TEST_TENANT_ID)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.deleteRole(stringBuilder, roleId);
        });
    }

    @Test
    void testAssignMenusToRole_Success() {
        // Arrange
        Integer roleId = 1;
        AssignMenusRequest request = new AssignMenusRequest()
            .setMenuIds(java.util.Arrays.asList(1L, 2L));

        RoleEntity role = new RoleEntity().setId(1L).setRoleCode("admin");
        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(role));

        // Mock cross-tenant validation: both menus belong to TEST_TENANT_ID
        MenuEntity menu1 = new MenuEntity().setId(1L).setTenantId(TEST_TENANT_ID);
        MenuEntity menu2 = new MenuEntity().setId(2L).setTenantId(TEST_TENANT_ID);
        when(menuRepository.findAllById(java.util.Arrays.asList(1L, 2L)))
            .thenReturn(java.util.Arrays.asList(menu1, menu2));

        // Act
        roleService.assignMenusToRole(stringBuilder, roleId, request);

        // Assert
        verify(roleMenuRepository).deleteByRoleId(1L);
        verify(roleMenuRepository).saveAll(any());
    }

    @Test
    void testAssignMenusToRole_CrossTenantRejected() {
        // Arrange
        Integer roleId = 1;
        AssignMenusRequest request = new AssignMenusRequest()
            .setMenuIds(java.util.Arrays.asList(1L, 2L));

        RoleEntity role = new RoleEntity().setId(1L).setRoleCode("admin");
        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(role));

        // menuId=2 belongs to another tenant
        MenuEntity menu1 = new MenuEntity().setId(1L).setTenantId(TEST_TENANT_ID);
        MenuEntity menu2 = new MenuEntity().setId(2L).setTenantId(999L);
        when(menuRepository.findAllById(java.util.Arrays.asList(1L, 2L)))
            .thenReturn(java.util.Arrays.asList(menu1, menu2));

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.assignMenusToRole(stringBuilder, roleId, request);
        });
        verify(roleMenuRepository, never()).saveAll(any());
    }

    @Test
    void testRemoveMenuFromRole_Success() {
        // Arrange
        Integer roleId = 1;
        Integer menuId = 1;

        RoleEntity role = new RoleEntity().setId(1L).setRoleCode("admin");
        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(role));

        // Act
        roleService.removeMenuFromRole(stringBuilder, roleId, menuId);

        // Assert
        verify(roleMenuRepository).deleteByRoleIdAndMenuId(1L, 1L);
    }

    @Test
    void testGetRoleMenus_Success() {
        // Arrange
        Integer roleId = 1;

        RoleEntity role = new RoleEntity().setId(1L).setRoleCode("admin");
        when(roleRepository.findByIdAndTenantId(1L, TEST_TENANT_ID)).thenReturn(java.util.Optional.of(role));

        RoleMenuEntity rm = new RoleMenuEntity().setRoleId(1L).setMenuId(10L);
        when(roleMenuRepository.findByRoleId(1L)).thenReturn(java.util.Arrays.asList(rm));

        MenuEntity menu = new MenuEntity().setId(10L).setMenuCode("sys:user").setMenuName("用户管理").setPermissionCode("user:view");
        when(menuRepository.findAllById(java.util.Arrays.asList(10L))).thenReturn(java.util.Arrays.asList(menu));

        // Act
        roleService.getRoleMenus(menuSummaryBuilder, roleId);

        // Assert
        verify(menuSummaryBuilder).payload(any(RoleMenuSummary.class));
    }
}
