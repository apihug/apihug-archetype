# 部门管理模块详细文档

**模块路径：** `com.apihug.rad.api.department`  
**主要 Service：** `DepartmentServiceImpl`  
**Proto 文件：** `api/department/api.proto`  
**实体文件：** `domain/department/domain.proto`  

---

## 📋 功能概述

部门管理模块提供完整的部门 CRUD 功能：

### 部门管理
- ✅ 部门 CRUD
- ✅ 部门树查询
- ✅ 部门搜索（分页）
- ✅ 租户隔离（tenant_id）

> **注意：** 员工/成员与部门的关联已移至租户成员管理模块（TenantMemberService），
> 通过 TenantMemberEntity.department_id 实现成员部门分配。

---

## 🏗️ 架构设计

### 组件关系

```
┌─────────────────────────────────────────────────────────┐
│              DepartmentController (Generated)            │
├─────────────────────────────────────────────────────────┤
│              DepartmentServiceImpl                       │
│  - createDepartment()                                    │
│  - getDepartment()                                       │
│  - updateDepartment()                                    │
│  - deleteDepartment()                                    │
│  - getDepartmentTree()                                   │
│  - searchDepartments()                                   │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│         _DepartmentEntityRepository (Trait)             │
│  - findByParentId()                                     │
│  - searchDepartments()                                  │
└─────────────────────────────────────────────────────────┘
```

---

## 🔧 核心功能实现

### 1. 创建部门

**API:** `POST /api/departments`

**实现要点：**
- 验证部门代码唯一性
- 验证父部门存在
- 设置默认状态

**代码示例：**

```java
@Override
public void createDepartment(SimpleResultBuilder<DepartmentSummary> builder,
    CreateDepartmentRequest createRequest) {
  
  // 1. 验证部门代码唯一性
  if (departmentRepository.existsByDeptCode(createRequest.getDeptCode())) {
    throw HopeErrorDetailException.errorBuilder(DepartmentErrorEnum.DEPT_CODE_EXISTS).build();
  }

  // 2. 验证父部门存在（如果 parent_id != 0）
  if (createRequest.getParentId() != 0) {
    departmentRepository.findById(createRequest.getParentId())
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(DepartmentErrorEnum.INVALID_PARENT_DEPARTMENT).build());
  }

  // 3. 创建实体
  DepartmentEntity entity = new DepartmentEntity()
      .setTenantId(createRequest.getTenantId())
      .setParentId(createRequest.getParentId())
      .setDeptCode(createRequest.getDeptCode())
      .setDeptName(createRequest.getDeptName())
      .setSortOrder(createRequest.getSortOrder())
      .setManagerId(createRequest.getManagerId())
      .setStatus(createRequest.getStatus() != null 
          ? createRequest.getStatus() 
          : DeptStatusEnum.ACTIVE);

  // 4. 保存
  DepartmentEntity saved = departmentRepository.save(entity);

  // 5. 返回摘要
  DepartmentSummary summary = new DepartmentSummary()
      .setId(saved.getId())
      .setParentId(saved.getParentId())
      .setDeptCode(saved.getDeptCode())
      .setDeptName(saved.getDeptName())
      .setStatus(saved.getStatus());

  builder.payload(summary);
}
```

---

### 2. 获取部门树

**API:** `GET /api/departments/tree`

**实现要点：**
- 递归查询子部门
- 构建树形结构

**代码示例：**

```java
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
 * 递归构建部门树节点
 */
private DepartmentTreeNode buildDepartmentTreeNode(DepartmentEntity entity) {
  DepartmentTreeNode node = new DepartmentTreeNode();
  node.setDepartment(new DepartmentSummary()
      .setId(entity.getId())
      .setParentId(entity.getParentId())
      .setDeptCode(entity.getDeptCode())
      .setDeptName(entity.getDeptName())
      .setStatus(entity.getStatus()));
  
  // 递归查询子部门
  List<DepartmentEntity> children = departmentRepository.findByParentId(entity.getId());
  List<DepartmentTreeNode> childNodes = new ArrayList<>();
  for (DepartmentEntity child : children) {
    childNodes.add(buildDepartmentTreeNode(child));
  }
  node.setChildren(childNodes);
  
  return node;
}
```

---

### 3. 添加员工到部门

**API:** `POST /api/department-employees`

**实现要点：**
- 检查员工是否已在该部门
- 创建关联关系

**代码示例：**

