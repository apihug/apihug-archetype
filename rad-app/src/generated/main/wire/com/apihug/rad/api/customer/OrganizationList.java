// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 组织列表
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "OrganizationList",
    kind = Kind.MESSAGE
)
public class OrganizationList {
  private static final long serialVersionUID = 0L;

  protected List<OrganizationInfo> organizations;

  protected Long defaultOrganizationId;

  public List<OrganizationInfo> getOrganizations() {
    return organizations;
  }

  public OrganizationList setOrganizations(List<OrganizationInfo> organizations) {
    this.organizations = organizations;
    return this;
  }

  public Long getDefaultOrganizationId() {
    return defaultOrganizationId;
  }

  public OrganizationList setDefaultOrganizationId(Long defaultOrganizationId) {
    this.defaultOrganizationId = defaultOrganizationId;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "OrganizationList[" , "]")
    	.add("organizations=" + organizations)
    	.add("defaultOrganizationId=" + defaultOrganizationId)
        .toString();
  }
}
