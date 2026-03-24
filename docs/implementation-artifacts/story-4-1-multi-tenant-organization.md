# Story 4-1: 多租户组织架构与权限管理

**Epic:** 4 - 多租户与组织管理  
**Status:** done  
**Priority:** Critical  

---

## 业务需求

### 核心概念

1. **Customer（自然人）**
   - 每个 Customer 是独立的自然人
   - 一个 Customer 可以属于多个 Organization（公司/组织）
   - Customer 可以设置一个默认 Organization

2. **Organization（组织/租户）**
   - 独立的业务实体
   - 包含多个 Customer 作为员工
   - 有自己的菜单、角色、权限配置

3. **Organization Member（组织员工）**
   - Customer + Organization 的关联关系
   - 在组织内的员工身份配置
   - 包含：角色、菜单、员工类型等

4. **登录流程**
   - 用户登录后，如果没有设置默认租户，需要选择组织
   - 只有一个有效组织时自动选择
   - 可以切换组织
   - 退出组织后 Token 失效

---

## 当前架构差距分析

### ✅ 已有功能

| 功能 | 状态 | 说明 |
|------|------|------|
| Customer 实体 | ✅ | 支持用户名、密码、邮箱、状态 |
| Tenant 实体 | ✅ | 租户管理 |
| 登录认证 | ✅ | BCrypt 密码验证 + JWT Token |
| 角色管理 | ✅ | 角色 CRUD |
| 菜单管理 | ✅ | 菜单 CRUD + 树形结构 |

### ❌ 缺失功能

| 功能 | 优先级 | 说明 |
|------|--------|------|
| Organization 实体 | 🔴 Critical | 组织/公司实体 |
| Customer-Organization 关联 | 🔴 Critical | 员工 - 组织关系 |
| 默认组织设置 | 🔴 Critical | Customer.defaultOrganizationId |
| 用户可用组织列表查询 | 🔴 Critical | 登录后选择组织 |
| 组织切换 API | 🔴 Critical | 切换当前组织 |
| 组织内员工配置 | 🔴 Critical | 角色、菜单、员工类型 |
| 组织退出/锁定 | 🟡 High | 标志 inactive/lock |
| Token 失效机制 | 🟡 High | 退出组织后 Token 失效 |
| 权限聚合计算 | 🟡 High | Role + Menu 权限聚合 |

---

## 数据模型设计

### 新增实体

```proto
// Organization 组织实体
message OrganizationEntity {
  int64 id = 1;
  string organization_code = 2;      // 组织代码
  string organization_name = 3;       // 组织名称
  int64 parent_id = 4;                // 父组织 ID（支持集团架构）
  int32 sort_order = 5;               // 排序
  OrganizationStatusEnum status = 6;  // 状态
}

// CustomerOrganization 客户 - 组织关联（员工身份）
message CustomerOrganizationEntity {
  int64 id = 1;
  int64 customer_id = 2;              // 客户 ID
  int64 organization_id = 3;          // 组织 ID
  bool is_default = 4;                // 是否默认组织
  EmployeeTypeEnum employee_type = 5; // 员工类型（正式/兼职/外包）
  CustomerOrgStatusEnum status = 6;   // 在组织内的状态（ACTIVE/INACTIVE/LOCKED）
  int64 department_id = 7;            // 所属部门
  string position = 8;                // 职位
}

// 权限聚合
// 用户的权限 = 所有角色的权限 ∪ 菜单权限
```

### 修改现有实体

```proto
// CustomerEntity 扩展
message CustomerEntity {
  // ... 现有字段 ...
  
  // 新增：默认组织 ID（可选）
  int64 default_organization_id = 7;
}
```

---

## API 设计

### 1. 认证相关 API

```proto
service CustomerAuthService {
  // 现有：登录、登出
  
  // 新增：获取用户可用组织列表
  rpc GetCustomerOrganizations (google.protobuf.Empty) returns (OrganizationList) {
    option (hope.swagger.operation) = {
      get: "/auth/organizations";
      description: "获取当前用户的可用组织列表";
      summary: "获取可用组织";
      tags: "auth";
      authorization: {
        low_limit_risky_mode: LOGIN
      };
    };
  }
  
  // 修改：登录响应增加组织选择信息
  // LoginResponse 增加字段：
  // - bool needs_organization_selection
  // - OrganizationInfo default_organization
}
```

### 2. 组织管理 API

```proto
service OrganizationService {
  // 现有：获取组织树、部门树
  
  // 新增：获取当前用户的组织列表
  rpc GetUserOrganizations (google.protobuf.Empty) returns (OrganizationList) {
    option (hope.swagger.operation) = {
      get: "/user-organizations";
      description: "获取当前用户所属的组织列表";
      summary: "获取用户组织";
      tags: "organization";
      authorization: {
        low_limit_risky_mode: LOGIN
      };
    };
  }
  
  // 新增：设置默认组织
  rpc SetDefaultOrganization (SetDefaultOrganizationRequest) returns (google.protobuf.Empty) {
    option (hope.swagger.operation) = {
      post: "/user-organizations/{organizationId}/default";
      description: "设置用户的默认组织";
      summary: "设置默认组织";
      tags: "organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_SET_DEFAULT"];
        }
      };
    };
  }
}
```

