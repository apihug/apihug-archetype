// 重命名完成后的总结文档
# Customer 命名规范

## 核心原则

**✅ 使用 "Customer"** - 表示所有使用系统的人类用户
**❌ 不使用 "User"** - 避免歧义

## Customer 包括的角色

- 管理员（Admin）
- 成员（Member）
- 员工（Employee）
- 经理（Manager）
- 以及其他所有业务角色

## API 命名规范

### 认证 API
- `/api/auth/login` - 客户登录
- `/api/auth/logout` - 客户登出

### 客户服务 API
- `/api/customer/info` - 当前客户信息查询
- `/api/customer/current-user-info` - 当前客户完整信息
- `/api/customer/user-organizations` - 客户组织列表
- `/api/customer/switch-organization` - 切换组织

### 客户管理 API
- `/api/customers` - 客户管理
- `POST /api/customers` - 创建客户
- `GET /api/customers/{customerId}` - 获取客户详情
- `PUT /api/customers/{customerId}` - 更新客户
- `DELETE /api/customers/{customerId}` - 删除客户
- `POST /api/customers/search` - 搜索客户

## 实体命名

- ✅ `CustomerEntity` - 客户实体
- ✅ `CustomerStatusEnum` - 客户状态枚举
- ✅ `CustomerErrorEnum` - 客户相关错误码

## Service 命名

- ✅ `CustomerAuthService` - 客户认证服务
- ✅ `CustomerService` - 客户服务（查询当前客户信息）
- ✅ `CustomerManagementService` - 客户管理服务（CRUD）

---

**所有 "User" 命名已清除，全部使用 "Customer"！**
