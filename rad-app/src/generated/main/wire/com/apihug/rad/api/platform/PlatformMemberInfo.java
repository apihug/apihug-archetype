// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 平台成员信息摘要（分页返回条目）
 * 平台成员信息摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "PlatformMemberInfo",
    kind = Kind.MESSAGE
)
public class PlatformMemberInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  protected Long customerId;

  protected String customerUsername;

  protected String customerEmail;

  protected CustomerPlatformTypeEnum platformRole;

  protected PlatformMemberStatusEnum status;

  @JsonFormat(
      pattern = "yyyy-MM-dd HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  public Long getId() {
    return id;
  }

  public PlatformMemberInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public PlatformMemberInfo setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getCustomerUsername() {
    return customerUsername;
  }

  public PlatformMemberInfo setCustomerUsername(String customerUsername) {
    this.customerUsername = customerUsername;
    return this;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public PlatformMemberInfo setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
    return this;
  }

  public CustomerPlatformTypeEnum getPlatformRole() {
    return platformRole;
  }

  public PlatformMemberInfo setPlatformRole(CustomerPlatformTypeEnum platformRole) {
    this.platformRole = platformRole;
    return this;
  }

  public PlatformMemberStatusEnum getStatus() {
    return status;
  }

  public PlatformMemberInfo setStatus(PlatformMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public PlatformMemberInfo setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "PlatformMemberInfo[" , "]")
    	.add("id=" + id)
    	.add("customerId=" + customerId)
    	.add("customerUsername=" + customerUsername)
    	.add("customerEmail=" + customerEmail)
    	.add("platformRole=" + platformRole)
    	.add("status=" + status)
    	.add("createdAt=" + createdAt)
        .toString();
  }
}
