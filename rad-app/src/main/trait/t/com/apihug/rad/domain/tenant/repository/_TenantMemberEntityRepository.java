// @formatter:off
package t.com.apihug.rad.domain.tenant.repository;

import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;

import java.util.List;
import java.util.Optional;

import static com.apihug.rad.domain.tenant.dsl.TenantMemberEntityDSL.*;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 * Extension interface for TenantMemberEntityRepository customizations.
 *
 * @see TenantMemberEntityRepository
 * @see com.apihug.rad.domain.tenant.TenantMemberEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Tenant member repository extension")
interface _TenantMemberEntityRepository extends TenantMemberEntityRepository {

  // ========== 按客户 ID 查询 ==========

  @Query
  List<TenantMemberEntity> findByCustomerId(Long customerId);

  @Query
  List<TenantMemberEntity> findByCustomerIdAndStatus(Long customerId, TenantMemberStatusEnum status);

  // ========== 按租户 ID 查询 ==========

  @Query
  List<TenantMemberEntity> findByTenantId(Long tenantId);

  @Query
  List<TenantMemberEntity> findByTenantIdAndStatus(Long tenantId, TenantMemberStatusEnum status);

  // ========== 精确查询 ==========

  @Query
  Optional<TenantMemberEntity> findByCustomerIdAndTenantId(Long customerId, Long tenantId);

  @Query
  boolean existsByCustomerIdAndTenantId(Long customerId, Long tenantId);

  // ========== 默认租户查询 ==========

  @Query
  Optional<TenantMemberEntity> findByCustomerIdAndIsDefault(Long customerId, Boolean isDefault);

  // ========== 分页搜索（使用 EasyCriteria） ==========

  default Page<TenantMemberEntity> searchTenantMembers(
      Long tenantId,
      TenantMemberStatusEnum status,
      MemberRoleEnum memberRole,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(Domain.TenantId, tenantId);

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    if (memberRole != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.MemberRole, memberRole.name()));
    }

    return findAll(criteria, pageable);
  }
}
