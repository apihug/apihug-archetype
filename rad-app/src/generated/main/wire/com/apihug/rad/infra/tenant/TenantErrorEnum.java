// @formatter:off
package com.apihug.rad.infra.tenant;

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
 * 租户相关错误
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/tenant/constant.proto",
    entity = "TenantErrorEnum",
    kind = Kind.ENUM
)
public enum TenantErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error TENANT_NOT_FOUND = new Error();

  public static final Error TENANT_CODE_EXISTS = new Error();

  public static final Error TENANT_HAS_USERS = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    TENANT_NOT_FOUND.setDomain("rad");
    TENANT_NOT_FOUND.setCode(10004001);
    TENANT_NOT_FOUND.setDescription("Tenant not found");
    TENANT_NOT_FOUND.setDescription2("租户不存在");
    TENANT_NOT_FOUND.setTips("Check if the tenant ID is correct");
    TENANT_NOT_FOUND.setPhase(Phase.DOMAIN);
    TENANT_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("TENANT_NOT_FOUND", TENANT_NOT_FOUND);
    ERRORS.add(TENANT_NOT_FOUND);
    TENANT_CODE_EXISTS.setDomain("rad");
    TENANT_CODE_EXISTS.setCode(10004002);
    TENANT_CODE_EXISTS.setDescription("Tenant code already exists");
    TENANT_CODE_EXISTS.setDescription2("租户代码已存在");
    TENANT_CODE_EXISTS.setTips("Use a different tenant code");
    TENANT_CODE_EXISTS.setPhase(Phase.DOMAIN);
    TENANT_CODE_EXISTS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("TENANT_CODE_EXISTS", TENANT_CODE_EXISTS);
    ERRORS.add(TENANT_CODE_EXISTS);
    TENANT_HAS_USERS.setDomain("rad");
    TENANT_HAS_USERS.setCode(10004003);
    TENANT_HAS_USERS.setDescription("Tenant has users");
    TENANT_HAS_USERS.setDescription2("租户下有用户，无法删除");
    TENANT_HAS_USERS.setTips("Remove all users from this tenant first");
    TENANT_HAS_USERS.setPhase(Phase.DOMAIN);
    TENANT_HAS_USERS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("TENANT_HAS_USERS", TENANT_HAS_USERS);
    ERRORS.add(TENANT_HAS_USERS);
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
