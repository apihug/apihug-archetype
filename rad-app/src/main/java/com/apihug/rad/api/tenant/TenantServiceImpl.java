// @formatter:off
package com.apihug.rad.api.tenant;

import java.lang.Long;
import java.lang.Override;
import java.lang.SuppressWarnings;

import com.apihug.rad.domain.platform.repository.PlatformMemberEntityRepository;
import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;
import com.apihug.rad.infra.tenant.TenantErrorEnum;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import hope.common.spring.security.context.HopeContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * <p>Service layer implementation for tenant management.
 */
@Template(type = Template.Type.SERVICE, usage = "Tenant management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "TenantService",
    kind = Kind.RPC,
    line = 11,
    column = 1)
public class TenantServiceImpl implements TenantService {

  private final TenantEntityRepository tenantRepository;
  private final PlatformMemberEntityRepository platformMemberRepository;

  public TenantServiceImpl(TenantEntityRepository tenantRepository,
      PlatformMemberEntityRepository platformMemberRepository) {
    this.tenantRepository = tenantRepository;
    this.platformMemberRepository = platformMemberRepository;
  }

  /** Create tenant */
  @Override
  public void createTenant(
      SimpleResultBuilder<TenantSummary> builder, CreateTenantRequest createTenantRequest) {
    // 验证租户代码唯一性
    if (tenantRepository.existsByTenantCode(createTenantRequest.getTenantCode())) {
      throw HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_CODE_EXISTS).build();
    }

    // 创建租户实体
    TenantEntity entity =
        new TenantEntity()
            .setTenantCode(createTenantRequest.getTenantCode())
            .setTenantName(createTenantRequest.getTenantName())
            .setContactEmail(createTenantRequest.getContactEmail())
            .setContactPhone(createTenantRequest.getContactPhone())
            .setStatus(
                createTenantRequest.getStatus() != null
                    ? createTenantRequest.getStatus()
                    : TenantStatusEnum.ACTIVE);

    // 保存租户
    TenantEntity saved = tenantRepository.save(entity);

    // 返回摘要
    TenantSummary summary =
        new TenantSummary()
            .setId(saved.getId())
            .setTenantCode(saved.getTenantCode())
            .setTenantName(saved.getTenantName())
            .setStatus(saved.getStatus());

    builder.payload(summary);
  }

  /** Get tenant detail */
  @Override
  public void getTenant(SimpleResultBuilder<TenantDetail> builder, Long tenantId) {

    RadCustomer customer = HopeContextHolder.customer();
    Long currentTenantId = customer.getTenantId();

    // 非当前租户时，仅平台管理员（OWNER/MANAGER）可查看其他租户信息
    if (!currentTenantId.equals(tenantId)) {
        assertPlatformLeader();
    }

    TenantEntity entity =
        tenantRepository
            .findById(tenantId.longValue())
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND)
                        .build());

    TenantDetail detail =
        new TenantDetail()
            .setId(entity.getId())
            .setTenantCode(entity.getTenantCode())
            .setTenantName(entity.getTenantName())
            .setContactEmail(entity.getContactEmail())
            .setContactPhone(entity.getContactPhone())
            .setStatus(entity.getStatus())
            .setMaxMembers(entity.getMaxUsers())
            .setMaxStorageMb(entity.getMaxStorageMb())
            .setCreatedAt(entity.getCreatedAt());

    builder.payload(detail);
  }

  @Override
  @Transactional
  public void updateTenant(
      SimpleResultBuilder<String> builder,
      Integer tenantId,
      UpdateTenantRequest updateTenantRequest) {
  RadCustomer customer = HopeContextHolder.customer();
  Long currentTenantId = customer.getTenantId();
  if (!currentTenantId.equals(tenantId.longValue())) {
      assertPlatformLeader();
  }

    TenantEntity entity =
        tenantRepository
            .findById(tenantId.longValue())
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND)
                        .build());

    // 更新字段
    if (updateTenantRequest.getTenantName() != null) {
      entity.setTenantName(updateTenantRequest.getTenantName());
    }
    if (updateTenantRequest.getContactEmail() != null) {
      entity.setContactEmail(updateTenantRequest.getContactEmail());
    }
    if (updateTenantRequest.getContactPhone() != null) {
      entity.setContactPhone(updateTenantRequest.getContactPhone());
    }
    if (updateTenantRequest.getStatus() != null) {
      entity.setStatus(updateTenantRequest.getStatus());
    }

    tenantRepository.save(entity);
  }

  /** Disable tenant */
  @Override
  public void disableTenant(SimpleResultBuilder<String> builder, Integer tenantId) {
    // 仅平台管理员（OWNER/MANAGER）可禁用租户
    assertPlatformLeader();

    TenantEntity entity =
        tenantRepository
            .findById(tenantId.longValue())
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND)
                        .build());

    entity.setStatus(TenantStatusEnum.DISABLED);
    tenantRepository.save(entity);
  }

  /** Configure tenant */
  @Override
  public void configureTenant(
      SimpleResultBuilder<String> builder,
      Integer tenantId,
      ConfigureTenantRequest configureTenantRequest) {
    // 仅平台管理员（OWNER/MANAGER）可配置租户
    assertPlatformLeader();

    TenantEntity entity =
        tenantRepository
            .findById(tenantId.longValue())
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND)
                        .build());

    // 更新配置
    if (configureTenantRequest.getMaxMembers() != null) {
      entity.setMaxUsers(configureTenantRequest.getMaxMembers());
    }
    if (configureTenantRequest.getMaxStorageMb() != null) {
      entity.setMaxStorageMb(configureTenantRequest.getMaxStorageMb());
    }
    if (configureTenantRequest.getExpiryDate() != null) {
      entity.setExpiryDate(configureTenantRequest.getExpiryDate());
    }

    tenantRepository.save(entity);
  }

  /**
   * 校验当前用户是否为活跃的平台管理员（OWNER 或 MANAGER）。
   * 不满足条件时抛出 TENANT_NOT_FOUND 以避免泄露信息。
   */
  private void assertPlatformLeader() {
    RadCustomer customer = HopeContextHolder.customer();
    boolean isPlatformLeader = platformMemberRepository
        .findByCustomerIdAndStatus(customer.getId(), PlatformMemberStatusEnum.PM_ACTIVE)
        .map(m -> m.getPlatformRole() == CustomerPlatformTypeEnum.OWNER
            || m.getPlatformRole() == CustomerPlatformTypeEnum.MANAGER)
        .orElse(false);
    if (!isPlatformLeader) {
      throw HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build();
    }

  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>Authorities: [TENANT_CREATE]
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/tenants/tenants/search}
   *     <p>{@code 搜索租户（分页）}
   * @see TenantService#searchTenants
   */
  @Override
  public void searchTenants(
      PageableResultBuilder<TenantSummary> builder,
      SearchTenantsRequest searchTenantsRequest,
      PageRequest pageParameter) {
    // 仅平台管理员可搜索租户
    assertPlatformLeader();

    Page<TenantEntity> page = tenantRepository.searchTenants(
        searchTenantsRequest.getKeyword(),
        searchTenantsRequest.getStatus(),
        pageParameter);

    builder.setPageIndex(page.getNumber())
           .setPageSize(pageParameter.getSize())
           .setTotalCount(page.getTotalElements())
           .setTotalPage(page.getTotalPages())
           .setData(page.getContent().stream()
               .map(entity -> new TenantSummary()
                   .setId(entity.getId())
                   .setTenantCode(entity.getTenantCode())
                   .setTenantName(entity.getTenantName())
                   .setStatus(entity.getStatus()))
               .collect(Collectors.toList()));
  }
}
