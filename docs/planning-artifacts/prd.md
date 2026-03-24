---
stepsCompleted: ["step-01-init", "step-02-discovery", "step-02b-vision", "step-02c-executive-summary", "step-03-success", "step-04-journeys", "step-05-domain-skipped", "step-06-innovation", "step-07-project-type", "step-08-scoping", "step-09-functional", "step-10-nonfunctional", "step-11-polish"]
inputDocuments:
  - docs/planning-artifacts/product-brief-rad-2026-03-20.md
  - docs/project-context.md
  - docs/planning-artifacts/architecture.md
documentCounts:
  briefCount: 1
  researchCount: 0
  brainstormingCount: 0
  projectDocsCount: 2
workflowType: 'prd'
date: '2026-03-20'
author: Aaron
classification:
  projectType: "developer_tool + api_backend"
  domain: "general"
  complexity: "medium"
  projectContext: "greenfield"
---

# Product Requirements Document - rad

**Author:** Aaron
**Date:** 2026-03-20

<!-- Content will be appended sequentially through collaborative workflow steps -->

## Executive Summary

RAD 是一个基于 ApiHug 框架的开源企业级应用开发模板，旨在解决开发者在启动新项目时重复建设基础设施功能的问题。通过预置多租户管理、RBAC 权限控制、审计日志等标准功能，RAD 将新项目启动时间从 2 周压缩到 5 分钟，让开发者能够专注于核心业务逻辑而非重复造轮子。

**目标用户：**
- 👨‍💻 独立开发者：快速交付项目，提高时薪
- 🏢 小团队负责人：标准化技术栈，降低新人培训成本
- 🏛️ 企业技术总监：保证系统安全和合规，快速响应业务需求

**核心问题：** ApiHug 作为框架 + 工具链不提供应用级实现，导致每个新项目都需要重复开发注册登录、客户管理、租户管理、角色授权、访问记录等基础功能，通常需要至少 2 周时间。

### What Makes This Special

**差异化优势：**
- **开源免费**：社区版完全免费，建立开发者社区和影响力
- **开箱即用**：5 分钟启动脚本，内置最佳实践，无需配置
- **Contract-First**：Proto DSL 定义 API，保证代码质量和一致性
- **AI 友好**：结构化 Proto 定义天然适合 AI 辅助（未来增强方向）

**核心洞察：** ApiHug 框架层和应用开发之间存在空白，RAD 提供标准化模板填充这个空白。Proto DSL 是额外优势，让未来 AI 集成更容易，但不是当前核心卖点。

**价值主张：** "RAD 让你分钟级启动一个 ApiHug 标准的企业级应用，内置最佳实践、质量保证和完整文档。"

## Project Classification

| 维度 | 分类 | 说明 |
|------|------|------|
| **项目类型** | developer_tool + api_backend | 开发者工具 + API 后端模板 |
| **领域** | general | 非受监管行业，低合规要求 |
| **复杂度** | medium | 技术深度中等，安全要求高 |
| **项目上下文** | greenfield | 全新产品开发，无历史包袱 |

## Success Criteria

### User Success

**啊哈时刻（5 分钟内）：**
- 开发者成功启动 RAD 模板
- 默认管理员账号登录成功
- 看到管理后台或 API 文档

**完成场景（1 周内）：**
- 完成第一个业务实体的 Proto 定义
- 生成完整 CRUD API
- 部署到生产环境

**情感状态：**
- 开发者评价："这 TMD 是个神器"
- 愿意向同事/社区推荐（NPS > 50）

### Business Success

**3 个月目标（MVP 验证）：**
- GitHub Stars: 100+
- 月下载量：100+
- 贡献者：10+
- "神器"评价比例：> 30%

**12 个月目标（社区建立）：**
- GitHub Stars: 1000+
- 月下载量：1000+
- 贡献者：100+
- 社区案例：10+

**24 个月目标（商业化探索）：**
- 推出企业版
- 企业版转化率：> 5%
- 企业版续费率：> 80%

### Technical Success

**代码质量：**
- 单元测试覆盖率：> 80%
- 集成测试覆盖率：> 60%
- 无高危安全漏洞
- 代码重复率：< 5%

**性能指标：**
- API 响应时间 P95: < 200ms
- 并发支持：> 1000 QPS
- 应用启动时间：< 30 秒

**文档质量：**
- 功能文档覆盖率：100%
- API 文档自动生成率：100%
- 快速开始阅读时间：< 10 分钟
- 文档满意度：> 4.5/5

### Measurable Outcomes

| 指标类别 | 指标名称 | 目标值 | 测量方法 |
|---------|---------|-------|---------|
| 用户采用 | 启动成功率 | > 95% | 首次启动成功/总启动数 |
| 用户采用 | 周活跃用户 | > 30% | 周活跃用户/总下载用户 |
| 用户采用 | 核心功能使用率 | > 80% | 使用登录/RBAC/租户的用户比例 |
| 用户满意 | NPS | > 50 | 社区调研 |
| 用户满意 | "神器"评价比例 | > 30% | 用户反馈/评论分析 |
| 技术健康 | 测试覆盖率 | > 80% | 单元测试覆盖率报告 |
| 技术健康 | API 响应时间 P95 | < 200ms | 性能监控 |
| 技术健康 | Issue 响应时间 | < 24 小时 | GitHub Issue 统计 |

