// @formatter:off
package com.apihug.rad.api.customer;

import java.lang.Override;
import java.lang.SuppressWarnings;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.domain.tenant.MemberRoleEntity;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.MemberRoleEntityRepository;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.infra.customer.CustomerErrorEnum;
import com.apihug.rad.infra.security.RadCustomer;
import com.apihug.rad.domain.security.CustomerPermissionResolver;
import com.apihug.rad.infra.tenant.TenantMemberErrorEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.JwtCustomizer;
import hope.common.spring.security.context.HopeContextHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Template(type = Template.Type.SERVICE, usage = "Customer API extension service")
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerService",
    kind = Kind.RPC,
    line = 54,
    column = 1)
public class CustomerServiceImpl implements CustomerService {

  private final CustomerEntityRepository customerRepository;
  private final TenantMemberEntityRepository tenantMemberRepository;
  private final TenantEntityRepository tenantRepository;
  private final JwtCustomizer jwtCustomizer;
  private final CustomerPermissionResolver permissionResolver;
  private final MemberRoleEntityRepository memberRoleRepository;
  private final RoleEntityRepository roleRepository;
  private final DepartmentEntityRepository departmentRepository;

  public CustomerServiceImpl(
      CustomerEntityRepository customerRepository,
      TenantMemberEntityRepository tenantMemberRepository,
      TenantEntityRepository tenantRepository,
      @org.springframework.context.annotation.Lazy JwtCustomizer jwtCustomizer,
      CustomerPermissionResolver permissionResolver,
      MemberRoleEntityRepository memberRoleRepository,
      RoleEntityRepository roleRepository,
      DepartmentEntityRepository departmentRepository) {
    this.customerRepository = customerRepository;
    this.tenantMemberRepository = tenantMemberRepository;
    this.tenantRepository = tenantRepository;
    this.jwtCustomizer = jwtCustomizer;
    this.permissionResolver = permissionResolver;
    this.memberRoleRepository = memberRoleRepository;
    this.roleRepository = roleRepository;
    this.departmentRepository = departmentRepository;
  }

  /**
   * @apiNote
   *     <p>{@code /api/customer/info}
   *     <p>{@code 查询当前客户信息}
   * @see CustomerService#info
   */
  @Override
  public void info(SimpleResultBuilder<CustomerInfo> builder) {
    Long customerId = (Long) HopeContextHolder.customer().getId();
    CustomerEntity customer =
        customerRepository
            .findById(customerId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND)
                        .build());

