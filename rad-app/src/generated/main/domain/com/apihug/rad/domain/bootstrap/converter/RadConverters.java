// @formatter:off
package com.apihug.rad.domain.bootstrap.converter;

import com.apihug.rad.domain.bootstrap.mixer.CustomerPlatformTypeEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.CustomerStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.DeptStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.MemberRoleEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.MemberTypeEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.MenuStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.MenuTypeEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.PlatformMemberStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.RoleStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.TenantMemberStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.TenantStatusEnumTitleList;
import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.department.DeptStatusEnum;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import com.apihug.rad.infra.role.RoleStatusEnum;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

@Generated("H.O.P.E. Infra Team")
public abstract class RadConverters {
  public static List<Converter> getConvertersToRegister() {
    List<Converter> converters = new ArrayList<>();
    converters.add(CustomerPlatformTypeEnumReaderTitleConverter.INSTANCE);
    converters.add(CustomerPlatformTypeEnumTitleListReaderConverter.INSTANCE);
    converters.add(CustomerPlatformTypeEnumTitleListWriterConverter.INSTANCE);
    converters.add(CustomerPlatformTypeEnumWriterTitleConverter.INSTANCE);
    converters.add(CustomerStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(CustomerStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(CustomerStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(CustomerStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(DeptStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(DeptStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(DeptStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(DeptStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(MemberRoleEnumReaderTitleConverter.INSTANCE);
    converters.add(MemberRoleEnumTitleListReaderConverter.INSTANCE);
    converters.add(MemberRoleEnumTitleListWriterConverter.INSTANCE);
    converters.add(MemberRoleEnumWriterTitleConverter.INSTANCE);
    converters.add(MemberTypeEnumReaderTitleConverter.INSTANCE);
    converters.add(MemberTypeEnumTitleListReaderConverter.INSTANCE);
    converters.add(MemberTypeEnumTitleListWriterConverter.INSTANCE);
    converters.add(MemberTypeEnumWriterTitleConverter.INSTANCE);
    converters.add(MenuStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(MenuStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(MenuStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(MenuStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(MenuTypeEnumReaderTitleConverter.INSTANCE);
    converters.add(MenuTypeEnumTitleListReaderConverter.INSTANCE);
    converters.add(MenuTypeEnumTitleListWriterConverter.INSTANCE);
    converters.add(MenuTypeEnumWriterTitleConverter.INSTANCE);
    converters.add(PlatformMemberStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(PlatformMemberStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(PlatformMemberStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(PlatformMemberStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(RoleStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(RoleStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(RoleStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(RoleStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(TenantMemberStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(TenantMemberStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(TenantMemberStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(TenantMemberStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(TenantStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(TenantStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(TenantStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(TenantStatusEnumWriterTitleConverter.INSTANCE);
    return converters;
  }

  @ReadingConverter
  public enum CustomerPlatformTypeEnumReaderTitleConverter implements Converter<String, CustomerPlatformTypeEnum> {
    INSTANCE;

    @Override
    public CustomerPlatformTypeEnum convert(String source) {
      return source == null ? CustomerPlatformTypeEnum.NA : CustomerPlatformTypeEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum CustomerPlatformTypeEnumTitleListReaderConverter implements Converter<String, CustomerPlatformTypeEnumTitleList> {
    INSTANCE;

    @Override
    public CustomerPlatformTypeEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return CustomerPlatformTypeEnumTitleList.EMPTY;
      }
      final CustomerPlatformTypeEnumTitleList res = new CustomerPlatformTypeEnumTitleList();
      for (final String each : source.split(",")) {
        CustomerPlatformTypeEnum got = CustomerPlatformTypeEnum.NA.mapFromName(each);
        if (CustomerPlatformTypeEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum CustomerPlatformTypeEnumTitleListWriterConverter implements Converter<CustomerPlatformTypeEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(CustomerPlatformTypeEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum CustomerPlatformTypeEnumWriterTitleConverter implements Converter<CustomerPlatformTypeEnum, String> {
    INSTANCE;

    @Override
    public String convert(CustomerPlatformTypeEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum CustomerStatusEnumReaderTitleConverter implements Converter<String, CustomerStatusEnum> {
    INSTANCE;

    @Override
    public CustomerStatusEnum convert(String source) {
      return source == null ? CustomerStatusEnum.NA : CustomerStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum CustomerStatusEnumTitleListReaderConverter implements Converter<String, CustomerStatusEnumTitleList> {
    INSTANCE;

    @Override
    public CustomerStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return CustomerStatusEnumTitleList.EMPTY;
      }
      final CustomerStatusEnumTitleList res = new CustomerStatusEnumTitleList();
      for (final String each : source.split(",")) {
        CustomerStatusEnum got = CustomerStatusEnum.NA.mapFromName(each);
        if (CustomerStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum CustomerStatusEnumTitleListWriterConverter implements Converter<CustomerStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(CustomerStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum CustomerStatusEnumWriterTitleConverter implements Converter<CustomerStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(CustomerStatusEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum DeptStatusEnumReaderTitleConverter implements Converter<String, DeptStatusEnum> {
    INSTANCE;

    @Override
    public DeptStatusEnum convert(String source) {
      return source == null ? DeptStatusEnum.NA : DeptStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum DeptStatusEnumTitleListReaderConverter implements Converter<String, DeptStatusEnumTitleList> {
    INSTANCE;

    @Override
    public DeptStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return DeptStatusEnumTitleList.EMPTY;
      }
      final DeptStatusEnumTitleList res = new DeptStatusEnumTitleList();
      for (final String each : source.split(",")) {
        DeptStatusEnum got = DeptStatusEnum.NA.mapFromName(each);
        if (DeptStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum DeptStatusEnumTitleListWriterConverter implements Converter<DeptStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(DeptStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum DeptStatusEnumWriterTitleConverter implements Converter<DeptStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(DeptStatusEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum MemberRoleEnumReaderTitleConverter implements Converter<String, MemberRoleEnum> {
    INSTANCE;

    @Override
    public MemberRoleEnum convert(String source) {
      return source == null ? MemberRoleEnum.NA : MemberRoleEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum MemberRoleEnumTitleListReaderConverter implements Converter<String, MemberRoleEnumTitleList> {
    INSTANCE;

    @Override
    public MemberRoleEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return MemberRoleEnumTitleList.EMPTY;
      }
      final MemberRoleEnumTitleList res = new MemberRoleEnumTitleList();
      for (final String each : source.split(",")) {
        MemberRoleEnum got = MemberRoleEnum.NA.mapFromName(each);
        if (MemberRoleEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum MemberRoleEnumTitleListWriterConverter implements Converter<MemberRoleEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(MemberRoleEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum MemberRoleEnumWriterTitleConverter implements Converter<MemberRoleEnum, String> {
    INSTANCE;

    @Override
    public String convert(MemberRoleEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum MemberTypeEnumReaderTitleConverter implements Converter<String, MemberTypeEnum> {
    INSTANCE;

    @Override
    public MemberTypeEnum convert(String source) {
      return source == null ? MemberTypeEnum.NA : MemberTypeEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum MemberTypeEnumTitleListReaderConverter implements Converter<String, MemberTypeEnumTitleList> {
    INSTANCE;

    @Override
    public MemberTypeEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return MemberTypeEnumTitleList.EMPTY;
      }
      final MemberTypeEnumTitleList res = new MemberTypeEnumTitleList();
      for (final String each : source.split(",")) {
        MemberTypeEnum got = MemberTypeEnum.NA.mapFromName(each);
        if (MemberTypeEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum MemberTypeEnumTitleListWriterConverter implements Converter<MemberTypeEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(MemberTypeEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum MemberTypeEnumWriterTitleConverter implements Converter<MemberTypeEnum, String> {
    INSTANCE;

    @Override
    public String convert(MemberTypeEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum MenuStatusEnumReaderTitleConverter implements Converter<String, MenuStatusEnum> {
    INSTANCE;

    @Override
    public MenuStatusEnum convert(String source) {
      return source == null ? MenuStatusEnum.NA : MenuStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum MenuStatusEnumTitleListReaderConverter implements Converter<String, MenuStatusEnumTitleList> {
    INSTANCE;

    @Override
    public MenuStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return MenuStatusEnumTitleList.EMPTY;
      }
      final MenuStatusEnumTitleList res = new MenuStatusEnumTitleList();
      for (final String each : source.split(",")) {
        MenuStatusEnum got = MenuStatusEnum.NA.mapFromName(each);
        if (MenuStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum MenuStatusEnumTitleListWriterConverter implements Converter<MenuStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(MenuStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum MenuStatusEnumWriterTitleConverter implements Converter<MenuStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(MenuStatusEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum MenuTypeEnumReaderTitleConverter implements Converter<String, MenuTypeEnum> {
    INSTANCE;

    @Override
    public MenuTypeEnum convert(String source) {
      return source == null ? MenuTypeEnum.NA : MenuTypeEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum MenuTypeEnumTitleListReaderConverter implements Converter<String, MenuTypeEnumTitleList> {
    INSTANCE;

    @Override
    public MenuTypeEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return MenuTypeEnumTitleList.EMPTY;
      }
      final MenuTypeEnumTitleList res = new MenuTypeEnumTitleList();
      for (final String each : source.split(",")) {
        MenuTypeEnum got = MenuTypeEnum.NA.mapFromName(each);
        if (MenuTypeEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum MenuTypeEnumTitleListWriterConverter implements Converter<MenuTypeEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(MenuTypeEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum MenuTypeEnumWriterTitleConverter implements Converter<MenuTypeEnum, String> {
    INSTANCE;

    @Override
    public String convert(MenuTypeEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum PlatformMemberStatusEnumReaderTitleConverter implements Converter<String, PlatformMemberStatusEnum> {
    INSTANCE;

    @Override
    public PlatformMemberStatusEnum convert(String source) {
      return source == null ? PlatformMemberStatusEnum.NA : PlatformMemberStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum PlatformMemberStatusEnumTitleListReaderConverter implements Converter<String, PlatformMemberStatusEnumTitleList> {
    INSTANCE;

    @Override
    public PlatformMemberStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return PlatformMemberStatusEnumTitleList.EMPTY;
      }
      final PlatformMemberStatusEnumTitleList res = new PlatformMemberStatusEnumTitleList();
      for (final String each : source.split(",")) {
        PlatformMemberStatusEnum got = PlatformMemberStatusEnum.NA.mapFromName(each);
        if (PlatformMemberStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum PlatformMemberStatusEnumTitleListWriterConverter implements Converter<PlatformMemberStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(PlatformMemberStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum PlatformMemberStatusEnumWriterTitleConverter implements Converter<PlatformMemberStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(PlatformMemberStatusEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum RoleStatusEnumReaderTitleConverter implements Converter<String, RoleStatusEnum> {
    INSTANCE;

    @Override
    public RoleStatusEnum convert(String source) {
      return source == null ? RoleStatusEnum.NA : RoleStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum RoleStatusEnumTitleListReaderConverter implements Converter<String, RoleStatusEnumTitleList> {
    INSTANCE;

    @Override
    public RoleStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return RoleStatusEnumTitleList.EMPTY;
      }
      final RoleStatusEnumTitleList res = new RoleStatusEnumTitleList();
      for (final String each : source.split(",")) {
        RoleStatusEnum got = RoleStatusEnum.NA.mapFromName(each);
        if (RoleStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum RoleStatusEnumTitleListWriterConverter implements Converter<RoleStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(RoleStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum RoleStatusEnumWriterTitleConverter implements Converter<RoleStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(RoleStatusEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum TenantMemberStatusEnumReaderTitleConverter implements Converter<String, TenantMemberStatusEnum> {
    INSTANCE;

    @Override
    public TenantMemberStatusEnum convert(String source) {
      return source == null ? TenantMemberStatusEnum.NA : TenantMemberStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum TenantMemberStatusEnumTitleListReaderConverter implements Converter<String, TenantMemberStatusEnumTitleList> {
    INSTANCE;

    @Override
    public TenantMemberStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return TenantMemberStatusEnumTitleList.EMPTY;
      }
      final TenantMemberStatusEnumTitleList res = new TenantMemberStatusEnumTitleList();
      for (final String each : source.split(",")) {
        TenantMemberStatusEnum got = TenantMemberStatusEnum.NA.mapFromName(each);
        if (TenantMemberStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum TenantMemberStatusEnumTitleListWriterConverter implements Converter<TenantMemberStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(TenantMemberStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum TenantMemberStatusEnumWriterTitleConverter implements Converter<TenantMemberStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(TenantMemberStatusEnum source) {
      return source == null ? null : source.title();
    }
  }

  @ReadingConverter
  public enum TenantStatusEnumReaderTitleConverter implements Converter<String, TenantStatusEnum> {
    INSTANCE;

    @Override
    public TenantStatusEnum convert(String source) {
      return source == null ? TenantStatusEnum.NA : TenantStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum TenantStatusEnumTitleListReaderConverter implements Converter<String, TenantStatusEnumTitleList> {
    INSTANCE;

    @Override
    public TenantStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return TenantStatusEnumTitleList.EMPTY;
      }
      final TenantStatusEnumTitleList res = new TenantStatusEnumTitleList();
      for (final String each : source.split(",")) {
        TenantStatusEnum got = TenantStatusEnum.NA.mapFromName(each);
        if (TenantStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum TenantStatusEnumTitleListWriterConverter implements Converter<TenantStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(TenantStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum TenantStatusEnumWriterTitleConverter implements Converter<TenantStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(TenantStatusEnum source) {
      return source == null ? null : source.title();
    }
  }
}
