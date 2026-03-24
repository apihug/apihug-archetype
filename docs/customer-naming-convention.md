// 重命名完成后的总结文档
# Customer 命名规范

## 核心原则

**✅ 使用 "Customer"** - 表示所有使用系统的人类用户（自然人）
**✅ 使用 "Tenant"** - 表示公司/组织（平台 = 特殊租户）
**✅ 使用 "TenantMember"** - 表示客户在租户中的身份（员工）
**❌ 不使用 "User"** - 避免歧义
**❌ 不使用 "Organization"** - 已统一为 Tenant

## Customer 包括的角色

- 管理员（Admin）
- 成员（Member）
- 拥有者（Owner）
- 经理（Manager）
- 以及其他所有业务角色

## API 命名规范

### 认证 API
- `/api/auth/login` - 客户登录
- `/api/auth/logout` - 客户登出

### 客户服务 API
- `/api/customer/info` - 当前客户信息查询
- `/api/customer/current-info` - 当前客户完整信息
- `/api/customer/tenants` - 客户租户列表
- `/api/customer/switch-tenant` - 切换租户

### 客户管理 API
- `POST /api/customers/customers` - 创建客户
- `GET /api/customers/customers/{customerId}` - 获取客户详情
- `PUT /api/customers/customers/{customerId}` - 更新客户
- `DELETE /api/customers/customers/{customerId}` - 删除客户
- `POST /api/customers/customers/search` - 搜索客户

### 租户成员 API
- `GET /api/tenant-members/tenants/{tenantId}/members` - 获取租户成员
- `POST /api/tenant-members/tenants/{tenantId}/members` - 添加租户成员
- `DELETE /api/tenant-members/tenants/{tenantId}/members/{memberId}` - 移除租户成员
- `PUT /api/tenant-members/tenants/{tenantId}/members/{memberId}/role` - 更新成员角色

## 实体命名

- ✅ `CustomerEntity` - 客户实体
- ✅ `TenantEntity` - 租户实体（is_platform=true 为平台）
- ✅ `TenantMemberEntity` - 租户成员实体
- ✅ `CustomerStatusEnum` - 客户状态枚举
- ✅ `CustomerErrorEnum` - 客户相关错误码
- ✅ `MemberRoleEnum` - 成员角色（OWNER/ADMIN/MEMBER）
- ✅ `TenantMemberStatusEnum` - 成员状态

## Service 命名

- ✅ `CustomerAuthService` - 客户认证服务
- ✅ `CustomerService` - 客户服务（查询当前客户信息、租户切换）
- ✅ `CustomerManagementService` - 客户管理服务（CRUD）
- ✅ `TenantService` - 租户管理服务
- ✅ `TenantMemberService` - 租户成员管理服务

---

**所有 "User" 命名已清除，全部使用 "Customer"！**
**所有 "Organization" 命名已清除，全部使用 "Tenant"！**

---

**文档更新日期：** 2026-03-24
