// @formatter:off
package com.apihug.rad.domain.bootstrap.converter;

import com.apihug.rad.domain.bootstrap.mixer.CustomerOrgStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.CustomerStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.DeptStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.EmployeeTypeEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.MenuStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.MenuTypeEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.OrganizationStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.RoleStatusEnumTitleList;
import com.apihug.rad.domain.bootstrap.mixer.TenantStatusEnumTitleList;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.department.DeptStatusEnum;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import com.apihug.rad.infra.organization.EmployeeTypeEnum;
import com.apihug.rad.infra.organization.OrganizationStatusEnum;
import com.apihug.rad.infra.role.RoleStatusEnum;
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
    converters.add(CustomerOrgStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(CustomerOrgStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(CustomerOrgStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(CustomerOrgStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(CustomerStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(CustomerStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(CustomerStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(CustomerStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(DeptStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(DeptStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(DeptStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(DeptStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(EmployeeTypeEnumReaderTitleConverter.INSTANCE);
    converters.add(EmployeeTypeEnumTitleListReaderConverter.INSTANCE);
    converters.add(EmployeeTypeEnumTitleListWriterConverter.INSTANCE);
    converters.add(EmployeeTypeEnumWriterTitleConverter.INSTANCE);
    converters.add(MenuStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(MenuStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(MenuStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(MenuStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(MenuTypeEnumReaderTitleConverter.INSTANCE);
    converters.add(MenuTypeEnumTitleListReaderConverter.INSTANCE);
    converters.add(MenuTypeEnumTitleListWriterConverter.INSTANCE);
    converters.add(MenuTypeEnumWriterTitleConverter.INSTANCE);
    converters.add(OrganizationStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(OrganizationStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(OrganizationStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(OrganizationStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(RoleStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(RoleStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(RoleStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(RoleStatusEnumWriterTitleConverter.INSTANCE);
    converters.add(TenantStatusEnumReaderTitleConverter.INSTANCE);
    converters.add(TenantStatusEnumTitleListReaderConverter.INSTANCE);
    converters.add(TenantStatusEnumTitleListWriterConverter.INSTANCE);
    converters.add(TenantStatusEnumWriterTitleConverter.INSTANCE);
    return converters;
  }

  @ReadingConverter
  public enum CustomerOrgStatusEnumReaderTitleConverter implements Converter<String, CustomerOrgStatusEnum> {
    INSTANCE;

    @Override
    public CustomerOrgStatusEnum convert(String source) {
      return source == null ? CustomerOrgStatusEnum.NA : CustomerOrgStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum CustomerOrgStatusEnumTitleListReaderConverter implements Converter<String, CustomerOrgStatusEnumTitleList> {
    INSTANCE;

    @Override
    public CustomerOrgStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return CustomerOrgStatusEnumTitleList.EMPTY;
      }
      final CustomerOrgStatusEnumTitleList res = new CustomerOrgStatusEnumTitleList();
      for (final String each : source.split(",")) {
        CustomerOrgStatusEnum got = CustomerOrgStatusEnum.NA.mapFromName(each);
        if (CustomerOrgStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum CustomerOrgStatusEnumTitleListWriterConverter implements Converter<CustomerOrgStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(CustomerOrgStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum CustomerOrgStatusEnumWriterTitleConverter implements Converter<CustomerOrgStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(CustomerOrgStatusEnum source) {
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
  public enum EmployeeTypeEnumReaderTitleConverter implements Converter<String, EmployeeTypeEnum> {
    INSTANCE;

    @Override
    public EmployeeTypeEnum convert(String source) {
      return source == null ? EmployeeTypeEnum.NA : EmployeeTypeEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum EmployeeTypeEnumTitleListReaderConverter implements Converter<String, EmployeeTypeEnumTitleList> {
    INSTANCE;

    @Override
    public EmployeeTypeEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return EmployeeTypeEnumTitleList.EMPTY;
      }
      final EmployeeTypeEnumTitleList res = new EmployeeTypeEnumTitleList();
      for (final String each : source.split(",")) {
        EmployeeTypeEnum got = EmployeeTypeEnum.NA.mapFromName(each);
        if (EmployeeTypeEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum EmployeeTypeEnumTitleListWriterConverter implements Converter<EmployeeTypeEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(EmployeeTypeEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum EmployeeTypeEnumWriterTitleConverter implements Converter<EmployeeTypeEnum, String> {
    INSTANCE;

    @Override
    public String convert(EmployeeTypeEnum source) {
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
  public enum OrganizationStatusEnumReaderTitleConverter implements Converter<String, OrganizationStatusEnum> {
    INSTANCE;

    @Override
    public OrganizationStatusEnum convert(String source) {
      return source == null ? OrganizationStatusEnum.NA : OrganizationStatusEnum.NA.mapFromName(source);
    }
  }

  @ReadingConverter
  public enum OrganizationStatusEnumTitleListReaderConverter implements Converter<String, OrganizationStatusEnumTitleList> {
    INSTANCE;

    @Override
    public OrganizationStatusEnumTitleList convert(String source) {
      if (source == null || source.isBlank()) {
        return OrganizationStatusEnumTitleList.EMPTY;
      }
      final OrganizationStatusEnumTitleList res = new OrganizationStatusEnumTitleList();
      for (final String each : source.split(",")) {
        OrganizationStatusEnum got = OrganizationStatusEnum.NA.mapFromName(each);
        if (OrganizationStatusEnum.NA != got) {
          res.add(got);
        }
      }
      return res;
    }
  }

  @WritingConverter
  public enum OrganizationStatusEnumTitleListWriterConverter implements Converter<OrganizationStatusEnumTitleList, String> {
    INSTANCE;

    @Override
    public String convert(OrganizationStatusEnumTitleList source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return source.stream().map(it -> it.name()).collect(Collectors.joining(","));
    }
  }

  @WritingConverter
  public enum OrganizationStatusEnumWriterTitleConverter implements Converter<OrganizationStatusEnum, String> {
    INSTANCE;

    @Override
    public String convert(OrganizationStatusEnum source) {
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
