// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 添加平台成员请求
 * 3+ 字段 → 用 Request Message
 * 添加平台成员请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "AddPlatformMemberRequest",
    kind = Kind.MESSAGE
)
public class AddPlatformMemberRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long customerId;

  protected CustomerPlatformTypeEnum platformRole;

  @Size(
      max = 200
  )
  protected String remark;

  public Long getCustomerId() {
    return customerId;
  }

  public AddPlatformMemberRequest setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public CustomerPlatformTypeEnum getPlatformRole() {
    return platformRole;
  }

  public AddPlatformMemberRequest setPlatformRole(CustomerPlatformTypeEnum platformRole) {
    this.platformRole = platformRole;
    return this;
  }

  public String getRemark() {
    return remark;
  }

  public AddPlatformMemberRequest setRemark(String remark) {
    this.remark = remark;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AddPlatformMemberRequest[" , "]")
    	.add("customerId=" + customerId)
    	.add("platformRole=" + platformRole)
    	.add("remark=" + remark)
        .toString();
  }
}
