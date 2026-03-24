// @formatter:off
package com.apihug.rad.infra.role;

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
 * Error happen during role domain
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/role/error.proto",
    entity = "RoleErrorEnum",
    kind = Kind.ENUM
)
public enum RoleErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error ROLE_NOT_FOUND = new Error();

  public static final Error ROLE_CODE_EXISTS = new Error();

  public static final Error ROLE_HAS_USERS = new Error();

  public static final Error PERMISSION_NOT_FOUND = new Error();

  public static final Error PERMISSION_ALREADY_ASSIGNED = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    ROLE_NOT_FOUND.setDomain("rad");
    ROLE_NOT_FOUND.setCode(10002001);
    ROLE_NOT_FOUND.setDescription("Role not found");
    ROLE_NOT_FOUND.setDescription2("角色不存在");
    ROLE_NOT_FOUND.setTips("Check if the role ID is correct");
    ROLE_NOT_FOUND.setPhase(Phase.DOMAIN);
    ROLE_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("ROLE_NOT_FOUND", ROLE_NOT_FOUND);
    ERRORS.add(ROLE_NOT_FOUND);
    ROLE_CODE_EXISTS.setDomain("rad");
    ROLE_CODE_EXISTS.setCode(10002002);
    ROLE_CODE_EXISTS.setDescription("Role code already exists");
    ROLE_CODE_EXISTS.setDescription2("角色代码已存在");
    ROLE_CODE_EXISTS.setTips("Use a different role code");
    ROLE_CODE_EXISTS.setPhase(Phase.DOMAIN);
    ROLE_CODE_EXISTS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("ROLE_CODE_EXISTS", ROLE_CODE_EXISTS);
    ERRORS.add(ROLE_CODE_EXISTS);
    ROLE_HAS_USERS.setDomain("rad");
    ROLE_HAS_USERS.setCode(10002003);
    ROLE_HAS_USERS.setDescription("Role has assigned users");
    ROLE_HAS_USERS.setDescription2("角色已分配给用户，无法删除");
    ROLE_HAS_USERS.setTips("Remove all users from this role first");
    ROLE_HAS_USERS.setPhase(Phase.DOMAIN);
    ROLE_HAS_USERS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("ROLE_HAS_USERS", ROLE_HAS_USERS);
    ERRORS.add(ROLE_HAS_USERS);
    PERMISSION_NOT_FOUND.setDomain("rad");
    PERMISSION_NOT_FOUND.setCode(10002004);
    PERMISSION_NOT_FOUND.setDescription("Permission not found");
    PERMISSION_NOT_FOUND.setDescription2("权限不存在");
    PERMISSION_NOT_FOUND.setTips("Check if the permission ID is correct");
    PERMISSION_NOT_FOUND.setPhase(Phase.DOMAIN);
    PERMISSION_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("PERMISSION_NOT_FOUND", PERMISSION_NOT_FOUND);
    ERRORS.add(PERMISSION_NOT_FOUND);
    PERMISSION_ALREADY_ASSIGNED.setDomain("rad");
    PERMISSION_ALREADY_ASSIGNED.setCode(10002005);
    PERMISSION_ALREADY_ASSIGNED.setDescription("Permission already assigned");
    PERMISSION_ALREADY_ASSIGNED.setDescription2("权限已分配");
    PERMISSION_ALREADY_ASSIGNED.setTips("This permission is already assigned to the role");
    PERMISSION_ALREADY_ASSIGNED.setPhase(Phase.DOMAIN);
    PERMISSION_ALREADY_ASSIGNED.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("PERMISSION_ALREADY_ASSIGNED", PERMISSION_ALREADY_ASSIGNED);
    ERRORS.add(PERMISSION_ALREADY_ASSIGNED);
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
