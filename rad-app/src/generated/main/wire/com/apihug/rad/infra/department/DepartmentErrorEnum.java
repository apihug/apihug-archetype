// @formatter:off
package com.apihug.rad.infra.department;

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
 * 部门相关错误
 */
@ProtoFrom(
    value = "com/apihug/rad/infra/department/constant.proto",
    entity = "DepartmentErrorEnum",
    kind = Kind.ENUM
)
public enum DepartmentErrorEnum implements Errors {
  INSTANCE;

  public static final List<Error> ERRORS = new ArrayList();

  public static final Map<String, Error> ERRORS_MAP;

  public static final Error UNDEFINED = Error.unknown().setDomain("rad").setTitle("UNDEFINED");

  public static final Error DEPARTMENT_NOT_FOUND = new Error();

  public static final Error DEPT_CODE_EXISTS = new Error();

  public static final Error DEPARTMENT_HAS_CHILDREN = new Error();

  public static final Error DEPARTMENT_HAS_EMPLOYEES = new Error();

  static {
    Map<String, Error> _ERRORS_MAP = new LinkedHashMap<>();
    DEPARTMENT_NOT_FOUND.setDomain("rad");
    DEPARTMENT_NOT_FOUND.setCode(10005001);
    DEPARTMENT_NOT_FOUND.setDescription("Department not found");
    DEPARTMENT_NOT_FOUND.setDescription2("部门不存在");
    DEPARTMENT_NOT_FOUND.setTips("Check if the department ID is correct");
    DEPARTMENT_NOT_FOUND.setPhase(Phase.DOMAIN);
    DEPARTMENT_NOT_FOUND.setSeverity(Severity.FATAL);
    _ERRORS_MAP.put("DEPARTMENT_NOT_FOUND", DEPARTMENT_NOT_FOUND);
    ERRORS.add(DEPARTMENT_NOT_FOUND);
    DEPT_CODE_EXISTS.setDomain("rad");
    DEPT_CODE_EXISTS.setCode(10005002);
    DEPT_CODE_EXISTS.setDescription("Department code already exists");
    DEPT_CODE_EXISTS.setDescription2("部门代码已存在");
    DEPT_CODE_EXISTS.setTips("Use a different department code");
    DEPT_CODE_EXISTS.setPhase(Phase.DOMAIN);
    DEPT_CODE_EXISTS.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("DEPT_CODE_EXISTS", DEPT_CODE_EXISTS);
    ERRORS.add(DEPT_CODE_EXISTS);
    DEPARTMENT_HAS_CHILDREN.setDomain("rad");
    DEPARTMENT_HAS_CHILDREN.setCode(10005003);
    DEPARTMENT_HAS_CHILDREN.setDescription("Department has child departments");
    DEPARTMENT_HAS_CHILDREN.setDescription2("部门有子部门，无法删除");
    DEPARTMENT_HAS_CHILDREN.setTips("Remove all child departments first");
    DEPARTMENT_HAS_CHILDREN.setPhase(Phase.DOMAIN);
    DEPARTMENT_HAS_CHILDREN.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("DEPARTMENT_HAS_CHILDREN", DEPARTMENT_HAS_CHILDREN);
    ERRORS.add(DEPARTMENT_HAS_CHILDREN);
    DEPARTMENT_HAS_EMPLOYEES.setDomain("rad");
    DEPARTMENT_HAS_EMPLOYEES.setCode(10005004);
    DEPARTMENT_HAS_EMPLOYEES.setDescription("Department has employees");
    DEPARTMENT_HAS_EMPLOYEES.setDescription2("部门有员工，无法删除");
    DEPARTMENT_HAS_EMPLOYEES.setTips("Remove all employees from this department first");
    DEPARTMENT_HAS_EMPLOYEES.setPhase(Phase.DOMAIN);
    DEPARTMENT_HAS_EMPLOYEES.setSeverity(Severity.WARN);
    _ERRORS_MAP.put("DEPARTMENT_HAS_EMPLOYEES", DEPARTMENT_HAS_EMPLOYEES);
    ERRORS.add(DEPARTMENT_HAS_EMPLOYEES);
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
