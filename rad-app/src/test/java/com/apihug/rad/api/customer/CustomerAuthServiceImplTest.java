package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.security.RadPermissionResolver;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.JwtCustomizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("客户认证 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class CustomerAuthServiceImplTest {

    @Mock
    private CustomerEntityRepository customerRepository;

    @Mock
    private JwtCustomizer jwtCustomizer;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RadPermissionResolver permissionResolver;

    @Mock
    private SimpleResultBuilder<LoginResponse> loginBuilder;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    private CustomerAuthServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CustomerAuthServiceImpl(customerRepository, jwtCustomizer, passwordEncoder, permissionResolver);
    }

    // ========== login ==========

    @Test
    @DisplayName("登录 - 成功")
    void testLogin_Success() {
        LoginRequest request = new LoginRequest()
            .setUsername("testuser")
            .setPassword("password123");

        CustomerEntity customer = new CustomerEntity()
            .setId(1L)
            .setUsername("testuser")
            .setPasswordHash("$2a$10$hashedPassword")
            .setStatus(CustomerStatusEnum.ACTIVE)
            .setDefaultTenantId(1L);

        when(customerRepository.findByUsername("testuser")).thenReturn(Optional.of(customer));
        when(passwordEncoder.matches("password123", "$2a$10$hashedPassword")).thenReturn(true);
        when(jwtCustomizer.encode(any())).thenReturn("jwt-token-123");
        when(permissionResolver.resolveRoles(1L, 1L)).thenReturn(Collections.emptySet());
        when(permissionResolver.resolveAuthorities(1L, 1L)).thenReturn(Collections.emptySet());

        service.login(loginBuilder, request);

        ArgumentCaptor<LoginResponse> captor = ArgumentCaptor.forClass(LoginResponse.class);
        verify(loginBuilder).payload(captor.capture());
        LoginResponse response = captor.getValue();
        assertEquals("jwt-token-123", response.getAccessToken());
        assertEquals(1L, response.getCustomerId());
        assertEquals("testuser", response.getUsername());
    }

    @Test
    @DisplayName("登录 - 用户不存在")
    void testLogin_UserNotFound() {
        LoginRequest request = new LoginRequest()
            .setUsername("nonexistent")
            .setPassword("password123");

        when(customerRepository.findByUsername("nonexistent")).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () ->
            service.login(loginBuilder, request));
        verify(jwtCustomizer, never()).encode(any());
    }

    @Test
    @DisplayName("登录 - 密码错误")
    void testLogin_WrongPassword() {
        LoginRequest request = new LoginRequest()
            .setUsername("testuser")
            .setPassword("wrongpassword");

        CustomerEntity customer = new CustomerEntity()
            .setId(1L)
            .setUsername("testuser")
            .setPasswordHash("$2a$10$hashedPassword")
            .setStatus(CustomerStatusEnum.ACTIVE);

        when(customerRepository.findByUsername("testuser")).thenReturn(Optional.of(customer));
        when(passwordEncoder.matches("wrongpassword", "$2a$10$hashedPassword")).thenReturn(false);

        assertThrows(HopeErrorDetailException.class, () ->
            service.login(loginBuilder, request));
        verify(jwtCustomizer, never()).encode(any());
    }

    @Test
    @DisplayName("登录 - 账号被锁定")
    void testLogin_AccountLocked() {
        LoginRequest request = new LoginRequest()
            .setUsername("testuser")
            .setPassword("password123");

        CustomerEntity customer = new CustomerEntity()
            .setId(1L)
            .setUsername("testuser")
            .setPasswordHash("$2a$10$hashedPassword")
            .setStatus(CustomerStatusEnum.LOCKED);

        when(customerRepository.findByUsername("testuser")).thenReturn(Optional.of(customer));
        when(passwordEncoder.matches("password123", "$2a$10$hashedPassword")).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () ->
            service.login(loginBuilder, request));
        verify(jwtCustomizer, never()).encode(any());
    }

    // ========== logout ==========

    @Test
    @DisplayName("登出 - 成功")
    void testLogout_Success() {
        service.logout(stringBuilder);
    }
}
