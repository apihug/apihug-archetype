# 用户管理模块详细文档

**模块路径：** `com.apihug.rad.api.customer`  
**主要 Service：** `UserServiceImpl`  
**Proto 文件：** `api/customer/api.proto`  
**实体文件：** `domain/customer/domain.proto`  

---

## 📋 功能概述

用户管理模块提供完整的用户 CRUD 操作和搜索功能：

- ✅ 创建用户
- ✅ 查询用户详情
- ✅ 更新用户信息
- ✅ 删除用户（软删除）
- ✅ 搜索用户（分页）

---

## 🏗️ 架构设计

### 组件关系

```
┌─────────────────────────────────────────────────────────┐
│                    Controller (Generated)                │
├─────────────────────────────────────────────────────────┤
│                    UserServiceImpl                       │
│  ┌─────────────────────────────────────────────────┐    │
│  │ - createUser()                                  │    │
│  │ - getUser()                                     │    │
│  │ - updateUser()                                  │    │
│  │ - deleteUser()                                  │    │
│  │ - searchUsers()                                 │    │
│  └─────────────────────────────────────────────────┘    │
│                     ↓                                    │
│  ┌─────────────────────────────────────────────────┐    │
│  │         _CustomerEntityRepository (Trait)       │    │
│  │  - findByUsername()                             │    │
│  │  - findByEmail()                                │    │
│  │  - searchUsers()                                │    │
│  └─────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────┘
```

---

## 🔧 核心功能实现

### 1. 创建用户

**API:** `POST /api/users`

**实现要点：**
- 验证用户名唯一性
- 验证邮箱唯一性
- 密码加密存储
- 设置默认状态

**代码示例：**

```java
@Override
public void createUser(SimpleResultBuilder<UserSummary> builder,
    CreateUserRequest createRequest) {
  
  // 1. 验证用户名唯一性
  if (customerRepository.existsByUsername(createRequest.getUsername())) {
    throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.USER_ALREADY_EXISTS).build();
  }

  // 2. 验证邮箱唯一性
  if (customerRepository.existsByEmail(createRequest.getEmail())) {
    throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.USER_ALREADY_EXISTS).build();
  }

  // 3. 创建实体
  CustomerEntity entity = new CustomerEntity()
      .setUsername(createRequest.getUsername())
      .setPasswordHash(passwordEncoder.encode(createRequest.getPassword()))
      .setPasswordSlat(generateSalt())
      .setEmail(createRequest.getEmail())
      .setStatus(createRequest.getStatus() != null 
          ? createRequest.getStatus() 
          : CustomerStatusEnum.ACTIVE);

  // 4. 保存
  CustomerEntity saved = customerRepository.save(entity);

  // 5. 返回摘要
  UserSummary summary = new UserSummary()
      .setId(saved.getId())
      .setUsername(saved.getUsername())
      .setStatus(saved.getStatus());

  builder.payload(summary);
}
```

---

### 2. 搜索用户（分页）

**API:** `POST /api/users/search`

**Proto 定义：**

```proto
rpc SearchUsers (SearchUsersRequest) returns (UserSummary) {
  option (hope.swagger.operation) = {
    post: "/users/search";
    pageable: true;  // 框架自动注入分页参数
    authorization: {
      rbac: {
        authorities: ["USER_VIEW"];
      }
    };
  };
}

message SearchUsersRequest {
  string keyword = 1;  // 只定义业务字段，不要 page/size
  CustomerStatusEnum status = 2;
}
```

**Repository Trait 实现：**

```java
interface _CustomerEntityRepository extends CustomerEntityRepository {
  
  default Page<CustomerEntity> searchUsers(
      String keyword, 
      CustomerStatusEnum status, 
      PageRequest pageRequest) {
    
    // 构建查询条件
    Criteria criteria = EasyCriteria.eq(_Deletable_.DELETED, false);

    // 关键词搜索
    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.Username, "%" + keyword + "%")
              .or(EasyCriteria.like(Domain.Email, "%" + keyword + "%")));
    }

    // 状态筛选
    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    // 执行分页查询
    return findAll(criteria, this.page(pageRequest));
  }
}
```

