// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 设置默认组织请求
 * 设置默认组织请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "SetDefaultOrganizationRequest",
    kind = Kind.MESSAGE
)
public class SetDefaultOrganizationRequest {
  private static final long serialVersionUID = 0L;

  @Override
  public String toString() {
    return new StringJoiner(", ", "SetDefaultOrganizationRequest[" , "]")
        .toString();
  }
}
