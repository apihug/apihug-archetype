// @formatter:off
package com.apihug.rad.api.customer;
import java.lang.Override;
import java.lang.SuppressWarnings;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.customer.CustomerErrorEnum;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.context.HopeContextHolder;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Customer API extension service")
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerService",
    kind = Kind.RPC,
    line = 152,
    column = 1)
public class CustomerServiceImpl implements CustomerService {

  private final CustomerEntityRepository customerRepository;


  public CustomerServiceImpl(CustomerEntityRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  /**
   * @apiNote
   *     <p>{@code /api/customer/info}
   *     <p>{@code 查询用户信息}
   * @see CustomerService#info
   */
  @Override
  public void info(SimpleResultBuilder<CustomerInfo> builder) {
    CustomerInfo info = new CustomerInfo();
    info.setCustomerId(1L).setTenantId(1L).setUsername("jake");
    // TODO fixme
    // info.setAuthorities()
    // info.setRoles();
    builder.payload(info);
  }


/**
 * @apiNote
 * 	<p>{@code /api/customer/current-user-info}
 * 	<p>{@code 获取当前用户完整信息（包含权限、角色、部门）}
 * @see CustomerService#getCurrentUserInfo
 */
@Override
public void getCurrentUserInfo(SimpleResultBuilder<CurrentUserInfo> builder) {
    // 获取当前登录用户
    Long customerId = (Long) HopeContextHolder.customer().getId();

    CustomerEntity customer = customerRepository.findById(customerId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

    // 构建用户信息
    CurrentUserInfo userInfo = new CurrentUserInfo()
        .setUser(new CustomerInfo()
            .setCustomerId(customer.getId())
            .setUsername(customer.getUsername())
            .setTenantId(customer.getDefaultTenantId()))
        // TODO: 加载用户角色列表
        // TODO: 加载用户权限列表
        // TODO: 加载用户部门信息
        .setCurrentOrganization(new OrganizationInfo()
            .setId(1L)
            .setOrganizationCode("default")
            .setOrganizationName("默认组织"));

    builder.payload(userInfo);
}

/**
 * @apiNote
 * 	<p>{@code /api/customer/user-organizations}
 * 	<p>{@code 获取用户的所有组织列表}
 * @see CustomerService#getUserOrganizations
 */
@Override
public void getUserOrganizations(SimpleResultBuilder<OrganizationList> builder) {
    // TODO: 从数据库加载用户组织列表
    OrganizationList list = new OrganizationList();
    builder.payload(list);
}

/**
 * @apiNote
 * 	<p>{@code /api/customer/switch-organization}
 * 	<p>{@code 切换到指定组织}
 * @see CustomerService#switchOrganization
 */
@Override
public void switchOrganization(SimpleResultBuilder<LoginResponse> builder, SwitchOrganizationRequest switchOrganizationRequest) {
    // TODO: 验证用户是否有该组织权限
    // TODO: 生成新 Token（包含新组织 ID）

    LoginResponse response = new LoginResponse();
    builder.payload(response);
}


}
