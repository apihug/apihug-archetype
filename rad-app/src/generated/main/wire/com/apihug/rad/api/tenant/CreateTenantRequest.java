// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 创建租户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "CreateTenantRequest",
    kind = Kind.MESSAGE
)
public class CreateTenantRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 50
  )
  protected String tenantCode;

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

  protected Boolean isPlatform;

  @Size(
      max = 500
  )
  protected String description;

  public String getTenantCode() {
    return tenantCode;
  }

  public CreateTenantRequest setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public CreateTenantRequest setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public CreateTenantRequest setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public CreateTenantRequest setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public TenantStatusEnum getStatus() {
    return status;
  }

  public CreateTenantRequest setStatus(TenantStatusEnum status) {
    this.status = status;
    return this;
  }

  public Boolean getIsPlatform() {
    return isPlatform;
  }

  public CreateTenantRequest setIsPlatform(Boolean isPlatform) {
    this.isPlatform = isPlatform;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public CreateTenantRequest setDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CreateTenantRequest[" , "]")
    	.add("tenantCode=" + tenantCode)
    	.add("tenantName=" + tenantName)
    	.add("contactEmail=" + contactEmail)
    	.add("contactPhone=" + contactPhone)
    	.add("status=" + status)
    	.add("isPlatform=" + isPlatform)
    	.add("description=" + description)
        .toString();
  }
}
