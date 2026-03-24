package com.apihug.rad.api.role;

import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.infra.role.RoleErrorEnum;
import com.apihug.rad.infra.role.RoleStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleEntityRepository roleRepository;

    @Mock
    private hope.common.spring.SimpleResultBuilder<RoleSummary> summaryBuilder;

    @Mock
    private hope.common.spring.SimpleResultBuilder<RoleDetail> detailBuilder;

    @Mock
    private hope.common.spring.SimpleResultBuilder<String> stringBuilder;

    private RoleServiceImpl roleService;

    @BeforeEach
    void setUp() {
        roleService = new RoleServiceImpl(roleRepository);
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

        when(roleRepository.existsByRoleCode("admin")).thenReturn(false);
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

        when(roleRepository.existsByRoleCode("existing")).thenReturn(true);

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

        when(roleRepository.findById(1L)).thenReturn(java.util.Optional.of(entity));

        // Act
        roleService.getRole(detailBuilder, roleId);

        // Assert
        verify(detailBuilder).payload(any(RoleDetail.class));
    }

    @Test
    void testGetRole_NotFound() {
        // Arrange
        Integer roleId = 999;
        when(roleRepository.findById(999L)).thenReturn(java.util.Optional.empty());

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

        when(roleRepository.findById(1L)).thenReturn(java.util.Optional.of(existing));
        when(roleRepository.save(any(RoleEntity.class))).thenReturn(existing);

        // Act
        roleService.updateRole(stringBuilder, roleId, request);

        // Assert
        verify(stringBuilder).done();
        verify(roleRepository).save(any(RoleEntity.class));
    }

    @Test
    void testUpdateRole_NotFound() {
        // Arrange
        Integer roleId = 999;
        UpdateRoleRequest request = new UpdateRoleRequest();

        when(roleRepository.findById(999L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.updateRole(stringBuilder, roleId, request);
        });
    }

    @Test
    void testDeleteRole_Success() {
        // Arrange
        Integer roleId = 1;
        RoleEntity entity = new RoleEntity()
            .setId(1L)
            .setRoleCode("admin");

        when(roleRepository.findById(1L)).thenReturn(java.util.Optional.of(entity));
        when(roleRepository.save(any(RoleEntity.class))).thenReturn(entity);

        // Act
        roleService.deleteRole(stringBuilder, roleId);

        // Assert
        verify(stringBuilder).done();
        verify(roleRepository).save(any(RoleEntity.class));
        assertTrue(entity.isDeleted());
    }

    @Test
    void testDeleteRole_NotFound() {
        // Arrange
        Integer roleId = 999;
        when(roleRepository.findById(999L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(HopeErrorDetailException.class, () -> {
            roleService.deleteRole(stringBuilder, roleId);
        });
    }

    @Test
    void testAssignPermissions_Success() {
        // Arrange
        Integer roleId = 1;
        AssignPermissionsRequest request = new AssignPermissionsRequest()
            .setPermissionIds(java.util.Arrays.asList(1L, 2L));

        // Act
        roleService.assignPermissions(stringBuilder, roleId, request);

        // Assert
        verify(stringBuilder).done();
    }

    @Test
    void testRemovePermission_Success() {
        // Arrange
        Integer roleId = 1;
        Integer permissionId = 1;
        RemovePermissionRequest request = new RemovePermissionRequest();

        // Act
        roleService.removePermission(stringBuilder, roleId, permissionId, request);

        // Assert
        verify(stringBuilder).done();
    }

    @Test
    void testGetRolePermissions_Success() {
        // Arrange
        Integer roleId = 1;

        // Act
        roleService.getRolePermissions(new hope.common.spring.SimpleResultBuilder<RolePermissionSummary>(), roleId);

        // Assert - TODO: 需要完善测试
    }
}
