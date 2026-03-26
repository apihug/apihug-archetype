package com.apihug.rad.api.platform;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.platform.PlatformMemberEntity;
import com.apihug.rad.domain.platform.repository.PlatformMemberEntityRepository;
import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@DisplayName("平台成员管理 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class PlatformServiceImplTest {

    @Mock
    private PlatformMemberEntityRepository platformMemberRepository;

    @Mock
    private CustomerEntityRepository customerRepository;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    @Mock
    private PageableResultBuilder<PlatformMemberInfo> pageableBuilder;

    private PlatformServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new PlatformServiceImpl(platformMemberRepository, customerRepository);
    }

    // ========== getPlatformMembers ==========

    @Test
    @DisplayName("获取平台成员列表 - 成功返回分页数据")
    void testGetPlatformMembers_Success() {
        GetPlatformMembersRequest request = new GetPlatformMembersRequest();
        PageRequest pageRequest = new PageRequest().setPage(0).setSize(10);

        PlatformMemberEntity member = new PlatformMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_ACTIVE);
        member.setCreatedAt(LocalDateTime.now());

        Page<PlatformMemberEntity> page = new PageImpl<>(Arrays.asList(member));

        when(platformMemberRepository.searchPlatformMembers(any(), any(), any())).thenReturn(page);
        when(customerRepository.findAllById(Arrays.asList(100L))).thenReturn(
            Arrays.asList(new CustomerEntity().setId(100L).setUsername("testuser").setEmail("test@example.com")));

        when(pageableBuilder.setPageIndex(anyInt())).thenReturn(pageableBuilder);
        when(pageableBuilder.setPageSize(anyInt())).thenReturn(pageableBuilder);
        when(pageableBuilder.setTotalCount(anyLong())).thenReturn(pageableBuilder);
        when(pageableBuilder.setTotalPage(anyInt())).thenReturn(pageableBuilder);

        service.getPlatformMembers(pageableBuilder, request, pageRequest);

        verify(platformMemberRepository).searchPlatformMembers(any(), any(), any());
        verify(customerRepository).findAllById(anyList());
        verify(pageableBuilder).setData(any());
    }

    @Test
    @DisplayName("获取平台成员列表 - 空列表")
    void testGetPlatformMembers_EmptyList() {
        GetPlatformMembersRequest request = new GetPlatformMembersRequest();
        PageRequest pageRequest = new PageRequest().setPage(0).setSize(10);

        Page<PlatformMemberEntity> emptyPage = new PageImpl<>(Collections.emptyList());

        when(platformMemberRepository.searchPlatformMembers(any(), any(), any())).thenReturn(emptyPage);
        when(customerRepository.findAllById(Collections.emptyList())).thenReturn(Collections.emptyList());

        when(pageableBuilder.setPageIndex(anyInt())).thenReturn(pageableBuilder);
        when(pageableBuilder.setPageSize(anyInt())).thenReturn(pageableBuilder);
        when(pageableBuilder.setTotalCount(anyLong())).thenReturn(pageableBuilder);
        when(pageableBuilder.setTotalPage(anyInt())).thenReturn(pageableBuilder);

        service.getPlatformMembers(pageableBuilder, request, pageRequest);

        verify(pageableBuilder).setData(Collections.emptyList());
    }

    // ========== addPlatformMember ==========

    @Test
    @DisplayName("添加平台成员 - 成功，默认 MEMBER 角色")
    void testAddPlatformMember_Success_DefaultRole() {
        AddPlatformMemberRequest request = new AddPlatformMemberRequest()
            .setCustomerId(100L);

        CustomerEntity customer = new CustomerEntity().setId(100L).setUsername("testuser");
        when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
        when(platformMemberRepository.existsByCustomerId(100L)).thenReturn(false);

        service.addPlatformMember(stringBuilder, request);

        ArgumentCaptor<PlatformMemberEntity> memberCaptor = ArgumentCaptor.forClass(PlatformMemberEntity.class);
        verify(platformMemberRepository).save(memberCaptor.capture());
        PlatformMemberEntity saved = memberCaptor.getValue();
        assertEquals(100L, saved.getCustomerId());
        assertEquals(CustomerPlatformTypeEnum.MEMBER, saved.getPlatformRole());
        assertEquals(PlatformMemberStatusEnum.PM_ACTIVE, saved.getStatus());

        // 验证客户的 platformType 被更新
        ArgumentCaptor<CustomerEntity> customerCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerRepository).save(customerCaptor.capture());
        assertEquals(CustomerPlatformTypeEnum.MEMBER, customerCaptor.getValue().getPlatformType());
    }

    @Test
    @DisplayName("添加平台成员 - 成功，指定 MANAGER 角色")
    void testAddPlatformMember_Success_ManagerRole() {
        AddPlatformMemberRequest request = new AddPlatformMemberRequest()
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.MANAGER);

        CustomerEntity customer = new CustomerEntity().setId(100L).setUsername("manager");
        when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
        when(platformMemberRepository.existsByCustomerId(100L)).thenReturn(false);

        service.addPlatformMember(stringBuilder, request);

        ArgumentCaptor<PlatformMemberEntity> captor = ArgumentCaptor.forClass(PlatformMemberEntity.class);
        verify(platformMemberRepository).save(captor.capture());
        assertEquals(CustomerPlatformTypeEnum.MANAGER, captor.getValue().getPlatformRole());
    }

    @Test
    @DisplayName("添加平台成员 - 客户不存在，抛出异常")
    void testAddPlatformMember_CustomerNotFound() {
        AddPlatformMemberRequest request = new AddPlatformMemberRequest().setCustomerId(999L);
        when(customerRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.addPlatformMember(stringBuilder, request));

        verify(platformMemberRepository, never()).save(any());
    }

    @Test
    @DisplayName("添加平台成员 - 已是平台成员，抛出重复异常")
    void testAddPlatformMember_AlreadyExists() {
        AddPlatformMemberRequest request = new AddPlatformMemberRequest().setCustomerId(100L);
        CustomerEntity customer = new CustomerEntity().setId(100L);
        when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
        when(platformMemberRepository.existsByCustomerId(100L)).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () ->
            service.addPlatformMember(stringBuilder, request));

        verify(platformMemberRepository, never()).save(any());
    }

    // ========== removePlatformMember ==========

    @Test
    @DisplayName("移除平台成员 - 成功，同时重置 platformType")
    void testRemovePlatformMember_Success() {
        PlatformMemberEntity member = new PlatformMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_ACTIVE);

        CustomerEntity customer = new CustomerEntity().setId(100L).setPlatformType(CustomerPlatformTypeEnum.MEMBER);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));

        service.removePlatformMember(stringBuilder, 1L);

        ArgumentCaptor<PlatformMemberEntity> memberCaptor = ArgumentCaptor.forClass(PlatformMemberEntity.class);
        verify(platformMemberRepository).save(memberCaptor.capture());
        assertEquals(PlatformMemberStatusEnum.PM_INACTIVE, memberCaptor.getValue().getStatus());

        ArgumentCaptor<CustomerEntity> customerCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerRepository).save(customerCaptor.capture());
        assertNull(customerCaptor.getValue().getPlatformType());
    }

    @Test
    @DisplayName("移除平台成员 - OWNER 不允许被移除，抛出异常")
    void testRemovePlatformMember_OwnerCannotBeRemoved() {
        PlatformMemberEntity owner = new PlatformMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.OWNER)
            .setStatus(PlatformMemberStatusEnum.PM_ACTIVE);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(owner));

        assertThrows(HopeErrorDetailException.class, () ->
            service.removePlatformMember(stringBuilder, 1L));

        verify(platformMemberRepository, never()).save(any());
    }

    @Test
    @DisplayName("移除平台成员 - 成员不存在，抛出异常")
    void testRemovePlatformMember_NotFound() {
        when(platformMemberRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.removePlatformMember(stringBuilder, 999L));
    }

    // ========== togglePlatformMemberFreeze ==========

    @Test
    @DisplayName("冻结/解冻 - PM_ACTIVE → PM_LOCKED")
    void testTogglePlatformMemberFreeze_ActiveToLocked() {
        PlatformMemberEntity member = new PlatformMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_ACTIVE);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(member));

        service.togglePlatformMemberFreeze(stringBuilder, 1L);

        ArgumentCaptor<PlatformMemberEntity> captor = ArgumentCaptor.forClass(PlatformMemberEntity.class);
        verify(platformMemberRepository).save(captor.capture());
        assertEquals(PlatformMemberStatusEnum.PM_LOCKED, captor.getValue().getStatus());
    }

    @Test
    @DisplayName("冻结/解冻 - PM_LOCKED → PM_ACTIVE")
    void testTogglePlatformMemberFreeze_LockedToActive() {
        PlatformMemberEntity member = new PlatformMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_LOCKED);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(member));

        service.togglePlatformMemberFreeze(stringBuilder, 1L);

        ArgumentCaptor<PlatformMemberEntity> captor = ArgumentCaptor.forClass(PlatformMemberEntity.class);
        verify(platformMemberRepository).save(captor.capture());
        assertEquals(PlatformMemberStatusEnum.PM_ACTIVE, captor.getValue().getStatus());
    }

    @Test
    @DisplayName("冻结/解冻 - PM_INACTIVE 状态不允许切换，抛出异常")
    void testTogglePlatformMemberFreeze_InactiveNotAllowed() {
        PlatformMemberEntity member = new PlatformMemberEntity()
            .setId(1L)
            .setCustomerId(100L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_INACTIVE);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(member));

        assertThrows(HopeErrorDetailException.class, () ->
            service.togglePlatformMemberFreeze(stringBuilder, 1L));

        verify(platformMemberRepository, never()).save(any());
    }

    @Test
    @DisplayName("冻结/解冻 - 成员不存在，抛出异常")
    void testTogglePlatformMemberFreeze_NotFound() {
        when(platformMemberRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.togglePlatformMemberFreeze(stringBuilder, 999L));
    }

    // ============================================================
    // updatePlatformMemberRole 测试
    // ============================================================

    @Test
    @DisplayName("更新角色 - 成功：MEMBER → MANAGER，同步更新 Customer.platformType")
    void testUpdatePlatformMemberRole_Success() {
        PlatformMemberEntity member = new PlatformMemberEntity()
            .setCustomerId(10L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_ACTIVE);

        CustomerEntity customer = new CustomerEntity();

        UpdatePlatformMemberRoleRequest request = new UpdatePlatformMemberRoleRequest()
            .setPlatformRole(CustomerPlatformTypeEnum.MANAGER);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(customerRepository.findById(10L)).thenReturn(Optional.of(customer));

        service.updatePlatformMemberRole(stringBuilder, 1L, request);

        ArgumentCaptor<PlatformMemberEntity> memberCaptor = ArgumentCaptor.forClass(PlatformMemberEntity.class);
        verify(platformMemberRepository).save(memberCaptor.capture());
        assertEquals(CustomerPlatformTypeEnum.MANAGER, memberCaptor.getValue().getPlatformRole());

        ArgumentCaptor<CustomerEntity> customerCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerRepository).save(customerCaptor.capture());
        assertEquals(CustomerPlatformTypeEnum.MANAGER, customerCaptor.getValue().getPlatformType());
    }

    @Test
    @DisplayName("更新角色 - 成员已移除（PM_INACTIVE），抛出异常")
    void testUpdatePlatformMemberRole_Inactive() {
        PlatformMemberEntity member = new PlatformMemberEntity()
            .setCustomerId(10L)
            .setPlatformRole(CustomerPlatformTypeEnum.MEMBER)
            .setStatus(PlatformMemberStatusEnum.PM_INACTIVE);

        UpdatePlatformMemberRoleRequest request = new UpdatePlatformMemberRoleRequest()
            .setPlatformRole(CustomerPlatformTypeEnum.MANAGER);

        when(platformMemberRepository.findById(1L)).thenReturn(Optional.of(member));

        assertThrows(HopeErrorDetailException.class, () ->
            service.updatePlatformMemberRole(stringBuilder, 1L, request));

        verify(platformMemberRepository, never()).save(any());
    }

    @Test
    @DisplayName("更新角色 - 成员不存在，抛出异常")
    void testUpdatePlatformMemberRole_NotFound() {
        UpdatePlatformMemberRoleRequest request = new UpdatePlatformMemberRoleRequest()
            .setPlatformRole(CustomerPlatformTypeEnum.MANAGER);

        when(platformMemberRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.updatePlatformMemberRole(stringBuilder, 999L, request));
    }
}
