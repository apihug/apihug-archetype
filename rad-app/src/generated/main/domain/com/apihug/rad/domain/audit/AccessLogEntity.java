// @formatter:off
package com.apihug.rad.domain.audit;

import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.wire.Identifiable;
import hope.common.spring.data.persistence.wire.Tenantable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import javax.annotation.Generated;

@Table(
    name = "SYS_ACCESS_LOG",
    indexes = {
        @Index(name = "IDX_SYS_ACCESS_LOG_CUSTOMER_ID", columnList = "CUSTOMER_ID"),
        @Index(name = "IDX_SYS_ACCESS_LOG_REQUEST_PATH", columnList = "REQUEST_PATH"),
        @Index(name = "IDX_SYS_ACCESS_LOG_CREATED_AT", columnList = "CREATED_AT"),
        @Index(name = "IDX_SYS_ACCESS_LOG_TENANT_ID_CREATED_AT", columnList = "TENANT_ID,CREATED_AT")
    }
)
@org.springframework.data.relational.core.mapping.Table("SYS_ACCESS_LOG")
@Generated("H.O.P.E. Infra Team")
public final class AccessLogEntity implements Identifiable<AccessLogEntity>, Tenantable<AccessLogEntity, Long> {
  @Id
  @org.springframework.data.annotation.Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  @Column(
      nullable = false,
      updatable = false,
      name = "ID",
      unique = true
  )
  @org.springframework.data.relational.core.mapping.Column("ID")
  @Description("Record ID")
  protected Long id;

  @org.springframework.data.relational.core.mapping.Column("HTTP_METHOD")
  @Description("HTTP请求方法")
  @Column(
      name = "HTTP_METHOD",
      insertable = true,
      updatable = true,
      length = 10
  )
  protected String httpMethod;

  @org.springframework.data.relational.core.mapping.Column("REQUEST_PATH")
  @Description("请求路径")
  @Column(
      name = "REQUEST_PATH",
      insertable = true,
      updatable = true,
      length = 500
  )
  protected String requestPath;

  @org.springframework.data.relational.core.mapping.Column("REQUEST_PARAMS")
  @Description("脱敏后的请求参数JSON")
  @Column(
      name = "REQUEST_PARAMS",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected String requestParams;

  @org.springframework.data.relational.core.mapping.Column("RESPONSE_STATUS")
  @Description("HTTP响应状态码")
  @Column(
      name = "RESPONSE_STATUS",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Integer responseStatus;

  /**
   * Default value: 0
   */
  @org.springframework.data.relational.core.mapping.Column("START_EPOCH_TS")
  @Description("start epoch timestamp")
  @Column(
      name = "START_EPOCH_TS",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long startEpochTs;

  /**
   * Default value: 0
   */
  @org.springframework.data.relational.core.mapping.Column("DURATION_MS")
  @Description("请求耗时毫秒")
  @Column(
      name = "DURATION_MS",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long durationMs;

  @org.springframework.data.relational.core.mapping.Column("CUSTOMER_ID")
  @Description("客户ID")
  @Column(
      name = "CUSTOMER_ID",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long customerId;

  @org.springframework.data.relational.core.mapping.Column("IP_ADDRESS")
  @Description("IP地址")
  @Column(
      name = "IP_ADDRESS",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 45
  )
  protected String ipAddress;

  @org.springframework.data.relational.core.mapping.Column("USER_AGENT")
  @Description("用户代理")
  @Column(
      name = "USER_AGENT",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 500
  )
  protected String userAgent;

  @org.springframework.data.relational.core.mapping.Column("SERVICE_NAME")
  @Description("服务名称")
  @Column(
      name = "SERVICE_NAME",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected String serviceName;

  @org.springframework.data.relational.core.mapping.Column("METHOD_NAME")
  @Description("方法名称")
  @Column(
      name = "METHOD_NAME",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 125
  )
  protected String methodName;

  @org.springframework.data.relational.core.mapping.Column("ERROR_CODE")
  @Description("错误码")
  @Column(
      name = "ERROR_CODE",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String errorCode;

  @org.springframework.data.relational.core.mapping.Column("ERROR_MESSAGE")
  @Description("错误信息")
  @Column(
      name = "ERROR_MESSAGE",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 500
  )
  protected String errorMessage;

  /**
   * Default value: API
   */
  @org.springframework.data.relational.core.mapping.Column("CHANNEL")
  @Description("渠道")
  @Column(
      name = "CHANNEL",
      insertable = true,
      updatable = true,
      length = 16
  )
  protected String channel;

  @org.springframework.data.relational.core.mapping.Column("CREATED_BY")
  @Description("created by")
  @Column(
      name = "CREATED_BY",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long createdBy;

  @org.springframework.data.relational.core.mapping.Column("CREATED_AT")
  @Description("created at timestamp")
  @Column(
      name = "CREATED_AT",
      insertable = true,
      length = 255
  )
  protected LocalDateTime createdAt;

  /**
   * Default value: LOW
   */
  @org.springframework.data.relational.core.mapping.Column("PRIORITY")
  @Description("priority of this method")
  @Column(
      name = "PRIORITY",
      insertable = true,
      length = 255
  )
  protected String priority;

  @Column(
      nullable = false,
      name = "TENANT_ID",
      updatable = false
  )
  @org.springframework.data.relational.core.mapping.Column("TENANT_ID")
  @Description("Record tenant ID")
  protected Long tenantId;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public AccessLogEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public AccessLogEntity setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  public String getRequestPath() {
    return requestPath;
  }

  public AccessLogEntity setRequestPath(String requestPath) {
    this.requestPath = requestPath;
    return this;
  }

  public String getRequestParams() {
    return requestParams;
  }

  public AccessLogEntity setRequestParams(String requestParams) {
    this.requestParams = requestParams;
    return this;
  }

  public Integer getResponseStatus() {
    return responseStatus;
  }

  public AccessLogEntity setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  public Long getStartEpochTs() {
    return startEpochTs;
  }

  public AccessLogEntity setStartEpochTs(Long startEpochTs) {
    this.startEpochTs = startEpochTs;
    return this;
  }

  public Long getDurationMs() {
    return durationMs;
  }

  public AccessLogEntity setDurationMs(Long durationMs) {
    this.durationMs = durationMs;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public AccessLogEntity setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public AccessLogEntity setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public AccessLogEntity setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  public String getServiceName() {
    return serviceName;
  }

  public AccessLogEntity setServiceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

  public String getMethodName() {
    return methodName;
  }

  public AccessLogEntity setMethodName(String methodName) {
    this.methodName = methodName;
    return this;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public AccessLogEntity setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public AccessLogEntity setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public String getChannel() {
    return channel;
  }

  public AccessLogEntity setChannel(String channel) {
    this.channel = channel;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public AccessLogEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public AccessLogEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public String getPriority() {
    return priority;
  }

  public AccessLogEntity setPriority(String priority) {
    this.priority = priority;
    return this;
  }

  @Override
  public Long getTenantId() {
    return tenantId;
  }

  @Override
  public AccessLogEntity setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }
}
