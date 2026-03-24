// @formatter:off
package t.com.apihug.rad.domain.organization.repository;

import com.apihug.rad.domain.organization.repository.UserOrganizationEntityRepository;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 * Extension interface for UserOrganizationEntityRepository customizations.
 *
 * RULES:
 *
 * MUST follow the rule: `apihug-impl-data-access-layer-guide`
 *
 * This interface serves as the extension point for adding custom methods to the
 * {@link UserOrganizationEntityRepository } beyond what Spring Data JDBC provides by default.
 *
 * HOW IT WORKS:
 * - The base {@link UserOrganizationEntityRepository } is automatically generated during wire
 * and will be OVERWRITTEN each time the project is rebuilt.
 * - Any custom methods defined in this interface will be merged into the generated
 * repository through wire process.
 * - The wire task scans this extension interface and copies all declared
 * methods to the final {@link UserOrganizationEntityRepository } implementation.
 *
 * IMPORTANT RULES:
 * 1. NEVER use this interface directly in your code - it's an internal extension point
 * 2. Keep this as a package-private interface (no public modifier) as shown
 * 3. DO NOT override any methods from:
 *  - The parent {@link UserOrganizationEntityRepository }
 *  - Spring Data's {@link org.springframework.data.repository.ListCrudRepository}
 *  - Any other Spring Data repository interfaces
 * 4. Only add NEW methods that are not already defined in the parent repositories
 *
 *
 * 1. Standard Spring Data JDBC Query Methods:
 *    - Define methods following Spring Data naming conventions (e.g., findByFieldName)
 *    - These will be automatically implemented by Spring Data at runtime
 *
 * 2. Custom Default Methods with Implementations:
 *    - Provide default method implementations for reusable query logic
 *    - Can combine multiple repository operations or add business logic
 *
 * 3. Domain-Specific Query Abstractions:
 *    - Create expressive, domain-oriented method names that encapsulate complex queries
 *    - Improve code readability and maintainability
 *
 * 4. Static SQL String Constants:
 *    - Define raw SQL strings for use with @Query annotations or custom implementations
 *    - Centralize SQL definitions for better maintainability
 *
 * USAGE EXAMPLE:
 * // Add custom query methods here
 * Optional<User> findByUserId(Long userId);
 * List<User> findAllByCreatedAtAfter(LocalDateTime date);
 *
 * @see UserOrganizationEntityRepository
 * @see com.apihug.rad.domain.organization.UserOrganizationEntity
 */
interface _UserOrganizationEntityRepository extends UserOrganizationEntityRepository {
}
