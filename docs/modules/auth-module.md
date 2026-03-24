# 认证模块详细文档

**模块路径：** `com.apihug.rad.api.customer`  
**主要 Service：** `CustomerAuthServiceImpl`, `CustomerServiceImpl`  
**Proto 文件：** `api/customer/api.proto`  

---

## 📋 功能概述

认证模块提供完整的用户认证和授权功能，包括：

- ✅ 用户登录/登出
- ✅ JWT Token 生成和验证
- ✅ 获取当前用户完整信息
- ✅ 用户组织管理
- ✅ 组织切换

---

## 🏗️ 架构设计

### 组件关系

```
┌─────────────────────────────────────────────────────────┐
│                    Controller (Generated)                │
├─────────────────────────────────────────────────────────┤
│                    CustomerAuthServiceImpl               │
│  ┌─────────────────────────────────────────────────┐    │
│  │ - login()                                       │    │
│  │ - logout()                                      │    │
│  │ - getCurrentUserInfo()                          │    │
│  │ - getUserOrganizations()                        │    │
│  │ - switchOrganization()                          │    │
│  └─────────────────────────────────────────────────┘    │
│                     ↓                                    │
│  ┌─────────────────────────────────────────────────┐    │
│  │         CustomerEntityRepository                │    │
│  │  - findByUsername()                             │    │
│  │  - findById()                                   │    │
│  └─────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────┘
```

### 关键依赖

| 依赖 | 用途 |
|------|------|
| `JWTTokenProvider` | JWT Token 生成和验证 |
| `CustomerEntityRepository` | 用户数据访问 |
| `PasswordEncoder` | 密码加密（SHA256） |
| `HopeContextHolder` | 获取当前登录用户上下文 |

---

## 🔐 认证流程

### 登录流程

```
1. 用户请求 POST /api/auth/login
   ↓
2. CustomerAuthServiceImpl.login()
   ↓
3. 验证用户名密码
   - customerRepository.findByUsername()
   - passwordEncoder.matches()
   ↓
4. 检查用户状态
   - status == ACTIVE
   ↓
5. 生成 JWT Token
   - jwtTokenProvider.createToken()
   ↓
6. 返回 LoginResponse
   - access_token
   - user_info
   - organizations
```

### 代码示例

```java
@Override
public void login(SimpleResultBuilder<LoginResponse> builder,
    LoginRequest loginRequest) {
  
  // 1. 查找用户
  CustomerEntity customer = customerRepository.findByUsername(loginRequest.getUsername())
      .orElseThrow(() -> HopeErrorDetailException.errorBuilder(AuthErrorEnum.LOGIN_FAIL).build());

  // 2. 验证密码
  if (!passwordEncoder.matches(loginRequest.getPassword(), customer.getPasswordHash())) {
    throw HopeErrorDetailException.errorBuilder(AuthErrorEnum.LOGIN_FAIL).build();
  }

  // 3. 检查状态
  if (customer.getStatus() != UserStatusEnum.ACTIVE) {
    throw HopeErrorDetailException.errorBuilder(AuthErrorEnum.ACCOUNT_LOCKED).build();
  }

  // 4. 生成 Token
  String accessToken = jwtTokenProvider.createToken(customer.getId());

  // 5. 构建响应
  LoginResponse response = new LoginResponse()
      .setAccessToken(accessToken)
      .setTokenType("Bearer")
      .setExpiresIn(7200L)
      .setUserInfo(buildUserInfo(customer));

  builder.payload(response);
}
```

---

## 👤 获取当前用户信息

### API: GET /api/auth/current-user-info

**功能：** 获取当前登录用户的完整信息，包括权限、角色、部门等。

**实现：**

```java
@Override
public void getCurrentUserInfo(SimpleResultBuilder<CurrentUserInfo> builder) {
    // 1. 获取当前登录用户 ID
    Long customerId = (Long) HopeContextHolder.customer().getId();
    
    // 2. 查询用户信息
    CustomerEntity customer = customerRepository.findById(customerId)
        .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

    // 3. 构建响应
    CurrentUserInfo userInfo = new CurrentUserInfo()
        .setUser(new CustomerInfo()
            .setCustomerId(customer.getId())
            .setUsername(customer.getUsername())
            .setTenantId(customer.getDefaultTenantId()));

    // TODO: 加载用户角色列表
    // TODO: 加载用户权限列表
    // TODO: 加载用户部门信息
    // TODO: 加载当前组织信息

    builder.payload(userInfo);
}
```

**响应示例：**

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
      "user:create",
      "role:view"
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

## 🏢 组织切换

### API: POST /api/auth/switch-organization

