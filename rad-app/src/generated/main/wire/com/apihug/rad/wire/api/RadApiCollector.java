// @formatter:off
package com.apihug.rad.wire.api;

import hope.common.proto.constant.Error;
import hope.common.proto.constant.Meta;
import hope.common.proto.mock.Mock;
import hope.common.proto.mock.Nature;
import hope.common.proto.mock.NumberRule;
import hope.common.proto.swagger.Authorization;
import hope.common.proto.swagger.DateFormat;
import hope.common.proto.swagger.JSONSchema;
import hope.common.proto.swagger.Operation;
import hope.common.proto.swagger.Parameter;
import hope.common.proto.swagger.Priority;
import hope.common.proto.swagger.RBAC;
import hope.common.proto.swagger.Schema;
import hope.common.service.Collector;
import hope.common.service.api.Component;
import hope.common.service.api.ComponentItem;
import hope.common.service.api.Service;
import hope.common.service.api.ServiceMethod;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class RadApiCollector implements Collector {
  protected final Map<String, Service> services = new LinkedHashMap();

  protected final Map<String, Component> components = new LinkedHashMap();

  public RadApiCollector() {
    initServices();
    initComponents();
  }

  @Override
  public Map<String, Service> services() {
    return services;
  }

  @Override
  public Map<String, Component> components() {
    return components;
  }

  @Override
  public RadApiContext apiContext() {
    return new RadApiContext();
  }

  void initServiceapi_auditAccessLogService() {
    Service res = new Service();
    res.setDescription("访问日志服务");
    res.setClzName("com.apihug.rad.api.audit.AccessLogService");
    res.setName("AccessLogService");
    res.setProtoFrom("com/apihug/rad/api/audit/api.proto");
    res.setProtoLine(10);
    res.setProtoColumn(1);
    res.setProtoEntity("AccessLogService");
    res.setPath("/access-logs");
    var _QueryAccessLogs = new ServiceMethod();
    _QueryAccessLogs.setName("QueryAccessLogs");
    _QueryAccessLogs.setProtoLine(16);
    _QueryAccessLogs.setProtoColumn(3);
    _QueryAccessLogs.setRequestRef("com.apihug.rad.api.audit.SearchAccessLogsRequest");
    _QueryAccessLogs.setResponseRef("com.apihug.rad.api.audit.AccessLogInfo");
    _QueryAccessLogs.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("access-log"));
        res.setSummary("分页查询HTTP访问审计日志");
        res.setDescription("查询访问日志");
        res.setPageable(true);
        res.setGet("/api/access-logs/query");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _QueryAccessLogs.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _QueryAccessLogs.setPath("/api/access-logs/query");
    res.addItem(_QueryAccessLogs);
    var _GetAccessLogStats = new ServiceMethod();
    _GetAccessLogStats.setName("GetAccessLogStats");
    _GetAccessLogStats.setProtoLine(35);
    _GetAccessLogStats.setProtoColumn(3);
    _GetAccessLogStats.setRequestRef("com.apihug.rad.api.audit.GetAccessLogStatsRequest");
    _GetAccessLogStats.setResponseRef("com.apihug.rad.api.audit.AccessLogStatsResponse");
    _GetAccessLogStats.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("access-log"));
        res.setSummary("获取访问日志统计概览");
        res.setDescription("Are u sure\n"
                + "获取访问统计");
        res.setGet("/api/access-logs/stats");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetAccessLogStats.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetAccessLogStats.setPath("/api/access-logs/stats");
    res.addItem(_GetAccessLogStats);
    services.put("com.apihug.rad.api.audit.AccessLogService", res);
  }

  void initServiceapi_customerCustomerAuthService() {
    Service res = new Service();
    res.setDescription("============ 客户认证 API ============\n"
            + "客户认证服务，提供登录登出功能");
    res.setClzName("com.apihug.rad.api.customer.CustomerAuthService");
    res.setName("CustomerAuthService");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(11);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerAuthService");
    res.setPath("/auth");
    var _Login = new ServiceMethod();
    _Login.setName("Login");
    _Login.setProtoLine(17);
    _Login.setProtoColumn(3);
    _Login.setRequestRef("com.apihug.rad.api.customer.LoginRequest");
    _Login.setResponseRef("com.apihug.rad.api.customer.LoginResponse");
    _Login.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("auth"));
        res.setSummary("客户登录认证");
        res.setDescription("客户登录认证接口，验证用户名和密码，成功后返回访问令牌");
        res.setPost("/api/auth/login");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.ANONYMOUS);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何进行客户登录认证？","登录接口需要哪些参数？","登录成功后返回什么信息？"));
        return res;
      }
    }.get());
    _Login.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _Login.setPath("/api/auth/login");
    res.addItem(_Login);
    var _Logout = new ServiceMethod();
    _Logout.setName("Logout");
    _Logout.setProtoLine(34);
    _Logout.setProtoColumn(3);
    _Logout.setRequestRef("hope.common.adaptor.Empty");
    _Logout.setResponseRef("hope.common.adaptor.Empty");
    _Logout.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("auth"));
        res.setSummary("退出登录");
        res.setDescription("客户退出登录接口，清除当前客户的会话信息");
        res.setPost("/api/auth/logout");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何退出当前登录？","登出接口的作用是什么？","登出后需要重新登录吗？"));
        return res;
      }
    }.get());
    _Logout.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _Logout.setPath("/api/auth/logout");
    res.addItem(_Logout);
    services.put("com.apihug.rad.api.customer.CustomerAuthService", res);
  }

  void initServiceapi_customerCustomerService() {
    Service res = new Service();
    res.setDescription("============ 客户服务 API ============\n"
            + "客户服务，提供当前客户信息查询、组织管理等功能");
    res.setClzName("com.apihug.rad.api.customer.CustomerService");
    res.setName("CustomerService");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(54);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerService");
    res.setPath("/customer");
    var _Info = new ServiceMethod();
    _Info.setName("Info");
    _Info.setProtoLine(60);
    _Info.setProtoColumn(3);
    _Info.setRequestRef("hope.common.adaptor.Empty");
    _Info.setResponseRef("com.apihug.rad.api.customer.CustomerInfo");
    _Info.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("当前客户信息查询");
        res.setDescription("查询当前客户信息");
        res.setGet("/api/customer/info");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("当前登录客户信息？","客户有哪些角色？","客户有哪些授权？"));
        return res;
      }
    }.get());
    _Info.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _Info.setPath("/api/customer/info");
    res.addItem(_Info);
    var _GetCurrentCustomerInfo = new ServiceMethod();
    _GetCurrentCustomerInfo.setName("GetCurrentCustomerInfo");
    _GetCurrentCustomerInfo.setProtoLine(77);
    _GetCurrentCustomerInfo.setProtoColumn(3);
    _GetCurrentCustomerInfo.setRequestRef("hope.common.adaptor.Empty");
    _GetCurrentCustomerInfo.setResponseRef("com.apihug.rad.api.customer.CurrentCustomerInfo");
    _GetCurrentCustomerInfo.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("获取当前客户完整信息");
        res.setDescription("获取当前客户完整信息（包含权限、角色、部门、当前租户）");
        res.setGet("/api/customer/current-info");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("当前客户有哪些权限？","当前客户有哪些角色？","当前客户属于哪些部门？"));
        return res;
      }
    }.get());
    _GetCurrentCustomerInfo.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetCurrentCustomerInfo.setPath("/api/customer/current-info");
    res.addItem(_GetCurrentCustomerInfo);
    var _GetCustomerTenants = new ServiceMethod();
    _GetCustomerTenants.setName("GetCustomerTenants");
    _GetCustomerTenants.setProtoLine(94);
    _GetCustomerTenants.setProtoColumn(3);
    _GetCustomerTenants.setRequestRef("hope.common.adaptor.Empty");
    _GetCustomerTenants.setResponseRef("com.apihug.rad.api.customer.TenantList");
    _GetCustomerTenants.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("获取客户租户列表");
        res.setDescription("获取客户加入的所有租户列表");
        res.setGet("/api/customer/tenants");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetCustomerTenants.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetCustomerTenants.setPath("/api/customer/tenants");
    res.addItem(_GetCustomerTenants);
    var _SwitchTenant = new ServiceMethod();
    _SwitchTenant.setName("SwitchTenant");
    _SwitchTenant.setProtoLine(106);
    _SwitchTenant.setProtoColumn(3);
    _SwitchTenant.setRequestRef("com.apihug.rad.api.customer.SwitchTenantRequest");
    _SwitchTenant.setResponseRef("com.apihug.rad.api.customer.LoginResponse");
    _SwitchTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("切换租户");
        res.setDescription("切换到指定租户，重新签发 Token");
        res.setPost("/api/customer/switch-tenant");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("切换租户后返回什么？","切换租户后权限如何变化？"));
        return res;
      }
    }.get());
    _SwitchTenant.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SwitchTenant.setPath("/api/customer/switch-tenant");
    res.addItem(_SwitchTenant);
    services.put("com.apihug.rad.api.customer.CustomerService", res);
  }

  void initServiceapi_customerCustomerManagementService() {
    Service res = new Service();
    res.setDescription("============ 客户管理 API ============\n"
            + "客户管理服务，提供客户 CRUD 和搜索功能");
    res.setClzName("com.apihug.rad.api.customer.CustomerManagementService");
    res.setName("CustomerManagementService");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(125);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerManagementService");
    res.setPath("/customers");
    var _CreateCustomer = new ServiceMethod();
    _CreateCustomer.setName("CreateCustomer");
    _CreateCustomer.setProtoLine(131);
    _CreateCustomer.setProtoColumn(3);
    _CreateCustomer.setRequestRef("com.apihug.rad.api.customer.CreateCustomerRequest");
    _CreateCustomer.setResponseRef("com.apihug.rad.api.customer.CustomerSummary");
    _CreateCustomer.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("创建客户");
        res.setDescription("创建新客户");
        res.setPost("/api/customers/customers");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("CUSTOMER_CREATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何创建新客户？","创建客户需要哪些信息？","客户邮箱是否需要唯一？"));
        return res;
      }
    }.get());
    _CreateCustomer.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _CreateCustomer.setPath("/api/customers/customers");
    res.addItem(_CreateCustomer);
    var _ForgotPassword = new ServiceMethod();
    _ForgotPassword.setName("ForgotPassword");
    _ForgotPassword.setProtoLine(153);
    _ForgotPassword.setProtoColumn(3);
    _ForgotPassword.setRequestRef("com.apihug.rad.api.customer.ForgotPasswordRequest");
    _ForgotPassword.setResponseRef("hope.common.adaptor.Empty");
    _ForgotPassword.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("auth"));
        res.setSummary("找回密码");
        res.setDescription("GetCustomer/UpdateCustomer/DeleteCustomer/SearchCustomers 已迁移至 TenantMemberService\n"
                + "租户管理员应通过 /api/tenant-members/tenants/{tenantId}/members 管理租户内成员\n"
                + "申请找回密码（发送重置邮件）");
        res.setPost("/api/customers/auth/forgot-password");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.ANONYMOUS);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何申请找回密码？","重置邮件发送到哪里？"));
        return res;
      }
    }.get());
    _ForgotPassword.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _ForgotPassword.setPath("/api/customers/auth/forgot-password");
    res.addItem(_ForgotPassword);
    var _ResetPassword = new ServiceMethod();
    _ResetPassword.setName("ResetPassword");
    _ResetPassword.setProtoLine(169);
    _ResetPassword.setProtoColumn(3);
    _ResetPassword.setRequestRef("com.apihug.rad.api.customer.ResetPasswordRequest");
    _ResetPassword.setResponseRef("hope.common.adaptor.Empty");
    _ResetPassword.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("auth"));
        res.setSummary("重置密码");
        res.setDescription("重置密码（使用 token）");
        res.setPost("/api/customers/auth/reset-password");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.ANONYMOUS);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何重置密码？","token 有效期多久？"));
        return res;
      }
    }.get());
    _ResetPassword.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _ResetPassword.setPath("/api/customers/auth/reset-password");
    res.addItem(_ResetPassword);
    services.put("com.apihug.rad.api.customer.CustomerManagementService", res);
  }

  void initServiceapi_departmentDepartmentService() {
    Service res = new Service();
    res.setDescription("============ 部门管理 API ============\n"
            + "部门管理服务，提供部门 CRUD 和树形查询功能");
    res.setClzName("com.apihug.rad.api.department.DepartmentService");
    res.setName("DepartmentService");
    res.setProtoFrom("com/apihug/rad/api/department/api.proto");
    res.setProtoLine(11);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentService");
    res.setPath("/departments");
    var _CreateDepartment = new ServiceMethod();
    _CreateDepartment.setName("CreateDepartment");
    _CreateDepartment.setProtoLine(17);
    _CreateDepartment.setProtoColumn(3);
    _CreateDepartment.setRequestRef("com.apihug.rad.api.department.CreateDepartmentRequest");
    _CreateDepartment.setResponseRef("com.apihug.rad.api.department.DepartmentSummary");
    _CreateDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department"));
        res.setSummary("创建部门");
        res.setDescription("创建新部门");
        res.setPost("/api/departments/departments");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("DEPARTMENT_CREATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _CreateDepartment.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _CreateDepartment.setPath("/api/departments/departments");
    res.addItem(_CreateDepartment);
    var _GetDepartment = new ServiceMethod();
    _GetDepartment.setName("GetDepartment");
    _GetDepartment.setProtoLine(31);
    _GetDepartment.setProtoColumn(3);
    _GetDepartment.setRequestRef("hope.common.adaptor.Empty");
    _GetDepartment.setResponseRef("com.apihug.rad.api.department.DepartmentDetail");
    _GetDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department"));
        res.setSummary("获取部门详情");
        res.setDescription("获取部门详情");
        res.setGet("/api/departments/departments/{departmentId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("departmentId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetDepartment.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetDepartment.setPath("/api/departments/departments/{departmentId}");
    res.addItem(_GetDepartment);
    var _UpdateDepartment = new ServiceMethod();
    _UpdateDepartment.setName("UpdateDepartment");
    _UpdateDepartment.setProtoLine(53);
    _UpdateDepartment.setProtoColumn(3);
    _UpdateDepartment.setRequestRef("com.apihug.rad.api.department.UpdateDepartmentRequest");
    _UpdateDepartment.setResponseRef("hope.common.adaptor.Empty");
    _UpdateDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department"));
        res.setSummary("更新部门");
        res.setDescription("更新部门信息");
        res.setPut("/api/departments/departments/{departmentId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("departmentId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("DEPARTMENT_UPDATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _UpdateDepartment.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _UpdateDepartment.setPath("/api/departments/departments/{departmentId}");
    res.addItem(_UpdateDepartment);
    var _DeleteDepartment = new ServiceMethod();
    _DeleteDepartment.setName("DeleteDepartment");
    _DeleteDepartment.setProtoLine(77);
    _DeleteDepartment.setProtoColumn(3);
    _DeleteDepartment.setRequestRef("hope.common.adaptor.Empty");
    _DeleteDepartment.setResponseRef("hope.common.adaptor.Empty");
    _DeleteDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department"));
        res.setSummary("删除部门");
        res.setDescription("删除部门（软删除）");
        res.setDelete("/api/departments/departments/{departmentId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("departmentId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("DEPARTMENT_DELETE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _DeleteDepartment.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _DeleteDepartment.setPath("/api/departments/departments/{departmentId}");
    res.addItem(_DeleteDepartment);
    var _GetDepartmentTree = new ServiceMethod();
    _GetDepartmentTree.setName("GetDepartmentTree");
    _GetDepartmentTree.setProtoLine(101);
    _GetDepartmentTree.setProtoColumn(3);
    _GetDepartmentTree.setRequestRef("hope.common.adaptor.Empty");
    _GetDepartmentTree.setResponseRef("com.apihug.rad.api.department.DepartmentTreeNode");
    _GetDepartmentTree.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department"));
        res.setSummary("获取部门树");
        res.setDescription("获取部门树形结构");
        res.setGet("/api/departments/departments/tree");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetDepartmentTree.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetDepartmentTree.setPath("/api/departments/departments/tree");
    res.addItem(_GetDepartmentTree);
    services.put("com.apihug.rad.api.department.DepartmentService", res);
  }

  void initServiceapi_menuMenuService() {
    Service res = new Service();
    res.setDescription("============ 菜单管理 API ============\n"
            + "菜单管理服务，提供菜单 CRUD 和树形查询功能");
    res.setClzName("com.apihug.rad.api.menu.MenuService");
    res.setName("MenuService");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(11);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuService");
    res.setPath("/menus");
    var _CreateMenu = new ServiceMethod();
    _CreateMenu.setName("CreateMenu");
    _CreateMenu.setProtoLine(17);
    _CreateMenu.setProtoColumn(3);
    _CreateMenu.setRequestRef("com.apihug.rad.api.menu.CreateMenuRequest");
    _CreateMenu.setResponseRef("com.apihug.rad.api.menu.MenuSummary");
    _CreateMenu.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("menu"));
        res.setSummary("创建菜单");
        res.setDescription("创建新菜单");
        res.setPost("/api/menus/menus");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("MENU_CREATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何创建新菜单？","创建菜单需要哪些信息？","菜单代码是否需要唯一？"));
        return res;
      }
    }.get());
    _CreateMenu.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _CreateMenu.setPath("/api/menus/menus");
    res.addItem(_CreateMenu);
    var _GetMenu = new ServiceMethod();
    _GetMenu.setName("GetMenu");
    _GetMenu.setProtoLine(36);
    _GetMenu.setProtoColumn(3);
    _GetMenu.setRequestRef("hope.common.adaptor.Empty");
    _GetMenu.setResponseRef("com.apihug.rad.api.menu.MenuDetail");
    _GetMenu.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("menu"));
        res.setSummary("获取菜单详情");
        res.setDescription("获取菜单详情");
        res.setGet("/api/menus/menus/{menuId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("menuId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何获取菜单详情？","菜单详情包含哪些信息？"));
        return res;
      }
    }.get());
    _GetMenu.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetMenu.setPath("/api/menus/menus/{menuId}");
    res.addItem(_GetMenu);
    var _UpdateMenu = new ServiceMethod();
    _UpdateMenu.setName("UpdateMenu");
    _UpdateMenu.setProtoLine(62);
    _UpdateMenu.setProtoColumn(3);
    _UpdateMenu.setRequestRef("com.apihug.rad.api.menu.UpdateMenuRequest");
    _UpdateMenu.setResponseRef("hope.common.adaptor.Empty");
    _UpdateMenu.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("menu"));
        res.setSummary("更新菜单");
        res.setDescription("更新菜单信息");
        res.setPut("/api/menus/menus/{menuId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("menuId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("MENU_UPDATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何更新菜单信息？","哪些字段可以更新？"));
        return res;
      }
    }.get());
    _UpdateMenu.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _UpdateMenu.setPath("/api/menus/menus/{menuId}");
    res.addItem(_UpdateMenu);
    var _DeleteMenu = new ServiceMethod();
    _DeleteMenu.setName("DeleteMenu");
    _DeleteMenu.setProtoLine(90);
    _DeleteMenu.setProtoColumn(3);
    _DeleteMenu.setRequestRef("hope.common.adaptor.Empty");
    _DeleteMenu.setResponseRef("hope.common.adaptor.Empty");
    _DeleteMenu.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("menu"));
        res.setSummary("删除菜单");
        res.setDescription("删除菜单（软删除）");
        res.setDelete("/api/menus/menus/{menuId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("menuId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("MENU_DELETE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何删除菜单？","是物理删除还是软删除？"));
        return res;
      }
    }.get());
    _DeleteMenu.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _DeleteMenu.setPath("/api/menus/menus/{menuId}");
    res.addItem(_DeleteMenu);
    var _GetMenuTree = new ServiceMethod();
    _GetMenuTree.setName("GetMenuTree");
    _GetMenuTree.setProtoLine(118);
    _GetMenuTree.setProtoColumn(3);
    _GetMenuTree.setRequestRef("hope.common.adaptor.Empty");
    _GetMenuTree.setResponseRef("com.apihug.rad.api.menu.MenuTreeNode");
    _GetMenuTree.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("menu"));
        res.setSummary("获取菜单树");
        res.setDescription("获取菜单树形结构");
        res.setGet("/api/menus/menus/tree");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何获取菜单树？","返回什么格式的树形结构？"));
        return res;
      }
    }.get());
    _GetMenuTree.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetMenuTree.setPath("/api/menus/menus/tree");
    res.addItem(_GetMenuTree);
    var _SearchMenus = new ServiceMethod();
    _SearchMenus.setName("SearchMenus");
    _SearchMenus.setProtoLine(134);
    _SearchMenus.setProtoColumn(3);
    _SearchMenus.setRequestRef("com.apihug.rad.api.menu.SearchMenusRequest");
    _SearchMenus.setResponseRef("com.apihug.rad.api.menu.MenuSummary");
    _SearchMenus.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("menu"));
        res.setSummary("搜索菜单");
        res.setDescription("搜索菜单（分页）");
        res.setPageable(true);
        res.setPost("/api/menus/menus/search");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("MENU_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何搜索菜单？","支持哪些筛选条件？","如何分页？"));
        return res;
      }
    }.get());
    _SearchMenus.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SearchMenus.setPath("/api/menus/menus/search");
    res.addItem(_SearchMenus);
    services.put("com.apihug.rad.api.menu.MenuService", res);
  }

  void initServiceapi_metaApihugService() {
    Service res = new Service();
    res.setDescription("apihug meta information");
    res.setClzName("com.apihug.rad.api.meta.ApihugService");
    res.setName("ApihugService");
    res.setProtoFrom("com/apihug/rad/api/meta/apihug_meta.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("ApihugService");
    res.setPath("/apihug/meta");
    var _Apis = new ServiceMethod();
    _Apis.setName("Apis");
    _Apis.setProtoLine(14);
    _Apis.setProtoColumn(3);
    _Apis.setRequestRef("hope.common.adaptor.Empty");
    _Apis.setResponseRef("hope.common.adaptor.Empty");
    _Apis.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("apihug"));
        res.setDescription("api information of this platform");
        res.setPriority(Priority.LOW);
        res.setGet("/api/apihug/meta/apis");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setPredefinedRoleChecker(RBAC.PredefinedRoleCheckerType.PLATFORM);
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _Apis.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _Apis.setPath("/api/apihug/meta/apis");
    _Apis.setPriority(hope.common.service.Priority.LOW);
    res.addItem(_Apis);
    var _Errors = new ServiceMethod();
    _Errors.setName("Errors");
    _Errors.setProtoLine(28);
    _Errors.setProtoColumn(3);
    _Errors.setRequestRef("hope.common.adaptor.Empty");
    _Errors.setResponseRef("hope.common.adaptor.Empty");
    _Errors.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("apihug"));
        res.setDescription("api errors information of this platform");
        res.setPriority(Priority.LOW);
        res.setGet("/api/apihug/meta/errors");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setPredefinedRoleChecker(RBAC.PredefinedRoleCheckerType.PLATFORM);
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _Errors.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _Errors.setPath("/api/apihug/meta/errors");
    _Errors.setPriority(hope.common.service.Priority.LOW);
    res.addItem(_Errors);
    var _Authorities = new ServiceMethod();
    _Authorities.setName("Authorities");
    _Authorities.setProtoLine(42);
    _Authorities.setProtoColumn(3);
    _Authorities.setRequestRef("hope.common.adaptor.Empty");
    _Authorities.setResponseRef("hope.common.adaptor.Empty");
    _Authorities.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("apihug"));
        res.setDescription("api errors information of this platform");
        res.setPriority(Priority.LOW);
        res.setGet("/api/apihug/meta/authorities");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setPredefinedRoleChecker(RBAC.PredefinedRoleCheckerType.PLATFORM);
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _Authorities.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _Authorities.setPath("/api/apihug/meta/authorities");
    _Authorities.setPriority(hope.common.service.Priority.LOW);
    res.addItem(_Authorities);
    var _Dictionaries = new ServiceMethod();
    _Dictionaries.setName("Dictionaries");
    _Dictionaries.setProtoLine(56);
    _Dictionaries.setProtoColumn(3);
    _Dictionaries.setRequestRef("hope.common.adaptor.Empty");
    _Dictionaries.setResponseRef("hope.common.adaptor.Empty");
    _Dictionaries.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("apihug"));
        res.setDescription("api errors information of this platform");
        res.setPriority(Priority.LOW);
        res.setGet("/api/apihug/meta/dictionaries");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setPredefinedRoleChecker(RBAC.PredefinedRoleCheckerType.PLATFORM);
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _Dictionaries.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _Dictionaries.setPath("/api/apihug/meta/dictionaries");
    _Dictionaries.setPriority(hope.common.service.Priority.LOW);
    res.addItem(_Dictionaries);
    var _Entities = new ServiceMethod();
    _Entities.setName("Entities");
    _Entities.setProtoLine(70);
    _Entities.setProtoColumn(3);
    _Entities.setRequestRef("hope.common.adaptor.Empty");
    _Entities.setResponseRef("hope.common.adaptor.Empty");
    _Entities.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("apihug"));
        res.setDescription("api errors information of this platform");
        res.setPriority(Priority.LOW);
        res.setGet("/api/apihug/meta/entities");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setPredefinedRoleChecker(RBAC.PredefinedRoleCheckerType.PLATFORM);
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _Entities.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _Entities.setPath("/api/apihug/meta/entities");
    _Entities.setPriority(hope.common.service.Priority.LOW);
    res.addItem(_Entities);
    services.put("com.apihug.rad.api.meta.ApihugService", res);
  }

  void initServiceapi_permissionPermissionService() {
    Service res = new Service();
    res.setDescription("============ 权限管理 API ============\n"
            + "权限管理服务，提供权限查询和聚合功能");
    res.setClzName("com.apihug.rad.api.permission.PermissionService");
    res.setName("PermissionService");
    res.setProtoFrom("com/apihug/rad/api/permission/api.proto");
    res.setProtoLine(10);
    res.setProtoColumn(1);
    res.setProtoEntity("PermissionService");
    res.setPath("/permissions");
    var _GetRolePermissions = new ServiceMethod();
    _GetRolePermissions.setName("GetRolePermissions");
    _GetRolePermissions.setProtoLine(17);
    _GetRolePermissions.setProtoColumn(3);
    _GetRolePermissions.setRequestRef("hope.common.adaptor.Empty");
    _GetRolePermissions.setResponseRef("com.apihug.rad.api.permission.PermissionInfo");
    _GetRolePermissions.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("permission"));
        res.setSummary("获取角色权限");
        res.setDescription("获取当前客户的角色权限集合\n"
                + "获取当前客户的角色权限集合");
        res.setOutputPlural(true);
        res.setGet("/api/permissions/roles");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetRolePermissions.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetRolePermissions.setPath("/api/permissions/roles");
    res.addItem(_GetRolePermissions);
    var _GetMenuPermissions = new ServiceMethod();
    _GetMenuPermissions.setName("GetMenuPermissions");
    _GetMenuPermissions.setProtoLine(31);
    _GetMenuPermissions.setProtoColumn(3);
    _GetMenuPermissions.setRequestRef("hope.common.adaptor.Empty");
    _GetMenuPermissions.setResponseRef("com.apihug.rad.api.permission.PermissionInfo");
    _GetMenuPermissions.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("permission"));
        res.setSummary("获取菜单权限");
        res.setDescription("获取当前客户的菜单权限集合\n"
                + "获取当前客户的菜单权限集合");
        res.setOutputPlural(true);
        res.setGet("/api/permissions/menus");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetMenuPermissions.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetMenuPermissions.setPath("/api/permissions/menus");
    res.addItem(_GetMenuPermissions);
    var _GetAllPermissions = new ServiceMethod();
    _GetAllPermissions.setName("GetAllPermissions");
    _GetAllPermissions.setProtoLine(45);
    _GetAllPermissions.setProtoColumn(3);
    _GetAllPermissions.setRequestRef("hope.common.adaptor.Empty");
    _GetAllPermissions.setResponseRef("com.apihug.rad.api.permission.PermissionInfo");
    _GetAllPermissions.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("permission"));
        res.setSummary("获取所有权限");
        res.setDescription("获取当前客户的所有权限（角色权限 ∪ 菜单权限）\n"
                + "获取当前客户的所有权限（聚合）");
        res.setOutputPlural(true);
        res.setGet("/api/permissions/all");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetAllPermissions.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetAllPermissions.setPath("/api/permissions/all");
    res.addItem(_GetAllPermissions);
    services.put("com.apihug.rad.api.permission.PermissionService", res);
  }

  void initServiceapi_roleRoleService() {
    Service res = new Service();
    res.setDescription("============ 角色管理 API ============\n"
            + "角色管理服务，提供角色 CRUD 和权限分配功能");
    res.setClzName("com.apihug.rad.api.role.RoleService");
    res.setName("RoleService");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(11);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleService");
    res.setPath("/roles");
    var _CreateRole = new ServiceMethod();
    _CreateRole.setName("CreateRole");
    _CreateRole.setProtoLine(17);
    _CreateRole.setProtoColumn(3);
    _CreateRole.setRequestRef("com.apihug.rad.api.role.CreateRoleRequest");
    _CreateRole.setResponseRef("com.apihug.rad.api.role.RoleSummary");
    _CreateRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("创建角色");
        res.setDescription("创建新角色");
        res.setPost("/api/roles/roles");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ROLE_CREATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何创建新角色？","创建角色需要哪些信息？","角色代码是否需要唯一？"));
        return res;
      }
    }.get());
    _CreateRole.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _CreateRole.setPath("/api/roles/roles");
    res.addItem(_CreateRole);
    var _GetRole = new ServiceMethod();
    _GetRole.setName("GetRole");
    _GetRole.setProtoLine(36);
    _GetRole.setProtoColumn(3);
    _GetRole.setRequestRef("hope.common.adaptor.Empty");
    _GetRole.setResponseRef("com.apihug.rad.api.role.RoleDetail");
    _GetRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("获取角色详情");
        res.setDescription("获取角色详情");
        res.setGet("/api/roles/roles/{roleId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何获取角色详情？","角色详情包含哪些信息？"));
        return res;
      }
    }.get());
    _GetRole.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetRole.setPath("/api/roles/roles/{roleId}");
    res.addItem(_GetRole);
    var _UpdateRole = new ServiceMethod();
    _UpdateRole.setName("UpdateRole");
    _UpdateRole.setProtoLine(62);
    _UpdateRole.setProtoColumn(3);
    _UpdateRole.setRequestRef("com.apihug.rad.api.role.UpdateRoleRequest");
    _UpdateRole.setResponseRef("hope.common.adaptor.Empty");
    _UpdateRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("更新角色");
        res.setDescription("更新角色信息");
        res.setPut("/api/roles/roles/{roleId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ROLE_UPDATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何更新角色信息？","哪些字段可以更新？"));
        return res;
      }
    }.get());
    _UpdateRole.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _UpdateRole.setPath("/api/roles/roles/{roleId}");
    res.addItem(_UpdateRole);
    var _DeleteRole = new ServiceMethod();
    _DeleteRole.setName("DeleteRole");
    _DeleteRole.setProtoLine(90);
    _DeleteRole.setProtoColumn(3);
    _DeleteRole.setRequestRef("hope.common.adaptor.Empty");
    _DeleteRole.setResponseRef("hope.common.adaptor.Empty");
    _DeleteRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("删除角色");
        res.setDescription("删除角色（软删除）");
        res.setDelete("/api/roles/roles/{roleId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ROLE_DELETE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何删除角色？","是物理删除还是软删除？"));
        return res;
      }
    }.get());
    _DeleteRole.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _DeleteRole.setPath("/api/roles/roles/{roleId}");
    res.addItem(_DeleteRole);
    var _SearchRoles = new ServiceMethod();
    _SearchRoles.setName("SearchRoles");
    _SearchRoles.setProtoLine(118);
    _SearchRoles.setProtoColumn(3);
    _SearchRoles.setRequestRef("com.apihug.rad.api.role.SearchRolesRequest");
    _SearchRoles.setResponseRef("com.apihug.rad.api.role.RoleSummary");
    _SearchRoles.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("搜索角色");
        res.setDescription("搜索角色（分页）");
        res.setPageable(true);
        res.setPost("/api/roles/roles/search");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ROLE_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何搜索角色？","支持哪些筛选条件？","如何分页？"));
        return res;
      }
    }.get());
    _SearchRoles.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SearchRoles.setPath("/api/roles/roles/search");
    res.addItem(_SearchRoles);
    var _AssignMenusToRole = new ServiceMethod();
    _AssignMenusToRole.setName("AssignMenusToRole");
    _AssignMenusToRole.setProtoLine(139);
    _AssignMenusToRole.setProtoColumn(3);
    _AssignMenusToRole.setRequestRef("com.apihug.rad.api.role.AssignMenusRequest");
    _AssignMenusToRole.setResponseRef("hope.common.adaptor.Empty");
    _AssignMenusToRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("分配菜单给角色");
        res.setDescription("为角色分配菜单（全量覆盖），参考 RuoYi insertRoleMenu\n"
                + "为角色分配菜单（全量覆盖，菜单中 BUTTON 类型的 permission_code 即为权限）");
        res.setPost("/api/roles/roles/{roleId}/menus");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ROLE_ASSIGN_PERMISSION"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何为角色分配菜单？","分配菜单后权限如何生效？"));
        return res;
      }
    }.get());
    _AssignMenusToRole.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AssignMenusToRole.setPath("/api/roles/roles/{roleId}/menus");
    res.addItem(_AssignMenusToRole);
    var _RemoveMenuFromRole = new ServiceMethod();
    _RemoveMenuFromRole.setName("RemoveMenuFromRole");
    _RemoveMenuFromRole.setProtoLine(168);
    _RemoveMenuFromRole.setProtoColumn(3);
    _RemoveMenuFromRole.setRequestRef("hope.common.adaptor.Empty");
    _RemoveMenuFromRole.setResponseRef("hope.common.adaptor.Empty");
    _RemoveMenuFromRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("移除角色菜单");
        res.setDescription("移除角色的某个菜单关联\n"
                + "移除角色的某个菜单关联");
        res.setDelete("/api/roles/roles/{roleId}/menus/{menuId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("menuId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ROLE_ASSIGN_PERMISSION"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _RemoveMenuFromRole.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _RemoveMenuFromRole.setPath("/api/roles/roles/{roleId}/menus/{menuId}");
    res.addItem(_RemoveMenuFromRole);
    var _GetRoleMenus = new ServiceMethod();
    _GetRoleMenus.setName("GetRoleMenus");
    _GetRoleMenus.setProtoLine(201);
    _GetRoleMenus.setProtoColumn(3);
    _GetRoleMenus.setRequestRef("hope.common.adaptor.Empty");
    _GetRoleMenus.setResponseRef("com.apihug.rad.api.role.RoleMenuSummary");
    _GetRoleMenus.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("获取角色菜单");
        res.setDescription("获取角色关联的菜单列表\n"
                + "获取角色关联的菜单列表（含权限代码）");
        res.setGet("/api/roles/roles/{roleId}/menus");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetRoleMenus.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetRoleMenus.setPath("/api/roles/roles/{roleId}/menus");
    res.addItem(_GetRoleMenus);
    services.put("com.apihug.rad.api.role.RoleService", res);
  }

  void initServiceapi_tenantTenantService() {
    Service res = new Service();
    res.setDescription("============ 租户管理 API ============\n"
            + "租户管理服务，提供租户 CRUD 和配置功能");
    res.setClzName("com.apihug.rad.api.tenant.TenantService");
    res.setName("TenantService");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(11);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantService");
    res.setPath("/tenants");
    var _CreateTenant = new ServiceMethod();
    _CreateTenant.setName("CreateTenant");
    _CreateTenant.setProtoLine(17);
    _CreateTenant.setProtoColumn(3);
    _CreateTenant.setRequestRef("com.apihug.rad.api.tenant.CreateTenantRequest");
    _CreateTenant.setResponseRef("com.apihug.rad.api.tenant.TenantSummary");
    _CreateTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant"));
        res.setSummary("创建租户");
        res.setDescription("创建新租户");
        res.setPost("/api/tenants/tenants");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_CREATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _CreateTenant.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _CreateTenant.setPath("/api/tenants/tenants");
    res.addItem(_CreateTenant);
    var _GetTenant = new ServiceMethod();
    _GetTenant.setName("GetTenant");
    _GetTenant.setProtoLine(31);
    _GetTenant.setProtoColumn(3);
    _GetTenant.setRequestRef("hope.common.adaptor.Empty");
    _GetTenant.setResponseRef("com.apihug.rad.api.tenant.TenantDetail");
    _GetTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant"));
        res.setSummary("获取租户详情");
        res.setDescription("获取租户详情");
        res.setGet("/api/tenants/tenants/{tenantId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetTenant.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetTenant.setPath("/api/tenants/tenants/{tenantId}");
    res.addItem(_GetTenant);
    var _UpdateTenant = new ServiceMethod();
    _UpdateTenant.setName("UpdateTenant");
    _UpdateTenant.setProtoLine(53);
    _UpdateTenant.setProtoColumn(3);
    _UpdateTenant.setRequestRef("com.apihug.rad.api.tenant.UpdateTenantRequest");
    _UpdateTenant.setResponseRef("hope.common.adaptor.Empty");
    _UpdateTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant"));
        res.setSummary("更新租户");
        res.setDescription("更新租户信息");
        res.setPut("/api/tenants/tenants/{tenantId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_UPDATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _UpdateTenant.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _UpdateTenant.setPath("/api/tenants/tenants/{tenantId}");
    res.addItem(_UpdateTenant);
    var _DisableTenant = new ServiceMethod();
    _DisableTenant.setName("DisableTenant");
    _DisableTenant.setProtoLine(77);
    _DisableTenant.setProtoColumn(3);
    _DisableTenant.setRequestRef("hope.common.adaptor.Empty");
    _DisableTenant.setResponseRef("hope.common.adaptor.Empty");
    _DisableTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant"));
        res.setSummary("停用租户");
        res.setDescription("停用租户");
        res.setDelete("/api/tenants/tenants/{tenantId}/disable");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_DISABLE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _DisableTenant.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _DisableTenant.setPath("/api/tenants/tenants/{tenantId}/disable");
    res.addItem(_DisableTenant);
    var _ConfigureTenant = new ServiceMethod();
    _ConfigureTenant.setName("ConfigureTenant");
    _ConfigureTenant.setProtoLine(101);
    _ConfigureTenant.setProtoColumn(3);
    _ConfigureTenant.setRequestRef("com.apihug.rad.api.tenant.ConfigureTenantRequest");
    _ConfigureTenant.setResponseRef("hope.common.adaptor.Empty");
    _ConfigureTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant"));
        res.setSummary("配置租户");
        res.setDescription("配置租户功能");
        res.setPost("/api/tenants/tenants/{tenantId}/configure");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_CONFIGURE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _ConfigureTenant.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _ConfigureTenant.setPath("/api/tenants/tenants/{tenantId}/configure");
    res.addItem(_ConfigureTenant);
    var _SearchTenants = new ServiceMethod();
    _SearchTenants.setName("SearchTenants");
    _SearchTenants.setProtoLine(126);
    _SearchTenants.setProtoColumn(3);
    _SearchTenants.setRequestRef("com.apihug.rad.api.tenant.SearchTenantsRequest");
    _SearchTenants.setResponseRef("com.apihug.rad.api.tenant.TenantSummary");
    _SearchTenants.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant"));
        res.setSummary("搜索租户");
        res.setDescription("搜索租户（分页）\n"
                + "搜索租户（分页）");
        res.setPageable(true);
        res.setPost("/api/tenants/tenants/search");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_CREATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _SearchTenants.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SearchTenants.setPath("/api/tenants/tenants/search");
    res.addItem(_SearchTenants);
    services.put("com.apihug.rad.api.tenant.TenantService", res);
  }

  void initServiceapi_tenantTenantMemberService() {
    Service res = new Service();
    res.setDescription("============ 租户成员管理 API ============\r\n"
            + "替代原 CustomerOrganizationService — 管理 Customer 在 Tenant 中的身份\r\n"
            + "租户成员管理服务，提供成员与租户关系管理功能");
    res.setClzName("com.apihug.rad.api.tenant.TenantMemberService");
    res.setName("TenantMemberService");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(13);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantMemberService");
    res.setPath("/tenant-members");
    var _GetTenantMembers = new ServiceMethod();
    _GetTenantMembers.setName("GetTenantMembers");
    _GetTenantMembers.setProtoLine(20);
    _GetTenantMembers.setProtoColumn(3);
    _GetTenantMembers.setRequestRef("com.apihug.rad.api.tenant.GetTenantMembersRequest");
    _GetTenantMembers.setResponseRef("com.apihug.rad.api.tenant.TenantMemberSummary");
    _GetTenantMembers.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("获取租户成员");
        res.setDescription("获取租户成员列表（分页）\r\n"
                + "获取租户成员列表");
        res.setPageable(true);
        res.setGet("/api/tenant-members/tenants/{tenantId}/members");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetTenantMembers.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetTenantMembers.setPath("/api/tenant-members/tenants/{tenantId}/members");
    res.addItem(_GetTenantMembers);
    var _AddMemberToTenant = new ServiceMethod();
    _AddMemberToTenant.setName("AddMemberToTenant");
    _AddMemberToTenant.setProtoLine(46);
    _AddMemberToTenant.setProtoColumn(3);
    _AddMemberToTenant.setRequestRef("com.apihug.rad.api.tenant.AddTenantMemberRequest");
    _AddMemberToTenant.setResponseRef("hope.common.adaptor.Empty");
    _AddMemberToTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("添加租户成员");
        res.setDescription("添加成员到租户\r\n"
                + "添加客户为租户成员");
        res.setPost("/api/tenant-members/tenants/{tenantId}/members");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_ADD"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AddMemberToTenant.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AddMemberToTenant.setPath("/api/tenant-members/tenants/{tenantId}/members");
    res.addItem(_AddMemberToTenant);
    var _RemoveMemberFromTenant = new ServiceMethod();
    _RemoveMemberFromTenant.setName("RemoveMemberFromTenant");
    _RemoveMemberFromTenant.setProtoLine(71);
    _RemoveMemberFromTenant.setProtoColumn(3);
    _RemoveMemberFromTenant.setRequestRef("hope.common.adaptor.Empty");
    _RemoveMemberFromTenant.setResponseRef("hope.common.adaptor.Empty");
    _RemoveMemberFromTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("移除租户成员");
        res.setDescription("从租户移除成员\r\n"
                + "从租户移除成员");
        res.setDelete("/api/tenant-members/tenants/{tenantId}/members/{memberId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_REMOVE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _RemoveMemberFromTenant.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _RemoveMemberFromTenant.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}");
    res.addItem(_RemoveMemberFromTenant);
    var _ToggleMemberLock = new ServiceMethod();
    _ToggleMemberLock.setName("ToggleMemberLock");
    _ToggleMemberLock.setProtoLine(104);
    _ToggleMemberLock.setProtoColumn(3);
    _ToggleMemberLock.setRequestRef("hope.common.adaptor.Empty");
    _ToggleMemberLock.setResponseRef("hope.common.adaptor.Empty");
    _ToggleMemberLock.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("切换成员锁定状态");
        res.setDescription("锁定/解锁成员\r\n"
                + "锁定/解锁租户成员");
        res.setPost("/api/tenant-members/tenants/{tenantId}/members/{memberId}/toggle-lock");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_LOCK"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _ToggleMemberLock.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _ToggleMemberLock.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/toggle-lock");
    res.addItem(_ToggleMemberLock);
    var _UpdateMemberRole = new ServiceMethod();
    _UpdateMemberRole.setName("UpdateMemberRole");
    _UpdateMemberRole.setProtoLine(137);
    _UpdateMemberRole.setProtoColumn(3);
    _UpdateMemberRole.setRequestRef("com.apihug.rad.api.tenant.UpdateMemberRoleRequest");
    _UpdateMemberRole.setResponseRef("hope.common.adaptor.Empty");
    _UpdateMemberRole.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("更新成员角色");
        res.setDescription("更新成员角色（OWNER/ADMIN/MEMBER）\r\n"
                + "更新成员在租户中的角色（拥有者/管理员/普通成员）");
        res.setPut("/api/tenant-members/tenants/{tenantId}/members/{memberId}/role");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_ASSIGN_ROLE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _UpdateMemberRole.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _UpdateMemberRole.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/role");
    res.addItem(_UpdateMemberRole);
    var _AssignMemberDepartment = new ServiceMethod();
    _AssignMemberDepartment.setName("AssignMemberDepartment");
    _AssignMemberDepartment.setProtoLine(170);
    _AssignMemberDepartment.setProtoColumn(3);
    _AssignMemberDepartment.setRequestRef("com.apihug.rad.api.tenant.AssignMemberDepartmentRequest");
    _AssignMemberDepartment.setResponseRef("hope.common.adaptor.Empty");
    _AssignMemberDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("分配成员部门");
        res.setDescription("分配成员到部门\r\n"
                + "将成员分配到指定部门");
        res.setPut("/api/tenant-members/tenants/{tenantId}/members/{memberId}/department");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_ASSIGN_ROLE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AssignMemberDepartment.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _AssignMemberDepartment.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/department");
    res.addItem(_AssignMemberDepartment);
    var _GetMemberDetail = new ServiceMethod();
    _GetMemberDetail.setName("GetMemberDetail");
    _GetMemberDetail.setProtoLine(203);
    _GetMemberDetail.setProtoColumn(3);
    _GetMemberDetail.setRequestRef("hope.common.adaptor.Empty");
    _GetMemberDetail.setResponseRef("com.apihug.rad.api.tenant.TenantMemberDetail");
    _GetMemberDetail.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("获取成员详情");
        res.setDescription("获取成员详情（含客户信息 + 成员身份信息）\r\n"
                + "获取租户成员详细信息（含客户账号信息和成员身份信息）");
        res.setGet("/api/tenant-members/tenants/{tenantId}/members/{memberId}/detail");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何获取成员详情？","成员详情包含哪些信息？"));
        return res;
      }
    }.get());
    _GetMemberDetail.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetMemberDetail.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/detail");
    res.addItem(_GetMemberDetail);
    var _SetDefaultTenant = new ServiceMethod();
    _SetDefaultTenant.setName("SetDefaultTenant");
    _SetDefaultTenant.setProtoLine(240);
    _SetDefaultTenant.setProtoColumn(3);
    _SetDefaultTenant.setRequestRef("hope.common.adaptor.Empty");
    _SetDefaultTenant.setResponseRef("hope.common.adaptor.Empty");
    _SetDefaultTenant.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("设置默认租户");
        res.setDescription("设置默认租户\r\n"
                + "将指定租户设为客户的默认租户");
        res.setPost("/api/tenant-members/tenants/{tenantId}/set-default");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _SetDefaultTenant.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SetDefaultTenant.setPath("/api/tenant-members/tenants/{tenantId}/set-default");
    res.addItem(_SetDefaultTenant);
    var _AssignRolesToMember = new ServiceMethod();
    _AssignRolesToMember.setName("AssignRolesToMember");
    _AssignRolesToMember.setProtoLine(263);
    _AssignRolesToMember.setProtoColumn(3);
    _AssignRolesToMember.setRequestRef("com.apihug.rad.api.tenant.AssignRolesRequest");
    _AssignRolesToMember.setResponseRef("hope.common.adaptor.Empty");
    _AssignRolesToMember.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("分配成员角色");
        res.setDescription("为成员分配 RBAC 角色（全量覆盖）\r\n"
                + "为租户成员分配 RBAC 角色（全量覆盖，替换已有角色）");
        res.setPost("/api/tenant-members/tenants/{tenantId}/members/{memberId}/roles");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_ASSIGN_ROLE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AssignRolesToMember.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AssignRolesToMember.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/roles");
    res.addItem(_AssignRolesToMember);
    var _GetMemberRoles = new ServiceMethod();
    _GetMemberRoles.setName("GetMemberRoles");
    _GetMemberRoles.setProtoLine(296);
    _GetMemberRoles.setProtoColumn(3);
    _GetMemberRoles.setRequestRef("hope.common.adaptor.Empty");
    _GetMemberRoles.setResponseRef("com.apihug.rad.api.tenant.MemberRoleSummary");
    _GetMemberRoles.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("获取成员角色");
        res.setDescription("获取成员的 RBAC 角色列表\r\n"
                + "获取租户成员的 RBAC 角色列表");
        res.setGet("/api/tenant-members/tenants/{tenantId}/members/{memberId}/roles");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetMemberRoles.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetMemberRoles.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/roles");
    res.addItem(_GetMemberRoles);
    var _RemoveRoleFromMember = new ServiceMethod();
    _RemoveRoleFromMember.setName("RemoveRoleFromMember");
    _RemoveRoleFromMember.setProtoLine(329);
    _RemoveRoleFromMember.setProtoColumn(3);
    _RemoveRoleFromMember.setRequestRef("hope.common.adaptor.Empty");
    _RemoveRoleFromMember.setResponseRef("hope.common.adaptor.Empty");
    _RemoveRoleFromMember.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("tenant-member"));
        res.setSummary("移除成员角色");
        res.setDescription("移除成员的某个 RBAC 角色\r\n"
                + "移除租户成员的某个 RBAC 角色");
        res.setDelete("/api/tenant-members/tenants/{tenantId}/members/{memberId}/roles/{roleId}");
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("tenantId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("memberId");
            return res;
          }
        }.get());
        res.addParameter(new Supplier<Parameter>() {
          @Override
          public Parameter get() {
            Parameter res = new Parameter();
            res.setIn(Parameter.IN.PATH);
            res.setSchema(new Supplier<JSONSchema>() {
              @Override
              public JSONSchema get() {
                JSONSchema res  = new JSONSchema();
                res.setEmpty(false);
                res.setFormat(JSONSchema.JSONSchemaFormat.INTEGER);
                return res;
              }
            }.get());
            res.setName("roleId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("TENANT_MEMBER_ASSIGN_ROLE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _RemoveRoleFromMember.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _RemoveRoleFromMember.setPath("/api/tenant-members/tenants/{tenantId}/members/{memberId}/roles/{roleId}");
    res.addItem(_RemoveRoleFromMember);
    services.put("com.apihug.rad.api.tenant.TenantMemberService", res);
  }

  private void initServices() {
    initServiceapi_auditAccessLogService();
    initServiceapi_customerCustomerAuthService();
    initServiceapi_customerCustomerService();
    initServiceapi_customerCustomerManagementService();
    initServiceapi_departmentDepartmentService();
    initServiceapi_menuMenuService();
    initServiceapi_metaApihugService();
    initServiceapi_permissionPermissionService();
    initServiceapi_roleRoleService();
    initServiceapi_tenantTenantService();
    initServiceapi_tenantTenantMemberService();
  }

  void initComponentapi_auditAccessLogInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.audit.AccessLogInfo");
    res.setName("AccessLogInfo");
    res.setProtoFrom("com/apihug/rad/api/audit/api.proto");
    res.setProtoLine(116);
    res.setProtoColumn(1);
    res.setProtoEntity("AccessLogInfo");
    res.setDescription("============ Response Messages ============\n"
            + "访问日志信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AccessLogInfo");
            res.setDescription("访问日志信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(124);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("日志ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _httpMethod = new ComponentItem();
    _httpMethod.setClzName("java.lang.String");
    _httpMethod.setName("http_method");
    _httpMethod.setFieldName("httpMethod");
    _httpMethod.setTag(2);
    _httpMethod.setProtoLine(129);
    _httpMethod.setProtoColumn(3);
    _httpMethod.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("HTTP方法");
        res.setExample("GET");
        return res;
      }
    }.get());
    res.addItem(_httpMethod);
    ComponentItem _requestPath = new ComponentItem();
    _requestPath.setClzName("java.lang.String");
    _requestPath.setName("request_path");
    _requestPath.setFieldName("requestPath");
    _requestPath.setTag(3);
    _requestPath.setProtoLine(134);
    _requestPath.setProtoColumn(3);
    _requestPath.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("请求路径");
        res.setExample("/api/auth/login");
        return res;
      }
    }.get());
    res.addItem(_requestPath);
    ComponentItem _responseStatus = new ComponentItem();
    _responseStatus.setClzName("java.lang.Integer");
    _responseStatus.setName("response_status");
    _responseStatus.setFieldName("responseStatus");
    _responseStatus.setTag(4);
    _responseStatus.setProtoLine(139);
    _responseStatus.setProtoColumn(3);
    _responseStatus.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("响应状态码");
        res.setExample("200");
        return res;
      }
    }.get());
    res.addItem(_responseStatus);
    ComponentItem _durationMs = new ComponentItem();
    _durationMs.setClzName("java.lang.Long");
    _durationMs.setName("duration_ms");
    _durationMs.setFieldName("durationMs");
    _durationMs.setTag(5);
    _durationMs.setProtoLine(144);
    _durationMs.setProtoColumn(3);
    _durationMs.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("耗时毫秒");
        res.setExample("42");
        return res;
      }
    }.get());
    res.addItem(_durationMs);
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(6);
    _customerId.setProtoLine(149);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _ipAddress = new ComponentItem();
    _ipAddress.setClzName("java.lang.String");
    _ipAddress.setName("ip_address");
    _ipAddress.setFieldName("ipAddress");
    _ipAddress.setTag(7);
    _ipAddress.setProtoLine(154);
    _ipAddress.setProtoColumn(3);
    _ipAddress.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("IP地址");
        res.setExample("192.168.1.100");
        return res;
      }
    }.get());
    res.addItem(_ipAddress);
    ComponentItem _userAgent = new ComponentItem();
    _userAgent.setClzName("java.lang.String");
    _userAgent.setName("user_agent");
    _userAgent.setFieldName("userAgent");
    _userAgent.setTag(8);
    _userAgent.setProtoLine(159);
    _userAgent.setProtoColumn(3);
    _userAgent.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户代理");
        res.setExample("Mozilla/5.0");
        return res;
      }
    }.get());
    res.addItem(_userAgent);
    ComponentItem _serviceName = new ComponentItem();
    _serviceName.setClzName("java.lang.String");
    _serviceName.setName("service_name");
    _serviceName.setFieldName("serviceName");
    _serviceName.setTag(9);
    _serviceName.setProtoLine(164);
    _serviceName.setProtoColumn(3);
    _serviceName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("服务名称");
        res.setExample("AuthService");
        return res;
      }
    }.get());
    res.addItem(_serviceName);
    ComponentItem _methodName = new ComponentItem();
    _methodName.setClzName("java.lang.String");
    _methodName.setName("method_name");
    _methodName.setFieldName("methodName");
    _methodName.setTag(10);
    _methodName.setProtoLine(169);
    _methodName.setProtoColumn(3);
    _methodName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("方法名称");
        res.setExample("Login");
        return res;
      }
    }.get());
    res.addItem(_methodName);
    ComponentItem _errorCode = new ComponentItem();
    _errorCode.setClzName("java.lang.String");
    _errorCode.setName("error_code");
    _errorCode.setFieldName("errorCode");
    _errorCode.setTag(11);
    _errorCode.setProtoLine(174);
    _errorCode.setProtoColumn(3);
    _errorCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("错误码");
        res.setExample("AUTH_FAILED");
        return res;
      }
    }.get());
    res.addItem(_errorCode);
    ComponentItem _errorMessage = new ComponentItem();
    _errorMessage.setClzName("java.lang.String");
    _errorMessage.setName("error_message");
    _errorMessage.setFieldName("errorMessage");
    _errorMessage.setTag(12);
    _errorMessage.setProtoLine(179);
    _errorMessage.setProtoColumn(3);
    _errorMessage.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("错误信息");
        res.setExample("认证失败");
        return res;
      }
    }.get());
    res.addItem(_errorMessage);
    ComponentItem _requestParams = new ComponentItem();
    _requestParams.setClzName("java.lang.String");
    _requestParams.setName("request_params");
    _requestParams.setFieldName("requestParams");
    _requestParams.setTag(13);
    _requestParams.setProtoLine(184);
    _requestParams.setProtoColumn(3);
    _requestParams.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("脱敏后的请求参数");
        res.setExample("{\"username\":\"admin\",\"password\":\"***\"}");
        return res;
      }
    }.get());
    res.addItem(_requestParams);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(14);
    _createdAt.setProtoLine(189);
    _createdAt.setProtoColumn(3);
    _createdAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("创建时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_createdAt);
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(15);
    _tenantId.setProtoLine(195);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    ComponentItem _priority = new ComponentItem();
    _priority.setClzName("java.lang.String");
    _priority.setName("priority");
    _priority.setFieldName("priority");
    _priority.setTag(16);
    _priority.setProtoLine(200);
    _priority.setProtoColumn(3);
    _priority.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("priority of this method");
        res.setExample("LOW");
        return res;
      }
    }.get());
    res.addItem(_priority);
    components.put("com.apihug.rad.api.audit.AccessLogInfo", res);
  }

  void initComponentapi_auditAccessLogStatsResponse() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.audit.AccessLogStatsResponse");
    res.setName("AccessLogStatsResponse");
    res.setProtoFrom("com/apihug/rad/api/audit/api.proto");
    res.setProtoLine(206);
    res.setProtoColumn(1);
    res.setProtoEntity("AccessLogStatsResponse");
    res.setDescription("访问统计响应");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AccessLogStatsResponse");
            res.setDescription("访问统计响应");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _totalRequests = new ComponentItem();
    _totalRequests.setClzName("java.lang.Long");
    _totalRequests.setName("total_requests");
    _totalRequests.setFieldName("totalRequests");
    _totalRequests.setTag(1);
    _totalRequests.setProtoLine(214);
    _totalRequests.setProtoColumn(3);
    _totalRequests.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("总请求数");
        res.setExample("10000");
        return res;
      }
    }.get());
    res.addItem(_totalRequests);
    ComponentItem _successCount = new ComponentItem();
    _successCount.setClzName("java.lang.Long");
    _successCount.setName("success_count");
    _successCount.setFieldName("successCount");
    _successCount.setTag(2);
    _successCount.setProtoLine(219);
    _successCount.setProtoColumn(3);
    _successCount.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成功请求数(2xx)");
        res.setExample("9500");
        return res;
      }
    }.get());
    res.addItem(_successCount);
    ComponentItem _errorCount = new ComponentItem();
    _errorCount.setClzName("java.lang.Long");
    _errorCount.setName("error_count");
    _errorCount.setFieldName("errorCount");
    _errorCount.setTag(3);
    _errorCount.setProtoLine(224);
    _errorCount.setProtoColumn(3);
    _errorCount.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("错误请求数(4xx+5xx)");
        res.setExample("500");
        return res;
      }
    }.get());
    res.addItem(_errorCount);
    ComponentItem _avgDurationMs = new ComponentItem();
    _avgDurationMs.setClzName("java.lang.Long");
    _avgDurationMs.setName("avg_duration_ms");
    _avgDurationMs.setFieldName("avgDurationMs");
    _avgDurationMs.setTag(4);
    _avgDurationMs.setProtoLine(229);
    _avgDurationMs.setProtoColumn(3);
    _avgDurationMs.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("平均耗时毫秒");
        res.setExample("120");
        return res;
      }
    }.get());
    res.addItem(_avgDurationMs);
    ComponentItem _topPaths = new ComponentItem();
    _topPaths.setClzName("com.apihug.rad.api.audit.PathStats");
    _topPaths.setName("top_paths");
    _topPaths.setFieldName("topPaths");
    _topPaths.setTag(5);
    _topPaths.setProtoLine(234);
    _topPaths.setProtoColumn(3);
    _topPaths.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("Top访问路径统计");
        return res;
      }
    }.get());
    _topPaths.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_topPaths);
    components.put("com.apihug.rad.api.audit.AccessLogStatsResponse", res);
  }

  void initComponentapi_auditGetAccessLogStatsRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.audit.GetAccessLogStatsRequest");
    res.setName("GetAccessLogStatsRequest");
    res.setProtoFrom("com/apihug/rad/api/audit/api.proto");
    res.setProtoLine(93);
    res.setProtoColumn(1);
    res.setProtoEntity("GetAccessLogStatsRequest");
    res.setDescription("获取访问统计请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("GetAccessLogStatsRequest");
            res.setDescription("获取访问统计请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _startTime = new ComponentItem();
    _startTime.setClzName("java.time.LocalDateTime");
    _startTime.setName("start_time");
    _startTime.setFieldName("startTime");
    _startTime.setTag(1);
    _startTime.setProtoLine(101);
    _startTime.setProtoColumn(3);
    _startTime.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("开始时间（可选）");
        res.setExample("2024-01-01 00:00:00");
        res.setDateFormat(DateFormat.YYYY_MM_DD_HH_MM_SS);
        return res;
      }
    }.get());
    res.addItem(_startTime);
    ComponentItem _endTime = new ComponentItem();
    _endTime.setClzName("java.time.LocalDateTime");
    _endTime.setName("end_time");
    _endTime.setFieldName("endTime");
    _endTime.setTag(2);
    _endTime.setProtoLine(107);
    _endTime.setProtoColumn(3);
    _endTime.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("结束时间（可选）");
        res.setExample("2024-12-31 23:59:59");
        res.setDateFormat(DateFormat.YYYY_MM_DD_HH_MM_SS);
        return res;
      }
    }.get());
    res.addItem(_endTime);
    components.put("com.apihug.rad.api.audit.GetAccessLogStatsRequest", res);
  }

  void initComponentapi_auditPathStats() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.audit.PathStats");
    res.setName("PathStats");
    res.setProtoFrom("com/apihug/rad/api/audit/api.proto");
    res.setProtoLine(239);
    res.setProtoColumn(1);
    res.setProtoEntity("PathStats");
    res.setDescription("路径统计");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("PathStats");
            res.setDescription("路径统计");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _path = new ComponentItem();
    _path.setClzName("java.lang.String");
    _path.setName("path");
    _path.setFieldName("path");
    _path.setTag(1);
    _path.setProtoLine(247);
    _path.setProtoColumn(3);
    _path.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("请求路径");
        res.setExample("/api/auth/login");
        return res;
      }
    }.get());
    res.addItem(_path);
    ComponentItem _count = new ComponentItem();
    _count.setClzName("java.lang.Long");
    _count.setName("count");
    _count.setFieldName("count");
    _count.setTag(2);
    _count.setProtoLine(252);
    _count.setProtoColumn(3);
    _count.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("请求次数");
        res.setExample("1500");
        return res;
      }
    }.get());
    res.addItem(_count);
    ComponentItem _avgDurationMs = new ComponentItem();
    _avgDurationMs.setClzName("java.lang.Long");
    _avgDurationMs.setName("avg_duration_ms");
    _avgDurationMs.setFieldName("avgDurationMs");
    _avgDurationMs.setTag(3);
    _avgDurationMs.setProtoLine(257);
    _avgDurationMs.setProtoColumn(3);
    _avgDurationMs.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("平均耗时毫秒");
        res.setExample("85");
        return res;
      }
    }.get());
    res.addItem(_avgDurationMs);
    ComponentItem _errorRate = new ComponentItem();
    _errorRate.setClzName("java.lang.Integer");
    _errorRate.setName("error_rate");
    _errorRate.setFieldName("errorRate");
    _errorRate.setTag(4);
    _errorRate.setProtoLine(262);
    _errorRate.setProtoColumn(3);
    _errorRate.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("错误率(百分比*100)");
        res.setExample("5");
        return res;
      }
    }.get());
    res.addItem(_errorRate);
    components.put("com.apihug.rad.api.audit.PathStats", res);
  }

  void initComponentapi_auditSearchAccessLogsRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.audit.SearchAccessLogsRequest");
    res.setName("SearchAccessLogsRequest");
    res.setProtoFrom("com/apihug/rad/api/audit/api.proto");
    res.setProtoLine(53);
    res.setProtoColumn(1);
    res.setProtoEntity("SearchAccessLogsRequest");
    res.setDescription("Let it go\n"
            + "查询访问日志请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setDescription("查询访问日志请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(1);
    _customerId.setProtoLine(60);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户ID（可选）");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _httpMethod = new ComponentItem();
    _httpMethod.setClzName("java.lang.String");
    _httpMethod.setName("http_method");
    _httpMethod.setFieldName("httpMethod");
    _httpMethod.setTag(2);
    _httpMethod.setProtoLine(65);
    _httpMethod.setProtoColumn(3);
    _httpMethod.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("HTTP方法（可选）");
        res.setExample("GET");
        return res;
      }
    }.get());
    res.addItem(_httpMethod);
    ComponentItem _requestPath = new ComponentItem();
    _requestPath.setClzName("java.lang.String");
    _requestPath.setName("request_path");
    _requestPath.setFieldName("requestPath");
    _requestPath.setTag(3);
    _requestPath.setProtoLine(70);
    _requestPath.setProtoColumn(3);
    _requestPath.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("请求路径（可选，模糊匹配）");
        res.setExample("/api/auth");
        return res;
      }
    }.get());
    res.addItem(_requestPath);
    ComponentItem _responseStatus = new ComponentItem();
    _responseStatus.setClzName("java.lang.Integer");
    _responseStatus.setName("response_status");
    _responseStatus.setFieldName("responseStatus");
    _responseStatus.setTag(4);
    _responseStatus.setProtoLine(75);
    _responseStatus.setProtoColumn(3);
    _responseStatus.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("响应状态码（可选）");
        res.setExample("200");
        return res;
      }
    }.get());
    res.addItem(_responseStatus);
    ComponentItem _startTime = new ComponentItem();
    _startTime.setClzName("java.time.LocalDateTime");
    _startTime.setName("start_time");
    _startTime.setFieldName("startTime");
    _startTime.setTag(5);
    _startTime.setProtoLine(80);
    _startTime.setProtoColumn(3);
    _startTime.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("开始时间（可选）");
        res.setExample("2024-01-01T00:00:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_startTime);
    ComponentItem _endTime = new ComponentItem();
    _endTime.setClzName("java.time.LocalDateTime");
    _endTime.setName("end_time");
    _endTime.setFieldName("endTime");
    _endTime.setTag(6);
    _endTime.setProtoLine(86);
    _endTime.setProtoColumn(3);
    _endTime.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("结束时间（可选）");
        res.setExample("2024-12-31T23:59:59");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_endTime);
    components.put("com.apihug.rad.api.audit.SearchAccessLogsRequest", res);
  }

  void initComponentapi_customerCreateCustomerRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CreateCustomerRequest");
    res.setName("CreateCustomerRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(406);
    res.setProtoColumn(1);
    res.setProtoEntity("CreateCustomerRequest");
    res.setDescription("创建客户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CreateCustomerRequest");
            res.setDescription("创建客户请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _username = new ComponentItem();
    _username.setClzName("java.lang.String");
    _username.setName("username");
    _username.setFieldName("username");
    _username.setTag(1);
    _username.setProtoLine(414);
    _username.setProtoColumn(3);
    _username.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户名");
        res.setExample("zhangsan");
        res.setMaxLength(50l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_username);
    ComponentItem _password = new ComponentItem();
    _password.setClzName("java.lang.String");
    _password.setName("password");
    _password.setFieldName("password");
    _password.setTag(2);
    _password.setProtoLine(422);
    _password.setProtoColumn(3);
    _password.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("密码");
        res.setExample("SecureP@ss123");
        res.setMaxLength(100l);
        res.setMinLength(6l);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_password);
    ComponentItem _email = new ComponentItem();
    _email.setClzName("java.lang.String");
    _email.setName("email");
    _email.setFieldName("email");
    _email.setTag(3);
    _email.setProtoLine(430);
    _email.setProtoColumn(3);
    _email.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("邮箱");
        res.setExample("zhangsan@example.com");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.EMAIL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_email);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.customer.CustomerStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(438);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _defaultTenantId = new ComponentItem();
    _defaultTenantId.setClzName("java.lang.Long");
    _defaultTenantId.setName("default_tenant_id");
    _defaultTenantId.setFieldName("defaultTenantId");
    _defaultTenantId.setTag(5);
    _defaultTenantId.setProtoLine(444);
    _defaultTenantId.setProtoColumn(3);
    _defaultTenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("默认租户 ID");
        res.setExample("1");
        res.setMinimum(0.0D);
        return res;
      }
    }.get());
    res.addItem(_defaultTenantId);
    components.put("com.apihug.rad.api.customer.CreateCustomerRequest", res);
  }

  void initComponentapi_customerCurrentCustomerInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CurrentCustomerInfo");
    res.setName("CurrentCustomerInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(343);
    res.setProtoColumn(1);
    res.setProtoEntity("CurrentCustomerInfo");
    res.setDescription("当前客户完整信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CurrentCustomerInfo");
            res.setDescription("当前客户完整信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _customer = new ComponentItem();
    _customer.setClzName("com.apihug.rad.api.customer.CustomerInfo");
    _customer.setName("customer");
    _customer.setFieldName("customer");
    _customer.setTag(1);
    _customer.setProtoLine(351);
    _customer.setProtoColumn(3);
    _customer.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户基本信息");
        return res;
      }
    }.get());
    res.addItem(_customer);
    ComponentItem _roles = new ComponentItem();
    _roles.setClzName("com.apihug.rad.api.customer.RoleInfo");
    _roles.setName("roles");
    _roles.setFieldName("roles");
    _roles.setTag(2);
    _roles.setProtoLine(355);
    _roles.setProtoColumn(3);
    _roles.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户角色列表");
        return res;
      }
    }.get());
    _roles.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_roles);
    ComponentItem _authorities = new ComponentItem();
    _authorities.setClzName("java.lang.String");
    _authorities.setName("authorities");
    _authorities.setFieldName("authorities");
    _authorities.setTag(3);
    _authorities.setProtoLine(359);
    _authorities.setProtoColumn(3);
    _authorities.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户权限列表");
        return res;
      }
    }.get());
    _authorities.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_authorities);
    ComponentItem _department = new ComponentItem();
    _department.setClzName("com.apihug.rad.api.customer.DepartmentInfo");
    _department.setName("department");
    _department.setFieldName("department");
    _department.setTag(4);
    _department.setProtoLine(363);
    _department.setProtoColumn(3);
    _department.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户部门信息");
        return res;
      }
    }.get());
    res.addItem(_department);
    ComponentItem _currentTenant = new ComponentItem();
    _currentTenant.setClzName("com.apihug.rad.api.customer.TenantInfo");
    _currentTenant.setName("current_tenant");
    _currentTenant.setFieldName("currentTenant");
    _currentTenant.setTag(5);
    _currentTenant.setProtoLine(367);
    _currentTenant.setProtoColumn(3);
    _currentTenant.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("当前租户信息");
        return res;
      }
    }.get());
    res.addItem(_currentTenant);
    components.put("com.apihug.rad.api.customer.CurrentCustomerInfo", res);
  }

  void initComponentapi_customerCustomerInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CustomerInfo");
    res.setName("CustomerInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(304);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerInfo");
    res.setDescription("客户信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setDescription("客户信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(1);
    _customerId.setProtoLine(311);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            NumberRule _numberRule = new NumberRule();
            _numberRule.setMax(1000l);
            _numberRule.setMin(1036l);
            res.setNumberRule(_numberRule);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _username = new ComponentItem();
    _username.setClzName("java.lang.String");
    _username.setName("username");
    _username.setFieldName("username");
    _username.setTag(3);
    _username.setProtoLine(319);
    _username.setProtoColumn(3);
    _username.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户名");
        res.setExample("admin");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_username);
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(4);
    _tenantId.setProtoLine(326);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            NumberRule _numberRule = new NumberRule();
            _numberRule.setMax(1000l);
            _numberRule.setMin(1036l);
            res.setNumberRule(_numberRule);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    ComponentItem _roles = new ComponentItem();
    _roles.setClzName("java.lang.String");
    _roles.setName("roles");
    _roles.setFieldName("roles");
    _roles.setTag(5);
    _roles.setProtoLine(334);
    _roles.setProtoColumn(3);
    _roles.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户角色列表");
        return res;
      }
    }.get());
    _roles.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_roles);
    ComponentItem _authorities = new ComponentItem();
    _authorities.setClzName("java.lang.String");
    _authorities.setName("authorities");
    _authorities.setFieldName("authorities");
    _authorities.setTag(6);
    _authorities.setProtoLine(338);
    _authorities.setProtoColumn(3);
    _authorities.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户权限列表");
        return res;
      }
    }.get());
    _authorities.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_authorities);
    components.put("com.apihug.rad.api.customer.CustomerInfo", res);
  }

  void initComponentapi_customerCustomerSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CustomerSummary");
    res.setName("CustomerSummary");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(451);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerSummary");
    res.setDescription("客户摘要信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CustomerSummary");
            res.setDescription("客户摘要信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(459);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _username = new ComponentItem();
    _username.setClzName("java.lang.String");
    _username.setName("username");
    _username.setFieldName("username");
    _username.setTag(2);
    _username.setProtoLine(466);
    _username.setProtoColumn(3);
    _username.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户名");
        res.setExample("zhangsan");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_username);
    ComponentItem _email = new ComponentItem();
    _email.setClzName("java.lang.String");
    _email.setName("email");
    _email.setFieldName("email");
    _email.setTag(3);
    _email.setProtoLine(473);
    _email.setProtoColumn(3);
    _email.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("邮箱");
        res.setExample("zhangsan@example.com");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.EMAIL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_email);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.customer.CustomerStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(480);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(5);
    _tenantId.setProtoLine(486);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    components.put("com.apihug.rad.api.customer.CustomerSummary", res);
  }

  void initComponentapi_customerDepartmentInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.DepartmentInfo");
    res.setName("DepartmentInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(567);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentInfo");
    res.setDescription("部门信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("DepartmentInfo");
            res.setDescription("部门信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(575);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _deptCode = new ComponentItem();
    _deptCode.setClzName("java.lang.String");
    _deptCode.setName("dept_code");
    _deptCode.setFieldName("deptCode");
    _deptCode.setTag(2);
    _deptCode.setProtoLine(581);
    _deptCode.setProtoColumn(3);
    _deptCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门代码");
        res.setExample("tech_dev");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptCode);
    ComponentItem _deptName = new ComponentItem();
    _deptName.setClzName("java.lang.String");
    _deptName.setName("dept_name");
    _deptName.setFieldName("deptName");
    _deptName.setTag(3);
    _deptName.setProtoLine(588);
    _deptName.setProtoColumn(3);
    _deptName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门名称");
        res.setExample("研发部");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptName);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(4);
    _parentId.setProtoLine(595);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父部门 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_parentId);
    components.put("com.apihug.rad.api.customer.DepartmentInfo", res);
  }

  void initComponentapi_customerForgotPasswordRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.ForgotPasswordRequest");
    res.setName("ForgotPasswordRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(496);
    res.setProtoColumn(1);
    res.setProtoEntity("ForgotPasswordRequest");
    res.setDescription("CustomerDetail, UpdateCustomerRequest, SearchCustomersRequest 已移除\n"
            + "租户内成员查看/搜索/管理 → TenantMemberService\n"
            + "找回密码请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("ForgotPasswordRequest");
            res.setDescription("找回密码请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _email = new ComponentItem();
    _email.setClzName("java.lang.String");
    _email.setName("email");
    _email.setFieldName("email");
    _email.setTag(1);
    _email.setProtoLine(504);
    _email.setProtoColumn(3);
    _email.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("邮箱");
        res.setExample("zhangsan@example.com");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.EMAIL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_email);
    components.put("com.apihug.rad.api.customer.ForgotPasswordRequest", res);
  }

  void initComponentapi_customerLoginRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.LoginRequest");
    res.setName("LoginRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(188);
    res.setProtoColumn(1);
    res.setProtoEntity("LoginRequest");
    res.setDescription("============ 消息类型定义 ============\n"
            + "登录请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("LoginRequest");
            res.setDescription("登录请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _username = new ComponentItem();
    _username.setClzName("java.lang.String");
    _username.setName("username");
    _username.setFieldName("username");
    _username.setTag(1);
    _username.setProtoLine(196);
    _username.setProtoColumn(3);
    _username.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户名");
        res.setExample("admin");
        res.setMaxLength(50l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_username);
    ComponentItem _password = new ComponentItem();
    _password.setClzName("java.lang.String");
    _password.setName("password");
    _password.setFieldName("password");
    _password.setTag(2);
    _password.setProtoLine(204);
    _password.setProtoColumn(3);
    _password.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("密码");
        res.setExample("password123");
        res.setMaxLength(100l);
        res.setMinLength(6l);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_password);
    ComponentItem _rememberMe = new ComponentItem();
    _rememberMe.setClzName("java.lang.Boolean");
    _rememberMe.setName("remember_me");
    _rememberMe.setFieldName("rememberMe");
    _rememberMe.setTag(3);
    _rememberMe.setProtoLine(212);
    _rememberMe.setProtoColumn(3);
    _rememberMe.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("whether to remember me");
        return res;
      }
    }.get());
    res.addItem(_rememberMe);
    components.put("com.apihug.rad.api.customer.LoginRequest", res);
  }

  void initComponentapi_customerLoginResponse() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.LoginResponse");
    res.setName("LoginResponse");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(217);
    res.setProtoColumn(1);
    res.setProtoEntity("LoginResponse");
    res.setDescription("登录响应");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("LoginResponse");
            res.setDescription("登录响应");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _accessToken = new ComponentItem();
    _accessToken.setClzName("java.lang.String");
    _accessToken.setName("access_token");
    _accessToken.setFieldName("accessToken");
    _accessToken.setTag(1);
    _accessToken.setProtoLine(225);
    _accessToken.setProtoColumn(3);
    _accessToken.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("访问令牌");
        res.setExample("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.GUID);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_accessToken);
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(2);
    _customerId.setProtoLine(232);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            NumberRule _numberRule = new NumberRule();
            _numberRule.setMax(1000l);
            _numberRule.setMin(1036l);
            res.setNumberRule(_numberRule);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _username = new ComponentItem();
    _username.setClzName("java.lang.String");
    _username.setName("username");
    _username.setFieldName("username");
    _username.setTag(3);
    _username.setProtoLine(240);
    _username.setProtoColumn(3);
    _username.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户名");
        res.setExample("admin");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_username);
    ComponentItem _needsTenantSelection = new ComponentItem();
    _needsTenantSelection.setClzName("java.lang.Boolean");
    _needsTenantSelection.setName("needs_tenant_selection");
    _needsTenantSelection.setFieldName("needsTenantSelection");
    _needsTenantSelection.setTag(4);
    _needsTenantSelection.setProtoLine(248);
    _needsTenantSelection.setProtoColumn(3);
    _needsTenantSelection.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否需要选择租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_needsTenantSelection);
    ComponentItem _tenants = new ComponentItem();
    _tenants.setClzName("com.apihug.rad.api.customer.TenantInfo");
    _tenants.setName("tenants");
    _tenants.setFieldName("tenants");
    _tenants.setTag(5);
    _tenants.setProtoLine(254);
    _tenants.setProtoColumn(3);
    _tenants.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户的租户列表");
        return res;
      }
    }.get());
    _tenants.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_tenants);
    ComponentItem _defaultTenant = new ComponentItem();
    _defaultTenant.setClzName("com.apihug.rad.api.customer.TenantInfo");
    _defaultTenant.setName("default_tenant");
    _defaultTenant.setFieldName("defaultTenant");
    _defaultTenant.setTag(6);
    _defaultTenant.setProtoLine(259);
    _defaultTenant.setProtoColumn(3);
    _defaultTenant.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("默认租户信息");
        return res;
      }
    }.get());
    res.addItem(_defaultTenant);
    components.put("com.apihug.rad.api.customer.LoginResponse", res);
  }

  void initComponentapi_customerResetPasswordRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.ResetPasswordRequest");
    res.setName("ResetPasswordRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(513);
    res.setProtoColumn(1);
    res.setProtoEntity("ResetPasswordRequest");
    res.setDescription("重置密码请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("ResetPasswordRequest");
            res.setDescription("重置密码请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _token = new ComponentItem();
    _token.setClzName("java.lang.String");
    _token.setName("token");
    _token.setFieldName("token");
    _token.setTag(1);
    _token.setProtoLine(521);
    _token.setProtoColumn(3);
    _token.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("重置 token");
        res.setExample("abc123xyz");
        res.setMaxLength(255l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.GUID);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_token);
    ComponentItem _password = new ComponentItem();
    _password.setClzName("java.lang.String");
    _password.setName("password");
    _password.setFieldName("password");
    _password.setTag(2);
    _password.setProtoLine(529);
    _password.setProtoColumn(3);
    _password.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("新密码");
        res.setExample("NewSecureP@ss123");
        res.setMaxLength(100l);
        res.setMinLength(6l);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_password);
    components.put("com.apihug.rad.api.customer.ResetPasswordRequest", res);
  }

  void initComponentapi_customerRoleInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.RoleInfo");
    res.setName("RoleInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(538);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleInfo");
    res.setDescription("角色信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RoleInfo");
            res.setDescription("角色信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(546);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _roleCode = new ComponentItem();
    _roleCode.setClzName("java.lang.String");
    _roleCode.setName("role_code");
    _roleCode.setFieldName("roleCode");
    _roleCode.setTag(2);
    _roleCode.setProtoLine(552);
    _roleCode.setProtoColumn(3);
    _roleCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色代码");
        res.setExample("admin");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleCode);
    ComponentItem _roleName = new ComponentItem();
    _roleName.setClzName("java.lang.String");
    _roleName.setName("role_name");
    _roleName.setFieldName("roleName");
    _roleName.setTag(3);
    _roleName.setProtoLine(559);
    _roleName.setProtoColumn(3);
    _roleName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色名称");
        res.setExample("管理员");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleName);
    components.put("com.apihug.rad.api.customer.RoleInfo", res);
  }

  void initComponentapi_customerSwitchTenantRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.SwitchTenantRequest");
    res.setName("SwitchTenantRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(390);
    res.setProtoColumn(1);
    res.setProtoEntity("SwitchTenantRequest");
    res.setDescription("切换租户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SwitchTenantRequest");
            res.setDescription("切换租户请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(1);
    _tenantId.setProtoLine(398);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("目标租户 ID");
        res.setExample("2");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    components.put("com.apihug.rad.api.customer.SwitchTenantRequest", res);
  }

  void initComponentapi_customerTenantInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.TenantInfo");
    res.setName("TenantInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(265);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantInfo");
    res.setDescription("租户信息（用于登录响应、客户租户列表等）\n"
            + "租户信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TenantInfo");
            res.setDescription("租户信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(273);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _tenantCode = new ComponentItem();
    _tenantCode.setClzName("java.lang.String");
    _tenantCode.setName("tenant_code");
    _tenantCode.setFieldName("tenantCode");
    _tenantCode.setTag(2);
    _tenantCode.setProtoLine(279);
    _tenantCode.setProtoColumn(3);
    _tenantCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户代码");
        res.setExample("acme_corp");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantCode);
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(3);
    _tenantName.setProtoLine(286);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(4);
    _isDefault.setProtoLine(293);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否默认租户");
        res.setExample("true");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    ComponentItem _isPlatform = new ComponentItem();
    _isPlatform.setClzName("java.lang.Boolean");
    _isPlatform.setName("is_platform");
    _isPlatform.setFieldName("isPlatform");
    _isPlatform.setTag(5);
    _isPlatform.setProtoLine(298);
    _isPlatform.setProtoColumn(3);
    _isPlatform.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否平台租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isPlatform);
    components.put("com.apihug.rad.api.customer.TenantInfo", res);
  }

  void initComponentapi_customerTenantList() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.TenantList");
    res.setName("TenantList");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(372);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantList");
    res.setDescription("租户列表");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TenantList");
            res.setDescription("租户列表");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _tenants = new ComponentItem();
    _tenants.setClzName("com.apihug.rad.api.customer.TenantInfo");
    _tenants.setName("tenants");
    _tenants.setFieldName("tenants");
    _tenants.setTag(1);
    _tenants.setProtoLine(380);
    _tenants.setProtoColumn(3);
    _tenants.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户列表");
        return res;
      }
    }.get());
    _tenants.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_tenants);
    ComponentItem _defaultTenantId = new ComponentItem();
    _defaultTenantId.setClzName("java.lang.Long");
    _defaultTenantId.setName("default_tenant_id");
    _defaultTenantId.setFieldName("defaultTenantId");
    _defaultTenantId.setTag(2);
    _defaultTenantId.setProtoLine(384);
    _defaultTenantId.setProtoColumn(3);
    _defaultTenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("默认租户 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_defaultTenantId);
    components.put("com.apihug.rad.api.customer.TenantList", res);
  }

  void initComponentapi_departmentCreateDepartmentRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.CreateDepartmentRequest");
    res.setName("CreateDepartmentRequest");
    res.setProtoFrom("com/apihug/rad/api/department/api.proto");
    res.setProtoLine(114);
    res.setProtoColumn(1);
    res.setProtoEntity("CreateDepartmentRequest");
    res.setDescription("创建部门请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CreateDepartmentRequest");
            res.setDescription("创建部门请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(1);
    _tenantId.setProtoLine(122);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID（从当前上下文获取）");
        res.setExample("1");
        res.setMinimum(1.0D);
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(2);
    _parentId.setProtoLine(128);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父部门 ID（0 表示根部门）");
        res.setExample("0");
        res.setMinimum(0.0D);
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _deptCode = new ComponentItem();
    _deptCode.setClzName("java.lang.String");
    _deptCode.setName("dept_code");
    _deptCode.setFieldName("deptCode");
    _deptCode.setTag(3);
    _deptCode.setProtoLine(134);
    _deptCode.setProtoColumn(3);
    _deptCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门代码");
        res.setExample("tech_dev");
        res.setMaxLength(50l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptCode);
    ComponentItem _deptName = new ComponentItem();
    _deptName.setClzName("java.lang.String");
    _deptName.setName("dept_name");
    _deptName.setFieldName("deptName");
    _deptName.setTag(4);
    _deptName.setProtoLine(142);
    _deptName.setProtoColumn(3);
    _deptName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门名称");
        res.setExample("研发部");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptName);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(5);
    _sortOrder.setProtoLine(150);
    _sortOrder.setProtoColumn(3);
    _sortOrder.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("排序顺序");
        res.setExample("10");
        return res;
      }
    }.get());
    res.addItem(_sortOrder);
    ComponentItem _managerId = new ComponentItem();
    _managerId.setClzName("java.lang.String");
    _managerId.setName("manager_id");
    _managerId.setFieldName("managerId");
    _managerId.setTag(6);
    _managerId.setProtoLine(155);
    _managerId.setProtoColumn(3);
    _managerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门负责人 ID");
        res.setExample("1");
        res.setMaxLength(50l);
        return res;
      }
    }.get());
    res.addItem(_managerId);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.department.DeptStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(7);
    _status.setProtoLine(161);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.department.CreateDepartmentRequest", res);
  }

  void initComponentapi_departmentDepartmentDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.DepartmentDetail");
    res.setName("DepartmentDetail");
    res.setProtoFrom("com/apihug/rad/api/department/api.proto");
    res.setProtoLine(244);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentDetail");
    res.setDescription("部门详情信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("DepartmentDetail");
            res.setDescription("部门详情信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(252);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(2);
    _parentId.setProtoLine(259);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父部门 ID");
        res.setExample("0");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _deptCode = new ComponentItem();
    _deptCode.setClzName("java.lang.String");
    _deptCode.setName("dept_code");
    _deptCode.setFieldName("deptCode");
    _deptCode.setTag(3);
    _deptCode.setProtoLine(265);
    _deptCode.setProtoColumn(3);
    _deptCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门代码");
        res.setExample("tech_dev");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptCode);
    ComponentItem _deptName = new ComponentItem();
    _deptName.setClzName("java.lang.String");
    _deptName.setName("dept_name");
    _deptName.setFieldName("deptName");
    _deptName.setTag(4);
    _deptName.setProtoLine(272);
    _deptName.setProtoColumn(3);
    _deptName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门名称");
        res.setExample("研发部");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptName);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(5);
    _sortOrder.setProtoLine(279);
    _sortOrder.setProtoColumn(3);
    _sortOrder.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("排序顺序");
        res.setExample("10");
        return res;
      }
    }.get());
    res.addItem(_sortOrder);
    ComponentItem _managerId = new ComponentItem();
    _managerId.setClzName("java.lang.String");
    _managerId.setName("manager_id");
    _managerId.setFieldName("managerId");
    _managerId.setTag(6);
    _managerId.setProtoLine(284);
    _managerId.setProtoColumn(3);
    _managerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门负责人 ID");
        res.setExample("1");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_managerId);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.department.DeptStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(7);
    _status.setProtoLine(290);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(8);
    _createdAt.setProtoLine(296);
    _createdAt.setProtoColumn(3);
    _createdAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("创建时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_createdAt);
    components.put("com.apihug.rad.api.department.DepartmentDetail", res);
  }

  void initComponentapi_departmentDepartmentSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.DepartmentSummary");
    res.setName("DepartmentSummary");
    res.setProtoFrom("com/apihug/rad/api/department/api.proto");
    res.setProtoLine(202);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentSummary");
    res.setDescription("部门摘要信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("DepartmentSummary");
            res.setDescription("部门摘要信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(210);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(2);
    _parentId.setProtoLine(217);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父部门 ID");
        res.setExample("0");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _deptCode = new ComponentItem();
    _deptCode.setClzName("java.lang.String");
    _deptCode.setName("dept_code");
    _deptCode.setFieldName("deptCode");
    _deptCode.setTag(3);
    _deptCode.setProtoLine(223);
    _deptCode.setProtoColumn(3);
    _deptCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门代码");
        res.setExample("tech_dev");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptCode);
    ComponentItem _deptName = new ComponentItem();
    _deptName.setClzName("java.lang.String");
    _deptName.setName("dept_name");
    _deptName.setFieldName("deptName");
    _deptName.setTag(4);
    _deptName.setProtoLine(230);
    _deptName.setProtoColumn(3);
    _deptName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门名称");
        res.setExample("研发部");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptName);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.department.DeptStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(5);
    _status.setProtoLine(237);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.department.DepartmentSummary", res);
  }

  void initComponentapi_departmentDepartmentTreeNode() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.DepartmentTreeNode");
    res.setName("DepartmentTreeNode");
    res.setProtoFrom("com/apihug/rad/api/department/api.proto");
    res.setProtoLine(303);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentTreeNode");
    res.setDescription("部门树节点");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("DepartmentTreeNode");
            res.setDescription("部门树节点");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _department = new ComponentItem();
    _department.setClzName("com.apihug.rad.api.department.DepartmentSummary");
    _department.setName("department");
    _department.setFieldName("department");
    _department.setTag(1);
    _department.setProtoLine(311);
    _department.setProtoColumn(3);
    _department.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门信息");
        return res;
      }
    }.get());
    res.addItem(_department);
    ComponentItem _children = new ComponentItem();
    _children.setClzName("com.apihug.rad.api.department.DepartmentTreeNode");
    _children.setName("children");
    _children.setFieldName("children");
    _children.setTag(2);
    _children.setProtoLine(315);
    _children.setProtoColumn(3);
    _children.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("子部门列表");
        return res;
      }
    }.get());
    _children.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_children);
    components.put("com.apihug.rad.api.department.DepartmentTreeNode", res);
  }

  void initComponentapi_departmentUpdateDepartmentRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.UpdateDepartmentRequest");
    res.setName("UpdateDepartmentRequest");
    res.setProtoFrom("com/apihug/rad/api/department/api.proto");
    res.setProtoLine(168);
    res.setProtoColumn(1);
    res.setProtoEntity("UpdateDepartmentRequest");
    res.setDescription("更新部门请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UpdateDepartmentRequest");
            res.setDescription("更新部门请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _deptName = new ComponentItem();
    _deptName.setClzName("java.lang.String");
    _deptName.setName("dept_name");
    _deptName.setFieldName("deptName");
    _deptName.setTag(1);
    _deptName.setProtoLine(176);
    _deptName.setProtoColumn(3);
    _deptName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门名称");
        res.setExample("研发部");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_deptName);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(2);
    _sortOrder.setProtoLine(184);
    _sortOrder.setProtoColumn(3);
    _sortOrder.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("排序顺序");
        res.setExample("10");
        return res;
      }
    }.get());
    res.addItem(_sortOrder);
    ComponentItem _managerId = new ComponentItem();
    _managerId.setClzName("java.lang.String");
    _managerId.setName("manager_id");
    _managerId.setFieldName("managerId");
    _managerId.setTag(3);
    _managerId.setProtoLine(189);
    _managerId.setProtoColumn(3);
    _managerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门负责人 ID");
        res.setExample("1");
        res.setMaxLength(50l);
        return res;
      }
    }.get());
    res.addItem(_managerId);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.department.DeptStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(195);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.department.UpdateDepartmentRequest", res);
  }

  void initComponentapi_menuCreateMenuRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.menu.CreateMenuRequest");
    res.setName("CreateMenuRequest");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(155);
    res.setProtoColumn(1);
    res.setProtoEntity("CreateMenuRequest");
    res.setDescription("创建菜单请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CreateMenuRequest");
            res.setDescription("创建菜单请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(1);
    _parentId.setProtoLine(163);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父菜单 ID（0 表示根菜单）");
        res.setExample("0");
        res.setMinimum(0.0D);
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _menuCode = new ComponentItem();
    _menuCode.setClzName("java.lang.String");
    _menuCode.setName("menu_code");
    _menuCode.setFieldName("menuCode");
    _menuCode.setTag(2);
    _menuCode.setProtoLine(169);
    _menuCode.setProtoColumn(3);
    _menuCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单代码");
        res.setExample("system_user");
        res.setMaxLength(50l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuCode);
    ComponentItem _menuName = new ComponentItem();
    _menuName.setClzName("java.lang.String");
    _menuName.setName("menu_name");
    _menuName.setFieldName("menuName");
    _menuName.setTag(3);
    _menuName.setProtoLine(177);
    _menuName.setProtoColumn(3);
    _menuName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单名称");
        res.setExample("用户管理");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuName);
    ComponentItem _path = new ComponentItem();
    _path.setClzName("java.lang.String");
    _path.setName("path");
    _path.setFieldName("path");
    _path.setTag(4);
    _path.setProtoLine(185);
    _path.setProtoColumn(3);
    _path.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单路径");
        res.setExample("/system/user");
        res.setMaxLength(255l);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.URL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_path);
    ComponentItem _icon = new ComponentItem();
    _icon.setClzName("java.lang.String");
    _icon.setName("icon");
    _icon.setFieldName("icon");
    _icon.setTag(5);
    _icon.setProtoLine(192);
    _icon.setProtoColumn(3);
    _icon.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单图标");
        res.setExample("lucide:users");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_icon);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(6);
    _sortOrder.setProtoLine(198);
    _sortOrder.setProtoColumn(3);
    _sortOrder.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("排序顺序（数字越小越靠前）");
        res.setExample("10");
        return res;
      }
    }.get());
    res.addItem(_sortOrder);
    ComponentItem _menuType = new ComponentItem();
    _menuType.setClzName("com.apihug.rad.infra.menu.MenuTypeEnum");
    _menuType.setName("menu_type");
    _menuType.setFieldName("menuType");
    _menuType.setTag(7);
    _menuType.setProtoLine(203);
    _menuType.setProtoColumn(3);
    _menuType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单类型");
        res.setExample("MENU");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_menuType);
    ComponentItem _permissionCode = new ComponentItem();
    _permissionCode.setClzName("java.lang.String");
    _permissionCode.setName("permission_code");
    _permissionCode.setFieldName("permissionCode");
    _permissionCode.setTag(8);
    _permissionCode.setProtoLine(209);
    _permissionCode.setProtoColumn(3);
    _permissionCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("关联的权限代码");
        res.setExample("user:view");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_permissionCode);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.menu.MenuStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(9);
    _status.setProtoLine(215);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.menu.CreateMenuRequest", res);
  }

  void initComponentapi_menuMenuDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.menu.MenuDetail");
    res.setName("MenuDetail");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(329);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuDetail");
    res.setDescription("菜单详情信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("MenuDetail");
            res.setDescription("菜单详情信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(337);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(2);
    _parentId.setProtoLine(344);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父菜单 ID");
        res.setExample("0");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _menuCode = new ComponentItem();
    _menuCode.setClzName("java.lang.String");
    _menuCode.setName("menu_code");
    _menuCode.setFieldName("menuCode");
    _menuCode.setTag(3);
    _menuCode.setProtoLine(350);
    _menuCode.setProtoColumn(3);
    _menuCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单代码");
        res.setExample("system_user");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuCode);
    ComponentItem _menuName = new ComponentItem();
    _menuName.setClzName("java.lang.String");
    _menuName.setName("menu_name");
    _menuName.setFieldName("menuName");
    _menuName.setTag(4);
    _menuName.setProtoLine(357);
    _menuName.setProtoColumn(3);
    _menuName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单名称");
        res.setExample("用户管理");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuName);
    ComponentItem _path = new ComponentItem();
    _path.setClzName("java.lang.String");
    _path.setName("path");
    _path.setFieldName("path");
    _path.setTag(5);
    _path.setProtoLine(364);
    _path.setProtoColumn(3);
    _path.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单路径");
        res.setExample("/system/user");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.URL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_path);
    ComponentItem _icon = new ComponentItem();
    _icon.setClzName("java.lang.String");
    _icon.setName("icon");
    _icon.setFieldName("icon");
    _icon.setTag(6);
    _icon.setProtoLine(370);
    _icon.setProtoColumn(3);
    _icon.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单图标");
        res.setExample("lucide:users");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_icon);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(7);
    _sortOrder.setProtoLine(376);
    _sortOrder.setProtoColumn(3);
    _sortOrder.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("排序顺序");
        res.setExample("10");
        return res;
      }
    }.get());
    res.addItem(_sortOrder);
    ComponentItem _menuType = new ComponentItem();
    _menuType.setClzName("com.apihug.rad.infra.menu.MenuTypeEnum");
    _menuType.setName("menu_type");
    _menuType.setFieldName("menuType");
    _menuType.setTag(8);
    _menuType.setProtoLine(381);
    _menuType.setProtoColumn(3);
    _menuType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单类型");
        res.setExample("MENU");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_menuType);
    ComponentItem _permissionCode = new ComponentItem();
    _permissionCode.setClzName("java.lang.String");
    _permissionCode.setName("permission_code");
    _permissionCode.setFieldName("permissionCode");
    _permissionCode.setTag(9);
    _permissionCode.setProtoLine(387);
    _permissionCode.setProtoColumn(3);
    _permissionCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("关联的权限代码");
        res.setExample("user:view");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_permissionCode);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.menu.MenuStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(10);
    _status.setProtoLine(393);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(11);
    _createdAt.setProtoLine(399);
    _createdAt.setProtoColumn(3);
    _createdAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("创建时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_createdAt);
    ComponentItem _updatedAt = new ComponentItem();
    _updatedAt.setClzName("java.time.LocalDateTime");
    _updatedAt.setName("updated_at");
    _updatedAt.setFieldName("updatedAt");
    _updatedAt.setTag(12);
    _updatedAt.setProtoLine(405);
    _updatedAt.setProtoColumn(3);
    _updatedAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("更新时间");
        res.setExample("2024-01-16T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_updatedAt);
    components.put("com.apihug.rad.api.menu.MenuDetail", res);
  }

  void initComponentapi_menuMenuSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.menu.MenuSummary");
    res.setName("MenuSummary");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(275);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuSummary");
    res.setDescription("菜单摘要信息（列表用）");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("MenuSummary");
            res.setDescription("菜单摘要信息（列表用）");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(283);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(2);
    _parentId.setProtoLine(290);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父菜单 ID");
        res.setExample("0");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _menuCode = new ComponentItem();
    _menuCode.setClzName("java.lang.String");
    _menuCode.setName("menu_code");
    _menuCode.setFieldName("menuCode");
    _menuCode.setTag(3);
    _menuCode.setProtoLine(296);
    _menuCode.setProtoColumn(3);
    _menuCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单代码");
        res.setExample("system_user");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuCode);
    ComponentItem _menuName = new ComponentItem();
    _menuName.setClzName("java.lang.String");
    _menuName.setName("menu_name");
    _menuName.setFieldName("menuName");
    _menuName.setTag(4);
    _menuName.setProtoLine(303);
    _menuName.setProtoColumn(3);
    _menuName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单名称");
        res.setExample("用户管理");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuName);
    ComponentItem _path = new ComponentItem();
    _path.setClzName("java.lang.String");
    _path.setName("path");
    _path.setFieldName("path");
    _path.setTag(5);
    _path.setProtoLine(310);
    _path.setProtoColumn(3);
    _path.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单路径");
        res.setExample("/system/user");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.URL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_path);
    ComponentItem _menuType = new ComponentItem();
    _menuType.setClzName("com.apihug.rad.infra.menu.MenuTypeEnum");
    _menuType.setName("menu_type");
    _menuType.setFieldName("menuType");
    _menuType.setTag(6);
    _menuType.setProtoLine(316);
    _menuType.setProtoColumn(3);
    _menuType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单类型");
        res.setExample("MENU");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_menuType);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.menu.MenuStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(7);
    _status.setProtoLine(322);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.menu.MenuSummary", res);
  }

  void initComponentapi_menuMenuTreeNode() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.menu.MenuTreeNode");
    res.setName("MenuTreeNode");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(412);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuTreeNode");
    res.setDescription("菜单树节点");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("MenuTreeNode");
            res.setDescription("菜单树节点");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _menu = new ComponentItem();
    _menu.setClzName("com.apihug.rad.api.menu.MenuSummary");
    _menu.setName("menu");
    _menu.setFieldName("menu");
    _menu.setTag(1);
    _menu.setProtoLine(420);
    _menu.setProtoColumn(3);
    _menu.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单信息");
        return res;
      }
    }.get());
    res.addItem(_menu);
    ComponentItem _children = new ComponentItem();
    _children.setClzName("com.apihug.rad.api.menu.MenuTreeNode");
    _children.setName("children");
    _children.setFieldName("children");
    _children.setTag(2);
    _children.setProtoLine(424);
    _children.setProtoColumn(3);
    _children.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("子菜单列表");
        return res;
      }
    }.get());
    _children.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_children);
    components.put("com.apihug.rad.api.menu.MenuTreeNode", res);
  }

  void initComponentapi_menuSearchMenusRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.menu.SearchMenusRequest");
    res.setName("SearchMenusRequest");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(429);
    res.setProtoColumn(1);
    res.setProtoEntity("SearchMenusRequest");
    res.setDescription("搜索菜单请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SearchMenusRequest");
            res.setDescription("搜索菜单请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _keyword = new ComponentItem();
    _keyword.setClzName("java.lang.String");
    _keyword.setName("keyword");
    _keyword.setFieldName("keyword");
    _keyword.setTag(1);
    _keyword.setProtoLine(437);
    _keyword.setProtoColumn(3);
    _keyword.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("搜索关键词（菜单代码或名称）");
        res.setExample("user");
        return res;
      }
    }.get());
    res.addItem(_keyword);
    ComponentItem _menuType = new ComponentItem();
    _menuType.setClzName("com.apihug.rad.infra.menu.MenuTypeEnum");
    _menuType.setName("menu_type");
    _menuType.setFieldName("menuType");
    _menuType.setTag(2);
    _menuType.setProtoLine(442);
    _menuType.setProtoColumn(3);
    _menuType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单类型筛选");
        res.setExample("MENU");
        return res;
      }
    }.get());
    res.addItem(_menuType);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.menu.MenuStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(3);
    _status.setProtoLine(447);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单状态筛选");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.menu.SearchMenusRequest", res);
  }

  void initComponentapi_menuUpdateMenuRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.menu.UpdateMenuRequest");
    res.setName("UpdateMenuRequest");
    res.setProtoFrom("com/apihug/rad/api/menu/api.proto");
    res.setProtoLine(222);
    res.setProtoColumn(1);
    res.setProtoEntity("UpdateMenuRequest");
    res.setDescription("更新菜单请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UpdateMenuRequest");
            res.setDescription("更新菜单请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _menuName = new ComponentItem();
    _menuName.setClzName("java.lang.String");
    _menuName.setName("menu_name");
    _menuName.setFieldName("menuName");
    _menuName.setTag(1);
    _menuName.setProtoLine(230);
    _menuName.setProtoColumn(3);
    _menuName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单名称");
        res.setExample("用户管理");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_menuName);
    ComponentItem _path = new ComponentItem();
    _path.setClzName("java.lang.String");
    _path.setName("path");
    _path.setFieldName("path");
    _path.setTag(2);
    _path.setProtoLine(238);
    _path.setProtoColumn(3);
    _path.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单路径");
        res.setExample("/system/user");
        res.setMaxLength(255l);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.URL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_path);
    ComponentItem _icon = new ComponentItem();
    _icon.setClzName("java.lang.String");
    _icon.setName("icon");
    _icon.setFieldName("icon");
    _icon.setTag(3);
    _icon.setProtoLine(245);
    _icon.setProtoColumn(3);
    _icon.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单图标");
        res.setExample("lucide:users");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_icon);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(4);
    _sortOrder.setProtoLine(251);
    _sortOrder.setProtoColumn(3);
    _sortOrder.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("排序顺序");
        res.setExample("10");
        return res;
      }
    }.get());
    res.addItem(_sortOrder);
    ComponentItem _menuType = new ComponentItem();
    _menuType.setClzName("com.apihug.rad.infra.menu.MenuTypeEnum");
    _menuType.setName("menu_type");
    _menuType.setFieldName("menuType");
    _menuType.setTag(5);
    _menuType.setProtoLine(256);
    _menuType.setProtoColumn(3);
    _menuType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单类型");
        res.setExample("MENU");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_menuType);
    ComponentItem _permissionCode = new ComponentItem();
    _permissionCode.setClzName("java.lang.String");
    _permissionCode.setName("permission_code");
    _permissionCode.setFieldName("permissionCode");
    _permissionCode.setTag(6);
    _permissionCode.setProtoLine(262);
    _permissionCode.setProtoColumn(3);
    _permissionCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("关联的权限代码");
        res.setExample("user:view");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_permissionCode);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.menu.MenuStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(7);
    _status.setProtoLine(268);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.menu.UpdateMenuRequest", res);
  }

  void initComponentapi_permissionPermissionInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.permission.PermissionInfo");
    res.setName("PermissionInfo");
    res.setProtoFrom("com/apihug/rad/api/permission/api.proto");
    res.setProtoLine(60);
    res.setProtoColumn(1);
    res.setProtoEntity("PermissionInfo");
    res.setDescription("权限信息\n"
            + "权限信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("PermissionInfo");
            res.setDescription("权限信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _permissionCode = new ComponentItem();
    _permissionCode.setClzName("java.lang.String");
    _permissionCode.setName("permission_code");
    _permissionCode.setFieldName("permissionCode");
    _permissionCode.setTag(1);
    _permissionCode.setProtoLine(68);
    _permissionCode.setProtoColumn(3);
    _permissionCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限代码");
        res.setExample("customer:create");
        return res;
      }
    }.get());
    res.addItem(_permissionCode);
    ComponentItem _permissionName = new ComponentItem();
    _permissionName.setClzName("java.lang.String");
    _permissionName.setName("permission_name");
    _permissionName.setFieldName("permissionName");
    _permissionName.setTag(2);
    _permissionName.setProtoLine(73);
    _permissionName.setProtoColumn(3);
    _permissionName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限名称");
        res.setExample("创建客户");
        return res;
      }
    }.get());
    res.addItem(_permissionName);
    components.put("com.apihug.rad.api.permission.PermissionInfo", res);
  }

  void initComponentapi_roleAssignMenusRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.AssignMenusRequest");
    res.setName("AssignMenusRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(401);
    res.setProtoColumn(1);
    res.setProtoEntity("AssignMenusRequest");
    res.setDescription("分配菜单请求（全量覆盖）");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AssignMenusRequest");
            res.setDescription("分配菜单请求（全量覆盖）");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _menuIds = new ComponentItem();
    _menuIds.setClzName("java.lang.Long");
    _menuIds.setName("menu_ids");
    _menuIds.setFieldName("menuIds");
    _menuIds.setTag(1);
    _menuIds.setProtoLine(409);
    _menuIds.setProtoColumn(3);
    _menuIds.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单 ID 列表");
        res.setExample("[1, 2, 3]");
        res.setEmpty(false);
        return res;
      }
    }.get());
    _menuIds.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_menuIds);
    components.put("com.apihug.rad.api.role.AssignMenusRequest", res);
  }

  void initComponentapi_roleCreateRoleRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.CreateRoleRequest");
    res.setName("CreateRoleRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(224);
    res.setProtoColumn(1);
    res.setProtoEntity("CreateRoleRequest");
    res.setDescription("创建角色请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CreateRoleRequest");
            res.setDescription("创建角色请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _roleCode = new ComponentItem();
    _roleCode.setClzName("java.lang.String");
    _roleCode.setName("role_code");
    _roleCode.setFieldName("roleCode");
    _roleCode.setTag(1);
    _roleCode.setProtoLine(232);
    _roleCode.setProtoColumn(3);
    _roleCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色代码");
        res.setExample("admin");
        res.setMaxLength(50l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleCode);
    ComponentItem _roleName = new ComponentItem();
    _roleName.setClzName("java.lang.String");
    _roleName.setName("role_name");
    _roleName.setFieldName("roleName");
    _roleName.setTag(2);
    _roleName.setProtoLine(240);
    _roleName.setProtoColumn(3);
    _roleName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色名称");
        res.setExample("管理员");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleName);
    ComponentItem _description = new ComponentItem();
    _description.setClzName("java.lang.String");
    _description.setName("description");
    _description.setFieldName("description");
    _description.setTag(3);
    _description.setProtoLine(248);
    _description.setProtoColumn(3);
    _description.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色描述");
        res.setExample("系统管理员角色");
        res.setMaxLength(500l);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.BOOK);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_description);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.role.RoleStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(255);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.role.CreateRoleRequest", res);
  }

  void initComponentapi_roleRoleDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RoleDetail");
    res.setName("RoleDetail");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(328);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleDetail");
    res.setDescription("角色详情信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RoleDetail");
            res.setDescription("角色详情信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(336);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _roleCode = new ComponentItem();
    _roleCode.setClzName("java.lang.String");
    _roleCode.setName("role_code");
    _roleCode.setFieldName("roleCode");
    _roleCode.setTag(2);
    _roleCode.setProtoLine(343);
    _roleCode.setProtoColumn(3);
    _roleCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色代码");
        res.setExample("admin");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleCode);
    ComponentItem _roleName = new ComponentItem();
    _roleName.setClzName("java.lang.String");
    _roleName.setName("role_name");
    _roleName.setFieldName("roleName");
    _roleName.setTag(3);
    _roleName.setProtoLine(350);
    _roleName.setProtoColumn(3);
    _roleName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色名称");
        res.setExample("管理员");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleName);
    ComponentItem _description = new ComponentItem();
    _description.setClzName("java.lang.String");
    _description.setName("description");
    _description.setFieldName("description");
    _description.setTag(4);
    _description.setProtoLine(357);
    _description.setProtoColumn(3);
    _description.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色描述");
        res.setExample("系统管理员角色");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.BOOK);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_description);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.role.RoleStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(5);
    _status.setProtoLine(363);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(6);
    _createdAt.setProtoLine(369);
    _createdAt.setProtoColumn(3);
    _createdAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("创建时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_createdAt);
    ComponentItem _updatedAt = new ComponentItem();
    _updatedAt.setClzName("java.time.LocalDateTime");
    _updatedAt.setName("updated_at");
    _updatedAt.setFieldName("updatedAt");
    _updatedAt.setTag(7);
    _updatedAt.setProtoLine(375);
    _updatedAt.setProtoColumn(3);
    _updatedAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("更新时间");
        res.setExample("2024-01-16T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_updatedAt);
    components.put("com.apihug.rad.api.role.RoleDetail", res);
  }

  void initComponentapi_roleRoleMenuItem() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RoleMenuItem");
    res.setName("RoleMenuItem");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(435);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleMenuItem");
    res.setDescription("角色关联的菜单项");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RoleMenuItem");
            res.setDescription("角色关联的菜单项");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(443);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _menuCode = new ComponentItem();
    _menuCode.setClzName("java.lang.String");
    _menuCode.setName("menu_code");
    _menuCode.setFieldName("menuCode");
    _menuCode.setTag(2);
    _menuCode.setProtoLine(449);
    _menuCode.setProtoColumn(3);
    _menuCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单代码");
        res.setExample("system:user");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_menuCode);
    ComponentItem _menuName = new ComponentItem();
    _menuName.setClzName("java.lang.String");
    _menuName.setName("menu_name");
    _menuName.setFieldName("menuName");
    _menuName.setTag(3);
    _menuName.setProtoLine(455);
    _menuName.setProtoColumn(3);
    _menuName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单名称");
        res.setExample("用户管理");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_menuName);
    ComponentItem _permissionCode = new ComponentItem();
    _permissionCode.setClzName("java.lang.String");
    _permissionCode.setName("permission_code");
    _permissionCode.setFieldName("permissionCode");
    _permissionCode.setTag(4);
    _permissionCode.setProtoLine(461);
    _permissionCode.setProtoColumn(3);
    _permissionCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限代码（BUTTON 类型菜单的原子权限）");
        res.setExample("customer:create");
        return res;
      }
    }.get());
    res.addItem(_permissionCode);
    ComponentItem _menuType = new ComponentItem();
    _menuType.setClzName("java.lang.String");
    _menuType.setName("menu_type");
    _menuType.setFieldName("menuType");
    _menuType.setTag(5);
    _menuType.setProtoLine(466);
    _menuType.setProtoColumn(3);
    _menuType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单类型（DIRECTORY/MENU/BUTTON）");
        res.setExample("BUTTON");
        return res;
      }
    }.get());
    res.addItem(_menuType);
    components.put("com.apihug.rad.api.role.RoleMenuItem", res);
  }

  void initComponentapi_roleRoleMenuSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RoleMenuSummary");
    res.setName("RoleMenuSummary");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(416);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleMenuSummary");
    res.setDescription("角色菜单摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RoleMenuSummary");
            res.setDescription("角色菜单摘要");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _roleId = new ComponentItem();
    _roleId.setClzName("java.lang.Long");
    _roleId.setName("role_id");
    _roleId.setFieldName("roleId");
    _roleId.setTag(1);
    _roleId.setProtoLine(424);
    _roleId.setProtoColumn(3);
    _roleId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_roleId);
    ComponentItem _menus = new ComponentItem();
    _menus.setClzName("com.apihug.rad.api.role.RoleMenuItem");
    _menus.setName("menus");
    _menus.setFieldName("menus");
    _menus.setTag(2);
    _menus.setProtoLine(430);
    _menus.setProtoColumn(3);
    _menus.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("关联的菜单列表");
        return res;
      }
    }.get());
    _menus.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_menus);
    components.put("com.apihug.rad.api.role.RoleMenuSummary", res);
  }

  void initComponentapi_roleRoleSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RoleSummary");
    res.setName("RoleSummary");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(292);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleSummary");
    res.setDescription("角色摘要信息（列表用）");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RoleSummary");
            res.setDescription("角色摘要信息（列表用）");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(300);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _roleCode = new ComponentItem();
    _roleCode.setClzName("java.lang.String");
    _roleCode.setName("role_code");
    _roleCode.setFieldName("roleCode");
    _roleCode.setTag(2);
    _roleCode.setProtoLine(307);
    _roleCode.setProtoColumn(3);
    _roleCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色代码");
        res.setExample("admin");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleCode);
    ComponentItem _roleName = new ComponentItem();
    _roleName.setClzName("java.lang.String");
    _roleName.setName("role_name");
    _roleName.setFieldName("roleName");
    _roleName.setTag(3);
    _roleName.setProtoLine(314);
    _roleName.setProtoColumn(3);
    _roleName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色名称");
        res.setExample("管理员");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleName);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.role.RoleStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(321);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.role.RoleSummary", res);
  }

  void initComponentapi_roleSearchRolesRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.SearchRolesRequest");
    res.setName("SearchRolesRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(382);
    res.setProtoColumn(1);
    res.setProtoEntity("SearchRolesRequest");
    res.setDescription("搜索角色请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SearchRolesRequest");
            res.setDescription("搜索角色请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _keyword = new ComponentItem();
    _keyword.setClzName("java.lang.String");
    _keyword.setName("keyword");
    _keyword.setFieldName("keyword");
    _keyword.setTag(1);
    _keyword.setProtoLine(390);
    _keyword.setProtoColumn(3);
    _keyword.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("搜索关键词（角色代码或名称）");
        res.setExample("admin");
        return res;
      }
    }.get());
    res.addItem(_keyword);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.role.RoleStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(2);
    _status.setProtoLine(395);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色状态筛选");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.role.SearchRolesRequest", res);
  }

  void initComponentapi_roleUpdateRoleRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.UpdateRoleRequest");
    res.setName("UpdateRoleRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(262);
    res.setProtoColumn(1);
    res.setProtoEntity("UpdateRoleRequest");
    res.setDescription("更新角色请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UpdateRoleRequest");
            res.setDescription("更新角色请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _roleName = new ComponentItem();
    _roleName.setClzName("java.lang.String");
    _roleName.setName("role_name");
    _roleName.setFieldName("roleName");
    _roleName.setTag(1);
    _roleName.setProtoLine(270);
    _roleName.setProtoColumn(3);
    _roleName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色名称");
        res.setExample("管理员");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_roleName);
    ComponentItem _description = new ComponentItem();
    _description.setClzName("java.lang.String");
    _description.setName("description");
    _description.setFieldName("description");
    _description.setTag(2);
    _description.setProtoLine(278);
    _description.setProtoColumn(3);
    _description.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色描述");
        res.setExample("系统管理员角色");
        res.setMaxLength(500l);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.BOOK);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_description);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.role.RoleStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(3);
    _status.setProtoLine(285);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.role.UpdateRoleRequest", res);
  }

  void initComponentapi_tenantConfigureTenantRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.ConfigureTenantRequest");
    res.setName("ConfigureTenantRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(237);
    res.setProtoColumn(1);
    res.setProtoEntity("ConfigureTenantRequest");
    res.setDescription("配置租户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("ConfigureTenantRequest");
            res.setDescription("配置租户请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _maxMembers = new ComponentItem();
    _maxMembers.setClzName("java.lang.Integer");
    _maxMembers.setName("max_members");
    _maxMembers.setFieldName("maxMembers");
    _maxMembers.setTag(1);
    _maxMembers.setProtoLine(245);
    _maxMembers.setProtoColumn(3);
    _maxMembers.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("最大成员数");
        res.setExample("100");
        res.setMinimum(1.0D);
        return res;
      }
    }.get());
    res.addItem(_maxMembers);
    ComponentItem _maxStorageMb = new ComponentItem();
    _maxStorageMb.setClzName("java.lang.Long");
    _maxStorageMb.setName("max_storage_mb");
    _maxStorageMb.setFieldName("maxStorageMb");
    _maxStorageMb.setTag(2);
    _maxStorageMb.setProtoLine(251);
    _maxStorageMb.setProtoColumn(3);
    _maxStorageMb.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("最大存储空间（MB）");
        res.setExample("10240");
        res.setMinimum(1.0D);
        return res;
      }
    }.get());
    res.addItem(_maxStorageMb);
    ComponentItem _enabledModules = new ComponentItem();
    _enabledModules.setClzName("java.lang.String");
    _enabledModules.setName("enabled_modules");
    _enabledModules.setFieldName("enabledModules");
    _enabledModules.setTag(3);
    _enabledModules.setProtoLine(257);
    _enabledModules.setProtoColumn(3);
    _enabledModules.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("启用的功能模块");
        res.setExample("[\"user\", \"role\", \"menu\", \"department\"]");
        return res;
      }
    }.get());
    _enabledModules.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_enabledModules);
    ComponentItem _expiryDate = new ComponentItem();
    _expiryDate.setClzName("java.time.LocalDateTime");
    _expiryDate.setName("expiry_date");
    _expiryDate.setFieldName("expiryDate");
    _expiryDate.setTag(4);
    _expiryDate.setProtoLine(262);
    _expiryDate.setProtoColumn(3);
    _expiryDate.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("到期时间");
        res.setExample("2025-12-31T23:59:59");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_expiryDate);
    components.put("com.apihug.rad.api.tenant.ConfigureTenantRequest", res);
  }

  void initComponentapi_tenantCreateTenantRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.CreateTenantRequest");
    res.setName("CreateTenantRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(142);
    res.setProtoColumn(1);
    res.setProtoEntity("CreateTenantRequest");
    res.setDescription("创建租户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CreateTenantRequest");
            res.setDescription("创建租户请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _tenantCode = new ComponentItem();
    _tenantCode.setClzName("java.lang.String");
    _tenantCode.setName("tenant_code");
    _tenantCode.setFieldName("tenantCode");
    _tenantCode.setTag(1);
    _tenantCode.setProtoLine(150);
    _tenantCode.setProtoColumn(3);
    _tenantCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户代码");
        res.setExample("acme_corp");
        res.setMaxLength(50l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantCode);
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(2);
    _tenantName.setProtoLine(158);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _contactEmail = new ComponentItem();
    _contactEmail.setClzName("java.lang.String");
    _contactEmail.setName("contact_email");
    _contactEmail.setFieldName("contactEmail");
    _contactEmail.setTag(3);
    _contactEmail.setProtoLine(166);
    _contactEmail.setProtoColumn(3);
    _contactEmail.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("联系人邮箱");
        res.setExample("contact@acme.com");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.EMAIL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_contactEmail);
    ComponentItem _contactPhone = new ComponentItem();
    _contactPhone.setClzName("java.lang.String");
    _contactPhone.setName("contact_phone");
    _contactPhone.setFieldName("contactPhone");
    _contactPhone.setTag(4);
    _contactPhone.setProtoLine(174);
    _contactPhone.setProtoColumn(3);
    _contactPhone.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("联系人电话");
        res.setExample("13800138000");
        res.setMaxLength(20l);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.PHONE);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_contactPhone);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(5);
    _status.setProtoLine(181);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _isPlatform = new ComponentItem();
    _isPlatform.setClzName("java.lang.Boolean");
    _isPlatform.setName("is_platform");
    _isPlatform.setFieldName("isPlatform");
    _isPlatform.setTag(6);
    _isPlatform.setProtoLine(187);
    _isPlatform.setProtoColumn(3);
    _isPlatform.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否为平台租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isPlatform);
    ComponentItem _description = new ComponentItem();
    _description.setClzName("java.lang.String");
    _description.setName("description");
    _description.setFieldName("description");
    _description.setTag(7);
    _description.setProtoLine(192);
    _description.setProtoColumn(3);
    _description.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户描述");
        res.setExample("企业管理平台");
        res.setMaxLength(500l);
        return res;
      }
    }.get());
    res.addItem(_description);
    components.put("com.apihug.rad.api.tenant.CreateTenantRequest", res);
  }

  void initComponentapi_tenantSearchTenantsRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.SearchTenantsRequest");
    res.setName("SearchTenantsRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(379);
    res.setProtoColumn(1);
    res.setProtoEntity("SearchTenantsRequest");
    res.setDescription("搜索租户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SearchTenantsRequest");
            res.setDescription("搜索租户请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _keyword = new ComponentItem();
    _keyword.setClzName("java.lang.String");
    _keyword.setName("keyword");
    _keyword.setFieldName("keyword");
    _keyword.setTag(1);
    _keyword.setProtoLine(387);
    _keyword.setProtoColumn(3);
    _keyword.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("搜索关键词（租户名称或代码）");
        res.setExample("acme");
        return res;
      }
    }.get());
    res.addItem(_keyword);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(2);
    _status.setProtoLine(392);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户状态筛选");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.tenant.SearchTenantsRequest", res);
  }

  void initComponentapi_tenantTenantDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.TenantDetail");
    res.setName("TenantDetail");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(305);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantDetail");
    res.setDescription("租户详情信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TenantDetail");
            res.setDescription("租户详情信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(313);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _tenantCode = new ComponentItem();
    _tenantCode.setClzName("java.lang.String");
    _tenantCode.setName("tenant_code");
    _tenantCode.setFieldName("tenantCode");
    _tenantCode.setTag(2);
    _tenantCode.setProtoLine(320);
    _tenantCode.setProtoColumn(3);
    _tenantCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户代码");
        res.setExample("acme_corp");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantCode);
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(3);
    _tenantName.setProtoLine(327);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _contactEmail = new ComponentItem();
    _contactEmail.setClzName("java.lang.String");
    _contactEmail.setName("contact_email");
    _contactEmail.setFieldName("contactEmail");
    _contactEmail.setTag(4);
    _contactEmail.setProtoLine(334);
    _contactEmail.setProtoColumn(3);
    _contactEmail.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("联系人邮箱");
        res.setExample("contact@acme.com");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.EMAIL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_contactEmail);
    ComponentItem _contactPhone = new ComponentItem();
    _contactPhone.setClzName("java.lang.String");
    _contactPhone.setName("contact_phone");
    _contactPhone.setFieldName("contactPhone");
    _contactPhone.setTag(5);
    _contactPhone.setProtoLine(340);
    _contactPhone.setProtoColumn(3);
    _contactPhone.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("联系人电话");
        res.setExample("13800138000");
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.PHONE);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_contactPhone);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(6);
    _status.setProtoLine(346);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _maxMembers = new ComponentItem();
    _maxMembers.setClzName("java.lang.Integer");
    _maxMembers.setName("max_members");
    _maxMembers.setFieldName("maxMembers");
    _maxMembers.setTag(7);
    _maxMembers.setProtoLine(352);
    _maxMembers.setProtoColumn(3);
    _maxMembers.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("最大成员数");
        res.setExample("100");
        return res;
      }
    }.get());
    res.addItem(_maxMembers);
    ComponentItem _maxStorageMb = new ComponentItem();
    _maxStorageMb.setClzName("java.lang.Long");
    _maxStorageMb.setName("max_storage_mb");
    _maxStorageMb.setFieldName("maxStorageMb");
    _maxStorageMb.setTag(8);
    _maxStorageMb.setProtoLine(357);
    _maxStorageMb.setProtoColumn(3);
    _maxStorageMb.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("最大存储空间（MB）");
        res.setExample("10240");
        return res;
      }
    }.get());
    res.addItem(_maxStorageMb);
    ComponentItem _isPlatform = new ComponentItem();
    _isPlatform.setClzName("java.lang.Boolean");
    _isPlatform.setName("is_platform");
    _isPlatform.setFieldName("isPlatform");
    _isPlatform.setTag(9);
    _isPlatform.setProtoLine(362);
    _isPlatform.setProtoColumn(3);
    _isPlatform.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否为平台租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isPlatform);
    ComponentItem _description = new ComponentItem();
    _description.setClzName("java.lang.String");
    _description.setName("description");
    _description.setFieldName("description");
    _description.setTag(10);
    _description.setProtoLine(367);
    _description.setProtoColumn(3);
    _description.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户描述");
        res.setExample("企业管理平台");
        return res;
      }
    }.get());
    res.addItem(_description);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(11);
    _createdAt.setProtoLine(372);
    _createdAt.setProtoColumn(3);
    _createdAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("创建时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_createdAt);
    components.put("com.apihug.rad.api.tenant.TenantDetail", res);
  }

  void initComponentapi_tenantTenantSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.TenantSummary");
    res.setName("TenantSummary");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(269);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantSummary");
    res.setDescription("租户摘要信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TenantSummary");
            res.setDescription("租户摘要信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(277);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _tenantCode = new ComponentItem();
    _tenantCode.setClzName("java.lang.String");
    _tenantCode.setName("tenant_code");
    _tenantCode.setFieldName("tenantCode");
    _tenantCode.setTag(2);
    _tenantCode.setProtoLine(284);
    _tenantCode.setProtoColumn(3);
    _tenantCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户代码");
        res.setExample("acme_corp");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantCode);
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(3);
    _tenantName.setProtoLine(291);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(298);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.tenant.TenantSummary", res);
  }

  void initComponentapi_tenantUpdateTenantRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.UpdateTenantRequest");
    res.setName("UpdateTenantRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(199);
    res.setProtoColumn(1);
    res.setProtoEntity("UpdateTenantRequest");
    res.setDescription("更新租户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UpdateTenantRequest");
            res.setDescription("更新租户请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(1);
    _tenantName.setProtoLine(207);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.NAME);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _contactEmail = new ComponentItem();
    _contactEmail.setClzName("java.lang.String");
    _contactEmail.setName("contact_email");
    _contactEmail.setFieldName("contactEmail");
    _contactEmail.setTag(2);
    _contactEmail.setProtoLine(215);
    _contactEmail.setProtoColumn(3);
    _contactEmail.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("联系人邮箱");
        res.setExample("contact@acme.com");
        res.setMaxLength(100l);
        res.setEmpty(false);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.EMAIL);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_contactEmail);
    ComponentItem _contactPhone = new ComponentItem();
    _contactPhone.setClzName("java.lang.String");
    _contactPhone.setName("contact_phone");
    _contactPhone.setFieldName("contactPhone");
    _contactPhone.setTag(3);
    _contactPhone.setProtoLine(223);
    _contactPhone.setProtoColumn(3);
    _contactPhone.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("联系人电话");
        res.setExample("13800138000");
        res.setMaxLength(20l);
        res.setMock(new Supplier<Mock>() {
          @Override
          public Mock get() {
            Mock res = new Mock();
            res.setNature(Nature.PHONE);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    res.addItem(_contactPhone);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(4);
    _status.setProtoLine(230);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户状态");
        res.setExample("ACTIVE");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.tenant.UpdateTenantRequest", res);
  }

  void initComponentapi_tenantAddTenantMemberRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.AddTenantMemberRequest");
    res.setName("AddTenantMemberRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(395);
    res.setProtoColumn(1);
    res.setProtoEntity("AddTenantMemberRequest");
    res.setDescription("添加租户成员请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AddTenantMemberRequest");
            res.setDescription("添加租户成员请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(1);
    _customerId.setProtoLine(403);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _departmentId = new ComponentItem();
    _departmentId.setClzName("java.lang.Long");
    _departmentId.setName("department_id");
    _departmentId.setFieldName("departmentId");
    _departmentId.setTag(2);
    _departmentId.setProtoLine(410);
    _departmentId.setProtoColumn(3);
    _departmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_departmentId);
    ComponentItem _position = new ComponentItem();
    _position.setClzName("java.lang.String");
    _position.setName("position");
    _position.setFieldName("position");
    _position.setTag(3);
    _position.setProtoLine(415);
    _position.setProtoColumn(3);
    _position.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("职位");
        res.setExample("软件工程师");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_position);
    ComponentItem _memberType = new ComponentItem();
    _memberType.setClzName("com.apihug.rad.infra.tenant.MemberTypeEnum");
    _memberType.setName("member_type");
    _memberType.setFieldName("memberType");
    _memberType.setTag(4);
    _memberType.setProtoLine(421);
    _memberType.setProtoColumn(3);
    _memberType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员类型");
        res.setExample("FULL_TIME");
        return res;
      }
    }.get());
    res.addItem(_memberType);
    ComponentItem _memberRole = new ComponentItem();
    _memberRole.setClzName("com.apihug.rad.infra.tenant.MemberRoleEnum");
    _memberRole.setName("member_role");
    _memberRole.setFieldName("memberRole");
    _memberRole.setTag(5);
    _memberRole.setProtoLine(426);
    _memberRole.setProtoColumn(3);
    _memberRole.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员角色");
        res.setExample("MEMBER");
        return res;
      }
    }.get());
    res.addItem(_memberRole);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(6);
    _isDefault.setProtoLine(431);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否设为默认租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    components.put("com.apihug.rad.api.tenant.AddTenantMemberRequest", res);
  }

  void initComponentapi_tenantAssignMemberDepartmentRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.AssignMemberDepartmentRequest");
    res.setName("AssignMemberDepartmentRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(452);
    res.setProtoColumn(1);
    res.setProtoEntity("AssignMemberDepartmentRequest");
    res.setDescription("分配成员部门请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AssignMemberDepartmentRequest");
            res.setDescription("分配成员部门请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _departmentId = new ComponentItem();
    _departmentId.setClzName("java.lang.Long");
    _departmentId.setName("department_id");
    _departmentId.setFieldName("departmentId");
    _departmentId.setTag(1);
    _departmentId.setProtoLine(460);
    _departmentId.setProtoColumn(3);
    _departmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_departmentId);
    ComponentItem _position = new ComponentItem();
    _position.setClzName("java.lang.String");
    _position.setName("position");
    _position.setFieldName("position");
    _position.setTag(2);
    _position.setProtoLine(467);
    _position.setProtoColumn(3);
    _position.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("新职位");
        res.setExample("技术经理");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_position);
    components.put("com.apihug.rad.api.tenant.AssignMemberDepartmentRequest", res);
  }

  void initComponentapi_tenantAssignRolesRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.AssignRolesRequest");
    res.setName("AssignRolesRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(634);
    res.setProtoColumn(1);
    res.setProtoEntity("AssignRolesRequest");
    res.setDescription("分配角色请求\r\n"
            + "分配 RBAC 角色请求（全量覆盖）");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AssignRolesRequest");
            res.setDescription("分配 RBAC 角色请求（全量覆盖）");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _roleIds = new ComponentItem();
    _roleIds.setClzName("java.lang.Long");
    _roleIds.setName("role_ids");
    _roleIds.setFieldName("roleIds");
    _roleIds.setTag(1);
    _roleIds.setProtoLine(642);
    _roleIds.setProtoColumn(3);
    _roleIds.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("RBAC 角色 ID 列表");
        res.setExample("[1, 2, 3]");
        res.setEmpty(false);
        return res;
      }
    }.get());
    _roleIds.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_roleIds);
    components.put("com.apihug.rad.api.tenant.AssignRolesRequest", res);
  }

  void initComponentapi_tenantGetTenantMembersRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.GetTenantMembersRequest");
    res.setName("GetTenantMembersRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(372);
    res.setProtoColumn(1);
    res.setProtoEntity("GetTenantMembersRequest");
    res.setDescription("============ 消息类型定义 ============\r\n"
            + "获取租户成员列表请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("GetTenantMembersRequest");
            res.setDescription("获取租户成员列表请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantMemberStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(1);
    _status.setProtoLine(380);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员状态筛选");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _memberRole = new ComponentItem();
    _memberRole.setClzName("com.apihug.rad.infra.tenant.MemberRoleEnum");
    _memberRole.setName("member_role");
    _memberRole.setFieldName("memberRole");
    _memberRole.setTag(2);
    _memberRole.setProtoLine(385);
    _memberRole.setProtoColumn(3);
    _memberRole.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员角色筛选");
        return res;
      }
    }.get());
    res.addItem(_memberRole);
    ComponentItem _keyword = new ComponentItem();
    _keyword.setClzName("java.lang.String");
    _keyword.setName("keyword");
    _keyword.setFieldName("keyword");
    _keyword.setTag(3);
    _keyword.setProtoLine(389);
    _keyword.setProtoColumn(3);
    _keyword.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("搜索关键词（用户名或邮箱）");
        res.setExample("zhangsan");
        return res;
      }
    }.get());
    res.addItem(_keyword);
    components.put("com.apihug.rad.api.tenant.GetTenantMembersRequest", res);
  }

  void initComponentapi_tenantMemberRoleItem() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.MemberRoleItem");
    res.setName("MemberRoleItem");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(670);
    res.setProtoColumn(1);
    res.setProtoEntity("MemberRoleItem");
    res.setDescription("成员角色项\r\n"
            + "成员的 RBAC 角色信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("MemberRoleItem");
            res.setDescription("成员的 RBAC 角色信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(678);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _roleCode = new ComponentItem();
    _roleCode.setClzName("java.lang.String");
    _roleCode.setName("role_code");
    _roleCode.setFieldName("roleCode");
    _roleCode.setTag(2);
    _roleCode.setProtoLine(684);
    _roleCode.setProtoColumn(3);
    _roleCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色代码");
        res.setExample("finance_manager");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_roleCode);
    ComponentItem _roleName = new ComponentItem();
    _roleName.setClzName("java.lang.String");
    _roleName.setName("role_name");
    _roleName.setFieldName("roleName");
    _roleName.setTag(3);
    _roleName.setProtoLine(690);
    _roleName.setProtoColumn(3);
    _roleName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色名称");
        res.setExample("财务经理");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_roleName);
    components.put("com.apihug.rad.api.tenant.MemberRoleItem", res);
  }

  void initComponentapi_tenantMemberRoleSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.MemberRoleSummary");
    res.setName("MemberRoleSummary");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(650);
    res.setProtoColumn(1);
    res.setProtoEntity("MemberRoleSummary");
    res.setDescription("成员角色摘要\r\n"
            + "成员角色摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("MemberRoleSummary");
            res.setDescription("成员角色摘要");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _memberId = new ComponentItem();
    _memberId.setClzName("java.lang.Long");
    _memberId.setName("member_id");
    _memberId.setFieldName("memberId");
    _memberId.setTag(1);
    _memberId.setProtoLine(658);
    _memberId.setProtoColumn(3);
    _memberId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_memberId);
    ComponentItem _roles = new ComponentItem();
    _roles.setClzName("com.apihug.rad.api.tenant.MemberRoleItem");
    _roles.setName("roles");
    _roles.setFieldName("roles");
    _roles.setTag(2);
    _roles.setProtoLine(664);
    _roles.setProtoColumn(3);
    _roles.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("RBAC 角色列表");
        return res;
      }
    }.get());
    _roles.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_roles);
    components.put("com.apihug.rad.api.tenant.MemberRoleSummary", res);
  }

  void initComponentapi_tenantTenantMemberDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.TenantMemberDetail");
    res.setName("TenantMemberDetail");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(544);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantMemberDetail");
    res.setDescription("成员详情（含客户账号信息 + 成员身份信息）\r\n"
            + "租户成员详情信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TenantMemberDetail");
            res.setDescription("租户成员详情信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(553);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员关系 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(2);
    _customerId.setProtoLine(558);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(3);
    _tenantId.setProtoLine(563);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    ComponentItem _customerUsername = new ComponentItem();
    _customerUsername.setClzName("java.lang.String");
    _customerUsername.setName("customer_username");
    _customerUsername.setFieldName("customerUsername");
    _customerUsername.setTag(4);
    _customerUsername.setProtoLine(569);
    _customerUsername.setProtoColumn(3);
    _customerUsername.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户用户名");
        res.setExample("zhangsan");
        return res;
      }
    }.get());
    res.addItem(_customerUsername);
    ComponentItem _customerEmail = new ComponentItem();
    _customerEmail.setClzName("java.lang.String");
    _customerEmail.setName("customer_email");
    _customerEmail.setFieldName("customerEmail");
    _customerEmail.setTag(5);
    _customerEmail.setProtoLine(574);
    _customerEmail.setProtoColumn(3);
    _customerEmail.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户邮箱");
        res.setExample("zhangsan@example.com");
        return res;
      }
    }.get());
    res.addItem(_customerEmail);
    ComponentItem _customerStatus = new ComponentItem();
    _customerStatus.setClzName("com.apihug.rad.infra.customer.CustomerStatusEnum");
    _customerStatus.setName("customer_status");
    _customerStatus.setFieldName("customerStatus");
    _customerStatus.setTag(6);
    _customerStatus.setProtoLine(579);
    _customerStatus.setProtoColumn(3);
    _customerStatus.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户账号状态");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_customerStatus);
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(7);
    _tenantName.setProtoLine(585);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _tenantCode = new ComponentItem();
    _tenantCode.setClzName("java.lang.String");
    _tenantCode.setName("tenant_code");
    _tenantCode.setFieldName("tenantCode");
    _tenantCode.setTag(8);
    _tenantCode.setProtoLine(590);
    _tenantCode.setProtoColumn(3);
    _tenantCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户代码");
        res.setExample("acme_corp");
        return res;
      }
    }.get());
    res.addItem(_tenantCode);
    ComponentItem _memberType = new ComponentItem();
    _memberType.setClzName("com.apihug.rad.infra.tenant.MemberTypeEnum");
    _memberType.setName("member_type");
    _memberType.setFieldName("memberType");
    _memberType.setTag(9);
    _memberType.setProtoLine(596);
    _memberType.setProtoColumn(3);
    _memberType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员类型");
        res.setExample("FULL_TIME");
        return res;
      }
    }.get());
    res.addItem(_memberType);
    ComponentItem _memberRole = new ComponentItem();
    _memberRole.setClzName("com.apihug.rad.infra.tenant.MemberRoleEnum");
    _memberRole.setName("member_role");
    _memberRole.setFieldName("memberRole");
    _memberRole.setTag(10);
    _memberRole.setProtoLine(601);
    _memberRole.setProtoColumn(3);
    _memberRole.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员角色");
        res.setExample("MEMBER");
        return res;
      }
    }.get());
    res.addItem(_memberRole);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantMemberStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(11);
    _status.setProtoLine(606);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员状态");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _departmentId = new ComponentItem();
    _departmentId.setClzName("java.lang.Long");
    _departmentId.setName("department_id");
    _departmentId.setFieldName("departmentId");
    _departmentId.setTag(12);
    _departmentId.setProtoLine(611);
    _departmentId.setProtoColumn(3);
    _departmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_departmentId);
    ComponentItem _position = new ComponentItem();
    _position.setClzName("java.lang.String");
    _position.setName("position");
    _position.setFieldName("position");
    _position.setTag(13);
    _position.setProtoLine(616);
    _position.setProtoColumn(3);
    _position.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("职位");
        res.setExample("软件工程师");
        return res;
      }
    }.get());
    res.addItem(_position);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(14);
    _isDefault.setProtoLine(621);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否默认租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(15);
    _createdAt.setProtoLine(626);
    _createdAt.setProtoColumn(3);
    _createdAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("加入时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_createdAt);
    components.put("com.apihug.rad.api.tenant.TenantMemberDetail", res);
  }

  void initComponentapi_tenantTenantMemberSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.TenantMemberSummary");
    res.setName("TenantMemberSummary");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(474);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantMemberSummary");
    res.setDescription("租户成员摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TenantMemberSummary");
            res.setDescription("租户成员摘要");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(482);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员关系 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Long");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(2);
    _customerId.setProtoLine(487);
    _customerId.setProtoColumn(3);
    _customerId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_customerId);
    ComponentItem _customerUsername = new ComponentItem();
    _customerUsername.setClzName("java.lang.String");
    _customerUsername.setName("customer_username");
    _customerUsername.setFieldName("customerUsername");
    _customerUsername.setTag(3);
    _customerUsername.setProtoLine(492);
    _customerUsername.setProtoColumn(3);
    _customerUsername.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户用户名");
        res.setExample("zhangsan");
        return res;
      }
    }.get());
    res.addItem(_customerUsername);
    ComponentItem _customerEmail = new ComponentItem();
    _customerEmail.setClzName("java.lang.String");
    _customerEmail.setName("customer_email");
    _customerEmail.setFieldName("customerEmail");
    _customerEmail.setTag(4);
    _customerEmail.setProtoLine(497);
    _customerEmail.setProtoColumn(3);
    _customerEmail.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户邮箱");
        res.setExample("zhangsan@example.com");
        return res;
      }
    }.get());
    res.addItem(_customerEmail);
    ComponentItem _tenantId = new ComponentItem();
    _tenantId.setClzName("java.lang.Long");
    _tenantId.setName("tenant_id");
    _tenantId.setFieldName("tenantId");
    _tenantId.setTag(5);
    _tenantId.setProtoLine(502);
    _tenantId.setProtoColumn(3);
    _tenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_tenantId);
    ComponentItem _tenantName = new ComponentItem();
    _tenantName.setClzName("java.lang.String");
    _tenantName.setName("tenant_name");
    _tenantName.setFieldName("tenantName");
    _tenantName.setTag(6);
    _tenantName.setProtoLine(507);
    _tenantName.setProtoColumn(3);
    _tenantName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("租户名称");
        res.setExample("Acme 公司");
        return res;
      }
    }.get());
    res.addItem(_tenantName);
    ComponentItem _departmentId = new ComponentItem();
    _departmentId.setClzName("java.lang.Long");
    _departmentId.setName("department_id");
    _departmentId.setFieldName("departmentId");
    _departmentId.setTag(7);
    _departmentId.setProtoLine(512);
    _departmentId.setProtoColumn(3);
    _departmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_departmentId);
    ComponentItem _position = new ComponentItem();
    _position.setClzName("java.lang.String");
    _position.setName("position");
    _position.setFieldName("position");
    _position.setTag(8);
    _position.setProtoLine(517);
    _position.setProtoColumn(3);
    _position.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("职位");
        res.setExample("软件工程师");
        return res;
      }
    }.get());
    res.addItem(_position);
    ComponentItem _memberType = new ComponentItem();
    _memberType.setClzName("com.apihug.rad.infra.tenant.MemberTypeEnum");
    _memberType.setName("member_type");
    _memberType.setFieldName("memberType");
    _memberType.setTag(9);
    _memberType.setProtoLine(522);
    _memberType.setProtoColumn(3);
    _memberType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员类型");
        res.setExample("FULL_TIME");
        return res;
      }
    }.get());
    res.addItem(_memberType);
    ComponentItem _memberRole = new ComponentItem();
    _memberRole.setClzName("com.apihug.rad.infra.tenant.MemberRoleEnum");
    _memberRole.setName("member_role");
    _memberRole.setFieldName("memberRole");
    _memberRole.setTag(10);
    _memberRole.setProtoLine(527);
    _memberRole.setProtoColumn(3);
    _memberRole.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员角色");
        res.setExample("MEMBER");
        return res;
      }
    }.get());
    res.addItem(_memberRole);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.tenant.TenantMemberStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(11);
    _status.setProtoLine(532);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("成员状态");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(12);
    _isDefault.setProtoLine(537);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否默认租户");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    components.put("com.apihug.rad.api.tenant.TenantMemberSummary", res);
  }

  void initComponentapi_tenantUpdateMemberRoleRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.UpdateMemberRoleRequest");
    res.setName("UpdateMemberRoleRequest");
    res.setProtoFrom("com/apihug/rad/api/tenant/member.proto");
    res.setProtoLine(437);
    res.setProtoColumn(1);
    res.setProtoEntity("UpdateMemberRoleRequest");
    res.setDescription("更新成员角色请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UpdateMemberRoleRequest");
            res.setDescription("更新成员角色请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _memberRole = new ComponentItem();
    _memberRole.setClzName("com.apihug.rad.infra.tenant.MemberRoleEnum");
    _memberRole.setName("member_role");
    _memberRole.setFieldName("memberRole");
    _memberRole.setTag(1);
    _memberRole.setProtoLine(445);
    _memberRole.setProtoColumn(3);
    _memberRole.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("新角色");
        res.setExample("ADMIN");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_memberRole);
    components.put("com.apihug.rad.api.tenant.UpdateMemberRoleRequest", res);
  }

  void initComponentinfra_authAuthErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.auth.AuthErrorEnum");
    res.setName("AuthErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/auth/constant.proto");
    res.setProtoLine(10);
    res.setProtoColumn(1);
    res.setProtoEntity("AuthErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("LOGIN_FAIL");
        res.setCode(10006001);
        res.setMessage("Login failed");
        res.setMessage2("登录失败");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Check your username and password");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACCOUNT_LOCKED");
        res.setCode(10006002);
        res.setMessage("Account is locked");
        res.setMessage2("账户已锁定");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Try again later or contact admin");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_NOT_FOUND");
        res.setCode(10006003);
        res.setMessage("Tenant not found");
        res.setMessage2("租户不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Check if the tenant ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("NO_TENANT_ACCESS");
        res.setCode(10006004);
        res.setMessage("No access to this tenant");
        res.setMessage2("无权访问该租户");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Contact your administrator");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TOKEN_EXPIRED");
        res.setCode(10006005);
        res.setMessage("Token has expired");
        res.setMessage2("Token 已过期");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Please login again");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INVALID_TOKEN");
        res.setCode(10006006);
        res.setMessage("Invalid token");
        res.setMessage2("无效的 Token");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Please login again");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.auth.AuthErrorEnum", res);
  }

  void initComponentinfra_customerCustomerStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.customer.CustomerStatusEnum");
    res.setName("CustomerStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/customer/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACTIVE");
        res.setCode(1);
        res.setMessage("active");
        res.setMessage2("活跃");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INACTIVE");
        res.setCode(2);
        res.setMessage("inactive");
        res.setMessage2("非活跃");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("LOCKED");
        res.setCode(3);
        res.setMessage("locked");
        res.setMessage2("锁定");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DISABLED");
        res.setCode(4);
        res.setMessage("disabled");
        res.setMessage2("禁用");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.customer.CustomerStatusEnum", res);
  }

  void initComponentinfra_customerCustomerErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.customer.CustomerErrorEnum");
    res.setName("CustomerErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/customer/error.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_NOT_FOUND");
        res.setCode(10001023);
        res.setMessage("Customer not found");
        res.setMessage2("客户不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Contact your admin or create a new customer");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_ALREADY_EXISTS");
        res.setCode(10001026);
        res.setMessage("Customer already exists");
        res.setMessage2("客户已存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Use a different username or email");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INVALID_RESET_TOKEN");
        res.setCode(10001027);
        res.setMessage("Invalid reset token");
        res.setMessage2("重置 token 无效");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Request a new password reset");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("RESET_TOKEN_EXPIRED");
        res.setCode(10001028);
        res.setMessage("Reset token expired");
        res.setMessage2("重置 token 已过期");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Request a new password reset");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("WEAK_PASSWORD");
        res.setCode(10001029);
        res.setMessage("Weak password");
        res.setMessage2("密码强度不足");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Password must be at least 6 characters");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.customer.CustomerErrorEnum", res);
  }

  void initComponentinfra_departmentDepartmentErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.department.DepartmentErrorEnum");
    res.setName("DepartmentErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/department/constant.proto");
    res.setProtoLine(26);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_NOT_FOUND");
        res.setCode(10005001);
        res.setMessage("Department not found");
        res.setMessage2("部门不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the department ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPT_CODE_EXISTS");
        res.setCode(10005002);
        res.setMessage("Department code already exists");
        res.setMessage2("部门代码已存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Use a different department code");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_HAS_CHILDREN");
        res.setCode(10005003);
        res.setMessage("Department has child departments");
        res.setMessage2("部门有子部门，无法删除");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Remove all child departments first");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_HAS_EMPLOYEES");
        res.setCode(10005004);
        res.setMessage("Department has employees");
        res.setMessage2("部门有员工，无法删除");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Remove all employees from this department first");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.department.DepartmentErrorEnum", res);
  }

  void initComponentinfra_departmentDeptStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.department.DeptStatusEnum");
    res.setName("DeptStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/department/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("DeptStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACTIVE");
        res.setCode(1);
        res.setMessage("active");
        res.setMessage2("启用");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DISABLED");
        res.setCode(2);
        res.setMessage("disabled");
        res.setMessage2("禁用");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.department.DeptStatusEnum", res);
  }

  void initComponentinfra_menuMenuStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.menu.MenuStatusEnum");
    res.setName("MenuStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/menu/constant.proto");
    res.setProtoLine(32);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACTIVE");
        res.setCode(1);
        res.setMessage("active");
        res.setMessage2("启用");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INACTIVE");
        res.setCode(2);
        res.setMessage("inactive");
        res.setMessage2("禁用");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.menu.MenuStatusEnum", res);
  }

  void initComponentinfra_menuMenuTypeEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.menu.MenuTypeEnum");
    res.setName("MenuTypeEnum");
    res.setProtoFrom("com/apihug/rad/infra/menu/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuTypeEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DIRECTORY");
        res.setCode(1);
        res.setMessage("directory");
        res.setMessage2("目录");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU");
        res.setCode(2);
        res.setMessage("menu");
        res.setMessage2("菜单");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("BUTTON");
        res.setCode(3);
        res.setMessage("button");
        res.setMessage2("按钮");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.menu.MenuTypeEnum", res);
  }

  void initComponentinfra_menuMenuErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.menu.MenuErrorEnum");
    res.setName("MenuErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/menu/error.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("MenuErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_NOT_FOUND");
        res.setCode(10003001);
        res.setMessage("Menu not found");
        res.setMessage2("菜单不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the menu ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_CODE_EXISTS");
        res.setCode(10003002);
        res.setMessage("Menu code already exists");
        res.setMessage2("菜单代码已存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Use a different menu code");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_HAS_CHILDREN");
        res.setCode(10003003);
        res.setMessage("Menu has child menus");
        res.setMessage2("菜单有子菜单，无法删除");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Remove all child menus first");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INVALID_PARENT_MENU");
        res.setCode(10003004);
        res.setMessage("Invalid parent menu");
        res.setMessage2("无效的父菜单");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the parent menu ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.menu.MenuErrorEnum", res);
  }

  void initComponentinfra_roleRoleStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.role.RoleStatusEnum");
    res.setName("RoleStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/role/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACTIVE");
        res.setCode(1);
        res.setMessage("active");
        res.setMessage2("活跃");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INACTIVE");
        res.setCode(2);
        res.setMessage("inactive");
        res.setMessage2("非活跃");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DISABLED");
        res.setCode(3);
        res.setMessage("disabled");
        res.setMessage2("禁用");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.role.RoleStatusEnum", res);
  }

  void initComponentinfra_roleRoleErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.role.RoleErrorEnum");
    res.setName("RoleErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/role/error.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("RoleErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_NOT_FOUND");
        res.setCode(10002001);
        res.setMessage("Role not found");
        res.setMessage2("角色不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the role ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_CODE_EXISTS");
        res.setCode(10002002);
        res.setMessage("Role code already exists");
        res.setMessage2("角色代码已存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Use a different role code");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_HAS_USERS");
        res.setCode(10002003);
        res.setMessage("Role has assigned users");
        res.setMessage2("角色已分配给用户，无法删除");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Remove all users from this role first");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("PERMISSION_NOT_FOUND");
        res.setCode(10002004);
        res.setMessage("Permission not found");
        res.setMessage2("权限不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the permission ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("PERMISSION_ALREADY_ASSIGNED");
        res.setCode(10002005);
        res.setMessage("Permission already assigned");
        res.setMessage2("权限已分配");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("This permission is already assigned to the role");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.role.RoleErrorEnum", res);
  }

  void initComponentinfra_settingsRadAuthorityEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.settings.RadAuthorityEnum");
    res.setName("RadAuthorityEnum");
    res.setProtoFrom("com/apihug/rad/infra/settings/authority.proto");
    res.setProtoLine(7);
    res.setProtoColumn(1);
    res.setProtoEntity("RadAuthorityEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_CREATE");
        res.setCode(1);
        res.setMessage("customer:create");
        res.setMessage2("创建客户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_UPDATE");
        res.setCode(2);
        res.setMessage("customer:update");
        res.setMessage2("更新客户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_DELETE");
        res.setCode(3);
        res.setMessage("customer:delete");
        res.setMessage2("删除客户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_VIEW");
        res.setCode(4);
        res.setMessage("customer:view");
        res.setMessage2("查看客户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_CREATE");
        res.setCode(5);
        res.setMessage("role:create");
        res.setMessage2("创建角色");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_UPDATE");
        res.setCode(6);
        res.setMessage("role:update");
        res.setMessage2("更新角色");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_DELETE");
        res.setCode(7);
        res.setMessage("role:delete");
        res.setMessage2("删除角色");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_VIEW");
        res.setCode(8);
        res.setMessage("role:view");
        res.setMessage2("查看角色");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ROLE_ASSIGN_PERMISSION");
        res.setCode(9);
        res.setMessage("role:assign_permission");
        res.setMessage2("分配角色权限");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_CREATE");
        res.setCode(10);
        res.setMessage("menu:create");
        res.setMessage2("创建菜单");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_UPDATE");
        res.setCode(11);
        res.setMessage("menu:update");
        res.setMessage2("更新菜单");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_DELETE");
        res.setCode(12);
        res.setMessage("menu:delete");
        res.setMessage2("删除菜单");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MENU_VIEW");
        res.setCode(13);
        res.setMessage("menu:view");
        res.setMessage2("查看菜单");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_CREATE");
        res.setCode(14);
        res.setMessage("tenant:create");
        res.setMessage2("创建租户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_UPDATE");
        res.setCode(15);
        res.setMessage("tenant:update");
        res.setMessage2("更新租户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_DISABLE");
        res.setCode(16);
        res.setMessage("tenant:disable");
        res.setMessage2("停用租户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_CONFIGURE");
        res.setCode(17);
        res.setMessage("tenant:configure");
        res.setMessage2("配置租户");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_CREATE");
        res.setCode(18);
        res.setMessage("department:create");
        res.setMessage2("创建部门");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_UPDATE");
        res.setCode(19);
        res.setMessage("department:update");
        res.setMessage2("更新部门");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_DELETE");
        res.setCode(20);
        res.setMessage("department:delete");
        res.setMessage2("删除部门");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DEPARTMENT_ASSIGN_EMPLOYEE");
        res.setCode(21);
        res.setMessage("department:assign_employee");
        res.setMessage2("分配员工到部门");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_MEMBER_VIEW");
        res.setCode(22);
        res.setMessage("tenant:member:view");
        res.setMessage2("查看租户成员");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_MEMBER_ADD");
        res.setCode(23);
        res.setMessage("tenant:member:add");
        res.setMessage2("添加租户成员");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_MEMBER_REMOVE");
        res.setCode(24);
        res.setMessage("tenant:member:remove");
        res.setMessage2("移除租户成员");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_MEMBER_LOCK");
        res.setCode(25);
        res.setMessage("tenant:member:lock");
        res.setMessage2("锁定租户成员");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_MEMBER_ASSIGN_ROLE");
        res.setCode(26);
        res.setMessage("tenant:member:assign_role");
        res.setMessage2("分配成员角色");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_MEMBER_ASSIGN_DEPARTMENT");
        res.setCode(27);
        res.setMessage("tenant:member:assign_department");
        res.setMessage2("分配成员部门");
        return res;
      }
    }.get());
    res.setEnumAuthorityClz(true);
    components.put("com.apihug.rad.infra.settings.RadAuthorityEnum", res);
  }

  void initComponentinfra_tenantTenantErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.tenant.TenantErrorEnum");
    res.setName("TenantErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/tenant/constant.proto");
    res.setProtoLine(32);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_NOT_FOUND");
        res.setCode(10004001);
        res.setMessage("Tenant not found");
        res.setMessage2("租户不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the tenant ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_CODE_EXISTS");
        res.setCode(10004002);
        res.setMessage("Tenant code already exists");
        res.setMessage2("租户代码已存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Use a different tenant code");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TENANT_HAS_MEMBERS");
        res.setCode(10004003);
        res.setMessage("Tenant has members");
        res.setMessage2("租户下有成员，无法删除");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Remove all members from this tenant first");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.tenant.TenantErrorEnum", res);
  }

  void initComponentinfra_tenantTenantStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.tenant.TenantStatusEnum");
    res.setName("TenantStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/tenant/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACTIVE");
        res.setCode(1);
        res.setMessage("active");
        res.setMessage2("活跃");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("DISABLED");
        res.setCode(2);
        res.setMessage("disabled");
        res.setMessage2("禁用");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("EXPIRED");
        res.setCode(3);
        res.setMessage("expired");
        res.setMessage2("过期");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.tenant.TenantStatusEnum", res);
  }

  void initComponentinfra_tenantMemberRoleEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.tenant.MemberRoleEnum");
    res.setName("MemberRoleEnum");
    res.setProtoFrom("com/apihug/rad/infra/tenant/member_constant.proto");
    res.setProtoLine(40);
    res.setProtoColumn(1);
    res.setProtoEntity("MemberRoleEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MEMBER");
        res.setCode(1);
        res.setMessage("member");
        res.setMessage2("普通成员");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ADMIN");
        res.setCode(2);
        res.setMessage("admin");
        res.setMessage2("管理员");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("OWNER");
        res.setCode(3);
        res.setMessage("owner");
        res.setMessage2("拥有者");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.tenant.MemberRoleEnum", res);
  }

  void initComponentinfra_tenantMemberTypeEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.tenant.MemberTypeEnum");
    res.setName("MemberTypeEnum");
    res.setProtoFrom("com/apihug/rad/infra/tenant/member_constant.proto");
    res.setProtoLine(9);
    res.setProtoColumn(1);
    res.setProtoEntity("MemberTypeEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("FULL_TIME");
        res.setCode(1);
        res.setMessage("full_time");
        res.setMessage2("正式员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("PART_TIME");
        res.setCode(2);
        res.setMessage("part_time");
        res.setMessage2("兼职员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CONTRACTOR");
        res.setCode(3);
        res.setMessage("contractor");
        res.setMessage2("外包员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("INTERN");
        res.setCode(4);
        res.setMessage("intern");
        res.setMessage2("实习生");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.tenant.MemberTypeEnum", res);
  }

  void initComponentinfra_tenantTenantMemberErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.tenant.TenantMemberErrorEnum");
    res.setName("TenantMemberErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/tenant/member_constant.proto");
    res.setProtoLine(91);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantMemberErrorEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MEMBER_NOT_FOUND");
        res.setCode(10007001);
        res.setMessage("Tenant member not found");
        res.setMessage2("租户成员不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Check if the member ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MEMBER_ALREADY_EXISTS");
        res.setCode(10007002);
        res.setMessage("Member already exists in this tenant");
        res.setMessage2("该成员已在此租户中");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("The customer is already a member of this tenant");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("MEMBER_LOCKED");
        res.setCode(10007003);
        res.setMessage("Member is locked");
        res.setMessage2("成员已被锁定");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Contact your tenant administrator");
        res.setError(error);
        return res;
      }
    }.get());
    res.setEnumErrorClz(true);
    components.put("com.apihug.rad.infra.tenant.TenantMemberErrorEnum", res);
  }

  void initComponentinfra_tenantTenantMemberStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.tenant.TenantMemberStatusEnum");
    res.setName("TenantMemberStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/tenant/member_constant.proto");
    res.setProtoLine(66);
    res.setProtoColumn(1);
    res.setProtoEntity("TenantMemberStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TM_ACTIVE");
        res.setCode(1);
        res.setMessage("active");
        res.setMessage2("正常");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TM_INACTIVE");
        res.setCode(2);
        res.setMessage("inactive");
        res.setMessage2("已退出");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("TM_LOCKED");
        res.setCode(3);
        res.setMessage("locked");
        res.setMessage2("已锁定");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.tenant.TenantMemberStatusEnum", res);
  }

  private void initComponents() {
    initComponentapi_auditAccessLogInfo();
    initComponentapi_auditAccessLogStatsResponse();
    initComponentapi_auditGetAccessLogStatsRequest();
    initComponentapi_auditPathStats();
    initComponentapi_auditSearchAccessLogsRequest();
    initComponentapi_customerCreateCustomerRequest();
    initComponentapi_customerCurrentCustomerInfo();
    initComponentapi_customerCustomerInfo();
    initComponentapi_customerCustomerSummary();
    initComponentapi_customerDepartmentInfo();
    initComponentapi_customerForgotPasswordRequest();
    initComponentapi_customerLoginRequest();
    initComponentapi_customerLoginResponse();
    initComponentapi_customerResetPasswordRequest();
    initComponentapi_customerRoleInfo();
    initComponentapi_customerSwitchTenantRequest();
    initComponentapi_customerTenantInfo();
    initComponentapi_customerTenantList();
    initComponentapi_departmentCreateDepartmentRequest();
    initComponentapi_departmentDepartmentDetail();
    initComponentapi_departmentDepartmentSummary();
    initComponentapi_departmentDepartmentTreeNode();
    initComponentapi_departmentUpdateDepartmentRequest();
    initComponentapi_menuCreateMenuRequest();
    initComponentapi_menuMenuDetail();
    initComponentapi_menuMenuSummary();
    initComponentapi_menuMenuTreeNode();
    initComponentapi_menuSearchMenusRequest();
    initComponentapi_menuUpdateMenuRequest();
    initComponentapi_permissionPermissionInfo();
    initComponentapi_roleAssignMenusRequest();
    initComponentapi_roleCreateRoleRequest();
    initComponentapi_roleRoleDetail();
    initComponentapi_roleRoleMenuItem();
    initComponentapi_roleRoleMenuSummary();
    initComponentapi_roleRoleSummary();
    initComponentapi_roleSearchRolesRequest();
    initComponentapi_roleUpdateRoleRequest();
    initComponentapi_tenantConfigureTenantRequest();
    initComponentapi_tenantCreateTenantRequest();
    initComponentapi_tenantSearchTenantsRequest();
    initComponentapi_tenantTenantDetail();
    initComponentapi_tenantTenantSummary();
    initComponentapi_tenantUpdateTenantRequest();
    initComponentapi_tenantAddTenantMemberRequest();
    initComponentapi_tenantAssignMemberDepartmentRequest();
    initComponentapi_tenantAssignRolesRequest();
    initComponentapi_tenantGetTenantMembersRequest();
    initComponentapi_tenantMemberRoleItem();
    initComponentapi_tenantMemberRoleSummary();
    initComponentapi_tenantTenantMemberDetail();
    initComponentapi_tenantTenantMemberSummary();
    initComponentapi_tenantUpdateMemberRoleRequest();
    initComponentinfra_authAuthErrorEnum();
    initComponentinfra_customerCustomerStatusEnum();
    initComponentinfra_customerCustomerErrorEnum();
    initComponentinfra_departmentDepartmentErrorEnum();
    initComponentinfra_departmentDeptStatusEnum();
    initComponentinfra_menuMenuStatusEnum();
    initComponentinfra_menuMenuTypeEnum();
    initComponentinfra_menuMenuErrorEnum();
    initComponentinfra_roleRoleStatusEnum();
    initComponentinfra_roleRoleErrorEnum();
    initComponentinfra_settingsRadAuthorityEnum();
    initComponentinfra_tenantTenantErrorEnum();
    initComponentinfra_tenantTenantStatusEnum();
    initComponentinfra_tenantMemberRoleEnum();
    initComponentinfra_tenantMemberTypeEnum();
    initComponentinfra_tenantTenantMemberErrorEnum();
    initComponentinfra_tenantTenantMemberStatusEnum();
  }
}