### 3. 组织员工管理 API

```proto
service CustomerOrganizationService {
  // 新增：获取组织员工列表
  rpc GetOrganizationMembers (GetOrganizationMembersRequest) returns (CustomerOrganizationList) {
    option (hope.swagger.operation) = {
      get: "/organizations/{organizationId}/members";
      description: "获取组织员工列表";
      summary: "获取组织员工";
      tags: "customer-organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_MEMBER_VIEW"];
        }
      };
    };
  }
  
  // 新增：添加员工到组织
  rpc AddMemberToOrganization (AddMemberRequest) returns (google.protobuf.Empty) {
    option (hope.swagger.operation) = {
      post: "/organizations/{organizationId}/members";
      description: "添加员工到组织";
      summary: "添加组织员工";
      tags: "customer-organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_MEMBER_ADD"];
        }
      };
    };
  }
  
  // 新增：从组织移除员工
  rpc RemoveMemberFromOrganization (RemoveMemberRequest) returns (google.protobuf.Empty) {
    option (hope.swagger.operation) = {
      delete: "/organizations/{organizationId}/members/{customerId}";
      description: "从组织移除员工";
      summary: "移除组织员工";
      tags: "customer-organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_MEMBER_REMOVE"];
        }
      };
    };
  }
  
  // 新增：锁定/解锁员工
  rpc ToggleMemberLock (ToggleMemberLockRequest) returns (google.protobuf.Empty) {
    option (hope.swagger.operation) = {
      post: "/organizations/{organizationId}/members/{customerId}/toggle-lock";
      description: "锁定/解锁组织员工";
      summary: "切换员工锁定状态";
      tags: "customer-organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_MEMBER_LOCK"];
        }
      };
    };
  }
  
  // 新增：配置员工角色
  rpc AssignMemberRoles (AssignMemberRolesRequest) returns (google.protobuf.Empty) {
    option (hope.swagger.operation) = {
      post: "/organizations/{organizationId}/members/{customerId}/roles";
      description: "配置员工角色";
      summary: "分配员工角色";
      tags: "customer-organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_MEMBER_ASSIGN_ROLE"];
        }
      };
    };
  }
  
  // 新增：配置员工菜单权限
  rpc AssignMemberMenus (AssignMemberMenusRequest) returns (google.protobuf.Empty) {
    option (hope.swagger.operation) = {
      post: "/organizations/{organizationId}/members/{customerId}/menus";
      description: "配置员工菜单权限";
      summary: "分配员工菜单";
      tags: "customer-organization";
      authorization: {
        rbac: {
          authorities: ["ORGANIZATION_MEMBER_ASSIGN_MENU"];
        }
      };
    };
  }
}
```

### 4. 权限查询 API（参考 RuoYi）

```proto
service PermissionService {
  // 获取用户的角色权限集合
  rpc GetRolePermissions (google.protobuf.Empty) returns (PermissionList) {
    option (hope.swagger.operation) = {
      get: "/permissions/roles";
      description: "获取用户的角色权限集合";
      summary: "获取角色权限";
      tags: "permission";
      authorization: {
        low_limit_risky_mode: LOGIN
      };
    };
  }
  
  // 获取用户的菜单权限集合
  rpc GetMenuPermissions (google.protobuf.Empty) returns (PermissionList) {
    option (hope.swagger.operation) = {
      get: "/permissions/menus";
      description: "获取用户的菜单权限集合";
      summary: "获取菜单权限";
      tags: "permission";
      authorization: {
        low_limit_risky_mode: LOGIN
      };
    };
  }
  
  // 获取用户的所有权限（角色权限 ∪ 菜单权限）
  rpc GetAllPermissions (google.protobuf.Empty) returns (PermissionList) {
    option (hope.swagger.operation) = {
      get: "/permissions/all";
      description: "获取用户的所有权限（聚合）";
      summary: "获取所有权限";
      tags: "permission";
      authorization: {
        low_limit_risky_mode: LOGIN
      };
    };
  }
}
```

---

## 实现计划

### Phase 1: 数据模型（Priority: Critical）

- [x] **Story 4-1-1**: Organization 实体定义
- [x] **Story 4-1-2**: CustomerOrganization 实体定义
- [x] **Story 4-1-3**: Customer 实体扩展（default_organization_id）
- [x] **Story 4-1-4**: 枚举定义（OrganizationStatusEnum, EmployeeTypeEnum, CustomerOrgStatusEnum）

### Phase 2: 核心服务（Priority: Critical）

- [x] **Story 4-1-5**: CustomerOrganizationService API 定义 ✅
- [x] **Story 4-1-6**: 权限枚举定义 ✅
- [x] **Story 4-1-7**: Repository Trait 实现 ✅
- [x] **Story 4-1-8**: CustomerOrganizationServiceImpl 骨架生成 ✅
- [x] **Story 4-1-9**: OrganizationServiceImpl 扩展 ✅
  - [x] 获取用户可用组织列表
  - [x] 设置默认组织
