// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 创建客户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CreateCustomerRequest",
    kind = Kind.MESSAGE
)
public class CreateCustomerRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 50
  )
  protected String username;

  @NotEmpty
  @Size(
      min = 6,
      max = 100
  )
  protected String password;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String email;

  protected CustomerStatusEnum status;

  @Min(0)
  protected Long defaultTenantId;

  public String getUsername() {
    return username;
  }

  public CreateCustomerRequest setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public CreateCustomerRequest setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public CreateCustomerRequest setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerStatusEnum getStatus() {
    return status;
  }

  public CreateCustomerRequest setStatus(CustomerStatusEnum status) {
    this.status = status;
    return this;
  }

  public Long getDefaultTenantId() {
    return defaultTenantId;
  }

  public CreateCustomerRequest setDefaultTenantId(Long defaultTenantId) {
    this.defaultTenantId = defaultTenantId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CreateCustomerRequest[" , "]")
    	.add("username=" + username)
    	.add("password=" + password)
    	.add("email=" + email)
    	.add("status=" + status)
    	.add("defaultTenantId=" + defaultTenantId)
        .toString();
  }
}
