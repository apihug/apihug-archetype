// @formatter:off
package com.apihug.rad.api.menu;

import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新菜单请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "UpdateMenuRequest",
    kind = Kind.MESSAGE
)
public class UpdateMenuRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String menuName;

  @Size(
      max = 255
  )
  protected String path;

  @Size(
      max = 100
  )
  protected String icon;

  protected Integer sortOrder;

  protected MenuTypeEnum menuType;

  @Size(
      max = 100
  )
  protected String permissionCode;

  protected MenuStatusEnum status;

  public String getMenuName() {
    return menuName;
  }

  public UpdateMenuRequest setMenuName(String menuName) {
    this.menuName = menuName;
    return this;
  }

  public String getPath() {
    return path;
  }

  public UpdateMenuRequest setPath(String path) {
    this.path = path;
    return this;
  }

  public String getIcon() {
    return icon;
  }

  public UpdateMenuRequest setIcon(String icon) {
    this.icon = icon;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public UpdateMenuRequest setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public MenuTypeEnum getMenuType() {
    return menuType;
  }

  public UpdateMenuRequest setMenuType(MenuTypeEnum menuType) {
    this.menuType = menuType;
    return this;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public UpdateMenuRequest setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
    return this;
  }

  public MenuStatusEnum getStatus() {
    return status;
  }

  public UpdateMenuRequest setStatus(MenuStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdateMenuRequest[" , "]")
    	.add("menuName=" + menuName)
    	.add("path=" + path)
    	.add("icon=" + icon)
    	.add("sortOrder=" + sortOrder)
    	.add("menuType=" + menuType)
    	.add("permissionCode=" + permissionCode)
    	.add("status=" + status)
        .toString();
  }
}
