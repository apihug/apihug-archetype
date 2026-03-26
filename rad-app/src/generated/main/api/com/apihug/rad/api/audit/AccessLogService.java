// @formatter:off
package com.apihug.rad.api.audit;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "AccessLogService",
    kind = Kind.RPC,
    line = 9,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface AccessLogService {
  /**
   * @apiNote
   * 	<p>{@code /api/access-logs/query}
   * 	<p>{@code 查询访问日志}
   */
  default void queryAccessLogs(PageableResultBuilder<AccessLogInfo> builder,
      SearchAccessLogsRequest searchAccessLogsRequest, PageRequest pageParameter) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/access-logs/stats}
   * 	<p>{@code 获取访问统计}
   */
  default void getAccessLogStats(SimpleResultBuilder<AccessLogStatsResponse> builder,
      GetAccessLogStatsRequest getAccessLogStatsRequest) {
    builder.notImplemented();
  }
}
