// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CustomerAuthService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface CustomerAuthService {
  /**
   * @apiNote
   * 	<p>{@code /api/auth/login}
   * 	<p>{@code 客户登录认证接口，验证用户名和密码，成功后返回访问令牌}
   */
  default void login(SimpleResultBuilder<LoginResponse> builder, LoginRequest loginRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/auth/logout}
   * 	<p>{@code 客户退出登录接口，清除当前客户的会话信息}
   */
  default void logout(SimpleResultBuilder<String> builder) {
    builder.notImplemented();
  }
}
