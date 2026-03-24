// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 租户详情信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "TenantDetail",
    kind = Kind.MESSAGE
)
public class TenantDetail {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  @NotEmpty
  protected String tenantCode;

  @NotEmpty
  protected String tenantName;

  protected String contactEmail;

  protected String contactPhone;

  protected TenantStatusEnum status;

  protected Integer maxMembers;

  protected Long maxStorageMb;

  protected Boolean isPlatform;

  protected String description;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  public Long getId() {
    return id;
  }

  public TenantDetail setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTenantCode() {
    return tenantCode;
  }

  public TenantDetail setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public TenantDetail setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public TenantDetail setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public TenantDetail setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public TenantStatusEnum getStatus() {
    return status;
  }

  public TenantDetail setStatus(TenantStatusEnum status) {
    this.status = status;
    return this;
  }

  public Integer getMaxMembers() {
    return maxMembers;
  }

  public TenantDetail setMaxMembers(Integer maxMembers) {
    this.maxMembers = maxMembers;
    return this;
  }

  public Long getMaxStorageMb() {
    return maxStorageMb;
  }

  public TenantDetail setMaxStorageMb(Long maxStorageMb) {
    this.maxStorageMb = maxStorageMb;
    return this;
  }

  public Boolean getIsPlatform() {
    return isPlatform;
  }

  public TenantDetail setIsPlatform(Boolean isPlatform) {
    this.isPlatform = isPlatform;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public TenantDetail setDescription(String description) {
    this.description = description;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public TenantDetail setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TenantDetail[" , "]")
    	.add("id=" + id)
    	.add("tenantCode=" + tenantCode)
    	.add("tenantName=" + tenantName)
    	.add("contactEmail=" + contactEmail)
    	.add("contactPhone=" + contactPhone)
    	.add("status=" + status)
    	.add("maxMembers=" + maxMembers)
    	.add("maxStorageMb=" + maxStorageMb)
    	.add("isPlatform=" + isPlatform)
    	.add("description=" + description)
    	.add("createdAt=" + createdAt)
        .toString();
  }
}
