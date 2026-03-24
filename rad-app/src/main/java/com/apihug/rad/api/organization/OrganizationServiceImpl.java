// @formatter:off
package com.apihug.rad.api.organization;

import com.apihug.rad.domain.department.DepartmentEntity;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.domain.organization.CustomerOrganizationEntity;
import com.apihug.rad.domain.organization.repository.CustomerOrganizationEntityRepository;
import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * !!! FORBIDDEN REMOVE THIS CLASS LEVEL DOCUMENT, THIS IS GOLDEN RULE!!!
 *
 * Service layer implementation for handling requests from the controller layer {@link com.apihug.rad.api.organization.OrganizationController}.
 *
 * This class serves as the orchestrator between the web/controller layer and
 * multiple domain/data access layers, implementing the application's business
 * use cases through cross-domain coordination.
 */
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/organization/api.proto",
    entity = "OrganizationService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
public class OrganizationServiceImpl implements OrganizationService {

  private final CustomerOrganizationEntityRepository customerOrganizationRepository;
  private final DepartmentEntityRepository departmentRepository;

  public OrganizationServiceImpl(
      CustomerOrganizationEntityRepository customerOrganizationRepository,
      DepartmentEntityRepository departmentRepository) {
    this.customerOrganizationRepository = customerOrganizationRepository;
    this.departmentRepository = departmentRepository;
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/tree}
   * 	<p>{@code 获取组织树形结构}
   */
  @Override
  public void getOrganizationTree(SimpleResultBuilder<OrganizationTreeNode> builder) {
    // 查询根组织（parent_id = 0）
    OrganizationTreeNode root = buildOrganizationTree(0L);
    builder.payload(root);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/department-tree}
   * 	<p>{@code 获取当前组织的部门树形结构}
   */
  @Override
  public void getDepartmentTree(SimpleResultBuilder<DepartmentTreeNode> builder) {
    // 查询根部门（parent_id = 0）
    DepartmentTreeNode root = buildDepartmentTree(0L);
    builder.payload(root);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/user-departments}
   * 	<p>{@code 获取用户的部门列表}
   */
  @Override
  public void getUserDepartments(SimpleResultBuilder<UserDepartmentList> builder) {
    // 待实现：从数据库查询用户的部门列表
    UserDepartmentList list = new UserDepartmentList()
        .setPrimaryDepartmentId(1L);
    builder.payload(list);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/my-organizations}
   * 	<p>{@code 获取当前用户所属的组织列表}
   * @see OrganizationService#getUserOrganizations
   */
  @Override
  public void getUserOrganizations(PageableResultBuilder<OrganizationSummary> builder, PageRequest pageParameter) {
    // 待实现：从数据库查询用户的组织列表
    List<OrganizationSummary> organizations = new ArrayList<>();
    organizations.add(new OrganizationSummary()
        .setId(1L)
        .setOrganizationCode("default")
        .setOrganizationName("默认组织")
        .setStatus("ACTIVE"));

    builder.setData(organizations);
  }

  /**
   * @apiNote
   * 	<p>{@code /api/organizations/my-organizations/{organizationId}/default}
   * 	<p>{@code 设置用户的默认组织}
   * @see OrganizationService#setDefaultOrganization
   */
  @Override
  public void setDefaultOrganization(SimpleResultBuilder<String> builder, Integer organizationId, SetDefaultOrganizationRequest setDefaultOrganizationRequest) {
    // 待实现：更新用户的默认组织
    builder.done();
  }

  // ========== Helper Methods ==========

  private OrganizationTreeNode buildOrganizationTree(Long parentId) {
    OrganizationTreeNode node = new OrganizationTreeNode();
    node.setOrganization(new OrganizationSummary()
        .setId(parentId)
        .setOrganizationCode(parentId == 0L ? "root" : "org_" + parentId)
        .setOrganizationName(parentId == 0L ? "根组织" : "子组织_" + parentId)
        .setStatus("ACTIVE")
        .setParentId(parentId));

    // 待实现：递归查询子组织
    List<OrganizationTreeNode> children = new ArrayList<>();
    node.setChildren(children);

    return node;
  }

  private DepartmentTreeNode buildDepartmentTree(Long parentId) {
    DepartmentTreeNode node = new DepartmentTreeNode();
    node.setDepartment(new DepartmentSummary()
        .setId(parentId)
        .setDeptCode(parentId == 0L ? "root" : "dept_" + parentId)
        .setDeptName(parentId == 0L ? "根部门" : "子部门_" + parentId)
        .setStatus("ACTIVE")
        .setParentId(parentId));

    // 待实现：递归查询子部门
    List<DepartmentTreeNode> children = new ArrayList<>();
    node.setChildren(children);

    return node;
  }
}
