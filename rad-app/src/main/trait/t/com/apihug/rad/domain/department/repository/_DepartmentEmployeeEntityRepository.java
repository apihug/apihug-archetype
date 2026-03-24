// @formatter:off
package t.com.apihug.rad.domain.department.repository;

import com.apihug.rad.domain.department.DepartmentEmployeeEntity;
import com.apihug.rad.domain.department.repository.DepartmentEmployeeEntityRepository;
import hope.common.meta.annotation.Template;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;

/**
 * @see DepartmentEmployeeEntityRepository
 * @see com.apihug.rad.domain.department.DepartmentEmployeeEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Department employee repository extension")
interface _DepartmentEmployeeEntityRepository extends DepartmentEmployeeEntityRepository {

  @Query
  Optional<DepartmentEmployeeEntity> findByEmployeeIdAndDepartmentId(Long employeeId, Long departmentId);

  @Query
  List<DepartmentEmployeeEntity> findByEmployeeId(Long employeeId);

  @Query
  List<DepartmentEmployeeEntity> findByDepartmentId(Long departmentId);

  @Query
  boolean existsByEmployeeIdAndDepartmentId(Long employeeId, Long departmentId);
}