## Product Scope

### MVP - Minimum Viable Product

**核心功能（必须工作）：**
- [ ] 多租户管理（Schema 级隔离, apihug 自带）
- [ ] 审计日志（访问记录自动采集）
- [ ] JWT 认证
- [ ] 注册登录 API
- [ ] 找回密码 API
- [ ] 客户（用户）管理 API（CRUD + 搜索）
- [ ] RBAC API（角色 + 权限 + 菜单管理）

**开发体验（必须完整）：**
- [ ] 5 分钟启动脚本（gradlew bootRun）
- [ ] API 文档（Swagger/OpenAPI 自动生成， Apihug 自带）
- [ ] 快速开始文档（< 10 分钟阅读）

**质量标准（必须满足）：**
- [ ] 测试覆盖率 > 80%
- [ ] 无高危安全漏洞
- [ ] API 响应时间 P95 < 200ms

### Growth Features (Post-MVP)

**V2.0 考虑：**
- [ ] 管理后台 UI（Vue 3 + Vben Admin）
- [ ] 高级数据权限（行级/列级）
- [ ] 工作流引擎
- [ ] 报表生成器

**企业版专属：**
- [ ] SSO 集成（SAML/OAuth）
- [ ] SLA 技术支持
- [ ] 定制开发服务

### Vision (Future)

**阶段 1（0-12 月）：社区版 MVP（纯后端）**
- 建立核心用户群
- 完善 API 文档和示例
- 培养社区贡献者

**阶段 2（12-24 月）：企业版 + UI 扩展**
- 推出企业版功能（SSO、SLA）
- 可选管理后台 UI
- 启动模块市场

**阶段 3（24 月+）：面向 AI 的基础设施**
- AI 代理可以直接操作 RAD 生成业务功能
- Proto 定义 → AI 辅助生成完整 CRUD
- AI 理解业务语义，自动推荐权限配置
- 成为 AI 驱动开发的标准平台

## User Journeys

### Journey 1: 小张（独立开发者）- 成功路径

**画像：** 28 岁，自由职业开发者，接私活为主
**目标：** 快速交付项目，提高时薪
**痛点：** 基础设施重复开发，耗时 2 周+，利润微薄

**旅程叙事：**

| 阶段 | 场景 | 行为 | 感受 |
|------|------|------|------|
| **开场** | 周一早上，收到新项目需求 | 评估工作量，发现基础设施要 2 周 | 焦虑：时间不够 |
| **发现** | 周二，GitHub 搜索"ApiHug 模板" | 找到 RAD，看文档和 Stars | 期待：好像很合适 |
| **尝试** | 周三，下载 RAD | `git clone` → 改配置 → `gradlew bootRun` | 紧张：能成功吗 |
| **啊哈！** | 5 分钟后，API 启动成功 | 用 Postman 测试登录 API，返回 200 OK | 惊喜：这就好了？！ |
| **开发** | 周四 - 周五，定义业务实体 | Proto 定义 → 生成 → 实现业务逻辑 | 专注：这才是我想做的 |
| **交付** | 下周中，完成项目 | 部署到客户服务器，验收通过 | 满足：提前交付，多接一单 |
| **推荐** | 周末，开发者社区分享 | 写博客，推荐 RAD | 自豪：帮到更多人 |

**情感弧线：** 焦虑 → 期待 → 紧张 → 惊喜 → 专注 → 满足 → 自豪

**关键决策点：**
- 决定尝试 RAD（而不是自己开发）
- 5 分钟启动成功（留下或放弃的关键时刻）
- 第一个业务功能完成（确认价值）

**失败场景与恢复：**
- 启动失败 → 查看文档 → 找到问题 → 解决
- API 不理解 → 看示例 → 模仿 → 成功

---

### Journey 2: 李总（小团队负责人）- 团队采用

**画像：** 35 岁，10 人技术团队负责人，软件外包公司
**目标：** 标准化技术栈，提高交付速度
**痛点：** 重复造轮子效率低，代码质量不稳定

**旅程叙事：**

| 阶段 | 场景 | 行为 | 感受 |
|------|------|------|------|
| **开场** | 月初，项目评审会 | 发现 3 个项目都在重复开发基础设施 | 烦恼：效率太低 |
| **调研** | 第 1 天，研究 RAD | 看文档、代码质量、社区评价 | 谨慎：值得投入吗 |
| **试点** | 第 1 周，选一个小项目试用 | 组织团队学习，分配任务 | 期待：希望能成 |
| **培训** | 第 2 周，团队培训 | 新人学习 RAD 架构和规范 | 投入：磨刀不误砍柴工 |
| **交付** | 第 3 周，试点项目交付 | 提前完成，代码质量稳定 | 满意：这个方向对 |
| **推广** | 第 2 个月，所有新项目都用 RAD | 制定规范，强制执行 | 放心：标准化了 |
| **升级** | 第 6 个月，购买企业版 | 获得 SSO、SLA 支持 | 值得：投资回报高 |

