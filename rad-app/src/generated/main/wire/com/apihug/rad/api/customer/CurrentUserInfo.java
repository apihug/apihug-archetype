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
    entity = "CurrentUserInfo",
    kind = Kind.MESSAGE
)
public class CurrentUserInfo {
  private static final long serialVersionUID = 0L;

  protected CustomerInfo user;

  protected List<RoleInfo> roles;

  protected List<String> authorities;

  protected DepartmentInfo department;

  protected OrganizationInfo currentOrganization;

  public CustomerInfo getUser() {
    return user;
  }

  public CurrentUserInfo setUser(CustomerInfo user) {
    this.user = user;
    return this;
  }

  public List<RoleInfo> getRoles() {
    return roles;
  }

  public CurrentUserInfo setRoles(List<RoleInfo> roles) {
    this.roles = roles;
    return this;
  }

  public List<String> getAuthorities() {
    return authorities;
  }

  public CurrentUserInfo setAuthorities(List<String> authorities) {
    this.authorities = authorities;
    return this;
  }

  public DepartmentInfo getDepartment() {
    return department;
  }

  public CurrentUserInfo setDepartment(DepartmentInfo department) {
    this.department = department;
    return this;
  }

  public OrganizationInfo getCurrentOrganization() {
    return currentOrganization;
  }

  public CurrentUserInfo setCurrentOrganization(OrganizationInfo currentOrganization) {
    this.currentOrganization = currentOrganization;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "CurrentUserInfo[" , "]")
    	.add("user=" + user)
    	.add("roles=" + roles)
    	.add("authorities=" + authorities)
    	.add("department=" + department)
    	.add("currentOrganization=" + currentOrganization)
        .toString();
  }
}
