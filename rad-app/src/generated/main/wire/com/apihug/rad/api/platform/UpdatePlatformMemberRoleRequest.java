// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新平台成员角色请求
 * 更新平台成员角色请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "UpdatePlatformMemberRoleRequest",
    kind = Kind.MESSAGE
)
public class UpdatePlatformMemberRoleRequest {
  private static final long serialVersionUID = 0L;

  protected CustomerPlatformTypeEnum platformRole;

  public CustomerPlatformTypeEnum getPlatformRole() {
    return platformRole;
  }

  public UpdatePlatformMemberRoleRequest setPlatformRole(CustomerPlatformTypeEnum platformRole) {
    this.platformRole = platformRole;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdatePlatformMemberRoleRequest[" , "]")
    	.add("platformRole=" + platformRole)
        .toString();
  }
}
