// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 角色信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "RoleInfo",
    kind = Kind.MESSAGE
)
public class RoleInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String roleCode;

  @NotEmpty
  protected String roleName;

  public Long getId() {
    return id;
  }

  public RoleInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public RoleInfo setRoleCode(String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public RoleInfo setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RoleInfo[" , "]")
    	.add("id=" + id)
    	.add("roleCode=" + roleCode)
    	.add("roleName=" + roleName)
        .toString();
  }
}
