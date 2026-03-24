// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 组织摘要
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "OrganizationSummary",
    kind = Kind.MESSAGE
)
public class OrganizationSummary {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String organizationCode;

  @NotEmpty
  protected String organizationName;

  protected Long parentId;

  protected String status;

  public Long getId() {
    return id;
  }

  public OrganizationSummary setId(Long id) {
    this.id = id;
    return this;
  }

  public String getOrganizationCode() {
    return organizationCode;
  }

  public OrganizationSummary setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
    return this;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public OrganizationSummary setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public OrganizationSummary setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public OrganizationSummary setStatus(String status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "OrganizationSummary[" , "]")
    	.add("id=" + id)
    	.add("organizationCode=" + organizationCode)
    	.add("organizationName=" + organizationName)
    	.add("parentId=" + parentId)
    	.add("status=" + status)
        .toString();
  }
}
