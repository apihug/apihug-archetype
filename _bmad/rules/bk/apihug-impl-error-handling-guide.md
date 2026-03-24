---
name: apihug-impl-error-handling-guide
description: >
  Authoritative guide for structured error handling in ApiHug services.
  Covers the mandatory Error-First principle: define errors in proto,
  wire generates typed error enums, throw HopeErrorDetailException in business logic,
  and use builder.error() in service methods.
  Forbids raw exceptions, ad-hoc error codes, and validation bypasses.
version: 1.0.1
author: APIHug Team / H.O.P.E. Infrastructure
created: 2026-03-09
updated: 2026-03-09
tags: [apihug, error-handling, exception, HopeErrorDetailException, proto-error]
purpose: Enforce structured, traceable error handling — all errors from proto-defined enums.
scope: All backend ServiceImpl, DomainService, and Repository layers.
---

# Error Handling Guide

## Package Reference

| Simple Name                | Fully Qualified Class                                     |
|----------------------------|-----------------------------------------------------------|
| `HopeErrorDetailException` | `hope.common.api.exceptions.HopeErrorDetailException`     |
| `Error`                    | `hope.common.api.error.Error`                             |
| `Phase`                    | `hope.common.api.error.Phase`                             |
| `Severity`                 | `hope.common.api.error.Severity`                          |
| `SimpleResultBuilder`      | `hope.common.spring.SimpleResultBuilder`                  |
| `HopeExceptionHandler`     | `hope.common.spring.problem.servlet.HopeExceptionHandler` |
| Generated error enums      | `{package}.wire.errors.{Module}ErrorEnum`                 |

---

## Core Principle: Error-First, Proto-Driven

**Every error that escapes a service method MUST carry:**
- A typed, proto-defined error enum value (with `code`, `title`, `http_status`, `phase`, `severity`)
- Wrapped in `HopeErrorDetailException` OR returned via `builder.error()`

**NEVER throw raw exceptions, construct anonymous `Error` objects with ad-hoc codes, or bypass proto validation.**

> `HopeErrorDetailException` is a `RuntimeException` — no need to declare or catch at every layer. Global `HopeExceptionHandler` (`@ControllerAdvice`) intercepts it automatically.

---

## 1. Error Definition (Proto — MANDATORY First Step)

> Full proto error enum syntax: see `apihug-proto-enum-error-extension-guide`.

```proto
syntax = "proto3";
package com.example.order.infra.order;

enum OrderErrorEnum {
  ORDER_NOT_FOUND = 0 [(hope.constant.field) = {
    code: 20001,
    message: "order not found",
    message2: "订单不存在",
    error: {
      title: "Order Not Found",
      http_status: NOT_FOUND,
      phase: SERVICE,
      severity: ERROR
    }
  }];

  ORDER_ALREADY_CANCELLED = 1 [(hope.constant.field) = {
    code: 20002,
    message: "order already cancelled",
    error: { title: "Order Already Cancelled", http_status: CONFLICT, phase: SERVICE, severity: WARN }
  }];
}
```

**After `gradlew :{module}:wire`:**
```java
// AUTO-GENERATED — implements hope.common.api.error.Error
public enum OrderErrorEnum implements Error {
    ORDER_NOT_FOUND(20001, "order not found", HttpStatus.NOT_FOUND, Phase.SERVICE, Severity.ERROR),
    ORDER_ALREADY_CANCELLED(20002, "order already cancelled", HttpStatus.CONFLICT, Phase.SERVICE, Severity.WARN);
}
```

---

## 2. Throwing Errors in Business Logic

### 2.1 DomainService — Always Throw `HopeErrorDetailException`

Domain/infrastructure layers have no access to response builder — MUST throw exception.

```java
public Order cancelOrder(Long orderId) {
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() ->
            HopeErrorDetailException.errorBuilder(OrderErrorEnum.ORDER_NOT_FOUND)
                .setMessage("Order not found: " + orderId)
                .build()
        );

    if (order.isCancelled()) {
        throw HopeErrorDetailException.errorBuilder(OrderErrorEnum.ORDER_ALREADY_CANCELLED).build();
    }
    order.cancel();
    return orderRepository.save(order);
}
```

### 2.2 ServiceImpl — Three Valid Patterns

**Pattern A (PREFERRED): Let exception propagate — no try-catch needed**

```java
@Override
public void cancelOrder(SimpleResultBuilder<Void> builder, Long orderId) {
    orderDomainService.cancelOrder(orderId);  // throws HopeErrorDetailException if error
    builder.ok("Order cancelled");
    // HopeExceptionHandler intercepts automatically
}
```

**Pattern B: Catch only when adding context or translating error**

```java
@Override
public void cancelOrder(SimpleResultBuilder<Void> builder, Long orderId) {
    try {
        orderDomainService.cancelOrder(orderId);
        builder.ok("Order cancelled");
    } catch (HopeErrorDetailException e) {
        builder.badRequest().errors(e.getErrors());  // forward to builder
    }
}
```

**Pattern C: Use builder directly for simple checks**

