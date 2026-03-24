// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 找回密码请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "ForgotPasswordRequest",
    kind = Kind.MESSAGE
)
public class ForgotPasswordRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String email;

  public String getEmail() {
    return email;
  }

  public ForgotPasswordRequest setEmail(String email) {
    this.email = email;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "ForgotPasswordRequest[" , "]")
    	.add("email=" + email)
        .toString();
  }
}
