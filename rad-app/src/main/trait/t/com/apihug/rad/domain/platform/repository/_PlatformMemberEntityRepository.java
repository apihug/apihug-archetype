// @formatter:off
package t.com.apihug.rad.domain.platform.repository;

import com.apihug.rad.domain.platform.PlatformMemberEntity;
import com.apihug.rad.domain.platform.repository.PlatformMemberEntityRepository;
import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.query.Criteria;

import java.util.Optional;

import static com.apihug.rad.domain.platform.dsl.PlatformMemberEntityDSL.*;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 * Extension interface for PlatformMemberEntityRepository customizations.
 *
 * @see PlatformMemberEntityRepository
 * @see com.apihug.rad.domain.platform.PlatformMemberEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Platform member repository extension")
interface _PlatformMemberEntityRepository extends PlatformMemberEntityRepository {

  // ========== 按客户 ID 查询 ==========

  Optional<PlatformMemberEntity> findByCustomerId(Long customerId);

  boolean existsByCustomerId(Long customerId);

  Optional<PlatformMemberEntity> findByCustomerIdAndStatus(Long customerId, PlatformMemberStatusEnum status);

  // ========== 分页搜索 ==========

  default Page<PlatformMemberEntity> searchPlatformMembers(
      PlatformMemberStatusEnum status,
      CustomerPlatformTypeEnum platformRole,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = Criteria.empty();

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    if (platformRole != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.PlatformRole, platformRole.name()));
    }

    return findAll(criteria, pageable);
  }
}