**情感弧线：** 烦恼 → 谨慎 → 期待 → 投入 → 满意 → 放心 → 值得

---

### Journey 3: 王总（企业技术总监）- 企业采购

**画像：** 42 岁，200 人技术团队 CTO，中型企业
**目标：** 快速响应业务需求，保证系统安全和合规
**痛点：** 各系统重复建设，安全标准不统一

**旅程叙事：**

| 阶段 | 场景 | 行为 | 感受 |
|------|------|------|------|
| **开场** | 季度规划会 | 业务部门抱怨系统开发太慢 | 压力：需要提速 |
| **调研** | 第 1 周，技术选型 | 评估 RAD 的安全性、合规性 | 严格：不能有风险 |
| **POC** | 第 2 周，技术验证 | 压力测试、安全扫描、代码审计 | 严谨：数据说话 |
| **采购** | 第 3 周，商务谈判 | 购买企业版，签订 SLA | 决策：值得投资 |
| **部署** | 第 1 个月，内部部署 | 集成 SSO，配置权限模型 | 专业：符合企业标准 |
| **推广** | 第 2 个月，多业务线采用 | 培训各团队，制定规范 | 满意：规模化效应 |
| **反馈** | 第 3 个月，项目复盘 | 开发时间缩短 60%，安全审计通过 | 认可：继续投入 |

**情感弧线：** 压力 → 严格 → 严谨 → 决策 → 专业 → 满意 → 认可

---

### Journey 4: 系统管理员 - 维护与升级

**画像：** RAD 模板维护者，负责 Issue 响应和版本发布
**目标：** 保持模板最新，及时修复 bug
**痛点：** Issue 响应不及时，用户流失

**旅程叙事：**

| 阶段 | 场景 | 行为 | 感受 |
|------|------|------|------|
| **日常** | 每天早上 | 检查 GitHub Issue 和 PR | 责任：及时响应 |
| **发现问题** | 用户报告 bug | 复现问题，定位原因 | 专注：快速修复 |
| **修复** | 当天内 | 提交 fix，更新测试 | 专业：保证质量 |
| **发布** | 每周五 | 整理 changelog，发布新版本 | 成就：持续改进 |
| **监控** | 发布后 | 观察社区反馈，下载量变化 | 关注：用户满意 |

---

### Journey Requirements Summary

基于以上旅程，RAD 需要提供以下核心能力：

**启动体验：**
- 5 分钟启动脚本（gradlew bootRun）
- 清晰的快速开始文档（< 10 分钟阅读）
- 默认配置和示例账号

**开发体验：**
- Proto 定义 → 自动生成代码
- API 文档自动生成（Swagger/OpenAPI）
- API 测试示例（Postman Collection）

**质量保证：**
- 测试覆盖率 > 80%
- 无高危安全漏洞
- 性能基准测试（P95 < 200ms）

**社区支持：**
- GitHub Issue 响应 < 24 小时
- 文档完善，示例丰富
- 社区案例分享

## Project-Type Specific Requirements

### API Design (ApiHug Contract-First)

**API 版本控制：**
- 不使用 URL 路径版本（如 `/api/v1/*`）
- ApiHug 通过 proto 定义和 wire 生成管理版本
- 向后兼容通过 proto 字段规则保证

**核心 API 端点（基于现有 proto）：**

```proto
// 认证服务
service AuthService {
  rpc Login (LoginRequest) returns (LoginResponse)     // POST /auth/login
  rpc Logout (Empty) returns (Empty)                   // POST /auth/logout
}

// 客户服务
service CustomerService {
  rpc Info (Empty) returns (CustomerInfo)              // GET /customer/info
}
```

**MVP 需要补充的 API：**

```proto
// 用户管理
service UserService {
  rpc CreateUser (CreateUserRequest) returns (UserSummary)     // POST /users
  rpc GetUser (Empty) returns (UserDetail)                     // GET /users/{id}
  rpc UpdateUser (UpdateUserRequest) returns (Empty)           // PUT /users/{id}
  rpc DeleteUser (Empty) returns (Empty)                       // DELETE /users/{id}
  rpc SearchUsers (SearchUsersRequest) returns (UserSummary)   // POST /users/search (pageable: true)
}

// 角色管理
service RoleService {
  rpc CreateRole (CreateRoleRequest) returns (RoleSummary)     // POST /roles
  rpc GetRole (Empty) returns (RoleDetail)                     // GET /roles/{id}
  rpc UpdateRole (UpdateRoleRequest) returns (Empty)           // PUT /roles/{id}
  rpc DeleteRole (Empty) returns (Empty)                       // DELETE /roles/{id}
  rpc SearchRoles (SearchRolesRequest) returns (RoleSummary)   // POST /roles/search (pageable: true)
  rpc AssignPermissions (AssignPermissionsRequest) returns (Empty)  // POST /roles/{id}/permissions
}

// 权限管理
service PermissionService {
  rpc ListPermissions (Empty) returns (PermissionSummary)      // GET /permissions
}

// 菜单管理
service MenuService {
  rpc GetMenuTree (Empty) returns (MenuTreeNode)               // GET /menus/tree
  rpc CreateMenu (CreateMenuRequest) returns (MenuSummary)     // POST /menus
  rpc UpdateMenu (UpdateMenuRequest) returns (Empty)           // PUT /menus/{id}
  rpc DeleteMenu (Empty) returns (Empty)                       // DELETE /menus/{id}
}
```

