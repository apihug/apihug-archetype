---
epic: 2
story: 2
key: "2-2-department-management"
title: "部门管理 API"
status: ready-for-dev
created: '2026-03-20'
author: Aaron
---

# Story: 部门管理 API

**Epic:** 2 - 多租户管理
**Story:** 2-2
**Status:** ready-for-dev

---

## User Story

作为租户管理员，我希望能够管理部门（创建、查询、更新、删除、树形结构），以便组织公司内部架构。

---

## Acceptance Criteria

**AC1: 创建部门**
- Given 租户管理员发送创建部门请求
- When 部门代码在租户内唯一
- Then 返回 201 Created，包含部门 ID
- And 部门信息已保存

**AC2: 获取部门详情**
- Given 用户已登录
- When 请求获取部门详情
- Then 返回 200 OK，包含部门完整信息
- And 包含子部门列表（如果有）

**AC3: 更新部门**
- Given 租户管理员发送更新部门请求
- When 部门存在且数据有效
- Then 返回 204 No Content
- And 部门信息已更新

**AC4: 删除部门**
- Given 租户管理员发送删除部门请求
- When 部门存在且无子部门
- Then 返回 204 No Content
- And 部门被软删除

**AC5: 获取部门树**
- Given 用户已登录
- When 请求获取部门树
- Then 返回 200 OK，包含完整的部门树形结构

---

## Tasks

- [ ] Task 1: 设计部门管理 Proto API
- [ ] Task 2: 设计部门实体 Proto
- [ ] Task 3: 扩展错误枚举
- [ ] Task 4: 扩展权限枚举
- [ ] Task 5: 运行 Wire 生成代码
- [ ] Task 6: 扩展 Repository Trait
- [ ] Task 7: 实现 ServiceImpl
- [ ] Task 8: 编写单元测试

---

## Status

**Current Status:** ready-for-dev
**Last Updated:** 2026-03-20
