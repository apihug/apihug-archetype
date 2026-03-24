// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.infra.tenant.TenantErrorEnum;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.api.PageRequest;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.beans.Transient;import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * Service layer implementation for tenant management.
 */
@Template(type = Template.Type.SERVICE, usage = "Tenant management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "TenantService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
public class TenantServiceImpl implements TenantService {

  private final TenantEntityRepository tenantRepository;

  public TenantServiceImpl(TenantEntityRepository tenantRepository) {
    this.tenantRepository = tenantRepository;
  }

  /**
   * Create tenant
   */
  @Override
  public void createTenant(SimpleResultBuilder<TenantSummary> builder,
      CreateTenantRequest createTenantRequest) {
    // 验证租户代码唯一性
    if (tenantRepository.existsByTenantCode(createTenantRequest.getTenantCode())) {
      throw HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_CODE_EXISTS).build();
    }

    // 创建租户实体
    TenantEntity entity = new TenantEntity()
        .setTenantCode(createTenantRequest.getTenantCode())
        .setTenantName(createTenantRequest.getTenantName())
        .setContactEmail(createTenantRequest.getContactEmail())
        .setContactPhone(createTenantRequest.getContactPhone())
        .setStatus(createTenantRequest.getStatus() != null
            ? createTenantRequest.getStatus()
            : TenantStatusEnum.ACTIVE);

    // 保存租户
    TenantEntity saved = tenantRepository.save(entity);

    // 返回摘要
    TenantSummary summary = new TenantSummary()
        .setId(saved.getId())
        .setTenantCode(saved.getTenantCode())
        .setTenantName(saved.getTenantName())
        .setStatus(saved.getStatus());

    builder.payload(summary);
  }

  /**
   * Get tenant detail
   */
  @Override
  public void getTenant(SimpleResultBuilder<TenantDetail> builder, Integer tenantId) {
    TenantEntity entity = tenantRepository.findById(tenantId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build());

    TenantDetail detail = new TenantDetail()
        .setId(entity.getId())
        .setTenantCode(entity.getTenantCode())
        .setTenantName(entity.getTenantName())
        .setContactEmail(entity.getContactEmail())
        .setContactPhone(entity.getContactPhone())
        .setStatus(entity.getStatus())
        .setMaxUsers(entity.getMaxUsers())
        .setMaxStorageMb(entity.getMaxStorageMb())
        .setCreatedAt(entity.getCreatedAt());

    builder.payload(detail);
  }

  @Transactional
  /**
   * Update tenant
   */
  @Override
  public void updateTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      UpdateTenantRequest updateTenantRequest) {
    TenantEntity entity = tenantRepository.findById(tenantId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build());

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
    builder.done();
  }

  /**
   * Disable tenant
   */
  @Override
  public void disableTenant(SimpleResultBuilder<String> builder, Integer tenantId) {
    TenantEntity entity = tenantRepository.findById(tenantId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build());

    entity.setStatus(TenantStatusEnum.DISABLED);
    tenantRepository.save(entity);
    builder.done();
  }

  /**
   * Configure tenant
   */
  @Override
  public void configureTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      ConfigureTenantRequest configureTenantRequest) {
    TenantEntity entity = tenantRepository.findById(tenantId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(TenantErrorEnum.TENANT_NOT_FOUND).build());

    // 更新配置
    if (configureTenantRequest.getMaxUsers() != null) {
      entity.setMaxUsers(configureTenantRequest.getMaxUsers());
    }
    if (configureTenantRequest.getMaxStorageMb() != null) {
      entity.setMaxStorageMb(configureTenantRequest.getMaxStorageMb());
    }
    if (configureTenantRequest.getExpiryDate() != null) {
      entity.setExpiryDate(configureTenantRequest.getExpiryDate());
    }

    tenantRepository.save(entity);
    builder.done();
  }
}
