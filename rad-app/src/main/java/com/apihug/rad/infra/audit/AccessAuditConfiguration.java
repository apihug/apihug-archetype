package com.apihug.rad.infra.audit;

import com.apihug.rad.domain.audit.AccessLogEntity;
import com.apihug.rad.domain.audit.repository.AccessLogEntityRepository;
import com.apihug.rad.infra.security.RadCustomer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hope.common.api.Result;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Template;
import hope.common.runtime.RuntimeContext;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectType;
import hope.common.spring.security.Customer;
import hope.common.spring.security.context.HopeContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Template(type = Template.Type.SERVICE, usage = "Audit aspect service")
@Configuration(proxyBeanMethods = false)
public class AccessAuditConfiguration {

  /** Sensitive parameter key patterns - values will be masked */
  private static final Set<String> SENSITIVE_KEYS =
      Set.of(
          "password",
          "secret",
          "token",
          "key",
          "hash",
          "credential",
          "authorization",
          "apikey",
          "api_key");

  private static final Logger log = LoggerFactory.getLogger(AccessAuditConfiguration.class);
  final AccessLogEntityRepository repository;
  final ObjectMapper mapper;
  final Object LOCK = new Object();
  Map<String, ServiceMethod> path2Methods = new HashMap<>();

  public AccessAuditConfiguration(AccessLogEntityRepository repository, ObjectMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  /**
   * Asynchronously save access log. Snapshot all context on the calling thread, then persist in a
   * separate thread to avoid blocking the main request.
   */
  private void asyncSaveAccessLog(
      ServiceMethodContext method,
      Map<String, Object> ctx,
      int httpStatus,
      Long startTime,
      String channel,
      String errorCode,
      String errorMessage) {

    long endTime = System.currentTimeMillis();
    long duration = startTime != null ? endTime - startTime : 0;
    // TODO finish your logic

    // 2. User context (must read on current thread before async)
    Long userId = null;
    Long tenantId = null;
    try {
      Customer customer = HopeContextHolder.getContext();
      if (customer != null && !customer.isAnonymous()) {
        if (customer instanceof RadCustomer hc) {
          userId = hc.getId();
          tenantId = hc.getTenantId();
        }
      }
    } catch (Exception e) {
      // Anonymous or context unavailable
    }

    // 3. HTTP request context
    String ipAddress = null;
    String userAgent = null;
    try {
      ServletRequestAttributes attrs =
          (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      if (attrs != null) {
        HttpServletRequest request = attrs.getRequest();
        ipAddress = getClientIp(request);
        userAgent = request.getHeader("User-Agent");
        if (userAgent != null && userAgent.length() > 500) {
          userAgent = userAgent.substring(0, 500);
        }
      }
    } catch (Throwable e) {
      // Request context unavailable
    }

    // 4. Request params (desensitized)
    String requestParams = sanitizeParams(ctx);

    // 1. Service/Method from framework context
    String serviceName = method.service();
    String methodName = method.method();
    String path = method.path();

    // ===== Build entity with snapshots =====
    final AccessLogEntity accessLog = new AccessLogEntity();
    accessLog.setHttpMethod(method.httpMethod().name());
    accessLog.setPriority(method.priority().name());
    accessLog.setRequestPath(path != null ? path : "");
    accessLog.setRequestParams(requestParams);
    accessLog.setResponseStatus(httpStatus);
    accessLog.setStartEpochTs(startTime);
    accessLog.setDurationMs(duration);
    accessLog.setCustomerId(userId);
    accessLog.setIpAddress(ipAddress);
    accessLog.setUserAgent(userAgent);
    accessLog.setServiceName(serviceName);
    accessLog.setMethodName(methodName);
    accessLog.setChannel(channel);
    accessLog.setErrorCode(errorCode);
    accessLog.setErrorMessage(errorMessage);
    accessLog.setTenantId(tenantId == null ? 0L : tenantId);
    // Pre-populate audit fields on current thread so _save() won't need auditContext() in async
    // thread
    accessLog.setCreatedAt(java.time.LocalDateTime.now());
    accessLog.setCreatedBy(userId == null ? 0L : userId);

    CompletableFuture.runAsync(
        () -> {
          try {
            repository.save(accessLog);
          } catch (Throwable e) {
            log.warn(
                "Failed to save access log: {} {} - {}",
                accessLog.getHttpMethod(),
                accessLog.getRequestPath(),
                e.getMessage(),
                e);
          }
        });
  }

  /**
   * Extract simple class name from fully qualified service name. e.g.,
   * "com.apihug.hub.api.AuthService" -> "AuthService"
   */
  private String extractSimpleServiceName(String fqn) {
    if (fqn == null) return null;
    int lastDot = fqn.lastIndexOf('.');
    return lastDot >= 0 ? fqn.substring(lastDot + 1) : fqn;
  }

  /** Get client IP, considering proxy headers. */
  private String getClientIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("X-Real-IP");
    }
    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    // X-Forwarded-For may contain multiple IPs, take the first
    if (ip != null && ip.contains(",")) {
      ip = ip.split(",")[0].trim();
    }
    if (ip != null && ip.length() > 45) {
      ip = ip.substring(0, 45);
    }
    return ip;
  }

