// @formatter:off
package com.apihug.rad.api.organization;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 组织树节点
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "OrganizationTreeNode",
    kind = Kind.MESSAGE
)
public class OrganizationTreeNode {
  private static final long serialVersionUID = 0L;

  protected OrganizationSummary organization;

  protected List<OrganizationTreeNode> children;

  public OrganizationSummary getOrganization() {
    return organization;
  }

  public OrganizationTreeNode setOrganization(OrganizationSummary organization) {
    this.organization = organization;
    return this;
  }

  public List<OrganizationTreeNode> getChildren() {
    return children;
  }

  public OrganizationTreeNode setChildren(List<OrganizationTreeNode> children) {
    this.children = children;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "OrganizationTreeNode[" , "]")
    	.add("organization=" + organization)
    	.add("children=" + children)
        .toString();
  }
}
