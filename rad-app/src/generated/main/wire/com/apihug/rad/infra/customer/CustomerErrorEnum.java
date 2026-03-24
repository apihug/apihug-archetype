// @formatter:off
package com.apihug.rad.infra.customer;

import hope.common.api.error.Error;
import hope.common.api.error.Errors;
import hope.common.api.error.Phase;
import hope.common.api.error.Severity;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户领域相关错误
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/customer/error.proto",
    entity = "CustomerErrorEnum",
    kind = Kind.ENUM
)
public enum CustomerErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error CUSTOMER_NOT_FOUND = new Error();

  public static final Error CUSTOMER_ALREADY_EXISTS = new Error();

  public static final Error INVALID_RESET_TOKEN = new Error();

  public static final Error RESET_TOKEN_EXPIRED = new Error();

  public static final Error WEAK_PASSWORD = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    CUSTOMER_NOT_FOUND.setDomain("rad");
    CUSTOMER_NOT_FOUND.setCode(10001023);
    CUSTOMER_NOT_FOUND.setDescription("Customer not found");
    CUSTOMER_NOT_FOUND.setDescription2("客户不存在");
    CUSTOMER_NOT_FOUND.setTips("Contact your admin or create a new customer");
    CUSTOMER_NOT_FOUND.setPhase(Phase.DOMAIN);
    CUSTOMER_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("CUSTOMER_NOT_FOUND", CUSTOMER_NOT_FOUND);
    ERRORS.add(CUSTOMER_NOT_FOUND);
    CUSTOMER_ALREADY_EXISTS.setDomain("rad");
    CUSTOMER_ALREADY_EXISTS.setCode(10001026);
    CUSTOMER_ALREADY_EXISTS.setDescription("Customer already exists");
    CUSTOMER_ALREADY_EXISTS.setDescription2("客户已存在");
    CUSTOMER_ALREADY_EXISTS.setTips("Use a different username or email");
    CUSTOMER_ALREADY_EXISTS.setPhase(Phase.DOMAIN);
    CUSTOMER_ALREADY_EXISTS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("CUSTOMER_ALREADY_EXISTS", CUSTOMER_ALREADY_EXISTS);
    ERRORS.add(CUSTOMER_ALREADY_EXISTS);
    INVALID_RESET_TOKEN.setDomain("rad");
    INVALID_RESET_TOKEN.setCode(10001027);
    INVALID_RESET_TOKEN.setDescription("Invalid reset token");
    INVALID_RESET_TOKEN.setDescription2("重置 token 无效");
    INVALID_RESET_TOKEN.setTips("Request a new password reset");
    INVALID_RESET_TOKEN.setPhase(Phase.DOMAIN);
    INVALID_RESET_TOKEN.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("INVALID_RESET_TOKEN", INVALID_RESET_TOKEN);
    ERRORS.add(INVALID_RESET_TOKEN);
    RESET_TOKEN_EXPIRED.setDomain("rad");
    RESET_TOKEN_EXPIRED.setCode(10001028);
    RESET_TOKEN_EXPIRED.setDescription("Reset token expired");
    RESET_TOKEN_EXPIRED.setDescription2("重置 token 已过期");
    RESET_TOKEN_EXPIRED.setTips("Request a new password reset");
    RESET_TOKEN_EXPIRED.setPhase(Phase.DOMAIN);
    RESET_TOKEN_EXPIRED.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("RESET_TOKEN_EXPIRED", RESET_TOKEN_EXPIRED);
    ERRORS.add(RESET_TOKEN_EXPIRED);
    WEAK_PASSWORD.setDomain("rad");
    WEAK_PASSWORD.setCode(10001029);
    WEAK_PASSWORD.setDescription("Weak password");
    WEAK_PASSWORD.setDescription2("密码强度不足");
    WEAK_PASSWORD.setTips("Password must be at least 6 characters");
    WEAK_PASSWORD.setPhase(Phase.DOMAIN);
    WEAK_PASSWORD.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("WEAK_PASSWORD", WEAK_PASSWORD);
    ERRORS.add(WEAK_PASSWORD);
    ERRORS_MAP = Collections.unmodifiableMap(_ERRORS_MAP);
  }

  @Override
  public String domain() {
    return "rad";
  }

  @Override
  public List<Error> items() {
    return ERRORS;
  }

  @Override
  public Error map(String name) {
    return ERRORS_MAP.getOrDefault(name, UNDEFINED);
  }
}
