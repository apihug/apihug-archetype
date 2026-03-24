// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 客户详情信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerDetail",
    kind = Kind.MESSAGE
)
public class CustomerDetail {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  @NotEmpty
  protected String username;

  @NotEmpty
  protected String email;

  protected CustomerStatusEnum status;

  protected Long defaultTenantId;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime updatedAt;

  public Long getId() {
    return id;
  }

  public CustomerDetail setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public CustomerDetail setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public CustomerDetail setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerStatusEnum getStatus() {
    return status;
  }

  public CustomerDetail setStatus(CustomerStatusEnum status) {
    this.status = status;
    return this;
  }

  public Long getDefaultTenantId() {
    return defaultTenantId;
  }

  public CustomerDetail setDefaultTenantId(Long defaultTenantId) {
    this.defaultTenantId = defaultTenantId;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public CustomerDetail setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public CustomerDetail setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CustomerDetail[" , "]")
    	.add("id=" + id)
    	.add("username=" + username)
    	.add("email=" + email)
    	.add("status=" + status)
    	.add("defaultTenantId=" + defaultTenantId)
    	.add("createdAt=" + createdAt)
    	.add("updatedAt=" + updatedAt)
        .toString();
  }
}
