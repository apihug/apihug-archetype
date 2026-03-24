// @formatter:off
package t.com.apihug.rad.domain.role.repository;

import com.apihug.rad.domain.role.RoleEntity;
import com.apihug.rad.domain.role.repository.RoleEntityRepository;
import com.apihug.rad.infra.role.RoleStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import java.util.Optional;

/**
 * @see RoleEntityRepository
 * @see com.apihug.rad.domain.role.RoleEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Role repository extension")
interface _RoleEntityRepository extends RoleEntityRepository {

  @Query
  Optional<RoleEntity> findByRoleCode(String roleCode);

  @Query
  boolean existsByRoleCode(String roleCode);

  // ========== 搜索方法（使用 EasyCriteria） ==========

  @Query
  default Page<RoleEntity> searchRoles(
      String keyword,
      RoleStatusEnum status,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(_Deletable_.DELETED, false);

    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.RoleCode, keyword)
              .or(EasyCriteria.like(Domain.RoleName, keyword)));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return this.findAll(criteria, pageable);
  }
}
