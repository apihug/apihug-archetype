# 租户成员管理模块详细文档

**模块路径：** `com.apihug.rad.api.tenant`  
**主要 Service：** `TenantMemberServiceImpl`  
**Proto 文件：** `api/tenant/member.proto`  
**实体文件：** `domain/tenant/member.proto`  

---

## 📋 功能概述

租户成员管理模块提供完整的租户成员生命周期管理：

- ✅ 获取租户成员列表（分页）
- ✅ 添加成员到租户
- ✅ 从租户移除成员
- ✅ 切换成员锁定状态
- ✅ 更新成员角色（OWNER/ADMIN/MEMBER）
- ✅ 分配成员部门
- ✅ 设置默认租户

---

## 🏗️ 架构设计

### 核心概念

**TenantMember** 表示 Customer（客户）在 Tenant（租户）中的成员身份。

| 概念 | 说明 |
|------|------|
| Customer | 自然人，系统登录主体 |
| Tenant | 公司/组织，资源隔离边界 |
| TenantMember | Customer 在 Tenant 中的身份关系 |
| MemberRole | 成员角色：OWNER（拥有者）、ADMIN（管理员）、MEMBER（普通成员） |

### API 端点

| API | 方法 | 端点 | 说明 |
|-----|------|------|------|
| 获取成员列表 | GET | `/api/tenants/{tenantId}/members` | 分页查询 |
| 添加成员 | POST | `/api/tenants/{tenantId}/members` | 添加客户为成员 |
| 移除成员 | DELETE | `/api/tenants/{tenantId}/members/{memberId}` | 从租户移除 |
| 切换锁定 | POST | `/api/tenants/{tenantId}/members/{memberId}/toggle-lock` | 锁定/解锁 |
| 更新角色 | PUT | `/api/tenants/{tenantId}/members/{memberId}/role` | 更新成员角色 |
| 分配部门 | PUT | `/api/tenants/{tenantId}/members/{memberId}/department` | 分配到部门 |
| 设置默认 | POST | `/api/tenants/{tenantId}/set-default` | 设为当前客户默认租户 |

---

## 🔧 核心功能实现

### 1. 获取租户成员列表

**API:** `GET /api/tenants/{tenantId}/members`

**响应示例：**

```json
{
  "code": 200,
  "data": {
    "page_index": 0,
    "page_size": 10,
    "total_count": 2,
    "data": [
      {
        "id": 1,
        "customer_id": 1,
        "username": "admin",
        "member_role": "OWNER",
        "department_id": 1,
        "is_locked": false
      }
    ]
  }
}
```

---

### 2. 添加成员到租户

**API:** `POST /api/tenants/{tenantId}/members`

**实现要点：**
- 验证客户存在
- 验证未超出租户最大成员数
- 检查是否已是成员
- 默认角色为 MEMBER

---

### 3. 更新成员角色

**API:** `PUT /api/tenants/{tenantId}/members/{memberId}/role`

**成员角色枚举（MemberRoleEnum）：**

| 角色 | 说明 |
|------|------|
| OWNER | 拥有者 - 最高权限，可管理所有成员 |
| ADMIN | 管理员 - 可管理普通成员 |
| MEMBER | 普通成员 - 基本访问权限 |

---

### 4. 分配成员部门

**API:** `PUT /api/tenants/{tenantId}/members/{memberId}/department`

**实现要点：**
- 验证部门属于同一租户
- 更新 TenantMemberEntity.department_id
- 替代了原来的 DepartmentEmployee 关联

---

## 📊 数据库表结构

### SYS_TENANT_MEMBER (租户成员表)

| 字段 | 类型 | 约束 | 说明 |
|------|------|------|------|
| ID | BIGINT | PRIMARY KEY | 主键 |
| CUSTOMER_ID | BIGINT | NOT NULL | 客户 ID |
| TENANT_ID | BIGINT | NOT NULL | 租户 ID |
| MEMBER_ROLE | VARCHAR(20) | NOT NULL, DEFAULT 'MEMBER' | 成员角色 |
| DEPARTMENT_ID | BIGINT | DEFAULT 0 | 部门 ID |
| IS_LOCKED | BOOLEAN | NOT NULL, DEFAULT FALSE | 是否锁定 |
| IS_DEFAULT | BOOLEAN | NOT NULL, DEFAULT FALSE | 是否默认租户 |
| DELETED | BOOLEAN | NOT NULL, DEFAULT FALSE | 软删除标记 |
| CREATED_AT | TIMESTAMP | NOT NULL | 创建时间 |
| CREATED_BY | BIGINT | NOT NULL | 创建人 |
| UPDATED_AT | TIMESTAMP | | 更新时间 |
| UPDATED_BY | BIGINT | | 更新人 |

**索引：**
```sql
CREATE UNIQUE INDEX UK_SYS_TENANT_MEMBER ON SYS_TENANT_MEMBER(CUSTOMER_ID, TENANT_ID);
CREATE INDEX IDX_SYS_TENANT_MEMBER_TENANT ON SYS_TENANT_MEMBER(TENANT_ID);
CREATE INDEX IDX_SYS_TENANT_MEMBER_CUSTOMER ON SYS_TENANT_MEMBER(CUSTOMER_ID);
CREATE INDEX IDX_SYS_TENANT_MEMBER_DEPT ON SYS_TENANT_MEMBER(DEPARTMENT_ID);
```

---

## 🔒 权限要求

| 操作 | 权限代码 | 说明 |
|------|---------|------|
| 查看成员 | `TENANT_MEMBER_VIEW` | tenant:member:view |
| 添加成员 | `TENANT_MEMBER_ADD` | tenant:member:add |
| 移除成员 | `TENANT_MEMBER_REMOVE` | tenant:member:remove |
| 锁定成员 | `TENANT_MEMBER_LOCK` | tenant:member:lock |
| 更新角色 | `TENANT_MEMBER_ASSIGN_ROLE` | tenant:member:assign-role |
| 分配部门 | `TENANT_MEMBER_ASSIGN_DEPARTMENT` | tenant:member:assign-department |

---

## 📝 待完善功能

### 高优先级
- [ ] 成员数量上限检查（max_members）
- [ ] 角色权限层级校验（MEMBER 不能升级为 OWNER）
- [ ] 批量添加成员

### 中优先级
- [ ] 成员邀请机制
- [ ] 成员转让拥有者
- [ ] 成员活动日志

---

## 🔗 相关文件

- **Proto 定义：** `rad-app/src/main/proto/com/apihug/rad/api/tenant/member.proto`
- **Domain 定义：** `rad-app/src/main/proto/com/apihug/rad/domain/tenant/member.proto`
- **成员常量：** `rad-app/src/main/proto/com/apihug/rad/infra/tenant/member_constant.proto`
- **Service 实现：** `rad-app/src/main/java/com/apihug/rad/api/tenant/TenantMemberServiceImpl.java`
- **权限定义：** `rad-app/src/main/proto/com/apihug/rad/infra/settings/authority.proto`

---

**文档更新日期：** 2026-03-24
