package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("JWT 认证集成测试")
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class JwtAuthenticationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String authToken;

    @BeforeEach
    void setUp() {
        authToken = null;
    }

    @Test
    @DisplayName("BCrypt 密码编码测试")
    void testBCryptEncoding() {
        // 验证 PasswordEncoder 正常工作
        String rawPassword = "admin123";
        String encoded = passwordEncoder.encode(rawPassword);
        
        // 验证编码后的格式
        org.junit.jupiter.api.Assertions.assertTrue(encoded.startsWith("$2a$"));
        org.junit.jupiter.api.Assertions.assertTrue(passwordEncoder.matches(rawPassword, encoded));
        org.junit.jupiter.api.Assertions.assertFalse(passwordEncoder.matches("wrong", encoded));
    }

    @Test
    @DisplayName("JWT 生成测试 - 登录成功")
    void testJwtGeneration_LoginSuccess() throws Exception {
        // Arrange
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("test_admin")
            .setPassword("admin123");

        // Act
        ResultActions result = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value(0))
            .andExpect(jsonPath("$.data.accessToken").exists())
            .andExpect(jsonPath("$.data.customerId").value(1))
            .andExpect(jsonPath("$.data.username").value("test_admin"));

        // 保存 Token 供后续测试使用
        String responseContent = result.andReturn().getResponse().getContentAsString();
        authToken = objectMapper.readTree(responseContent).get("data").get("accessToken").asText();

        // Assert
        result.andDo(print());
    }

    @Test
    @DisplayName("JWT 生成测试 - 密码错误")
    void testJwtGeneration_WrongPassword() throws Exception {
        // Arrange
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("test_admin")
            .setPassword("wrong_password");

        // Act & Assert - 错误时返回 500
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().is5xxServerError())
            .andDo(print());
    }

    @Test
    @DisplayName("JWT 生成测试 - 用户不存在")
    void testJwtGeneration_UserNotFound() throws Exception {
        // Arrange
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("nonexistent_user")
            .setPassword("password");

        // Act & Assert - 错误时返回 500
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().is5xxServerError())
            .andDo(print());
    }

    @Test
    @DisplayName("JWT 生成测试 - 账户锁定")
    void testJwtGeneration_AccountLocked() throws Exception {
        // Arrange
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("locked_user")
            .setPassword("user123");

        // Act & Assert - 错误时返回 500
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().is5xxServerError())
            .andDo(print());
    }

    @Test
    @DisplayName("JWT 使用测试 - 获取当前客户信息")
    void testJwtUsage_GetCurrentCustomerInfo() throws Exception {
        // Arrange - 先登录获取 Token
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("test_admin")
            .setPassword("admin123");

        String responseContent = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        String token = objectMapper.readTree(responseContent).get("data").get("accessToken").asText();

        // Act - 使用 Token 获取当前客户信息
        mockMvc.perform(get("/api/customer/current-user-info")
                .header("Authorization", "Bearer " + token))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value(0))
            .andExpect(jsonPath("$.data.user.customerId").exists())
            .andExpect(jsonPath("$.data.user.username").value("test_admin"))
            .andDo(print());
    }

    @Test
    @DisplayName("JWT 使用测试 - 获取客户信息")
    void testJwtUsage_GetCustomerInfo() throws Exception {
        // Arrange - 先登录获取 Token
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("test_admin")
            .setPassword("admin123");

        String responseContent = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        String token = objectMapper.readTree(responseContent).get("data").get("accessToken").asText();

        // Act - 使用 Token 获取客户信息
        mockMvc.perform(get("/api/customer/info")
                .header("Authorization", "Bearer " + token))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value(0))
            .andExpect(jsonPath("$.data.customerId").exists())
            .andExpect(jsonPath("$.data.username").exists())
            .andDo(print());
    }

    @Test
    @DisplayName("JWT 使用测试 - 无效 Token")
    void testJwtUsage_InvalidToken() throws Exception {
        // Act & Assert - 使用无效 Token 会触发 Spring Security 异常
        // Spring Security 的 JwtFilter 会解析 Token 失败并抛出 BadJwtException
        // 这是预期的行为，表示 Token 验证失败
        org.junit.jupiter.api.Assertions.assertThrows(
            org.springframework.security.oauth2.jwt.BadJwtException.class,
            () -> {
                mockMvc.perform(get("/api/customer/info")
                        .header("Authorization", "Bearer invalid-token"));
            });
    }

    @Test
    @DisplayName("JWT 使用测试 - 无 Token")
    void testJwtUsage_NoToken() throws Exception {
        // Act & Assert - 不使用 Token
        mockMvc.perform(get("/api/customer/info"))
            .andExpect(status().is4xxClientError())
            .andDo(print());
    }

    @Test
    @DisplayName("JWT 登出测试")
    void testJwtLogout() throws Exception {
        // Arrange - 先登录获取 Token
        LoginRequest loginRequest = new LoginRequest()
            .setUsername("test_admin")
            .setPassword("admin123");

        String responseContent = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        String token = objectMapper.readTree(responseContent).get("data").get("accessToken").asText();

        // Act - 登出
        mockMvc.perform(post("/api/auth/logout")
                .header("Authorization", "Bearer " + token))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value(0))
            .andDo(print());
    }
}
