// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 租户信息（用于登录响应、客户租户列表等）
 * 租户信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "TenantInfo",
    kind = Kind.MESSAGE
)
public class TenantInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String tenantCode;

  @NotEmpty
  protected String tenantName;

  protected Boolean isDefault;

  protected Boolean isPlatform;

  public Long getId() {
    return id;
  }

  public TenantInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTenantCode() {
    return tenantCode;
  }

  public TenantInfo setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public TenantInfo setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public TenantInfo setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public Boolean getIsPlatform() {
    return isPlatform;
  }

  public TenantInfo setIsPlatform(Boolean isPlatform) {
    this.isPlatform = isPlatform;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TenantInfo[" , "]")
    	.add("id=" + id)
    	.add("tenantCode=" + tenantCode)
    	.add("tenantName=" + tenantName)
    	.add("isDefault=" + isDefault)
    	.add("isPlatform=" + isPlatform)
        .toString();
  }
}
