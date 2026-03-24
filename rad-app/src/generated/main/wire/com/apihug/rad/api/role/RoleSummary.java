// @formatter:off
package com.apihug.rad.api.role;

import com.apihug.rad.infra.role.RoleStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 角色摘要信息（列表用）
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleSummary",
    kind = Kind.MESSAGE
)
public class RoleSummary {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  @NotEmpty
  protected String roleCode;

  @NotEmpty
  protected String roleName;

  protected RoleStatusEnum status;

  public Long getId() {
    return id;
  }

  public RoleSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public RoleSummary setRoleCode(String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public RoleSummary setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public RoleStatusEnum getStatus() {
    return status;
  }

  public RoleSummary setStatus(RoleStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RoleSummary[" , "]")
    	.add("id=" + id)
    	.add("roleCode=" + roleCode)
    	.add("roleName=" + roleName)
    	.add("status=" + status)
        .toString();
  }
}
