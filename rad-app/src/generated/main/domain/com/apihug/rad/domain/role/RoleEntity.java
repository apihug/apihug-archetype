// @formatter:off
package com.apihug.rad.domain.role;

import com.apihug.rad.infra.role.RoleStatusEnum;
import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.Domain;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Generated;
import org.springframework.data.relational.core.mapping.Column;

@Table(
    name = "SYS_ROLE",
    indexes = {
        @Index(name = "IDX_SYS_ROLE_ROLE_CODE", columnList = "ROLE_CODE"),
        @Index(name = "IDX_SYS_ROLE_TENANT_ID", columnList = "TENANT_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_ROLE_TENANT_ID_ROLE_CODE", columnNames = {"TENANT_ID", "ROLE_CODE"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_ROLE")
@Generated("H.O.P.E. Infra Team")
public final class RoleEntity extends Domain<RoleEntity, Long, Long> {
  @Column("ROLE_CODE")
  @Description("角色代码")
  @jakarta.persistence.Column(
      name = "ROLE_CODE",
      unique = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String roleCode;

  @Column("ROLE_NAME")
  @Description("角色名称")
  @jakarta.persistence.Column(
      name = "ROLE_NAME",
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String roleName;

  @Column("DESCRIPTION")
  @Description("角色描述")
  @jakarta.persistence.Column(
      name = "DESCRIPTION",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 500
  )
  protected String description;

  /**
   * Default value: ACTIVE
   */
  @Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("角色状态")
  @jakarta.persistence.Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected RoleStatusEnum status;

  public String getRoleCode() {
    return roleCode;
  }

  public RoleEntity setRoleCode(String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public RoleEntity setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public RoleEntity setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleStatusEnum getStatus() {
    return status;
  }

  public RoleEntity setStatus(RoleStatusEnum status) {
    this.status = status;
    return this;
  }
}
