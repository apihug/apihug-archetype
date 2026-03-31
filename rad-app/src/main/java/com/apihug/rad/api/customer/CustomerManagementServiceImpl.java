// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.beans.ResetTokenStore;
import com.apihug.rad.infra.customer.CustomerErrorEnum;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.SimpleResultBuilder;
import java.util.UUID;
import org.springframework.stereotype.Service;



@Template(type = Template.Type.SERVICE, usage = "Customer account management service (platform-level)", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerManagementService",
    kind = Kind.RPC,
    line = 125,
    column = 1)
public class CustomerManagementServiceImpl implements CustomerManagementService {

  private static final long RESET_TOKEN_EXPIRY_MINUTES = 30;

  protected final PasswordEncoder passwordEncoder;
  private final CustomerEntityRepository customerRepository;
  private final ResetTokenStore resetTokenStore;

  public CustomerManagementServiceImpl(
      PasswordEncoder passwordEncoder,
      CustomerEntityRepository customerRepository,
      ResetTokenStore resetTokenStore) {
    this.passwordEncoder = passwordEncoder;
    this.customerRepository = customerRepository;
    this.resetTokenStore = resetTokenStore;
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [CUSTOMER_CREATE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/customers/customers}
   *     <p>{@code 创建新客户}
   * @see CustomerManagementService#createCustomer
   */
  @Override
  public void createCustomer(
      SimpleResultBuilder<CustomerSummary> builder, CreateCustomerRequest createCustomerRequest) {
    // 1. 验证用户名唯一性
    if (customerRepository.existsByUsername(createCustomerRequest.getUsername())) {
      throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_ALREADY_EXISTS).build();
    }

    // 2. 验证邮箱唯一性（如果提供了邮箱）
    if (createCustomerRequest.getEmail() != null &&
        !createCustomerRequest.getEmail().isEmpty() &&
        customerRepository.existsByEmail(createCustomerRequest.getEmail())) {
      throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_ALREADY_EXISTS).build();
    }

    // 3. 创建客户实体（密码使用 BCrypt 加密）
    CustomerEntity entity = new CustomerEntity()
        .setUsername(createCustomerRequest.getUsername())
        .setPasswordHash(passwordEncoder.encode(createCustomerRequest.getPassword()))
        .setEmail(createCustomerRequest.getEmail())
        .setStatus(createCustomerRequest.getStatus() != null
            ? createCustomerRequest.getStatus()
            : CustomerStatusEnum.ACTIVE)
        .setDefaultTenantId(createCustomerRequest.getDefaultTenantId() != null
            ? createCustomerRequest.getDefaultTenantId()
            : 0L);

    // 4. 保存客户
    CustomerEntity saved = customerRepository.save(entity);

    // 5. 返回摘要
    CustomerSummary summary = new CustomerSummary()
        .setId(saved.getId())
        .setUsername(saved.getUsername())
        .setEmail(saved.getEmail())
        .setStatus(saved.getStatus())
        .setTenantId(saved.getDefaultTenantId());

    builder.payload(summary);
  }

  /**
   * @apiNote
   *     <p>{@code /api/customers/auth/forgot-password}
   *     <p>{@code 申请找回密码（发送重置邮件）}
   * @see CustomerManagementService#forgotPassword
   */
  @Override
  public void forgotPassword(
      SimpleResultBuilder<String> builder, ForgotPasswordRequest forgotPasswordRequest) {
    // 无论是否找到用户都返回成功，防止泄露邮箱信息
    customerRepository.findByEmail(forgotPasswordRequest.getEmail())
        .ifPresent(customer -> {
          // 生成重置 token（UUID）
          String token = UUID.randomUUID().toString();
          resetTokenStore.store(token, customer.getId(), RESET_TOKEN_EXPIRY_MINUTES);

          // TODO: 接入邮件服务后替换为真实邮件发送

        });
  }

  /**
   * @apiNote
   *     <p>{@code /api/customers/auth/reset-password}
   *     <p>{@code 重置密码（使用 token）}
   * @see CustomerManagementService#resetPassword
   */
  @Override
  public void resetPassword(
      SimpleResultBuilder<String> builder, ResetPasswordRequest resetPasswordRequest) {
    // 1. 查找并移除 token
    Long customerId = resetTokenStore.removeAndGet(resetPasswordRequest.getToken());
    if (customerId == null) {
      throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.RESET_TOKEN_EXPIRED).build();
    }

    // 2. 查找客户
    CustomerEntity customer = customerRepository.findById(customerId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(
            CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

    // 3. 使用 BCrypt 加密新密码并更新
    customer.setPasswordHash(passwordEncoder.encode(resetPasswordRequest.getPassword()));
    customerRepository.save(customer);
  }
}
