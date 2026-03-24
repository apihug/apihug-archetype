// @formatter:off
package com.apihug.rad.api.organization;

import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * ============ 消息类型定义 ============
 * 获取组织员工列表请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "GetOrganizationMembersRequest",
    kind = Kind.MESSAGE
)
public class GetOrganizationMembersRequest {
  private static final long serialVersionUID = 0L;

  protected CustomerOrgStatusEnum status;

  public CustomerOrgStatusEnum getStatus() {
    return status;
  }

  public GetOrganizationMembersRequest setStatus(CustomerOrgStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "GetOrganizationMembersRequest[" , "]")
    	.add("status=" + status)
        .toString();
  }
}
