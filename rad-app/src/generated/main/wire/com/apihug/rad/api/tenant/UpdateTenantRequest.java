// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新租户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "UpdateTenantRequest",
    kind = Kind.MESSAGE
)
public class UpdateTenantRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String tenantName;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String contactEmail;

  @Size(
      max = 20
  )
  protected String contactPhone;

  protected TenantStatusEnum status;

  public String getTenantName() {
    return tenantName;
  }

  public UpdateTenantRequest setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public UpdateTenantRequest setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public UpdateTenantRequest setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public TenantStatusEnum getStatus() {
    return status;
  }

  public UpdateTenantRequest setStatus(TenantStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdateTenantRequest[" , "]")
    	.add("tenantName=" + tenantName)
    	.add("contactEmail=" + contactEmail)
    	.add("contactPhone=" + contactPhone)
    	.add("status=" + status)
        .toString();
  }
}
