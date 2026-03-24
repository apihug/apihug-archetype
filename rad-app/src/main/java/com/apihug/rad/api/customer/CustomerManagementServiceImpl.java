// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.beans.PasswordEncoder;
import com.apihug.rad.infra.customer.CustomerErrorEnum;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;



@Template(type = Template.Type.SERVICE, usage = "Customer account management service", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerManagementService",
    kind = Kind.RPC,
    line = 125,
    column = 1)
public class CustomerManagementServiceImpl implements CustomerManagementService {

  protected final PasswordEncoder passwordEncoder;
  private final CustomerEntityRepository customerRepository;

  public CustomerManagementServiceImpl(
      PasswordEncoder passwordEncoder, CustomerEntityRepository customerRepository) {
    this.passwordEncoder = passwordEncoder;
    this.customerRepository = customerRepository;
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
      throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.USER_ALREADY_EXISTS).build();
    }

    // 2. 验证邮箱唯一性（如果提供了邮箱）
    if (createCustomerRequest.getEmail() != null &&
        !createCustomerRequest.getEmail().isEmpty() &&
        customerRepository.existsByEmail(createCustomerRequest.getEmail())) {
      throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.USER_ALREADY_EXISTS).build();
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
   *     <p>{@code /api/customers/customers/{customerId}}
   *     <p>{@code 获取客户详情}
   * @see CustomerManagementService#getCustomer
   */
  @Override
  public void getCustomer(SimpleResultBuilder<CustomerDetail> builder, Integer customerId) {

    //This customer must be this TENANT

    // 1. 查找客户
    CustomerEntity entity = customerRepository.findById(customerId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

    // 2. 构建详情（不返回密码哈希）
    CustomerDetail detail = new CustomerDetail()
        .setId(entity.getId())
        .setUsername(entity.getUsername())
        .setEmail(entity.getEmail())
        .setStatus(entity.getStatus())
        .setDefaultTenantId(entity.getDefaultTenantId())
        .setCreatedAt(entity.getCreatedAt())
        .setUpdatedAt(entity.getUpdatedAt());

    builder.payload(detail);
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [CUSTOMER_UPDATE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/customers/customers/{customerId}}
   *     <p>{@code 更新客户信息}
   * @see CustomerManagementService#updateCustomer
   */
  @Override
  public void updateCustomer(
      SimpleResultBuilder<String> builder,
      Integer customerId,
      UpdateCustomerRequest updateCustomerRequest) {
    // 1. 查找客户
    CustomerEntity entity = customerRepository.findById(customerId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

    // 2. 更新邮箱（如果提供了且不同）
    if (updateCustomerRequest.getEmail() != null &&
        !updateCustomerRequest.getEmail().equals(entity.getEmail())) {
      // 验证邮箱唯一性
      if (customerRepository.existsByEmail(updateCustomerRequest.getEmail())) {
        throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.USER_ALREADY_EXISTS).build();
      }
      entity.setEmail(updateCustomerRequest.getEmail());
    }

    // 3. 更新状态
    if (updateCustomerRequest.getStatus() != null) {
      entity.setStatus(updateCustomerRequest.getStatus());
    }

    // 4. 保存
    customerRepository.save(entity);
    builder.done();
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [CUSTOMER_DELETE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/customers/customers/{customerId}}
   *     <p>{@code 删除客户（软删除）}
   * @see CustomerManagementService#deleteCustomer
   */
  @Override
  public void deleteCustomer(SimpleResultBuilder<String> builder, Integer customerId) {
    // 1. 查找客户
    CustomerEntity entity = customerRepository.findById(customerId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

    // 2. 软删除
    entity.setDeleted(true)
        .setDeletedAt(LocalDateTime.now())
        .setDeletedBy(0L); // TODO: 从当前用户上下文获取

    customerRepository.save(entity);
    builder.done();
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [CUSTOMER_VIEW]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/customers/customers/search}
   *     <p>{@code 搜索客户（分页）}
   * @see CustomerManagementService#searchCustomers
   */
  @Override
  public void searchCustomers(
      PageableResultBuilder<CustomerSummary> builder,
      SearchCustomersRequest searchCustomersRequest,
      PageRequest pageParameter) {
    // 使用 Repository trait 中的搜索方法
    Page<CustomerEntity> page = customerRepository.searchUsers(
        searchCustomersRequest.getKeyword(),
        searchCustomersRequest.getStatus(),
        pageParameter);

    // 构建响应
    builder.setPageIndex(pageParameter.getPage())
           .setPageSize(pageParameter.getSize())
           .setTotalCount(page.getTotalElements())
           .setTotalPage(page.getTotalPages())
           .setData(page.getContent().stream()
               .map(e -> new CustomerSummary()
                   .setId(e.getId())
                   .setUsername(e.getUsername())
                   .setEmail(e.getEmail())
                   .setStatus(e.getStatus())
                   .setTenantId(e.getDefaultTenantId()))
               .collect(Collectors.toList()));
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
    // 查找客户（不泄露邮箱是否存在）
    customerRepository.findByEmail(forgotPasswordRequest.getEmail())
        .ifPresent(customer -> {
          // TODO: 生成重置 token 并发送邮件
          // 为了安全，即使找到用户也不立即返回错误
        });

    // 无论是否找到用户都返回成功，防止泄露邮箱信息
    builder.done();
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
    // TODO: 验证 token 有效性
    // TODO: 验证 token 是否过期
    // TODO: 使用 BCrypt 加密新密码
    // TODO: 更新密码
    builder.done();
  }
}
