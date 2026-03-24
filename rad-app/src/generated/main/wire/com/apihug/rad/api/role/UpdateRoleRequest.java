// @formatter:off
package com.apihug.rad.api.role;

import com.apihug.rad.infra.role.RoleStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 更新角色请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "UpdateRoleRequest",
    kind = Kind.MESSAGE
)
public class UpdateRoleRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 100
  )
  protected String roleName;

  @Size(
      max = 500
  )
  protected String description;

  protected RoleStatusEnum status;

  public String getRoleName() {
    return roleName;
  }

  public UpdateRoleRequest setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public UpdateRoleRequest setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleStatusEnum getStatus() {
    return status;
  }

  public UpdateRoleRequest setStatus(RoleStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "UpdateRoleRequest[" , "]")
    	.add("roleName=" + roleName)
    	.add("description=" + description)
    	.add("status=" + status)
        .toString();
  }
}
