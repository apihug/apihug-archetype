// @formatter:off
package com.apihug.rad.domain.organization;

import com.apihug.rad.infra.organization.OrganizationStatusEnum;
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
    name = "SYS_ORGANIZATION",
    indexes = {
        @Index(name = "IDX_SYS_ORGANIZATION_PARENT_ID", columnList = "PARENT_ID"),
        @Index(name = "IDX_SYS_ORGANIZATION_ORGANIZATION_CODE", columnList = "ORGANIZATION_CODE")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_ORGANIZATION_ORGANIZATION_CODE", columnNames = "ORGANIZATION_CODE")
)
@org.springframework.data.relational.core.mapping.Table("SYS_ORGANIZATION")
@Generated("H.O.P.E. Infra Team")
public final class OrganizationEntity extends Domain<OrganizationEntity, Long, Long> {
  /**
   * Default value: 0
   */
  @Column("PARENT_ID")
  @Description("父组织 ID")
  @jakarta.persistence.Column(
      name = "PARENT_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long parentId;

  @Column("ORGANIZATION_CODE")
  @Description("组织代码")
  @jakarta.persistence.Column(
      name = "ORGANIZATION_CODE",
      unique = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String organizationCode;

  @Column("ORGANIZATION_NAME")
  @Description("组织名称")
  @jakarta.persistence.Column(
      name = "ORGANIZATION_NAME",
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String organizationName;

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

  /**
   * Default value: ACTIVE
   */
  @Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("组织状态")
  @jakarta.persistence.Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected OrganizationStatusEnum status;

  public Long getParentId() {
    return parentId;
  }

  public OrganizationEntity setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getOrganizationCode() {
    return organizationCode;
  }

  public OrganizationEntity setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
    return this;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public OrganizationEntity setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public OrganizationEntity setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public OrganizationStatusEnum getStatus() {
    return status;
  }

  public OrganizationEntity setStatus(OrganizationStatusEnum status) {
    this.status = status;
    return this;
  }
}