---

### Authentication & Authorization (ApiHug JWT + AOP)

**认证方式：**
- JWT Token 认证（ApiHug 内置）
- Token 由框架自动生成和验证
- 用户信息通过 `HopeContextHolder.customer()` 获取

**授权控制（Proto 驱动）：**

```proto
// 1. 匿名访问（无需登录）
rpc Login (LoginRequest) returns (LoginResponse) {
  option (hope.swagger.operation) = {
    post: "/login";
    authorization: {
      low_limit_risky_mode: ANONYMOUS
    };
  };
}

// 2. 需要登录
rpc Logout (Empty) returns (Empty) {
  option (hope.swagger.operation) = {
    post: "/logout";
    authorization: {
      low_limit_risky_mode: LOGIN
    };
  };
}

// 3. RBAC 控制（角色 + 权限）
rpc DeleteUser (Empty) returns (Empty) {
  option (hope.swagger.operation) = {
    delete: "/users/{id}";
    authorization: {
      rbac: {
        roles: {
          roles: ["ROLE_ADMIN"]
        };
        authorities: ["USER_DELETE"];
        combinator: AND;
      };
    };
  };
}
```

**权限枚举定义（`infra/settings/authority.proto`）：**

```proto
enum RadAuthorityEnum {
  USER_CREATE = 0 [(hope.constant.field) = {
    code: 1,
    message: "user:create",
    message2: "创建用户"
  }];
  
  USER_DELETE = 1 [(hope.constant.field) = {
    code: 2,
    message: "user:delete",
    message2: "删除用户"
  }];
  
  ROLE_CREATE = 2 [(hope.constant.field) = {
    code: 3,
    message: "role:create",
    message2: "创建角色"
  }];
  
  MENU_VIEW = 3 [(hope.constant.field) = {
    code: 4,
    message: "menu:view",
    message2: "查看菜单"
  }];
}
```

**安全架构（ApiHug 内置）：**

```
HTTP Request
  → JWTFilter（提取 JWT → 构建 Customer → HopeContextHolder）
  → Controller
  → SecurityAspect（AOP BEFORE, priority=100）
  → HopeSecurityManager.check()（proto RBAC vs Customer）
  → ServiceImpl（RBAC 已强制执行，零 auth 代码）
```

**关键规则：**
- ✅ ZERO RBAC 代码在 ServiceImpl/DomainService/Repository
- ✅ 不使用 `@PreAuthorize`、`@Secured`、`@RolesAllowed`
- ✅ 权限完全由 proto `authorization` 选项控制
- ✅ 使用 `HopeContextHolder.customer()` 获取当前用户

---

### Data Format & Response

**统一响应格式（ApiHug Result）：**

```json
// 成功响应
{
  "code": 200,
  "data": { ... },
  "message": "success"
}

// 错误响应
{
  "code": 404,
  "error": {
    "code": "USER_NOT_FOUND",
    "message": "用户不存在",
    "message2": "user not found",
    "title": "用户未找到",
    "http_status": NOT_FOUND,
    "phase": SERVICE,
    "severity": ERROR
  }
}
```

**分页响应（Framework 自动包装）：**

```proto
rpc SearchUsers (SearchUsersRequest) returns (UserSummary) {
  option (hope.swagger.operation) = {
    post: "/users/search";
    pageable: true;  // 框架自动包装为 Page<UserSummary>
  };
}

// ❌ 禁止：手动添加 page/size/sort 到 Request
message SearchUsersRequest {
  string keyword = 1;  // 只定义业务字段
  // int32 page = 2;   // ❌ 禁止！框架自动注入
  // int32 size = 3;   // ❌ 禁止！框架自动注入
}
```

---

### Error Handling

**错误码定义（`infra/{feature}/error.proto`）：**

```proto
enum UserError {
  USER_NOT_FOUND = 0 [(hope.constant.field) = {
    code: 10001,
    message: "用户不存在",
    message2: "user not found",
    error: {
      title: "用户未找到",
      http_status: NOT_FOUND,
      phase: SERVICE,
      severity: ERROR
    }
  }];
  
  USER_ALREADY_EXISTS = 1 [(hope.constant.field) = {
    code: 10002,
    message: "用户已存在",
    message2: "user already exists",
    error: {
      title: "用户已存在",
      http_status: CONFLICT,
      phase: SERVICE,
      severity: ERROR
    }
  }];
}
```

