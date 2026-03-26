// @formatter:off
package com.apihug.rad.domain.platform;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
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
import java.lang.Long;
import java.lang.Override;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Table(
    name = "SYS_PLATFORM_MEMBER",
    indexes = @Index(name = "IDX_SYS_PLATFORM_MEMBER_CUSTOMER_ID", columnList = "CUSTOMER_ID"),
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_PLATFORM_MEMBER_CUSTOMER_ID", columnNames = "CUSTOMER_ID")
)
@org.springframework.data.relational.core.mapping.Table("SYS_PLATFORM_MEMBER")
@Generated("H.O.P.E. Infra Team")
public final class PlatformMemberEntity implements Identifiable<PlatformMemberEntity>, Auditable<PlatformMemberEntity, Long> {
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

  @org.springframework.data.relational.core.mapping.Column("CUSTOMER_ID")
  @Description("客户 ID")
  @Column(
      name = "CUSTOMER_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long customerId;

  /**
   * Default value: MEMBER
   */
  @org.springframework.data.relational.core.mapping.Column("PLATFORM_ROLE")
  @Enumerated(EnumType.STRING)
  @Description("平台角色（MEMBER/MANAGER/OWNER）")
  @Column(
      name = "PLATFORM_ROLE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected CustomerPlatformTypeEnum platformRole;

  /**
   * Default value: PM_ACTIVE
   */
  @org.springframework.data.relational.core.mapping.Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("平台成员状态")
  @Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected PlatformMemberStatusEnum status;

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
  public PlatformMemberEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public PlatformMemberEntity setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public CustomerPlatformTypeEnum getPlatformRole() {
    return platformRole;
  }

  public PlatformMemberEntity setPlatformRole(CustomerPlatformTypeEnum platformRole) {
    this.platformRole = platformRole;
    return this;
  }

  public PlatformMemberStatusEnum getStatus() {
    return status;
  }

  public PlatformMemberEntity setStatus(PlatformMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public PlatformMemberEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public Long getCreatedBy() {
    return createdBy;
  }

  @Override
  public PlatformMemberEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public PlatformMemberEntity setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public Long getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public PlatformMemberEntity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
