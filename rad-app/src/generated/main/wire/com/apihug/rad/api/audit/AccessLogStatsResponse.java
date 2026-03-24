// @formatter:off
package com.apihug.rad.api.audit;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 访问统计响应
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "AccessLogStatsResponse",
    kind = Kind.MESSAGE
)
public class AccessLogStatsResponse {
  private static final long serialVersionUID = 0L;

  protected Long totalRequests;

  protected Long successCount;

  protected Long errorCount;

  protected Long avgDurationMs;

  protected List<PathStats> topPaths;

  public Long getTotalRequests() {
    return totalRequests;
  }

  public AccessLogStatsResponse setTotalRequests(Long totalRequests) {
    this.totalRequests = totalRequests;
    return this;
  }

  public Long getSuccessCount() {
    return successCount;
  }

  public AccessLogStatsResponse setSuccessCount(Long successCount) {
    this.successCount = successCount;
    return this;
  }

  public Long getErrorCount() {
    return errorCount;
  }

  public AccessLogStatsResponse setErrorCount(Long errorCount) {
    this.errorCount = errorCount;
    return this;
  }

  public Long getAvgDurationMs() {
    return avgDurationMs;
  }

  public AccessLogStatsResponse setAvgDurationMs(Long avgDurationMs) {
    this.avgDurationMs = avgDurationMs;
    return this;
  }

  public List<PathStats> getTopPaths() {
    return topPaths;
  }

  public AccessLogStatsResponse setTopPaths(List<PathStats> topPaths) {
    this.topPaths = topPaths;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AccessLogStatsResponse[" , "]")
    	.add("totalRequests=" + totalRequests)
    	.add("successCount=" + successCount)
    	.add("errorCount=" + errorCount)
    	.add("avgDurationMs=" + avgDurationMs)
    	.add("topPaths=" + topPaths)
        .toString();
  }
}