**错误抛出方式（DomainService）：**

```java
// ✅ 正确方式
throw HopeErrorDetailException.errorBuilder(UserError.USER_NOT_FOUND).build();

// ❌ 错误方式
throw new RuntimeException("用户不存在");
```

**错误处理原则：**
- ✅ 业务错误使用 `HopeErrorDetailException` + 错误枚举
- ✅ 错误枚举在 proto 中定义（`infra/{feature}/error.proto`）
- ✅ 错误包含 http_status、phase、severity 元数据
- ✅ 框架自动映射错误枚举到 HTTP 状态码

---

### SDK Generation (ApiHug Wire)

**自动生成（`gradlew :rad-app:wire`）：**

```yaml
TypeScript SDK:
  路径：packages/rad-app-sdk/
  生成：gradlew :rad-app:wire
  使用：import { UserService } from '@rad-app/sdk'

Java SDK:
  路径：rad-app/src/generated/main/api/
  生成：gradlew :rad-app:wire
  使用：@Autowired private UserService userService
```

**SDK 功能：**
- 完整的类型定义（TypeScript/Java）
- API 调用方法封装
- 请求/响应验证
- 错误处理封装

---

### Implementation Architecture

**后端分层（Onion Architecture）：**

```
Proto DSL
   ↓
gradlew :rad-app:wire
   ↓
Generated:
  - Controller (src/generated/) ← READ-ONLY
  - Entity (src/generated/) ← READ-ONLY
  - ServiceImpl skeleton (src/main/java/) ← 填充方法体
  - Trait Repository skeleton (src/main/trait/) ← 添加查询方法

Handwritten:
  - ServiceImpl (业务逻辑，零 RBAC 代码)
  - DomainService (可选，业务逻辑，抛出错误枚举)
  - Repository trait (查询逻辑，EasyCriteria/SQL)
```

**关键规则：**
- ✅ 所有查询逻辑在 Repository trait（`t._*Repository`）
- ✅ ServiceImpl 只调用 Repository，不组装查询
- ✅ DomainService 抛出 `HopeErrorDetailException`
- ✅ ServiceImpl 零 RBAC 代码（框架 AOP 控制）
- ✅ 不使用 `@PreAuthorize` 等 Spring Security 注解

**Repository trait 示例：**

```java
interface _UserRepository extends UserRepository {
    // Spring Data 查询方法
    Optional<UserEntity> findByUsername(String username);
    
    // 动态查询（EasyCriteria）
    default Page<UserEntity> search(Long tenantId, String keyword, PageRequest page) {
        Criteria criteria = EasyCriteria.eq(_Tenantable_.TENANT_ID, tenantId)
                .and(EasyCriteria.eq(_Deletable_.DELETED, false));
        
        if (keyword != null && !keyword.isBlank()) {
            criteria = criteria.and(EasyCriteria.like(Domain.Name, keyword));
        }
        
        return findAll(criteria, this.page(page));
    }
}
```

---

### Menu, Role, Permission Management

**菜单管理（需要补充 proto）：**

```proto
// 菜单实体
message MenuEntity {
  int64 id = 1;
  int64 parent_id = 2;           // 父菜单 ID（树形结构）
  string name = 3;               // 菜单名称
  string path = 4;               // 前端路由路径
  string icon = 5;               // 菜单图标
  int32 sort_order = 6;          // 排序
  int64 permission_id = 7;       // 关联的权限 ID
  bool visible = 8;              // 是否可见
}

// 菜单树响应
message MenuTreeNode {
  MenuSummary menu = 1;
  repeated MenuTreeNode children = 2;
}
```

**角色权限关系（需要补充 proto）：**

```proto
// 角色实体
message RoleEntity {
  int64 id = 1;
  string name = 2;               // 角色名称
  string code = 3;               // 角色代码
  string description = 4;        // 角色描述
}

// 分配权限给角色
message AssignPermissionsRequest {
  int64 role_id = 1;
  repeated int64 permission_ids = 2;
}

// 分配角色给用户
message AssignRolesRequest {
  int64 user_id = 1;
  repeated int64 role_ids = 2;
}
```

**权限检查流程（框架自动）：**

```
1. 用户请求 API
   ↓
2. JWTFilter 提取 JWT → 构建 Customer → HopeContextHolder
   ↓
3. SecurityAspect（AOP）检查 proto authorization
   ↓
4. HopeSecurityManager.check() 验证角色/权限
   ↓
5. 有权限 → 执行 ServiceImpl；无权限 → 返回 403
```

**后端实现（零 RBAC 代码）：**

