// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 分配员工菜单请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "AssignMemberMenusRequest",
    kind = Kind.MESSAGE
)
public class AssignMemberMenusRequest {
  private static final long serialVersionUID = 0L;

  protected List<Integer> menuIds;

  public List<Integer> getMenuIds() {
    return menuIds;
  }

  public AssignMemberMenusRequest setMenuIds(List<Integer> menuIds) {
    this.menuIds = menuIds;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AssignMemberMenusRequest[" , "]")
    	.add("menuIds=" + menuIds)
        .toString();
  }
}
