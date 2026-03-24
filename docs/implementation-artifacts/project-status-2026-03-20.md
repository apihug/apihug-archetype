---
date: '2026-03-20'
author: Aaron
---

# RAD 项目现状梳理

## 已实现的功能

### 1. Customer (用户) 管理 ✅

**Proto 定义位置：** `rad-app/src/main/proto/com/apihug/rad/api/customer/api.proto`

**已实现 API：**
- ✅ `POST /api/auth/login` - 用户登录
- ✅ `POST /api/auth/logout` - 用户登出
- ✅ `GET /api/customer/info` - 获取当前用户信息

**已实现实体：**
- ✅ `CustomerEntity` - 用户实体（`SYS_CUSTOMER` 表）
  - 字段：username, password_hash, password_slat, email, status, default_tenant_id
  - 索引：USERNAME 唯一索引，EMAIL 唯一索引
  - Wire: ALL (IDENTIFIABLE, AUDITABLE, DELETABLE, TENANTABLE, VERSIONABLE)

**已实现 Service：**
- ✅ `CustomerServiceImpl` - 用户服务实现
  - 当前 `info()` 方法返回硬编码测试数据

**错误码定义：**
- `CUSTOMER_NOT_FOUND` (10001023) - 客户不存在
- `CUSTOMER_LOCK` (10001024) - 账户锁定
- `CUSTOMER_LOGIN_FAIL` (10001025) - 登录失败

**状态枚举：**
- `CustomerStatusEnum` - ACTIVE, INACTIVE, LOCKED

---

### 2. Audit (审计日志) 管理 ✅

**Proto 定义位置：** `rad-app/src/main/proto/com/apihug/rad/api/audit/api.proto`

**已实现 API：**
- ✅ `GET /api/access-logs/query` - 查询访问日志（分页）
- ✅ `GET /api/access-logs/stats` - 获取访问统计

**已实现实体：**
- ✅ `AccessLogEntity` - 审计日志实体（`SYS_ACCESS_LOG` 表）
  - 字段：http_method, request_path, response_status, duration_ms, customer_id, ip_address, user_agent, service_name, method_name, error_code, error_message, request_params, tenant_id, priority
  - 索引：CUSTOMER_ID, REQUEST_PATH, CREATED_AT, TENANT_ID + CREATED_AT 复合索引
  - Wire: IDENTIFIABLE, TENANTABLE

**已实现 Service：**
- ✅ `AccessLogServiceImpl` - 审计日志服务实现

---

### 3. ApiHug 原生支持的功能 ✅

**多租户管理：**
- ✅ ApiHug 框架原生支持
- ✅ 通过 `Tenantable` Wire 接口自动实现
- ✅ Schema 级隔离（框架自动处理）

**API Meta 信息管理：**
- ✅ `apihug.json` - 项目元信息
  - API 根路径：`/api`
  - 错误码前缀：10240000
  - 权限枚举类：`RadAuthorityEnum`
- ✅ `entities.json` - 实体元信息
  - 表定义、字段定义、索引定义
- ✅ `hope-domain-authorities.json` - 权限定义
  - 当前权限：`USER_ADD`, `USER_DELETE`

**静态资源管理：**
- ✅ ApiHug 框架原生支持
- ✅ 通过 proto `authorization` 选项控制访问

---

## 需要补充开发的功能

### 1. 用户管理 API（补充）❌

**需要补充的 API：**
- ❌ `POST /api/users` - 创建用户
- ❌ `GET /api/users/{id}` - 获取用户详情
- ❌ `PUT /api/users/{id}` - 更新用户
- ❌ `DELETE /api/users/{id}` - 删除用户（软删除）
- ❌ `POST /api/users/search` - 搜索用户（分页）
- ❌ `POST /api/auth/forgot-password` - 找回密码
- ❌ `POST /api/auth/reset-password` - 重置密码

**需要补充的实体：**
- ❌ 无（`CustomerEntity` 已存在）

**需要补充的 Service：**
- ❌ `UserServiceImpl` - 用户管理服务实现

---

### 2. 角色管理 API ❌

**需要补充的 Proto 定义：**
- ❌ `RoleEntity` - 角色实体
- ❌ `RoleService` - 角色服务
- ❌ 角色管理 API（CRUD + 搜索）

**需要补充的 API：**
- ❌ `POST /api/roles` - 创建角色
- ❌ `GET /api/roles/{id}` - 获取角色详情
- ❌ `PUT /api/roles/{id}` - 更新角色
- ❌ `DELETE /api/roles/{id}` - 删除角色
- ❌ `POST /api/roles/search` - 搜索角色（分页）

---

### 3. 权限管理 API ❌

**需要补充的 Proto 定义：**
- ❌ 权限枚举定义（扩展 `RadAuthorityEnum`）

**需要补充的 API：**
- ❌ `GET /api/permissions` - 获取所有权限列表
- ❌ `POST /api/roles/{id}/permissions` - 为角色分配权限
- ❌ `DELETE /api/roles/{id}/permissions/{permissionId}` - 移除角色权限

---

### 4. 菜单管理 API ❌

