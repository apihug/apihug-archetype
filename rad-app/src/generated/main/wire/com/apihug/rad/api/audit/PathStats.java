// @formatter:off
package com.apihug.rad.api.audit;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 路径统计
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "PathStats",
    kind = Kind.MESSAGE
)
public class PathStats {
  private static final long serialVersionUID = 0L;

  protected String path;

  protected Long count;

  protected Long avgDurationMs;

  protected Integer errorRate;

  public String getPath() {
    return path;
  }

  public PathStats setPath(String path) {
    this.path = path;
    return this;
  }

  public Long getCount() {
    return count;
  }

  public PathStats setCount(Long count) {
    this.count = count;
    return this;
  }

  public Long getAvgDurationMs() {
    return avgDurationMs;
  }

  public PathStats setAvgDurationMs(Long avgDurationMs) {
    this.avgDurationMs = avgDurationMs;
    return this;
  }

  public Integer getErrorRate() {
    return errorRate;
  }

  public PathStats setErrorRate(Integer errorRate) {
    this.errorRate = errorRate;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "PathStats[" , "]")
    	.add("path=" + path)
    	.add("count=" + count)
    	.add("avgDurationMs=" + avgDurationMs)
    	.add("errorRate=" + errorRate)
        .toString();
  }
}
