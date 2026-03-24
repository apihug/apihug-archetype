# API 参考文档

**版本：** 1.0  
**更新日期：** 2026-03-24  
**基础路径：** `/api`  

---

## 📋 目录

1. [认证 API](#认证-api)
2. [客户管理 API](#客户管理-api)
3. [角色管理 API](#角色管理-api)
4. [菜单管理 API](#菜单管理-api)
5. [租户管理 API](#租户管理-api)
6. [租户成员管理 API](#租户成员管理-api)
7. [部门管理 API](#部门管理-api)
8. [审计日志 API](#审计日志-api)

---

## 认证 API

### 1. 客户登录

```http
POST /auth/login
```

**请求：**

```json
{
  "username": "admin",
  "password": "admin123",
  "tenant_id": 1,
  "captcha": "abcd"
}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "token_type": "Bearer",
    "expires_in": 7200,
    "customer_info": {
      "id": 1,
      "username": "admin",
      "nickname": "管理员",
      "status": "ACTIVE"
    },
    "current_tenant": {
      "id": 1,
      "tenant_code": "acme_corp",
      "tenant_name": "Acme 公司",
      "is_platform": false
    }
  }
}
```

---

### 2. 退出登录

```http
POST /auth/logout
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200
}
```

---

### 3. 获取当前客户信息

```http
GET /api/customer/current-info
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "customer": {
      "customer_id": 1,
      "username": "admin",
      "tenant_id": 1
    },
    "roles": [
      {
        "id": 1,
        "role_code": "admin",
        "role_name": "管理员"
      }
    ],
    "authorities": [
      "customer:view",
      "customer:create"
    ],
    "department": {
      "id": 1,
      "dept_code": "tech_dev",
      "dept_name": "研发部"
    },
    "current_tenant": {
      "id": 1,
      "tenant_code": "acme_corp",
      "tenant_name": "Acme 公司",
      "is_platform": false
    }
  }
}
```

---

### 4. 获取客户租户列表

```http
GET /api/customer/tenants
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "tenants": [
      {
        "id": 1,
        "tenant_code": "acme_corp",
        "tenant_name": "Acme 公司",
        "is_platform": false,
        "is_default": true
      },
      {
        "id": 2,
        "tenant_code": "sub_tenant",
        "tenant_name": "分公司",
        "is_platform": false,
        "is_default": false
      }
    ],
    "default_tenant": 1
  }
}
```

---

### 5. 切换租户

```http
POST /api/customer/switch-tenant
Authorization: Bearer {token}
Content-Type: application/json

{
  "tenant_id": 2
}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "access_token": "new_token...",
    "token_type": "Bearer",
    "expires_in": 7200
  }
}
```

---

## 客户管理 API

### 1. 创建客户

```http
POST /api/customers/customers
Authorization: Bearer {token}
Content-Type: application/json

{
  "username": "zhangsan",
  "password": "SecureP@ss123",
  "email": "zhangsan@example.com",
  "status": "ACTIVE",
  "default_tenant_id": 1
}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "id": 1,
    "username": "zhangsan",
    "status": "ACTIVE"
  }
}
```

---

### 2. 获取客户详情

```http
GET /api/customers/customers/{customerId}
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "id": 1,
    "username": "zhangsan",
    "email": "zhangsan@example.com",
    "status": "ACTIVE",
    "default_tenant_id": 1,
    "created_at": "2024-01-15T10:30:00"
  }
}
```

---

### 3. 更新客户

```http
PUT /api/customers/customers/{customerId}
Authorization: Bearer {token}
Content-Type: application/json

{
  "email": "newemail@example.com",
  "status": "ACTIVE"
}
```

**响应：**

```json
{
  "code": 200
}
```

---

### 4. 删除客户

```http
DELETE /api/customers/customers/{customerId}
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200
}
```

---

### 5. 搜索客户

```http
POST /api/customers/customers/search?page=0&size=10
Authorization: Bearer {token}
Content-Type: application/json

{
  "keyword": "zhangsan",
  "status": "ACTIVE"
}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "page_index": 0,
    "page_size": 10,
    "total_count": 1,
    "total_page": 1,
    "data": [
      {
        "id": 1,
        "username": "zhangsan",
        "email": "zhangsan@example.com",
        "status": "ACTIVE"
      }
    ]
  }
}
```

---

## 角色管理 API

### 1. 创建角色

```http
POST /api/roles
Authorization: Bearer {token}
Content-Type: application/json

{
  "role_code": "manager",
  "role_name": "经理",
  "description": "部门经理角色",
  "status": "ACTIVE"
}
```

---

### 2. 分配权限

```http
POST /api/roles/{roleId}/permissions
Authorization: Bearer {token}
Content-Type: application/json

{
  "permission_ids": [1, 2, 3]
}
```

---

### 3. 移除权限

```http
DELETE /api/roles/{roleId}/permissions/{permissionId}
Authorization: Bearer {token}
```

---

## 菜单管理 API

### 1. 获取菜单树

```http
GET /api/menus/tree
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "menu": {
      "id": 1,
      "parent_id": 0,
      "menu_code": "system",
      "menu_name": "系统管理"
    },
    "children": [
      {
        "menu": {
          "id": 2,
          "parent_id": 1,
          "menu_code": "system_user",
          "menu_name": "用户管理",
          "path": "/system/user",
          "icon": "lucide:users"
        },
        "children": []
      }
    ]
  }
}
```

---

## 租户成员管理 API

### 1. 获取租户成员列表

```http
GET /api/tenants/{tenantId}/members?page=0&size=10
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "page_index": 0,
    "page_size": 10,
    "total_count": 2,
    "total_page": 1,
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

```http
POST /api/tenants/{tenantId}/members
Authorization: Bearer {token}
Content-Type: application/json

{
  "customer_id": 2,
  "member_role": "MEMBER",
  "department_id": 1
}
```

---

### 3. 从租户移除成员

```http
DELETE /api/tenants/{tenantId}/members/{memberId}
Authorization: Bearer {token}
```

---

### 4. 切换成员锁定状态

```http
POST /api/tenants/{tenantId}/members/{memberId}/toggle-lock
Authorization: Bearer {token}
```

---

### 5. 更新成员角色

```http
PUT /api/tenants/{tenantId}/members/{memberId}/role
Authorization: Bearer {token}
Content-Type: application/json

{
  "member_role": "ADMIN"
}
```

---

### 6. 分配成员部门

```http
PUT /api/tenants/{tenantId}/members/{memberId}/department
Authorization: Bearer {token}
Content-Type: application/json

{
  "department_id": 2
}
```

---

### 7. 设置默认租户

```http
POST /api/tenants/{tenantId}/set-default
Authorization: Bearer {token}
```

---

## 部门管理 API

### 1. 获取部门树

```http
GET /api/departments/tree
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "department": {
      "id": 1,
      "parent_id": 0,
      "dept_code": "tech",
      "dept_name": "技术部",
      "tenant_id": 1
    },
    "children": [
      {
        "department": {
          "id": 2,
          "parent_id": 1,
          "dept_code": "tech_dev",
          "dept_name": "研发部",
          "tenant_id": 1
        },
        "children": []
      }
    ]
  }
}
```

---

## 错误码说明

### 通用错误码

| 错误码 | HTTP 状态 | 说明 |
|--------|----------|------|
| 200 | 200 | 成功 |
| 400 | 400 | 请求参数错误 |
| 401 | 401 | 未认证 |
| 403 | 403 | 无权限 |
| 404 | 404 | 资源不存在 |
| 500 | 500 | 服务器内部错误 |

### 业务错误码

| 错误码 | 说明 |
|--------|------|
| 10001023 | 客户不存在 |
| 10001024 | 账户锁定 |
| 10001025 | 登录失败 |
| 10001026 | 客户已存在 |
| 10002001 | 角色不存在 |
| 10002002 | 角色代码已存在 |
| 10003001 | 菜单不存在 |
| 10003002 | 菜单代码已存在 |
| 10004001 | 租户不存在 |
| 10005001 | 部门不存在 |
| 10005002 | 部门代码已存在 |
| 10005003 | 部门有子部门 |
| 10005004 | 部门有成员 |

---

**文档更新日期：** 2026-03-24
