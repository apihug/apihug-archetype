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
 * 重置密码请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "ResetPasswordRequest",
    kind = Kind.MESSAGE
)
public class ResetPasswordRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 255
  )
  protected String token;

  @NotEmpty
  @Size(
      min = 6,
      max = 100
  )
  protected String password;

  public String getToken() {
    return token;
  }

  public ResetPasswordRequest setToken(String token) {
    this.token = token;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public ResetPasswordRequest setPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "ResetPasswordRequest[" , "]")
    	.add("token=" + token)
    	.add("password=" + password)
        .toString();
  }
}
