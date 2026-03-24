// @formatter:off
package com.apihug.rad.infra.organization;

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
 * 组织状态枚举
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/infra/organization/constant.proto",
    entity = "OrganizationStatusEnum",
    kind = Kind.ENUM
)
@Schema(
    enumAsRef = true,
    nullable = false,
    allowableValues = {
        "ORG_ACTIVE",
        "ORG_INACTIVE",
        "ORG_DISABLED"
    },
    example = "ORG_ACTIVE",
    description = "组织状态枚举"
)
public enum OrganizationStatusEnum implements Enumeration<OrganizationStatusEnum> {
  NA(-1, "Default Placeholder Should NEVER be used", "默认占位枚举请勿使用"),

  ORG_ACTIVE(1, "active", "活跃"),

  ORG_INACTIVE(2, "inactive", "未激活"),

  ORG_DISABLED(3, "disabled", "禁用");

  public static final List<String> VALUES;

  public static final List<OrganizationStatusEnum> ENUMS;

  public static final List<Integer> CODES;

  public static final Map<String, OrganizationStatusEnum> NAME_2_ENUM_MAP;

  public static final Map<Integer, OrganizationStatusEnum> CODE_2_ENUM_MAP;

  public static final Enumeration.EnumerationsHelper<OrganizationStatusEnum> HELPER;

  static {
    List<String> _VALUES = new ArrayList<>();
    List<OrganizationStatusEnum> _ENUMS = new ArrayList<>();
    List<Integer> _CODES = new ArrayList<>();
    Map<String, OrganizationStatusEnum> _NAME_2_ENUM_MAP = new LinkedHashMap<>();
    Map<Integer, OrganizationStatusEnum> _CODE_2_ENUM_MAP = new LinkedHashMap<>();
    for (OrganizationStatusEnum each : OrganizationStatusEnum.values()) {
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
    new EnumerationsHelper<OrganizationStatusEnum>() {

    @Override
    public OrganizationStatusEnum mapFromCode(int code) {
    	return CODE_2_ENUM_MAP.getOrDefault(code, NA);
    }

    @Override
    public OrganizationStatusEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
    	return NA;
    }
    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
    }

    @Override
    public Class<OrganizationStatusEnum> supportClz() {
    	return OrganizationStatusEnum.class;
    }

    @Override
    public List<String> supportValues() {
    return VALUES;
    }

    @Override
    public List<OrganizationStatusEnum> supportEnumerations() {
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

  OrganizationStatusEnum(int code, String description, String description2, boolean deprecated) {
    this.code = code;
    this.description = description;
    this.description2 = description2;
    this.deprecated = deprecated;
  }

  OrganizationStatusEnum(int code, String description, String description2) {
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
  public List<OrganizationStatusEnum> supportEnumerations() {
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
  public OrganizationStatusEnum mapFromCode(int code) {
    if (this.code == code) {
      return this;
    }

    return  CODE_2_ENUM_MAP.getOrDefault(code, NA);
  }

  @Override
  public OrganizationStatusEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
      return NA;
    }

    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
  }
}
