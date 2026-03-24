// @formatter:off
package com.apihug.rad.api.organization;

import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import com.apihug.rad.infra.organization.EmployeeTypeEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 组织员工摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/customer_org.proto",
    entity = "CustomerOrganizationSummary",
    kind = Kind.MESSAGE
)
public class CustomerOrganizationSummary {
  private static final long serialVersionUID = 0L;

  protected Long id;

  protected Long customerId;

  protected String customerUsername;

  protected String customerEmail;

  protected Long organizationId;

  protected String organizationName;

  protected Long departmentId;

  protected String position;

  protected EmployeeTypeEnum employeeType;

  protected CustomerOrgStatusEnum status;

  protected Boolean isDefault;

  public Long getId() {
    return id;
  }

  public CustomerOrganizationSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public CustomerOrganizationSummary setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getCustomerUsername() {
    return customerUsername;
  }

  public CustomerOrganizationSummary setCustomerUsername(String customerUsername) {
    this.customerUsername = customerUsername;
    return this;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public CustomerOrganizationSummary setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
    return this;
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public CustomerOrganizationSummary setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public CustomerOrganizationSummary setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public CustomerOrganizationSummary setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public CustomerOrganizationSummary setPosition(String position) {
    this.position = position;
    return this;
  }

  public EmployeeTypeEnum getEmployeeType() {
    return employeeType;
  }

  public CustomerOrganizationSummary setEmployeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
    return this;
  }

  public CustomerOrgStatusEnum getStatus() {
    return status;
  }

  public CustomerOrganizationSummary setStatus(CustomerOrgStatusEnum status) {
    this.status = status;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public CustomerOrganizationSummary setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CustomerOrganizationSummary[" , "]")
    	.add("id=" + id)
    	.add("customerId=" + customerId)
    	.add("customerUsername=" + customerUsername)
    	.add("customerEmail=" + customerEmail)
    	.add("organizationId=" + organizationId)
    	.add("organizationName=" + organizationName)
    	.add("departmentId=" + departmentId)
    	.add("position=" + position)
    	.add("employeeType=" + employeeType)
    	.add("status=" + status)
    	.add("isDefault=" + isDefault)
        .toString();
  }
}
