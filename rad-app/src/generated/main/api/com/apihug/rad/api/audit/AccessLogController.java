// @formatter:off
package com.apihug.rad.api.audit;

import hope.common.api.PageRequest;
import hope.common.api.Pageable;
import hope.common.api.Result;
import hope.common.api.annotation.ParameterObject;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import hope.common.spring.helper.PageRequestGuardian;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "AccessLogService",
    kind = Kind.RPC,
    line = 9,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class AccessLogController {
  public static final String _SVC_NAME = "com.apihug.rad.api.audit.AccessLogService";

  protected final AccessLogService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public AccessLogController(AccessLogService service) {
    this._service = service;
  }

  /**
   * @apiNote
   * 	<p>{@code /api/access-logs/query}
   * 	<p>{@code 查询访问日志}
   */
  @GetMapping("/api/access-logs/query")
  public ResponseEntity<Result<Pageable<AccessLogInfo>>> queryAccessLogs(
      @ParameterObject SearchAccessLogsRequest searchAccessLogsRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<AccessLogInfo> builder = new PageableResultBuilder<AccessLogInfo>();
    searchAccessLogsRequest = searchAccessLogsRequest == null ? new SearchAccessLogsRequest(): searchAccessLogsRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "searchAccessLogsRequest", searchAccessLogsRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.QueryAccessLogs, _ctx);
      _service.queryAccessLogs(builder, searchAccessLogsRequest, pageParameter);
      ResponseEntity<Result<Pageable<AccessLogInfo>>> res = builder.done();
      aspect().after(Apis.QueryAccessLogs, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.QueryAccessLogs, exception);
      aspect().exception(Apis.QueryAccessLogs, _ctx, exception);
      throw exception;
    }
  }

  /**
   * @apiNote
   * 	<p>{@code /api/access-logs/stats}
   * 	<p>{@code 获取访问统计}
   */
  @GetMapping("/api/access-logs/stats")
  public ResponseEntity<Result<AccessLogStatsResponse>> getAccessLogStats(
      @ParameterObject GetAccessLogStatsRequest getAccessLogStatsRequest) {
    final SimpleResultBuilder<AccessLogStatsResponse> builder = new SimpleResultBuilder<AccessLogStatsResponse>();
    getAccessLogStatsRequest = getAccessLogStatsRequest == null ? new GetAccessLogStatsRequest(): getAccessLogStatsRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "getAccessLogStatsRequest", getAccessLogStatsRequest);
    try {
      aspect().before(Apis.GetAccessLogStats, _ctx);
      _service.getAccessLogStats(builder, getAccessLogStatsRequest);
      ResponseEntity<Result<AccessLogStatsResponse>> res = builder.done();
      aspect().after(Apis.GetAccessLogStats, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetAccessLogStats, exception);
      aspect().exception(Apis.GetAccessLogStats, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext QueryAccessLogs = new ServiceMethodContext("com.apihug.rad.api.audit.AccessLogService", "QueryAccessLogs", "/api/access-logs/query", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext GetAccessLogStats = new ServiceMethodContext("com.apihug.rad.api.audit.AccessLogService", "GetAccessLogStats", "/api/access-logs/stats", Priority.LOW, ServiceMethod.HttpMethod.GET);
  }
}