**需要补充的 Proto 定义：**
- ❌ `MenuEntity` - 菜单实体
- ❌ `MenuService` - 菜单服务
- ❌ 菜单管理 API

**需要补充的 API：**
- ❌ `GET /api/menus/tree` - 获取菜单树
- ❌ `POST /api/menus` - 创建菜单
- ❌ `PUT /api/menus/{id}` - 更新菜单
- ❌ `DELETE /api/menus/{id}` - 删除菜单

---

### 5. 租户管理 API ❌

**需要补充的 Proto 定义：**
- ❌ `TenantEntity` - 租户实体
- ❌ `TenantService` - 租户服务

**需要补充的 API：**
- ❌ `POST /api/tenants` - 创建租户
- ❌ `GET /api/tenants/{id}` - 获取租户详情
- ❌ `PUT /api/tenants/{id}` - 更新租户
- ❌ `DELETE /api/tenants/{id}` - 停用租户

---

### 6. API Key 管理 API ❌

**需要补充的 Proto 定义：**
- ❌ `ApiKeyEntity` - API Key 实体
- ❌ `ApiKeyService` - API Key 服务

**需要补充的 API：**
- ❌ `POST /api/api-keys` - 创建 API Key
- ❌ `GET /api/api-keys` - 获取 API Key 列表
- ❌ `DELETE /api/api-keys/{id}` - 删除 API Key
- ❌ `POST /api/api-keys/{id}/reset` - 重置 API Key

---

### 7. 平台管理 API ❌

**需要补充的 Proto 定义：**
- ❌ 平台资源查看 API

**需要补充的 API：**
- ❌ `GET /api/platform/apis` - 查看所有 API 列表
- ❌ `GET /api/platform/constants` - 查看所有常量定义
- ❌ `GET /api/platform/errors` - 查看错误码列表
- ❌ `GET /api/platform/entities` - 查看所有实体模型
- ❌ `GET /api/platform/tenants` - 查看租户列表
- ❌ `GET /api/platform/stats` - 查看平台统计数据

---

## 开发建议

### 优先级排序

**P0 - MVP 必须（立即开发）：**
1. 用户管理 API（补充）- 基于现有 `CustomerEntity` 扩展
2. 角色管理 API - 新建 `RoleEntity`
3. 权限管理 API - 扩展 `RadAuthorityEnum`
4. 菜单管理 API - 新建 `MenuEntity`

**P1 - 增强功能（V2.0）：**
1. 租户管理 API - ApiHug 已内置，包装即可
2. API Key 管理 API - 新建 `ApiKeyEntity`

**P2 - 企业版功能（V3.0）：**
1. 平台管理 API - 查看元信息

---

### 开发步骤

**步骤 1：补充用户管理 API**
1. 在 `customer/api.proto` 中补充用户管理 API
2. 运行 `gradlew :rad-app:wire` 生成代码
3. 在 `CustomerServiceImpl` 中补充实现
4. 编写测试

**步骤 2：创建角色管理**
1. 创建 `infra/settings/role_constant.proto` - 角色常量
2. 创建 `domain/role/domain.proto` - 角色实体
3. 创建 `api/role/api.proto` - 角色 API
4. 运行 `gradlew :rad-app:wire` 生成代码
5. 实现 `RoleServiceImpl`

**步骤 3：创建菜单管理**
1. 创建 `domain/menu/domain.proto` - 菜单实体
2. 创建 `api/menu/api.proto` - 菜单 API
3. 运行 `gradlew :rad-app:wire` 生成代码
4. 实现 `MenuServiceImpl`

**步骤 4：扩展权限枚举**
1. 修改 `infra/settings/authority.proto` - 扩展 `RadAuthorityEnum`
2. 添加角色、菜单相关权限
3. 运行 `gradlew :rad-app:wire` 重新生成

---

## ApiHug 原生功能（无需开发）

**以下功能 ApiHug 已内置，无需重复设计：**

1. **多租户隔离** - `Tenantable` Wire 自动处理
2. **审计日志** - `Auditable` Wire 自动填充审计字段
3. **软删除** - `Deletable` Wire 自动处理
4. **版本控制** - `Versionable` Wire 自动处理乐观锁
5. **API 元信息** - `apihug.json` 等文件自动生成
6. **JWT 认证** - 框架内置
7. **RBAC 权限检查** - Proto `authorization` 选项 + AOP

---

## 总结

**已实现：**
- ✅ Customer（用户）基础 API（登录、登出、查询）
- ✅ Audit（审计日志）完整 API
- ✅ ApiHug 原生多租户、审计、软删除支持

**需要开发：**
- ❌ 用户管理完整 API（CRUD + 搜索 + 找回密码）
- ❌ 角色管理 API
- ❌ 权限管理 API
- ❌ 菜单管理 API
- ❌ 租户管理 API（包装 ApiHug 内置功能）
- ❌ API Key 管理 API
- ❌ 平台管理 API

**开发策略：**
- 充分利用 ApiHug 内置功能，避免重复造轮子
- 优先开发 MVP 必须的 P0 功能
- 角色、菜单、权限是核心，优先实现
