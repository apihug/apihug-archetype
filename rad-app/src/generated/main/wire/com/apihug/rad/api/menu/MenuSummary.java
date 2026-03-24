// @formatter:off
package com.apihug.rad.api.menu;

import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 菜单摘要信息（列表用）
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "MenuSummary",
    kind = Kind.MESSAGE
)
public class MenuSummary {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  protected Long parentId;

  @NotEmpty
  protected String menuCode;

  @NotEmpty
  protected String menuName;

  protected String path;

  protected MenuTypeEnum menuType;

  protected MenuStatusEnum status;

  public Long getId() {
    return id;
  }

  public MenuSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public MenuSummary setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getMenuCode() {
    return menuCode;
  }

  public MenuSummary setMenuCode(String menuCode) {
    this.menuCode = menuCode;
    return this;
  }

  public String getMenuName() {
    return menuName;
  }

  public MenuSummary setMenuName(String menuName) {
    this.menuName = menuName;
    return this;
  }

  public String getPath() {
    return path;
  }

  public MenuSummary setPath(String path) {
    this.path = path;
    return this;
  }

  public MenuTypeEnum getMenuType() {
    return menuType;
  }

  public MenuSummary setMenuType(MenuTypeEnum menuType) {
    this.menuType = menuType;
    return this;
  }

  public MenuStatusEnum getStatus() {
    return status;
  }

  public MenuSummary setStatus(MenuStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "MenuSummary[" , "]")
    	.add("id=" + id)
    	.add("parentId=" + parentId)
    	.add("menuCode=" + menuCode)
    	.add("menuName=" + menuName)
    	.add("path=" + path)
    	.add("menuType=" + menuType)
    	.add("status=" + status)
        .toString();
  }
}
