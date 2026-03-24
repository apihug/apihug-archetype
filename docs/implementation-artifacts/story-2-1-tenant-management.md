---
epic: 2
story: 1
key: "2-1-tenant-management"
title: "租户管理 API"
status: ready-for-dev
created: '2026-03-20'
author: Aaron
---

# Story: 租户管理 API

**Epic:** 2 - 多租户管理
**Story:** 2-1
**Status:** ready-for-dev

---

## User Story

作为平台管理员，我希望能够管理租户（创建、查询、更新、停用），以便为不同企业提供独立的数据空间。

---

## Acceptance Criteria

**AC1: 创建租户**
- Given 平台管理员发送创建租户请求
- When 租户代码唯一
- Then 返回 201 Created，包含租户 ID
- And 自动创建租户 Schema

**AC2: 获取租户详情**
- Given 用户已登录
- When 请求获取租户详情
- Then 返回 200 OK，包含租户完整信息
- And 包含租户配置信息

**AC3: 更新租户**
- Given 平台管理员发送更新租户请求
- When 租户存在且数据有效
- Then 返回 204 No Content
- And 租户信息已更新

**AC4: 停用租户**
- Given 平台管理员发送停用租户请求
- When 租户存在
- Then 返回 204 No Content
- And 租户被停用（无法登录）

**AC5: 租户配置**
- Given 平台管理员发送配置租户请求
- When 租户存在
- Then 可以配置租户的功能模块、用户数限制、存储空间等

---

## Tasks

- [ ] Task 1: 设计租户管理 Proto API
- [ ] Task 2: 设计租户实体 Proto
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
