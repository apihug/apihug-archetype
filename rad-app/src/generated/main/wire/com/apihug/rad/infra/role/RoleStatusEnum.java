// @formatter:off
package com.apihug.rad.infra.role;

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
 * 角色状态枚举定义
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/infra/role/constant.proto",
    entity = "RoleStatusEnum",
    kind = Kind.ENUM
)
@Schema(
    enumAsRef = true,
    nullable = false,
    allowableValues = {
        "ACTIVE",
        "INACTIVE",
        "DISABLED"
    },
    example = "ACTIVE",
    description = "角色状态枚举定义"
)
public enum RoleStatusEnum implements Enumeration<RoleStatusEnum> {
  NA(-1, "Default Placeholder Should NEVER be used", "默认占位枚举请勿使用"),

  ACTIVE(1, "active", "活跃"),

  INACTIVE(2, "inactive", "非活跃"),

  DISABLED(3, "disabled", "禁用");

  public static final List<String> VALUES;

  public static final List<RoleStatusEnum> ENUMS;

  public static final List<Integer> CODES;

  public static final Map<String, RoleStatusEnum> NAME_2_ENUM_MAP;

  public static final Map<Integer, RoleStatusEnum> CODE_2_ENUM_MAP;

  public static final Enumeration.EnumerationsHelper<RoleStatusEnum> HELPER;

  static {
    List<String> _VALUES = new ArrayList<>();
    List<RoleStatusEnum> _ENUMS = new ArrayList<>();
    List<Integer> _CODES = new ArrayList<>();
    Map<String, RoleStatusEnum> _NAME_2_ENUM_MAP = new LinkedHashMap<>();
    Map<Integer, RoleStatusEnum> _CODE_2_ENUM_MAP = new LinkedHashMap<>();
    for (RoleStatusEnum each : RoleStatusEnum.values()) {
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
    new EnumerationsHelper<RoleStatusEnum>() {

    @Override
    public RoleStatusEnum mapFromCode(int code) {
    	return CODE_2_ENUM_MAP.getOrDefault(code, NA);
    }

    @Override
    public RoleStatusEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
    	return NA;
    }
    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
    }

    @Override
    public Class<RoleStatusEnum> supportClz() {
    	return RoleStatusEnum.class;
    }

    @Override
    public List<String> supportValues() {
    return VALUES;
    }

    @Override
    public List<RoleStatusEnum> supportEnumerations() {
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

  RoleStatusEnum(int code, String description, String description2, boolean deprecated) {
    this.code = code;
    this.description = description;
    this.description2 = description2;
    this.deprecated = deprecated;
  }

  RoleStatusEnum(int code, String description, String description2) {
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
  public List<RoleStatusEnum> supportEnumerations() {
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
  public RoleStatusEnum mapFromCode(int code) {
    if (this.code == code) {
      return this;
    }

    return  CODE_2_ENUM_MAP.getOrDefault(code, NA);
  }

  @Override
  public RoleStatusEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
      return NA;
    }

    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
  }
}
