---
name: apihug-impl-result-pageable-guide
description: >
  Result and Pageable response structures in APIHug.
  Covers builders, PageRequest, and proto contract rules for pageable/output_repeated.
version: 1.0.4
author: APIHug Team / H.O.P.E. Infrastructure
created: 2026-02-28
updated: 2026-03-09
tags: [apihug, result, pageable, pagination, response-builder]
purpose: Enforce consistent API response patterns.
scope: All controller endpoints and service methods returning JSON.
---

# Result & Pageable Usage Guide

## Package Reference

| Class | FQN |
|-------|-----|
| `Result<T>` | `hope.common.api.Result` |
| `Pageable<T>` | `hope.common.api.Pageable` |
| `PageRequest` | `hope.common.api.PageRequest` |
| `SimpleResultBuilder` | `hope.common.api.builder.SimpleResultBuilder` |
| `PageableResultBuilder` | `hope.common.api.builder.PageableResultBuilder` |

---

## 1. Core Data Structures

### 1.1 `Result<T>` – Unified API Response

| Field | Type | Description |
|-------|------|-------------|
| `code` | `int` | `0` = success, non‑zero = failure |
| `message` | `String` | Human‑readable message |
| `data` | `T` | Payload (generic) |
| `errors` | `List<Error>` | Detailed error list (optional) |

### 1.2 `Pageable<T>` – Paginated Result

| Field | Type | Description |
|-------|------|-------------|
| `pageIndex` | `int` | Current page **⚠️ 0‑based** |
| `pageSize` | `int` | Items per page |
| `totalCount` | `long` | Total records |
| `totalPage` | `int` | Total pages |
| `data` | `List<T>` | Items for current page |

### 1.3 `PageRequest` – Pagination Parameters

| Field | Type | Description | Constraints |
|-------|------|-------------|-------------|
| `page` | `Integer` | Page **⚠️ 0‑based** | Min 0 |
| `size` | `Integer` | Items per page | Min 1, Max 1024 |
| `sort` | `List<String>` | Sort: `"field,direction"` | Optional |

> **Critical:** All page indexes are **0‑based** (aligns with Spring Data).

---

## 2. Proto Contract Rules — CRITICAL

> **⚠️ ZERO TOLERANCE**: Violating these rules will cause runtime errors or double-wrapping bugs.

### Quick Decision Table

| Scenario | Proto Setting | Request | Response |
|----------|---------------|---------|----------|
| Large dataset, paging | `pageable: true` | Query fields only | Single item type |
| Small list, no paging | `output_repeated: true` | Normal | Single item type |
| Batch input | `input_repeated: true` | Single item type | Normal |
| Batch I/O | Both `input/output_repeated` | Single item type | Single item type |

### 2.1 Paginated RPC (`pageable: true`)

| Proto element         | Rule                                                                      |
|-----------------------|---------------------------------------------------------------------------|
| **Request Message**   | Contains **query/filter fields only** — NEVER `page`, `size`, or `sort`   |
| **Response type**     | Single item type (e.g. `UserSummary`) — NOT a list or pageable wrapper    |
| **Pagination params** | Injected automatically by framework when `pageable: true`                 |
| **Pageable wrapper**  | `Result<Pageable<T>>` assembled automatically                             |

```proto
// ✅ CORRECT
rpc SearchUsers (SearchUsersRequest) returns (UserSummary) {
  option (hope.swagger.operation) = {
    get: "/users";
    pageable: true;   // framework injects page/size/sort
  };
}

message SearchUsersRequest {
  string keyword = 1;
  int32  status  = 2;
  // ❌ NEVER add page/size/sort here
}

// ❌ WRONG — wrapping response yourself
rpc SearchUsers (SearchUsersRequest) returns (PageableUserSummary);  // ❌ double-wrapping
```

**Generated ServiceImpl signature:**
```java
void searchUsers(PageableResultBuilder<UserSummary> builder, 
                 SearchUsersRequest request, 
                 PageRequest pageParameter);
```

### 2.2 List Output (`output_repeated: true`)

For simple list responses **without pagination**, use `output_repeated: true`.

| Proto element     | Rule                                               |
|-------------------|----------------------------------------------------|
| **Response type** | Single item type — NOT a list wrapper              |
| **List wrapper**  | `Result<List<T>>` assembled automatically          |
| **Use case**      | Small datasets, dropdowns, reference data          |

```proto
// ✅ CORRECT
rpc ListRoles (ListRolesRequest) returns (RoleSummary) {
  option (hope.swagger.operation) = {
    get: "/roles";
    output_repeated: true;  // framework wraps in Result<List<RoleSummary>>
  };
}

// ❌ WRONG
rpc ListRoles (ListRolesRequest) returns (RoleSummaryList);  // ❌ unnecessary wrapper
```

**Generated ServiceImpl signature:**
```java
void listRoles(SimpleResultBuilder<List<RoleSummary>> builder, ListRolesRequest request);
```

