---
name: apihug-impl-security-rbac-guide
description: >
  Core security components for RBAC implementation using ApiHug security framework.
  Covers Customer identity, JWT lifecycle, role checking, and framework-enforced access control.
author: H.O.P.E. Infra Team
tags: [security, rbac, jwt, authentication, authorization]
---

# ApiHug Security Infrastructure

> **CRITICAL**: RBAC is 100% FRAMEWORK-CONTROLLED.
> - Permissions defined in proto → AOP enforced at runtime
> - ZERO RBAC code allowed in ServiceImpl/DomainService/Repository
> - Violation = Architecture breach

## Location

```
src/main/java/{package}/infra/security/
├── {Domain}Customer.java                      # User identity entity
├── Anonymous{Domain}Customer.java             # Anonymous user singleton
├── {Domain}QuickCustomerRoleChecker.java      # Built-in role checker
├── {Domain}JwtCustomizer.java                 # JWT lifecycle
└── {Domain}SecurityCustomizer.java            # Global access configurator
```

---

## Components

### {Domain}Customer

User identity entity carrying authenticated user information.

| Attribute   | Type                 | Description              |
|-------------|----------------------|--------------------------|
| ID          | Long                 | Unique user identifier   |
| TenantId    | Long                 | Tenant (multi-tenant)    |
| Account     | String               | Login name               |
| Name        | String               | Display name             |
| Active      | boolean              | Account activation       |
| Authorities | Collection\<String\> | Fine-grained permissions |
| Roles       | Collection\<String\> | Role groups              |

**RBAC Model**: `User → Roles → Authorities`

### Anonymous{Domain}Customer

Singleton for unauthenticated visitors — immutable, all role checks return `false`.

### {Domain}QuickCustomerRoleChecker

Quick validation for built-in roles.

| Category     | Methods                                                    |
|--------------|------------------------------------------------------------|
| Platform     | `isPlatform()`, `isPlatformManager()`, `isPlatformOwner()` |
| Organization | `isOrigination()`, `isOriginationManager()`, `isOriginationOwner()` |

**Hierarchy**: `Owner > Manager > Member`

Api quick validation roles from proto `authorization.rbac.predefined_role_checker` — no manual implementation required:

```protobuf
authorization: {
    rbac:{
      predefined_role_checker: PLATFORM|PLATFORM_MANAGER...
    }
  }
```

### {Domain}JwtCustomizer

JWT token lifecycle manager.

| Method         | Purpose                        |
|----------------|--------------------------------|
| `create()`     | Create blank user instance     |
| `anonymous()`  | Return anonymous user singleton|
| `tokenize()`   | Inject custom claims (JWT gen) |
| `tokenParse()` | Restore claims (JWT parse)     |

### {Domain}SecurityCustomizer

Global access control configuration.

| Policy   | Behavior                | Use Case          |
|----------|-------------------------|-------------------|
| `PASS`   | Anonymous access        | Public APIs       |
| `LOGIN`  | Requires authentication | Business endpoints|
| `ACTIVE` | Requires active account | Sensitive ops     |
| `DENY`   | Block access            | Default deny      |

> For most APIs, RBAC is configured via proto definitions. This handles edge cases.

---

## ⚠️ ABSOLUTE PROHIBITION — RBAC IN IMPLEMENTATION CODE

### The Rule (ZERO TOLERANCE)

```
┌─────────────────────────────────────────────────────────────────────────┐
│  RBAC PERMISSION = PROTO DEFINITION → FRAMEWORK AOP → AUTO ENFORCED    │
│                                                                         │
│  IMPLEMENTATION CODE (ServiceImpl/DomainService/Repository)             │
│  ┌─────────────────────────────────────────────────────────────────┐   │
│  │  ❌ NO permission checks    ❌ NO role validation               │   │
│  │  ❌ NO security guards      ❌ NO access control logic          │   │
│  │  ❌ NO @PreAuthorize        ❌ NO hasRole/hasAuthority calls    │   │
│  │  ❌ NO manual RBAC          ❌ NO security annotations          │   │
│  └─────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────┘
```

### How RBAC Works (Framework-Driven)

