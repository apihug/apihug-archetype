# 客户管理模块详细文档

**模块路径：** `com.apihug.rad.api.customer`  
**主要 Service：** `CustomerManagementServiceImpl`  
**Proto 文件：** `api/customer/api.proto`  
**实体文件：** `domain/customer/domain.proto`  

---

## 📋 功能概述

客户管理模块提供完整的客户 CRUD 操作和搜索功能：

- ✅ 创建客户
- ✅ 查询客户详情
- ✅ 更新客户信息
- ✅ 删除客户（软删除）
- ✅ 搜索客户（分页）

---

## 🏗️ 架构设计

### 组件关系

```
┌─────────────────────────────────────────────────────────┐
│                    Controller (Generated)                │
├─────────────────────────────────────────────────────────┤
│              CustomerManagementServiceImpl               │
│  ┌─────────────────────────────────────────────────┐    │
│  │ - createCustomer()                              │    │
│  │ - getCustomer()                                 │    │
│  │ - updateCustomer()                              │    │
│  │ - deleteCustomer()                              │    │
│  │ - searchCustomers()                             │    │
│  └─────────────────────────────────────────────────┘    │
│                     ↓                                    │
│  ┌─────────────────────────────────────────────────┐    │
│  │         _CustomerEntityRepository (Trait)       │    │
│  │  - findByUsername()                             │    │
│  │  - findByEmail()                                │    │
│  │  - searchCustomers()                            │    │
│  └─────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────┘
```

---

## 🔧 核心功能实现

### 1. 创建客户

**API:** `POST /api/customers/customers`

**实现要点：**
- 验证用户名唯一性
- 验证邮箱唯一性
- 密码加密存储
- 设置默认状态

**代码示例：**

```java
@Override
public void createCustomer(SimpleResultBuilder<CustomerSummary> builder,
    CreateCustomerRequest createRequest) {
  
  // 1. 验证用户名唯一性
  if (customerRepository.existsByUsername(createRequest.getUsername())) {
    throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_ALREADY_EXISTS).build();
  }

  // 2. 验证邮箱唯一性
  if (customerRepository.existsByEmail(createRequest.getEmail())) {
    throw HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_ALREADY_EXISTS).build();
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
  CustomerSummary summary = new CustomerSummary()
      .setId(saved.getId())
      .setUsername(saved.getUsername())
      .setStatus(saved.getStatus());

  builder.payload(summary);
}
```

---

### 2. 搜索客户（分页）

**API:** `POST /api/customers/customers/search`

**Proto 定义：**

```proto
rpc SearchCustomers (SearchCustomersRequest) returns (CustomerSummary) {
  option (hope.swagger.operation) = {
    post: "/customers/search";
    pageable: true;
    authorization: {
      rbac: {
        authorities: ["CUSTOMER_VIEW"];
      }
    };
  };
}

message SearchCustomersRequest {
  string keyword = 1;
  CustomerStatusEnum status = 2;
}
```

**Repository Trait 实现：**

```java
interface _CustomerEntityRepository extends CustomerEntityRepository {
  
  default Page<CustomerEntity> searchCustomers(
      String keyword, 
      CustomerStatusEnum status, 
      PageRequest pageRequest) {
    
    Criteria criteria = EasyCriteria.eq(_Deletable_.DELETED, false);

    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.Username, "%" + keyword + "%")
              .or(EasyCriteria.like(Domain.Email, "%" + keyword + "%")));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return findAll(criteria, this.page(pageRequest));
  }
}
```

**ServiceImpl 实现：**

```java
@Override
public void searchCustomers(PageableResultBuilder<CustomerSummary> builder,
    SearchCustomersRequest request, PageRequest pageParameter) {
  
  Page<CustomerEntity> page = customerRepository.searchCustomers(
      request.getKeyword(),
      request.getStatus(),
      pageParameter
  );

  builder.setPageIndex(pageParameter.getPage())
         .setPageSize(pageParameter.getSize())
         .setTotalCount(page.getTotalElements())
         .setTotalPage(page.getTotalPages())
         .setData(page.getContent().stream()
             .map(this::buildCustomerSummary)
             .collect(Collectors.toList()));
}
```

---

### 3. 删除客户（软删除）

**API:** `DELETE /api/customers/customers/{customerId}`

**实现要点：**
- 软删除（设置 deleted = true）
- 记录删除时间和删除人
- 检查是否有子数据

**代码示例：**

```java
@Override
public void deleteCustomer(SimpleResultBuilder<String> builder,
    Integer customerId) {
  
  CustomerEntity entity = customerRepository.findById(customerId.longValue())
      .orElseThrow(() -> HopeErrorDetailException.errorBuilder(CustomerErrorEnum.CUSTOMER_NOT_FOUND).build());

  entity.setDeleted(true)
      .setDeletedAt(LocalDateTime.now())
      .setDeletedBy(HopeContextHolder.customer().getId());

  customerRepository.save(entity);
  
  builder.done();
}
```

---

## 📊 数据库表结构

### SYS_CUSTOMER (客户表)

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
CREATE UNIQUE INDEX UK_SYS_CUSTOMER_USERNAME ON SYS_CUSTOMER(USERNAME);
CREATE UNIQUE INDEX UK_SYS_CUSTOMER_EMAIL ON SYS_CUSTOMER(EMAIL);
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
| `CustomerManagementServiceImplTest` | 11 | CRUD、搜索、异常处理 |

---

## 📝 待完善功能

### 高优先级
- [ ] 密码强度验证
- [ ] 邮箱验证流程
- [ ] 手机号验证
- [ ] 客户头像上传

### 中优先级
- [ ] 批量导入客户
- [ ] 批量导出客户
- [ ] 客户租户关联

### 低优先级
- [ ] 客户登录日志
- [ ] 客户在线状态
- [ ] 客户会话管理

---

## 🔗 相关文件

- **Proto 定义：** `rad-app/src/main/proto/com/apihug/rad/api/customer/api.proto`
- **Domain 定义：** `rad-app/src/main/proto/com/apihug/rad/domain/customer/domain.proto`
- **Service 实现：** `rad-app/src/main/java/com/apihug/rad/api/customer/CustomerManagementServiceImpl.java`
- **Repository Trait：** `rad-app/src/main/trait/t/com/apihug/rad/domain/customer/repository/_CustomerEntityRepository.java`
- **测试代码：** `rad-app/src/test/java/com/apihug/rad/api/customer/CustomerManagementServiceImplTest.java`

---

**文档更新日期：** 2026-03-24
