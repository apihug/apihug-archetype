// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 切换组织请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "SwitchOrganizationRequest",
    kind = Kind.MESSAGE
)
public class SwitchOrganizationRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long organizationId;

  public Long getOrganizationId() {
    return organizationId;
  }

  public SwitchOrganizationRequest setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SwitchOrganizationRequest[" , "]")
    	.add("organizationId=" + organizationId)
        .toString();
  }
}