### 2.3 List Input (`input_repeated: true`)

For batch operations accepting **a list of items as input**, use `input_repeated: true`. The framework unwraps the request into `List<T>` — clean and intuitive.

| Proto element     | Rule                                               |
|-------------------|----------------------------------------------------|
| **Request type**  | Single item type — NOT a list wrapper              |
| **List input**    | `List<T>` injected automatically by framework      |
| **Use case**      | Batch create, batch update, bulk operations        |

```proto
// ✅ CORRECT
rpc BatchCreateUsers (CreateUserRequest) returns (UserSummary) {
  option (hope.swagger.operation) = {
    post: "/users/batch";
    input_repeated: true;   // framework unwraps request body into List<CreateUserRequest>
    output_repeated: true;  // returns List<UserSummary>
  };
}

message CreateUserRequest {
  string username = 1;
  string email = 2;
}

// ❌ WRONG
rpc BatchCreateUsers (BatchCreateUsersRequest) returns (UserSummaryList);  // ❌ unnecessary wrappers
```

**Generated ServiceImpl signature:**
```java
void batchCreateUsers(SimpleResultBuilder<List<UserSummary>> builder, 
                      List<CreateUserRequest> requests);  // List<T> injected
```

---

## 3. Service Implementation Patterns

### 3.1 SimpleResultBuilder

```java
@Override
public void getUser(SimpleResultBuilder<UserDetail> builder, Long id) {
    User user = userRepository.findById(id).orElse(null);
    if (user == null) {
        builder.notFound().error(UserErrorEnum.USER_NOT_FOUND);
        return;
    }
    builder.payload(userMapper.toDetail(user));
    // NEVER call done() — controller handles it
}
```

**HTTP status helpers:**
```java
builder.notFound().error(UserErrorEnum.USER_NOT_FOUND);
builder.badRequest().error(OrderErrorEnum.ORDER_PAYMENT_FAILED);
builder.conflict().error(OrderErrorEnum.ORDER_ALREADY_CANCELLED);
```

### 3.2 PageableResultBuilder

```java
@Override
public void searchUsers(PageableResultBuilder<UserSummary> builder,
                         QueryUsersRequest request,
                         PageRequest pageParameter) {
    Page<User> page = userRepository.findAll(
        buildCriteria(request),
        org.springframework.data.domain.PageRequest.of(
            pageParameter.getPage(), pageParameter.getSize()
        )
    );

    builder.setPageIndex(pageParameter.getPage())
           .setPageSize(pageParameter.getSize())
           .setTotalCount(page.getTotalElements())
           .setTotalPage(page.getTotalPages())
           .setData(page.getContent());
    // NEVER call done()
}
```

---

## 4. PageRequest Utilities

```java
PageRequest.empty();                    // default: page=0, size=20
PageRequest.immutableOf(0, 50);         // immutable instance
new PageRequest().setPage(0).setSize(20).setSort(List.of("createTime,desc"));
```

> `PageRequest` is guarded by `PageRequestGuardian` in generated controllers.

---

## 5. JSON Response Examples

**Success:** `{ "code": 0, "message": "OK", "data": { "id": 1, "name": "John" } }`

**Error:** `{ "code": 400, "message": "Validation failed", "errors": [...] }`

**Paginated:**
```json
{ "code": 0, "data": { "pageIndex": 0, "pageSize": 20, "totalCount": 100, "totalPage": 5, "data": [...] } }
```

---

## 6. Best Practices

### ⚠️ FORBIDDEN Patterns (ZERO TOLERANCE)

```
┌─────────────────────────────────────────────────────────────────────────────┐
│  PAGEABLE API — ABSOLUTELY FORBIDDEN                                        │
├─────────────────────────────────────────────────────────────────────────────┤
│  ❌ message SearchRequest { int32 page = 1; int32 size = 2; }              │
│  ❌ rpc Search (...) returns (PageableUserSummary);                        │
│  ❌ rpc Search (...) returns (UserSummaryList);                            │
│  ❌ builder.done() in service implementation                               │
└─────────────────────────────────────────────────────────────────────────────┘
```

| # | Rule | Why |
|---|------|-----|
| 1 | **NEVER call `done()`** | Generated controller handles it |
| 2 | **NEVER add `page/size/sort`** to Request Message | Framework injects via `pageable: true` |
| 3 | **NEVER wrap response** in list/pageable type | Framework wraps `Result<Pageable<T>>` |
| 4 | **NEVER return `null`** for `Pageable.data` | Return empty list instead |

### ✅ Correct Patterns

| # | Practice | Example |
|---|----------|---------|
| 1 | **Chain builder methods** | `.payload(x).message(y)` |
| 2 | **Sort format** | `"createTime,desc"` |
| 3 | **Page index** | 0‑based (aligns with Spring Data) |
