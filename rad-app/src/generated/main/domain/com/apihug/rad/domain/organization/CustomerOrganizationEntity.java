// @formatter:off
package com.apihug.rad.domain.organization;

import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import com.apihug.rad.infra.organization.EmployeeTypeEnum;
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
    name = "SYS_CUSTOMER_ORGANIZATION",
    indexes = {
        @Index(name = "IDX_SYS_CUSTOMER_ORGANIZATION_CUSTOMER_ID", columnList = "CUSTOMER_ID"),
        @Index(name = "IDX_SYS_CUSTOMER_ORGANIZATION_ORGANIZATION_ID", columnList = "ORGANIZATION_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_CUSTOMER_ORGANIZATION_CUSTOMER_ID_ORGANIZATION_ID", columnNames = {"CUSTOMER_ID", "ORGANIZATION_ID"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_CUSTOMER_ORGANIZATION")
@Generated("H.O.P.E. Infra Team")
public final class CustomerOrganizationEntity implements Identifiable<CustomerOrganizationEntity>, Auditable<CustomerOrganizationEntity, Long> {
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

  /**
   * Default value: FULL_TIME
   */
  @org.springframework.data.relational.core.mapping.Column("EMPLOYEE_TYPE")
  @Enumerated(EnumType.STRING)
  @Description("员工类型")
  @Column(
      name = "EMPLOYEE_TYPE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected EmployeeTypeEnum employeeType;

  /**
   * Default value: ACTIVE
   */
  @org.springframework.data.relational.core.mapping.Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("在组织内的状态")
  @Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected CustomerOrgStatusEnum status;

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
  public CustomerOrganizationEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public CustomerOrganizationEntity setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public CustomerOrganizationEntity setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public CustomerOrganizationEntity setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public EmployeeTypeEnum getEmployeeType() {
    return employeeType;
  }

  public CustomerOrganizationEntity setEmployeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
    return this;
  }

  public CustomerOrgStatusEnum getStatus() {
    return status;
  }

  public CustomerOrganizationEntity setStatus(CustomerOrgStatusEnum status) {
    this.status = status;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public CustomerOrganizationEntity setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public CustomerOrganizationEntity setPosition(String position) {
    this.position = position;
    return this;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public CustomerOrganizationEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public Long getCreatedBy() {
    return createdBy;
  }

  @Override
  public CustomerOrganizationEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public CustomerOrganizationEntity setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public Long getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public CustomerOrganizationEntity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
