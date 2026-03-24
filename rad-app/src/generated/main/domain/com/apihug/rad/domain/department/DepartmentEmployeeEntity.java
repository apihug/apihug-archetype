// @formatter:off
package com.apihug.rad.domain.department;

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
import java.lang.String;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Table(
    name = "SYS_DEPARTMENT_EMPLOYEE",
    indexes = {
        @Index(name = "IDX_SYS_DEPARTMENT_EMPLOYEE_DEPARTMENT_ID", columnList = "DEPARTMENT_ID"),
        @Index(name = "IDX_SYS_DEPARTMENT_EMPLOYEE_EMPLOYEE_ID", columnList = "EMPLOYEE_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_DEPARTMENT_EMPLOYEE_EMPLOYEE_ID_DEPARTMENT_ID", columnNames = {"EMPLOYEE_ID", "DEPARTMENT_ID"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_DEPARTMENT_EMPLOYEE")
@Generated("H.O.P.E. Infra Team")
public final class DepartmentEmployeeEntity implements Identifiable<DepartmentEmployeeEntity>, Auditable<DepartmentEmployeeEntity, Long> {
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

  @org.springframework.data.relational.core.mapping.Column("EMPLOYEE_ID")
  @Description("员工 ID")
  @Column(
      name = "EMPLOYEE_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long employeeId;

  @org.springframework.data.relational.core.mapping.Column("DEPARTMENT_ID")
  @Description("部门 ID")
  @Column(
      name = "DEPARTMENT_ID",
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

  /**
   * Default value: true
   */
  @org.springframework.data.relational.core.mapping.Column("IS_PRIMARY")
  @Description("是否主部门")
  @Column(
      name = "IS_PRIMARY",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Boolean isPrimary;

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
  public DepartmentEmployeeEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public DepartmentEmployeeEntity setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public DepartmentEmployeeEntity setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public DepartmentEmployeeEntity setPosition(String position) {
    this.position = position;
    return this;
  }

  public Boolean getIsPrimary() {
    return isPrimary;
  }

  public DepartmentEmployeeEntity setIsPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
    return this;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public DepartmentEmployeeEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public Long getCreatedBy() {
    return createdBy;
  }

  @Override
  public DepartmentEmployeeEntity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public DepartmentEmployeeEntity setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public Long getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public DepartmentEmployeeEntity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
