// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 登录响应
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "LoginResponse",
    kind = Kind.MESSAGE
)
public class LoginResponse {
  private static final long serialVersionUID = 0L;

  @NotEmpty
  protected String accessToken;

  @Min(1)
  protected Long customerId;

  @NotEmpty
  protected String username;

  protected Boolean needsOrganizationSelection;

  protected List<OrganizationInfo> organizations;

  protected OrganizationInfo defaultOrganization;

  public String getAccessToken() {
    return accessToken;
  }

  public LoginResponse setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public LoginResponse setCustomerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public LoginResponse setUsername(String username) {
    this.username = username;
    return this;
  }

  public Boolean getNeedsOrganizationSelection() {
    return needsOrganizationSelection;
  }

  public LoginResponse setNeedsOrganizationSelection(Boolean needsOrganizationSelection) {
    this.needsOrganizationSelection = needsOrganizationSelection;
    return this;
  }

  public List<OrganizationInfo> getOrganizations() {
    return organizations;
  }

  public LoginResponse setOrganizations(List<OrganizationInfo> organizations) {
    this.organizations = organizations;
    return this;
  }

  public OrganizationInfo getDefaultOrganization() {
    return defaultOrganization;
  }

  public LoginResponse setDefaultOrganization(OrganizationInfo defaultOrganization) {
    this.defaultOrganization = defaultOrganization;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "LoginResponse[" , "]")
    	.add("accessToken=" + accessToken)
    	.add("customerId=" + customerId)
    	.add("username=" + username)
    	.add("needsOrganizationSelection=" + needsOrganizationSelection)
    	.add("organizations=" + organizations)
    	.add("defaultOrganization=" + defaultOrganization)
        .toString();
  }
}
