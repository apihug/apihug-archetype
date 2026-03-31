// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.domain.department.DepartmentEntity;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.infra.department.DepartmentErrorEnum;
import com.apihug.rad.infra.department.DeptStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.SimpleResultBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import hope.common.spring.security.context.HopeContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Template(type = Template.Type.SERVICE, usage = "Department management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentService",
    kind = Kind.RPC,
    line = 11,
    column = 1)
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentEntityRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentEntityRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  /** Create department */
  @Override
  @Transactional
  public void createDepartment(
      SimpleResultBuilder<DepartmentSummary> builder,
      CreateDepartmentRequest createDepartmentRequest) {

    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    // 验证部门代码唯一性（租户内唯一）
    if (departmentRepository.existsByDeptCodeAndTenantId(
        createDepartmentRequest.getDeptCode(), tenantId)) {
      throw HopeErrorDetailException.errorBuilder(DepartmentErrorEnum.DEPT_CODE_EXISTS).build();
    }

    // 验证父部门（如果 parentId != 0，必须属于同一租户）
    if (createDepartmentRequest.getParentId() != null && createDepartmentRequest.getParentId() != 0) {
      departmentRepository.findByIdAndTenantId(createDepartmentRequest.getParentId(), tenantId)
          .orElseThrow(() -> HopeErrorDetailException.errorBuilder(
              DepartmentErrorEnum.DEPARTMENT_NOT_FOUND).build());
    }

    // 创建部门实体
    DepartmentEntity entity =
        new DepartmentEntity()
            .setParentId(createDepartmentRequest.getParentId())
            .setDeptCode(createDepartmentRequest.getDeptCode())
            .setDeptName(createDepartmentRequest.getDeptName())
            .setSortOrder(createDepartmentRequest.getSortOrder())
            .setManagerId(createDepartmentRequest.getManagerId())
            .setStatus(
                createDepartmentRequest.getStatus() != null
                    ? createDepartmentRequest.getStatus()
                    : DeptStatusEnum.ACTIVE);

    // 保存部门
    DepartmentEntity saved = departmentRepository.save(entity);

    // 返回摘要
    DepartmentSummary summary =
        new DepartmentSummary()
            .setId(saved.getId())
            .setParentId(saved.getParentId())
            .setDeptCode(saved.getDeptCode())
            .setDeptName(saved.getDeptName())
            .setStatus(saved.getStatus());

    builder.payload(summary);
  }

  /** Get department detail */
  @Override
  public void getDepartment(SimpleResultBuilder<DepartmentDetail> builder, Integer departmentId) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    DepartmentEntity entity =
        departmentRepository
            .findByIdAndTenantId(departmentId.longValue(), tenantId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(DepartmentErrorEnum.DEPARTMENT_NOT_FOUND)
                        .build());

    DepartmentDetail detail =
        new DepartmentDetail()
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

  /** Update department */
  @Override
  @Transactional
  public void updateDepartment(
      SimpleResultBuilder<String> builder,
      Integer departmentId,
      UpdateDepartmentRequest updateDepartmentRequest) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    DepartmentEntity entity =
        departmentRepository
            .findByIdAndTenantId(departmentId.longValue(), tenantId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(DepartmentErrorEnum.DEPARTMENT_NOT_FOUND)
                        .build());

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
  }

  /** Delete department */
  @Override
  @Transactional
  public void deleteDepartment(SimpleResultBuilder<String> builder, Integer departmentId) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    DepartmentEntity entity =
        departmentRepository
            .findByIdAndTenantId(departmentId.longValue(), tenantId)
            .orElseThrow(
                () ->
                    HopeErrorDetailException.errorBuilder(
                            com.apihug.rad.infra.department.DepartmentErrorEnum
                                .DEPARTMENT_NOT_FOUND)
                        .build());

    // 检查是否有子部门（同租户内）
    List<DepartmentEntity> children =
        departmentRepository.findByParentIdAndTenantId(entity.getId(), tenantId);
    if (!children.isEmpty()) {
      throw HopeErrorDetailException.errorBuilder(
              com.apihug.rad.infra.department.DepartmentErrorEnum.DEPARTMENT_HAS_CHILDREN)
          .build();
    }

    // 软删除
    entity
        .setDeleted(true)
        .setDeletedAt(LocalDateTime.now())
        .setDeletedBy(
            ((Long) hope.common.spring.security.context.HopeContextHolder.customer().getId()));

    departmentRepository.save(entity);
  }

  /** Get department tree */
  @Override
  public void getDepartmentTree(SimpleResultBuilder<DepartmentTreeNode> builder) {
    RadCustomer customer = HopeContextHolder.customer();
    Long tenantId = customer.getTenantId();
    // 一次性加载当前租户所有未删除部门，避免递归 N+1
    List<DepartmentEntity> allDepts = departmentRepository.findByTenantIdAndDeletedFalse(tenantId);

    // 按 parentId 分组
    Map<Long, List<DepartmentEntity>> childrenMap =
        allDepts.stream().collect(Collectors.groupingBy(DepartmentEntity::getParentId));

    // 构建树形结构（根部门 parentId = 0）
    List<DepartmentTreeNode> children = buildDepartmentChildren(childrenMap, 0L);

    DepartmentTreeNode root = new DepartmentTreeNode();
    root.setChildren(children);
    builder.payload(root);
  }

  /** Build department tree children from pre-loaded map */
  private List<DepartmentTreeNode> buildDepartmentChildren(
      Map<Long, List<DepartmentEntity>> childrenMap, Long parentId) {
    List<DepartmentEntity> children = childrenMap.getOrDefault(parentId, List.of());
    List<DepartmentTreeNode> nodes = new ArrayList<>();
    for (DepartmentEntity entity : children) {
      DepartmentTreeNode node = new DepartmentTreeNode();
      node.setDepartment(
          new DepartmentSummary()
              .setId(entity.getId())
              .setParentId(entity.getParentId())
              .setDeptCode(entity.getDeptCode())
              .setDeptName(entity.getDeptName())
              .setStatus(entity.getStatus()));
      node.setChildren(buildDepartmentChildren(childrenMap, entity.getId()));
      nodes.add(node);
    }
    return nodes;
  }
}