  /**
   * Desensitize request parameters. Keys containing sensitive words will have their values replaced
   * with "***".
   */
  private String sanitizeParams(Map<String, Object> ctx) {
    if (ctx == null || ctx.isEmpty()) {
      return null;
    }
    try {
      Map<String, Object> sanitized = new LinkedHashMap<>();
      for (Map.Entry<String, Object> entry : ctx.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();

        if (key.startsWith("_")) {
          continue;
        }
        if (value instanceof Map) {
          sanitized.put(key, sanitizeMap((Map<?, ?>) value));
        } else {
          sanitized.put(key, sanitizeValue(key, value));
        }
      }
      return mapper.writeValueAsString(sanitized);
    } catch (JsonProcessingException e) {
      return "{\"_error\":\"serialize_failed\"}";
    } catch (Exception e) {
      return null;
    }
  }

  private Map<String, Object> sanitizeMap(Map<?, ?> map) {
    Map<String, Object> result = new LinkedHashMap<>();
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      String key = String.valueOf(entry.getKey());
      Object value = entry.getValue();
      if (value instanceof Map) {
        result.put(key, sanitizeMap((Map<?, ?>) value));
      } else {
        result.put(key, sanitizeValue(key, value));
      }
    }
    return result;
  }

  private Object sanitizeValue(String key, Object value) {
    if (value == null) return null;
    String lowerKey = key.toLowerCase();
    for (String sensitive : SENSITIVE_KEYS) {
      if (lowerKey.contains(sensitive)) {
        return "***";
      }
    }
    // Truncate long string values
    if (value instanceof String s && s.length() > 200) {
      return s.substring(0, 200) + "...(truncated)";
    }
    return String.valueOf(value);
  }

  protected Optional<ServiceMethod> getMethods(String path) {
    if (path2Methods.isEmpty()) {
      synchronized (LOCK) {
        Map<String, hope.common.service.api.Service> services =
            RuntimeContext.INSTANCE.getModule().service().services();
        for (var svc : services.values()) {
          for (var mth : svc.getItems()) {
            path2Methods.put(mth.getPath(), mth);
          }
        }
      }
    }
    return Optional.ofNullable(path2Methods.get(path));
  }

  @Service
  public class AfterAspect implements Aspect {

    @Override
    public String name() {
      return "audit-after";
    }

    @Override
    public AspectType type() {
      return AspectType.AFTER;
    }

    @Override
    public <T> void after(
        ServiceMethodContext method, Map<String, Object> ctx, ResponseEntity<Result<T>> res) {
      int httpStatus = res != null ? res.getStatusCode().value() : 200;
      Long __start_time = (Long) ctx.get(START_TIME);
      String channel = ctx.getOrDefault(CHANNEL, "NA").toString();
      asyncSaveAccessLog(method, ctx, httpStatus, __start_time, channel, null, null);
    }
  }

  @Service
  public class ExceptonAspect implements Aspect {

    @Override
    public String name() {
      return "audit-exception";
    }

    @Override
    public AspectType type() {
      return AspectType.EXCEPTION;
    }

    @Override
    public void exception(
        ServiceMethodContext method, Map<String, Object> ctx, Throwable exception) {
      String errorCode = exception.getClass().getSimpleName();
      String errorMessage = exception.getMessage();
      if (errorMessage != null && errorMessage.length() > 500) {
        errorMessage = errorMessage.substring(0, 500);
      }
      Long __start_time = (Long) ctx.get(START_TIME);
      String channel = ctx.getOrDefault(CHANNEL, "NA").toString();
      // TODO this is much detail, look look how to handle this nicely
      if (exception instanceof HopeErrorDetailException hopeErrorDetailException) {
        var errors = hopeErrorDetailException.getErrors();
        if (errors != null && errors.size() > 0) {
          var error = errors.get(0);
          errorCode = error.getTitle();
          errorMessage = error.getDescription();
        }
      }
      asyncSaveAccessLog(method, ctx, 500, __start_time, channel, errorCode, errorMessage);
    }
  }
}
