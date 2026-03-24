# RAD 项目文档索引

**项目名称：** RAD (Rapid Application Development)  
**框架：** ApiHug 2.4.8-RELEASE  
**技术栈：** Java 18+, Spring Boot 3.5+, Vue 3 + Vben Admin  
**文档更新日期：** 2026-03-20  

---

## 📋 项目概述

RAD 是一个基于 ApiHug 框架的企业级快速应用开发模板，提供完整的用户管理、权限控制、多租户支持等功能。

**核心价值：**
- ⚡ 5 分钟启动新项目
- 🔐 内置企业级安全认证
- 🏢 完整的多租户支持
- 📊 完整的 RBAC 权限管理

---

## 🏗️ 项目结构

```
rad/
├── rad-app/                          # 后端主模块
│   ├── src/main/
│   │   ├── proto/                    # Proto DSL 定义
│   │   │   └── com/apihug/rad/
│   │   │       ├── api/              # API 层（服务定义）
│   │   │       ├── domain/           # 领域层（实体定义）
│   │   │       └── infra/            # 基础设施层（枚举、错误码）
│   │   ├── java/                     # Java 实现
│   │   │   └── com/apihug/rad/api/   # ServiceImpl 实现
│   │   ├── trait/                    # Repository trait 扩展
│   │   └── resources/                # 配置文件
│   └── src/test/                     # 测试代码
├── docs/                             # 项目文档
│   ├── planning-artifacts/           # 规划文档（PRD、Story 等）
│   └── implementation-artifacts/     # 实现文档
└── _bmad/                            # BMAD 配置
```

---

## 📚 详细文档

### 模块文档
- [认证模块](modules/auth-module.md) - 用户认证、Token 管理、组织切换
- [用户管理模块](modules/user-module.md) - 用户 CRUD、搜索、密码管理
- [角色管理模块](modules/role-module.md) - 角色 CRUD、权限分配
- [部门管理模块](modules/department-module.md) - 部门 CRUD、树形结构、员工管理
- [组织管理模块](modules/organization-module.md) - 组织树、部门树查询

### API 文档
- [API 参考文档](api-reference.md) - 完整的 API 端点、请求/响应示例

---

## 📦 功能模块

### 1. 认证与授权模块 (`auth/`, `customer/`)

**功能：**
- ✅ 用户登录/登出
- ✅ JWT Token 认证
- ✅ 获取当前用户信息
- ✅ 组织切换
- ✅ 权限加载

**关键文件：**
- Proto: `api/customer/api.proto`
- Service: `api/customer/CustomerAuthServiceImpl.java`
- Service: `api/customer/CustomerServiceImpl.java`

**API 端点：**
- `POST /api/auth/login` - 用户登录
- `POST /api/auth/logout` - 退出登录
- `GET /api/auth/current-user-info` - 获取当前用户信息
- `GET /api/auth/user-organizations` - 获取用户组织列表
- `POST /api/auth/switch-organization` - 切换组织

---

### 2. 用户管理模块 (`customer/`)

**功能：**
- ✅ 用户 CRUD
- ✅ 用户搜索（分页）
- ✅ 找回密码
- ✅ 重置密码

**关键文件：**
- Proto: `api/customer/api.proto`
- Domain: `domain/customer/domain.proto`
- Service: `api/customer/UserServiceImpl.java`

**API 端点：**
- `POST /api/users` - 创建用户
- `GET /api/users/{userId}` - 获取用户详情
- `PUT /api/users/{userId}` - 更新用户
- `DELETE /api/users/{userId}` - 删除用户
- `POST /api/users/search` - 搜索用户

---

### 3. 角色管理模块 (`role/`)

**功能：**
- ✅ 角色 CRUD
- ✅ 角色搜索（分页）
- ✅ 分配权限给角色
- ✅ 移除角色权限
- ✅ 获取角色权限列表

**关键文件：**
- Proto: `api/role/api.proto`
- Domain: `domain/role/domain.proto`
- Service: `api/role/RoleServiceImpl.java`

**API 端点：**
- `POST /api/roles` - 创建角色
- `GET /api/roles/{roleId}` - 获取角色详情
- `PUT /api/roles/{roleId}` - 更新角色
- `DELETE /api/roles/{roleId}` - 删除角色
- `POST /api/roles/search` - 搜索角色
- `POST /api/roles/{roleId}/permissions` - 分配权限
- `DELETE /api/roles/{roleId}/permissions/{permissionId}` - 移除权限

---

### 4. 菜单管理模块 (`menu/`)

**功能：**
- ✅ 菜单 CRUD
- ✅ 菜单树查询
- ✅ 菜单搜索（分页）

**关键文件：**
- Proto: `api/menu/api.proto`
- Domain: `domain/menu/domain.proto`
- Service: `api/menu/MenuServiceImpl.java`

**API 端点：**
- `POST /api/menus` - 创建菜单
- `GET /api/menus/{menuId}` - 获取菜单详情
- `PUT /api/menus/{menuId}` - 更新菜单
- `DELETE /api/menus/{menuId}` - 删除菜单
- `GET /api/menus/tree` - 获取菜单树
- `POST /api/menus/search` - 搜索菜单

