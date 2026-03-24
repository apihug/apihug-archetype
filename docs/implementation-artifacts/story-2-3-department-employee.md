---
epic: 2
story: 3
key: "2-3-department-employee"
title: "部门员工管理 API"
status: ready-for-dev
created: '2026-03-20'
author: Aaron
---

# Story: 部门员工管理 API

**Epic:** 2 - 多租户管理
**Story:** 2-3
**Status:** ready-for-dev

---

## User Story

作为租户管理员，我希望能够管理部门员工（添加、移除、调岗），以便管理员工的部门归属。

---

## Acceptance Criteria

**AC1: 添加员工到部门**
- Given 租户管理员发送添加员工请求
- When 员工和部门都存在
- Then 返回 204 No Content
- And 员工部门关联已保存

**AC2: 从部门移除员工**
- Given 租户管理员发送移除员工请求
- When 员工部门关联存在
- Then 返回 204 No Content
- And 员工部门关联已删除

**AC3: 员工调岗**
- Given 租户管理员发送调岗请求
- When 员工存在且目标部门存在
- Then 返回 204 No Content
- And 员工部门已更新

**AC4: 获取部门员工列表**
- Given 用户已登录
- When 请求获取部门员工列表
- Then 返回 200 OK，包含员工列表
- And 包含员工基本信息和职位

**AC5: 获取员工的部门历史**
- Given 用户已登录
- When 请求获取员工的部门历史
- Then 返回 200 OK，包含部门变更历史

---

## Tasks

- [ ] Task 1: 设计部门员工管理 Proto API
- [ ] Task 2: 设计部门员工关联实体 Proto
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
