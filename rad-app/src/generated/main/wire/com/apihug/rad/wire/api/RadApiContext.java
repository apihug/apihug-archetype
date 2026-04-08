// @formatter:off
package com.apihug.rad.wire.api;

import hope.common.service.ApiContext;
import hope.common.service.ApiServiceContextBuilder;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RadApiContext extends ApiContext<RadApiContext> {
  /**
   * AccessLogService : 访问日志服务
   */
  public final RadApiContext accessLogService(final Consumer<AccessLogService> consumer) {
    final AccessLogService svc = new AccessLogService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * CustomerAuthService : 客户认证服务，提供登录登出功能
   */
  public final RadApiContext customerAuthService(final Consumer<CustomerAuthService> consumer) {
    final CustomerAuthService svc = new CustomerAuthService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * CustomerService : 客户服务，提供当前客户信息查询、组织管理等功能
   */
  public final RadApiContext customerService(final Consumer<CustomerService> consumer) {
    final CustomerService svc = new CustomerService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * CustomerManagementService : 客户管理服务，提供客户 CRUD 和搜索功能
   */
  public final RadApiContext customerManagementService(
      final Consumer<CustomerManagementService> consumer) {
    final CustomerManagementService svc = new CustomerManagementService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * DepartmentService : 部门管理服务，提供部门 CRUD 和树形查询功能
   */
  public final RadApiContext departmentService(final Consumer<DepartmentService> consumer) {
    final DepartmentService svc = new DepartmentService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * MenuService : 菜单管理服务，提供菜单 CRUD 和树形查询功能
   */
  public final RadApiContext menuService(final Consumer<MenuService> consumer) {
    final MenuService svc = new MenuService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * ApihugService : apihug meta information
   */
  public final RadApiContext apihugService(final Consumer<ApihugService> consumer) {
    final ApihugService svc = new ApihugService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * PermissionService : 权限管理服务，提供权限查询和聚合功能
   */
  public final RadApiContext permissionService(final Consumer<PermissionService> consumer) {
    final PermissionService svc = new PermissionService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * PlatformService : 平台管理服务，提供平台成员 CRUD 和配置功能
   */
  public final RadApiContext platformService(final Consumer<PlatformService> consumer) {
    final PlatformService svc = new PlatformService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * TenantService : 租户管理服务，提供租户 CRUD 和配置功能（平台级管理）
   */
  public final RadApiContext tenantService(final Consumer<TenantService> consumer) {
    final TenantService svc = new TenantService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * RoleService : 角色管理服务，提供角色 CRUD 和权限分配功能
   */
  public final RadApiContext roleService(final Consumer<RoleService> consumer) {
    final RoleService svc = new RoleService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * TenantMemberService : 租户成员管理服务，提供成员与租户关系管理功能
   */
  public final RadApiContext tenantMemberService(final Consumer<TenantMemberService> consumer) {
    final TenantMemberService svc = new TenantMemberService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  @Override
  public final List<ApiServiceContextBuilder> builders() {
    List<ApiServiceContextBuilder> res  = new ArrayList();
    return res;
  }

  /**
   * 访问日志服务
   */
  public final class AccessLogService extends ApiServiceContextBuilder<AccessLogService, RadApiContext> {
    public AccessLogService() {
      super(RadApiContext.this);
      all.add("QueryAccessLogs");
      all.add("GetAccessLogStats");
    }

    public AccessLogService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return AccessLogService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.audit.AccessLogService";
    }

    public class Methods {
      /**
       * Include QueryAccessLogs
       */
      public final AccessLogService QueryAccessLogs() {
        AccessLogService.this.include("QueryAccessLogs");
        return AccessLogService.this;
      }

      /**
       * Exclude QueryAccessLogs
       */
      public final AccessLogService _QueryAccessLogs() {
        AccessLogService.this.exclude("QueryAccessLogs");
        return AccessLogService.this;
      }

      /**
       * Include GetAccessLogStats
       */
      public final AccessLogService GetAccessLogStats() {
        AccessLogService.this.include("GetAccessLogStats");
        return AccessLogService.this;
      }

      /**
       * Exclude GetAccessLogStats
       */
      public final AccessLogService _GetAccessLogStats() {
        AccessLogService.this.exclude("GetAccessLogStats");
        return AccessLogService.this;
      }
    }
  }

  /**
   * 客户认证服务，提供登录登出功能
   */
  public final class CustomerAuthService extends ApiServiceContextBuilder<CustomerAuthService, RadApiContext> {
    public CustomerAuthService() {
      super(RadApiContext.this);
      all.add("Login");
      all.add("Logout");
    }

    public CustomerAuthService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return CustomerAuthService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.customer.CustomerAuthService";
    }

    public class Methods {
      /**
       * Include Login
       */
      public final CustomerAuthService Login() {
        CustomerAuthService.this.include("Login");
        return CustomerAuthService.this;
      }

      /**
       * Exclude Login
       */
      public final CustomerAuthService _Login() {
        CustomerAuthService.this.exclude("Login");
        return CustomerAuthService.this;
      }

      /**
       * Include Logout
       */
      public final CustomerAuthService Logout() {
        CustomerAuthService.this.include("Logout");
        return CustomerAuthService.this;
      }

      /**
       * Exclude Logout
       */
      public final CustomerAuthService _Logout() {
        CustomerAuthService.this.exclude("Logout");
        return CustomerAuthService.this;
      }
    }
  }

  /**
   * 客户服务，提供当前客户信息查询、组织管理等功能
   */
  public final class CustomerService extends ApiServiceContextBuilder<CustomerService, RadApiContext> {
    public CustomerService() {
      super(RadApiContext.this);
      all.add("Info");
      all.add("GetCurrentCustomerInfo");
      all.add("GetCustomerTenants");
      all.add("SwitchTenant");
      all.add("SetDefaultTenant");
    }

    public CustomerService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return CustomerService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.customer.CustomerService";
    }

    public class Methods {
      /**
       * Include Info
       */
      public final CustomerService Info() {
        CustomerService.this.include("Info");
        return CustomerService.this;
      }

      /**
       * Exclude Info
       */
      public final CustomerService _Info() {
        CustomerService.this.exclude("Info");
        return CustomerService.this;
      }

      /**
       * Include GetCurrentCustomerInfo
       */
      public final CustomerService GetCurrentCustomerInfo() {
        CustomerService.this.include("GetCurrentCustomerInfo");
        return CustomerService.this;
      }

      /**
       * Exclude GetCurrentCustomerInfo
       */
      public final CustomerService _GetCurrentCustomerInfo() {
        CustomerService.this.exclude("GetCurrentCustomerInfo");
        return CustomerService.this;
      }

      /**
       * Include GetCustomerTenants
       */
      public final CustomerService GetCustomerTenants() {
        CustomerService.this.include("GetCustomerTenants");
        return CustomerService.this;
      }

      /**
       * Exclude GetCustomerTenants
       */
      public final CustomerService _GetCustomerTenants() {
        CustomerService.this.exclude("GetCustomerTenants");
        return CustomerService.this;
      }

      /**
       * Include SwitchTenant
       */
      public final CustomerService SwitchTenant() {
        CustomerService.this.include("SwitchTenant");
        return CustomerService.this;
      }

      /**
       * Exclude SwitchTenant
       */
      public final CustomerService _SwitchTenant() {
        CustomerService.this.exclude("SwitchTenant");
        return CustomerService.this;
      }

      /**
       * Include SetDefaultTenant
       */
      public final CustomerService SetDefaultTenant() {
        CustomerService.this.include("SetDefaultTenant");
        return CustomerService.this;
      }

      /**
       * Exclude SetDefaultTenant
       */
      public final CustomerService _SetDefaultTenant() {
        CustomerService.this.exclude("SetDefaultTenant");
        return CustomerService.this;
      }
    }
  }

  /**
   * 客户管理服务，提供客户 CRUD 和搜索功能
   */
  public final class CustomerManagementService extends ApiServiceContextBuilder<CustomerManagementService, RadApiContext> {
    public CustomerManagementService() {
      super(RadApiContext.this);
      all.add("CreateCustomer");
      all.add("ForgotPassword");
      all.add("ResetPassword");
    }

    public CustomerManagementService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return CustomerManagementService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.customer.CustomerManagementService";
    }

    public class Methods {
      /**
       * Include CreateCustomer
       */
      public final CustomerManagementService CreateCustomer() {
        CustomerManagementService.this.include("CreateCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Exclude CreateCustomer
       */
      public final CustomerManagementService _CreateCustomer() {
        CustomerManagementService.this.exclude("CreateCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Include ForgotPassword
       */
      public final CustomerManagementService ForgotPassword() {
        CustomerManagementService.this.include("ForgotPassword");
        return CustomerManagementService.this;
      }

      /**
       * Exclude ForgotPassword
       */
      public final CustomerManagementService _ForgotPassword() {
        CustomerManagementService.this.exclude("ForgotPassword");
        return CustomerManagementService.this;
      }

      /**
       * Include ResetPassword
       */
      public final CustomerManagementService ResetPassword() {
        CustomerManagementService.this.include("ResetPassword");
        return CustomerManagementService.this;
      }

      /**
       * Exclude ResetPassword
       */
      public final CustomerManagementService _ResetPassword() {
        CustomerManagementService.this.exclude("ResetPassword");
        return CustomerManagementService.this;
      }
    }
  }

  /**
   * 部门管理服务，提供部门 CRUD 和树形查询功能
   */
  public final class DepartmentService extends ApiServiceContextBuilder<DepartmentService, RadApiContext> {
    public DepartmentService() {
      super(RadApiContext.this);
      all.add("CreateDepartment");
      all.add("GetDepartment");
      all.add("UpdateDepartment");
      all.add("DeleteDepartment");
      all.add("GetDepartmentTree");
    }

    public DepartmentService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return DepartmentService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.department.DepartmentService";
    }

    public class Methods {
      /**
       * Include CreateDepartment
       */
      public final DepartmentService CreateDepartment() {
        DepartmentService.this.include("CreateDepartment");
        return DepartmentService.this;
      }

      /**
       * Exclude CreateDepartment
       */
      public final DepartmentService _CreateDepartment() {
        DepartmentService.this.exclude("CreateDepartment");
        return DepartmentService.this;
      }

      /**
       * Include GetDepartment
       */
      public final DepartmentService GetDepartment() {
        DepartmentService.this.include("GetDepartment");
        return DepartmentService.this;
      }

      /**
       * Exclude GetDepartment
       */
      public final DepartmentService _GetDepartment() {
        DepartmentService.this.exclude("GetDepartment");
        return DepartmentService.this;
      }

      /**
       * Include UpdateDepartment
       */
      public final DepartmentService UpdateDepartment() {
        DepartmentService.this.include("UpdateDepartment");
        return DepartmentService.this;
      }

      /**
       * Exclude UpdateDepartment
       */
      public final DepartmentService _UpdateDepartment() {
        DepartmentService.this.exclude("UpdateDepartment");
        return DepartmentService.this;
      }

      /**
       * Include DeleteDepartment
       */
      public final DepartmentService DeleteDepartment() {
        DepartmentService.this.include("DeleteDepartment");
        return DepartmentService.this;
      }

      /**
       * Exclude DeleteDepartment
       */
      public final DepartmentService _DeleteDepartment() {
        DepartmentService.this.exclude("DeleteDepartment");
        return DepartmentService.this;
      }

      /**
       * Include GetDepartmentTree
       */
      public final DepartmentService GetDepartmentTree() {
        DepartmentService.this.include("GetDepartmentTree");
        return DepartmentService.this;
      }

      /**
       * Exclude GetDepartmentTree
       */
      public final DepartmentService _GetDepartmentTree() {
        DepartmentService.this.exclude("GetDepartmentTree");
        return DepartmentService.this;
      }
    }
  }

  /**
   * 菜单管理服务，提供菜单 CRUD 和树形查询功能
   */
  public final class MenuService extends ApiServiceContextBuilder<MenuService, RadApiContext> {
    public MenuService() {
      super(RadApiContext.this);
      all.add("CreateMenu");
      all.add("GetMenu");
      all.add("UpdateMenu");
      all.add("DeleteMenu");
      all.add("GetMenuTree");
      all.add("SearchMenus");
    }

    public MenuService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return MenuService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.menu.MenuService";
    }

    public class Methods {
      /**
       * Include CreateMenu
       */
      public final MenuService CreateMenu() {
        MenuService.this.include("CreateMenu");
        return MenuService.this;
      }

      /**
       * Exclude CreateMenu
       */
      public final MenuService _CreateMenu() {
        MenuService.this.exclude("CreateMenu");
        return MenuService.this;
      }

      /**
       * Include GetMenu
       */
      public final MenuService GetMenu() {
        MenuService.this.include("GetMenu");
        return MenuService.this;
      }

      /**
       * Exclude GetMenu
       */
      public final MenuService _GetMenu() {
        MenuService.this.exclude("GetMenu");
        return MenuService.this;
      }

      /**
       * Include UpdateMenu
       */
      public final MenuService UpdateMenu() {
        MenuService.this.include("UpdateMenu");
        return MenuService.this;
      }

      /**
       * Exclude UpdateMenu
       */
      public final MenuService _UpdateMenu() {
        MenuService.this.exclude("UpdateMenu");
        return MenuService.this;
      }

      /**
       * Include DeleteMenu
       */
      public final MenuService DeleteMenu() {
        MenuService.this.include("DeleteMenu");
        return MenuService.this;
      }

      /**
       * Exclude DeleteMenu
       */
      public final MenuService _DeleteMenu() {
        MenuService.this.exclude("DeleteMenu");
        return MenuService.this;
      }

      /**
       * Include GetMenuTree
       */
      public final MenuService GetMenuTree() {
        MenuService.this.include("GetMenuTree");
        return MenuService.this;
      }

      /**
       * Exclude GetMenuTree
       */
      public final MenuService _GetMenuTree() {
        MenuService.this.exclude("GetMenuTree");
        return MenuService.this;
      }

      /**
       * Include SearchMenus
       */
      public final MenuService SearchMenus() {
        MenuService.this.include("SearchMenus");
        return MenuService.this;
      }

      /**
       * Exclude SearchMenus
       */
      public final MenuService _SearchMenus() {
        MenuService.this.exclude("SearchMenus");
        return MenuService.this;
      }
    }
  }

  /**
   * apihug meta information
   */
  public final class ApihugService extends ApiServiceContextBuilder<ApihugService, RadApiContext> {
    public ApihugService() {
      super(RadApiContext.this);
      all.add("Apis");
      all.add("Errors");
      all.add("Authorities");
      all.add("Dictionaries");
      all.add("Entities");
    }

    public ApihugService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return ApihugService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.meta.ApihugService";
    }

    public class Methods {
      /**
       * Include Apis
       */
      public final ApihugService Apis() {
        ApihugService.this.include("Apis");
        return ApihugService.this;
      }

      /**
       * Exclude Apis
       */
      public final ApihugService _Apis() {
        ApihugService.this.exclude("Apis");
        return ApihugService.this;
      }

      /**
       * Include Errors
       */
      public final ApihugService Errors() {
        ApihugService.this.include("Errors");
        return ApihugService.this;
      }

      /**
       * Exclude Errors
       */
      public final ApihugService _Errors() {
        ApihugService.this.exclude("Errors");
        return ApihugService.this;
      }

      /**
       * Include Authorities
       */
      public final ApihugService Authorities() {
        ApihugService.this.include("Authorities");
        return ApihugService.this;
      }

      /**
       * Exclude Authorities
       */
      public final ApihugService _Authorities() {
        ApihugService.this.exclude("Authorities");
        return ApihugService.this;
      }

      /**
       * Include Dictionaries
       */
      public final ApihugService Dictionaries() {
        ApihugService.this.include("Dictionaries");
        return ApihugService.this;
      }

      /**
       * Exclude Dictionaries
       */
      public final ApihugService _Dictionaries() {
        ApihugService.this.exclude("Dictionaries");
        return ApihugService.this;
      }

      /**
       * Include Entities
       */
      public final ApihugService Entities() {
        ApihugService.this.include("Entities");
        return ApihugService.this;
      }

      /**
       * Exclude Entities
       */
      public final ApihugService _Entities() {
        ApihugService.this.exclude("Entities");
        return ApihugService.this;
      }
    }
  }

  /**
   * 权限管理服务，提供权限查询和聚合功能
   */
  public final class PermissionService extends ApiServiceContextBuilder<PermissionService, RadApiContext> {
    public PermissionService() {
      super(RadApiContext.this);
      all.add("GetRolePermissions");
      all.add("GetMenuPermissions");
      all.add("GetAllPermissions");
    }

    public PermissionService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return PermissionService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.permission.PermissionService";
    }

    public class Methods {
      /**
       * Include GetRolePermissions
       */
      public final PermissionService GetRolePermissions() {
        PermissionService.this.include("GetRolePermissions");
        return PermissionService.this;
      }

      /**
       * Exclude GetRolePermissions
       */
      public final PermissionService _GetRolePermissions() {
        PermissionService.this.exclude("GetRolePermissions");
        return PermissionService.this;
      }

      /**
       * Include GetMenuPermissions
       */
      public final PermissionService GetMenuPermissions() {
        PermissionService.this.include("GetMenuPermissions");
        return PermissionService.this;
      }

      /**
       * Exclude GetMenuPermissions
       */
      public final PermissionService _GetMenuPermissions() {
        PermissionService.this.exclude("GetMenuPermissions");
        return PermissionService.this;
      }

      /**
       * Include GetAllPermissions
       */
      public final PermissionService GetAllPermissions() {
        PermissionService.this.include("GetAllPermissions");
        return PermissionService.this;
      }

      /**
       * Exclude GetAllPermissions
       */
      public final PermissionService _GetAllPermissions() {
        PermissionService.this.exclude("GetAllPermissions");
        return PermissionService.this;
      }
    }
  }

  /**
   * 平台管理服务，提供平台成员 CRUD 和配置功能
   */
  public final class PlatformService extends ApiServiceContextBuilder<PlatformService, RadApiContext> {
    public PlatformService() {
      super(RadApiContext.this);
      all.add("GetPlatformMembers");
      all.add("AddPlatformMember");
      all.add("RemovePlatformMember");
      all.add("TogglePlatformMemberFreeze");
      all.add("UpdatePlatformMemberRole");
    }

    public PlatformService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return PlatformService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.platform.PlatformService";
    }

    public class Methods {
      /**
       * Include GetPlatformMembers
       */
      public final PlatformService GetPlatformMembers() {
        PlatformService.this.include("GetPlatformMembers");
        return PlatformService.this;
      }

      /**
       * Exclude GetPlatformMembers
       */
      public final PlatformService _GetPlatformMembers() {
        PlatformService.this.exclude("GetPlatformMembers");
        return PlatformService.this;
      }

      /**
       * Include AddPlatformMember
       */
      public final PlatformService AddPlatformMember() {
        PlatformService.this.include("AddPlatformMember");
        return PlatformService.this;
      }

      /**
       * Exclude AddPlatformMember
       */
      public final PlatformService _AddPlatformMember() {
        PlatformService.this.exclude("AddPlatformMember");
        return PlatformService.this;
      }

      /**
       * Include RemovePlatformMember
       */
      public final PlatformService RemovePlatformMember() {
        PlatformService.this.include("RemovePlatformMember");
        return PlatformService.this;
      }

      /**
       * Exclude RemovePlatformMember
       */
      public final PlatformService _RemovePlatformMember() {
        PlatformService.this.exclude("RemovePlatformMember");
        return PlatformService.this;
      }

      /**
       * Include TogglePlatformMemberFreeze
       */
      public final PlatformService TogglePlatformMemberFreeze() {
        PlatformService.this.include("TogglePlatformMemberFreeze");
        return PlatformService.this;
      }

      /**
       * Exclude TogglePlatformMemberFreeze
       */
      public final PlatformService _TogglePlatformMemberFreeze() {
        PlatformService.this.exclude("TogglePlatformMemberFreeze");
        return PlatformService.this;
      }

      /**
       * Include UpdatePlatformMemberRole
       */
      public final PlatformService UpdatePlatformMemberRole() {
        PlatformService.this.include("UpdatePlatformMemberRole");
        return PlatformService.this;
      }

      /**
       * Exclude UpdatePlatformMemberRole
       */
      public final PlatformService _UpdatePlatformMemberRole() {
        PlatformService.this.exclude("UpdatePlatformMemberRole");
        return PlatformService.this;
      }
    }
  }

  /**
   * 租户管理服务，提供租户 CRUD 和配置功能（平台级管理）
   */
  public final class TenantService extends ApiServiceContextBuilder<TenantService, RadApiContext> {
    public TenantService() {
      super(RadApiContext.this);
      all.add("CreateTenant");
      all.add("GetTenant");
      all.add("UpdateTenant");
      all.add("DisableTenant");
      all.add("ConfigureTenant");
      all.add("SearchTenants");
    }

    public TenantService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return TenantService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.platform.TenantService";
    }

    public class Methods {
      /**
       * Include CreateTenant
       */
      public final TenantService CreateTenant() {
        TenantService.this.include("CreateTenant");
        return TenantService.this;
      }

      /**
       * Exclude CreateTenant
       */
      public final TenantService _CreateTenant() {
        TenantService.this.exclude("CreateTenant");
        return TenantService.this;
      }

      /**
       * Include GetTenant
       */
      public final TenantService GetTenant() {
        TenantService.this.include("GetTenant");
        return TenantService.this;
      }

      /**
       * Exclude GetTenant
       */
      public final TenantService _GetTenant() {
        TenantService.this.exclude("GetTenant");
        return TenantService.this;
      }

      /**
       * Include UpdateTenant
       */
      public final TenantService UpdateTenant() {
        TenantService.this.include("UpdateTenant");
        return TenantService.this;
      }

      /**
       * Exclude UpdateTenant
       */
      public final TenantService _UpdateTenant() {
        TenantService.this.exclude("UpdateTenant");
        return TenantService.this;
      }

      /**
       * Include DisableTenant
       */
      public final TenantService DisableTenant() {
        TenantService.this.include("DisableTenant");
        return TenantService.this;
      }

      /**
       * Exclude DisableTenant
       */
      public final TenantService _DisableTenant() {
        TenantService.this.exclude("DisableTenant");
        return TenantService.this;
      }

      /**
       * Include ConfigureTenant
       */
      public final TenantService ConfigureTenant() {
        TenantService.this.include("ConfigureTenant");
        return TenantService.this;
      }

      /**
       * Exclude ConfigureTenant
       */
      public final TenantService _ConfigureTenant() {
        TenantService.this.exclude("ConfigureTenant");
        return TenantService.this;
      }

      /**
       * Include SearchTenants
       */
      public final TenantService SearchTenants() {
        TenantService.this.include("SearchTenants");
        return TenantService.this;
      }

      /**
       * Exclude SearchTenants
       */
      public final TenantService _SearchTenants() {
        TenantService.this.exclude("SearchTenants");
        return TenantService.this;
      }
    }
  }

  /**
   * 角色管理服务，提供角色 CRUD 和权限分配功能
   */
  public final class RoleService extends ApiServiceContextBuilder<RoleService, RadApiContext> {
    public RoleService() {
      super(RadApiContext.this);
      all.add("CreateRole");
      all.add("GetRole");
      all.add("UpdateRole");
      all.add("DeleteRole");
      all.add("SearchRoles");
      all.add("AssignMenusToRole");
      all.add("RemoveMenuFromRole");
      all.add("GetRoleMenus");
    }

    public RoleService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return RoleService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.role.RoleService";
    }

    public class Methods {
      /**
       * Include CreateRole
       */
      public final RoleService CreateRole() {
        RoleService.this.include("CreateRole");
        return RoleService.this;
      }

      /**
       * Exclude CreateRole
       */
      public final RoleService _CreateRole() {
        RoleService.this.exclude("CreateRole");
        return RoleService.this;
      }

      /**
       * Include GetRole
       */
      public final RoleService GetRole() {
        RoleService.this.include("GetRole");
        return RoleService.this;
      }

      /**
       * Exclude GetRole
       */
      public final RoleService _GetRole() {
        RoleService.this.exclude("GetRole");
        return RoleService.this;
      }

      /**
       * Include UpdateRole
       */
      public final RoleService UpdateRole() {
        RoleService.this.include("UpdateRole");
        return RoleService.this;
      }

      /**
       * Exclude UpdateRole
       */
      public final RoleService _UpdateRole() {
        RoleService.this.exclude("UpdateRole");
        return RoleService.this;
      }

      /**
       * Include DeleteRole
       */
      public final RoleService DeleteRole() {
        RoleService.this.include("DeleteRole");
        return RoleService.this;
      }

      /**
       * Exclude DeleteRole
       */
      public final RoleService _DeleteRole() {
        RoleService.this.exclude("DeleteRole");
        return RoleService.this;
      }

      /**
       * Include SearchRoles
       */
      public final RoleService SearchRoles() {
        RoleService.this.include("SearchRoles");
        return RoleService.this;
      }

      /**
       * Exclude SearchRoles
       */
      public final RoleService _SearchRoles() {
        RoleService.this.exclude("SearchRoles");
        return RoleService.this;
      }

      /**
       * Include AssignMenusToRole
       */
      public final RoleService AssignMenusToRole() {
        RoleService.this.include("AssignMenusToRole");
        return RoleService.this;
      }

      /**
       * Exclude AssignMenusToRole
       */
      public final RoleService _AssignMenusToRole() {
        RoleService.this.exclude("AssignMenusToRole");
        return RoleService.this;
      }

      /**
       * Include RemoveMenuFromRole
       */
      public final RoleService RemoveMenuFromRole() {
        RoleService.this.include("RemoveMenuFromRole");
        return RoleService.this;
      }

      /**
       * Exclude RemoveMenuFromRole
       */
      public final RoleService _RemoveMenuFromRole() {
        RoleService.this.exclude("RemoveMenuFromRole");
        return RoleService.this;
      }

      /**
       * Include GetRoleMenus
       */
      public final RoleService GetRoleMenus() {
        RoleService.this.include("GetRoleMenus");
        return RoleService.this;
      }

      /**
       * Exclude GetRoleMenus
       */
      public final RoleService _GetRoleMenus() {
        RoleService.this.exclude("GetRoleMenus");
        return RoleService.this;
      }
    }
  }

  /**
   * 租户成员管理服务，提供成员与租户关系管理功能
   */
  public final class TenantMemberService extends ApiServiceContextBuilder<TenantMemberService, RadApiContext> {
    public TenantMemberService() {
      super(RadApiContext.this);
      all.add("GetTenantMembers");
      all.add("AddMemberToTenant");
      all.add("RemoveMemberFromTenant");
      all.add("ToggleMemberLock");
      all.add("UpdateMemberRole");
      all.add("AssignMemberDepartment");
      all.add("GetMemberDetail");
      all.add("AssignRolesToMember");
      all.add("GetMemberRoles");
      all.add("RemoveRoleFromMember");
    }

    public TenantMemberService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return TenantMemberService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.tenant.TenantMemberService";
    }

    public class Methods {
      /**
       * Include GetTenantMembers
       */
      public final TenantMemberService GetTenantMembers() {
        TenantMemberService.this.include("GetTenantMembers");
        return TenantMemberService.this;
      }

      /**
       * Exclude GetTenantMembers
       */
      public final TenantMemberService _GetTenantMembers() {
        TenantMemberService.this.exclude("GetTenantMembers");
        return TenantMemberService.this;
      }

      /**
       * Include AddMemberToTenant
       */
      public final TenantMemberService AddMemberToTenant() {
        TenantMemberService.this.include("AddMemberToTenant");
        return TenantMemberService.this;
      }

      /**
       * Exclude AddMemberToTenant
       */
      public final TenantMemberService _AddMemberToTenant() {
        TenantMemberService.this.exclude("AddMemberToTenant");
        return TenantMemberService.this;
      }

      /**
       * Include RemoveMemberFromTenant
       */
      public final TenantMemberService RemoveMemberFromTenant() {
        TenantMemberService.this.include("RemoveMemberFromTenant");
        return TenantMemberService.this;
      }

      /**
       * Exclude RemoveMemberFromTenant
       */
      public final TenantMemberService _RemoveMemberFromTenant() {
        TenantMemberService.this.exclude("RemoveMemberFromTenant");
        return TenantMemberService.this;
      }

      /**
       * Include ToggleMemberLock
       */
      public final TenantMemberService ToggleMemberLock() {
        TenantMemberService.this.include("ToggleMemberLock");
        return TenantMemberService.this;
      }

      /**
       * Exclude ToggleMemberLock
       */
      public final TenantMemberService _ToggleMemberLock() {
        TenantMemberService.this.exclude("ToggleMemberLock");
        return TenantMemberService.this;
      }

      /**
       * Include UpdateMemberRole
       */
      public final TenantMemberService UpdateMemberRole() {
        TenantMemberService.this.include("UpdateMemberRole");
        return TenantMemberService.this;
      }

      /**
       * Exclude UpdateMemberRole
       */
      public final TenantMemberService _UpdateMemberRole() {
        TenantMemberService.this.exclude("UpdateMemberRole");
        return TenantMemberService.this;
      }

      /**
       * Include AssignMemberDepartment
       */
      public final TenantMemberService AssignMemberDepartment() {
        TenantMemberService.this.include("AssignMemberDepartment");
        return TenantMemberService.this;
      }

      /**
       * Exclude AssignMemberDepartment
       */
      public final TenantMemberService _AssignMemberDepartment() {
        TenantMemberService.this.exclude("AssignMemberDepartment");
        return TenantMemberService.this;
      }

      /**
       * Include GetMemberDetail
       */
      public final TenantMemberService GetMemberDetail() {
        TenantMemberService.this.include("GetMemberDetail");
        return TenantMemberService.this;
      }

      /**
       * Exclude GetMemberDetail
       */
      public final TenantMemberService _GetMemberDetail() {
        TenantMemberService.this.exclude("GetMemberDetail");
        return TenantMemberService.this;
      }

      /**
       * Include AssignRolesToMember
       */
      public final TenantMemberService AssignRolesToMember() {
        TenantMemberService.this.include("AssignRolesToMember");
        return TenantMemberService.this;
      }

      /**
       * Exclude AssignRolesToMember
       */
      public final TenantMemberService _AssignRolesToMember() {
        TenantMemberService.this.exclude("AssignRolesToMember");
        return TenantMemberService.this;
      }

      /**
       * Include GetMemberRoles
       */
      public final TenantMemberService GetMemberRoles() {
        TenantMemberService.this.include("GetMemberRoles");
        return TenantMemberService.this;
      }

      /**
       * Exclude GetMemberRoles
       */
      public final TenantMemberService _GetMemberRoles() {
        TenantMemberService.this.exclude("GetMemberRoles");
        return TenantMemberService.this;
      }

      /**
       * Include RemoveRoleFromMember
       */
      public final TenantMemberService RemoveRoleFromMember() {
        TenantMemberService.this.include("RemoveRoleFromMember");
        return TenantMemberService.this;
      }

      /**
       * Exclude RemoveRoleFromMember
       */
      public final TenantMemberService _RemoveRoleFromMember() {
        TenantMemberService.this.exclude("RemoveRoleFromMember");
        return TenantMemberService.this;
      }
    }
  }
}
