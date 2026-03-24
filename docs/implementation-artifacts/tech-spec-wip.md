---
title: '用户管理 API 补充'
slug: 'user-management-api-extension'
created: '2026-03-20'
status: 'review'
stepsCompleted: [1, 2, 3, 4]
tech_stack: ['Java 18+', 'Spring Boot 3.5+', 'ApiHug 2.4+', 'Protobuf']
files_to_modify:
  - 'rad-app/src/main/proto/com/apihug/rad/api/customer/api.proto'
  - 'rad-app/src/main/java/com/apihug/rad/api/customer/CustomerServiceImpl.java'
code_patterns:
  - 'ApiHug Contract-First'
  - 'Onion Architecture (ServiceImpl → DomainService → Repository)'
  - 'Zero RBAC code in ServiceImpl'
test_patterns:
  - 'Unit tests for ServiceImpl'
  - 'Integration tests for API endpoints'
---

# Tech-Spec: 用户管理 API 补充

**Created:** 2026-03-20

## Overview

### Problem Statement

现有项目中，Customer（用户）管理只有基础的登录、登出、查询功能，缺少完整的用户管理 API（CRUD、搜索、找回密码），导致无法实际管理用户。

### Solution

在现有 `customer/api.proto` 中补充用户管理 API，扩展现有 `CustomerServiceImpl` 实现完整功能。

### Scope

**In Scope:**
- 用户 CRUD API（创建、查询、更新、删除）
- 用户搜索 API（分页）
- 找回密码流程（申请重置、重置密码）
- 复用现有 `CustomerEntity`，无需新建实体

**Out of Scope:**
- 角色管理（单独的故事）
- 权限管理（单独的故事）
- 菜单管理（单独的故事）
- 前端 UI 实现

## Context for Development

### Codebase Patterns

**ApiHug 开发模式（已验证）：**
1. Proto DSL 定义 API → `gradlew :rad-app:wire` → 生成代码
2. ServiceImpl 填充业务逻辑（零 RBAC 代码）
3. Repository trait 处理查询逻辑（`t._*Repository`）
4. DomainService（可选）处理复杂业务逻辑

**现有代码参考（已读取）：**
- `AuthService` - 认证服务参考（`AuthServiceImpl.java`）
- `AccessLogService` - 审计日志服务参考（`AccessLogServiceImpl.java`）
  - 分页查询模式：`PageableResultBuilder<T>` + `PageRequest`
  - Repository trait 调用模式
- `CustomerServiceImpl` - 现有客户服务（需扩展）
- `_CustomerEntityRepository` - Repository trait 扩展
  - 已有方法：`findByUsername()`, `findByEmail()`

**文件结构（已确认）：**
- Proto: `rad-app/src/main/proto/com/apihug/rad/api/customer/api.proto`
- ServiceImpl: `rad-app/src/main/java/com/apihug/rad/api/customer/CustomerServiceImpl.java`
- Repository Trait: `rad-app/src/main/trait/t/com/apihug/rad/domain/customer/repository/_CustomerEntityRepository.java`
- Entity: `CustomerEntity` (已有，无需修改)

### Files to Reference

| File | Purpose |
|------|---------|
| `api/customer/api.proto` | 现有用户 API 定义（需扩展） |
| `infra/customer/error.proto` | 错误码定义（需扩展） |
| `domain/customer/domain.proto` | 用户实体定义（已有，无需修改） |
| `api/customer/CustomerServiceImpl.java` | 现有服务实现（需扩展） |
| `trait/_CustomerEntityRepository.java` | Repository trait（需扩展） |
| `api/audit/AccessLogServiceImpl.java` | 分页查询参考 |

### Technical Decisions

**架构决策（已确认）：**
1. **复用现有 `CustomerEntity`** - 无需新建实体，减少数据库变更
2. **扩展现有 `CustomerServiceImpl`** - 保持代码一致性
3. **Proto 定义遵循 ApiHug 规范** - `pageable: true` 用于分页
4. **错误处理** - 使用 `HopeErrorDetailException` + `CustomerErrorEnum`
5. **密码安全** - bcrypt 加密（`password_hash` + `password_slat` 字段已有）

**API 设计决策：**
1. **创建用户** - `POST /api/users`，返回 `UserSummary`
2. **获取用户详情** - `GET /api/users/{id}`，返回 `UserDetail`
3. **更新用户** - `PUT /api/users/{id}`，返回 `Empty`
4. **删除用户** - `DELETE /api/users/{id}`（软删除），返回 `Empty`
5. **搜索用户** - `POST /api/users/search`（分页），返回 `UserSummary`
6. **找回密码** - `POST /api/auth/forgot-password` + `POST /api/auth/reset-password`

