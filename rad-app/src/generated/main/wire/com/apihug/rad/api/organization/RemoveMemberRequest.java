// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 从组织移除员工请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "RemoveMemberRequest",
    kind = Kind.MESSAGE
)
public class RemoveMemberRequest {
  private static final long serialVersionUID = 0L;

  @Override
  public String toString() {
    return new StringJoiner(", ", "RemoveMemberRequest[" , "]")
        .toString();
  }
}