**ServiceImpl 实现：**

```java
@Override
public void searchUsers(PageableResultBuilder<UserSummary> builder,
    SearchUsersRequest request, PageRequest pageParameter) {
  
  // 调用 Repository trait 方法
  Page<CustomerEntity> page = customerRepository.searchUsers(
      request.getKeyword(),
      request.getStatus(),
      pageParameter
  );

  // 构建分页响应
  builder.setPageIndex(pageParameter.getPage())
         .setPageSize(pageParameter.getSize())
         .setTotalCount(page.getTotalElements())
         .setTotalPage(page.getTotalPages())
         .setData(page.getContent().stream()
             .map(this::buildUserSummary)
             .collect(Collectors.toList()));
}
```

---

### 3. 删除用户（软删除）

**API:** `DELETE /api/users/{userId}`

**实现要点：**
- 软删除（设置 deleted = true）
- 记录删除时间和删除人
- 检查是否有子数据

**代码示例：**

```java
@Override
public void deleteUser(SimpleResultBuilder<String> builder,
    Integer userId) {
  
  // 1. 查找用户
  CustomerEntity entity = customerRepository.findById(userId.longValue())
      .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

  // 2. 软删除
  entity.setDeleted(true)
      .setDeletedAt(LocalDateTime.now())
      .setDeletedBy(HopeContextHolder.customer().getId());

  // 3. 保存
  customerRepository.save(entity);
  
  builder.done();
}
```

---

## 📊 数据库表结构

### SYS_CUSTOMER (用户表)

| 字段 | 类型 | 约束 | 说明 |
|------|------|------|------|
| ID | BIGINT | PRIMARY KEY | 主键 |
| USERNAME | VARCHAR(50) | UNIQUE, NOT NULL | 用户名 |
| EMAIL | VARCHAR(100) | UNIQUE | 邮箱 |
| PASSWORD_HASH | VARCHAR(255) | NOT NULL | 密码哈希 |
| PASSWORD_SLAT | VARCHAR(255) | NOT NULL | 密码盐 |
| STATUS | VARCHAR(12) | NOT NULL, DEFAULT 'ACTIVE' | 状态 |
| DEFAULT_TENANT_ID | BIGINT | NOT NULL, DEFAULT 0 | 默认租户 ID |
| DELETED | BOOLEAN | NOT NULL, DEFAULT FALSE | 软删除标记 |
| DELETED_AT | TIMESTAMP | | 删除时间 |
| DELETED_BY | BIGINT | | 删除人 |
| CREATED_AT | TIMESTAMP | NOT NULL | 创建时间 |
| CREATED_BY | BIGINT | NOT NULL | 创建人 |
| UPDATED_AT | TIMESTAMP | | 更新时间 |
| UPDATED_BY | BIGINT | | 更新人 |

### 索引

```sql
-- 唯一索引
CREATE UNIQUE INDEX UK_SYS_CUSTOMER_USERNAME ON SYS_CUSTOMER(USERNAME);
CREATE UNIQUE INDEX UK_SYS_CUSTOMER_EMAIL ON SYS_CUSTOMER(EMAIL);

-- 普通索引
CREATE INDEX IDX_SYS_CUSTOMER_USERNAME ON SYS_CUSTOMER(USERNAME);
CREATE INDEX IDX_SYS_CUSTOMER_EMAIL ON SYS_CUSTOMER(EMAIL);
CREATE INDEX IDX_SYS_CUSTOMER_TENANT_ID ON SYS_CUSTOMER(DEFAULT_TENANT_ID);
CREATE INDEX IDX_SYS_CUSTOMER_DELETED ON SYS_CUSTOMER(DELETED);
```