---

### 5. 租户管理模块 (`tenant/`)

**功能：**
- ✅ 租户 CRUD
- ✅ 租户配置
- ✅ 租户停用

**关键文件：**
- Proto: `api/tenant/api.proto`
- Domain: `domain/tenant/domain.proto`
- Service: `api/tenant/TenantServiceImpl.java`

**API 端点：**
- `POST /api/tenants` - 创建租户
- `GET /api/tenants/{tenantId}` - 获取租户详情
- `PUT /api/tenants/{tenantId}` - 更新租户
- `DELETE /api/tenants/{tenantId}/disable` - 停用租户
- `POST /api/tenants/{tenantId}/configure` - 配置租户

---

### 6. 部门管理模块 (`department/`)

**功能：**
- ✅ 部门 CRUD
- ✅ 部门树查询
- ✅ 部门搜索（分页）

**关键文件：**
- Proto: `api/department/api.proto`
- Domain: `domain/department/domain.proto`
- Service: `api/department/DepartmentServiceImpl.java`

**API 端点：**
- `POST /api/departments` - 创建部门
- `GET /api/departments/{departmentId}` - 获取部门详情
- `PUT /api/departments/{departmentId}` - 更新部门
- `DELETE /api/departments/{departmentId}` - 删除部门
- `GET /api/departments/tree` - 获取部门树
- `POST /api/departments/search` - 搜索部门

---

### 7. 部门员工管理模块 (`department/employee`)

**功能：**
- ✅ 添加员工到部门
- ✅ 从部门移除员工
- ✅ 员工调岗
- ✅ 获取部门员工列表

**关键文件：**
- Proto: `api/department/employee.proto`
- Domain: `domain/department/employee.proto`
- Service: `api/department/DepartmentEmployeeServiceImpl.java`

**API 端点：**
- `POST /api/department-employees` - 添加员工到部门
- `DELETE /api/department-employees/{employeeId}` - 从部门移除员工
- `POST /api/department-employees/transfer` - 员工调岗
- `GET /api/departments/{departmentId}/employees` - 获取部门员工列表

---

### 8. 组织管理模块 (`organization/`)

**功能：**
- ✅ 组织树查询
- ✅ 部门树查询
- ✅ 获取用户部门列表

**关键文件：**
- Proto: `api/organization/api.proto`
- Service: `api/organization/OrganizationServiceImpl.java`

**API 端点：**
- `GET /api/organizations/tree` - 获取组织树
- `GET /api/organizations/department-tree` - 获取部门树
- `GET /api/organizations/user-departments` - 获取用户部门

---

### 9. 审计日志模块 (`audit/`)

**功能：**
- ✅ 访问日志记录
- ✅ 访问日志查询
- ✅ 访问统计

**关键文件：**
- Proto: `api/audit/api.proto`
- Domain: `domain/audit/domain.proto`
- Service: `api/audit/AccessLogServiceImpl.java`

**API 端点：**
- `GET /api/access-logs/query` - 查询访问日志
- `GET /api/access-logs/stats` - 获取访问统计

---

## 📊 测试统计

| 模块 | 单元测试数 | 通过率 |
|------|-----------|--------|
| 用户管理 | 11 | 100% |
| 角色管理 | 11 | 100% |
| 租户管理 | 11 | 100% |
| 部门管理 | 11 | 100% |
| 菜单管理 | 11 | 100% |
| 部门员工 | 7 | 100% |
| 高级认证 | 3 | 100% |
| 组织管理 | 4 | 100% |
| **总计** | **69** | **100%** |

---

## 🔧 开发指南

### 添加新功能

1. **定义 Proto**
   ```proto
   // api/{feature}/api.proto
   service FeatureService {
     rpc CreateFeature (CreateFeatureRequest) returns (FeatureSummary) {
       option (hope.swagger.operation) = {
         post: "/features";
         authorization: {
           rbac: {
             authorities: ["FEATURE_CREATE"];
           }
         };
       };
     }
   }
   ```

2. **运行 Wire**
   ```bash
   gradlew :rad-app:wire
   ```

3. **实现 ServiceImpl**
   ```java
   @Override
   public void createFeature(SimpleResultBuilder<FeatureSummary> builder,
       CreateFeatureRequest request) {
     // 实现业务逻辑
   }
   ```

4. **编写测试**
   ```java
   @Test
   void testCreateFeature_Success() {
     // 编写单元测试
   }
   ```

---

## 📝 更新日志

### 2026-03-20
- ✅ 完成高级认证与组织管理功能
- ✅ 完成所有 69 个单元测试
- ✅ 构建验证通过

---

## 🔗 相关链接

- [ApiHug 官方文档](https://github.com/apihug/)
- [BMAD 方法论文档](https://docs.bmad-method.org/)
- [项目 PRD 文档](docs/planning-artifacts/prd.md)
