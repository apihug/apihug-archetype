// @formatter:off
package t.com.apihug.rad.domain.organization.repository;

import com.apihug.rad.domain.organization.CustomerOrganizationEntity;
import com.apihug.rad.domain.organization.repository.CustomerOrganizationEntityRepository;
import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import static com.apihug.rad.domain.organization.dsl.CustomerOrganizationEntityDSL.*;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * CustomerOrganizationEntityRepository trait extension.
 *
 * <p>This interface serves as the extension point for adding custom query methods
 * to the {@link CustomerOrganizationEntityRepository} beyond what Spring Data JDBC
 * provides by default.</p>
 *
 * <p>HOW IT WORKS:</p>
 * <ul>
 *   <li>The base {@link CustomerOrganizationEntityRepository} is automatically generated
 *       during wire and will be OVERWRITTEN each time the project is rebuilt.</li>
 *   <li>Any custom methods defined in this interface will be merged into the generated
 *       repository through wire process.</li>
 *   <li>The wire task scans this extension interface and copies all declared methods
 *       to the final {@link CustomerOrganizationEntityRepository} implementation.</li>
 * </ul>
 *
 * <p>IMPORTANT RULES:</p>
 * <ol>
 *   <li>NEVER use this interface directly in your code - it's an internal extension point</li>
 *   <li>Keep this as a package-private interface (no public modifier)</li>
 *   <li>DO NOT override any methods from the parent repositories</li>
 *   <li>Only add NEW methods that are not already defined in the parent repositories</li>
 * </ol>
 *
 * @see CustomerOrganizationEntityRepository
 * @see com.apihug.rad.domain.organization.CustomerOrganizationEntity
 */
@Template(type = Template.Type.TRAIT, usage = "CustomerOrganization repository extension")
interface _CustomerOrganizationEntityRepository extends CustomerOrganizationEntityRepository {

  // ========== 基础查询方法 ==========

  @Query
  java.util.Optional<CustomerOrganizationEntity> findByCustomerIdAndOrganizationId(Long customerId, Long organizationId);

  @Query
  boolean existsByCustomerIdAndOrganizationId(Long customerId, Long organizationId);

  // ========== 组织员工列表查询 ==========

  @Query
  default Page<CustomerOrganizationEntity> findByOrganizationId(
      Long organizationId,
      CustomerOrgStatusEnum status,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(Domain.OrganizationId, organizationId);

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return this.findAll(criteria, pageable);
  }

  // ========== 客户所属组织查询 ==========

  @Query
  default Page<CustomerOrganizationEntity> findByCustomerId(
      Long customerId,
      CustomerOrgStatusEnum status,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(Domain.CustomerId, customerId);

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return this.findAll(criteria, pageable);
  }

  // ========== 默认组织查询 ==========

  @Query
  java.util.Optional<CustomerOrganizationEntity> findFirstByCustomerIdAndIsDefaultTrue(Long customerId);

  // ========== 批量操作 ==========

  @Query
  void deleteByCustomerIdAndOrganizationId(Long customerId, Long organizationId);

  @Query
  void deleteAllByCustomerId(Long customerId);

  @Query
  void deleteAllByOrganizationId(Long organizationId);
}