```java
@Override
public void getOrder(SimpleResultBuilder<OrderDetail> builder, Long orderId) {
    Order order = orderRepository.findById(orderId).orElse(null);
    if (order == null) {
        builder.notFound().error(OrderErrorEnum.ORDER_NOT_FOUND);
        return;
    }
    builder.payload(orderMapper.toDetail(order));
}
```

### 2.3 Repository/Infrastructure — Throw `HopeErrorDetailException`

```java
public Order requireById(Long id) {
    return findById(id).orElseThrow(() ->
        HopeErrorDetailException.errorBuilder(OrderErrorEnum.ORDER_NOT_FOUND)
            .setMessage("Order ID: " + id)
            .build()
    );
}
```

---

## 3. `HopeErrorDetailException` API

### Factory Methods

| Method                                      | Usage                                   |
|---------------------------------------------|-----------------------------------------|
| `errorBuilder(ErrorEnum)`                   | Start with proto error **(PREFERRED)**  |
| `errorBuilder()`                            | Empty builder (add errors manually)     |
| `errorBuilder(message, ErrorEnum)`          | Message + proto error                   |
| `noImplement()`                             | Not-yet-implemented features            |

### Builder Chain

```java
HopeErrorDetailException.errorBuilder(OrderErrorEnum.ORDER_NOT_FOUND)
    .setMessage("Human-readable message for logs")   // optional
    .setCause(originalException)                       // optional
    .build();
```

> **Prefer enum-based factory over manual `ErrorBuilder`** — manual construction loses proto metadata traceability.

---

## 4. `builder.error()` in ServiceImpl

```java
builder.notFound().error(OrderErrorEnum.ORDER_NOT_FOUND);
builder.badRequest().error(OrderErrorEnum.ORDER_PAYMENT_FAILED);
builder.conflict().error(OrderErrorEnum.ORDER_ALREADY_CANCELLED);
```

> HTTP status helper (`.notFound()`, `.badRequest()`) sets transport status. `.error(ErrorEnum)` encodes structured payload.

---

## 5. Validation Errors — Framework Responsibility

**Input validation is handled automatically — DO NOT write manual validation in ServiceImpl.**

| Validation Type                  | Handler                                   | Developer Action                 |
|----------------------------------|-------------------------------------------|----------------------------------|
| Proto field constraints          | Framework auto-validates before ServiceImpl | Define constraints in proto      |
| Missing required fields          | Framework returns 400                     | None                             |
| Custom business rule validation  | DomainService / ServiceImpl               | Throw `HopeErrorDetailException` |

```proto
// ✅ Define validation in proto — framework enforces
message CreateOrderRequest {
  string product_id = 1 [(hope.swagger.field) = { required: true }];
  int32 quantity = 2 [(hope.swagger.field) = { minimum: 1, maximum: 9999 }];
}
```

**FORBIDDEN:**
```java
// ❌ Do NOT manually validate proto-constrained fields
if (request.getProductId() == null) {
    builder.badRequest().message("Product ID required");
    return;
}
```

---

## 6. Forbidden Patterns

```java
// ❌ Raw RuntimeException with string message
throw new RuntimeException("Order not found");

// ❌ Ad-hoc Error object with hardcoded codes
Error error = new Error().setCode(404).setDescription("not found");
builder.badRequest().error(error);

// ❌ Catching and swallowing HopeErrorDetailException
try { domainService.process(); } 
catch (HopeErrorDetailException e) { logger.error("error", e); }  // structured errors lost

// ❌ Wrapping in another RuntimeException
throw new RuntimeException("wrapped", hopeException);  // loses all metadata

// ❌ Unnecessary try-catch that just re-throws
try { domainService.process(); } catch (HopeErrorDetailException e) { throw e; }  // pointless

// ❌ Manual input validation for proto-defined constraints
if (request.getName() == null) { builder.badRequest().message("Name required"); return; }
```

---

## 7. Error Code Namespace Convention

**Error codes MUST be unique within the domain module.**

```proto
// ✅ CORRECT — unique codes across enums in same domain
enum UserErrorEnum {
  USER_NOT_FOUND      = 0 [(hope.constant.field) = {code: 1001, ...}];
  USER_ALREADY_EXISTS = 1 [(hope.constant.field) = {code: 1002, ...}];
}

enum OrderErrorEnum {
  ORDER_NOT_FOUND = 0 [(hope.constant.field) = {code: 2001, ...}];  // different range
}

// ❌ WRONG — duplicate codes across enums
enum PaymentErrorEnum {
  PAYMENT_FAILED = 0 [(hope.constant.field) = {code: 1001, ...}];  // collides with UserErrorEnum
}
```

---

## 8. Quick Reference

| Scenario                                 | Pattern                                                       |
|------------------------------------------|---------------------------------------------------------------|
| Entity not found in DomainService        | `throw HopeErrorDetailException.errorBuilder(ENUM).build()`   |
| Business rule violation in DomainService | `throw HopeErrorDetailException.errorBuilder(ENUM).build()`   |
| Not found check in ServiceImpl           | `builder.notFound().error(ENUM)`                              |
| Forward DomainService error to builder   | `catch(HopeErrorDetailException e) { builder.errors(e.getErrors()); }` |
| Input validation                         | Define in proto — framework handles                           |
| Unexpected system error                  | Let propagate — `HopeExceptionHandler` catches all `Throwable` |
