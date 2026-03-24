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
 * ============ Response Messages ============
 * 访问日志信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/audit/api.proto",
    entity = "AccessLogInfo",
    kind = Kind.MESSAGE
)
public class AccessLogInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  protected String httpMethod;

  protected String requestPath;

  protected Integer responseStatus;

  protected Long durationMs;

  protected Long customerId;

  protected String ipAddress;

  protected String userAgent;

  protected String serviceName;

  protected String methodName;

  protected String errorCode;

  protected String errorMessage;

  protected String requestParams;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  protected Long tenantId;

  protected String priority;

  public Long getId() {
    return id;
  }

  public AccessLogInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public AccessLogInfo setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  public String getRequestPath() {
    return requestPath;
  }

  public AccessLogInfo setRequestPath(String requestPath) {
    this.requestPath = requestPath;
    return this;
  }

  public Integer getResponseStatus() {
    return responseStatus;
  }

  public AccessLogInfo setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  public Long getDurationMs() {
    return durationMs;
  }

  public AccessLogInfo setDurationMs(Long durationMs) {
    this.durationMs = durationMs;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public AccessLogInfo setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public AccessLogInfo setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public AccessLogInfo setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  public String getServiceName() {
    return serviceName;
  }

  public AccessLogInfo setServiceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

  public String getMethodName() {
    return methodName;
  }

  public AccessLogInfo setMethodName(String methodName) {
    this.methodName = methodName;
    return this;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public AccessLogInfo setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public AccessLogInfo setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public String getRequestParams() {
    return requestParams;
  }

  public AccessLogInfo setRequestParams(String requestParams) {
    this.requestParams = requestParams;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public AccessLogInfo setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public AccessLogInfo setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public String getPriority() {
    return priority;
  }

  public AccessLogInfo setPriority(String priority) {
    this.priority = priority;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AccessLogInfo[" , "]")
    	.add("id=" + id)
    	.add("httpMethod=" + httpMethod)
    	.add("requestPath=" + requestPath)
    	.add("responseStatus=" + responseStatus)
    	.add("durationMs=" + durationMs)
    	.add("customerId=" + customerId)
    	.add("ipAddress=" + ipAddress)
    	.add("userAgent=" + userAgent)
    	.add("serviceName=" + serviceName)
    	.add("methodName=" + methodName)
    	.add("errorCode=" + errorCode)
    	.add("errorMessage=" + errorMessage)
    	.add("requestParams=" + requestParams)
    	.add("createdAt=" + createdAt)
    	.add("tenantId=" + tenantId)
    	.add("priority=" + priority)
        .toString();
  }
}
