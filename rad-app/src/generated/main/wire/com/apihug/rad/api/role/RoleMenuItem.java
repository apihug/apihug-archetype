// @formatter:off
package com.apihug.rad.api.role;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 角色关联的菜单项
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleMenuItem",
    kind = Kind.MESSAGE
)
public class RoleMenuItem {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String menuCode;

  @NotEmpty
  protected String menuName;

  protected String permissionCode;

  protected String menuType;

  public Long getId() {
    return id;
  }

  public RoleMenuItem setId(Long id) {
    this.id = id;
    return this;
  }

  public String getMenuCode() {
    return menuCode;
  }

  public RoleMenuItem setMenuCode(String menuCode) {
    this.menuCode = menuCode;
    return this;
  }

  public String getMenuName() {
    return menuName;
  }

  public RoleMenuItem setMenuName(String menuName) {
    this.menuName = menuName;
    return this;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public RoleMenuItem setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
    return this;
  }

  public String getMenuType() {
    return menuType;
  }

  public RoleMenuItem setMenuType(String menuType) {
    this.menuType = menuType;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RoleMenuItem[" , "]")
    	.add("id=" + id)
    	.add("menuCode=" + menuCode)
    	.add("menuName=" + menuName)
    	.add("permissionCode=" + permissionCode)
    	.add("menuType=" + menuType)
        .toString();
  }
}
