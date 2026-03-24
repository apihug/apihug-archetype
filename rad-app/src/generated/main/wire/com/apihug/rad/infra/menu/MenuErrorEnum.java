// @formatter:off
package com.apihug.rad.infra.menu;

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
 * Error happen during menu domain
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/menu/error.proto",
    entity = "MenuErrorEnum",
    kind = Kind.ENUM
)
public enum MenuErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error MENU_NOT_FOUND = new Error();

  public static final Error MENU_CODE_EXISTS = new Error();

  public static final Error MENU_HAS_CHILDREN = new Error();

  public static final Error INVALID_PARENT_MENU = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    MENU_NOT_FOUND.setDomain("rad");
    MENU_NOT_FOUND.setCode(10003001);
    MENU_NOT_FOUND.setDescription("Menu not found");
    MENU_NOT_FOUND.setDescription2("菜单不存在");
    MENU_NOT_FOUND.setTips("Check if the menu ID is correct");
    MENU_NOT_FOUND.setPhase(Phase.DOMAIN);
    MENU_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("MENU_NOT_FOUND", MENU_NOT_FOUND);
    ERRORS.add(MENU_NOT_FOUND);
    MENU_CODE_EXISTS.setDomain("rad");
    MENU_CODE_EXISTS.setCode(10003002);
    MENU_CODE_EXISTS.setDescription("Menu code already exists");
    MENU_CODE_EXISTS.setDescription2("菜单代码已存在");
    MENU_CODE_EXISTS.setTips("Use a different menu code");
    MENU_CODE_EXISTS.setPhase(Phase.DOMAIN);
    MENU_CODE_EXISTS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("MENU_CODE_EXISTS", MENU_CODE_EXISTS);
    ERRORS.add(MENU_CODE_EXISTS);
    MENU_HAS_CHILDREN.setDomain("rad");
    MENU_HAS_CHILDREN.setCode(10003003);
    MENU_HAS_CHILDREN.setDescription("Menu has child menus");
    MENU_HAS_CHILDREN.setDescription2("菜单有子菜单，无法删除");
    MENU_HAS_CHILDREN.setTips("Remove all child menus first");
    MENU_HAS_CHILDREN.setPhase(Phase.DOMAIN);
    MENU_HAS_CHILDREN.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("MENU_HAS_CHILDREN", MENU_HAS_CHILDREN);
    ERRORS.add(MENU_HAS_CHILDREN);
    INVALID_PARENT_MENU.setDomain("rad");
    INVALID_PARENT_MENU.setCode(10003004);
    INVALID_PARENT_MENU.setDescription("Invalid parent menu");
    INVALID_PARENT_MENU.setDescription2("无效的父菜单");
    INVALID_PARENT_MENU.setTips("Check if the parent menu ID is correct");
    INVALID_PARENT_MENU.setPhase(Phase.DOMAIN);
    INVALID_PARENT_MENU.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("INVALID_PARENT_MENU", INVALID_PARENT_MENU);
    ERRORS.add(INVALID_PARENT_MENU);
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