    CustomerInfo info =
        new CustomerInfo()
            .setCustomerId(customer.getId())
            .setTenantId(customer.getDefaultTenantId())
            .setUsername(customer.getUsername());
    builder.payload(info);
  }

  /**
   * @apiNote
   *     <p>{@code /api/customer/current-info}
   *     <p>{@code 获取当前客户完整信息（包含权限、角色、部门、当前租户）}
   * @see CustomerService#getCurrentCustomerInfo
   */
  @Override
  public void getCurrentCustomerInfo(SimpleResultBuilder<CurrentCustomerInfo> builder) {

    // TODO this is current customer:
    RadCustomer contextCustomer = HopeContextHolder.customer();

    Long customerId = contextCustomer.getId();

    CustomerEntity customer =
        customerRepository
            .findById(customerId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND)
                        .build());

    // 获取当前租户信息
    TenantInfo currentTenant = null;
    if (customer.getDefaultTenantId() != null && customer.getDefaultTenantId() > 0) {
      currentTenant =
          tenantRepository
              .findById(customer.getDefaultTenantId())
              .map(
                  t ->
                      new TenantInfo()
                          .setId(t.getId())
                          .setTenantCode(t.getTenantCode())
                          .setTenantName(t.getTenantName())
                          .setIsDefault(true)
                          .setIsPlatform(t.getIsPlatform()))
              .orElse(null);
    }

    // 加载当前租户下的成员信息（角色、权限、部门）
    List<RoleInfo> roles = new ArrayList<>();
    List<String> authorityList = new ArrayList<>();
    DepartmentInfo departmentInfo = null;

    Long currentTenantId = contextCustomer.getTenantId();

    if (customer.getDefaultTenantId() != null && customer.getDefaultTenantId() > 0) {
      java.util.Optional<TenantMemberEntity> memberOpt =
          tenantMemberRepository.findByCustomerIdAndTenantId(
              customerId, customer.getDefaultTenantId());
      if (memberOpt.isPresent()) {
        TenantMemberEntity m = memberOpt.get();
        // 加载 RBAC 角色
        List<MemberRoleEntity> memberRoles = memberRoleRepository.findByMemberId(m.getId());
        if (!memberRoles.isEmpty()) {
          List<Long> roleIds =
              memberRoles.stream().map(MemberRoleEntity::getRoleId).collect(Collectors.toList());
          List<RoleEntity> roleEntities = roleRepository.findAllById(roleIds);
          roleEntities.forEach(
              r ->
                  roles.add(
                      new RoleInfo()
                          .setId(r.getId())
                          .setRoleCode(r.getRoleCode())
                          .setRoleName(r.getRoleName())));
        }

        // 加载部门信息
        if (m.getDepartmentId() != null && m.getDepartmentId() > 0) {
          departmentInfo =
              departmentRepository
                  .findById(m.getDepartmentId())
                  .map(
                      dept ->
                          new DepartmentInfo()
                              .setId(dept.getId())
                              .setDeptCode(dept.getDeptCode())
                              .setDeptName(dept.getDeptName())
                              .setParentId(dept.getParentId()))
                  .orElse(null);
        }
      }

      // 解析权限
      Set<String> authorities =
          permissionResolver.resolveAuthorities(customerId, customer.getDefaultTenantId());
      authorityList.addAll(authorities);
    }

    // 提取角色代码列表用于 CustomerInfo
    List<String> roleCodes = roles.stream().map(RoleInfo::getRoleCode).collect(Collectors.toList());

    CurrentCustomerInfo customerInfo =
        new CurrentCustomerInfo()
            .setCustomer(
                new CustomerInfo()
                    .setCustomerId(customer.getId())
                    .setUsername(customer.getUsername())
                    .setTenantId(customer.getDefaultTenantId())
                    .setRoles(roleCodes)
                    .setAuthorities(authorityList))
            .setRoles(roles)
            .setAuthorities(authorityList)
            .setDepartment(departmentInfo)
            .setCurrentTenant(currentTenant);

    builder.payload(customerInfo);
  }

  /**
   * @apiNote
   *     <p>{@code /api/customer/tenants}
   *     <p>{@code 获取客户加入的所有租户列表}
   * @see CustomerService#getCustomerTenants
   */
  @Override
  public void getCustomerTenants(SimpleResultBuilder<TenantList> builder) {
    Long customerId = (Long) HopeContextHolder.customer().getId();

    // 查询客户加入的所有租户成员关系
    List<TenantMemberEntity> memberships = tenantMemberRepository.findByCustomerId(customerId);

    // 批量加载所有租户详情，避免 N+1
    List<Long> tenantIds =
        memberships.stream().map(TenantMemberEntity::getTenantId).collect(Collectors.toList());
    Map<Long, TenantEntity> tenantMap =
        tenantRepository.findAllById(tenantIds).stream()
            .collect(Collectors.toMap(TenantEntity::getId, t -> t));

    // 组装租户信息
    List<TenantInfo> tenantInfos =
        memberships.stream()
            .map(
                m -> {
                  TenantInfo info =
                      new TenantInfo().setId(m.getTenantId()).setIsDefault(m.getIsDefault());
                  TenantEntity t = tenantMap.get(m.getTenantId());
                  if (t != null) {
                    info.setTenantCode(t.getTenantCode())
                        .setTenantName(t.getTenantName())
                        .setIsPlatform(t.getIsPlatform());
                  }
                  return info;
                })
            .collect(Collectors.toList());

    // 查找默认租户 ID
    Long defaultTenantId =
        memberships.stream()
            .filter(TenantMemberEntity::getIsDefault)
            .map(TenantMemberEntity::getTenantId)
            .findFirst()
            .orElse(0L);

    TenantList list = new TenantList().setTenants(tenantInfos).setDefaultTenantId(defaultTenantId);
    builder.payload(list);
  }

  /**
   * @apiNote
   *     <p>{@code /api/customer/switch-tenant}
   *     <p>{@code 切换到指定租户，重新签发 Token}
   * @see CustomerService#switchTenant
   */
  @Transactional
  @Override
  public void switchTenant(
      SimpleResultBuilder<LoginResponse> builder, SwitchTenantRequest switchTenantRequest) {

    // TODO this is current customer:
    RadCustomer contextCustomer = HopeContextHolder.customer();

    Long customerId = contextCustomer.getId();
    Long currentTenantId = contextCustomer.getTenantId();
    Long targetTenantId = switchTenantRequest.getTenantId();

    // 1. 验证客户存在
    CustomerEntity customer =
        customerRepository
            .findById(customerId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND)
                        .build());

    // 2. 验证客户是该租户的成员且状态正常
    TenantMemberEntity membership =
        tenantMemberRepository
            .findByCustomerIdAndTenantId(customerId, targetTenantId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND)
                        .build());

    if (membership.getStatus() == TenantMemberStatusEnum.TM_LOCKED) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_LOCKED).build();
    }

    if (membership.getStatus() == TenantMemberStatusEnum.TM_INACTIVE) {
      throw HopeErrorDetailException.errorBuilder(TenantMemberErrorEnum.MEMBER_NOT_FOUND).build();
    }

    // 3. 更新客户默认租户
    customer.setDefaultTenantId(targetTenantId);
    customerRepository.save(customer);

    // TODO no need to pick here
    // 4. 解析权限并重新生成 JWT Token（包含新租户 ID + 新权限）
    Set<String> roles = permissionResolver.resolveRoles(customer.getId(), targetTenantId);
    Set<String> authorities =
        permissionResolver.resolveAuthorities(customer.getId(), targetTenantId);

    RadCustomer radCustomer =
        new RadCustomer()
            .setId(customer.getId())
            .setTenantId(targetTenantId)
            .setAccount(customer.getUsername())
            .setName(customer.getUsername())
            .setActive(true);
    radCustomer.setRoles(roles);
    radCustomer.setAuthorities(authorities);

    String accessToken = jwtCustomizer.encode(radCustomer);

    // 5. 构建响应
    LoginResponse response =
        new LoginResponse()
            .setAccessToken(accessToken)
            .setCustomerId(customer.getId())
            .setUsername(customer.getUsername());

    builder.payload(response);
  }
}
