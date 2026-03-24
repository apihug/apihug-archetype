// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis;

import com.apihug.rad.domain.audit.dsl.AccessLogEntityDSL;
import com.apihug.rad.domain.bootstrap.mybatis.type.CustomerOrgStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.CustomerStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.DeptStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.EmployeeTypeEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.MenuStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.MenuTypeEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.OrganizationStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.RoleStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.bootstrap.mybatis.type.TenantStatusEnumTitleTypeHandler;
import com.apihug.rad.domain.customer.dsl.CustomerEntityDSL;
import com.apihug.rad.domain.department.dsl.DepartmentEmployeeEntityDSL;
import com.apihug.rad.domain.department.dsl.DepartmentEntityDSL;
import com.apihug.rad.domain.menu.dsl.MenuEntityDSL;
import com.apihug.rad.domain.organization.dsl.CustomerOrganizationEntityDSL;
import com.apihug.rad.domain.organization.dsl.OrganizationEntityDSL;
import com.apihug.rad.domain.role.dsl.RoleEntityDSL;
import com.apihug.rad.domain.tenant.dsl.TenantEntityDSL;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import com.apihug.rad.infra.department.DeptStatusEnum;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
import com.apihug.rad.infra.organization.EmployeeTypeEnum;
import com.apihug.rad.infra.organization.OrganizationStatusEnum;
import com.apihug.rad.infra.role.RoleStatusEnum;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.spring.data.persistence.mybatis.AnalystHelper;
import hope.common.spring.data.persistence.wire.Wirer.Known;
import hope.common.spring.data.persistence.wire.Wirer.Mixer;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

@Generated("H.O.P.E. Infra Team")
public interface RadDatabase {
  RadDatabase.AccessLogEntity SYS_ACCESS_LOG = new AccessLogEntity();

  Supplier<RadDatabase.AccessLogEntity> SYS_ACCESS_LOG_ALIAS = AccessLogEntity::new;

  RadDatabase.CustomerEntity SYS_CUSTOMER = new CustomerEntity();

  Supplier<RadDatabase.CustomerEntity> SYS_CUSTOMER_ALIAS = CustomerEntity::new;

  RadDatabase.DepartmentEmployeeEntity SYS_DEPARTMENT_EMPLOYEE = new DepartmentEmployeeEntity();

  Supplier<RadDatabase.DepartmentEmployeeEntity> SYS_DEPARTMENT_EMPLOYEE_ALIAS = DepartmentEmployeeEntity::new;

  RadDatabase.DepartmentEntity SYS_DEPARTMENT = new DepartmentEntity();

  Supplier<RadDatabase.DepartmentEntity> SYS_DEPARTMENT_ALIAS = DepartmentEntity::new;

  RadDatabase.MenuEntity SYS_MENU = new MenuEntity();

  Supplier<RadDatabase.MenuEntity> SYS_MENU_ALIAS = MenuEntity::new;

  RadDatabase.CustomerOrganizationEntity SYS_CUSTOMER_ORGANIZATION = new CustomerOrganizationEntity();

  Supplier<RadDatabase.CustomerOrganizationEntity> SYS_CUSTOMER_ORGANIZATION_ALIAS = CustomerOrganizationEntity::new;

  RadDatabase.OrganizationEntity SYS_ORGANIZATION = new OrganizationEntity();

  Supplier<RadDatabase.OrganizationEntity> SYS_ORGANIZATION_ALIAS = OrganizationEntity::new;

  RadDatabase.RoleEntity SYS_ROLE = new RoleEntity();

  Supplier<RadDatabase.RoleEntity> SYS_ROLE_ALIAS = RoleEntity::new;

  RadDatabase.TenantEntity SYS_TENANT = new TenantEntity();

  Supplier<RadDatabase.TenantEntity> SYS_TENANT_ALIAS = TenantEntity::new;

  final class AccessLogEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<String> HttpMethod = AnalystHelper.mapper(AccessLogEntityDSL.Domain.HttpMethod, this);

    public final SqlColumn<String> RequestPath = AnalystHelper.mapper(AccessLogEntityDSL.Domain.RequestPath, this);

