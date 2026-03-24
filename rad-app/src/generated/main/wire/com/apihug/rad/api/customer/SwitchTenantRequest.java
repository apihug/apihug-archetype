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
 * 切换租户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "SwitchTenantRequest",
    kind = Kind.MESSAGE
)
public class SwitchTenantRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long tenantId;

  public Long getTenantId() {
    return tenantId;
  }

  public SwitchTenantRequest setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SwitchTenantRequest[" , "]")
    	.add("tenantId=" + tenantId)
        .toString();
  }
}
