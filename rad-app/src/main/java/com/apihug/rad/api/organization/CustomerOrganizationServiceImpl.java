// @formatter:off
package com.apihug.rad.api.organization;

import com.apihug.rad.domain.organization.CustomerOrganizationEntity;
import com.apihug.rad.domain.organization.repository.CustomerOrganizationEntityRepository;
import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * Service layer implementation for handling requests from the controller layer {@link com.apihug.rad.api.organization.CustomerOrganizationController}.
 *
 * This class serves as the orchestrator between the web/controller layer and
 * multiple domain/data access layers, implementing the application's business
 * use cases through cross-domain coordination.
 *
 * ARCHITECTURAL GUIDELINES:
 *
 * 1. Data Access Responsibility:
 *  - Complex SQL queries, data composition, and database logic should NOT be
 *    implemented in this service class
 *  - Such database-specific operations must be delegated to the corresponding
 *    repository trait extensions within each domain
 *  - Each domain's repositories serve as the single source of truth for their
 *    respective data access logic
 *
 * 2. Cross-Domain Coordination:
 *  - This service may coordinate and aggregate data from MULTIPLE domain layers
 *  - When business use cases require data from different domains, this service
 *    is responsible for:
 *    a) Invoking the appropriate repositories from each domain
 *    b) Composing/aggregating the results into a cohesive response
 *    c) Managing transactional boundaries across domains when necessary
 *  - Example: An order service may coordinate with User domain (for customer data),
 *    Inventory domain (for stock verification), and Payment domain (for processing)
 *
 * 3. Service Layer Responsibility:
 *  - Act as a thin facade/mediator between controllers and multiple domain layers
 *  - Focus on request mapping, validation coordination, and transaction management
 *  - Delegate to domain-specific repositories for data operations
 *  - Maintain simplicity and clarity - avoid complex business logic here
 *
 * 4. Design Pattern:
 *  - Follow the Facade pattern to provide a unified interface to controllers
 *  - Keep the service layer focused on orchestration across domains, not on
 *    implementation details of any single domain
 */
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "CustomerOrganizationService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
public class CustomerOrganizationServiceImpl implements CustomerOrganizationService {

  private final CustomerOrganizationEntityRepository customerOrganizationRepository;

  public CustomerOrganizationServiceImpl(CustomerOrganizationEntityRepository customerOrganizationRepository) {
    this.customerOrganizationRepository = customerOrganizationRepository;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members}
   * 	<p>{@code 获取组织员工列表}
   * @see CustomerOrganizationService#getOrganizationMembers
   */
  @Override
  public void getOrganizationMembers(PageableResultBuilder<CustomerOrganizationSummary> builder,
      Integer organizationId, GetOrganizationMembersRequest getOrganizationMembersRequest,
      PageRequest pageParameter) {
    // 分页查询组织员工
    Page<CustomerOrganizationEntity> page = customerOrganizationRepository.findByOrganizationId(
        organizationId.longValue(),
        getOrganizationMembersRequest.getStatus(),
        pageParameter);

    // 构建响应
    List<CustomerOrganizationSummary> summaries = page.getContent().stream()
        .map(entity -> new CustomerOrganizationSummary()
            .setId(entity.getId())
            .setCustomerId(entity.getCustomerId())
            .setOrganizationId(entity.getOrganizationId())
            .setDepartmentId(entity.getDepartmentId())
            .setPosition(entity.getPosition())
            .setEmployeeType(entity.getEmployeeType())
            .setStatus(entity.getStatus())
            .setIsDefault(entity.getIsDefault()))
        .collect(Collectors.toList());

    builder.setData(summaries);
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ADD]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members}
   * 	<p>{@code 添加员工到组织}
   * @see CustomerOrganizationService#addMemberToOrganization
   */
  @Override
  public void addMemberToOrganization(SimpleResultBuilder<String> builder, Integer organizationId,
      AddMemberRequest addMemberRequest) {
    // 检查是否已存在
    if (customerOrganizationRepository.existsByCustomerIdAndOrganizationId(
        addMemberRequest.getCustomerId().longValue(), 
        organizationId.longValue())) {
      builder.done();
      return;
    }

    // 创建关联
    CustomerOrganizationEntity entity = new CustomerOrganizationEntity()
        .setCustomerId(addMemberRequest.getCustomerId().longValue())
        .setOrganizationId(organizationId.longValue())
        .setDepartmentId(addMemberRequest.getDepartmentId() != null 
            ? addMemberRequest.getDepartmentId().longValue() 
            : null)
        .setPosition(addMemberRequest.getPosition())
        .setEmployeeType(addMemberRequest.getEmployeeType() != null
            ? addMemberRequest.getEmployeeType()
            : com.apihug.rad.infra.organization.EmployeeTypeEnum.FULL_TIME)
        .setIsDefault(addMemberRequest.getIsDefault());

    customerOrganizationRepository.save(entity);
    builder.done();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_REMOVE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}}
   * 	<p>{@code 从组织移除员工}
   * @see CustomerOrganizationService#removeMemberFromOrganization
   */
  @Override
  public void removeMemberFromOrganization(SimpleResultBuilder<String> builder,
      Integer organizationId, Integer customerId, RemoveMemberRequest removeMemberRequest) {
    customerOrganizationRepository.deleteByCustomerIdAndOrganizationId(
        customerId.longValue(), 
        organizationId.longValue());
    
    builder.done();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_LOCK]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock}
   * 	<p>{@code 锁定/解锁组织员工}
   * @see CustomerOrganizationService#toggleMemberLock
   */
  @Override
  public void toggleMemberLock(SimpleResultBuilder<String> builder, Integer organizationId,
      Integer customerId, ToggleMemberLockRequest toggleMemberLockRequest) {
    customerOrganizationRepository.findByCustomerIdAndOrganizationId(
        customerId.longValue(), 
        organizationId.longValue())
        .ifPresent(entity -> {
          // 切换状态
          CustomerOrgStatusEnum newStatus = entity.getStatus() == CustomerOrgStatusEnum.LOCKED
              ? CustomerOrgStatusEnum.ACTIVE
              : CustomerOrgStatusEnum.LOCKED;
          entity.setStatus(newStatus);
          customerOrganizationRepository.save(entity);
        });
    
    builder.done();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ASSIGN_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles}
   * 	<p>{@code 配置员工角色}
   * @see CustomerOrganizationService#assignMemberRoles
   */
  @Override
  public void assignMemberRoles(SimpleResultBuilder<String> builder, Integer organizationId,
      Integer customerId, AssignMemberRolesRequest assignMemberRolesRequest) {
    // 待实现：需要 CustomerRole 实体支持
    builder.done();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [ORGANIZATION_MEMBER_ASSIGN_MENU]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus}
   * 	<p>{@code 配置员工菜单权限}
   * @see CustomerOrganizationService#assignMemberMenus
   */
  @Override
  public void assignMemberMenus(SimpleResultBuilder<String> builder, Integer organizationId,
      Integer customerId, AssignMemberMenusRequest assignMemberMenusRequest) {
    // 待实现：需要 CustomerMenu 实体支持
    builder.done();
  }
}
