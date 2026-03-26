// @formatter:off
package com.apihug.rad.api.department;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/department/api.proto",
    entity = "DepartmentService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface DepartmentService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/departments/departments}
   * 	<p>{@code 创建新部门}
   */
  default void createDepartment(SimpleResultBuilder<DepartmentSummary> builder,
      CreateDepartmentRequest createDepartmentRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/departments/departments/{departmentId}}
   * 	<p>{@code 获取部门详情}
   */
  default void getDepartment(SimpleResultBuilder<DepartmentDetail> builder, Integer departmentId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/departments/departments/{departmentId}}
   * 	<p>{@code 更新部门信息}
   */
  default void updateDepartment(SimpleResultBuilder<String> builder, Integer departmentId,
      UpdateDepartmentRequest updateDepartmentRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [DEPARTMENT_DELETE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/departments/departments/{departmentId}}
   * 	<p>{@code 删除部门（软删除）}
   */
  default void deleteDepartment(SimpleResultBuilder<String> builder, Integer departmentId) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/departments/departments/tree}
   * 	<p>{@code 获取部门树形结构}
   */
  default void getDepartmentTree(SimpleResultBuilder<DepartmentTreeNode> builder) {
    builder.notImplemented();
  }
}
