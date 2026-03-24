// @formatter:off
package com.apihug.rad.domain.tenant;

import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
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
import java.lang.Boolean;
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
    name = "SYS_TENANT_MEMBER",
    indexes = {
        @Index(name = "IDX_SYS_TENANT_MEMBER_CUSTOMER_ID", columnList = "CUSTOMER_ID"),
        @Index(name = "IDX_SYS_TENANT_MEMBER_TENANT_ID", columnList = "TENANT_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_TENANT_MEMBER_CUSTOMER_ID_TENANT_ID", columnNames = {"CUSTOMER_ID", "TENANT_ID"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_TENANT_MEMBER")
@Generated("H.O.P.E. Infra Team")
public final class TenantMemberEntity implements Identifiable<TenantMemberEntity>, Auditable<TenantMemberEntity, Long> {
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

  @org.springframework.data.relational.core.mapping.Column("TENANT_ID")
  @Description("租户 ID")
  @Column(
      name = "TENANT_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long tenantId;

  /**
   * Default value: false
   */
  @org.springframework.data.relational.core.mapping.Column("IS_DEFAULT")
  @Description("是否默认租户")
  @Column(
      name = "IS_DEFAULT",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Boolean isDefault;

  /**
   * Default value: FULL_TIME
   */
  @org.springframework.data.relational.core.mapping.Column("MEMBER_TYPE")
  @Enumerated(EnumType.STRING)
  @Description("成员类型（全职/兼职/外包/实习）")
  @Column(
      name = "MEMBER_TYPE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected MemberTypeEnum memberType;

  /**
   * Default value: MEMBER
   */
  @org.springframework.data.relational.core.mapping.Column("MEMBER_ROLE")
  @Enumerated(EnumType.STRING)
  @Description("成员角色（拥有者/管理员/普通成员）")
  @Column(
      name = "MEMBER_ROLE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected MemberRoleEnum memberRole;

  /**
   * Default value: TM_ACTIVE
   */
  @org.springframework.data.relational.core.mapping.Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("在租户内的状态")
  @Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected TenantMemberStatusEnum status;

  @org.springframework.data.relational.core.mapping.Column("DEPARTMENT_ID")
  @Description("所属部门 ID")
  @Column(
      name = "DEPARTMENT_ID",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long departmentId;

  @org.springframework.data.relational.core.mapping.Column("POSITION")
  @Description("职位")
  @Column(
      name = "POSITION",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String position;

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
  public TenantMemberEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public TenantMemberEntity setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public TenantMemberEntity setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public TenantMemberEntity setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public MemberTypeEnum getMemberType() {
    return memberType;
  }

  public TenantMemberEntity setMemberType(MemberTypeEnum memberType) {
    this.memberType = memberType;
    return this;
  }

  public MemberRoleEnum getMemberRole() {
    return memberRole;
  }

  public TenantMemberEntity setMemberRole(MemberRoleEnum memberRole) {
    this.memberRole = memberRole;
    return this;
  }

  public TenantMemberStatusEnum getStatus() {
    return status;
  }

  public TenantMemberEntity setStatus(TenantMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public TenantMemberEntity setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public TenantMemberEntity setPosition(String position) {
    this.position = position;
    return this;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public TenantMemberEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public Long getCreatedBy() {
    return createdBy;
  }

  @Override
  public TenantMemberEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public TenantMemberEntity setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public Long getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public TenantMemberEntity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