```
Proto Definition                    Runtime Enforcement
─────────────────                  ─────────────────────
authorization: {                   HopeSecurityManager (AOP)
  rbac: {                              ↓
    roles: ["ADMIN"]              ┌─────────────────────┐
    authorities: ["USER_DELETE"]  │ Intercept request   │
  }                               │ Check proto metadata│
}                                 │ Allow or Deny       │
                                  └─────────────────────┘
                                         ↓
                                   Controller (no RBAC code)
                                         ↓
                                   ServiceImpl (no RBAC code)
```

### FORBIDDEN Patterns (NEVER WRITE)

```java
// ❌ ABSOLUTELY FORBIDDEN in ServiceImpl/DomainService/Repository

// ❌ Spring Security annotations
@PreAuthorize("hasRole('ADMIN')")
@Secured("ROLE_ADMIN")
@RolesAllowed("ADMIN")

// ❌ Manual role/permission checks
if (!customer.getRoles().contains("ADMIN")) {
    throw new AccessDeniedException("Admin required");
}

// ❌ Security context validation
if (customer == null || !customer.isActive()) {
    throw new UnauthorizedException();
}

// ❌ Permission guards
if (!customer.getAuthorities().contains("USER_DELETE")) {
    throw new ForbiddenException("No delete permission");
}

// ❌ Role-based business logic branching
if (customer.isPlatformManager()) {
    // manager logic
} else {
    // member logic
}

// ❌ Any security-related conditional logic
if (SecurityContextHolder.getContext().getAuthentication() != null) { ... }
```

### CORRECT Approach

```java
// ✅ CORRECT — Zero RBAC code in implementation

@Service
public class UserServiceImpl implements UserService {
    
    // NO security annotations
    // NO role checks
    // NO permission validation
    // Just pure business logic
    
    @Override
    public void deleteUser(Long userId) {
        // Framework already validated RBAC via proto definition
        // Just do the business operation
        userRepo.deleteById(userId);
    }
}
```

```proto
// ✅ RBAC defined in proto — framework handles enforcement
rpc DeleteUser (google.protobuf.Empty) returns (google.protobuf.Empty) {
  option (hope.swagger.operation) = {
    delete: "/users/{id}";
    authorization: {
      rbac: {
        roles: { roles: ["ROLE_ADMIN"] };
        authorities: ["USER_DELETE"];
        combinator: AND;
      }
    }
  };
}
```

---

## Framework Responsibility

**Authentication and Authorization are ENTIRELY handled by ApiHug framework.**

- `JWTFilter` parses token, populates security context on every request
- `HopeSecurityManager` enforces RBAC at controller level via AOP (proto-driven)
- **ServiceImpl / DomainService MUST NOT contain any auth logic**

**FORBIDDEN:**
- Do NOT activate Spring Security in Spring context
- Do NOT write JWT generation, parsing, signing, or validation manually
- Do NOT add security checks, role guards, or permission validation in ServiceImpl/DomainService
- Do NOT modify generated security code under `src/generated/`

---

## Accessing Current User

```java
import hope.common.spring.security.context.HopeContextHolder;

// ONLY approved way — do NOT pass user via method parameters
{Domain}Customer customer = ({Domain}Customer) HopeContextHolder.customer();
//Customer may be null or anonymous 
Long currentUserId = customer.getId();
Long tenantId      = customer.getTenantId();
```

---

## Architecture

```
HTTP Request → JWTFilter (tokenParse) → SecurityCustomizer (policy) 
            → HopeSecurityManager (RBAC AOP) → Controller → Business Logic
```

1. **JWTFilter** parses token via `JwtCustomizer.decode()`
2. **SecurityCustomizer** applies global access policies
3. **HopeSecurityManager** validates RBAC via proto-defined metadata

---

## Usage

### Token Customization

```java
@Override
public void tokenize(JwtBuilder jwtBuilder, Customer customer) {
    jwtBuilder.claim("departmentId", customer.getDepartmentId());
}

@Override
public Customer tokenParse(Customer customer, Claims claims) {
    customer.setDepartmentId(claims.get("departmentId", Long.class));
    //Or other dynamic pick customer properties like authorities list
    return customer;
}
```

### Extending Role Detection

```java
@Override
public boolean isPlatformManager(Customer customer) {
    return customer.hasAnyRoles(List.of("PLATFORM_ADMIN", "PLATFORM_MANAGER"));
}
```
