// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 添加租户成员请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "AddTenantMemberRequest",
    kind = Kind.MESSAGE
)
public class AddTenantMemberRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Long customerId;

  protected Long departmentId;

  @Size(
      max = 100
  )
  protected String position;

  protected MemberTypeEnum memberType;

  protected MemberRoleEnum memberRole;

  protected Boolean isDefault;

  public Long getCustomerId() {
    return customerId;
  }

  public AddTenantMemberRequest setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public AddTenantMemberRequest setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public AddTenantMemberRequest setPosition(String position) {
    this.position = position;
    return this;
  }

  public MemberTypeEnum getMemberType() {
    return memberType;
  }

  public AddTenantMemberRequest setMemberType(MemberTypeEnum memberType) {
    this.memberType = memberType;
    return this;
  }

  public MemberRoleEnum getMemberRole() {
    return memberRole;
  }

  public AddTenantMemberRequest setMemberRole(MemberRoleEnum memberRole) {
    this.memberRole = memberRole;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public AddTenantMemberRequest setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "AddTenantMemberRequest[" , "]")
    	.add("customerId=" + customerId)
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
    	.add("memberType=" + memberType)
    	.add("memberRole=" + memberRole)
    	.add("isDefault=" + isDefault)
        .toString();
  }
}
