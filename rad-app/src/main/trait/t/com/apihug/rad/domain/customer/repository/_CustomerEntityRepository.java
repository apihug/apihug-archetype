// @formatter:off
package t.com.apihug.rad.domain.customer.repository;

import com.apihug.rad.domain.customer.CustomerEntity;
import com.apihug.rad.domain.customer.repository.CustomerEntityRepository;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import java.util.Optional;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!! Extension interface for
 * CustomerEntityRepository customizations.
 *
 * <p>RULES:
 *
 * <p>MUST follow the rule: `apihug-impl-data-access-layer-guide`
 *
 * <p>This interface serves as the extension point for adding custom methods to the {@link
 * CustomerEntityRepository } beyond what Spring Data JDBC provides by default.
 *
 * <p>HOW IT WORKS: - The base {@link CustomerEntityRepository } is automatically generated during
 * wire and will be OVERWRITTEN each time the project is rebuilt. - Any custom methods defined in
 * this interface will be merged into the generated repository through wire process. - The wire task
 * scans this extension interface and copies all declared methods to the final {@link
 * CustomerEntityRepository } implementation.
 *
 * <p>IMPORTANT RULES: 1. NEVER use this interface directly in your code - it's an internal
 * extension point 2. Keep this as a package-private interface (no public modifier) as shown 3. DO
 * NOT override any methods from: - The parent {@link CustomerEntityRepository } - Spring Data's
 * {@link org.springframework.data.repository.ListCrudRepository} - Any other Spring Data repository
 * interfaces 4. Only add NEW methods that are not already defined in the parent repositories
 *
 * <p>1. Standard Spring Data JDBC Query Methods: - Define methods following Spring Data naming
 * conventions (e.g., findByFieldName) - These will be automatically implemented by Spring Data at
 * runtime
 *
 * <p>2. Custom Default Methods with Implementations: - Provide default method implementations for
 * reusable query logic - Can combine multiple repository operations or add business logic
 *
 * <p>3. Domain-Specific Query Abstractions: - Create expressive, domain-oriented method names that
 * encapsulate complex queries - Improve code readability and maintainability
 *
 * <p>4. Static SQL String Constants: - Define raw SQL strings for use with @Query annotations or
 * custom implementations - Centralize SQL definitions for better maintainability
 *
 * <p>USAGE EXAMPLE: // Add custom query methods here Optional<User> findByUserId(Long userId);
 * List<User> findAllByCreatedAtAfter(LocalDateTime date);
 *
 * @see CustomerEntityRepository
 * @see com.apihug.rad.domain.customer.CustomerEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Customer repository extension")
interface _CustomerEntityRepository extends CustomerEntityRepository {

  @Query
  Optional<CustomerEntity> findByUsername(String username);

  @Query
  Optional<CustomerEntity> findByEmail(String email);

  // ========== 用户管理扩展方法 ==========

  @Query
  Optional<CustomerEntity> findByUsernameAndDefaultTenantId(String username, Long tenantId);

  @Query
  Optional<CustomerEntity> findByEmailAndDefaultTenantId(String email, Long tenantId);

  @Query
  boolean existsByUsername(String username);

  @Query
  boolean existsByEmail(String email);

  @Query
  boolean existsByUsernameAndDefaultTenantId(String username, Long tenantId);

  @Query
  boolean existsByEmailAndDefaultTenantId(String email, Long tenantId);

  // ========== 搜索方法（使用 EasyCriteria） ==========

  @Query
  default Page<CustomerEntity> searchUsers(
      String keyword,
      CustomerStatusEnum status,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(_Deletable_.DELETED, false);

    if (keyword != null && !keyword.isBlank()) {
      // EasyCriteria.like() auto-escapes % and _, but still accepts pattern
      // We need to add % for fuzzy match
      criteria = criteria.and(
          EasyCriteria.like(Domain.Username, keyword)
              .or(EasyCriteria.like(Domain.Email, keyword)));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return this.findAll(criteria, pageable);
  }
}
