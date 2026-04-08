// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.security.CustomerPermissionResolver;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.auth.AuthErrorEnum;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.JwtCustomizer;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
  private final TenantEntityRepository tenantRepository;
  private final TenantMemberEntityRepository tenantMemberRepository;
  private final JwtCustomizer jwtCustomizer;
  private final PasswordEncoder passwordEncoder;
  private final CustomerPermissionResolver permissionResolver;

  public CustomerAuthServiceImpl(
      CustomerEntityRepository customerRepository,
      TenantEntityRepository tenantRepository,
      TenantMemberEntityRepository tenantMemberRepository,
      @org.springframework.context.annotation.Lazy JwtCustomizer jwtCustomizer,
      PasswordEncoder passwordEncoder,
      CustomerPermissionResolver permissionResolver) {
    this.customerRepository = customerRepository;
    this.tenantRepository = tenantRepository;
    this.tenantMemberRepository = tenantMemberRepository;
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

    // 3.5 解析有效租户：优先默认租户，不可用则降级到其他活跃租户
    Long effectiveTenantId = resolveEffectiveTenant(customer);

    // TODO no need pick here
    // 4. 解析权限（新增）
    Set<String> roles = permissionResolver.resolveRoles(customer.getId(), effectiveTenantId);
    Set<String> authorities =
        permissionResolver.resolveAuthorities(customer.getId(), effectiveTenantId);

    // 5. 生成 JWT Token
    // 创建 RadCustomer 对象，包含用户核心信息
    RadCustomer radCustomer =
        new RadCustomer()
            .setId(customer.getId())
            .setTenantId(effectiveTenantId)
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

  /**
   * 解析有效租户 ID。
   *
   * <ol>
   *   <li>优先使用 defaultTenantId，验证租户状态 ACTIVE 且成员状态 TM_ACTIVE
   *   <li>默认租户不可用时，降级到该用户的其他活跃租户
   *   <li>如果降级成功，同步更新 defaultTenantId
   *   <li>无任何可用租户则返回 null（平台用户可以无租户登录）
   * </ol>
   */
  private Long resolveEffectiveTenant(CustomerEntity customer) {
    Long defaultTenantId = customer.getDefaultTenantId();

    // 尝试默认租户
    if (defaultTenantId != null) {
      boolean defaultValid =
          tenantRepository
                  .findById(defaultTenantId)
                  .filter(t -> TenantStatusEnum.ACTIVE == t.getStatus())
                  .isPresent()
              && tenantMemberRepository
                  .findByCustomerIdAndTenantId(customer.getId(), defaultTenantId)
                  .filter(m -> TenantMemberStatusEnum.TM_ACTIVE == m.getStatus())
                  .isPresent();
      if (defaultValid) {
        return defaultTenantId;
      }
    }

    // 降级：查找该用户所有活跃成员关系，匹配一个活跃租户
    List<TenantMemberEntity> activeMembers =
        tenantMemberRepository.findByCustomerIdAndStatus(
            customer.getId(), TenantMemberStatusEnum.TM_ACTIVE);

    for (TenantMemberEntity member : activeMembers) {
      boolean tenantActive =
          tenantRepository
              .findById(member.getTenantId())
              .filter(t -> TenantStatusEnum.ACTIVE == t.getStatus())
              .isPresent();
      if (tenantActive) {
        // 降级成功，同步更新 defaultTenantId
        customer.setDefaultTenantId(member.getTenantId());
        customerRepository.save(customer);
        return member.getTenantId();
      }
    }

    // 无可用租户，返回 null（平台用户或新用户可以无租户登录）
    return null;
  }
}
