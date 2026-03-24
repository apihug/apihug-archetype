// @formatter:off
package com.apihug.rad.api.role;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 角色菜单摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleMenuSummary",
    kind = Kind.MESSAGE
)
public class RoleMenuSummary {
  private static final long serialVersionUID = 0L;

  protected Long roleId;

  protected List<RoleMenuItem> menus;

  public Long getRoleId() {
    return roleId;
  }

  public RoleMenuSummary setRoleId(Long roleId) {
    this.roleId = roleId;
    return this;
  }

  public List<RoleMenuItem> getMenus() {
    return menus;
  }

  public RoleMenuSummary setMenus(List<RoleMenuItem> menus) {
    this.menus = menus;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RoleMenuSummary[" , "]")
    	.add("roleId=" + roleId)
    	.add("menus=" + menus)
        .toString();
  }
}
