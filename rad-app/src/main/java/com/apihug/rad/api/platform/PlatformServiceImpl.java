// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.domain.platform.PlatformMemberEntity;
import com.apihug.rad.domain.platform.repository.PlatformMemberEntityRepository;
import com.apihug.rad.infra.customer.CustomerErrorEnum;
import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberErrorEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * <p>Service layer implementation for handling requests from the controller layer {@link
 * com.apihug.rad.api.platform.PlatformController}.
 *
 * <p>This class serves as the orchestrator between the web/controller layer and multiple
 * domain/data access layers, implementing the application's business use cases through cross-domain
 * coordination.
 *
 * <p>ARCHITECTURAL GUIDELINES:
 *
 * <p>1. Data Access Responsibility: - Complex SQL queries, data composition, and database logic
 * should NOT be implemented in this service class - Such database-specific operations must be
 * delegated to the corresponding repository trait extensions within each domain - Each domain's
 * repositories serve as the single source of truth for their respective data access logic
 *
 * <p>2. Cross-Domain Coordination: - This service may coordinate and aggregate data from MULTIPLE
 * domain layers - When business use cases require data from different domains, this service is
 * responsible for: a) Invoking the appropriate repositories from each domain b)
 * Composing/aggregating the results into a cohesive response c) Managing transactional boundaries
 * across domains when necessary - Example: An order service may coordinate with User domain (for
 * customer data), Inventory domain (for stock verification), and Payment domain (for processing)
 *
 * <p>3. Service Layer Responsibility: - Act as a thin facade/mediator between controllers and
 * multiple domain layers - Focus on request mapping, validation coordination, and transaction
 * management - Delegate to domain-specific repositories for data operations - Maintain simplicity
 * and clarity - avoid complex business logic here
 *
 * <p>4. Design Pattern: - Follow the Facade pattern to provide a unified interface to controllers -
 * Keep the service layer focused on orchestration across domains, not on implementation details of
 * any single domain
 */
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "PlatformService",
    kind = Kind.RPC,
    line = 10,
    column = 1)
@Template(type = Template.Type.SERVICE, usage = "Platform member management", percentage = 90)
public class PlatformServiceImpl implements PlatformService {

  private final PlatformMemberEntityRepository platformMemberRepository;
  private final CustomerEntityRepository customerRepository;

  public PlatformServiceImpl(
      PlatformMemberEntityRepository platformMemberRepository,
      CustomerEntityRepository customerRepository) {
    this.platformMemberRepository = platformMemberRepository;
    this.customerRepository = customerRepository;
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [PLATFORM_MEMBER_VIEW]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/platforms/members}
   *     <p>{@code 获取平台成员列表，支持状态筛选和关键词搜索}
   * @see PlatformService#getPlatformMembers
   */
  @Override
  public void getPlatformMembers(
      PageableResultBuilder<PlatformMemberInfo> builder,
      GetPlatformMembersRequest getPlatformMembersRequest,
      PageRequest pageParameter) {
    // 使用 trait 中的分页搜索方法
    Page<PlatformMemberEntity> page =
        platformMemberRepository.searchPlatformMembers(
            getPlatformMembersRequest.getStatus(),
            getPlatformMembersRequest.getPlatformRole(),
            pageParameter);

    // 批量加载客户信息，避免 N+1
    List<Long> customerIds =
        page.getContent().stream()
            .map(PlatformMemberEntity::getCustomerId)
            .collect(Collectors.toList());
    Map<Long, CustomerEntity> customerMap =
        customerRepository.findAllById(customerIds).stream()
            .collect(Collectors.toMap(CustomerEntity::getId, c -> c));

    // 构建响应
    builder
        .setPageIndex(pageParameter.getPage())
        .setPageSize(pageParameter.getSize())
        .setTotalCount(page.getTotalElements())
        .setTotalPage(page.getTotalPages())
        .setData(
            page.getContent().stream()
                .map(
                    m -> {
                      PlatformMemberInfo info =
                          new PlatformMemberInfo()
                              .setId(m.getId())
                              .setCustomerId(m.getCustomerId())
                              .setPlatformRole(m.getPlatformRole())
                              .setStatus(m.getStatus())
                              .setCreatedAt(m.getCreatedAt());
                      CustomerEntity c = customerMap.get(m.getCustomerId());
                      if (c != null) {
                        info.setCustomerUsername(c.getUsername()).setCustomerEmail(c.getEmail());
                      }
                      return info;
                    })
                .collect(Collectors.toList()));
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [PLATFORM_MEMBER_ADD]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/platforms/members}
   *     <p>{@code 将指定客户添加为平台成员，并设置平台角色}
   * @see PlatformService#addPlatformMember
   */
  @Transactional
  @Override
  public void addPlatformMember(
      SimpleResultBuilder<String> builder, AddPlatformMemberRequest addPlatformMemberRequest) {
    Long customerId = addPlatformMemberRequest.getCustomerId();

    // 验证客户存在
    CustomerEntity customer =
        customerRepository
            .findById(customerId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND)
                        .build());

