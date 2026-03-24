// @formatter:off
package com.apihug.rad.api.audit;

import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 获取访问统计请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "GetAccessLogStatsRequest",
    kind = Kind.MESSAGE
)
public class GetAccessLogStatsRequest {
  private static final long serialVersionUID = 0L;

  @JsonFormat(
      pattern = "yyyy-MM-dd HH:mm:ss"
  )
  protected LocalDateTime startTime;

  @JsonFormat(
      pattern = "yyyy-MM-dd HH:mm:ss"
  )
  protected LocalDateTime endTime;

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public GetAccessLogStatsRequest setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public GetAccessLogStatsRequest setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "GetAccessLogStatsRequest[" , "]")
    	.add("startTime=" + startTime)
    	.add("endTime=" + endTime)
        .toString();
  }
}
