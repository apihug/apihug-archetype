// @formatter:off
package com.apihug.rad.infra.tenant;

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
 * 成员类型枚举（原 EmployeeTypeEnum，从 organization 迁移至 tenant）
 * 租户成员类型枚举
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/infra/tenant/member_constant.proto",
    entity = "MemberTypeEnum",
    kind = Kind.ENUM
)
@Schema(
    enumAsRef = true,
    nullable = false,
    allowableValues = {
        "FULL_TIME",
        "PART_TIME",
        "CONTRACTOR",
        "INTERN"
    },
    example = "FULL_TIME",
    description = "租户成员类型枚举"
)
public enum MemberTypeEnum implements Enumeration<MemberTypeEnum> {
  NA(-1, "Default Placeholder Should NEVER be used", "默认占位枚举请勿使用"),

  FULL_TIME(1, "full_time", "正式员工"),

  PART_TIME(2, "part_time", "兼职员工"),

  CONTRACTOR(3, "contractor", "外包员工"),

  INTERN(4, "intern", "实习生");

  public static final List<String> VALUES;

  public static final List<MemberTypeEnum> ENUMS;

  public static final List<Integer> CODES;

  public static final Map<String, MemberTypeEnum> NAME_2_ENUM_MAP;

  public static final Map<Integer, MemberTypeEnum> CODE_2_ENUM_MAP;

  public static final Enumeration.EnumerationsHelper<MemberTypeEnum> HELPER;

  static {
    List<String> _VALUES = new ArrayList<>();
    List<MemberTypeEnum> _ENUMS = new ArrayList<>();
    List<Integer> _CODES = new ArrayList<>();
    Map<String, MemberTypeEnum> _NAME_2_ENUM_MAP = new LinkedHashMap<>();
    Map<Integer, MemberTypeEnum> _CODE_2_ENUM_MAP = new LinkedHashMap<>();
    for (MemberTypeEnum each : MemberTypeEnum.values()) {
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
    new EnumerationsHelper<MemberTypeEnum>() {

    @Override
    public MemberTypeEnum mapFromCode(int code) {
    	return CODE_2_ENUM_MAP.getOrDefault(code, NA);
    }

    @Override
    public MemberTypeEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
    	return NA;
    }
    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
    }

    @Override
    public Class<MemberTypeEnum> supportClz() {
    	return MemberTypeEnum.class;
    }

    @Override
    public List<String> supportValues() {
    return VALUES;
    }

    @Override
    public List<MemberTypeEnum> supportEnumerations() {
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

  MemberTypeEnum(int code, String description, String description2, boolean deprecated) {
    this.code = code;
    this.description = description;
    this.description2 = description2;
    this.deprecated = deprecated;
  }

  MemberTypeEnum(int code, String description, String description2) {
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
  public List<MemberTypeEnum> supportEnumerations() {
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
  public MemberTypeEnum mapFromCode(int code) {
    if (this.code == code) {
      return this;
    }

    return  CODE_2_ENUM_MAP.getOrDefault(code, NA);
  }

  @Override
  public MemberTypeEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
      return NA;
    }

    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
  }
}
