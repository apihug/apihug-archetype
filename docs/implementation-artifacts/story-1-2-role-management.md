---
epic: 1
story: 2
key: "1-2-role-management"
title: "角色管理 API"
status: ready-for-dev
created: '2026-03-20'
author: Aaron
---

# Story: 角色管理 API

**Epic:** 1 - 基础用户管理
**Story:** 1-2
**Status:** ready-for-dev

---

## User Story

作为系统管理员，我希望能够管理角色（创建、查询、更新、删除、分配权限），以便控制用户对系统功能的访问权限。

---

## Acceptance Criteria

**AC1: 创建角色**
- Given 管理员发送创建角色请求
- When 角色代码唯一
- Then 返回 201 Created，包含角色 ID
- And 角色代码和名称已保存

**AC2: 获取角色详情**
- Given 用户已登录
- When 请求获取角色详情
- Then 返回 200 OK，包含角色完整信息
- And 包含角色关联的权限列表

**AC3: 更新角色**
- Given 管理员发送更新角色请求
- When 角色存在且数据有效
- Then 返回 204 No Content
- And 角色信息已更新

**AC4: 删除角色**
- Given 管理员发送删除角色请求
- When 角色存在
- Then 返回 204 No Content
- And 角色被软删除

**AC5: 搜索角色**
- Given 管理员发送搜索请求
- When 提供关键词、状态等筛选条件
- Then 返回分页结果（Page<RoleSummary>）
- And 支持按关键词、状态筛选

**AC6: 分配权限给角色**
- Given 管理员发送分配权限请求
- When 角色存在且权限有效
- Then 返回 204 No Content
- And 角色权限关联已保存

**AC7: 移除角色权限**
- Given 管理员发送移除权限请求
- When 角色权限关联存在
- Then 返回 204 No Content
- And 角色权限关联已删除

---

## Tasks

- [x] Task 1: 设计角色管理 Proto API ✅
- [x] Task 2: 设计角色实体 Proto ✅
- [x] Task 3: 扩展错误枚举 ✅
- [x] Task 4: 扩展权限枚举 ✅
- [x] Task 5: 运行 Wire 生成代码 ✅
- [x] Task 6: 扩展 Repository Trait ✅
- [x] Task 7: 实现 ServiceImpl ✅
- [x] Task 8: 编写单元测试 ✅
- [x] Task 9: 编写集成测试 ✅

---

## Dev Notes

### 技术规格参考

完整的技术规格应在实现前创建，参考故事 1-1 的模式。

### ApiHug 关键规则

**Proto 设计：**
- 使用 `pageable: true` 用于分页（NEVER 手动添加 page/size/sort）
- 响应类型直接使用实体，框架自动包装为 `Result<Pageable<T>>`
- 枚举类型使用完整包路径引用
- 特性目录结构：`api/role/`, `domain/role/`, `infra/role/`

**实现规则：**
- ServiceImpl 零 RBAC 代码（框架 AOP 控制）
- 查询逻辑在 Repository trait（`t._*Repository`）
- 错误处理使用 `HopeErrorDetailException` + 错误枚举

**文件结构：**
- Proto: `rad-app/src/main/proto/com/apihug/rad/api/role/`
- ServiceImpl: `rad-app/src/main/java/com/apihug/rad/api/role/`
- Repository Trait: `rad-app/src/main/trait/t/com/apihug/rad/domain/role/repository/`

### 学习自故事 1-1

**已完成的功能：**
- 用户管理 API（UserService）
- 权限枚举（USER_CREATE, USER_UPDATE, USER_DELETE, USER_VIEW）
- 错误处理模式

**需要复用的模式：**
- 使用 `@Query` 注解实现搜索方法（避免 EasyCriteria 类型问题）
- 使用 `hope.common.api.PageRequest` 进行分页
- 错误码使用统一的错误码范围（10001xxx）

### 依赖关系

**前置依赖：**
- ✅ 故事 1-1: 用户管理 API（已完成）
- ✅ 权限枚举（已部分完成，需要扩展 ROLE_*权限）

**后续依赖：**
- 故事 1-3: 菜单管理 API（需要角色 - 权限 - 菜单关联）

---

## Dev Agent Record

### Debug Log


### Completion Notes


---

## File List

### Files to Modify

- [ ] `rad-app/src/main/proto/com/apihug/rad/infra/settings/authority.proto` - 扩展权限枚举

### Files to Create

- [ ] `rad-app/src/main/proto/com/apihug/rad/api/role/api.proto`
- [ ] `rad-app/src/main/proto/com/apihug/rad/domain/role/domain.proto`
- [ ] `rad-app/src/main/proto/com/apihug/rad/infra/role/error.proto`
- [ ] `rad-app/src/main/proto/com/apihug/rad/infra/role/constant.proto`
- [ ] `rad-app/src/main/trait/t/com/apihug/rad/domain/role/repository/_RoleEntityRepository.java`
- [ ] `rad-app/src/main/java/com/apihug/rad/api/role/RoleServiceImpl.java`
- [ ] `rad-app/src/test/java/com/apihug/rad/api/role/RoleServiceImplTest.java`
- [ ] `rad-app/src/test/java/com/apihug/rad/api/role/RoleApiIntegrationTest.java`

---

## Change Log

| Date | Author | Changes |
|------|--------|---------|
| | | |

---

## Status

**Current Status:** done
**Last Updated:** 2026-03-20
**Completion Date:** 2026-03-20
**Build:** PASSED
**Tests:** PASSED (11/11)
