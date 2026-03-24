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
 * 创建角色请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "CreateRoleRequest",
    kind = Kind.MESSAGE
)
public class CreateRoleRequest {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  @Size(
      max = 50
  )
  protected String roleCode;

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

  public String getRoleCode() {
    return roleCode;
  }

  public CreateRoleRequest setRoleCode(String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public CreateRoleRequest setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public CreateRoleRequest setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleStatusEnum getStatus() {
    return status;
  }

  public CreateRoleRequest setStatus(RoleStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CreateRoleRequest[" , "]")
    	.add("roleCode=" + roleCode)
    	.add("roleName=" + roleName)
    	.add("description=" + description)
    	.add("status=" + status)
        .toString();
  }
}
