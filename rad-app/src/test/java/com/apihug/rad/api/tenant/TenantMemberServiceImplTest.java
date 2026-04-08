package com.apihug.rad.api.tenant;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.MemberRoleEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.tenant.*;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.Customer;
import hope.common.spring.security.context.HopeContextHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@DisplayName("租户成员管理 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class TenantMemberServiceImplTest {

    @Mock
    private TenantMemberEntityRepository tenantMemberRepository;

    @Mock
    private CustomerEntityRepository customerRepository;

    @Mock
    private TenantEntityRepository tenantRepository;

    @Mock
    private MemberRoleEntityRepository memberRoleRepository;

    @Mock
    private RoleEntityRepository roleRepository;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    @Mock
    private SimpleResultBuilder<TenantMemberDetail> detailBuilder;

    @Mock
    private PageableResultBuilder<TenantMemberSummary> pageableBuilder;

    private TenantMemberServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new TenantMemberServiceImpl(tenantMemberRepository, customerRepository, tenantRepository, memberRoleRepository, roleRepository);
    }

    // ========== getTenantMembers ==========

    @Test
    @DisplayName("获取租户成员列表 - 成功")
    void testGetTenantMembers_Success() {
        Integer tenantId = 1;
        GetTenantMembersRequest request = new GetTenantMembersRequest();
        PageRequest pageRequest = new PageRequest().setPage(0).setSize(10);

        TenantMemberEntity member = new TenantMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setTenantId(1L)
            .setMemberRole(MemberRoleEnum.MEMBER)
            .setMemberType(MemberTypeEnum.FULL_TIME)
            .setStatus(TenantMemberStatusEnum.TM_ACTIVE)
            .setIsDefault(true);

        Page<TenantMemberEntity> page = new PageImpl<>(Arrays.asList(member));

        when(tenantRepository.existsById(1L)).thenReturn(true);
        when(tenantMemberRepository.searchTenantMembers(eq(1L), any(), any(), any())).thenReturn(page);
        when(customerRepository.findAllById(Arrays.asList(100L))).thenReturn(
            Arrays.asList(new CustomerEntity().setId(100L).setUsername("testuser").setEmail("test@example.com")));

        when(pageableBuilder.setPageIndex(anyInt())).thenReturn(pageableBuilder);
        when(pageableBuilder.setPageSize(anyInt())).thenReturn(pageableBuilder);
        when(pageableBuilder.setTotalCount(anyLong())).thenReturn(pageableBuilder);
        when(pageableBuilder.setTotalPage(anyInt())).thenReturn(pageableBuilder);

        service.getTenantMembers(pageableBuilder, tenantId, request, pageRequest);

        verify(tenantMemberRepository).searchTenantMembers(eq(1L), any(), any(), any());
        verify(pageableBuilder).setData(any());
    }

    @Test
    @DisplayName("获取租户成员列表 - 租户不存在")
    void testGetTenantMembers_TenantNotFound() {
        Integer tenantId = 999;
        GetTenantMembersRequest request = new GetTenantMembersRequest();
        PageRequest pageRequest = new PageRequest().setPage(0).setSize(10);

        when(tenantRepository.existsById(999L)).thenReturn(false);

        assertThrows(HopeErrorDetailException.class, () ->
            service.getTenantMembers(pageableBuilder, tenantId, request, pageRequest));
    }

    // ========== addMemberToTenant ==========

    @Test
    @DisplayName("添加租户成员 - 成功")
    void testAddMemberToTenant_Success() {
        Integer tenantId = 1;
        AddTenantMemberRequest request = new AddTenantMemberRequest()
            .setCustomerId(100L)
            .setMemberRole(MemberRoleEnum.MEMBER)
            .setMemberType(MemberTypeEnum.FULL_TIME)
            .setIsDefault(false);

        when(tenantRepository.existsById(1L)).thenReturn(true);
        when(customerRepository.existsById(100L)).thenReturn(true);
        when(tenantMemberRepository.existsByCustomerIdAndTenantId(100L, 1L)).thenReturn(false);
        when(tenantMemberRepository.save(any(TenantMemberEntity.class))).thenReturn(new TenantMemberEntity());

        service.addMemberToTenant(stringBuilder, tenantId, request);

        ArgumentCaptor<TenantMemberEntity> captor = ArgumentCaptor.forClass(TenantMemberEntity.class);
        verify(tenantMemberRepository).save(captor.capture());
        TenantMemberEntity captured = captor.getValue();
        assertEquals(100L, captured.getCustomerId());
        assertEquals(1L, captured.getTenantId());
        assertEquals(MemberRoleEnum.MEMBER, captured.getMemberRole());
        assertEquals(TenantMemberStatusEnum.TM_ACTIVE, captured.getStatus());
    }

    @Test
    @DisplayName("添加租户成员 - 租户不存在")
    void testAddMemberToTenant_TenantNotFound() {
        Integer tenantId = 999;
        AddTenantMemberRequest request = new AddTenantMemberRequest().setCustomerId(100L);

        when(tenantRepository.existsById(999L)).thenReturn(false);

        assertThrows(HopeErrorDetailException.class, () ->
            service.addMemberToTenant(stringBuilder, tenantId, request));
        verify(tenantMemberRepository, never()).save(any());
    }

    @Test
    @DisplayName("添加租户成员 - 客户不存在")
    void testAddMemberToTenant_CustomerNotFound() {
        Integer tenantId = 1;
        AddTenantMemberRequest request = new AddTenantMemberRequest().setCustomerId(999L);

        when(tenantRepository.existsById(1L)).thenReturn(true);
        when(customerRepository.existsById(999L)).thenReturn(false);

        assertThrows(HopeErrorDetailException.class, () ->
            service.addMemberToTenant(stringBuilder, tenantId, request));
        verify(tenantMemberRepository, never()).save(any());
    }

    @Test
    @DisplayName("添加租户成员 - 已存在")
    void testAddMemberToTenant_AlreadyExists() {
        Integer tenantId = 1;
        AddTenantMemberRequest request = new AddTenantMemberRequest().setCustomerId(100L);

        when(tenantRepository.existsById(1L)).thenReturn(true);
        when(customerRepository.existsById(100L)).thenReturn(true);
        when(tenantMemberRepository.existsByCustomerIdAndTenantId(100L, 1L)).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () ->
            service.addMemberToTenant(stringBuilder, tenantId, request));
        verify(tenantMemberRepository, never()).save(any());
    }

    // ========== removeMemberFromTenant ==========

    @Test
    @DisplayName("移除租户成员 - 成功")
    void testRemoveMemberFromTenant_Success() {
        Integer tenantId = 1;
        Integer memberId = 10;
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(1L)
            .setStatus(TenantMemberStatusEnum.TM_ACTIVE);

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));
        when(tenantMemberRepository.save(any(TenantMemberEntity.class))).thenReturn(member);

        service.removeMemberFromTenant(stringBuilder, tenantId, memberId);

        assertEquals(TenantMemberStatusEnum.TM_INACTIVE, member.getStatus());
    }

    @Test
    @DisplayName("移除租户成员 - 成员不存在")
    void testRemoveMemberFromTenant_NotFound() {
        Integer tenantId = 1;
        Integer memberId = 999;

        when(tenantMemberRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.removeMemberFromTenant(stringBuilder, tenantId, memberId));
    }

    @Test
    @DisplayName("移除租户成员 - 不属于该租户")
    void testRemoveMemberFromTenant_WrongTenant() {
        Integer tenantId = 1;
        Integer memberId = 10;
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(2L); // 不属于 tenant 1

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));

        assertThrows(HopeErrorDetailException.class, () ->
            service.removeMemberFromTenant(stringBuilder, tenantId, memberId));
    }

    // ========== toggleMemberLock ==========

    @Test
    @DisplayName("锁定成员 - 从活跃到锁定")
    void testToggleMemberLock_ActiveToLocked() {
        Integer tenantId = 1;
        Integer memberId = 10;
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(1L)
            .setStatus(TenantMemberStatusEnum.TM_ACTIVE);

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));
        when(tenantMemberRepository.save(any(TenantMemberEntity.class))).thenReturn(member);

        service.toggleMemberLock(stringBuilder, tenantId, memberId);

        assertEquals(TenantMemberStatusEnum.TM_LOCKED, member.getStatus());
    }

    @Test
    @DisplayName("解锁成员 - 从锁定到活跃")
    void testToggleMemberLock_LockedToActive() {
        Integer tenantId = 1;
        Integer memberId = 10;
        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(1L)
            .setStatus(TenantMemberStatusEnum.TM_LOCKED);

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));
        when(tenantMemberRepository.save(any(TenantMemberEntity.class))).thenReturn(member);

        service.toggleMemberLock(stringBuilder, tenantId, memberId);

        assertEquals(TenantMemberStatusEnum.TM_ACTIVE, member.getStatus());
    }

    // ========== updateMemberRole ==========

    @Test
    @DisplayName("更新成员角色 - 成功")
    void testUpdateMemberRole_Success() {
        Integer tenantId = 1;
        Integer memberId = 10;
        UpdateMemberRoleRequest request = new UpdateMemberRoleRequest()
            .setMemberRole(MemberRoleEnum.ADMIN);

        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(1L)
            .setMemberRole(MemberRoleEnum.MEMBER);

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));
        when(tenantMemberRepository.save(any(TenantMemberEntity.class))).thenReturn(member);

        service.updateMemberRole(stringBuilder, tenantId, memberId, request);

        assertEquals(MemberRoleEnum.ADMIN, member.getMemberRole());
    }

    @Test
    @DisplayName("更新成员角色 - 成员不存在")
    void testUpdateMemberRole_NotFound() {
        Integer tenantId = 1;
        Integer memberId = 999;
        UpdateMemberRoleRequest request = new UpdateMemberRoleRequest()
            .setMemberRole(MemberRoleEnum.ADMIN);

        when(tenantMemberRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.updateMemberRole(stringBuilder, tenantId, memberId, request));
    }

    // ========== assignMemberDepartment ==========

    @Test
    @DisplayName("分配成员部门 - 成功")
    void testAssignMemberDepartment_Success() {
        Integer tenantId = 1;
        Integer memberId = 10;
        AssignMemberDepartmentRequest request = new AssignMemberDepartmentRequest()
            .setDepartmentId(5L)
            .setPosition("技术经理");

        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(1L);

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));
        when(tenantMemberRepository.save(any(TenantMemberEntity.class))).thenReturn(member);

        service.assignMemberDepartment(stringBuilder, tenantId, memberId, request);

        assertEquals(5L, member.getDepartmentId());
        assertEquals("技术经理", member.getPosition());
    }

    @Test
    @DisplayName("分配成员部门 - 成员不属于该租户")
    void testAssignMemberDepartment_WrongTenant() {
        Integer tenantId = 1;
        Integer memberId = 10;
        AssignMemberDepartmentRequest request = new AssignMemberDepartmentRequest()
            .setDepartmentId(5L);

        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(2L);

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));

        assertThrows(HopeErrorDetailException.class, () ->
            service.assignMemberDepartment(stringBuilder, tenantId, memberId, request));
    }


    // ========== getMemberDetail ==========

    @Test
    @DisplayName("获取成员详情 - 成功")
    void testGetMemberDetail_Success() {
        Integer tenantId = 1;
        Integer memberId = 10;

        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setCustomerId(100L)
            .setTenantId(1L)
            .setMemberType(MemberTypeEnum.FULL_TIME)
            .setMemberRole(MemberRoleEnum.ADMIN)
            .setStatus(TenantMemberStatusEnum.TM_ACTIVE)
            .setDepartmentId(5L)
            .setPosition("技术经理")
            .setIsDefault(true);

        CustomerEntity customer = new CustomerEntity()
            .setId(100L)
            .setUsername("zhangsan")
            .setEmail("zhangsan@example.com")
            .setStatus(com.apihug.rad.infra.customer.CustomerStatusEnum.ACTIVE);

        TenantEntity tenant = new TenantEntity()
            .setId(1L)
            .setTenantName("Acme 公司")
            .setTenantCode("acme_corp");

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));
        when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
        when(tenantRepository.findById(1L)).thenReturn(Optional.of(tenant));

        service.getMemberDetail(detailBuilder, tenantId, memberId);

        ArgumentCaptor<TenantMemberDetail> captor = ArgumentCaptor.forClass(TenantMemberDetail.class);
        verify(detailBuilder).payload(captor.capture());

        TenantMemberDetail detail = captor.getValue();
        assertEquals(10L, detail.getId());
        assertEquals(100L, detail.getCustomerId());
        assertEquals(1L, detail.getTenantId());
        assertEquals("zhangsan", detail.getCustomerUsername());
        assertEquals("zhangsan@example.com", detail.getCustomerEmail());
        assertEquals("Acme 公司", detail.getTenantName());
        assertEquals("acme_corp", detail.getTenantCode());
        assertEquals(MemberRoleEnum.ADMIN, detail.getMemberRole());
        assertEquals(TenantMemberStatusEnum.TM_ACTIVE, detail.getStatus());
        assertEquals("技术经理", detail.getPosition());
    }

    @Test
    @DisplayName("获取成员详情 - 成员不存在")
    void testGetMemberDetail_NotFound() {
        Integer tenantId = 1;
        Integer memberId = 999;

        when(tenantMemberRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.getMemberDetail(detailBuilder, tenantId, memberId));
    }

    @Test
    @DisplayName("获取成员详情 - 不属于该租户")
    void testGetMemberDetail_WrongTenant() {
        Integer tenantId = 1;
        Integer memberId = 10;

        TenantMemberEntity member = new TenantMemberEntity()
            .setId(10L)
            .setTenantId(2L); // 不属于 tenant 1

        when(tenantMemberRepository.findById(10L)).thenReturn(Optional.of(member));

        assertThrows(HopeErrorDetailException.class, () ->
            service.getMemberDetail(detailBuilder, tenantId, memberId));
    }
}
