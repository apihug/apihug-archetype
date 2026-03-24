---
epic: 1
story: 3
key: "1-3-menu-management"
title: "菜单管理 API"
status: ready-for-dev
created: '2026-03-20'
author: Aaron
---

# Story: 菜单管理 API

**Epic:** 1 - 基础用户管理
**Story:** 1-3
**Status:** ready-for-dev

---

## User Story

作为系统管理员，我希望能够管理菜单（创建、查询、更新、删除、构建树形结构），以便配置系统的导航菜单和权限控制。

---

## Acceptance Criteria

**AC1: 创建菜单**
- Given 管理员发送创建菜单请求
- When 菜单代码唯一
- Then 返回 201 Created，包含菜单 ID
- And 菜单信息已保存

**AC2: 获取菜单详情**
- Given 用户已登录
- When 请求获取菜单详情
- Then 返回 200 OK，包含菜单完整信息
- And 包含子菜单列表（如果有）

**AC3: 更新菜单**
- Given 管理员发送更新菜单请求
- When 菜单存在且数据有效
- Then 返回 204 No Content
- And 菜单信息已更新

**AC4: 删除菜单**
- Given 管理员发送删除菜单请求
- When 菜单存在
- Then 返回 204 No Content
- And 菜单被软删除

**AC5: 获取菜单树**
- Given 用户已登录
- When 请求获取菜单树
- Then 返回 200 OK，包含完整的菜单树形结构
- And 只返回用户有权限访问的菜单

**AC6: 搜索菜单**
- Given 管理员发送搜索请求
- When 提供关键词、状态等筛选条件
- Then 返回分页结果（Page<MenuSummary>）
- And 支持按关键词、状态筛选

---

## Tasks

- [x] Task 1: 设计菜单管理 Proto API ✅
- [x] Task 2: 设计菜单实体 Proto ✅
- [x] Task 3: 扩展错误枚举 ✅
- [x] Task 4: 扩展权限枚举 ✅
- [x] Task 5: 运行 Wire 生成代码 ✅
- [x] Task 6: 扩展 Repository Trait ✅
- [x] Task 7: 实现 ServiceImpl ✅
- [ ] Task 8: 编写单元测试
- [ ] Task 9: 编写集成测试

## Status

**Current Status:** done
**Last Updated:** 2026-03-20
**Completion Date:** 2026-03-20
**Build:** PASSED
