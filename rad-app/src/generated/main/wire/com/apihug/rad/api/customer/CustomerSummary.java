// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 客户摘要信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerSummary",
    kind = Kind.MESSAGE
)
public class CustomerSummary {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  @NotEmpty
  protected String username;

  @NotEmpty
  protected String email;

  protected CustomerStatusEnum status;

  protected Long tenantId;

  public Long getId() {
    return id;
  }

  public CustomerSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public CustomerSummary setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public CustomerSummary setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerStatusEnum getStatus() {
    return status;
  }

  public CustomerSummary setStatus(CustomerStatusEnum status) {
    this.status = status;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public CustomerSummary setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CustomerSummary[" , "]")
    	.add("id=" + id)
    	.add("username=" + username)
    	.add("email=" + email)
    	.add("status=" + status)
    	.add("tenantId=" + tenantId)
        .toString();
  }
}