**Repository 决策：**
- 扩展现有 `_CustomerEntityRepository` trait
- 添加方法：`searchUsers()`, `findByUsernameAndTenantId()` 等

## Implementation Plan

### Tasks

**Task 1: 补充 Proto 定义**
1. 在 `customer/api.proto` 中添加用户管理 API 定义
2. 定义请求/响应消息（`CreateUserRequest`, `UpdateUserRequest`, `UserSummary`, `UserDetail`）
3. 定义找回密码 API（`ForgotPasswordRequest`, `ResetPasswordRequest`）
4. 添加 `authorization` 配置（RBAC 控制）
5. 运行 `gradlew :rad-app:wire` 生成代码

**Task 2: 扩展错误枚举**
1. 在 `error.proto` 中添加新错误码（`USER_ALREADY_EXISTS`, `INVALID_RESET_TOKEN` 等）
2. 运行 `gradlew :rad-app:wire` 重新生成

**Task 3: 实现 ServiceImpl**
1. 扩展 `CustomerServiceImpl` 实现新用户管理方法
2. 实现 `createUser()` - 创建用户
3. 实现 `getUser()` - 获取用户详情
4. 实现 `updateUser()` - 更新用户
5. 实现 `deleteUser()` - 删除用户（软删除）
6. 实现 `searchUsers()` - 搜索用户（分页）
7. 实现 `forgotPassword()` - 申请找回密码
8. 实现 `resetPassword()` - 重置密码

**Task 4: 实现 Repository trait（如需要）**
1. 在 `_CustomerRepository` trait 中添加查询方法
2. 实现 `findByUsername()` - 按用户名查询
3. 实现 `findByEmail()` - 按邮箱查询
4. 实现 `search()` - 动态搜索（分页）

**Task 5: 编写测试**
1. 编写单元测试（`CustomerServiceImplTest`）
2. 编写集成测试（API 端点测试）
3. 确保测试覆盖率 > 80%

**Task 6: 文档和示例**
1. 更新快速开始文档
2. 添加 Postman Collection 示例
3. 添加 API 使用示例

### Acceptance Criteria

**AC1: 创建用户**
- Given 管理员发送创建用户请求
- When 用户名和邮箱唯一，密码符合强度要求
- Then 返回 201 Created，包含用户 ID
- And 密码使用 bcrypt 加密存储

**AC2: 获取用户详情**
- Given 用户已登录
- When 请求获取用户详情
- Then 返回 200 OK，包含用户完整信息
- And 不包含密码哈希等敏感字段

**AC3: 更新用户**
- Given 管理员发送更新用户请求
- When 用户存在且数据有效
- Then 返回 204 No Content
- And 用户信息已更新

**AC4: 删除用户**
- Given 管理员发送删除用户请求
- When 用户存在
- Then 返回 204 No Content
- And 用户被软删除（`deleted = true`）

**AC5: 搜索用户**
- Given 管理员发送搜索请求
- When 提供关键词、状态等筛选条件
- Then 返回分页结果（`Page<UserSummary>`）
- And 支持按关键词、状态、角色筛选

**AC6: 找回密码**
- Given 用户发送找回密码请求
- When 邮箱存在
- Then 发送重置邮件（模拟或实际）
- And 返回 204 No Content（不泄露邮箱是否存在）

**AC7: 重置密码**
- Given 用户发送重置密码请求
- When token 有效且未过期
- Then 密码重置成功，返回 204 No Content
- And 旧 token 失效

## Additional Context

### Dependencies

**外部依赖：**
- ApiHug 框架（wire 生成）
- Spring Data JDBC（数据库操作）
- bcrypt（密码加密）

**内部依赖：**
- `CustomerEntity` - 现有用户实体
- `RadAuthorityEnum` - 权限枚举（需扩展 `USER_CREATE`, `USER_UPDATE`, `USER_DELETE`）

### Testing Strategy

**单元测试：**
- 测试 ServiceImpl 方法
- Mock Repository 依赖
- 验证业务逻辑正确性

**集成测试：**
- 测试 API 端点
- 验证数据库操作
- 验证权限控制

**测试数据：**
- 使用 H2 内存数据库
- 每个测试独立数据
- 测试后清理数据

### Notes

**注意事项：**
1. 密码强度验证（最小长度 6，包含大小写和数字）
2. 用户名和邮箱唯一性验证
3. 软删除而非物理删除
4. 找回密码 token 过期时间（默认 1 小时）
5. 权限控制（创建/更新/删除需要管理员权限）
