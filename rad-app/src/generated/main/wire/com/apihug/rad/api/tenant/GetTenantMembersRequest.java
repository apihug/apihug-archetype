// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * ============ 消息类型定义 ============
 * 获取租户成员列表请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "GetTenantMembersRequest",
    kind = Kind.MESSAGE
)
public class GetTenantMembersRequest {
  private static final long serialVersionUID = 0L;

  protected TenantMemberStatusEnum status;

  protected MemberRoleEnum memberRole;

  protected String keyword;

  public TenantMemberStatusEnum getStatus() {
    return status;
  }

  public GetTenantMembersRequest setStatus(TenantMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  public MemberRoleEnum getMemberRole() {
    return memberRole;
  }

  public GetTenantMembersRequest setMemberRole(MemberRoleEnum memberRole) {
    this.memberRole = memberRole;
    return this;
  }

  public String getKeyword() {
    return keyword;
  }

  public GetTenantMembersRequest setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "GetTenantMembersRequest[" , "]")
    	.add("status=" + status)
    	.add("memberRole=" + memberRole)
    	.add("keyword=" + keyword)
        .toString();
  }
}