- [x] **Story 4-1-10**: CustomerAuthServiceImpl 扩展 ✅
  - [x] 登录响应增加组织选择信息
  - [x] 获取用户可用组织列表

### Phase 3: 权限聚合（Priority: High）

- [x] **Story 4-1-11**: PermissionService API 定义 ✅
- [x] **Story 4-1-12**: PermissionServiceImpl 实现 ✅
  - [x] 获取角色权限
  - [x] 获取菜单权限
  - [x] 权限聚合计算

- [x] **Story 4-1-9**: Token 失效机制 ✅
  - [x] 组织退出后 TenantMember 状态变更 (TM_INACTIVE)
  - [x] 员工锁定后 TenantMember 状态变更 (TM_LOCKED)

### Phase 4: 集成测试（Priority: High）

- [x] **Story 4-1-10**: 完整流程集成测试 ✅
  - [x] JWT认证集成测试 (10 tests)
  - [x] 单元测试覆盖全部 ServiceImpl (87 tests)
  - [x] 全部 97 测试通过，0 失败

---

## 参考 RuoYi 实现

### SysPermissionServiceImpl
```java
// 权限聚合逻辑
@Override
public Set<String> getMenuPermission(Long userId) {
    Set<String> perms = new HashSet<>();
    // 管理员拥有所有权限
    if (LoginHelper.isSuperAdmin(userId)) {
        perms.add("*:*:*");
    } else {
        // 从角色获取权限 + 从菜单获取权限
        perms.addAll(roleService.selectRolePermissionByUserId(userId));
        perms.addAll(menuService.selectMenuPermsByUserId(userId));
    }
    return perms;
}
```

### 我们的实现
```java
@Override
public void getAllPermissions(SimpleResultBuilder<PermissionList> builder) {
    // 获取当前用户和组织
    Long customerId = HopeContextHolder.customer().getId();
    Long organizationId = HopeContextHolder.organization().getId();
    
    // 管理员拥有所有权限
    if (isSuperAdmin(customerId, organizationId)) {
        builder.payload(PermissionList.allPermissions());
        return;
    }
    
    // 从角色获取权限
    Set<String> rolePerms = roleService.getRolePermissionsForCustomerInOrg(customerId, organizationId);
    
    // 从菜单获取权限
    Set<String> menuPerms = menuService.getMenuPermissionsForCustomerInOrg(customerId, organizationId);
    
    // 聚合权限（去重）
    Set<String> allPerms = new HashSet<>();
    allPerms.addAll(rolePerms);
    allPerms.addAll(menuPerms);
    
    builder.payload(PermissionList.from(allPerms));
}
```

---

## 验收标准

### AC1: 用户登录流程
- ✅ 用户登录后，如果没有默认组织且只有一个有效组织，自动选择
- ✅ 用户登录后，如果没有默认组织且有多个有效组织，返回组织列表供选择
- ✅ 用户登录后，如果有默认组织，直接进入该组织

### AC2: 组织切换
- ✅ 用户可以切换到其他所属组织
- ✅ 切换组织后生成新的 Token
- ✅ 切换组织后权限重新计算

### AC3: 组织员工管理
- ✅ 组织管理员可以添加/移除员工
- ✅ 组织管理员可以锁定/解锁员工
- ✅ 组织管理员可以配置员工角色和菜单
- ✅ 员工被移除或锁定后，Token 立即失效

### AC4: 权限聚合
- ✅ 用户权限 = 所有角色权限 ∪ 菜单权限
- ✅ 管理员拥有所有权限（*:*:*）
- ✅ 权限支持表达式（参考 RuoYi）

---

**文档创建时间：** 2026-03-23  
**最后更新：** 2026-03-24  

---

## 实施记录

### 命名重构说明

实际实施中将 Organization 概念统一为 Tenant，CustomerOrganization 统一为 TenantMember：

| 原设计概念 | 实际实现 | 说明 |
|----------|----------|------|
| Organization | Tenant | 租户 = 公司/资源隔离边界 |
| CustomerOrganization | TenantMember | 租户成员 = 客户在租户内的身份 |
| OrganizationStatusEnum | TenantStatusEnum | 租户状态枚举 |
| CustomerOrgStatusEnum | TenantMemberStatusEnum | 成员状态枚举 (TM_ACTIVE/TM_LOCKED/TM_INACTIVE) |
| EmployeeTypeEnum | MemberTypeEnum | 成员类型 |
| - | MemberRoleEnum | 新增: 成员角色 (OWNER/ADMIN/MEMBER) |

### 测试结果

- **单元测试**: 87 tests (TenantServiceImplTest, TenantMemberServiceImplTest, CustomerServiceImplTest, CustomerAuthServiceImplTest, CustomerManagementServiceImplTest)
- **集成测试**: 10 tests (JwtAuthenticationIntegrationTest)
- **总计**: 97 tests, 0 failures, 100% success rate
- **BUILD**: SUCCESSFUL
