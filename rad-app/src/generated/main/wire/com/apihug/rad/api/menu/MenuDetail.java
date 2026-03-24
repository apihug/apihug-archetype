// @formatter:off
package com.apihug.rad.api.menu;

import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 菜单详情信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "MenuDetail",
    kind = Kind.MESSAGE
)
public class MenuDetail {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  protected Long parentId;

  @NotEmpty
  protected String menuCode;

  @NotEmpty
  protected String menuName;

  protected String path;

  protected String icon;

  protected Integer sortOrder;

  protected MenuTypeEnum menuType;

  protected String permissionCode;

  protected MenuStatusEnum status;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime updatedAt;

  public Long getId() {
    return id;
  }

  public MenuDetail setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public MenuDetail setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getMenuCode() {
    return menuCode;
  }

  public MenuDetail setMenuCode(String menuCode) {
    this.menuCode = menuCode;
    return this;
  }

  public String getMenuName() {
    return menuName;
  }

  public MenuDetail setMenuName(String menuName) {
    this.menuName = menuName;
    return this;
  }

  public String getPath() {
    return path;
  }

  public MenuDetail setPath(String path) {
    this.path = path;
    return this;
  }

  public String getIcon() {
    return icon;
  }

  public MenuDetail setIcon(String icon) {
    this.icon = icon;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public MenuDetail setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public MenuTypeEnum getMenuType() {
    return menuType;
  }

  public MenuDetail setMenuType(MenuTypeEnum menuType) {
    this.menuType = menuType;
    return this;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public MenuDetail setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
    return this;
  }

  public MenuStatusEnum getStatus() {
    return status;
  }

  public MenuDetail setStatus(MenuStatusEnum status) {
    this.status = status;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public MenuDetail setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public MenuDetail setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "MenuDetail[" , "]")
    	.add("id=" + id)
    	.add("parentId=" + parentId)
    	.add("menuCode=" + menuCode)
    	.add("menuName=" + menuName)
    	.add("path=" + path)
    	.add("icon=" + icon)
    	.add("sortOrder=" + sortOrder)
    	.add("menuType=" + menuType)
    	.add("permissionCode=" + permissionCode)
    	.add("status=" + status)
    	.add("createdAt=" + createdAt)
    	.add("updatedAt=" + updatedAt)
        .toString();
  }
}
