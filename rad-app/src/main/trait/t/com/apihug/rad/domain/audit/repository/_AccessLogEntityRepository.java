// @formatter:off
package t.com.apihug.rad.domain.audit.repository;

import com.apihug.rad.api.audit.SearchAccessLogsRequest;
import com.apihug.rad.domain.audit.AccessLogEntity;
import com.apihug.rad.domain.audit.repository.AccessLogEntityRepository;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.query.Param;
import java.util.List;import java.util.Map;

/**
 * @see AccessLogEntityRepository
 * @see com.apihug.rad.domain.audit.AccessLogEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Access log repository")
interface _AccessLogEntityRepository extends AccessLogEntityRepository {

  /**
   * 按租户查询待审批列表（分页）
   *
   * @param tenantId 租户 ID
   * @param pageParameter 分页参数
   * @return 分页结果
   */
  @Query
  default Page<AccessLogEntity> searchAccessLogs(
      Long tenantId,
      final SearchAccessLogsRequest searchAccessLogsRequest,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(_Tenantable_.TENANT_ID, tenantId);

    if (searchAccessLogsRequest.getCustomerId() != null) {
      criteria =
          criteria.and(EasyCriteria.eq(Domain.CustomerId, searchAccessLogsRequest.getCustomerId()));
    }

    if (searchAccessLogsRequest.getHttpMethod() != null) {
      criteria =
          criteria.and(EasyCriteria.eq(Domain.HttpMethod, searchAccessLogsRequest.getHttpMethod()));
    }
    if (searchAccessLogsRequest.getResponseStatus() != null) {
      criteria =
          criteria.and(
              EasyCriteria.eq(Domain.ResponseStatus, searchAccessLogsRequest.getResponseStatus()));
    }
    if (searchAccessLogsRequest.getRequestPath() != null) {
      criteria =
          criteria.and(
              EasyCriteria.like(Domain.RequestPath, searchAccessLogsRequest.getRequestPath()));
    }

    return this.findAll(criteria, pageable);
  }

  @Query(
      """
        SELECT RESPONSE_STATUS AS responseStatus,
               COUNT(*) AS count,
               AVG(DURATION_MS) AS avgDurationMs
        FROM SYS_ACCESS_LOG
        WHERE TENANT_ID = :tenantId
        AND START_EPOCH_TS >= :startTs
        AND START_EPOCH_TS <= :endTs
        GROUP BY RESPONSE_STATUS
        """)
  List<Map<String,Object>> statistic(@Param("tenantId") Long tenantId, @Param("startTs") Long startTs, @Param("endTs") Long endTs);

}
