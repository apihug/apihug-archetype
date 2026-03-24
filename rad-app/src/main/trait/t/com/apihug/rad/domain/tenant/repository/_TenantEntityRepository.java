// @formatter:off
package t.com.apihug.rad.domain.tenant.repository;

import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import static com.apihug.rad.domain.tenant.dsl.TenantEntityDSL.*;

/**
 * @see TenantEntityRepository
 * @see com.apihug.rad.domain.tenant.TenantEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Tenant repository extension")
interface _TenantEntityRepository extends TenantEntityRepository {

  @Query
  java.util.Optional<TenantEntity> findByTenantCode(String tenantCode);

  @Query
  boolean existsByTenantCode(String tenantCode);

  /**
   * Search tenants with pagination
   */
  default Page<TenantEntity> searchTenants(
      String keyword, TenantStatusEnum status, hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = Criteria.empty();

    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.TenantCode, "%" + keyword + "%")
              .or(EasyCriteria.like(Domain.TenantName, "%" + keyword + "%")));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return findAll(criteria, pageable);
  }
}
