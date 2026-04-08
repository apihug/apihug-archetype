// @formatter:off
package com.apihug.rad.api.tenant;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 成员角色摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "MemberRoleSummary",
    kind = Kind.MESSAGE
)
public class MemberRoleSummary {
  private static final long serialVersionUID = 0L;

  protected Long memberId;

  protected List<MemberRoleItem> roles;

  public Long getMemberId() {
    return memberId;
  }

  public MemberRoleSummary setMemberId(Long memberId) {
    this.memberId = memberId;
    return this;
  }

  public List<MemberRoleItem> getRoles() {
    return roles;
  }

  public MemberRoleSummary setRoles(List<MemberRoleItem> roles) {
    this.roles = roles;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "MemberRoleSummary[" , "]")
    	.add("memberId=" + memberId)
    	.add("roles=" + roles)
        .toString();
  }
}