**功能：** 用户切换到另一个组织，生成新的 Token。

**实现：**

```java
@Override
public void switchOrganization(SimpleResultBuilder<LoginResponse> builder,
    SwitchOrganizationRequest switchOrganizationRequest) {
  
  // 1. 验证用户是否有该组织权限
  // 2. 生成新 Token（包含新组织 ID）
  // 3. 返回新的登录响应
  
  LoginResponse response = new LoginResponse();
  builder.payload(response);
}
```

**TODO 实现：**
- [ ] 验证用户组织权限
- [ ] 生成包含新组织 ID 的 Token
- [ ] 刷新用户权限缓存

---

## 📊 数据库表结构

### SYS_CUSTOMER (用户表)

| 字段 | 类型 | 说明 |
|------|------|------|
| ID | BIGINT | 主键 |
| USERNAME | VARCHAR(50) | 用户名（唯一） |
| PASSWORD_HASH | VARCHAR(255) | 密码哈希 |
| PASSWORD_SLAT | VARCHAR(255) | 密码盐 |
| EMAIL | VARCHAR(100) | 邮箱 |
| STATUS | VARCHAR(12) | 状态（ACTIVE/INACTIVE/LOCKED） |
| DEFAULT_TENANT_ID | BIGINT | 默认租户 ID |
| CREATED_AT | TIMESTAMP | 创建时间 |
| CREATED_BY | BIGINT | 创建人 |
| UPDATED_AT | TIMESTAMP | 更新时间 |
| UPDATED_BY | BIGINT | 更新人 |

### SYS_USER_ORGANIZATION (用户组织关联表)

| 字段 | 类型 | 说明 |
|------|------|------|
| ID | BIGINT | 主键 |
| USER_ID | BIGINT | 用户 ID |
| ORGANIZATION_ID | BIGINT | 组织 ID |
| IS_DEFAULT | BOOLEAN | 是否默认组织 |
| DEPARTMENT_ID | BIGINT | 部门 ID |
| CREATED_AT | TIMESTAMP | 创建时间 |
| CREATED_BY | BIGINT | 创建人 |

---

## 🔒 安全考虑

### 密码安全

- ✅ 使用 SHA256 加密
- ✅ 添加随机盐值
- ✅ 密码长度限制（6-100 字符）

### Token 安全

- ✅ JWT Token 签名验证
- ✅ Token 过期时间（2 小时）
- ✅ Token 刷新机制

### 账户安全

- ✅ 登录失败次数限制
- ✅ 账户锁定机制
- ✅ 状态检查（ACTIVE/LOCKED/DISABLED）

---

## 🧪 测试覆盖

### 单元测试

| 测试类 | 测试方法数 | 覆盖功能 |
|--------|-----------|---------|
| `CustomerAuthServiceImplTest` | 7 | 登录、登出、获取用户信息 |
| `CustomerServiceImplTest` | 11 | 用户 CRUD、搜索 |

### 测试示例

```java
@Test
@DisplayName("用户登录 - 成功")
void testLogin_Success() {
    // Arrange
    LoginRequest request = new LoginRequest()
        .setUsername("admin")
        .setPassword("admin123");

    CustomerEntity customer = new CustomerEntity()
        .setId(1L)
        .setUsername("admin")
        .setStatus(UserStatusEnum.ACTIVE);

    when(customerRepository.findByUsername("admin")).thenReturn(Optional.of(customer));

    // Act
    authService.login(loginBuilder, request);

    // Assert
    verify(loginBuilder).payload(any(LoginResponse.class));
}
```

---

## 📝 待完善功能

### 高优先级
- [ ] 登录失败次数限制（Redis 计数）
- [ ] 账户锁定时间控制
- [ ] 密码强度验证
- [ ] 用户角色列表加载
- [ ] 用户权限列表加载
- [ ] 用户部门信息加载

### 中优先级
- [ ] 组织切换完整实现
- [ ] Token 刷新接口
- [ ] 登录日志记录
- [ ] 在线用户管理

---

## 🔗 相关文件

- **Proto 定义：** `rad-app/src/main/proto/com/apihug/rad/api/customer/api.proto`
- **Service 实现：** `rad-app/src/main/java/com/apihug/rad/api/customer/CustomerAuthServiceImpl.java`
- **Service 实现：** `rad-app/src/main/java/com/apihug/rad/api/customer/CustomerServiceImpl.java`
- **实体定义：** `rad-app/src/main/proto/com/apihug/rad/domain/customer/domain.proto`
- **测试代码：** `rad-app/src/test/java/com/apihug/rad/api/customer/`

---

**文档更新日期：** 2026-03-20
