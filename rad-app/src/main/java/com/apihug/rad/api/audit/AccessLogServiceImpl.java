// @formatter:off
package com.apihug.rad.api.audit;

import com.apihug.rad.domain.audit.AccessLogEntity;
import com.apihug.rad.domain.audit.repository.AccessLogEntityRepository;
import com.apihug.rad.infra.security.RadCustomer;
import hope.common.api.PageRequest;
import hope.common.api.Pageable;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.context.HopeContextHolder;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Access Log Service", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "AccessLogService",
    kind = Kind.RPC,
    line = 13,
    column = 1)
public class AccessLogServiceImpl implements AccessLogService {

  final AccessLogEntityRepository accessLogEntityRepository;

  public AccessLogServiceImpl(AccessLogEntityRepository accessLogEntityRepository) {
    this.accessLogEntityRepository = accessLogEntityRepository;
  }

  /**
   * @apiNote
   *     <p>{@code /api/access-logs/query}
   *     <p>{@code 查询访问日志}
   * @see AccessLogService#queryAccessLogs
   */
  @Override
  public void queryAccessLogs(
      PageableResultBuilder<AccessLogInfo> builder,
      SearchAccessLogsRequest searchAccessLogsRequest,
      PageRequest pageParameter) {

    var tenantId = ((RadCustomer) HopeContextHolder.customer()).getTenantId();
    Page<AccessLogEntity> page =
        accessLogEntityRepository.searchAccessLogs(
            tenantId, searchAccessLogsRequest, pageParameter);
    Pageable<AccessLogInfo> res = new Pageable<>();
    res.setTotalCount(page.getTotalElements());
    res.setPageIndex(page.getNumber());
    res.setPageSize(page.getSize());
    res.setTotalPage(page.getTotalPages());
    res.setData(
        page.get()
            .map(
                entity ->
                    new AccessLogInfo()
                        .setCreatedAt(entity.getCreatedAt())
                        .setCustomerId(entity.getCustomerId())
                        .setId(entity.getId())
                        .setDurationMs(entity.getDurationMs())
                        .setHttpMethod(entity.getHttpMethod())
                        .setErrorCode(entity.getErrorCode())
                        .setErrorMessage(entity.getErrorMessage())
                        .setIpAddress(entity.getIpAddress())
                        .setServiceName(entity.getServiceName())
                        .setMethodName(entity.getMethodName())
                        .setRequestParams(entity.getRequestParams())
                        .setTenantId(tenantId)
                        .setPriority(entity.getPriority())
                        .setUserAgent(entity.getUserAgent())
                // TODO Other you name it
                )
            .collect(Collectors.toUnmodifiableList()));
    builder.payload(res);
  }

  /**
   * @apiNote
   *     <p>{@code /api/access-logs/stats}
   *     <p>{@code 获取访问统计}
   * @see AccessLogService#getAccessLogStats
   */
  @Override
  public void getAccessLogStats(
      SimpleResultBuilder<AccessLogStatsResponse> builder,
      GetAccessLogStatsRequest getAccessLogStatsRequest) {
    var tenantId = ((RadCustomer) HopeContextHolder.customer()).getTenantId();

    Long startTs = 0L;
    Long endTs = Long.MAX_VALUE;
    // This is LocalDateTime
    if (getAccessLogStatsRequest.getStartTime() != null) {
      startTs =
          getAccessLogStatsRequest.getStartTime().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
    }
    if (getAccessLogStatsRequest.getEndTime() != null) {
      endTs =
          getAccessLogStatsRequest.getEndTime().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
    }

    List<Map<String, Object>> statistic =
        accessLogEntityRepository.statistic(tenantId, startTs, endTs);

    Long totalRequests = 0L;
    Long successCount = 0L;
    Long totalDurationMs = 0L;
    for (Map<String, Object> map : statistic) {

      Integer responseStatus = (Integer) map.get("responseStatus");
      Long count = (Long) map.get("count");
      Long avgDurationMs = (Long) map.get("avgDurationMs");

      totalRequests += count;
      // FIXME Avoid overflow?
      totalDurationMs += avgDurationMs * count;
      if (responseStatus >= 200 && responseStatus <= 300) {
        successCount += count;
      }
    }
    AccessLogStatsResponse response = new AccessLogStatsResponse();
    response.setSuccessCount(successCount);
    response.setErrorCount(totalRequests - successCount);
    response.setAvgDurationMs(totalRequests > 0 ? totalDurationMs / totalRequests : 0L);
    response.setTotalRequests(totalRequests);
    // TODO
    // response.setTopPaths()
    builder.payload(response);
  }
}
