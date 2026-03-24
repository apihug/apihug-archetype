---
epic: 3
story: 1
key: "3-1-advanced-auth-organization"
title: "高级认证与组织管理"
status: ready-for-dev
created: '2026-03-20'
author: Aaron
---

# Story: 高级认证与组织管理

**Epic:** 3 - 高级认证与权限
**Story:** 3-1
**Status:** ready-for-dev

---

## User Story

作为企业用户，我希望能够登录后选择组织、切换组织，并获取当前组织的权限、角色、部门等信息，以便在多组织环境下高效工作。

---

## Background (参考 RuoYi 实现)

### RuoYi 登录流程分析

**核心功能：**
1. **登录验证** - 用户名密码验证 + 错误次数限制
2. **用户信息构建** - 用户基本信息 + 部门信息
3. **权限加载** - 菜单权限 + 角色权限
4. **岗位信息** - 用户关联的岗位列表
5. **登录日志** - 记录登录 IP、时间、状态
6. **租户支持** - 多租户环境下的登录处理

**关键类：**
- `SysLoginService` - 登录核心服务
- `LoginUser` - 登录用户模型（包含完整信息）
- `LoginHelper` - 登录辅助工具

---

## ApiHug 特殊设计

### 账户与组织独立

**核心概念：**
- **Customer (用户)** - 独立的账户体系，可属于多个组织
- **Organization (组织)** - 独立的组织体系，用户可加入多个组织
- **Token** - 包含用户 ID + 当前组织 ID
- **切换组织** - 用户可切换 Token 中的组织 ID

**登录流程：**
```
1. 用户登录 (username + password)
   ↓
2. 验证用户身份
   ↓
3. 获取用户的所有组织列表
   ↓
4. 选择默认组织或用户指定组织
   ↓
5. 生成 Token (userId + organizationId)
   ↓
6. 加载当前组织的权限、角色、部门等信息
```

---

## Acceptance Criteria

**AC1: 用户登录**
- Given 用户输入用户名和密码
- When 验证成功
- Then 返回用户基本信息和可选组织列表
- And 自动选择默认组织（如果有）

**AC2: 选择组织登录**
- Given 用户有多个组织
- When 用户选择特定组织登录
- Then 生成包含该组织 ID 的 Token
- And 加载该组织的权限信息

**AC3: 切换组织**
- Given 用户已登录
- When 用户切换到另一个组织
- Then 生成新的 Token（新组织 ID）
- And 刷新当前组织的权限、角色、部门信息

**AC4: 获取当前用户信息**
- Given 用户已登录
- When 请求获取当前用户信息
- Then 返回用户基本信息
- And 返回当前组织信息
- And 返回当前组织的角色列表
- And 返回当前组织的权限列表
- And 返回用户的部门信息
- And 返回用户的岗位信息（如果有）

**AC5: 获取组织架构**
- Given 用户已登录
- When 请求获取组织架构
- Then 返回完整的部门树形结构
- And 标记用户当前所在部门

**AC6: 登录失败处理**
- Given 用户登录失败
- When 连续失败 5 次
- Then 锁定账户 10 分钟
- And 记录登录日志

**AC7: 登录日志**
- Given 用户登录成功/失败
- When 登录完成
- Then 记录登录日志（IP、时间、地点、状态）

---

## Tasks

### Phase 1: Proto 设计

- [ ] Task 1.1: 设计认证 API Proto
  - File: `rad-app/src/main/proto/com/apihug/rad/api/auth/api.proto`
  - API:
    - `Login` - 用户登录
    - `Logout` - 退出登录
    - `GetOrganizations` - 获取用户的组织列表
    - `SwitchOrganization` - 切换组织
    - `GetCurrentUserInfo` - 获取当前用户信息

- [ ] Task 1.2: 设计组织管理 API Proto
  - File: `rad-app/src/main/proto/com/apihug/rad/api/organization/api.proto`
  - API:
    - `GetOrganizationTree` - 获取组织树
    - `GetDepartmentTree` - 获取部门树
    - `GetUserDepartments` - 获取用户的部门列表

- [ ] Task 1.3: 设计实体 Proto
  - File: `rad-app/src/main/proto/com/apihug/rad/domain/organization/domain.proto`
  - Entity: `OrganizationEntity`, `UserOrganizationEntity`

- [ ] Task 1.4: 扩展错误枚举
  - File: `rad-app/src/main/proto/com/apihug/rad/infra/auth/error.proto`
  - Errors: `LOGIN_FAIL`, `ACCOUNT_LOCKED`, `ORGANIZATION_NOT_FOUND`

