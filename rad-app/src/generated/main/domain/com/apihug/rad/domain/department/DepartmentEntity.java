// @formatter:off
package com.apihug.rad.domain.department;

import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.Domain;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Generated;
import org.springframework.data.relational.core.mapping.Column;

@Table(
    name = "SYS_DEPARTMENT",
    indexes = {
        @Index(name = "IDX_SYS_DEPARTMENT_PARENT_ID", columnList = "PARENT_ID"),
        @Index(name = "IDX_SYS_DEPARTMENT_DEPT_CODE", columnList = "DEPT_CODE")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_DEPARTMENT_DEPT_CODE", columnNames = "DEPT_CODE")
)
@org.springframework.data.relational.core.mapping.Table("SYS_DEPARTMENT")
@Generated("H.O.P.E. Infra Team")
public final class DepartmentEntity extends Domain<DepartmentEntity, Long, Long> {
  /**
   * Default value: 0
   */
  @Column("PARENT_ID")
  @Description("父部门 ID")
  @jakarta.persistence.Column(
      name = "PARENT_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long parentId;

  @Column("DEPT_CODE")
  @Description("部门代码")
  @jakarta.persistence.Column(
      name = "DEPT_CODE",
      unique = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String deptCode;

  @Column("DEPT_NAME")
  @Description("部门名称")
  @jakarta.persistence.Column(
      name = "DEPT_NAME",
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String deptName;

  /**
   * Default value: 0
   */
  @Column("SORT_ORDER")
  @Description("排序顺序")
  @jakarta.persistence.Column(
      name = "SORT_ORDER",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Integer sortOrder;

  @Column("MANAGER_ID")
  @Description("部门负责人 ID")
  @jakarta.persistence.Column(
      name = "MANAGER_ID",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String managerId;

  /**
   * Default value: ACTIVE
   */
  @Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("部门状态")
  @jakarta.persistence.Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected DeptStatusEnum status;

  public Long getParentId() {
    return parentId;
  }

  public DepartmentEntity setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getDeptCode() {
    return deptCode;
  }

  public DepartmentEntity setDeptCode(String deptCode) {
    this.deptCode = deptCode;
    return this;
  }

  public String getDeptName() {
    return deptName;
  }

  public DepartmentEntity setDeptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public DepartmentEntity setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public String getManagerId() {
    return managerId;
  }

  public DepartmentEntity setManagerId(String managerId) {
    this.managerId = managerId;
    return this;
  }

  public DeptStatusEnum getStatus() {
    return status;
  }

  public DepartmentEntity setStatus(DeptStatusEnum status) {
    this.status = status;
    return this;
  }
}
