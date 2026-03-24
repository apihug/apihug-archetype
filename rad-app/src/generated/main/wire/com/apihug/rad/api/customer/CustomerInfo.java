// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 客户信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerInfo",
    kind = Kind.MESSAGE
)
public class CustomerInfo {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long customerId;

  @NotEmpty
  protected String username;

  @Min(1)
  protected Long tenantId;

  protected List<String> roles;

  protected List<String> authorities;

  public Long getCustomerId() {
    return customerId;
  }

  public CustomerInfo setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public CustomerInfo setUsername(String username) {
    this.username = username;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public CustomerInfo setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public List<String> getRoles() {
    return roles;
  }

  public CustomerInfo setRoles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public List<String> getAuthorities() {
    return authorities;
  }

  public CustomerInfo setAuthorities(List<String> authorities) {
    this.authorities = authorities;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CustomerInfo[" , "]")
    	.add("customerId=" + customerId)
    	.add("username=" + username)
    	.add("tenantId=" + tenantId)
    	.add("roles=" + roles)
    	.add("authorities=" + authorities)
        .toString();
  }
}
