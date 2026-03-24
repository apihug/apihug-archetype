// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.MemberRoleEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新成员角色请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "UpdateMemberRoleRequest",
    kind = Kind.MESSAGE
)
public class UpdateMemberRoleRequest {
  private static final long serialVersionUID = 0L;

  protected MemberRoleEnum memberRole;

  public MemberRoleEnum getMemberRole() {
    return memberRole;
  }

  public UpdateMemberRoleRequest setMemberRole(MemberRoleEnum memberRole) {
    this.memberRole = memberRole;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdateMemberRoleRequest[" , "]")
    	.add("memberRole=" + memberRole)
        .toString();
  }
}