    public final SqlColumn<String> RequestParams = AnalystHelper.mapper(AccessLogEntityDSL.Domain.RequestParams, this);

    public final SqlColumn<Integer> ResponseStatus = AnalystHelper.mapper(AccessLogEntityDSL.Domain.ResponseStatus, this);

    public final SqlColumn<Long> StartEpochTs = AnalystHelper.mapper(AccessLogEntityDSL.Domain.StartEpochTs, this);

    public final SqlColumn<Long> DurationMs = AnalystHelper.mapper(AccessLogEntityDSL.Domain.DurationMs, this);

    public final SqlColumn<Long> CustomerId = AnalystHelper.mapper(AccessLogEntityDSL.Domain.CustomerId, this);

    public final SqlColumn<String> IpAddress = AnalystHelper.mapper(AccessLogEntityDSL.Domain.IpAddress, this);

    public final SqlColumn<String> UserAgent = AnalystHelper.mapper(AccessLogEntityDSL.Domain.UserAgent, this);

    public final SqlColumn<String> ServiceName = AnalystHelper.mapper(AccessLogEntityDSL.Domain.ServiceName, this);

    public final SqlColumn<String> MethodName = AnalystHelper.mapper(AccessLogEntityDSL.Domain.MethodName, this);

    public final SqlColumn<String> ErrorCode = AnalystHelper.mapper(AccessLogEntityDSL.Domain.ErrorCode, this);

    public final SqlColumn<String> ErrorMessage = AnalystHelper.mapper(AccessLogEntityDSL.Domain.ErrorMessage, this);

