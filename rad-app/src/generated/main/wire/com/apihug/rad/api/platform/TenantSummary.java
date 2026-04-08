// @formatter:off
package com.apihug.rad.api.platform;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 租户摘要信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/tenant.proto",
    entity = "TenantSummary",
    kind = Kind.MESSAGE
)
public class TenantSummary {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  @NotEmpty
  protected String tenantCode;

  @NotEmpty
  protected String tenantName;

  protected TenantStatusEnum status;

  public Long getId() {
    return id;
  }

  public TenantSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTenantCode() {
    return tenantCode;
  }

  public TenantSummary setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public TenantSummary setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public TenantStatusEnum getStatus() {
    return status;
  }

  public TenantSummary setStatus(TenantStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TenantSummary[" , "]")
    	.add("id=" + id)
    	.add("tenantCode=" + tenantCode)
    	.add("tenantName=" + tenantName)
    	.add("status=" + status)
        .toString();
  }
}
