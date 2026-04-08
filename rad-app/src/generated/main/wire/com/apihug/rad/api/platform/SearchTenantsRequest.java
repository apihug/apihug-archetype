// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 搜索租户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/tenant.proto",
    entity = "SearchTenantsRequest",
    kind = Kind.MESSAGE
)
public class SearchTenantsRequest {
  private static final long serialVersionUID = 0L;

  protected String keyword;

  protected TenantStatusEnum status;

  public String getKeyword() {
    return keyword;
  }

  public SearchTenantsRequest setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  public TenantStatusEnum getStatus() {
    return status;
  }

  public SearchTenantsRequest setStatus(TenantStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SearchTenantsRequest[" , "]")
    	.add("keyword=" + keyword)
    	.add("status=" + status)
        .toString();
  }
}
