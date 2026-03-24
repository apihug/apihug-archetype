# 组织管理模块详细文档

**模块路径：** `com.apihug.rad.api.organization`  
**主要 Service：** `OrganizationServiceImpl`  
**Proto 文件：** `api/organization/api.proto`  

---

## 📋 功能概述

组织管理模块提供组织树和部门树查询功能：

- ✅ 组织树查询
- ✅ 部门树查询
- ✅ 获取用户部门列表

---

## 🏗️ 架构设计

### API 端点

| API | 方法 | 端点 | 说明 |
|-----|------|------|------|
| 获取组织树 | GET | `/api/organizations/tree` | 获取完整组织树 |
| 获取部门树 | GET | `/api/organizations/department-tree` | 获取当前组织部门树 |
| 获取用户部门 | GET | `/api/organizations/user-departments` | 获取用户所属部门 |

---

## 🔧 核心功能实现

### 1. 获取组织树

**API:** `GET /api/organizations/tree`

**实现：**

```java
@Override
public void getOrganizationTree(SimpleResultBuilder<OrganizationTreeNode> builder) {
  OrganizationTreeNode root = buildOrganizationTree(0L);
  builder.payload(root);
}

private OrganizationTreeNode buildOrganizationTree(Long parentId) {
  OrganizationTreeNode node = new OrganizationTreeNode();
  node.setOrganization(new OrganizationSummary()
      .setId(parentId)
      .setOrganizationName(parentId == 0L ? "根组织" : "子组织"));
  
  // TODO: 递归查询子组织
  List<OrganizationTreeNode> children = new ArrayList<>();
  node.setChildren(children);
  
  return node;
}
```

**TODO 实现：**
- [ ] 组织实体定义
- [ ] 组织 Repository
- [ ] 递归查询子组织

---

### 2. 获取部门树

**API:** `GET /api/organizations/department-tree`

**实现：**

```java
@Override
public void getDepartmentTree(SimpleResultBuilder<DepartmentTreeNode> builder) {
  DepartmentTreeNode root = buildDepartmentTree(0L);
  builder.payload(root);
}

private DepartmentTreeNode buildDepartmentTree(Long parentId) {
  DepartmentTreeNode node = new DepartmentTreeNode();
  node.setDepartment(new DepartmentSummary()
      .setId(parentId)
      .setDeptName(parentId == 0L ? "根部门" : "子部门"));
  
  // TODO: 递归查询子部门
  List<DepartmentTreeNode> children = new ArrayList<>();
  node.setChildren(children);
  
  return node;
}
```

---

## 📝 待完善功能

### 高优先级
- [ ] 组织实体定义
- [ ] 组织 Repository 实现
- [ ] 递归查询优化（缓存）

### 中优先级
- [ ] 组织路径计算
- [ ] 组织统计信息
- [ ] 组织权限隔离

---

**文档更新日期：** 2026-03-20
