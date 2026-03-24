// @formatter:off
package com.apihug.rad.domain.role;

import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.wire.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Long;
import java.lang.Override;
import javax.annotation.Generated;

@Table(
    name = "SYS_ROLE_MENU",
    indexes = {
        @Index(name = "IDX_SYS_ROLE_MENU_ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "IDX_SYS_ROLE_MENU_MENU_ID", columnList = "MENU_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_ROLE_MENU_ROLE_ID_MENU_ID", columnNames = {"ROLE_ID", "MENU_ID"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_ROLE_MENU")
@Generated("H.O.P.E. Infra Team")
public final class RoleMenuEntity implements Identifiable<RoleMenuEntity> {
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

  @org.springframework.data.relational.core.mapping.Column("ROLE_ID")
  @Description("角色 ID")
  @Column(
      name = "ROLE_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long roleId;

  @org.springframework.data.relational.core.mapping.Column("MENU_ID")
  @Description("菜单 ID")
  @Column(
      name = "MENU_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long menuId;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public RoleMenuEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getRoleId() {
    return roleId;
  }

  public RoleMenuEntity setRoleId(Long roleId) {
    this.roleId = roleId;
    return this;
  }

  public Long getMenuId() {
    return menuId;
  }

  public RoleMenuEntity setMenuId(Long menuId) {
    this.menuId = menuId;
    return this;
  }
}
