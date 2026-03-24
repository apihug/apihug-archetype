// @formatter:off
package com.apihug.rad.domain.organization;

import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.wire.Auditable;
import hope.common.spring.data.persistence.wire.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Table(
    name = "SYS_USER_ORGANIZATION",
    indexes = {
        @Index(name = "IDX_SYS_USER_ORGANIZATION_USER_ID", columnList = "USER_ID"),
        @Index(name = "IDX_SYS_USER_ORGANIZATION_ORGANIZATION_ID", columnList = "ORGANIZATION_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_USER_ORGANIZATION_USER_ID_ORGANIZATION_ID", columnNames = {"USER_ID", "ORGANIZATION_ID"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_USER_ORGANIZATION")
@Generated("H.O.P.E. Infra Team")
public final class UserOrganizationEntity implements Identifiable<UserOrganizationEntity>, Auditable<UserOrganizationEntity, Long> {
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

  @org.springframework.data.relational.core.mapping.Column("USER_ID")
  @Description("用户 ID")
  @Column(
      name = "USER_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long userId;

  @org.springframework.data.relational.core.mapping.Column("ORGANIZATION_ID")
  @Description("组织 ID")
  @Column(
      name = "ORGANIZATION_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long organizationId;

  /**
   * Default value: false
   */
  @org.springframework.data.relational.core.mapping.Column("IS_DEFAULT")
  @Description("是否默认组织")
  @Column(
      name = "IS_DEFAULT",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Boolean isDefault;

  @org.springframework.data.relational.core.mapping.Column("DEPARTMENT_ID")
  @Description("部门 ID")
  @Column(
      name = "DEPARTMENT_ID",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long departmentId;

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
  public UserOrganizationEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getUserId() {
    return userId;
  }

  public UserOrganizationEntity setUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public UserOrganizationEntity setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public UserOrganizationEntity setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public UserOrganizationEntity setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public UserOrganizationEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public Long getCreatedBy() {
    return createdBy;
  }

  @Override
  public UserOrganizationEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public UserOrganizationEntity setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public Long getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public UserOrganizationEntity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