    // 验证成员关系不重复
    if (platformMemberRepository.existsByCustomerId(customerId)) {
      throw HopeErrorDetailException.errorBuilder(
              PlatformMemberErrorEnum.PLATFORM_MEMBER_ALREADY_EXISTS)
          .build();
    }

    // 确定平台角色
    CustomerPlatformTypeEnum role =
        addPlatformMemberRequest.getPlatformRole() != null
            ? addPlatformMemberRequest.getPlatformRole()
            : CustomerPlatformTypeEnum.MEMBER;

    // 创建平台成员记录
    PlatformMemberEntity member =
        new PlatformMemberEntity()
            .setCustomerId(customerId)
            .setPlatformRole(role)
            .setStatus(PlatformMemberStatusEnum.PM_ACTIVE);
    platformMemberRepository.save(member);

    customerRepository.updateCustomerPlatformType(customerId, role.title());
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [PLATFORM_MEMBER_REMOVE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/platforms/members/{memberId}}
   *     <p>{@code 移除平台成员，同时重置客户的 platform_type 为 NA。OWNER 角色不允许被移除}
   * @see PlatformService#removePlatformMember
   */
  @Transactional
  @Override
  public void removePlatformMember(SimpleResultBuilder<String> builder, Long memberId) {
    PlatformMemberEntity member =
        platformMemberRepository
            .findById(memberId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(
                            PlatformMemberErrorEnum.PLATFORM_MEMBER_NOT_FOUND)
                        .build());

    // OWNER 角色不允许被移除
    if (CustomerPlatformTypeEnum.OWNER == member.getPlatformRole()) {
      throw HopeErrorDetailException.errorBuilder(
              PlatformMemberErrorEnum.PLATFORM_OWNER_CANNOT_BE_REMOVED)
          .build();
    }

    // 软删除：设置为已移除状态
    member.setStatus(PlatformMemberStatusEnum.PM_INACTIVE);
    platformMemberRepository.save(member);

    // 重置客户的 platformType 为 NA（ApiHug 枚举字段绝不为 null，使用 default_value）
    customerRepository.updateCustomerPlatformType(member.getCustomerId(), CustomerPlatformTypeEnum.NA.title());
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [PLATFORM_MEMBER_FREEZE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/platforms/members/{memberId}/toggle-freeze}
   *     <p>{@code 切换平台成员冻结状态：PM_ACTIVE ↔ PM_LOCKED}
   * @see PlatformService#togglePlatformMemberFreeze
   */
  @Transactional
  @Override
  public void togglePlatformMemberFreeze(SimpleResultBuilder<String> builder, Long memberId) {
    PlatformMemberEntity member =
        platformMemberRepository
            .findById(memberId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(
                            PlatformMemberErrorEnum.PLATFORM_MEMBER_NOT_FOUND)
                        .build());

    // 只有 PM_ACTIVE 或 PM_LOCKED 状态才能切换
    if (member.getStatus() == PlatformMemberStatusEnum.PM_LOCKED) {
      member.setStatus(PlatformMemberStatusEnum.PM_ACTIVE);
    } else if (member.getStatus() == PlatformMemberStatusEnum.PM_ACTIVE) {
      member.setStatus(PlatformMemberStatusEnum.PM_LOCKED);
    } else {
      // PM_INACTIVE 状态不允许冻结/解冻
      throw HopeErrorDetailException.errorBuilder(PlatformMemberErrorEnum.PLATFORM_MEMBER_INACTIVE)
          .build();
    }

    platformMemberRepository.save(member);
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>PredefinedRoleCheckerType: PLATFORM
   *   <li>Authorities: [PLATFORM_MEMBER_UPDATE_ROLE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/platforms/members/{memberId}/role}
   *     <p>{@code 更新平台成员的平台角色（MEMBER/MANAGER/OWNER），并同步更新 CustomerEntity.platform_type}
   * @see PlatformService#updatePlatformMemberRole
   */
  @Transactional
  @Override
  public void updatePlatformMemberRole(
      SimpleResultBuilder<String> builder,
      Long memberId,
      UpdatePlatformMemberRoleRequest updatePlatformMemberRoleRequest) {
    PlatformMemberEntity member =
        platformMemberRepository
            .findById(memberId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(
                            PlatformMemberErrorEnum.PLATFORM_MEMBER_NOT_FOUND)
                        .build());

    if (member.getStatus() == PlatformMemberStatusEnum.PM_INACTIVE) {
      throw HopeErrorDetailException.errorBuilder(PlatformMemberErrorEnum.PLATFORM_MEMBER_INACTIVE)
          .build();
    }

    CustomerPlatformTypeEnum newRole = updatePlatformMemberRoleRequest.getPlatformRole();
    member.setPlatformRole(newRole);
    platformMemberRepository.save(member);

    customerRepository.updateCustomerPlatformType(member.getCustomerId(), newRole.title());
  }
}
