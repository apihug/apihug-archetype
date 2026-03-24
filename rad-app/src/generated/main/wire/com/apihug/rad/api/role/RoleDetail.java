// @formatter:off
package com.apihug.rad.api.role;

import com.apihug.rad.infra.role.RoleStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 角色详情信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/role/api.proto",
    entity = "RoleDetail",
    kind = Kind.MESSAGE
)
public class RoleDetail {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long id;

  @NotEmpty
  protected String roleCode;

  @NotEmpty
  protected String roleName;

  protected String description;

  protected RoleStatusEnum status;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime updatedAt;

  public Long getId() {
    return id;
  }

  public RoleDetail setId(Long id) {
    this.id = id;
    return this;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public RoleDetail setRoleCode(String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public RoleDetail setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public RoleDetail setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleStatusEnum getStatus() {
    return status;
  }

  public RoleDetail setStatus(RoleStatusEnum status) {
    this.status = status;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public RoleDetail setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public RoleDetail setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "RoleDetail[" , "]")
    	.add("id=" + id)
    	.add("roleCode=" + roleCode)
    	.add("roleName=" + roleName)
    	.add("description=" + description)
    	.add("status=" + status)
    	.add("createdAt=" + createdAt)
    	.add("updatedAt=" + updatedAt)
        .toString();
  }
}