- [ ] Task 1.5: 扩展权限枚举
  - File: `rad-app/src/main/proto/com/apihug/rad/infra/settings/authority.proto`
  - Authorities: `ORGANIZATION_VIEW`, `ORGANIZATION_SWITCH`

### Phase 2: 实现

- [ ] Task 2.1: 实现 AuthServiceImpl
  - File: `rad-app/src/main/java/com/apihug/rad/api/auth/AuthServiceImpl.java`
  - Methods:
    - `login()` - 登录验证
    - `logout()` - 退出登录
    - `getOrganizations()` - 获取组织列表
    - `switchOrganization()` - 切换组织

- [ ] Task 2.2: 实现 OrganizationServiceImpl
  - File: `rad-app/src/main/java/com/apihug/rad/api/organization/OrganizationServiceImpl.java`
  - Methods:
    - `getOrganizationTree()` - 获取组织树
    - `getDepartmentTree()` - 获取部门树
    - `getUserDepartments()` - 获取用户部门

- [ ] Task 2.3: 扩展 Repository Trait
  - File: `rad-app/src/main/trait/t/com/apihug/rad/domain/organization/repository/_OrganizationEntityRepository.java`
  - Methods: 组织查询、用户组织关联查询

- [ ] Task 2.4: 实现登录日志
  - File: `rad-app/src/main/java/com/apihug/rad/api/auth/LoginLogServiceImpl.java`
  - Methods: 记录登录日志、查询登录日志

### Phase 3: 测试

- [ ] Task 3.1: 编写 AuthServiceImpl 单元测试
- [ ] Task 3.2: 编写 OrganizationServiceImpl 单元测试
- [ ] Task 3.3: 编写集成测试（Liquibase 测试数据）

---

## Dev Notes

### 技术规格参考

**参考 RuoYi 实现：**
- `LoginUser` 模型设计 - 包含用户完整信息
- 登录失败次数限制 - Redis 计数
- 登录日志记录 - 异步事件

**ApiHug 实现要点：**
- Token 结构：`userId + organizationId`
- 权限加载：当前组织下的权限
- 部门加载：当前组织下的部门

### 数据模型设计

**用户 - 组织关联：**
```proto
message UserOrganizationEntity {
  int64 user_id = 1;
  int64 organization_id = 2;
  bool is_default = 3;  // 是否默认组织
  int64 department_id = 4;  // 所属部门
}
```

**Token 结构：**
```java
class TokenPayload {
  Long userId;
  Long organizationId;
  Long expireTime;
}
```

### 登录流程

```
1. 接收登录请求 (username, password, organizationId?)
   ↓
2. 验证用户名密码
   ↓
3. 查询用户的所有组织
   ↓
4. 如果未指定 organizationId:
   - 有默认组织 → 使用默认组织
   - 无默认组织 → 返回组织列表让用户选择
   ↓
5. 生成 Token (userId + organizationId)
   ↓
6. 加载当前组织信息:
   - 用户角色列表
   - 用户权限列表
   - 用户部门信息
   - 组织架构
   ↓
7. 返回登录结果
```

### 切换组织流程

```
1. 接收切换组织请求 (newOrganizationId)
   ↓
2. 验证用户是否有该组织权限
   ↓
3. 生成新 Token (userId + newOrganizationId)
   ↓
4. 重新加载新组织信息:
   - 角色列表
   - 权限列表
   - 部门信息
   ↓
5. 返回新组织信息
```

---

## File List

### Files to Create

#### Proto Files
- [ ] `rad-app/src/main/proto/com/apihug/rad/api/auth/api.proto`
- [ ] `rad-app/src/main/proto/com/apihug/rad/api/organization/api.proto`
- [ ] `rad-app/src/main/proto/com/apihug/rad/domain/organization/domain.proto`
- [ ] `rad-app/src/main/proto/com/apihug/rad/infra/auth/error.proto`

#### Implementation Files
- [ ] `rad-app/src/main/java/com/apihug/rad/api/auth/AuthServiceImpl.java`
- [ ] `rad-app/src/main/java/com/apihug/rad/api/organization/OrganizationServiceImpl.java`
- [ ] `rad-app/src/main/java/com/apihug/rad/api/auth/LoginLogServiceImpl.java`

#### Test Files
- [ ] `rad-app/src/test/java/com/apihug/rad/api/auth/AuthServiceImplTest.java`
- [ ] `rad-app/src/test/java/com/apihug/rad/api/organization/OrganizationServiceImplTest.java`
- [ ] `rad-app/src/test/resources/liquibase/test-data-auth.xml`

---

## Change Log

| Date | Author | Changes |
|------|--------|---------|
| 2026-03-20 | Aaron | Initial story creation |

---

## Status

**Current Status:** ready-for-dev
**Last Updated:** 2026-03-20
