// @formatter:off
package com.apihug.rad.api.department;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 部门树节点
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentTreeNode",
    kind = Kind.MESSAGE
)
public class DepartmentTreeNode {
  private static final long serialVersionUID = 0L;

  protected DepartmentSummary department;

  protected List<DepartmentTreeNode> children;

  public DepartmentSummary getDepartment() {
    return department;
  }

  public DepartmentTreeNode setDepartment(DepartmentSummary department) {
    this.department = department;
    return this;
  }

  public List<DepartmentTreeNode> getChildren() {
    return children;
  }

  public DepartmentTreeNode setChildren(List<DepartmentTreeNode> children) {
    this.children = children;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "DepartmentTreeNode[" , "]")
    	.add("department=" + department)
    	.add("children=" + children)
        .toString();
  }
}
