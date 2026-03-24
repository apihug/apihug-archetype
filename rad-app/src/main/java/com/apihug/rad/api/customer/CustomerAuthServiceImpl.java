// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.auth.AuthErrorEnum;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;
import com.apihug.rad.domain.security.CustomerPermissionResolver;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.SimpleResultBuilder;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import hope.common.spring.security.JwtCustomizer;
import java.util.Set;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.stereotype.Service;


@Template(type = Template.Type.SERVICE, usage = "Customer authorization service", percentage = 88)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerAuthService",
    kind = Kind.RPC,
    line = 9,
    column = 1)
public class CustomerAuthServiceImpl implements CustomerAuthService {

    static final Logger logger = LoggerFactory.getLogger(CustomerAuthServiceImpl.class);

  private final CustomerEntityRepository customerRepository;
  private final JwtCustomizer jwtCustomizer;
  private final PasswordEncoder passwordEncoder;
  private final CustomerPermissionResolver permissionResolver;

  public CustomerAuthServiceImpl(
      CustomerEntityRepository customerRepository,
      @org.springframework.context.annotation.Lazy JwtCustomizer jwtCustomizer,
      PasswordEncoder passwordEncoder,
      CustomerPermissionResolver permissionResolver) {
    this.customerRepository = customerRepository;
    this.jwtCustomizer = jwtCustomizer;
    this.passwordEncoder = passwordEncoder;
    this.permissionResolver = permissionResolver;
  }

  @Override
  public void login(SimpleResultBuilder<LoginResponse> builder, LoginRequest loginRequest) {
    // 1. 查找用户
    CustomerEntity customer =
        customerRepository
            .findByUsername(loginRequest.getUsername())
            .orElseThrow(
                () -> HopeErrorDetailException.errorBuilder(AuthErrorEnum.LOGIN_FAIL).build());

    // 2. 验证密码（使用 BCrypt 验证）
    if (!passwordEncoder.matches(loginRequest.getPassword(), customer.getPasswordHash())) {
      throw HopeErrorDetailException.errorBuilder(AuthErrorEnum.LOGIN_FAIL).build();
    }

    // 3. 检查用户状态
    if (CustomerStatusEnum.ACTIVE != customer.getStatus()) {
      throw HopeErrorDetailException.errorBuilder(AuthErrorEnum.ACCOUNT_LOCKED).build();
    }

    // TODO no need pick here
    // 4. 解析权限（新增）
    Set<String> roles = permissionResolver.resolveRoles(customer.getId(), customer.getDefaultTenantId());
    Set<String> authorities = permissionResolver.resolveAuthorities(customer.getId(), customer.getDefaultTenantId());

    // 5. 生成 JWT Token
    // 创建 RadCustomer 对象，包含用户核心信息
    RadCustomer radCustomer = new RadCustomer()
        .setId(customer.getId())
        .setTenantId(customer.getDefaultTenantId())
        .setAccount(customer.getUsername())
        .setName(customer.getUsername())
        .setActive(true);
    radCustomer.setRoles(roles);
    radCustomer.setAuthorities(authorities);

    // 使用 JwtCustomizer 生成 JWT Token
    String accessToken = jwtCustomizer.encode(radCustomer);

    // 5. 构建响应
    LoginResponse response =
        new LoginResponse()
            .setAccessToken(accessToken)
            .setCustomerId(customer.getId())
            .setUsername(customer.getUsername());

    builder.payload(response);
  }

  @Override
  public void logout(SimpleResultBuilder<String> builder) {
    // controller handles response automatically
      // TODO remove this session?
  }
}
