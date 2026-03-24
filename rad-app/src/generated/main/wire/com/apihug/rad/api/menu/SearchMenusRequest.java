// @formatter:off
package com.apihug.rad.api.menu;

import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 搜索菜单请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "SearchMenusRequest",
    kind = Kind.MESSAGE
)
public class SearchMenusRequest {
  private static final long serialVersionUID = 0L;

  protected String keyword;

  protected MenuTypeEnum menuType;

  protected MenuStatusEnum status;

  public String getKeyword() {
    return keyword;
  }

  public SearchMenusRequest setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  public MenuTypeEnum getMenuType() {
    return menuType;
  }

  public SearchMenusRequest setMenuType(MenuTypeEnum menuType) {
    this.menuType = menuType;
    return this;
  }

  public MenuStatusEnum getStatus() {
    return status;
  }

  public SearchMenusRequest setStatus(MenuStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SearchMenusRequest[" , "]")
    	.add("keyword=" + keyword)
    	.add("menuType=" + menuType)
    	.add("status=" + status)
        .toString();
  }
}
