// @formatter:off
package com.apihug.rad.api.role;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 分配菜单请求（全量覆盖）
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "AssignMenusRequest",
    kind = Kind.MESSAGE
)
public class AssignMenusRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  protected List<Long> menuIds;

  public List<Long> getMenuIds() {
    return menuIds;
  }

  public AssignMenusRequest setMenuIds(List<Long> menuIds) {
    this.menuIds = menuIds;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AssignMenusRequest[" , "]")
    	.add("menuIds=" + menuIds)
        .toString();
  }
}
