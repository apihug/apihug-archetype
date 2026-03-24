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
   * CustomerAuthService : ============ 客户认证 API ============
   * 客户认证服务，提供登录登出功能
   */
  public final RadApiContext customerAuthService(final Consumer<CustomerAuthService> consumer) {
    final CustomerAuthService svc = new CustomerAuthService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * CustomerService : ============ 客户服务 API ============
   * 客户服务，提供当前客户信息查询、组织管理等功能
   */
  public final RadApiContext customerService(final Consumer<CustomerService> consumer) {
    final CustomerService svc = new CustomerService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * CustomerManagementService : ============ 客户管理 API ============
   * 客户管理服务，提供客户 CRUD 和搜索功能
   */
  public final RadApiContext customerManagementService(
      final Consumer<CustomerManagementService> consumer) {
    final CustomerManagementService svc = new CustomerManagementService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * DepartmentService : ============ 部门管理 API ============
   * 部门管理服务，提供部门 CRUD 和树形查询功能
   */
  public final RadApiContext departmentService(final Consumer<DepartmentService> consumer) {
    final DepartmentService svc = new DepartmentService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * DepartmentEmployeeService : ============ 部门员工管理 API ============
   * 部门员工管理服务，提供员工部门关联功能
   */
  public final RadApiContext departmentEmployeeService(
      final Consumer<DepartmentEmployeeService> consumer) {
    final DepartmentEmployeeService svc = new DepartmentEmployeeService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * MenuService : ============ 菜单管理 API ============
   * 菜单管理服务，提供菜单 CRUD 和树形查询功能
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
   * OrganizationService : ============ 组织管理 API ============
   * 组织管理服务，提供组织树、部门树查询等功能
   */
  public final RadApiContext organizationService(final Consumer<OrganizationService> consumer) {
    final OrganizationService svc = new OrganizationService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * CustomerOrganizationService : ============ 组织员工管理 API ============
   * 组织员工管理服务，提供员工 - 组织关系管理功能
   */
  public final RadApiContext customerOrganizationService(
      final Consumer<CustomerOrganizationService> consumer) {
    final CustomerOrganizationService svc = new CustomerOrganizationService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * PermissionService : ============ 权限管理 API ============
   * 权限管理服务，提供权限查询和聚合功能
   */
  public final RadApiContext permissionService(final Consumer<PermissionService> consumer) {
    final PermissionService svc = new PermissionService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * RoleService : ============ 角色管理 API ============
   * 角色管理服务，提供角色 CRUD 和权限分配功能
   */
  public final RadApiContext roleService(final Consumer<RoleService> consumer) {
    final RoleService svc = new RoleService();
    consumer.accept(svc);
    svc.done();
    return RadApiContext.this;
  }

  /**
   * TenantService : ============ 租户管理 API ============
   * 租户管理服务，提供租户 CRUD 和配置功能
   */
  public final RadApiContext tenantService(final Consumer<TenantService> consumer) {
    final TenantService svc = new TenantService();
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
       * Include GetAccessLogStats : Are u sure
       */
      public final AccessLogService GetAccessLogStats() {
        AccessLogService.this.include("GetAccessLogStats");
        return AccessLogService.this;
      }

      /**
       * Exclude GetAccessLogStats : Are u sure
       */
      public final AccessLogService _GetAccessLogStats() {
        AccessLogService.this.exclude("GetAccessLogStats");
        return AccessLogService.this;
      }
    }
  }

  /**
   * ============ 客户认证 API ============
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
   * ============ 客户服务 API ============
   * 客户服务，提供当前客户信息查询、组织管理等功能
   */
  public final class CustomerService extends ApiServiceContextBuilder<CustomerService, RadApiContext> {
    public CustomerService() {
      super(RadApiContext.this);
      all.add("Info");
      all.add("GetCurrentUserInfo");
      all.add("GetUserOrganizations");
      all.add("SwitchOrganization");
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
       * Include GetCurrentUserInfo
       */
      public final CustomerService GetCurrentUserInfo() {
        CustomerService.this.include("GetCurrentUserInfo");
        return CustomerService.this;
      }

      /**
       * Exclude GetCurrentUserInfo
       */
      public final CustomerService _GetCurrentUserInfo() {
        CustomerService.this.exclude("GetCurrentUserInfo");
        return CustomerService.this;
      }

      /**
       * Include GetUserOrganizations
       */
      public final CustomerService GetUserOrganizations() {
        CustomerService.this.include("GetUserOrganizations");
        return CustomerService.this;
      }

      /**
       * Exclude GetUserOrganizations
       */
      public final CustomerService _GetUserOrganizations() {
        CustomerService.this.exclude("GetUserOrganizations");
        return CustomerService.this;
      }

      /**
       * Include SwitchOrganization
       */
      public final CustomerService SwitchOrganization() {
        CustomerService.this.include("SwitchOrganization");
        return CustomerService.this;
      }

      /**
       * Exclude SwitchOrganization
       */
      public final CustomerService _SwitchOrganization() {
        CustomerService.this.exclude("SwitchOrganization");
        return CustomerService.this;
      }
    }
  }

  /**
   * ============ 客户管理 API ============
   * 客户管理服务，提供客户 CRUD 和搜索功能
   */
  public final class CustomerManagementService extends ApiServiceContextBuilder<CustomerManagementService, RadApiContext> {
    public CustomerManagementService() {
      super(RadApiContext.this);
      all.add("CreateCustomer");
      all.add("GetCustomer");
      all.add("UpdateCustomer");
      all.add("DeleteCustomer");
      all.add("SearchCustomers");
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
       * Include GetCustomer
       */
      public final CustomerManagementService GetCustomer() {
        CustomerManagementService.this.include("GetCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Exclude GetCustomer
       */
      public final CustomerManagementService _GetCustomer() {
        CustomerManagementService.this.exclude("GetCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Include UpdateCustomer
       */
      public final CustomerManagementService UpdateCustomer() {
        CustomerManagementService.this.include("UpdateCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Exclude UpdateCustomer
       */
      public final CustomerManagementService _UpdateCustomer() {
        CustomerManagementService.this.exclude("UpdateCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Include DeleteCustomer
       */
      public final CustomerManagementService DeleteCustomer() {
        CustomerManagementService.this.include("DeleteCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Exclude DeleteCustomer
       */
      public final CustomerManagementService _DeleteCustomer() {
        CustomerManagementService.this.exclude("DeleteCustomer");
        return CustomerManagementService.this;
      }

      /**
       * Include SearchCustomers
       */
      public final CustomerManagementService SearchCustomers() {
        CustomerManagementService.this.include("SearchCustomers");
        return CustomerManagementService.this;
      }

      /**
       * Exclude SearchCustomers
       */
      public final CustomerManagementService _SearchCustomers() {
        CustomerManagementService.this.exclude("SearchCustomers");
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
   * ============ 部门管理 API ============
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
   * ============ 部门员工管理 API ============
   * 部门员工管理服务，提供员工部门关联功能
   */
  public final class DepartmentEmployeeService extends ApiServiceContextBuilder<DepartmentEmployeeService, RadApiContext> {
    public DepartmentEmployeeService() {
      super(RadApiContext.this);
      all.add("AddEmployeeToDepartment");
      all.add("RemoveEmployeeFromDepartment");
      all.add("TransferEmployee");
      all.add("GetDepartmentEmployees");
    }

    public DepartmentEmployeeService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return DepartmentEmployeeService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.department.DepartmentEmployeeService";
    }

    public class Methods {
      /**
       * Include AddEmployeeToDepartment
       */
      public final DepartmentEmployeeService AddEmployeeToDepartment() {
        DepartmentEmployeeService.this.include("AddEmployeeToDepartment");
        return DepartmentEmployeeService.this;
      }

      /**
       * Exclude AddEmployeeToDepartment
       */
      public final DepartmentEmployeeService _AddEmployeeToDepartment() {
        DepartmentEmployeeService.this.exclude("AddEmployeeToDepartment");
        return DepartmentEmployeeService.this;
      }

      /**
       * Include RemoveEmployeeFromDepartment
       */
      public final DepartmentEmployeeService RemoveEmployeeFromDepartment() {
        DepartmentEmployeeService.this.include("RemoveEmployeeFromDepartment");
        return DepartmentEmployeeService.this;
      }

      /**
       * Exclude RemoveEmployeeFromDepartment
       */
      public final DepartmentEmployeeService _RemoveEmployeeFromDepartment() {
        DepartmentEmployeeService.this.exclude("RemoveEmployeeFromDepartment");
        return DepartmentEmployeeService.this;
      }

      /**
       * Include TransferEmployee
       */
      public final DepartmentEmployeeService TransferEmployee() {
        DepartmentEmployeeService.this.include("TransferEmployee");
        return DepartmentEmployeeService.this;
      }

      /**
       * Exclude TransferEmployee
       */
      public final DepartmentEmployeeService _TransferEmployee() {
        DepartmentEmployeeService.this.exclude("TransferEmployee");
        return DepartmentEmployeeService.this;
      }

      /**
       * Include GetDepartmentEmployees
       */
      public final DepartmentEmployeeService GetDepartmentEmployees() {
        DepartmentEmployeeService.this.include("GetDepartmentEmployees");
        return DepartmentEmployeeService.this;
      }

      /**
       * Exclude GetDepartmentEmployees
       */
      public final DepartmentEmployeeService _GetDepartmentEmployees() {
        DepartmentEmployeeService.this.exclude("GetDepartmentEmployees");
        return DepartmentEmployeeService.this;
      }
    }
  }

  /**
   * ============ 菜单管理 API ============
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
   * ============ 组织管理 API ============
   * 组织管理服务，提供组织树、部门树查询等功能
   */
  public final class OrganizationService extends ApiServiceContextBuilder<OrganizationService, RadApiContext> {
    public OrganizationService() {
      super(RadApiContext.this);
      all.add("GetOrganizationTree");
      all.add("GetDepartmentTree");
      all.add("GetUserDepartments");
      all.add("GetUserOrganizations");
      all.add("SetDefaultOrganization");
    }

    public OrganizationService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return OrganizationService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.organization.OrganizationService";
    }

    public class Methods {
      /**
       * Include GetOrganizationTree
       */
      public final OrganizationService GetOrganizationTree() {
        OrganizationService.this.include("GetOrganizationTree");
        return OrganizationService.this;
      }

      /**
       * Exclude GetOrganizationTree
       */
      public final OrganizationService _GetOrganizationTree() {
        OrganizationService.this.exclude("GetOrganizationTree");
        return OrganizationService.this;
      }

      /**
       * Include GetDepartmentTree
       */
      public final OrganizationService GetDepartmentTree() {
        OrganizationService.this.include("GetDepartmentTree");
        return OrganizationService.this;
      }

      /**
       * Exclude GetDepartmentTree
       */
      public final OrganizationService _GetDepartmentTree() {
        OrganizationService.this.exclude("GetDepartmentTree");
        return OrganizationService.this;
      }

      /**
       * Include GetUserDepartments
       */
      public final OrganizationService GetUserDepartments() {
        OrganizationService.this.include("GetUserDepartments");
        return OrganizationService.this;
      }

      /**
       * Exclude GetUserDepartments
       */
      public final OrganizationService _GetUserDepartments() {
        OrganizationService.this.exclude("GetUserDepartments");
        return OrganizationService.this;
      }

      /**
       * Include GetUserOrganizations : 获取当前用户的组织列表
       */
      public final OrganizationService GetUserOrganizations() {
        OrganizationService.this.include("GetUserOrganizations");
        return OrganizationService.this;
      }

      /**
       * Exclude GetUserOrganizations : 获取当前用户的组织列表
       */
      public final OrganizationService _GetUserOrganizations() {
        OrganizationService.this.exclude("GetUserOrganizations");
        return OrganizationService.this;
      }

      /**
       * Include SetDefaultOrganization : 设置默认组织
       */
      public final OrganizationService SetDefaultOrganization() {
        OrganizationService.this.include("SetDefaultOrganization");
        return OrganizationService.this;
      }

      /**
       * Exclude SetDefaultOrganization : 设置默认组织
       */
      public final OrganizationService _SetDefaultOrganization() {
        OrganizationService.this.exclude("SetDefaultOrganization");
        return OrganizationService.this;
      }
    }
  }

  /**
   * ============ 组织员工管理 API ============
   * 组织员工管理服务，提供员工 - 组织关系管理功能
   */
  public final class CustomerOrganizationService extends ApiServiceContextBuilder<CustomerOrganizationService, RadApiContext> {
    public CustomerOrganizationService() {
      super(RadApiContext.this);
      all.add("GetOrganizationMembers");
      all.add("AddMemberToOrganization");
      all.add("RemoveMemberFromOrganization");
      all.add("ToggleMemberLock");
      all.add("AssignMemberRoles");
      all.add("AssignMemberMenus");
    }

    public CustomerOrganizationService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return CustomerOrganizationService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.organization.CustomerOrganizationService";
    }

    public class Methods {
      /**
       * Include GetOrganizationMembers : 获取组织员工列表 - 使用 pageable: true，返回单个对象，框架自动包装成 Page
       */
      public final CustomerOrganizationService GetOrganizationMembers() {
        CustomerOrganizationService.this.include("GetOrganizationMembers");
        return CustomerOrganizationService.this;
      }

      /**
       * Exclude GetOrganizationMembers : 获取组织员工列表 - 使用 pageable: true，返回单个对象，框架自动包装成 Page
       */
      public final CustomerOrganizationService _GetOrganizationMembers() {
        CustomerOrganizationService.this.exclude("GetOrganizationMembers");
        return CustomerOrganizationService.this;
      }

      /**
       * Include AddMemberToOrganization : 添加员工到组织
       */
      public final CustomerOrganizationService AddMemberToOrganization() {
        CustomerOrganizationService.this.include("AddMemberToOrganization");
        return CustomerOrganizationService.this;
      }

      /**
       * Exclude AddMemberToOrganization : 添加员工到组织
       */
      public final CustomerOrganizationService _AddMemberToOrganization() {
        CustomerOrganizationService.this.exclude("AddMemberToOrganization");
        return CustomerOrganizationService.this;
      }

      /**
       * Include RemoveMemberFromOrganization : 从组织移除员工
       */
      public final CustomerOrganizationService RemoveMemberFromOrganization() {
        CustomerOrganizationService.this.include("RemoveMemberFromOrganization");
        return CustomerOrganizationService.this;
      }

      /**
       * Exclude RemoveMemberFromOrganization : 从组织移除员工
       */
      public final CustomerOrganizationService _RemoveMemberFromOrganization() {
        CustomerOrganizationService.this.exclude("RemoveMemberFromOrganization");
        return CustomerOrganizationService.this;
      }

      /**
       * Include ToggleMemberLock : 锁定/解锁员工
       */
      public final CustomerOrganizationService ToggleMemberLock() {
        CustomerOrganizationService.this.include("ToggleMemberLock");
        return CustomerOrganizationService.this;
      }

      /**
       * Exclude ToggleMemberLock : 锁定/解锁员工
       */
      public final CustomerOrganizationService _ToggleMemberLock() {
        CustomerOrganizationService.this.exclude("ToggleMemberLock");
        return CustomerOrganizationService.this;
      }

      /**
       * Include AssignMemberRoles : 配置员工角色
       */
      public final CustomerOrganizationService AssignMemberRoles() {
        CustomerOrganizationService.this.include("AssignMemberRoles");
        return CustomerOrganizationService.this;
      }

      /**
       * Exclude AssignMemberRoles : 配置员工角色
       */
      public final CustomerOrganizationService _AssignMemberRoles() {
        CustomerOrganizationService.this.exclude("AssignMemberRoles");
        return CustomerOrganizationService.this;
      }

      /**
       * Include AssignMemberMenus : 配置员工菜单权限
       */
      public final CustomerOrganizationService AssignMemberMenus() {
        CustomerOrganizationService.this.include("AssignMemberMenus");
        return CustomerOrganizationService.this;
      }

      /**
       * Exclude AssignMemberMenus : 配置员工菜单权限
       */
      public final CustomerOrganizationService _AssignMemberMenus() {
        CustomerOrganizationService.this.exclude("AssignMemberMenus");
        return CustomerOrganizationService.this;
      }
    }
  }

  /**
   * ============ 权限管理 API ============
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
       * Include GetRolePermissions : 获取用户的角色权限集合
       */
      public final PermissionService GetRolePermissions() {
        PermissionService.this.include("GetRolePermissions");
        return PermissionService.this;
      }

      /**
       * Exclude GetRolePermissions : 获取用户的角色权限集合
       */
      public final PermissionService _GetRolePermissions() {
        PermissionService.this.exclude("GetRolePermissions");
        return PermissionService.this;
      }

      /**
       * Include GetMenuPermissions : 获取用户的菜单权限集合
       */
      public final PermissionService GetMenuPermissions() {
        PermissionService.this.include("GetMenuPermissions");
        return PermissionService.this;
      }

      /**
       * Exclude GetMenuPermissions : 获取用户的菜单权限集合
       */
      public final PermissionService _GetMenuPermissions() {
        PermissionService.this.exclude("GetMenuPermissions");
        return PermissionService.this;
      }

      /**
       * Include GetAllPermissions : 获取用户的所有权限（角色权限 ∪ 菜单权限）
       */
      public final PermissionService GetAllPermissions() {
        PermissionService.this.include("GetAllPermissions");
        return PermissionService.this;
      }

      /**
       * Exclude GetAllPermissions : 获取用户的所有权限（角色权限 ∪ 菜单权限）
       */
      public final PermissionService _GetAllPermissions() {
        PermissionService.this.exclude("GetAllPermissions");
        return PermissionService.this;
      }
    }
  }

  /**
   * ============ 角色管理 API ============
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
      all.add("AssignPermissions");
      all.add("RemovePermission");
      all.add("GetRolePermissions");
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
       * Include AssignPermissions
       */
      public final RoleService AssignPermissions() {
        RoleService.this.include("AssignPermissions");
        return RoleService.this;
      }

      /**
       * Exclude AssignPermissions
       */
      public final RoleService _AssignPermissions() {
        RoleService.this.exclude("AssignPermissions");
        return RoleService.this;
      }

      /**
       * Include RemovePermission
       */
      public final RoleService RemovePermission() {
        RoleService.this.include("RemovePermission");
        return RoleService.this;
      }

      /**
       * Exclude RemovePermission
       */
      public final RoleService _RemovePermission() {
        RoleService.this.exclude("RemovePermission");
        return RoleService.this;
      }

      /**
       * Include GetRolePermissions
       */
      public final RoleService GetRolePermissions() {
        RoleService.this.include("GetRolePermissions");
        return RoleService.this;
      }

      /**
       * Exclude GetRolePermissions
       */
      public final RoleService _GetRolePermissions() {
        RoleService.this.exclude("GetRolePermissions");
        return RoleService.this;
      }
    }
  }

  /**
   * ============ 租户管理 API ============
   * 租户管理服务，提供租户 CRUD 和配置功能
   */
  public final class TenantService extends ApiServiceContextBuilder<TenantService, RadApiContext> {
    public TenantService() {
      super(RadApiContext.this);
      all.add("CreateTenant");
      all.add("GetTenant");
      all.add("UpdateTenant");
      all.add("DisableTenant");
      all.add("ConfigureTenant");
    }

    public TenantService methods(Consumer<Methods> consumer) {
      final Methods methods = new Methods();
      consumer.accept(methods);
      return TenantService.this;
    }

    @Override
    public String clz() {
      return "com.apihug.rad.api.tenant.TenantService";
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
    }
  }
}
