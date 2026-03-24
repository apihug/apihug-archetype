// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.domain.department.DepartmentEntity;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.SimpleResultBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Department management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentEntityRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentEntityRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  /**
   * Create department
   */
  @Override
  public void createDepartment(SimpleResultBuilder<DepartmentSummary> builder,
      CreateDepartmentRequest createDepartmentRequest) {
    // 验证部门代码唯一性
    if (departmentRepository.existsByDeptCode(createDepartmentRequest.getDeptCode())) {
      throw HopeErrorDetailException.errorBuilder(com.apihug.rad.infra.department.DepartmentErrorEnum.DEPT_CODE_EXISTS).build();
    }

    // 创建部门实体
    DepartmentEntity entity = new DepartmentEntity()
        .setParentId(createDepartmentRequest.getParentId())
        .setDeptCode(createDepartmentRequest.getDeptCode())
        .setDeptName(createDepartmentRequest.getDeptName())
        .setSortOrder(createDepartmentRequest.getSortOrder())
        .setManagerId(createDepartmentRequest.getManagerId())
        .setStatus(createDepartmentRequest.getStatus() != null
            ? createDepartmentRequest.getStatus()
            : DeptStatusEnum.ACTIVE);

    // 保存部门
    DepartmentEntity saved = departmentRepository.save(entity);

    // 返回摘要
    DepartmentSummary summary = new DepartmentSummary()
        .setId(saved.getId())
        .setParentId(saved.getParentId())
        .setDeptCode(saved.getDeptCode())
        .setDeptName(saved.getDeptName())
        .setStatus(saved.getStatus());

    builder.payload(summary);
  }

  /**
   * Get department detail
   */
  @Override
  public void getDepartment(SimpleResultBuilder<DepartmentDetail> builder, Integer departmentId) {
    DepartmentEntity entity = departmentRepository.findById(departmentId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(com.apihug.rad.infra.department.DepartmentErrorEnum.DEPARTMENT_NOT_FOUND).build());

    DepartmentDetail detail = new DepartmentDetail()
        .setId(entity.getId())
        .setParentId(entity.getParentId())
        .setDeptCode(entity.getDeptCode())
        .setDeptName(entity.getDeptName())
        .setSortOrder(entity.getSortOrder())
        .setManagerId(entity.getManagerId())
        .setStatus(entity.getStatus())
        .setCreatedAt(entity.getCreatedAt());

    builder.payload(detail);
  }

  /**
   * Update department
   */
  @Override
  public void updateDepartment(SimpleResultBuilder<String> builder, Integer departmentId,
      UpdateDepartmentRequest updateDepartmentRequest) {
    DepartmentEntity entity = departmentRepository.findById(departmentId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(com.apihug.rad.infra.department.DepartmentErrorEnum.DEPARTMENT_NOT_FOUND).build());

    // 更新字段
    if (updateDepartmentRequest.getDeptName() != null) {
      entity.setDeptName(updateDepartmentRequest.getDeptName());
    }
    if (updateDepartmentRequest.getSortOrder() != null) {
      entity.setSortOrder(updateDepartmentRequest.getSortOrder());
    }
    if (updateDepartmentRequest.getManagerId() != null) {
      entity.setManagerId(updateDepartmentRequest.getManagerId());
    }
    if (updateDepartmentRequest.getStatus() != null) {
      entity.setStatus(updateDepartmentRequest.getStatus());
    }

    departmentRepository.save(entity);
    builder.done();
  }

  /**
   * Delete department
   */
  @Override
  public void deleteDepartment(SimpleResultBuilder<String> builder, Integer departmentId) {
    DepartmentEntity entity = departmentRepository.findById(departmentId.longValue())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(com.apihug.rad.infra.department.DepartmentErrorEnum.DEPARTMENT_NOT_FOUND).build());

    // 检查是否有子部门
    List<DepartmentEntity> children = departmentRepository.findByParentId(entity.getId());
    if (!children.isEmpty()) {
      throw HopeErrorDetailException.errorBuilder(com.apihug.rad.infra.department.DepartmentErrorEnum.DEPARTMENT_HAS_CHILDREN).build();
    }

    // 软删除
    entity.setDeleted(true)
        .setDeletedAt(LocalDateTime.now())
        .setDeletedBy(((Long) hope.common.spring.security.context.HopeContextHolder.customer().getId()));

    departmentRepository.save(entity);
    builder.done();
  }

  /**
   * Get department tree
   */
  @Override
  public void getDepartmentTree(SimpleResultBuilder<DepartmentTreeNode> builder) {
    // 获取所有根部门（parent_id = 0）
    List<DepartmentEntity> rootDepts = departmentRepository.findByParentId(0L);

    // 构建树形结构
    List<DepartmentTreeNode> children = new ArrayList<>();
    for (DepartmentEntity rootDept : rootDepts) {
      DepartmentTreeNode node = buildDepartmentTreeNode(rootDept);
      children.add(node);
    }

    DepartmentTreeNode root = new DepartmentTreeNode();
    root.setChildren(children);
    builder.payload(root);
  }

  /**
   * Build department tree node recursively
   */
  private DepartmentTreeNode buildDepartmentTreeNode(DepartmentEntity entity) {
    DepartmentTreeNode node = new DepartmentTreeNode();
    node.setDepartment(new DepartmentSummary()
        .setId(entity.getId())
        .setParentId(entity.getParentId())
        .setDeptCode(entity.getDeptCode())
        .setDeptName(entity.getDeptName())
        .setStatus(entity.getStatus()));

    // 递归构建子部门
    List<DepartmentEntity> children = departmentRepository.findByParentId(entity.getId());
    List<DepartmentTreeNode> childNodes = new ArrayList<>();
    for (DepartmentEntity child : children) {
      childNodes.add(buildDepartmentTreeNode(child));
    }
    node.setChildren(childNodes);

    return node;
  }
}
