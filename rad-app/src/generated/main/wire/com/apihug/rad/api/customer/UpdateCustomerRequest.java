// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新客户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "UpdateCustomerRequest",
    kind = Kind.MESSAGE
)
public class UpdateCustomerRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String email;

  protected CustomerStatusEnum status;

  public String getEmail() {
    return email;
  }

  public UpdateCustomerRequest setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerStatusEnum getStatus() {
    return status;
  }

  public UpdateCustomerRequest setStatus(CustomerStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdateCustomerRequest[" , "]")
    	.add("email=" + email)
    	.add("status=" + status)
        .toString();
  }
}
