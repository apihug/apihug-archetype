// @formatter:off
package com.apihug.rad.api.menu;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 菜单树节点
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/menu/api.proto",
    entity = "MenuTreeNode",
    kind = Kind.MESSAGE
)
public class MenuTreeNode {
  private static final long serialVersionUID = 0L;

  protected MenuSummary menu;

  protected List<MenuTreeNode> children;

  public MenuSummary getMenu() {
    return menu;
  }

  public MenuTreeNode setMenu(MenuSummary menu) {
    this.menu = menu;
    return this;
  }

  public List<MenuTreeNode> getChildren() {
    return children;
  }

  public MenuTreeNode setChildren(List<MenuTreeNode> children) {
    this.children = children;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "MenuTreeNode[" , "]")
    	.add("menu=" + menu)
    	.add("children=" + children)
        .toString();
  }
}