    public final SqlColumn<String> Channel = AnalystHelper.mapper(AccessLogEntityDSL.Domain.Channel, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(AccessLogEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(AccessLogEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<String> Priority = AnalystHelper.mapper(AccessLogEntityDSL.Domain.Priority, this);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(AccessLogEntityDSL.Domain.Id, this);

    public final SqlColumn<Long> TenantId = AnalystHelper.mapper(AccessLogEntityDSL.Domain.TenantId, this);

    public AccessLogEntity() {
      super("SYS_ACCESS_LOG");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return false;
    }

    public boolean isSoftDeletable() {
      return false;
    }

    public boolean isVersionable() {
      return false;
    }

    public boolean isTenantable() {
      return true;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(HttpMethod);
          res.add(RequestPath);
          res.add(RequestParams);
          res.add(ResponseStatus);
          res.add(StartEpochTs);
          res.add(DurationMs);
          res.add(CustomerId);
          res.add(IpAddress);
          res.add(UserAgent);
          res.add(ServiceName);
          res.add(MethodName);
          res.add(ErrorCode);
          res.add(ErrorMessage);
          res.add(Channel);
          res.add(CreatedBy);
          res.add(CreatedAt);
          res.add(Priority);
        }
        if(kind.tenantIncluded()) {
          res.add(TenantId);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class CustomerEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<Long> DefaultTenantId = AnalystHelper.mapper(CustomerEntityDSL.Domain.DefaultTenantId, this);

    public final SqlColumn<String> Username = AnalystHelper.mapper(CustomerEntityDSL.Domain.Username, this);

    public final SqlColumn<String> PasswordHash = AnalystHelper.mapper(CustomerEntityDSL.Domain.PasswordHash, this);

    public final SqlColumn<String> Email = AnalystHelper.mapper(CustomerEntityDSL.Domain.Email, this);

    public final SqlColumn<CustomerStatusEnum> Status = AnalystHelper.mapper(CustomerEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.CustomerStatusEnumTitleTypeHandler", CustomerStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Long> DefaultOrganizationId = AnalystHelper.mapper(CustomerEntityDSL.Domain.DefaultOrganizationId, this);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(CustomerEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(CustomerEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(CustomerEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(CustomerEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(CustomerEntityDSL.Domain.UpdatedBy, this);

    public final SqlColumn<Boolean> Deleted = AnalystHelper.mapper(CustomerEntityDSL.Domain.Deleted, this);

    public final SqlColumn<LocalDateTime> DeletedAt = AnalystHelper.mapper(CustomerEntityDSL.Domain.DeletedAt, this);

    public final SqlColumn<Long> DeletedBy = AnalystHelper.mapper(CustomerEntityDSL.Domain.DeletedBy, this);

    public final SqlColumn<Long> Version = AnalystHelper.mapper(CustomerEntityDSL.Domain.Version, this);

    public final SqlColumn<Long> TenantId = AnalystHelper.mapper(CustomerEntityDSL.Domain.TenantId, this);

    public CustomerEntity() {
      super("SYS_CUSTOMER");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return true;
    }

    public boolean isVersionable() {
      return true;
    }

    public boolean isTenantable() {
      return true;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(DefaultTenantId);
          res.add(Username);
          res.add(PasswordHash);
          res.add(Email);
          res.add(Status);
          res.add(DefaultOrganizationId);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        if(kind.deleteIncluded()) {
          res.add(Deleted);
          res.add(DeletedAt);
          res.add(DeletedBy);
        }
        if(kind.versionIncluded()) {
          res.add(Version);
        }
        if(kind.tenantIncluded()) {
          res.add(TenantId);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class DepartmentEmployeeEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<Long> EmployeeId = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.EmployeeId, this);

    public final SqlColumn<Long> DepartmentId = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.DepartmentId, this);

    public final SqlColumn<String> Position = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.Position, this);

    public final SqlColumn<Boolean> IsPrimary = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.IsPrimary, this);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(DepartmentEmployeeEntityDSL.Domain.UpdatedBy, this);

    public DepartmentEmployeeEntity() {
      super("SYS_DEPARTMENT_EMPLOYEE");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return false;
    }

    public boolean isVersionable() {
      return false;
    }

    public boolean isTenantable() {
      return false;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(EmployeeId);
          res.add(DepartmentId);
          res.add(Position);
          res.add(IsPrimary);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class DepartmentEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<Long> ParentId = AnalystHelper.mapper(DepartmentEntityDSL.Domain.ParentId, this);

    public final SqlColumn<String> DeptCode = AnalystHelper.mapper(DepartmentEntityDSL.Domain.DeptCode, this);

    public final SqlColumn<String> DeptName = AnalystHelper.mapper(DepartmentEntityDSL.Domain.DeptName, this);

    public final SqlColumn<Integer> SortOrder = AnalystHelper.mapper(DepartmentEntityDSL.Domain.SortOrder, this);

    public final SqlColumn<String> ManagerId = AnalystHelper.mapper(DepartmentEntityDSL.Domain.ManagerId, this);

    public final SqlColumn<DeptStatusEnum> Status = AnalystHelper.mapper(DepartmentEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.DeptStatusEnumTitleTypeHandler", DeptStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(DepartmentEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(DepartmentEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(DepartmentEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(DepartmentEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(DepartmentEntityDSL.Domain.UpdatedBy, this);

    public final SqlColumn<Boolean> Deleted = AnalystHelper.mapper(DepartmentEntityDSL.Domain.Deleted, this);

    public final SqlColumn<LocalDateTime> DeletedAt = AnalystHelper.mapper(DepartmentEntityDSL.Domain.DeletedAt, this);

    public final SqlColumn<Long> DeletedBy = AnalystHelper.mapper(DepartmentEntityDSL.Domain.DeletedBy, this);

    public final SqlColumn<Long> Version = AnalystHelper.mapper(DepartmentEntityDSL.Domain.Version, this);

    public final SqlColumn<Long> TenantId = AnalystHelper.mapper(DepartmentEntityDSL.Domain.TenantId, this);

    public DepartmentEntity() {
      super("SYS_DEPARTMENT");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return true;
    }

    public boolean isVersionable() {
      return true;
    }

    public boolean isTenantable() {
      return true;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(ParentId);
          res.add(DeptCode);
          res.add(DeptName);
          res.add(SortOrder);
          res.add(ManagerId);
          res.add(Status);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        if(kind.deleteIncluded()) {
          res.add(Deleted);
          res.add(DeletedAt);
          res.add(DeletedBy);
        }
        if(kind.versionIncluded()) {
          res.add(Version);
        }
        if(kind.tenantIncluded()) {
          res.add(TenantId);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class MenuEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<Long> ParentId = AnalystHelper.mapper(MenuEntityDSL.Domain.ParentId, this);

    public final SqlColumn<String> MenuCode = AnalystHelper.mapper(MenuEntityDSL.Domain.MenuCode, this);

    public final SqlColumn<String> MenuName = AnalystHelper.mapper(MenuEntityDSL.Domain.MenuName, this);

    public final SqlColumn<String> Path = AnalystHelper.mapper(MenuEntityDSL.Domain.Path, this);

    public final SqlColumn<String> Icon = AnalystHelper.mapper(MenuEntityDSL.Domain.Icon, this);

    public final SqlColumn<Integer> SortOrder = AnalystHelper.mapper(MenuEntityDSL.Domain.SortOrder, this);

    public final SqlColumn<MenuTypeEnum> MenuType = AnalystHelper.mapper(MenuEntityDSL.Domain.MenuType, this, "com.apihug.rad.domain.bootstrap.mybatis.type.MenuTypeEnumTitleTypeHandler", MenuTypeEnumTitleTypeHandler.PTC);

    public final SqlColumn<String> PermissionCode = AnalystHelper.mapper(MenuEntityDSL.Domain.PermissionCode, this);

    public final SqlColumn<MenuStatusEnum> Status = AnalystHelper.mapper(MenuEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.MenuStatusEnumTitleTypeHandler", MenuStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(MenuEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(MenuEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(MenuEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(MenuEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(MenuEntityDSL.Domain.UpdatedBy, this);

    public final SqlColumn<Boolean> Deleted = AnalystHelper.mapper(MenuEntityDSL.Domain.Deleted, this);

    public final SqlColumn<LocalDateTime> DeletedAt = AnalystHelper.mapper(MenuEntityDSL.Domain.DeletedAt, this);

    public final SqlColumn<Long> DeletedBy = AnalystHelper.mapper(MenuEntityDSL.Domain.DeletedBy, this);

    public final SqlColumn<Long> Version = AnalystHelper.mapper(MenuEntityDSL.Domain.Version, this);

    public final SqlColumn<Long> TenantId = AnalystHelper.mapper(MenuEntityDSL.Domain.TenantId, this);

    public MenuEntity() {
      super("SYS_MENU");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return true;
    }

    public boolean isVersionable() {
      return true;
    }

    public boolean isTenantable() {
      return true;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(ParentId);
          res.add(MenuCode);
          res.add(MenuName);
          res.add(Path);
          res.add(Icon);
          res.add(SortOrder);
          res.add(MenuType);
          res.add(PermissionCode);
          res.add(Status);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        if(kind.deleteIncluded()) {
          res.add(Deleted);
          res.add(DeletedAt);
          res.add(DeletedBy);
        }
        if(kind.versionIncluded()) {
          res.add(Version);
        }
        if(kind.tenantIncluded()) {
          res.add(TenantId);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class CustomerOrganizationEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<Long> CustomerId = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.CustomerId, this);

    public final SqlColumn<Long> OrganizationId = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.OrganizationId, this);

    public final SqlColumn<Boolean> IsDefault = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.IsDefault, this);

    public final SqlColumn<EmployeeTypeEnum> EmployeeType = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.EmployeeType, this, "com.apihug.rad.domain.bootstrap.mybatis.type.EmployeeTypeEnumTitleTypeHandler", EmployeeTypeEnumTitleTypeHandler.PTC);

    public final SqlColumn<CustomerOrgStatusEnum> Status = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.CustomerOrgStatusEnumTitleTypeHandler", CustomerOrgStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Long> DepartmentId = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.DepartmentId, this);

    public final SqlColumn<String> Position = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.Position, this);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(CustomerOrganizationEntityDSL.Domain.UpdatedBy, this);

    public CustomerOrganizationEntity() {
      super("SYS_CUSTOMER_ORGANIZATION");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return false;
    }

    public boolean isVersionable() {
      return false;
    }

    public boolean isTenantable() {
      return false;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(CustomerId);
          res.add(OrganizationId);
          res.add(IsDefault);
          res.add(EmployeeType);
          res.add(Status);
          res.add(DepartmentId);
          res.add(Position);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class OrganizationEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<Long> ParentId = AnalystHelper.mapper(OrganizationEntityDSL.Domain.ParentId, this);

    public final SqlColumn<String> OrganizationCode = AnalystHelper.mapper(OrganizationEntityDSL.Domain.OrganizationCode, this);

    public final SqlColumn<String> OrganizationName = AnalystHelper.mapper(OrganizationEntityDSL.Domain.OrganizationName, this);

    public final SqlColumn<Integer> SortOrder = AnalystHelper.mapper(OrganizationEntityDSL.Domain.SortOrder, this);

    public final SqlColumn<OrganizationStatusEnum> Status = AnalystHelper.mapper(OrganizationEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.OrganizationStatusEnumTitleTypeHandler", OrganizationStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(OrganizationEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(OrganizationEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(OrganizationEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(OrganizationEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(OrganizationEntityDSL.Domain.UpdatedBy, this);

    public final SqlColumn<Boolean> Deleted = AnalystHelper.mapper(OrganizationEntityDSL.Domain.Deleted, this);

    public final SqlColumn<LocalDateTime> DeletedAt = AnalystHelper.mapper(OrganizationEntityDSL.Domain.DeletedAt, this);

    public final SqlColumn<Long> DeletedBy = AnalystHelper.mapper(OrganizationEntityDSL.Domain.DeletedBy, this);

    public final SqlColumn<Long> Version = AnalystHelper.mapper(OrganizationEntityDSL.Domain.Version, this);

    public final SqlColumn<Long> TenantId = AnalystHelper.mapper(OrganizationEntityDSL.Domain.TenantId, this);

    public OrganizationEntity() {
      super("SYS_ORGANIZATION");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return true;
    }

    public boolean isVersionable() {
      return true;
    }

    public boolean isTenantable() {
      return true;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(ParentId);
          res.add(OrganizationCode);
          res.add(OrganizationName);
          res.add(SortOrder);
          res.add(Status);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        if(kind.deleteIncluded()) {
          res.add(Deleted);
          res.add(DeletedAt);
          res.add(DeletedBy);
        }
        if(kind.versionIncluded()) {
          res.add(Version);
        }
        if(kind.tenantIncluded()) {
          res.add(TenantId);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class RoleEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<String> RoleCode = AnalystHelper.mapper(RoleEntityDSL.Domain.RoleCode, this);

    public final SqlColumn<String> RoleName = AnalystHelper.mapper(RoleEntityDSL.Domain.RoleName, this);

    public final SqlColumn<String> Description = AnalystHelper.mapper(RoleEntityDSL.Domain.Description, this);

    public final SqlColumn<RoleStatusEnum> Status = AnalystHelper.mapper(RoleEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.RoleStatusEnumTitleTypeHandler", RoleStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(RoleEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(RoleEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(RoleEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(RoleEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(RoleEntityDSL.Domain.UpdatedBy, this);

    public final SqlColumn<Boolean> Deleted = AnalystHelper.mapper(RoleEntityDSL.Domain.Deleted, this);

    public final SqlColumn<LocalDateTime> DeletedAt = AnalystHelper.mapper(RoleEntityDSL.Domain.DeletedAt, this);

    public final SqlColumn<Long> DeletedBy = AnalystHelper.mapper(RoleEntityDSL.Domain.DeletedBy, this);

    public final SqlColumn<Long> Version = AnalystHelper.mapper(RoleEntityDSL.Domain.Version, this);

    public final SqlColumn<Long> TenantId = AnalystHelper.mapper(RoleEntityDSL.Domain.TenantId, this);

    public RoleEntity() {
      super("SYS_ROLE");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return true;
    }

    public boolean isVersionable() {
      return true;
    }

    public boolean isTenantable() {
      return true;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(RoleCode);
          res.add(RoleName);
          res.add(Description);
          res.add(Status);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        if(kind.deleteIncluded()) {
          res.add(Deleted);
          res.add(DeletedAt);
          res.add(DeletedBy);
        }
        if(kind.versionIncluded()) {
          res.add(Version);
        }
        if(kind.tenantIncluded()) {
          res.add(TenantId);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }

  final class TenantEntity extends SqlTable {
    private final List<SqlColumn>[] _CACHE_COLUMN_LIST;

    public final SqlColumn<String> TenantCode = AnalystHelper.mapper(TenantEntityDSL.Domain.TenantCode, this);

    public final SqlColumn<String> TenantName = AnalystHelper.mapper(TenantEntityDSL.Domain.TenantName, this);

    public final SqlColumn<String> ContactEmail = AnalystHelper.mapper(TenantEntityDSL.Domain.ContactEmail, this);

    public final SqlColumn<String> ContactPhone = AnalystHelper.mapper(TenantEntityDSL.Domain.ContactPhone, this);

    public final SqlColumn<TenantStatusEnum> Status = AnalystHelper.mapper(TenantEntityDSL.Domain.Status, this, "com.apihug.rad.domain.bootstrap.mybatis.type.TenantStatusEnumTitleTypeHandler", TenantStatusEnumTitleTypeHandler.PTC);

    public final SqlColumn<Integer> MaxUsers = AnalystHelper.mapper(TenantEntityDSL.Domain.MaxUsers, this);

    public final SqlColumn<Long> MaxStorageMb = AnalystHelper.mapper(TenantEntityDSL.Domain.MaxStorageMb, this);

    public final SqlColumn<LocalDateTime> ExpiryDate = AnalystHelper.mapper(TenantEntityDSL.Domain.ExpiryDate, this);

    public final SqlColumn<Long> Id = AnalystHelper.mapper(TenantEntityDSL.Domain.Id, this);

    public final SqlColumn<LocalDateTime> CreatedAt = AnalystHelper.mapper(TenantEntityDSL.Domain.CreatedAt, this);

    public final SqlColumn<Long> CreatedBy = AnalystHelper.mapper(TenantEntityDSL.Domain.CreatedBy, this);

    public final SqlColumn<LocalDateTime> UpdatedAt = AnalystHelper.mapper(TenantEntityDSL.Domain.UpdatedAt, this);

    public final SqlColumn<Long> UpdatedBy = AnalystHelper.mapper(TenantEntityDSL.Domain.UpdatedBy, this);

    public TenantEntity() {
      super("SYS_TENANT");
      _CACHE_COLUMN_LIST = new List[Known._SIZE_+1];;
    }

    public boolean isIdentifiable() {
      return true;
    }

    public boolean isAuditable() {
      return true;
    }

    public boolean isSoftDeletable() {
      return false;
    }

    public boolean isVersionable() {
      return false;
    }

    public boolean isTenantable() {
      return false;
    }

    public List<SqlColumn> columnsOfDomain() {
      return columnsOf(Known.DOMAIN);
    }

    public List<SqlColumn> columnsOfIdentifiedDomain() {
      return columnsOf(Known.IDENTIFIED_DOMAIN);
    }

    public List<SqlColumn> columnsOfAll() {
      return columnsOf(Known.ALL);
    }

    public List<SqlColumn> columnsOf(Mixer kind) {
      assert kind.good() : "Exceed the range of predefined column composited kind";
      List<SqlColumn> res = _CACHE_COLUMN_LIST[kind.bit()];
      if (res == null) {
        res = new ArrayList<>();
        if (kind.idIncluded()) {
          res.add(Id);
        }
        if (kind.domainIncluded()) {
          res.add(TenantCode);
          res.add(TenantName);
          res.add(ContactEmail);
          res.add(ContactPhone);
          res.add(Status);
          res.add(MaxUsers);
          res.add(MaxStorageMb);
          res.add(ExpiryDate);
        }
        if(kind.auditIncluded()) {
          res.add(CreatedAt);
          res.add(CreatedBy);
          res.add(UpdatedAt);
          res.add(UpdatedBy);
        }
        _CACHE_COLUMN_LIST[kind.bit()] = res;
      }
      return res;
    }
  }
}