---

## 🔒 业务规则

### 用户名规则
- ✅ 长度：1-50 字符
- ✅ 唯一性：全局唯一
- ✅ 格式：字母开头，可包含数字、下划线

### 密码规则
- ✅ 长度：6-100 字符
- ✅ 加密：SHA256 + Salt
- ✅ 强度：建议包含大小写字母、数字、特殊字符

### 邮箱规则
- ✅ 格式：符合 RFC 5322 标准
- ✅ 唯一性：全局唯一
- ✅ 验证：发送验证邮件

### 状态流转

```
INACTIVE → ACTIVE (激活)
ACTIVE → LOCKED (锁定)
ACTIVE → DISABLED (禁用)
LOCKED → ACTIVE (解锁)
DISABLED → ACTIVE (启用)
```

---

## 🧪 测试覆盖

### 单元测试

| 测试类 | 测试方法数 | 覆盖功能 |
|--------|-----------|---------|
| `UserServiceImplTest` | 11 | CRUD、搜索、异常处理 |

### 测试用例

```java
@Test
@DisplayName("创建用户 - 成功")
void testCreateUser_Success() {
    // Arrange
    CreateUserRequest request = new CreateUserRequest()
        .setUsername("testuser")
        .setPassword("SecureP@ss123")
        .setEmail("test@example.com");

    when(customerRepository.existsByUsername("testuser")).thenReturn(false);
    when(customerRepository.existsByEmail("test@example.com")).thenReturn(false);
    when(customerRepository.save(any())).thenReturn(savedEntity);

    // Act
    userService.createUser(summaryBuilder, request);

    // Assert
    verify(customerRepository).save(any());
    verify(summaryBuilder).payload(any());
}

@Test
@DisplayName("创建用户 - 用户名已存在")
void testCreateUser_UsernameExists() {
    // Arrange
    CreateUserRequest request = new CreateUserRequest()
        .setUsername("existing")
        .setPassword("password");

    when(customerRepository.existsByUsername("existing")).thenReturn(true);

    // Act & Assert
    assertThrows(HopeErrorDetailException.class, () -> 
        userService.createUser(summaryBuilder, request));
}

@Test
@DisplayName("搜索用户 - 带关键词")
void testSearchUsers_WithKeyword() {
    // Arrange
    SearchUsersRequest request = new SearchUsersRequest()
        .setKeyword("test");

    Page<CustomerEntity> page = new PageImpl<>(entities);
    when(customerRepository.searchUsers("test", null, pageRequest)).thenReturn(page);

    // Act
    userService.searchUsers(pageableBuilder, request, pageRequest);

    // Assert
    verify(pageableBuilder).setData(any());
    verify(pageableBuilder).setTotalCount(2L);
}
```

---

## 📝 待完善功能

### 高优先级
- [ ] 密码强度验证
- [ ] 邮箱验证流程
- [ ] 手机号验证
- [ ] 用户头像上传

### 中优先级
- [ ] 批量导入用户
- [ ] 批量导出用户
- [ ] 用户角色关联
- [ ] 用户部门关联

### 低优先级
- [ ] 用户登录日志
- [ ] 用户在线状态
- [ ] 用户会话管理

---

## 🔗 相关文件

- **Proto 定义：** `rad-app/src/main/proto/com/apihug/rad/api/customer/api.proto`
- **Domain 定义：** `rad-app/src/main/proto/com/apihug/rad/domain/customer/domain.proto`
- **Service 实现：** `rad-app/src/main/java/com/apihug/rad/api/customer/UserServiceImpl.java`
- **Repository Trait：** `rad-app/src/main/trait/t/com/apihug/rad/domain/customer/repository/_CustomerEntityRepository.java`
- **测试代码：** `rad-app/src/test/java/com/apihug/rad/api/customer/UserServiceImplTest.java`

---

**文档更新日期：** 2026-03-20
