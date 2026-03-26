// @formatter:off
package com.apihug.rad.infra.settings;

import hope.common.enumeration.Enumeration;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

/**
 * RAD 权限枚举
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/infra/settings/authority.proto",
    entity = "RadAuthorityEnum",
    kind = Kind.ENUM
)
@Schema(
    enumAsRef = true,
    nullable = false,
    allowableValues = {
        "CUSTOMER_CREATE",
        "CUSTOMER_UPDATE",
        "CUSTOMER_DELETE",
        "CUSTOMER_VIEW",
        "ROLE_CREATE",
        "ROLE_UPDATE",
        "ROLE_DELETE",
        "ROLE_VIEW",
        "ROLE_ASSIGN_PERMISSION",
        "MENU_CREATE",
        "MENU_UPDATE",
        "MENU_DELETE",
        "MENU_VIEW",
        "TENANT_CREATE",
        "TENANT_UPDATE",
        "TENANT_DISABLE",
        "TENANT_CONFIGURE",
        "DEPARTMENT_CREATE",
        "DEPARTMENT_UPDATE",
        "DEPARTMENT_DELETE",
        "DEPARTMENT_ASSIGN_EMPLOYEE",
        "TENANT_MEMBER_VIEW",
        "TENANT_MEMBER_ADD",
        "TENANT_MEMBER_REMOVE",
        "TENANT_MEMBER_LOCK",
        "TENANT_MEMBER_ASSIGN_ROLE",
        "TENANT_MEMBER_ASSIGN_DEPARTMENT",
        "PLATFORM_MEMBER_VIEW",
        "PLATFORM_MEMBER_ADD",
        "PLATFORM_MEMBER_REMOVE",
        "PLATFORM_MEMBER_FREEZE",
        "PLATFORM_MEMBER_UPDATE_ROLE"
    },
    example = "CUSTOMER_CREATE",
    description = "RAD 权限枚举"
)
public enum RadAuthorityEnum implements Enumeration<RadAuthorityEnum> {
  NA(-1, "Default Placeholder Should NEVER be used", "默认占位枚举请勿使用"),

  /**
   * 客户管理权限
   */
  CUSTOMER_CREATE(1, "customer:create", "创建客户"),

  CUSTOMER_UPDATE(2, "customer:update", "更新客户"),

  CUSTOMER_DELETE(3, "customer:delete", "删除客户"),

  CUSTOMER_VIEW(4, "customer:view", "查看客户"),

  /**
   * 角色管理权限
   */
  ROLE_CREATE(5, "tenant:role:create", "创建角色"),

  ROLE_UPDATE(6, "tenant:role:update", "更新角色"),

  ROLE_DELETE(7, "tenant:role:delete", "删除角色"),

  ROLE_VIEW(8, "tenant:role:view", "查看角色"),

  ROLE_ASSIGN_PERMISSION(9, "tenant:role:assign_permission", "分配角色权限"),

  /**
   * 菜单管理权限
   */
  MENU_CREATE(10, "platform:menu:create", "创建菜单"),

  MENU_UPDATE(11, "platform:menu:update", "更新菜单"),

  MENU_DELETE(12, "platform:menu:delete", "删除菜单"),

  MENU_VIEW(13, "platform:menu:view", "查看菜单"),

  /**
   * 租户管理权限
   */
  TENANT_CREATE(14, "tenant:create", "创建租户"),

  TENANT_UPDATE(15, "tenant:update", "更新租户"),

  TENANT_DISABLE(16, "tenant:disable", "停用租户"),

  TENANT_CONFIGURE(17, "tenant:configure", "配置租户"),

  /**
   * 部门管理权限
   */
  DEPARTMENT_CREATE(18, "tenant:department:create", "创建部门"),

  DEPARTMENT_UPDATE(19, "tenant:department:update", "更新部门"),

  DEPARTMENT_DELETE(20, "tenant:department:delete", "删除部门"),

  DEPARTMENT_ASSIGN_EMPLOYEE(21, "tenant:department:assign_employee", "分配员工到部门"),

  /**
   * 租户成员管理权限
   */
  TENANT_MEMBER_VIEW(22, "tenant:member:view", "查看租户成员"),

  TENANT_MEMBER_ADD(23, "tenant:member:add", "添加租户成员"),

  TENANT_MEMBER_REMOVE(24, "tenant:member:remove", "移除租户成员"),

  TENANT_MEMBER_LOCK(25, "tenant:member:lock", "锁定租户成员"),

  TENANT_MEMBER_ASSIGN_ROLE(26, "tenant:member:assign_role", "分配成员角色"),

  TENANT_MEMBER_ASSIGN_DEPARTMENT(27, "tenant:member:assign_department", "分配成员部门"),

  /**
   * 平台成员管理权限
   */
  PLATFORM_MEMBER_VIEW(28, "platform:member:view", "查看平台成员"),

  PLATFORM_MEMBER_ADD(29, "platform:member:add", "添加平台成员"),

  PLATFORM_MEMBER_REMOVE(30, "platform:member:remove", "移除平台成员"),

  PLATFORM_MEMBER_FREEZE(31, "platform:member:freeze", "冻结/解冻平台成员"),

  PLATFORM_MEMBER_UPDATE_ROLE(32, "platform:member:update_role", "更新平台成员角色");

  public static final List<String> VALUES;

  public static final List<RadAuthorityEnum> ENUMS;

  public static final List<Integer> CODES;

  public static final Map<String, RadAuthorityEnum> NAME_2_ENUM_MAP;

  public static final Map<Integer, RadAuthorityEnum> CODE_2_ENUM_MAP;

  public static final Enumeration.EnumerationsHelper<RadAuthorityEnum> HELPER;

  static {
    List<String> _VALUES = new ArrayList<>();
    List<RadAuthorityEnum> _ENUMS = new ArrayList<>();
    List<Integer> _CODES = new ArrayList<>();
    Map<String, RadAuthorityEnum> _NAME_2_ENUM_MAP = new LinkedHashMap<>();
    Map<Integer, RadAuthorityEnum> _CODE_2_ENUM_MAP = new LinkedHashMap<>();
    for (RadAuthorityEnum each : RadAuthorityEnum.values()) {
    	_VALUES.add(each.title());
    	_ENUMS.add(each);
    	_CODES.add(each.code());
    	_NAME_2_ENUM_MAP.put(each.title(), each);
    	_CODE_2_ENUM_MAP.put(each.code(), each);
    }
    VALUES = Collections.unmodifiableList(_VALUES);
    ENUMS = Collections.unmodifiableList(_ENUMS);
    CODES = Collections.unmodifiableList(_CODES);
    NAME_2_ENUM_MAP = Collections.unmodifiableMap(_NAME_2_ENUM_MAP);
    CODE_2_ENUM_MAP = Collections.unmodifiableMap(_CODE_2_ENUM_MAP);
    HELPER =
    new EnumerationsHelper<RadAuthorityEnum>() {

    @Override
    public RadAuthorityEnum mapFromCode(int code) {
    	return CODE_2_ENUM_MAP.getOrDefault(code, NA);
    }

    @Override
    public RadAuthorityEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
    	return NA;
    }
    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
    }

    @Override
    public Class<RadAuthorityEnum> supportClz() {
    	return RadAuthorityEnum.class;
    }

    @Override
    public List<String> supportValues() {
    return VALUES;
    }

    @Override
    public List<RadAuthorityEnum> supportEnumerations() {
    return ENUMS;
    }

    @Override
    public List<Integer> supportCodes() {
    return CODES;
    }

    };
  }

  public final int code;

  public final String description;

  public final String description2;

  public final boolean deprecated;

  RadAuthorityEnum(int code, String description, String description2, boolean deprecated) {
    this.code = code;
    this.description = description;
    this.description2 = description2;
    this.deprecated = deprecated;
  }

  RadAuthorityEnum(int code, String description, String description2) {
    this(code, description, description2, false);
  }

  @Override
  public String title() {
    return name();
  }

  @Override
  public int code() {
    return code;
  }

  @Override
  public String description() {
    return description;
  }

  @Override
  public String description2() {
    return description2 != null ? description2 : description();
  }

  @Override
  public boolean deprecated() {
    return deprecated;
  }

  @Override
  public List<RadAuthorityEnum> supportEnumerations() {
    return ENUMS;
  }

  @Override
  public List<Integer> supportCodes() {
    return CODES;
  }

  @Override
  public List<String> supportValues() {
    return VALUES;
  }

  @Override
  public RadAuthorityEnum mapFromCode(int code) {
    if (this.code == code) {
      return this;
    }

    return  CODE_2_ENUM_MAP.getOrDefault(code, NA);
  }

  @Override
  public RadAuthorityEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
      return NA;
    }

    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
  }
}
