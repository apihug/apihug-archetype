// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * ============ 消息类型定义 ============
 * 登录请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "LoginRequest",
    kind = Kind.MESSAGE
)
public class LoginRequest {
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

  protected Boolean rememberMe;

  public String getUsername() {
    return username;
  }

  public LoginRequest setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public LoginRequest setPassword(String password) {
    this.password = password;
    return this;
  }

  public Boolean getRememberMe() {
    return rememberMe;
  }

  public LoginRequest setRememberMe(Boolean rememberMe) {
    this.rememberMe = rememberMe;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "LoginRequest[" , "]")
    	.add("username=" + username)
    	.add("password=" + password)
    	.add("rememberMe=" + rememberMe)
        .toString();
  }
}
