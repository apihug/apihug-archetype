// @formatter:off
package com.apihug.rad.api.role;

import com.apihug.rad.infra.role.RoleStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 搜索角色请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "SearchRolesRequest",
    kind = Kind.MESSAGE
)
public class SearchRolesRequest {
  private static final long serialVersionUID = 0L;

  protected String keyword;

  protected RoleStatusEnum status;

  public String getKeyword() {
    return keyword;
  }

  public SearchRolesRequest setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  public RoleStatusEnum getStatus() {
    return status;
  }

  public SearchRolesRequest setStatus(RoleStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SearchRolesRequest[" , "]")
    	.add("keyword=" + keyword)
    	.add("status=" + status)
        .toString();
  }
}