```java
@Override
public void addEmployeeToDepartment(SimpleResultBuilder<String> builder,
    AddEmployeeRequest addEmployeeRequest) {
  
  // 1. 检查是否已存在
  if (employeeRepository.existsByEmployeeIdAndDepartmentId(
      addEmployeeRequest.getEmployeeId(), 
      addEmployeeRequest.getDepartmentId())) {
    builder.done();
    return;
  }

  // 2. 创建关联
  DepartmentEmployeeEntity entity = new DepartmentEmployeeEntity()
      .setEmployeeId(addEmployeeRequest.getEmployeeId())
      .setDepartmentId(addEmployeeRequest.getDepartmentId())
      .setPosition(addEmployeeRequest.getPosition())
      .setIsPrimary(false);

  employeeRepository.save(entity);
  builder.done();
}
```

---

### 4. 员工调岗

**API:** `POST /api/department-employees/transfer`

**实现要点：**
- 从原部门移除
- 添加到新部门
- 设置为主部门

**代码示例：**

```java
@Override
public void transferEmployee(SimpleResultBuilder<String> builder,
    TransferEmployeeRequest transferEmployeeRequest) {
  
  // 1. 从原部门移除
  employeeRepository.findByEmployeeIdAndDepartmentId(
      transferEmployeeRequest.getEmployeeId(), 
      transferEmployeeRequest.getFromDepartmentId())
      .ifPresent(employeeRepository::delete);

  // 2. 添加到新部门
  DepartmentEmployeeEntity entity = new DepartmentEmployeeEntity()
      .setEmployeeId(transferEmployeeRequest.getEmployeeId())
      .setDepartmentId(transferEmployeeRequest.getToDepartmentId())
      .setPosition(transferEmployeeRequest.getPosition())
      .setIsPrimary(true);

  employeeRepository.save(entity);
  builder.done();
}
```

---

## 📊 数据库表结构

### SYS_DEPARTMENT (部门表)

| 字段 | 类型 | 约束 | 说明 |
|------|------|------|------|
| ID | BIGINT | PRIMARY KEY | 主键 |
| TENANT_ID | BIGINT | NOT NULL | 租户 ID |
| PARENT_ID | BIGINT | NOT NULL, DEFAULT 0 | 父部门 ID |
| DEPT_CODE | VARCHAR(50) | UNIQUE, NOT NULL | 部门代码 |
| DEPT_NAME | VARCHAR(100) | NOT NULL | 部门名称 |
| SORT_ORDER | INT | NOT NULL, DEFAULT 0 | 排序顺序 |
| MANAGER_ID | BIGINT | | 部门负责人 ID |
| STATUS | VARCHAR(20) | NOT NULL, DEFAULT 'ACTIVE' | 状态 |
| DELETED | BOOLEAN | NOT NULL, DEFAULT FALSE | 软删除标记 |
| DELETED_AT | TIMESTAMP | | 删除时间 |
| DELETED_BY | BIGINT | | 删除人 |
| CREATED_AT | TIMESTAMP | NOT NULL | 创建时间 |
| CREATED_BY | BIGINT | NOT NULL | 创建人 |
| UPDATED_AT | TIMESTAMP | | 更新时间 |
| UPDATED_BY | BIGINT | | 更新人 |

**索引：**
```sql
CREATE UNIQUE INDEX UK_SYS_DEPT_CODE ON SYS_DEPARTMENT(DEPT_CODE);
CREATE INDEX IDX_SYS_DEPT_PARENT_ID ON SYS_DEPARTMENT(PARENT_ID);
CREATE INDEX IDX_SYS_DEPT_TENANT_ID ON SYS_DEPARTMENT(TENANT_ID);
CREATE INDEX IDX_SYS_DEPT_CODE ON SYS_DEPARTMENT(DEPT_CODE);
```

> **注意：** 原 SYS_DEPARTMENT_EMPLOYEE 表已废弃，成员部门关联通过 SYS_TENANT_MEMBER.DEPARTMENT_ID 实现。

---

## 🧪 测试覆盖

### 单元测试

| 测试类 | 测试方法数 | 覆盖功能 |
|--------|-----------|---------|
| `DepartmentServiceImplTest` | 11 | 部门 CRUD、树查询 |

---

## 📝 待完善功能

### 高优先级
- [ ] 部门路径计算（用于快速查询上级部门）
- [ ] 部门负责人自动关联客户
- [ ] 部门成员统计（通过 TenantMember.department_id 查询）

### 中优先级
- [ ] 部门合并功能
- [ ] 部门历史变更记录
- [ ] 部门编制管理

---

**文档更新日期：** 2026-03-24
