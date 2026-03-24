package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.MemberRoleEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.security.RadPermissionResolver;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.Customer;
import hope.common.spring.security.JwtCustomizer;
import hope.common.spring.security.context.HopeContextHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("客户 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerEntityRepository customerRepository;

    @Mock
    private TenantMemberEntityRepository tenantMemberRepository;

    @Mock
    private TenantEntityRepository tenantRepository;

    @Mock
    private JwtCustomizer jwtCustomizer;

    @Mock
    private RadPermissionResolver permissionResolver;

    @Mock
    private MemberRoleEntityRepository memberRoleRepository;

    @Mock
    private RoleEntityRepository roleRepository;

    @Mock
    private DepartmentEntityRepository departmentRepository;

    @Mock
    private SimpleResultBuilder<CustomerInfo> customerInfoBuilder;

    @Mock
    private SimpleResultBuilder<CurrentCustomerInfo> currentInfoBuilder;

    @Mock
    private SimpleResultBuilder<TenantList> tenantListBuilder;

    @Mock
    private SimpleResultBuilder<LoginResponse> loginResponseBuilder;

    private CustomerServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CustomerServiceImpl(customerRepository, tenantMemberRepository, tenantRepository, jwtCustomizer, permissionResolver, memberRoleRepository, roleRepository, departmentRepository);
    }

    // ========== info ==========

    @Test
    @DisplayName("查询当前客户信息 - 成功")
    void testInfo_Success() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser")
                .setDefaultTenantId(1L);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));

            service.info(customerInfoBuilder);

            ArgumentCaptor<CustomerInfo> captor = ArgumentCaptor.forClass(CustomerInfo.class);
            verify(customerInfoBuilder).payload(captor.capture());
            CustomerInfo info = captor.getValue();
            assertEquals(100L, info.getCustomerId());
            assertEquals("testuser", info.getUsername());
            assertEquals(1L, info.getTenantId());
        }
    }

    @Test
    @DisplayName("查询当前客户信息 - 客户不存在")
    void testInfo_NotFound() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(999L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            when(customerRepository.findById(999L)).thenReturn(Optional.empty());

            assertThrows(HopeErrorDetailException.class, () ->
                service.info(customerInfoBuilder));
        }
    }

    // ========== getCurrentCustomerInfo ==========

    @Test
    @DisplayName("获取客户完整信息 - 含租户信息")
    void testGetCurrentCustomerInfo_WithTenant() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser")
                .setDefaultTenantId(1L);

            TenantEntity tenant = new TenantEntity()
                .setId(1L)
                .setTenantCode("acme")
                .setTenantName("Acme Corp")
                .setIsPlatform(false);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
            when(tenantRepository.findById(1L)).thenReturn(Optional.of(tenant));
            when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 1L))
                .thenReturn(Optional.of(new TenantMemberEntity()));

            service.getCurrentCustomerInfo(currentInfoBuilder);

            ArgumentCaptor<CurrentCustomerInfo> captor = ArgumentCaptor.forClass(CurrentCustomerInfo.class);
            verify(currentInfoBuilder).payload(captor.capture());
            CurrentCustomerInfo info = captor.getValue();
            assertNotNull(info.getCustomer());
            assertEquals(100L, info.getCustomer().getCustomerId());
            assertNotNull(info.getCurrentTenant());
            assertEquals("acme", info.getCurrentTenant().getTenantCode());
        }
    }

    @Test
    @DisplayName("获取客户完整信息 - 无租户")
    void testGetCurrentCustomerInfo_NoTenant() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser")
                .setDefaultTenantId(0L);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));

            service.getCurrentCustomerInfo(currentInfoBuilder);

            ArgumentCaptor<CurrentCustomerInfo> captor = ArgumentCaptor.forClass(CurrentCustomerInfo.class);
            verify(currentInfoBuilder).payload(captor.capture());
            CurrentCustomerInfo info = captor.getValue();
            assertNotNull(info.getCustomer());
            assertNull(info.getCurrentTenant());
        }
    }

    // ========== getCustomerTenants ==========

    @Test
    @DisplayName("获取客户租户列表 - 成功")
    void testGetCustomerTenants_Success() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            TenantMemberEntity member1 = new TenantMemberEntity()
                .setId(1L).setCustomerId(100L).setTenantId(1L).setIsDefault(true);
            TenantMemberEntity member2 = new TenantMemberEntity()
                .setId(2L).setCustomerId(100L).setTenantId(2L).setIsDefault(false);

            TenantEntity tenant1 = new TenantEntity()
                .setId(1L).setTenantCode("acme").setTenantName("Acme").setIsPlatform(false);
            TenantEntity tenant2 = new TenantEntity()
                .setId(2L).setTenantCode("beta").setTenantName("Beta").setIsPlatform(true);

            when(tenantMemberRepository.findByCustomerId(100L))
                .thenReturn(Arrays.asList(member1, member2));
            when(tenantRepository.findAllById(Arrays.asList(1L, 2L)))
                .thenReturn(Arrays.asList(tenant1, tenant2));

            service.getCustomerTenants(tenantListBuilder);

            ArgumentCaptor<TenantList> captor = ArgumentCaptor.forClass(TenantList.class);
            verify(tenantListBuilder).payload(captor.capture());
            TenantList list = captor.getValue();
            assertEquals(2, list.getTenants().size());
            assertEquals(1L, list.getDefaultTenantId());
        }
    }

    @Test
    @DisplayName("获取客户租户列表 - 空列表")
    void testGetCustomerTenants_Empty() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            when(tenantMemberRepository.findByCustomerId(100L)).thenReturn(Arrays.asList());

            service.getCustomerTenants(tenantListBuilder);

            ArgumentCaptor<TenantList> captor = ArgumentCaptor.forClass(TenantList.class);
            verify(tenantListBuilder).payload(captor.capture());
            TenantList list = captor.getValue();
            assertTrue(list.getTenants().isEmpty());
            assertEquals(0L, list.getDefaultTenantId());
        }
    }

    // ========== switchTenant ==========

    @Test
    @DisplayName("切换租户 - 成功")
    void testSwitchTenant_Success() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser")
                .setDefaultTenantId(1L);

            TenantMemberEntity membership = new TenantMemberEntity()
                .setId(1L)
                .setCustomerId(100L)
                .setTenantId(2L)
                .setStatus(TenantMemberStatusEnum.TM_ACTIVE);

            SwitchTenantRequest request = new SwitchTenantRequest().setTenantId(2L);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
            when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 2L))
                .thenReturn(Optional.of(membership));
            when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customer);
            when(jwtCustomizer.encode(any())).thenReturn("new-jwt-token");

            service.switchTenant(loginResponseBuilder, request);

            assertEquals(2L, customer.getDefaultTenantId());
            verify(jwtCustomizer).encode(any());
            ArgumentCaptor<LoginResponse> captor = ArgumentCaptor.forClass(LoginResponse.class);
            verify(loginResponseBuilder).payload(captor.capture());
            assertEquals("new-jwt-token", captor.getValue().getAccessToken());
        }
    }

    @Test
    @DisplayName("切换租户 - 不是目标租户成员")
    void testSwitchTenant_NotMember() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser");

            SwitchTenantRequest request = new SwitchTenantRequest().setTenantId(999L);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
            when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 999L))
                .thenReturn(Optional.empty());

            assertThrows(HopeErrorDetailException.class, () ->
                service.switchTenant(loginResponseBuilder, request));
            verify(jwtCustomizer, never()).encode(any());
        }
    }

    @Test
    @DisplayName("切换租户 - 成员被锁定")
    void testSwitchTenant_MemberLocked() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser");

            TenantMemberEntity membership = new TenantMemberEntity()
                .setId(1L)
                .setStatus(TenantMemberStatusEnum.TM_LOCKED);

            SwitchTenantRequest request = new SwitchTenantRequest().setTenantId(2L);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
            when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 2L))
                .thenReturn(Optional.of(membership));

            assertThrows(HopeErrorDetailException.class, () ->
                service.switchTenant(loginResponseBuilder, request));
            verify(jwtCustomizer, never()).encode(any());
        }
    }

    @Test
    @DisplayName("切换租户 - 成员已退出")
    void testSwitchTenant_MemberInactive() {
        try (MockedStatic<HopeContextHolder> holderMock = mockStatic(HopeContextHolder.class)) {
            Customer mockCustomer = mock(Customer.class);
            when(mockCustomer.getId()).thenReturn(100L);
            holderMock.when(HopeContextHolder::customer).thenReturn(mockCustomer);

            CustomerEntity customer = new CustomerEntity()
                .setId(100L)
                .setUsername("testuser");

            TenantMemberEntity membership = new TenantMemberEntity()
                .setId(1L)
                .setStatus(TenantMemberStatusEnum.TM_INACTIVE);

            SwitchTenantRequest request = new SwitchTenantRequest().setTenantId(2L);

            when(customerRepository.findById(100L)).thenReturn(Optional.of(customer));
            when(tenantMemberRepository.findByCustomerIdAndTenantId(100L, 2L))
                .thenReturn(Optional.of(membership));

            assertThrows(HopeErrorDetailException.class, () ->
                service.switchTenant(loginResponseBuilder, request));
            verify(jwtCustomizer, never()).encode(any());
        }
    }
}
