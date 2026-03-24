# API 参考文档

**版本：** 1.0  
**更新日期：** 2026-03-20  
**基础路径：** `/api`  

---

## 📋 目录

1. [认证 API](#认证-api)
2. [用户管理 API](#用户管理-api)
3. [角色管理 API](#角色管理-api)
4. [菜单管理 API](#菜单管理-api)
5. [租户管理 API](#租户管理-api)
6. [部门管理 API](#部门管理-api)
7. [部门员工 API](#部门员工-api)
8. [组织管理 API](#组织管理-api)
9. [审计日志 API](#审计日志-api)

---

## 认证 API

### 1. 用户登录

```http
POST /auth/login
```

**请求：**

```json
{
  "username": "admin",
  "password": "admin123",
  "organization_id": 1,
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
    "user_info": {
      "id": 1,
      "username": "admin",
      "nickname": "管理员",
      "status": "ACTIVE"
    },
    "current_organization": {
      "id": 1,
      "organization_code": "acme_corp",
      "organization_name": "Acme 公司"
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

### 3. 获取当前用户信息

```http
GET /auth/current-user-info
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "user": {
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
      "user:view",
      "user:create"
    ],
    "department": {
      "id": 1,
      "dept_code": "tech_dev",
      "dept_name": "研发部"
    },
    "current_organization": {
      "id": 1,
      "organization_code": "acme_corp",
      "organization_name": "Acme 公司"
    }
  }
}
```

---

### 4. 获取用户组织列表

```http
GET /auth/user-organizations
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200,
  "data": {
    "organizations": [
      {
        "id": 1,
        "organization_code": "acme_corp",
        "organization_name": "Acme 公司",
        "is_default": true
      },
      {
        "id": 2,
        "organization_code": "sub_org",
        "organization_name": "分公司",
        "is_default": false
      }
    ],
    "default_organization_id": 1
  }
}
```

---

### 5. 切换组织

```http
POST /auth/switch-organization
Authorization: Bearer {token}
Content-Type: application/json

{
  "organization_id": 2
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

## 用户管理 API

### 1. 创建用户

```http
POST /api/users
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

### 2. 获取用户详情

```http
GET /api/users/{userId}
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

### 3. 更新用户

```http
PUT /api/users/{userId}
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

### 4. 删除用户

```http
DELETE /api/users/{userId}
Authorization: Bearer {token}
```

**响应：**

```json
{
  "code": 200
}
```

---

### 5. 搜索用户

```http
POST /api/users/search?page=0&size=10
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
      "dept_name": "技术部"
    },
    "children": [
      {
        "department": {
          "id": 2,
          "parent_id": 1,
          "dept_code": "tech_dev",
          "dept_name": "研发部"
        },
        "children": []
      }
    ]
  }
}
```

---

### 2. 添加员工到部门

```http
POST /api/department-employees
Authorization: Bearer {token}
Content-Type: application/json

{
  "employee_id": 1,
  "department_id": 2,
  "position": "工程师"
}
```

---

### 3. 员工调岗

```http
POST /api/department-employees/transfer
Authorization: Bearer {token}
Content-Type: application/json

{
  "employee_id": 1,
  "from_department_id": 2,
  "to_department_id": 3,
  "position": "经理"
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
| 10001026 | 用户已存在 |
| 10002001 | 角色不存在 |
| 10002002 | 角色代码已存在 |
| 10003001 | 菜单不存在 |
| 10003002 | 菜单代码已存在 |
| 10004001 | 租户不存在 |
| 10005001 | 部门不存在 |
| 10005002 | 部门代码已存在 |
| 10005003 | 部门有子部门 |
| 10005004 | 部门有员工 |
| 10006001 | 登录失败 |
| 10006002 | 账户已锁定 |
| 10006003 | 组织不存在 |
| 10006004 | 无权访问该组织 |

---

**文档更新日期：** 2026-03-20
