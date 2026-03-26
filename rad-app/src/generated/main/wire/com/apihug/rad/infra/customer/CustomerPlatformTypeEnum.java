// @formatter:off
package com.apihug.rad.infra.customer;

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
 * 客户平台标志
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/infra/customer/constant.proto",
    entity = "CustomerPlatformTypeEnum",
    kind = Kind.ENUM
)
@Schema(
    enumAsRef = true,
    nullable = false,
    allowableValues = {
        "MEMBER",
        "MANAGER",
        "OWNER"
    },
    example = "MEMBER",
    description = "客户平台标志"
)
public enum CustomerPlatformTypeEnum implements Enumeration<CustomerPlatformTypeEnum> {
  NA(-1, "Default Placeholder Should NEVER be used", "默认占位枚举请勿使用"),

  MEMBER(1, "platform member", "平台员工"),

  MANAGER(2, "platform manager", "平台管理员"),

  OWNER(3, "platform owner", "平台拥有者");

  public static final List<String> VALUES;

  public static final List<CustomerPlatformTypeEnum> ENUMS;

  public static final List<Integer> CODES;

  public static final Map<String, CustomerPlatformTypeEnum> NAME_2_ENUM_MAP;

  public static final Map<Integer, CustomerPlatformTypeEnum> CODE_2_ENUM_MAP;

  public static final Enumeration.EnumerationsHelper<CustomerPlatformTypeEnum> HELPER;

  static {
    List<String> _VALUES = new ArrayList<>();
    List<CustomerPlatformTypeEnum> _ENUMS = new ArrayList<>();
    List<Integer> _CODES = new ArrayList<>();
    Map<String, CustomerPlatformTypeEnum> _NAME_2_ENUM_MAP = new LinkedHashMap<>();
    Map<Integer, CustomerPlatformTypeEnum> _CODE_2_ENUM_MAP = new LinkedHashMap<>();
    for (CustomerPlatformTypeEnum each : CustomerPlatformTypeEnum.values()) {
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
    new EnumerationsHelper<CustomerPlatformTypeEnum>() {

    @Override
    public CustomerPlatformTypeEnum mapFromCode(int code) {
    	return CODE_2_ENUM_MAP.getOrDefault(code, NA);
    }

    @Override
    public CustomerPlatformTypeEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
    	return NA;
    }
    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
    }

    @Override
    public Class<CustomerPlatformTypeEnum> supportClz() {
    	return CustomerPlatformTypeEnum.class;
    }

    @Override
    public List<String> supportValues() {
    return VALUES;
    }

    @Override
    public List<CustomerPlatformTypeEnum> supportEnumerations() {
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

  CustomerPlatformTypeEnum(int code, String description, String description2, boolean deprecated) {
    this.code = code;
    this.description = description;
    this.description2 = description2;
    this.deprecated = deprecated;
  }

  CustomerPlatformTypeEnum(int code, String description, String description2) {
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
  public List<CustomerPlatformTypeEnum> supportEnumerations() {
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
  public CustomerPlatformTypeEnum mapFromCode(int code) {
    if (this.code == code) {
      return this;
    }

    return  CODE_2_ENUM_MAP.getOrDefault(code, NA);
  }

  @Override
  public CustomerPlatformTypeEnum mapFromName(String name) {
    if (name == null || name.isEmpty()) {
      return NA;
    }

    return NAME_2_ENUM_MAP.getOrDefault(name, NA);
  }
}
