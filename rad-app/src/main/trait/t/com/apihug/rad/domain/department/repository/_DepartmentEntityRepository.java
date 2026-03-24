// @formatter:off
package t.com.apihug.rad.domain.department.repository;

import com.apihug.rad.domain.department.DepartmentEntity;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import static com.apihug.rad.domain.department.dsl.DepartmentEntityDSL.*;

/**
 * @see DepartmentEntityRepository
 * @see com.apihug.rad.domain.department.DepartmentEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Department repository extension")
interface _DepartmentEntityRepository extends DepartmentEntityRepository {

  @Query
  java.util.Optional<DepartmentEntity> findByDeptCode(String deptCode);

  @Query
  boolean existsByDeptCode(String deptCode);

  @Query
  java.util.List<DepartmentEntity> findByParentId(Long parentId);

  /**
   * Search departments with pagination
   */
  default Page<DepartmentEntity> searchDepartments(
      String keyword, DeptStatusEnum status, hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(_Deletable_.DELETED, false);

    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.DeptCode, keyword)
              .or(EasyCriteria.like(Domain.DeptName, keyword)));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return findAll(criteria, pageable);
  }
}
