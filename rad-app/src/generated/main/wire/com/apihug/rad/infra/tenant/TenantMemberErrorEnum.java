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
 * 租户成员相关错误
 * 租户成员相关错误
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/tenant/member_constant.proto",
    entity = "TenantMemberErrorEnum",
    kind = Kind.ENUM
)
public enum TenantMemberErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error MEMBER_NOT_FOUND = new Error();

  public static final Error MEMBER_ALREADY_EXISTS = new Error();

  public static final Error MEMBER_LOCKED = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    MEMBER_NOT_FOUND.setDomain("rad");
    MEMBER_NOT_FOUND.setCode(10007001);
    MEMBER_NOT_FOUND.setDescription("Tenant member not found");
    MEMBER_NOT_FOUND.setDescription2("租户成员不存在");
    MEMBER_NOT_FOUND.setTips("Check if the member ID is correct");
    MEMBER_NOT_FOUND.setPhase(Phase.DOMAIN);
    MEMBER_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("MEMBER_NOT_FOUND", MEMBER_NOT_FOUND);
    ERRORS.add(MEMBER_NOT_FOUND);
    MEMBER_ALREADY_EXISTS.setDomain("rad");
    MEMBER_ALREADY_EXISTS.setCode(10007002);
    MEMBER_ALREADY_EXISTS.setDescription("Member already exists in this tenant");
    MEMBER_ALREADY_EXISTS.setDescription2("该成员已在此租户中");
    MEMBER_ALREADY_EXISTS.setTips("The customer is already a member of this tenant");
    MEMBER_ALREADY_EXISTS.setPhase(Phase.DOMAIN);
    MEMBER_ALREADY_EXISTS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("MEMBER_ALREADY_EXISTS", MEMBER_ALREADY_EXISTS);
    ERRORS.add(MEMBER_ALREADY_EXISTS);
    MEMBER_LOCKED.setDomain("rad");
    MEMBER_LOCKED.setCode(10007003);
    MEMBER_LOCKED.setDescription("Member is locked");
    MEMBER_LOCKED.setDescription2("成员已被锁定");
    MEMBER_LOCKED.setTips("Contact your tenant administrator");
    MEMBER_LOCKED.setPhase(Phase.DOMAIN);
    MEMBER_LOCKED.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("MEMBER_LOCKED", MEMBER_LOCKED);
    ERRORS.add(MEMBER_LOCKED);
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
