// @formatter:off
package com.apihug.rad.api.customer;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 组织信息（用于登录响应）
 * 组织信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "OrganizationInfo",
    kind = Kind.MESSAGE
)
public class OrganizationInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String organizationCode;

  @NotEmpty
  protected String organizationName;

  protected Boolean isDefault;

  public Long getId() {
    return id;
  }

  public OrganizationInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getOrganizationCode() {
    return organizationCode;
  }

  public OrganizationInfo setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
    return this;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public OrganizationInfo setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public OrganizationInfo setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "OrganizationInfo[" , "]")
    	.add("id=" + id)
    	.add("organizationCode=" + organizationCode)
    	.add("organizationName=" + organizationName)
    	.add("isDefault=" + isDefault)
        .toString();
  }
}
