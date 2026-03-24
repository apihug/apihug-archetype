# RAD 项目文档索引

**项目名称：** RAD (Rapid Application Development)  
**框架：** ApiHug 2.4.8-RELEASE  
**技术栈：** Java 18+, Spring Boot 3.5+, Vue 3 + Vben Admin  
**文档更新日期：** 2026-03-24  

---

## 📋 项目概述

RAD 是一个基于 ApiHug 框架的企业级快速应用开发模板，提供完整的客户管理、权限控制、多租户支持等功能。

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
- [认证模块](modules/auth-module.md) - 客户认证、Token 管理、租户切换
- [客户管理模块](modules/customer-module.md) - 客户 CRUD、搜索、密码管理
- [角色管理模块](modules/role-module.md) - 角色 CRUD、权限分配（租户隔离）
- [部门管理模块](modules/department-module.md) - 部门 CRUD、树形结构（租户隔离）
- [租户成员管理模块](modules/tenant-member-module.md) - 成员管理、角色分配、部门分配

### API 文档
- [API 参考文档](api-reference.md) - 完整的 API 端点、请求/响应示例

---

## 📦 功能模块

### 1. 认证与授权模块 (`auth/`, `customer/`)

**功能：**
- ✅ 客户登录/登出
- ✅ JWT Token 认证
- ✅ 获取当前客户信息
- ✅ 租户切换
- ✅ 权限加载

**关键文件：**
- Proto: `api/customer/api.proto`
- Service: `api/customer/CustomerAuthServiceImpl.java`
- Service: `api/customer/CustomerServiceImpl.java`

**API 端点：**
- `POST /api/auth/login` - 客户登录
- `POST /api/auth/logout` - 退出登录
- `GET /api/customer/current-info` - 获取当前客户信息
- `GET /api/customer/tenants` - 获取客户租户列表
- `POST /api/customer/switch-tenant` - 切换租户

---

### 2. 客户管理模块 (`customer/`)

**功能：**
- ✅ 客户 CRUD
- ✅ 客户搜索（分页）
- ✅ 找回密码
- ✅ 重置密码

**关键文件：**
- Proto: `api/customer/api.proto`
- Domain: `domain/customer/domain.proto`
- Service: `api/customer/CustomerManagementServiceImpl.java`

**API 端点：**
- `POST /api/customers/customers` - 创建客户
- `GET /api/customers/customers/{customerId}` - 获取客户详情
- `PUT /api/customers/customers/{customerId}` - 更新客户
- `DELETE /api/customers/customers/{customerId}` - 删除客户
- `POST /api/customers/customers/search` - 搜索客户

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
- ✅ 租户搜索
- ✅ 平台租户支持（is_platform）

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
- `POST /api/tenants/search` - 搜索租户

---

### 6. 部门管理模块 (`department/`)

**功能：**
- ✅ 部门 CRUD
- ✅ 部门树查询
- ✅ 部门搜索（分页）
- ✅ 租户隔离（tenant_id）

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

### 7. 租户成员管理模块 (`tenant/member`)

**功能：**
- ✅ 获取租户成员列表（分页）
- ✅ 添加成员到租户
- ✅ 从租户移除成员
- ✅ 切换成员锁定状态
- ✅ 更新成员角色（OWNER/ADMIN/MEMBER）
- ✅ 分配成员部门
- ✅ 设置默认租户

**关键文件：**
- Proto: `api/tenant/member.proto`
- Domain: `domain/tenant/member.proto`
- Service: `api/tenant/TenantMemberServiceImpl.java`

**API 端点：**
- `GET /api/tenants/{tenantId}/members` - 获取成员列表
- `POST /api/tenants/{tenantId}/members` - 添加成员
- `DELETE /api/tenants/{tenantId}/members/{memberId}` - 移除成员
- `POST /api/tenants/{tenantId}/members/{memberId}/toggle-lock` - 切换锁定
- `PUT /api/tenants/{tenantId}/members/{memberId}/role` - 更新角色
- `PUT /api/tenants/{tenantId}/members/{memberId}/department` - 分配部门
- `POST /api/tenants/{tenantId}/set-default` - 设置默认租户

---

### 8. 审计日志模块 (`audit/`)

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
| 客户管理 | 11 | 100% |
| 角色管理 | 11 | 100% |
| 租户管理 | 11 | 100% |
| 部门管理 | 11 | 100% |
| 菜单管理 | 11 | 100% |
| 租户成员 | 7 | 100% |
| 高级认证 | 3 | 100% |
| **总计** | **65** | **100%** |

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

### 2026-03-24
- ✅ 完成账户和租户体系重构（Customer + Tenant + TenantMember）
- ✅ 消除所有 User/Organization 概念混淆
- ✅ 添加租户成员管理模块
- ✅ Role/Menu/Department 添加 tenant_id 租户隔离

### 2026-03-20
- ✅ 完成高级认证与组织管理功能
- ✅ 完成所有 65 个单元测试
- ✅ 构建验证通过

## 🔗 相关链接

- [ApiHug 官方文档](https://github.com/apihug/)
- [BMAD 方法论文档](https://docs.bmad-method.org/)
- [项目 PRD 文档](docs/planning-artifacts/prd.md)