```java
// ✅ ServiceImpl - 零 RBAC 代码
@Override
public void deleteUser(Empty request) {
    // 不需要检查权限！框架 AOP 已处理
    UserEntity user = userRepo.findById(request.getId())
        .orElseThrow(() -> HopeErrorDetailException
            .errorBuilder(UserError.USER_NOT_FOUND)
            .build());
    
    userRepo.delete(user);
}

## Project Scoping & Phased Development

### MVP Strategy & Philosophy

**MVP Approach:** 平台型 MVP - 最小可用平台
**Resource Requirements:** 1-2 名核心开发者 + 1 名文档 + 1 名社区运营（可兼职）
**Timeline:** 6 周到 MVP 发布

**MVP 目标：**
- 让开发者能在 5 分钟内启动一个包含基本功能的企业级应用
- 验证"Proto DSL + 最佳实践"的开发范式是否有效
- 建立社区影响力，吸引早期采用者

### MVP Feature Set (Phase 1)

**Core User Journeys Supported:**
1. 小张（独立开发者）：5 分钟启动 → 1 周交付项目
2. 李总（小团队）：试点项目 → 团队推广
3. 王总（企业）：安全评估 → POC 验证

**Must-Have Capabilities:**

**认证与授权：**
- 注册、登录、登出 API
- 用户信息查询
- 找回密码流程

**用户管理：**
- 用户 CRUD API
- 用户搜索（分页）

**角色与权限：**
- 角色 CRUD API
- 权限枚举定义
- 分配权限给角色
- 分配角色给用户

**菜单管理：**
- 菜单树查询
- 菜单 CRUD API

**多租户与审计：**
- 多租户隔离（ApiHug 内置）
- 审计日志（ApiHug 内置）

**开发体验：**
- 5 分钟启动脚本（gradlew bootRun）
- 快速开始文档（< 10 分钟阅读）
- API 文档（Swagger 自动生成）
- Postman Collection 示例

**质量标准（必须满足）：**
- 测试覆盖率 > 80%
- 无高危安全漏洞
- API 响应时间 P95 < 200ms

### Post-MVP Features

**Phase 2 (Growth) - V2.0:**

**高级权限功能：**
- 数据权限（行级/列级）
- 动态权限
- 权限继承

**高级用户功能：**
- 用户组管理
- 委托授权
- 临时权限

**审计增强：**
- 审计日志导出（Excel/CSV）
- 审计报表
- 自定义审计事件

**开发工具：**
- 管理后台 UI（Vue 3 + Vben Admin）
- Docker/K8s 部署脚本

**Phase 3 (Expansion) - V3.0+:**

**企业版功能：**
- SSO 集成（SAML/OAuth）
- LDAP/AD 集成
- SLA 技术支持
- 定制开发服务

**AI 增强：**
- AI 辅助 Proto 定义
- AI 辅助 API 设计
- AI 代码审查

**API Hub / 模块市场：**
- 预置业务模块交易
- 第三方开发者发布模块
- 模块订阅和自动更新

### Risk Mitigation Strategy

**Technical Risks:**
- Proto DSL 学习曲线陡峭 → 提供详细文档和示例
- 多租户隔离实现复杂 → 依赖 ApiHug 框架内置支持
- 性能不达标（P95 > 200ms）→ 早期性能测试和优化

**Market Risks:**
- 社区 adoption 低 → 内容营销、社区建设、案例分享
- 竞品快速跟进 → 建立社区壁垒、持续创新

**Resource Risks:**
- 核心开发者时间不足 → 明确 MVP 范围、分阶段开发
- 文档工作量大 → 文档即代码、示例驱动

## Functional Requirements

### Authentication & Account Management

- FR1: 用户可以注册新账户（提供用户名、邮箱、密码）
- FR2: 用户可以使用用户名和密码登录
- FR3: 用户可以退出登录
- FR4: 用户可以查看自己的账户信息
- FR5: 用户可以更新自己的账户信息
- FR6: 用户可以申请找回密码
- FR7: 系统可以验证密码强度
- FR8: 系统可以在多次登录失败后锁定账户

### User Management

- FR9: 管理员可以创建新用户
- FR10: 管理员可以查看用户详情
- FR11: 管理员可以更新用户信息
- FR12: 管理员可以删除用户（软删除）
- FR13: 管理员可以搜索用户（支持关键词、状态、角色筛选）
- FR14: 管理员可以查看用户的角色列表
- FR15: 管理员可以查看用户的权限列表

### Role & Permission Management

- FR16: 管理员可以创建新角色
- FR17: 管理员可以查看角色详情
- FR18: 管理员可以更新角色信息
- FR19: 管理员可以删除角色
- FR20: 管理员可以搜索角色
- FR21: 管理员可以查看系统所有权限列表
- FR22: 管理员可以为角色分配权限
- FR23: 管理员可以移除角色的权限
- FR24: 管理员可以为用户分配角色
- FR25: 管理员可以移除用户的角色
- FR26: 系统可以验证用户是否有指定权限

### Menu Management

- FR27: 管理员可以查看菜单树（支持按用户权限过滤）
- FR28: 管理员可以创建新菜单
- FR29: 管理员可以更新菜单信息（名称、路径、图标、排序）
- FR30: 管理员可以删除菜单
- FR31: 管理员可以将菜单与权限关联
- FR32: 系统可以根据用户权限动态生成可访问菜单

### Tenant Management

- FR33: 系统可以为每个租户创建独立的 Schema
- FR34: 系统可以隔离不同租户的数据访问
- FR35: 系统可以自动识别当前请求的租户
- FR36: 管理员可以创建新租户
- FR37: 管理员可以更新租户配置
- FR38: 管理员可以停用/启用租户

### Audit & Logging

- FR39: 系统可以自动记录所有写操作的审计日志
- FR40: 审计日志包含操作人、操作时间、操作类型、影响数据
- FR41: 审计日志不可篡改
- FR42: 管理员可以查询审计日志（支持按用户、时间、操作类型筛选）
- FR43: 管理员可以导出审计日志（CSV/Excel）
- FR44: 系统可以记录登录/登出事件

### Developer Tools

- FR45: 开发者可以通过 gradlew 命令启动应用
- FR46: 系统可以自动生成 API 文档（Swagger/OpenAPI）
- FR47: 系统可以自动生成 TypeScript SDK
- FR48: 系统可以自动生成 Java SDK
- FR49: 开发者可以通过 Postman Collection 测试 API
- FR50: 系统可以提供快速开始文档

### System Capabilities

- FR51: 系统可以支持多语言（中文/英文）
- FR52: 系统可以配置会话超时时间
- FR53: 系统可以刷新 JWT Token
- FR54: 系统可以验证请求签名
- FR55: 系统可以限制 API 请求频率

### API Key Management

- FR56: 管理员可以创建新的 API Key
- FR57: 管理员可以查看 API Key 列表
- FR58: 管理员可以查看 API Key 详情（包括密钥、创建时间、过期时间、使用状态）
- FR59: 管理员可以更新 API Key 配置（名称、描述、过期时间）
- FR60: 管理员可以删除/禁用 API Key
- FR61: 管理员可以为 API Key 分配权限范围
- FR62: 管理员可以为 API Key 设置访问频率限制
- FR63: 管理员可以重置 API Key（生成新密钥）
- FR64: 系统可以验证 API Key 的有效性
- FR65: 系统可以记录 API Key 的使用日志
- FR66: 系统可以在 API Key 过期前发送提醒

### Platform Administration

**Note:** 平台管理员通过数据库角色配置实现，无需独立模块。角色检查逻辑在 `RadQuickCustomerRoleChecker` 中配置。

- FR67: 系统可以识别平台管理员角色（通过数据库配置）
- FR68: 平台管理员可以查看所有 API 列表（按服务分组）
- FR69: 平台管理员可以查看 API 详情（请求/响应结构、授权要求）
- FR70: 平台管理员可以查看所有常量定义（枚举值、业务代码）
- FR71: 平台管理员可以查看错误码列表
- FR72: 平台管理员可以查看错误码详情（HTTP 状态、phase、severity）
- FR73: 平台管理员可以查看所有实体模型（数据库表结构）
- FR74: 平台管理员可以查看租户列表
- FR75: 平台管理员可以查看平台统计数据（用户数、租户数）

## Non-Functional Requirements

### Performance

**API 响应时间：**
- NFR-P1: 普通 API 请求 P95 响应时间 < 200ms
- NFR-P2: 复杂查询 API P95 响应时间 < 500ms
- NFR-P3: 应用启动时间 < 30 秒

**并发支持：**
- NFR-P4: 系统支持 ≥ 1000 QPS
- NFR-P5: 数据库连接池支持 ≥ 100 并发连接

**性能退化：**
- NFR-P6: 10 倍数据增长时，性能退化 < 20%

### Security

**认证与授权：**
- NFR-S1: 所有 API 请求必须经过认证（匿名 API 除外）
- NFR-S2: JWT Token 必须使用 HS256 或 RS256 算法签名
- NFR-S3: Token 过期时间可配置（默认 30 分钟）
- NFR-S4: 密码必须使用 bcrypt 或 argon2 加密存储

**数据安全：**
- NFR-S5: 生产环境必须使用 HTTPS
- NFR-S6: 敏感数据（密码、Token）必须加密传输
- NFR-S7: 多租户数据必须完全隔离（Schema 级）

**审计与合规：**
- NFR-S8: 所有写操作必须记录审计日志
- NFR-S9: 审计日志不可篡改
- NFR-S10: 登录失败 5 次后锁定账户

### Scalability

**用户增长：**
- NFR-SC1: 系统支持 10 倍用户增长，无需架构变更
- NFR-SC2: 租户数量支持 ≥ 1000 个

**数据增长：**
- NFR-SC3: 单表支持 ≥ 1000 万行数据
- NFR-SC4: 支持水平分库分表（未来扩展）

**流量峰值：**
- NFR-SC5: 支持 5 倍日常流量的峰值

### Reliability

**可用性：**
- NFR-R1: 系统可用性 ≥ 99.9%（每月停机时间 < 43 分钟）
- NFR-R2: 支持优雅关闭（连接 draining）

**容错能力：**
- NFR-R3: 单点故障不影响整体系统（数据库、缓存）
- NFR-R4: 支持自动重试机制（网络错误）

**恢复能力：**
- NFR-R5: 数据库支持备份和恢复（RTO < 1 小时，RPO < 5 分钟）

### Maintainability

**代码质量：**
- NFR-M1: 单元测试覆盖率 ≥ 80%
- NFR-M2: 集成测试覆盖率 ≥ 60%
- NFR-M3: 代码重复率 < 5%

**文档质量：**
- NFR-M4: 功能文档覆盖率 100%
- NFR-M5: API 文档自动生成率 100%
- NFR-M6: 快速开始文档 < 10 分钟阅读完成

**开发体验：**
- NFR-M7: 新增功能开发时间 < 2 天（简单 CRUD）
- NFR-M8: 新人上手时间 < 1 天

### Compatibility

**向后兼容：**
- NFR-C1: API 变更必须保持向后兼容至少 6 个月
- NFR-C2: 废弃 API 必须提前 3 个月通知

**技术兼容：**
- NFR-C3: 支持 Java 18+
- NFR-C4: 支持 Spring Boot 3.5+
- NFR-C5: 支持 PostgreSQL / MySQL / H2 数据库

### Detected Innovation Areas

**1. Proto DSL + 企业级应用模板（新范式）**

RAD 将 ApiHug 的 Proto DSL 与企业级应用最佳实践结合，创造了一种新的开发范式：
- **Proto DSL 定义 API**：结构化、语义化、类型安全
- **自动生成代码**：Proto → 完整 CRUD API + 权限配置
- **内置最佳实践**：多租户、RBAC、审计日志开箱即用

**与传统方案对比：**
| 方案 | API 定义方式 | 代码生成 | 最佳实践 |
|------|------------|---------|---------|
| 传统 Java | 手写 Controller/Service | 无 | 依赖开发者经验 |
| JHipster | JDL（自定义 DSL） | 完整应用 | 通用 Web 应用 |
| RuoYi | 手写代码 | 代码生成器（需配置） | 国内企业实践 |
| **RAD** | **Proto DSL（标准协议）** | **完整 API+ 权限** | **企业级基础设施** |

**2. AI 友好的开发平台**

Proto DSL 的结构化特性使其天然适合 AI 辅助：
- **AI 理解业务语义**：Proto 定义清晰表达实体关系和 API 意图
- **AI 辅助代码生成**：基于 Proto 定义生成完整 CRUD + 测试
- **AI 辅助 API 设计**：自然语言描述 → AI 推荐 Proto 定义

**AI 能力路线图：**
- 当前：Proto DSL 适合 AI 辅助（未来整合 AI 工具）
- 近期：AI 辅助 Proto 定义（自然语言 → Proto）
- 远期：AI 自主开发（Proto → AI 生成完整业务逻辑）

**3. Contract-First 开发体验**

Proto 定义即合同，AI 和人类都能理解：
- **减少沟通成本**：产品、开发、AI 对需求理解一致
- **提高代码质量**：Proto 约束保证 API 一致性
- **加速协作**：合同明确，并行开发

### Market Context & Competitive Landscape

**竞争格局：**
| 竞品 | 定位 | 创新点 | 不足 |
|------|------|-------|------|
| JHipster | Web 应用生成器 | JDL DSL、完整应用生成 | 不专注企业级基础设施 |
| RuoYi | 企业级快速开发平台 | 国内实践、功能丰富 | 代码质量参差不齐 |
| ApiHug | 框架 + 工具链 | Proto DSL、Contract-First | 不提供应用实现 |
| **RAD** | **企业级应用模板** | **Proto DSL + 最佳实践 + AI 友好** | **新进入市场** |

**市场机会：**
- ApiHug 生态缺少应用层参考实现
- 开发者需要快速启动的企业级模板
- AI 辅助开发成为新常态

### Validation Approach

**创新验证方法：**

| 创新点 | 验证方法 | 成功标准 |
|-------|---------|---------|
| 5 分钟启动 | 用户测试（10 个开发者） | 8/10 在 5 分钟内成功启动 |
| AI 友好性 | 整合 AI 工具测试 | AI 生成 Proto 定义准确率 > 80% |
| Contract-First | 对比实验（Proto vs 传统） | 沟通成本降低 50% |
| 开发效率提升 | 用户案例追踪 | 项目交付时间缩短 60% |

**验证时间表：**
- 0-3 个月：MVP 验证（启动成功率 > 95%）
- 3-6 个月：社区反馈（"神器"评价 > 30%）
- 6-12 个月：案例研究（交付时间缩短 60%）

### Risk Mitigation

**创新风险与应对：**

| 风险 | 可能性 | 影响 | 应对措施 |
|------|-------|------|---------|
| 5 分钟启动失败 | 中 | 高 | 完善文档、提供 Docker 镜像 |
| AI 辅助不实用 | 中 | 中 | 作为可选功能，不影响核心价值 |
| Contract-First 不被接受 | 低 | 中 | 提供传统方式迁移指南 |
| 社区 adoption 低 | 中 | 高 | 内容营销、社区建设、案例分享 |
| 竞品快速跟进 | 中 | 中 | 建立社区壁垒、持续创新 |
