// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Size;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 查询平台成员列表请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "GetPlatformMembersRequest",
    kind = Kind.MESSAGE
)
public class GetPlatformMembersRequest {
  private static final long serialVersionUID = 0L;

  protected PlatformMemberStatusEnum status;

  protected CustomerPlatformTypeEnum platformRole;

  @Size(
      max = 100
  )
  protected String keyword;

  public PlatformMemberStatusEnum getStatus() {
    return status;
  }

  public GetPlatformMembersRequest setStatus(PlatformMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  public CustomerPlatformTypeEnum getPlatformRole() {
    return platformRole;
  }

  public GetPlatformMembersRequest setPlatformRole(CustomerPlatformTypeEnum platformRole) {
    this.platformRole = platformRole;
    return this;
  }

  public String getKeyword() {
    return keyword;
  }

  public GetPlatformMembersRequest setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "GetPlatformMembersRequest[" , "]")
    	.add("status=" + status)
    	.add("platformRole=" + platformRole)
    	.add("keyword=" + keyword)
        .toString();
  }
}
