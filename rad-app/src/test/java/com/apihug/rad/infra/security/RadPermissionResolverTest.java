package com.apihug.rad.infra.security;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.RoleMenuEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.role.repository.RoleMenuEntityRepository;
import com.apihug.rad.domain.security.CustomerPermissionResolver;
import com.apihug.rad.domain.tenant.MemberRoleEntity;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.MemberRoleEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("RadPermissionResolver 权限解析测试")
@ExtendWith(MockitoExtension.class)
class RadPermissionResolverTest {

    @Mock
    private TenantMemberEntityRepository tenantMemberRepository;
    @Mock
    private MemberRoleEntityRepository memberRoleRepository;
    @Mock
    private RoleEntityRepository roleRepository;
    @Mock
    private RoleMenuEntityRepository roleMenuRepository;
    @Mock
    private MenuEntityRepository menuRepository;

    private CustomerPermissionResolver resolver;

    @BeforeEach
    void setUp() {
        resolver = new CustomerPermissionResolver(
            tenantMemberRepository, memberRoleRepository,
            roleRepository, roleMenuRepository, menuRepository);
    }

    // ========== resolveRoles ==========

    @Test
    @DisplayName("OWNER 用户获得超级管理员角色 (*)")
    void testResolveRoles_Owner() {
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.OWNER);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));

        Set<String> roles = resolver.resolveRoles(100L, 1L);

        assertEquals(Set.of("*"), roles);
        verify(memberRoleRepository, never()).findByMemberId(any());
    }

    @Test
    @DisplayName("普通成员通过 MemberRole -> RoleEntity 解析角色")
    void testResolveRoles_NormalMember() {
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.MEMBER);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));

        MemberRoleEntity mr1 = new MemberRoleEntity().setMemberId(1L).setRoleId(10L);
        MemberRoleEntity mr2 = new MemberRoleEntity().setMemberId(1L).setRoleId(20L);
        when(memberRoleRepository.findByMemberId(1L)).thenReturn(Arrays.asList(mr1, mr2));

        RoleEntity role1 = new RoleEntity().setId(10L).setRoleCode("editor");
        RoleEntity role2 = new RoleEntity().setId(20L).setRoleCode("viewer");
        when(roleRepository.findAllById(Arrays.asList(10L, 20L)))
            .thenReturn(Arrays.asList(role1, role2));

        Set<String> roles = resolver.resolveRoles(100L, 1L);

        assertEquals(Set.of("editor", "viewer"), roles);
    }

    @Test
    @DisplayName("成员无角色分配返回空集")
    void testResolveRoles_NoAssignedRoles() {
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.MEMBER);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));
        when(memberRoleRepository.findByMemberId(1L)).thenReturn(Collections.emptyList());

        Set<String> roles = resolver.resolveRoles(100L, 1L);

        assertTrue(roles.isEmpty());
    }

    @Test
    @DisplayName("非租户成员返回空集")
    void testResolveRoles_NotMember() {
        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.empty());

        Set<String> roles = resolver.resolveRoles(100L, 1L);

        assertTrue(roles.isEmpty());
    }

    @Test
    @DisplayName("null 参数返回空集")
    void testResolveRoles_NullParams() {
        assertTrue(resolver.resolveRoles(null, 1L).isEmpty());
        assertTrue(resolver.resolveRoles(100L, null).isEmpty());
        assertTrue(resolver.resolveRoles(100L, 0L).isEmpty());
    }

    // ========== resolveAuthorities ==========

    @Test
    @DisplayName("OWNER 用户获得全部权限 (*:*:*)")
    void testResolveAuthorities_Owner() {
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.OWNER);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));

        Set<String> authorities = resolver.resolveAuthorities(100L, 1L);

        assertEquals(Set.of("*:*:*"), authorities);
        verify(memberRoleRepository, never()).findByMemberId(any());
    }

    @Test
    @DisplayName("普通成员通过完整链路解析权限")
    void testResolveAuthorities_FullChain() {
        // Member
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.ADMIN);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));

        // MemberRole
        MemberRoleEntity mr = new MemberRoleEntity().setMemberId(1L).setRoleId(10L);
        when(memberRoleRepository.findByMemberId(1L)).thenReturn(Collections.singletonList(mr));

        // RoleMenu
        RoleMenuEntity rm1 = new RoleMenuEntity().setRoleId(10L).setMenuId(100L);
        RoleMenuEntity rm2 = new RoleMenuEntity().setRoleId(10L).setMenuId(200L);
        when(roleMenuRepository.findByRoleIdIn(Collections.singletonList(10L)))
            .thenReturn(Arrays.asList(rm1, rm2));

        // Menu
        MenuEntity menu1 = new MenuEntity().setId(100L).setPermissionCode("user:view");
        MenuEntity menu2 = new MenuEntity().setId(200L).setPermissionCode("user:create");
        when(menuRepository.findAllById(any())).thenReturn(Arrays.asList(menu1, menu2));

        Set<String> authorities = resolver.resolveAuthorities(100L, 1L);

        assertEquals(Set.of("user:view", "user:create"), authorities);
    }

    @Test
    @DisplayName("菜单无 permissionCode 被过滤")
    void testResolveAuthorities_FilterBlankPermissionCode() {
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.MEMBER);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));

        MemberRoleEntity mr = new MemberRoleEntity().setMemberId(1L).setRoleId(10L);
        when(memberRoleRepository.findByMemberId(1L)).thenReturn(Collections.singletonList(mr));

        RoleMenuEntity rm = new RoleMenuEntity().setRoleId(10L).setMenuId(100L);
        when(roleMenuRepository.findByRoleIdIn(Collections.singletonList(10L)))
            .thenReturn(Collections.singletonList(rm));

        // Menu with blank permission code (directory type menu)
        MenuEntity menu = new MenuEntity().setId(100L).setPermissionCode("");
        when(menuRepository.findAllById(any())).thenReturn(Collections.singletonList(menu));

        Set<String> authorities = resolver.resolveAuthorities(100L, 1L);

        assertTrue(authorities.isEmpty());
    }

    @Test
    @DisplayName("无角色菜单关联返回空集")
    void testResolveAuthorities_NoRoleMenus() {
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L).setCustomerId(100L).setTenantId(1L)
            .setMemberRole(MemberRoleEnum.MEMBER);

        when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
            .thenReturn(Optional.of(member));

        MemberRoleEntity mr = new MemberRoleEntity().setMemberId(1L).setRoleId(10L);
        when(memberRoleRepository.findByMemberId(1L)).thenReturn(Collections.singletonList(mr));

        when(roleMenuRepository.findByRoleIdIn(Collections.singletonList(10L)))
            .thenReturn(Collections.emptyList());

        Set<String> authorities = resolver.resolveAuthorities(100L, 1L);

        assertTrue(authorities.isEmpty());
    }

    // ========== Static helpers ==========

    @Test
    @DisplayName("isSuperAdmin 检查")
    void testIsSuperAdmin() {
        assertTrue(CustomerPermissionResolver.isSuperAdmin(Set.of("*:*:*")));
        assertFalse(CustomerPermissionResolver.isSuperAdmin(Set.of("user:view")));
        assertFalse(CustomerPermissionResolver.isSuperAdmin(null));
    }

    @Test
    @DisplayName("isSuperAdminRole 检查")
    void testIsSuperAdminRole() {
        assertTrue(CustomerPermissionResolver.isSuperAdminRole(Set.of("*")));
        assertFalse(CustomerPermissionResolver.isSuperAdminRole(Set.of("admin")));
        assertFalse(CustomerPermissionResolver.isSuperAdminRole(null));
    }
}
