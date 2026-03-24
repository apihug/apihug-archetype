// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 当前客户完整信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "CurrentCustomerInfo",
    kind = Kind.MESSAGE
)
public class CurrentCustomerInfo {
  private static final long serialVersionUID = 0L;

  protected CustomerInfo customer;

  protected List<RoleInfo> roles;

  protected List<String> authorities;

  protected DepartmentInfo department;

  protected TenantInfo currentTenant;

  public CustomerInfo getCustomer() {
    return customer;
  }

  public CurrentCustomerInfo setCustomer(CustomerInfo customer) {
    this.customer = customer;
    return this;
  }

  public List<RoleInfo> getRoles() {
    return roles;
  }

  public CurrentCustomerInfo setRoles(List<RoleInfo> roles) {
    this.roles = roles;
    return this;
  }

  public List<String> getAuthorities() {
    return authorities;
  }

  public CurrentCustomerInfo setAuthorities(List<String> authorities) {
    this.authorities = authorities;
    return this;
  }

  public DepartmentInfo getDepartment() {
    return department;
  }

  public CurrentCustomerInfo setDepartment(DepartmentInfo department) {
    this.department = department;
    return this;
  }

  public TenantInfo getCurrentTenant() {
    return currentTenant;
  }

  public CurrentCustomerInfo setCurrentTenant(TenantInfo currentTenant) {
    this.currentTenant = currentTenant;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CurrentCustomerInfo[" , "]")
    	.add("customer=" + customer)
    	.add("roles=" + roles)
    	.add("authorities=" + authorities)
    	.add("department=" + department)
    	.add("currentTenant=" + currentTenant)
        .toString();
  }
}
