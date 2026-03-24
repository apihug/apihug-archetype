// @formatter:off
package com.apihug.rad.api.tenant;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 成员详情（含客户账号信息 + 成员身份信息）
 * 租户成员详情信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/tenant/member.proto",
    entity = "TenantMemberDetail",
    kind = Kind.MESSAGE
)
public class TenantMemberDetail {
  private static final long serialVersionUID = 0L;

  protected Long id;

  protected Long customerId;

  protected Long tenantId;

  protected String customerUsername;

  protected String customerEmail;

  protected CustomerStatusEnum customerStatus;

  protected String tenantName;

  protected String tenantCode;

  protected MemberTypeEnum memberType;

  protected MemberRoleEnum memberRole;

  protected TenantMemberStatusEnum status;

  protected Long departmentId;

  protected String position;

  protected Boolean isDefault;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime createdAt;

  public Long getId() {
    return id;
  }

  public TenantMemberDetail setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public TenantMemberDetail setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public TenantMemberDetail setTenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public String getCustomerUsername() {
    return customerUsername;
  }

  public TenantMemberDetail setCustomerUsername(String customerUsername) {
    this.customerUsername = customerUsername;
    return this;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public TenantMemberDetail setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
    return this;
  }

  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public TenantMemberDetail setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  public String getTenantName() {
    return tenantName;
  }

  public TenantMemberDetail setTenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

  public String getTenantCode() {
    return tenantCode;
  }

  public TenantMemberDetail setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
    return this;
  }

  public MemberTypeEnum getMemberType() {
    return memberType;
  }

  public TenantMemberDetail setMemberType(MemberTypeEnum memberType) {
    this.memberType = memberType;
    return this;
  }

  public MemberRoleEnum getMemberRole() {
    return memberRole;
  }

  public TenantMemberDetail setMemberRole(MemberRoleEnum memberRole) {
    this.memberRole = memberRole;
    return this;
  }

  public TenantMemberStatusEnum getStatus() {
    return status;
  }

  public TenantMemberDetail setStatus(TenantMemberStatusEnum status) {
    this.status = status;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public TenantMemberDetail setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public TenantMemberDetail setPosition(String position) {
    this.position = position;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public TenantMemberDetail setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public TenantMemberDetail setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "TenantMemberDetail[" , "]")
    	.add("id=" + id)
    	.add("customerId=" + customerId)
    	.add("tenantId=" + tenantId)
    	.add("customerUsername=" + customerUsername)
    	.add("customerEmail=" + customerEmail)
    	.add("customerStatus=" + customerStatus)
    	.add("tenantName=" + tenantName)
    	.add("tenantCode=" + tenantCode)
    	.add("memberType=" + memberType)
    	.add("memberRole=" + memberRole)
    	.add("status=" + status)
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
    	.add("isDefault=" + isDefault)
    	.add("createdAt=" + createdAt)
        .toString();
  }
}
