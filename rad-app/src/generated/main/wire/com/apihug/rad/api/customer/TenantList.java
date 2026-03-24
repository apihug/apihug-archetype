// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 租户列表
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "TenantList",
    kind = Kind.MESSAGE
)
public class TenantList {
  private static final long serialVersionUID = 0L;

  protected List<TenantInfo> tenants;

  protected Long defaultTenantId;

  public List<TenantInfo> getTenants() {
    return tenants;
  }

  public TenantList setTenants(List<TenantInfo> tenants) {
    this.tenants = tenants;
    return this;
  }

  public Long getDefaultTenantId() {
    return defaultTenantId;
  }

  public TenantList setDefaultTenantId(Long defaultTenantId) {
    this.defaultTenantId = defaultTenantId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TenantList[" , "]")
    	.add("tenants=" + tenants)
    	.add("defaultTenantId=" + defaultTenantId)
        .toString();
  }
}
