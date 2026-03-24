// @formatter:off
package com.apihug.rad.domain.menu;

import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
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
    name = "SYS_MENU",
    indexes = {
        @Index(name = "IDX_SYS_MENU_PARENT_ID", columnList = "PARENT_ID"),
        @Index(name = "IDX_SYS_MENU_MENU_CODE", columnList = "MENU_CODE"),
        @Index(name = "IDX_SYS_MENU_TENANT_ID", columnList = "TENANT_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_MENU_TENANT_ID_MENU_CODE", columnNames = {"TENANT_ID", "MENU_CODE"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_MENU")
@Generated("H.O.P.E. Infra Team")
public final class MenuEntity extends Domain<MenuEntity, Long, Long> {
  /**
   * Default value: 0
   */
  @Column("PARENT_ID")
  @Description("父菜单 ID")
  @jakarta.persistence.Column(
      name = "PARENT_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long parentId;

  @Column("MENU_CODE")
  @Description("菜单代码")
  @jakarta.persistence.Column(
      name = "MENU_CODE",
      unique = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String menuCode;

  @Column("MENU_NAME")
  @Description("菜单名称")
  @jakarta.persistence.Column(
      name = "MENU_NAME",
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String menuName;

  @Column("PATH")
  @Description("菜单路径")
  @jakarta.persistence.Column(
      name = "PATH",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 255
  )
  protected String path;

  @Column("ICON")
  @Description("菜单图标")
  @jakarta.persistence.Column(
      name = "ICON",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String icon;

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
   * Default value: MENU
   */
  @Column("MENU_TYPE")
  @Enumerated(EnumType.STRING)
  @Description("菜单类型")
  @jakarta.persistence.Column(
      name = "MENU_TYPE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected MenuTypeEnum menuType;

  @Column("PERMISSION_CODE")
  @Description("关联的权限代码")
  @jakarta.persistence.Column(
      name = "PERMISSION_CODE",
      nullable = true,
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String permissionCode;

  /**
   * Default value: ACTIVE
   */
  @Column("STATUS_CODE")
  @Enumerated(EnumType.STRING)
  @Description("菜单状态")
  @jakarta.persistence.Column(
      name = "STATUS_CODE",
      insertable = true,
      updatable = true,
      length = 20
  )
  protected MenuStatusEnum status;

  public Long getParentId() {
    return parentId;
  }

  public MenuEntity setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getMenuCode() {
    return menuCode;
  }

  public MenuEntity setMenuCode(String menuCode) {
    this.menuCode = menuCode;
    return this;
  }

  public String getMenuName() {
    return menuName;
  }

  public MenuEntity setMenuName(String menuName) {
    this.menuName = menuName;
    return this;
  }

  public String getPath() {
    return path;
  }

  public MenuEntity setPath(String path) {
    this.path = path;
    return this;
  }

  public String getIcon() {
    return icon;
  }

  public MenuEntity setIcon(String icon) {
    this.icon = icon;
    return this;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public MenuEntity setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  public MenuTypeEnum getMenuType() {
    return menuType;
  }

  public MenuEntity setMenuType(MenuTypeEnum menuType) {
    this.menuType = menuType;
    return this;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public MenuEntity setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
    return this;
  }

  public MenuStatusEnum getStatus() {
    return status;
  }

  public MenuEntity setStatus(MenuStatusEnum status) {
    this.status = status;
    return this;
  }
}
