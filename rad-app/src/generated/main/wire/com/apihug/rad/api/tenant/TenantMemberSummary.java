// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 租户成员摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "TenantMemberSummary",
    kind = Kind.MESSAGE
)
public class TenantMemberSummary {
  private static final long serialVersionUID = 0L;

  protected Long id;

  protected Long customerId;

  protected String customerUsername;

  protected String customerEmail;

  protected Long tenantId;

  protected String tenantName;

  protected Long departmentId;

  protected String position;

  protected MemberTypeEnum memberType;

  protected MemberRoleEnum memberRole;

  protected TenantMemberStatusEnum status;

  protected Boolean isDefault;

  public Long getId() {
    return id;
  }

  public TenantMemberSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public TenantMemberSummary setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getCustomerUsername() {
    return customerUsername;
  }

  public TenantMemberSummary setCustomerUsername(String customerUsername) {
    this.customerUsername = customerUsername;
    return this;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public TenantMemberSummary setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public TenantMemberSummary setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public TenantMemberSummary setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public TenantMemberSummary setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public TenantMemberSummary setPosition(String position) {
    this.position = position;
    return this;
  }

  public MemberTypeEnum getMemberType() {
    return memberType;
  }

  public TenantMemberSummary setMemberType(MemberTypeEnum memberType) {
    this.memberType = memberType;
    return this;
  }

  public MemberRoleEnum getMemberRole() {
    return memberRole;
  }

  public TenantMemberSummary setMemberRole(MemberRoleEnum memberRole) {
    this.memberRole = memberRole;
    return this;
  }

  public TenantMemberStatusEnum getStatus() {
    return status;
  }

  public TenantMemberSummary setStatus(TenantMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public TenantMemberSummary setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TenantMemberSummary[" , "]")
    	.add("id=" + id)
    	.add("customerId=" + customerId)
    	.add("customerUsername=" + customerUsername)
    	.add("customerEmail=" + customerEmail)
    	.add("tenantId=" + tenantId)
    	.add("tenantName=" + tenantName)
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
    	.add("memberType=" + memberType)
    	.add("memberRole=" + memberRole)
    	.add("status=" + status)
    	.add("isDefault=" + isDefault)
        .toString();
  }
}
