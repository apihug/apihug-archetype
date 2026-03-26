// @formatter:off
package com.apihug.rad.infra.platform;

import hope.common.api.error.Error;
import hope.common.api.error.Errors;
import hope.common.api.error.HttpStatus;
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
 * 平台成员相关错误枚举
 * 平台成员相关错误
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/platform/constant.proto",
    entity = "PlatformMemberErrorEnum",
    kind = Kind.ENUM
)
public enum PlatformMemberErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error PLATFORM_MEMBER_NOT_FOUND = new Error();

  public static final Error PLATFORM_MEMBER_ALREADY_EXISTS = new Error();

  public static final Error PLATFORM_OWNER_CANNOT_BE_REMOVED = new Error();

  public static final Error PLATFORM_MEMBER_LOCKED = new Error();

  public static final Error PLATFORM_MEMBER_INACTIVE = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    PLATFORM_MEMBER_NOT_FOUND.setDomain("rad");
    PLATFORM_MEMBER_NOT_FOUND.setCode(10008001);
    PLATFORM_MEMBER_NOT_FOUND.setDescription("Platform member not found");
    PLATFORM_MEMBER_NOT_FOUND.setDescription2("平台成员不存在");
    PLATFORM_MEMBER_NOT_FOUND.setTips("Check if the platform member ID is correct");
    PLATFORM_MEMBER_NOT_FOUND.setPhase(Phase.DOMAIN);
    PLATFORM_MEMBER_NOT_FOUND.setSeverity(Severity.FATAL);
    PLATFORM_MEMBER_NOT_FOUND.setHttpStatus(HttpStatus.NOT_FOUND);
    _ERRORS_MAP.put("PLATFORM_MEMBER_NOT_FOUND", PLATFORM_MEMBER_NOT_FOUND);
    ERRORS.add(PLATFORM_MEMBER_NOT_FOUND);
    PLATFORM_MEMBER_ALREADY_EXISTS.setDomain("rad");
    PLATFORM_MEMBER_ALREADY_EXISTS.setCode(10008002);
    PLATFORM_MEMBER_ALREADY_EXISTS.setDescription("Customer is already a platform member");
    PLATFORM_MEMBER_ALREADY_EXISTS.setDescription2("该客户已是平台成员");
    PLATFORM_MEMBER_ALREADY_EXISTS.setTips("The customer has already joined the platform");
    PLATFORM_MEMBER_ALREADY_EXISTS.setPhase(Phase.DOMAIN);
    PLATFORM_MEMBER_ALREADY_EXISTS.setSeverity(Severity.WARN);
    PLATFORM_MEMBER_ALREADY_EXISTS.setHttpStatus(HttpStatus.CONFLICT);
    _ERRORS_MAP.put("PLATFORM_MEMBER_ALREADY_EXISTS", PLATFORM_MEMBER_ALREADY_EXISTS);
    ERRORS.add(PLATFORM_MEMBER_ALREADY_EXISTS);
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setDomain("rad");
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setCode(10008003);
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setDescription("Platform owner cannot be removed");
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setDescription2("平台拥有者不允许被移除");
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setTips("Cannot remove the platform owner to prevent losing platform access");
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setPhase(Phase.DOMAIN);
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setSeverity(Severity.WARN);
    PLATFORM_OWNER_CANNOT_BE_REMOVED.setHttpStatus(HttpStatus.BAD_REQUEST);
    _ERRORS_MAP.put("PLATFORM_OWNER_CANNOT_BE_REMOVED", PLATFORM_OWNER_CANNOT_BE_REMOVED);
    ERRORS.add(PLATFORM_OWNER_CANNOT_BE_REMOVED);
    PLATFORM_MEMBER_LOCKED.setDomain("rad");
    PLATFORM_MEMBER_LOCKED.setCode(10008004);
    PLATFORM_MEMBER_LOCKED.setDescription("Platform member is locked");
    PLATFORM_MEMBER_LOCKED.setDescription2("平台成员已被冻结");
    PLATFORM_MEMBER_LOCKED.setTips("Contact platform administrator to unlock your account");
    PLATFORM_MEMBER_LOCKED.setPhase(Phase.DOMAIN);
    PLATFORM_MEMBER_LOCKED.setSeverity(Severity.WARN);
    PLATFORM_MEMBER_LOCKED.setHttpStatus(HttpStatus.FORBIDDEN);
    _ERRORS_MAP.put("PLATFORM_MEMBER_LOCKED", PLATFORM_MEMBER_LOCKED);
    ERRORS.add(PLATFORM_MEMBER_LOCKED);
    PLATFORM_MEMBER_INACTIVE.setDomain("rad");
    PLATFORM_MEMBER_INACTIVE.setCode(10008005);
    PLATFORM_MEMBER_INACTIVE.setDescription("Platform member is inactive and cannot be modified");
    PLATFORM_MEMBER_INACTIVE.setDescription2("平台成员已移除，无法进行此操作");
    PLATFORM_MEMBER_INACTIVE.setTips("Inactive members cannot be frozen or unfrozen");
    PLATFORM_MEMBER_INACTIVE.setPhase(Phase.DOMAIN);
    PLATFORM_MEMBER_INACTIVE.setSeverity(Severity.WARN);
    PLATFORM_MEMBER_INACTIVE.setHttpStatus(HttpStatus.BAD_REQUEST);
    _ERRORS_MAP.put("PLATFORM_MEMBER_INACTIVE", PLATFORM_MEMBER_INACTIVE);
    ERRORS.add(PLATFORM_MEMBER_INACTIVE);
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
