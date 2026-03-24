// @formatter:off
package com.apihug.rad.api.audit;

import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * Let it go
 * 查询访问日志请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "SearchAccessLogsRequest",
    kind = Kind.MESSAGE
)
public class SearchAccessLogsRequest {
  private static final long serialVersionUID = 0L;

  protected Long customerId;

  protected String httpMethod;

  protected String requestPath;

  protected Integer responseStatus;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime startTime;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime endTime;

  public Long getCustomerId() {
    return customerId;
  }

  public SearchAccessLogsRequest setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public SearchAccessLogsRequest setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  public String getRequestPath() {
    return requestPath;
  }

  public SearchAccessLogsRequest setRequestPath(String requestPath) {
    this.requestPath = requestPath;
    return this;
  }

  public Integer getResponseStatus() {
    return responseStatus;
  }

  public SearchAccessLogsRequest setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public SearchAccessLogsRequest setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public SearchAccessLogsRequest setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SearchAccessLogsRequest[" , "]")
    	.add("customerId=" + customerId)
    	.add("httpMethod=" + httpMethod)
    	.add("requestPath=" + requestPath)
    	.add("responseStatus=" + responseStatus)
    	.add("startTime=" + startTime)
    	.add("endTime=" + endTime)
        .toString();
  }
}
