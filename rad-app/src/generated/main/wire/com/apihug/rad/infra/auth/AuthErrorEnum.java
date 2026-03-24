// @formatter:off
package com.apihug.rad.infra.auth;

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
 * 认证相关错误
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/auth/constant.proto",
    entity = "AuthErrorEnum",
    kind = Kind.ENUM
)
public enum AuthErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error LOGIN_FAIL = new Error();

  public static final Error ACCOUNT_LOCKED = new Error();

  public static final Error ORGANIZATION_NOT_FOUND = new Error();

  public static final Error NO_ORGANIZATION_ACCESS = new Error();

  public static final Error TOKEN_EXPIRED = new Error();

  public static final Error INVALID_TOKEN = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    LOGIN_FAIL.setDomain("rad");
    LOGIN_FAIL.setCode(10006001);
    LOGIN_FAIL.setDescription("Login failed");
    LOGIN_FAIL.setDescription2("登录失败");
    LOGIN_FAIL.setTips("Check your username and password");
    LOGIN_FAIL.setPhase(Phase.SERVICE);
    LOGIN_FAIL.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("LOGIN_FAIL", LOGIN_FAIL);
    ERRORS.add(LOGIN_FAIL);
    ACCOUNT_LOCKED.setDomain("rad");
    ACCOUNT_LOCKED.setCode(10006002);
    ACCOUNT_LOCKED.setDescription("Account is locked");
    ACCOUNT_LOCKED.setDescription2("账户已锁定");
    ACCOUNT_LOCKED.setTips("Try again later or contact admin");
    ACCOUNT_LOCKED.setPhase(Phase.SERVICE);
    ACCOUNT_LOCKED.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("ACCOUNT_LOCKED", ACCOUNT_LOCKED);
    ERRORS.add(ACCOUNT_LOCKED);
    ORGANIZATION_NOT_FOUND.setDomain("rad");
    ORGANIZATION_NOT_FOUND.setCode(10006003);
    ORGANIZATION_NOT_FOUND.setDescription("Organization not found");
    ORGANIZATION_NOT_FOUND.setDescription2("组织不存在");
    ORGANIZATION_NOT_FOUND.setTips("Check if the organization ID is correct");
    ORGANIZATION_NOT_FOUND.setPhase(Phase.SERVICE);
    ORGANIZATION_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("ORGANIZATION_NOT_FOUND", ORGANIZATION_NOT_FOUND);
    ERRORS.add(ORGANIZATION_NOT_FOUND);
    NO_ORGANIZATION_ACCESS.setDomain("rad");
    NO_ORGANIZATION_ACCESS.setCode(10006004);
    NO_ORGANIZATION_ACCESS.setDescription("No access to this organization");
    NO_ORGANIZATION_ACCESS.setDescription2("无权访问该组织");
    NO_ORGANIZATION_ACCESS.setTips("Contact your administrator");
    NO_ORGANIZATION_ACCESS.setPhase(Phase.SERVICE);
    NO_ORGANIZATION_ACCESS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("NO_ORGANIZATION_ACCESS", NO_ORGANIZATION_ACCESS);
    ERRORS.add(NO_ORGANIZATION_ACCESS);
    TOKEN_EXPIRED.setDomain("rad");
    TOKEN_EXPIRED.setCode(10006005);
    TOKEN_EXPIRED.setDescription("Token has expired");
    TOKEN_EXPIRED.setDescription2("Token 已过期");
    TOKEN_EXPIRED.setTips("Please login again");
    TOKEN_EXPIRED.setPhase(Phase.SERVICE);
    TOKEN_EXPIRED.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("TOKEN_EXPIRED", TOKEN_EXPIRED);
    ERRORS.add(TOKEN_EXPIRED);
    INVALID_TOKEN.setDomain("rad");
    INVALID_TOKEN.setCode(10006006);
    INVALID_TOKEN.setDescription("Invalid token");
    INVALID_TOKEN.setDescription2("无效的 Token");
    INVALID_TOKEN.setTips("Please login again");
    INVALID_TOKEN.setPhase(Phase.SERVICE);
    INVALID_TOKEN.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("INVALID_TOKEN", INVALID_TOKEN);
    ERRORS.add(INVALID_TOKEN);
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
