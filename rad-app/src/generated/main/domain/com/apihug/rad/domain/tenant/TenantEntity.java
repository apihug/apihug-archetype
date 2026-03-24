// @formatter:off
package com.apihug.rad.domain.tenant;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.wire.Auditable;
import hope.common.spring.data.persistence.wire.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Table(
    name = "SYS_TENANT",
    indexes = @Index(name = "IDX_SYS_TENANT_TENANT_CODE", columnList = "TENANT_CODE"),
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_TENANT_TENANT_CODE", columnNames = "TENANT_CODE")
)
@org.springframework.data.relational.core.mapping.Table("SYS_TENANT")
@Generated("H.O.P.E. Infra Team")
public final class TenantEntity implements Identifiable<TenantEntity>, Auditable<TenantEntity, Long> {
  @Id
  @org.springframework.data.annotation.Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  @Column(
      nullable = false,
      updatable = false,
      name = "ID",
      unique = true
  )
  @org.springframework.data.relational.core.mapping.Column("ID")
  @Description("Record ID")
  protected Long id;

  @org.springframework.data.relational.core.mapping.Column("TENANT_CODE")
  @Description("租户代码")
  @Column(
      name = "TENANT_CODE",
      unique = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String tenantCode;

  @org.springframework.data.relational.core.mapping.Column("TENANT_NAME")
  @Description("租户名称")
  @Column(
      name = "TENANT_NAME",
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String tenantName;

  @org.springframework.data.relational.core.mapping.Column("CONTACT_EMAIL")
  @Description("联系人邮箱")
  @Column(
      name = "CONTACT_EMAIL",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String contactEmail;

  @org.springframework.data.relational.core.mapping.Column("CONTACT_PHONE")
  @Description("联系人电话")
  @Column(
      name = "CONTACT_PHONE",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 20
  )
  protected String contactPhone;

  /**
   * Default value: ACTIVE
   */
  @org.springframework.data.relational.core.mapping.Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("租户状态")
  @Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected TenantStatusEnum status;

  /**
   * Default value: 100
   */
  @org.springframework.data.relational.core.mapping.Column("MAX_USERS")
  @Description("最大用户数")
  @Column(
      name = "MAX_USERS",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Integer maxUsers;

  /**
   * Default value: 10240
   */
  @org.springframework.data.relational.core.mapping.Column("MAX_STORAGE_MB")
  @Description("最大存储空间（MB）")
  @Column(
      name = "MAX_STORAGE_MB",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long maxStorageMb;

  @org.springframework.data.relational.core.mapping.Column("EXPIRY_DATE")
  @Description("到期时间")
  @Column(
      name = "EXPIRY_DATE",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected LocalDateTime expiryDate;

  @Column(
      nullable = false,
      updatable = false,
      name = "CREATED_AT"
  )
  @org.springframework.data.relational.core.mapping.Column("CREATED_AT")
  @CreatedDate
  @Description("Record created time")
  protected LocalDateTime createdAt;

  @Column(
      name = "CREATED_BY"
  )
  @org.springframework.data.relational.core.mapping.Column("CREATED_BY")
  @CreatedBy
  @Description("Record created by")
  protected Long createdBy;

  @Column(
      nullable = false,
      name = "UPDATED_AT"
  )
  @org.springframework.data.relational.core.mapping.Column("UPDATED_AT")
  @LastModifiedDate
  @Description("Record updated time")
  protected LocalDateTime updatedAt;

  @Column(
      name = "UPDATED_BY"
  )
  @org.springframework.data.relational.core.mapping.Column("UPDATED_BY")
  @LastModifiedBy
  @Description("Record updated by")
  protected Long updatedBy;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public TenantEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTenantCode() {
    return tenantCode;
  }

  public TenantEntity setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public TenantEntity setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public TenantEntity setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public TenantEntity setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public TenantStatusEnum getStatus() {
    return status;
  }

  public TenantEntity setStatus(TenantStatusEnum status) {
    this.status = status;
    return this;
  }

  public Integer getMaxUsers() {
    return maxUsers;
  }

  public TenantEntity setMaxUsers(Integer maxUsers) {
    this.maxUsers = maxUsers;
    return this;
  }

  public Long getMaxStorageMb() {
    return maxStorageMb;
  }

  public TenantEntity setMaxStorageMb(Long maxStorageMb) {
    this.maxStorageMb = maxStorageMb;
    return this;
  }

  public LocalDateTime getExpiryDate() {
    return expiryDate;
  }

  public TenantEntity setExpiryDate(LocalDateTime expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public TenantEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public Long getCreatedBy() {
    return createdBy;
  }

  @Override
  public TenantEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public TenantEntity setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public Long getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public TenantEntity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
