package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.beans.ResetTokenStore;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.SimpleResultBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@DisplayName("客户管理 Service 单元测试（平台级）")
@ExtendWith(MockitoExtension.class)
class CustomerManagementServiceImplTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private CustomerEntityRepository customerRepository;

    @Mock
    private ResetTokenStore resetTokenStore;

    @Mock
    private SimpleResultBuilder<CustomerSummary> summaryBuilder;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    private CustomerManagementServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CustomerManagementServiceImpl(passwordEncoder, customerRepository, resetTokenStore);
    }

    // ========== createCustomer ==========

    @Test
    @DisplayName("创建客户 - 成功")
    void testCreateCustomer_Success() {
        CreateCustomerRequest request = new CreateCustomerRequest()
            .setUsername("newuser")
            .setPassword("password123")
            .setEmail("new@example.com")
            .setStatus(CustomerStatusEnum.ACTIVE);

        CustomerEntity savedEntity = new CustomerEntity()
            .setId(1L)
            .setUsername("newuser")
            .setEmail("new@example.com")
            .setStatus(CustomerStatusEnum.ACTIVE)
            .setDefaultTenantId(0L);

        when(customerRepository.existsByUsername("newuser")).thenReturn(false);
        when(customerRepository.existsByEmail("new@example.com")).thenReturn(false);
        when(passwordEncoder.encode("password123")).thenReturn("$2a$10$encoded");
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(savedEntity);

        service.createCustomer(summaryBuilder, request);

        ArgumentCaptor<CustomerEntity> captor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerRepository).save(captor.capture());
        assertEquals("$2a$10$encoded", captor.getValue().getPasswordHash());
        verify(summaryBuilder).payload(any(CustomerSummary.class));
    }

    @Test
    @DisplayName("创建客户 - 用户名已存在")
    void testCreateCustomer_UsernameExists() {
        CreateCustomerRequest request = new CreateCustomerRequest()
            .setUsername("existing")
            .setPassword("password123");

        when(customerRepository.existsByUsername("existing")).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () ->
            service.createCustomer(summaryBuilder, request));
        verify(customerRepository, never()).save(any());
    }

    @Test
    @DisplayName("创建客户 - 邮箱已存在")
    void testCreateCustomer_EmailExists() {
        CreateCustomerRequest request = new CreateCustomerRequest()
            .setUsername("newuser")
            .setPassword("password123")
            .setEmail("existing@example.com");

        when(customerRepository.existsByUsername("newuser")).thenReturn(false);
        when(customerRepository.existsByEmail("existing@example.com")).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () ->
            service.createCustomer(summaryBuilder, request));
        verify(customerRepository, never()).save(any());
    }

    // ========== forgotPassword ==========

    @Test
    @DisplayName("找回密码 - 邮箱存在")
    void testForgotPassword_EmailExists() {
        ForgotPasswordRequest request = new ForgotPasswordRequest()
            .setEmail("test@example.com");

        when(customerRepository.findByEmail("test@example.com"))
            .thenReturn(Optional.of(new CustomerEntity().setId(1L)));

        service.forgotPassword(stringBuilder, request);

        // 验证 token 被存储到 ResetTokenStore
        verify(resetTokenStore).store(anyString(), eq(1L), eq(30L));
    }

    @Test
    @DisplayName("找回密码 - 邮箱不存在（不泄露）")
    void testForgotPassword_EmailNotExists() {
        ForgotPasswordRequest request = new ForgotPasswordRequest()
            .setEmail("notfound@example.com");

        when(customerRepository.findByEmail("notfound@example.com"))
            .thenReturn(Optional.empty());

        service.forgotPassword(stringBuilder, request);

        // 无论是否找到都返回成功，且不应存储 token
        verify(resetTokenStore, never()).store(anyString(), anyLong(), anyLong());
    }

    // ========== resetPassword ==========

    @Test
    @DisplayName("重置密码 - token 无效")
    void testResetPassword_InvalidToken() {
        ResetPasswordRequest request = new ResetPasswordRequest()
            .setToken("invalid-token")
            .setPassword("newpassword");

        when(resetTokenStore.removeAndGet("invalid-token")).thenReturn(null);

        assertThrows(HopeErrorDetailException.class, () ->
            service.resetPassword(stringBuilder, request));
    }

    @Test
    @DisplayName("重置密码 - 完整流程（forgotPassword + resetPassword）")
    void testResetPassword_FullFlow() {
        // Step 1: forgotPassword 生成 token
        CustomerEntity customer = new CustomerEntity().setId(1L);
        when(customerRepository.findByEmail("test@example.com"))
            .thenReturn(Optional.of(customer));

        ForgotPasswordRequest forgotRequest = new ForgotPasswordRequest()
            .setEmail("test@example.com");
        service.forgotPassword(stringBuilder, forgotRequest);

        // 捕获存储的 token
        ArgumentCaptor<String> tokenCaptor = ArgumentCaptor.forClass(String.class);
        verify(resetTokenStore).store(tokenCaptor.capture(), eq(1L), eq(30L));
        String token = tokenCaptor.getValue();

        // Step 2: resetPassword 使用 token
        when(resetTokenStore.removeAndGet(token)).thenReturn(1L);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(passwordEncoder.encode("newpassword")).thenReturn("$2a$10$newEncoded");
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customer);

        ResetPasswordRequest resetRequest = new ResetPasswordRequest()
            .setToken(token)
            .setPassword("newpassword");
        service.resetPassword(stringBuilder, resetRequest);

        // 验证密码已更新
        verify(customerRepository).save(any(CustomerEntity.class));
        verify(resetTokenStore).removeAndGet(token);
    }
}
