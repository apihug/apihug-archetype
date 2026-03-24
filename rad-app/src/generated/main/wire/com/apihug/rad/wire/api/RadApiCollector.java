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
    var _GetCurrentUserInfo = new ServiceMethod();
    _GetCurrentUserInfo.setName("GetCurrentUserInfo");
    _GetCurrentUserInfo.setProtoLine(77);
    _GetCurrentUserInfo.setProtoColumn(3);
    _GetCurrentUserInfo.setRequestRef("hope.common.adaptor.Empty");
    _GetCurrentUserInfo.setResponseRef("com.apihug.rad.api.customer.CurrentUserInfo");
    _GetCurrentUserInfo.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("获取当前客户信息");
        res.setDescription("获取当前客户完整信息（包含权限、角色、部门）");
        res.setGet("/api/customer/current-user-info");
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
    _GetCurrentUserInfo.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetCurrentUserInfo.setPath("/api/customer/current-user-info");
    res.addItem(_GetCurrentUserInfo);
    var _GetUserOrganizations = new ServiceMethod();
    _GetUserOrganizations.setName("GetUserOrganizations");
    _GetUserOrganizations.setProtoLine(94);
    _GetUserOrganizations.setProtoColumn(3);
    _GetUserOrganizations.setRequestRef("hope.common.adaptor.Empty");
    _GetUserOrganizations.setResponseRef("com.apihug.rad.api.customer.OrganizationList");
    _GetUserOrganizations.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("获取客户组织");
        res.setDescription("获取客户的所有组织列表");
        res.setGet("/api/customer/user-organizations");
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
    _GetUserOrganizations.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetUserOrganizations.setPath("/api/customer/user-organizations");
    res.addItem(_GetUserOrganizations);
    var _SwitchOrganization = new ServiceMethod();
    _SwitchOrganization.setName("SwitchOrganization");
    _SwitchOrganization.setProtoLine(106);
    _SwitchOrganization.setProtoColumn(3);
    _SwitchOrganization.setRequestRef("com.apihug.rad.api.customer.SwitchOrganizationRequest");
    _SwitchOrganization.setResponseRef("com.apihug.rad.api.customer.LoginResponse");
    _SwitchOrganization.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("切换组织");
        res.setDescription("切换到指定组织");
        res.setPost("/api/customer/switch-organization");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            res.setLowLimitRiskyMode(Authorization.LowLimitRiskyMode.LOGIN);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("切换组织后返回什么？","切换组织后权限如何变化？"));
        return res;
      }
    }.get());
    _SwitchOrganization.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SwitchOrganization.setPath("/api/customer/switch-organization");
    res.addItem(_SwitchOrganization);
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
    var _GetCustomer = new ServiceMethod();
    _GetCustomer.setName("GetCustomer");
    _GetCustomer.setProtoLine(150);
    _GetCustomer.setProtoColumn(3);
    _GetCustomer.setRequestRef("hope.common.adaptor.Empty");
    _GetCustomer.setResponseRef("com.apihug.rad.api.customer.CustomerDetail");
    _GetCustomer.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("获取客户详情");
        res.setDescription("获取客户详情");
        res.setGet("/api/customers/customers/{customerId}");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("CUSTOMER_VIEW"));
            rbac.setPredefinedRoleChecker(RBAC.PredefinedRoleCheckerType.TENANT);
            rbac.setCombinator(RBAC.Combinator.OR);
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何获取客户详情？","客户详情包含哪些信息？"));
        return res;
      }
    }.get());
    _GetCustomer.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetCustomer.setPath("/api/customers/customers/{customerId}");
    res.addItem(_GetCustomer);
    var _UpdateCustomer = new ServiceMethod();
    _UpdateCustomer.setName("UpdateCustomer");
    _UpdateCustomer.setProtoLine(180);
    _UpdateCustomer.setProtoColumn(3);
    _UpdateCustomer.setRequestRef("com.apihug.rad.api.customer.UpdateCustomerRequest");
    _UpdateCustomer.setResponseRef("hope.common.adaptor.Empty");
    _UpdateCustomer.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("更新客户");
        res.setDescription("更新客户信息");
        res.setPut("/api/customers/customers/{customerId}");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("CUSTOMER_UPDATE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何更新客户信息？","哪些字段可以更新？"));
        return res;
      }
    }.get());
    _UpdateCustomer.setHttpMethod(ServiceMethod.HttpMethod.PUT);
    _UpdateCustomer.setPath("/api/customers/customers/{customerId}");
    res.addItem(_UpdateCustomer);
    var _DeleteCustomer = new ServiceMethod();
    _DeleteCustomer.setName("DeleteCustomer");
    _DeleteCustomer.setProtoLine(208);
    _DeleteCustomer.setProtoColumn(3);
    _DeleteCustomer.setRequestRef("hope.common.adaptor.Empty");
    _DeleteCustomer.setResponseRef("hope.common.adaptor.Empty");
    _DeleteCustomer.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("删除客户");
        res.setDescription("删除客户（软删除）");
        res.setDelete("/api/customers/customers/{customerId}");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("CUSTOMER_DELETE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何删除客户？","是物理删除还是软删除？"));
        return res;
      }
    }.get());
    _DeleteCustomer.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _DeleteCustomer.setPath("/api/customers/customers/{customerId}");
    res.addItem(_DeleteCustomer);
    var _SearchCustomers = new ServiceMethod();
    _SearchCustomers.setName("SearchCustomers");
    _SearchCustomers.setProtoLine(236);
    _SearchCustomers.setProtoColumn(3);
    _SearchCustomers.setRequestRef("com.apihug.rad.api.customer.SearchCustomersRequest");
    _SearchCustomers.setResponseRef("com.apihug.rad.api.customer.CustomerSummary");
    _SearchCustomers.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer"));
        res.setSummary("搜索客户");
        res.setDescription("搜索客户（分页）");
        res.setPageable(true);
        res.setPost("/api/customers/customers/search");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("CUSTOMER_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        res.setQuestions(Arrays.asList("如何搜索客户？","支持哪些筛选条件？","如何分页？"));
        return res;
      }
    }.get());
    _SearchCustomers.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SearchCustomers.setPath("/api/customers/customers/search");
    res.addItem(_SearchCustomers);
    var _ForgotPassword = new ServiceMethod();
    _ForgotPassword.setName("ForgotPassword");
    _ForgotPassword.setProtoLine(256);
    _ForgotPassword.setProtoColumn(3);
    _ForgotPassword.setRequestRef("com.apihug.rad.api.customer.ForgotPasswordRequest");
    _ForgotPassword.setResponseRef("hope.common.adaptor.Empty");
    _ForgotPassword.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("auth"));
        res.setSummary("找回密码");
        res.setDescription("申请找回密码（发送重置邮件）");
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
    _ResetPassword.setProtoLine(272);
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

  void initServiceapi_departmentDepartmentEmployeeService() {
    Service res = new Service();
    res.setDescription("============ 部门员工管理 API ============\n"
            + "部门员工管理服务，提供员工部门关联功能");
    res.setClzName("com.apihug.rad.api.department.DepartmentEmployeeService");
    res.setName("DepartmentEmployeeService");
    res.setProtoFrom("com/apihug/rad/api/department/employee.proto");
    res.setProtoLine(10);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentEmployeeService");
    res.setPath("/department-employees");
    var _AddEmployeeToDepartment = new ServiceMethod();
    _AddEmployeeToDepartment.setName("AddEmployeeToDepartment");
    _AddEmployeeToDepartment.setProtoLine(16);
    _AddEmployeeToDepartment.setProtoColumn(3);
    _AddEmployeeToDepartment.setRequestRef("com.apihug.rad.api.department.AddEmployeeRequest");
    _AddEmployeeToDepartment.setResponseRef("hope.common.adaptor.Empty");
    _AddEmployeeToDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department-employee"));
        res.setSummary("添加员工");
        res.setDescription("添加员工到部门");
        res.setPost("/api/department-employees/department-employees");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("DEPARTMENT_ASSIGN_EMPLOYEE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AddEmployeeToDepartment.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AddEmployeeToDepartment.setPath("/api/department-employees/department-employees");
    res.addItem(_AddEmployeeToDepartment);
    var _RemoveEmployeeFromDepartment = new ServiceMethod();
    _RemoveEmployeeFromDepartment.setName("RemoveEmployeeFromDepartment");
    _RemoveEmployeeFromDepartment.setProtoLine(30);
    _RemoveEmployeeFromDepartment.setProtoColumn(3);
    _RemoveEmployeeFromDepartment.setRequestRef("com.apihug.rad.api.department.RemoveEmployeeRequest");
    _RemoveEmployeeFromDepartment.setResponseRef("hope.common.adaptor.Empty");
    _RemoveEmployeeFromDepartment.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department-employee"));
        res.setSummary("移除员工");
        res.setDescription("从部门移除员工");
        res.setDelete("/api/department-employees/department-employees/{employeeId}");
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
            res.setName("employeeId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("DEPARTMENT_ASSIGN_EMPLOYEE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _RemoveEmployeeFromDepartment.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _RemoveEmployeeFromDepartment.setPath("/api/department-employees/department-employees/{employeeId}");
    res.addItem(_RemoveEmployeeFromDepartment);
    var _TransferEmployee = new ServiceMethod();
    _TransferEmployee.setName("TransferEmployee");
    _TransferEmployee.setProtoLine(54);
    _TransferEmployee.setProtoColumn(3);
    _TransferEmployee.setRequestRef("com.apihug.rad.api.department.TransferEmployeeRequest");
    _TransferEmployee.setResponseRef("hope.common.adaptor.Empty");
    _TransferEmployee.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department-employee"));
        res.setSummary("员工调岗");
        res.setDescription("员工调岗");
        res.setPost("/api/department-employees/department-employees/transfer");
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("DEPARTMENT_ASSIGN_EMPLOYEE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _TransferEmployee.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _TransferEmployee.setPath("/api/department-employees/department-employees/transfer");
    res.addItem(_TransferEmployee);
    var _GetDepartmentEmployees = new ServiceMethod();
    _GetDepartmentEmployees.setName("GetDepartmentEmployees");
    _GetDepartmentEmployees.setProtoLine(68);
    _GetDepartmentEmployees.setProtoColumn(3);
    _GetDepartmentEmployees.setRequestRef("hope.common.adaptor.Empty");
    _GetDepartmentEmployees.setResponseRef("com.apihug.rad.api.department.DepartmentEmployeeList");
    _GetDepartmentEmployees.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("department-employee"));
        res.setSummary("获取部门员工");
        res.setDescription("获取部门员工列表");
        res.setGet("/api/department-employees/departments/{departmentId}/employees");
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
    _GetDepartmentEmployees.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetDepartmentEmployees.setPath("/api/department-employees/departments/{departmentId}/employees");
    res.addItem(_GetDepartmentEmployees);
    services.put("com.apihug.rad.api.department.DepartmentEmployeeService", res);
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

  void initServiceapi_organizationOrganizationService() {
    Service res = new Service();
    res.setDescription("============ 组织管理 API ============\n"
            + "组织管理服务，提供组织树、部门树查询等功能");
    res.setClzName("com.apihug.rad.api.organization.OrganizationService");
    res.setName("OrganizationService");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(10);
    res.setProtoColumn(1);
    res.setProtoEntity("OrganizationService");
    res.setPath("/organizations");
    var _GetOrganizationTree = new ServiceMethod();
    _GetOrganizationTree.setName("GetOrganizationTree");
    _GetOrganizationTree.setProtoLine(16);
    _GetOrganizationTree.setProtoColumn(3);
    _GetOrganizationTree.setRequestRef("hope.common.adaptor.Empty");
    _GetOrganizationTree.setResponseRef("com.apihug.rad.api.organization.OrganizationTreeNode");
    _GetOrganizationTree.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("organization"));
        res.setSummary("获取组织树");
        res.setDescription("获取组织树形结构");
        res.setGet("/api/organizations/tree");
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
    _GetOrganizationTree.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetOrganizationTree.setPath("/api/organizations/tree");
    res.addItem(_GetOrganizationTree);
    var _GetDepartmentTree = new ServiceMethod();
    _GetDepartmentTree.setName("GetDepartmentTree");
    _GetDepartmentTree.setProtoLine(28);
    _GetDepartmentTree.setProtoColumn(3);
    _GetDepartmentTree.setRequestRef("hope.common.adaptor.Empty");
    _GetDepartmentTree.setResponseRef("com.apihug.rad.api.organization.DepartmentTreeNode");
    _GetDepartmentTree.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("organization"));
        res.setSummary("获取部门树");
        res.setDescription("获取当前组织的部门树形结构");
        res.setGet("/api/organizations/department-tree");
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
    _GetDepartmentTree.setPath("/api/organizations/department-tree");
    res.addItem(_GetDepartmentTree);
    var _GetUserDepartments = new ServiceMethod();
    _GetUserDepartments.setName("GetUserDepartments");
    _GetUserDepartments.setProtoLine(40);
    _GetUserDepartments.setProtoColumn(3);
    _GetUserDepartments.setRequestRef("hope.common.adaptor.Empty");
    _GetUserDepartments.setResponseRef("com.apihug.rad.api.organization.UserDepartmentList");
    _GetUserDepartments.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("organization"));
        res.setSummary("获取用户部门");
        res.setDescription("获取用户的部门列表");
        res.setGet("/api/organizations/user-departments");
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
    _GetUserDepartments.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetUserDepartments.setPath("/api/organizations/user-departments");
    res.addItem(_GetUserDepartments);
    var _GetUserOrganizations = new ServiceMethod();
    _GetUserOrganizations.setName("GetUserOrganizations");
    _GetUserOrganizations.setProtoLine(53);
    _GetUserOrganizations.setProtoColumn(3);
    _GetUserOrganizations.setRequestRef("hope.common.adaptor.Empty");
    _GetUserOrganizations.setResponseRef("com.apihug.rad.api.organization.OrganizationSummary");
    _GetUserOrganizations.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("organization"));
        res.setSummary("获取我的组织");
        res.setDescription("获取当前用户的组织列表\n"
                + "获取当前用户所属的组织列表");
        res.setPageable(true);
        res.setGet("/api/organizations/my-organizations");
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
    _GetUserOrganizations.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetUserOrganizations.setPath("/api/organizations/my-organizations");
    res.addItem(_GetUserOrganizations);
    var _SetDefaultOrganization = new ServiceMethod();
    _SetDefaultOrganization.setName("SetDefaultOrganization");
    _SetDefaultOrganization.setProtoLine(67);
    _SetDefaultOrganization.setProtoColumn(3);
    _SetDefaultOrganization.setRequestRef("com.apihug.rad.api.organization.SetDefaultOrganizationRequest");
    _SetDefaultOrganization.setResponseRef("hope.common.adaptor.Empty");
    _SetDefaultOrganization.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("organization"));
        res.setSummary("设置默认组织");
        res.setDescription("设置默认组织\n"
                + "设置用户的默认组织");
        res.setPost("/api/organizations/my-organizations/{organizationId}/default");
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
            res.setName("organizationId");
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
    _SetDefaultOrganization.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _SetDefaultOrganization.setPath("/api/organizations/my-organizations/{organizationId}/default");
    res.addItem(_SetDefaultOrganization);
    services.put("com.apihug.rad.api.organization.OrganizationService", res);
  }

  void initServiceapi_organizationCustomerOrganizationService() {
    Service res = new Service();
    res.setDescription("============ 组织员工管理 API ============\n"
            + "组织员工管理服务，提供员工 - 组织关系管理功能");
    res.setClzName("com.apihug.rad.api.organization.CustomerOrganizationService");
    res.setName("CustomerOrganizationService");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(11);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerOrganizationService");
    res.setPath("/customer-organizations");
    var _GetOrganizationMembers = new ServiceMethod();
    _GetOrganizationMembers.setName("GetOrganizationMembers");
    _GetOrganizationMembers.setProtoLine(18);
    _GetOrganizationMembers.setProtoColumn(3);
    _GetOrganizationMembers.setRequestRef("com.apihug.rad.api.organization.GetOrganizationMembersRequest");
    _GetOrganizationMembers.setResponseRef("com.apihug.rad.api.organization.CustomerOrganizationSummary");
    _GetOrganizationMembers.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer-organization"));
        res.setSummary("获取组织员工");
        res.setDescription("获取组织员工列表 - 使用 pageable: true，返回单个对象，框架自动包装成 Page\n"
                + "获取组织员工列表");
        res.setPageable(true);
        res.setGet("/api/customer-organizations/organizations/{organizationId}/members");
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
            res.setName("organizationId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ORGANIZATION_MEMBER_VIEW"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _GetOrganizationMembers.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetOrganizationMembers.setPath("/api/customer-organizations/organizations/{organizationId}/members");
    res.addItem(_GetOrganizationMembers);
    var _AddMemberToOrganization = new ServiceMethod();
    _AddMemberToOrganization.setName("AddMemberToOrganization");
    _AddMemberToOrganization.setProtoLine(44);
    _AddMemberToOrganization.setProtoColumn(3);
    _AddMemberToOrganization.setRequestRef("com.apihug.rad.api.organization.AddMemberRequest");
    _AddMemberToOrganization.setResponseRef("hope.common.adaptor.Empty");
    _AddMemberToOrganization.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer-organization"));
        res.setSummary("添加组织员工");
        res.setDescription("添加员工到组织\n"
                + "添加员工到组织");
        res.setPost("/api/customer-organizations/organizations/{organizationId}/members");
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
            res.setName("organizationId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ORGANIZATION_MEMBER_ADD"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AddMemberToOrganization.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AddMemberToOrganization.setPath("/api/customer-organizations/organizations/{organizationId}/members");
    res.addItem(_AddMemberToOrganization);
    var _RemoveMemberFromOrganization = new ServiceMethod();
    _RemoveMemberFromOrganization.setName("RemoveMemberFromOrganization");
    _RemoveMemberFromOrganization.setProtoLine(69);
    _RemoveMemberFromOrganization.setProtoColumn(3);
    _RemoveMemberFromOrganization.setRequestRef("com.apihug.rad.api.organization.RemoveMemberRequest");
    _RemoveMemberFromOrganization.setResponseRef("hope.common.adaptor.Empty");
    _RemoveMemberFromOrganization.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer-organization"));
        res.setSummary("移除组织员工");
        res.setDescription("从组织移除员工\n"
                + "从组织移除员工");
        res.setDelete("/api/customer-organizations/organizations/{organizationId}/members/{customerId}");
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
            res.setName("organizationId");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ORGANIZATION_MEMBER_REMOVE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _RemoveMemberFromOrganization.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _RemoveMemberFromOrganization.setPath("/api/customer-organizations/organizations/{organizationId}/members/{customerId}");
    res.addItem(_RemoveMemberFromOrganization);
    var _ToggleMemberLock = new ServiceMethod();
    _ToggleMemberLock.setName("ToggleMemberLock");
    _ToggleMemberLock.setProtoLine(102);
    _ToggleMemberLock.setProtoColumn(3);
    _ToggleMemberLock.setRequestRef("com.apihug.rad.api.organization.ToggleMemberLockRequest");
    _ToggleMemberLock.setResponseRef("hope.common.adaptor.Empty");
    _ToggleMemberLock.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer-organization"));
        res.setSummary("切换员工锁定状态");
        res.setDescription("锁定/解锁员工\n"
                + "锁定/解锁组织员工");
        res.setPost("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock");
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
            res.setName("organizationId");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ORGANIZATION_MEMBER_LOCK"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _ToggleMemberLock.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _ToggleMemberLock.setPath("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/toggle-lock");
    res.addItem(_ToggleMemberLock);
    var _AssignMemberRoles = new ServiceMethod();
    _AssignMemberRoles.setName("AssignMemberRoles");
    _AssignMemberRoles.setProtoLine(135);
    _AssignMemberRoles.setProtoColumn(3);
    _AssignMemberRoles.setRequestRef("com.apihug.rad.api.organization.AssignMemberRolesRequest");
    _AssignMemberRoles.setResponseRef("hope.common.adaptor.Empty");
    _AssignMemberRoles.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer-organization"));
        res.setSummary("分配员工角色");
        res.setDescription("配置员工角色\n"
                + "配置员工角色");
        res.setPost("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles");
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
            res.setName("organizationId");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ORGANIZATION_MEMBER_ASSIGN_ROLE"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AssignMemberRoles.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AssignMemberRoles.setPath("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/roles");
    res.addItem(_AssignMemberRoles);
    var _AssignMemberMenus = new ServiceMethod();
    _AssignMemberMenus.setName("AssignMemberMenus");
    _AssignMemberMenus.setProtoLine(168);
    _AssignMemberMenus.setProtoColumn(3);
    _AssignMemberMenus.setRequestRef("com.apihug.rad.api.organization.AssignMemberMenusRequest");
    _AssignMemberMenus.setResponseRef("hope.common.adaptor.Empty");
    _AssignMemberMenus.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("customer-organization"));
        res.setSummary("分配员工菜单");
        res.setDescription("配置员工菜单权限\n"
                + "配置员工菜单权限");
        res.setPost("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus");
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
            res.setName("organizationId");
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
            res.setName("customerId");
            return res;
          }
        }.get());
        res.setAuthorization(new Supplier<Authorization>() {
          @Override
          public Authorization get() {
            Authorization res = new Authorization();
            RBAC rbac = new RBAC();
            rbac.setAuthorityClz("com.apihug.rad.infra.settings.RadAuthorityEnum");
            rbac.setAuthorities(Arrays.asList("ORGANIZATION_MEMBER_ASSIGN_MENU"));
            res.setRbac(rbac);
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    _AssignMemberMenus.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AssignMemberMenus.setPath("/api/customer-organizations/organizations/{organizationId}/members/{customerId}/menus");
    res.addItem(_AssignMemberMenus);
    services.put("com.apihug.rad.api.organization.CustomerOrganizationService", res);
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
        res.setDescription("获取用户的角色权限集合\n"
                + "获取用户的角色权限集合");
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
        res.setDescription("获取用户的菜单权限集合\n"
                + "获取用户的菜单权限集合");
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
        res.setDescription("获取用户的所有权限（角色权限 ∪ 菜单权限）\n"
                + "获取用户的所有权限（聚合）");
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
    var _AssignPermissions = new ServiceMethod();
    _AssignPermissions.setName("AssignPermissions");
    _AssignPermissions.setProtoLine(138);
    _AssignPermissions.setProtoColumn(3);
    _AssignPermissions.setRequestRef("com.apihug.rad.api.role.AssignPermissionsRequest");
    _AssignPermissions.setResponseRef("hope.common.adaptor.Empty");
    _AssignPermissions.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("分配权限");
        res.setDescription("为角色分配权限");
        res.setPost("/api/roles/roles/{roleId}/permissions");
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
        res.setQuestions(Arrays.asList("如何为角色分配权限？","可以分配多个权限吗？"));
        return res;
      }
    }.get());
    _AssignPermissions.setHttpMethod(ServiceMethod.HttpMethod.POST);
    _AssignPermissions.setPath("/api/roles/roles/{roleId}/permissions");
    res.addItem(_AssignPermissions);
    var _RemovePermission = new ServiceMethod();
    _RemovePermission.setName("RemovePermission");
    _RemovePermission.setProtoLine(166);
    _RemovePermission.setProtoColumn(3);
    _RemovePermission.setRequestRef("com.apihug.rad.api.role.RemovePermissionRequest");
    _RemovePermission.setResponseRef("hope.common.adaptor.Empty");
    _RemovePermission.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("移除权限");
        res.setDescription("移除角色权限");
        res.setDelete("/api/roles/roles/{roleId}/permissions/{permissionId}");
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
            res.setName("permissionId");
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
        res.setQuestions(Arrays.asList("如何移除角色权限？","移除权限后用户会立即失去该权限吗？"));
        return res;
      }
    }.get());
    _RemovePermission.setHttpMethod(ServiceMethod.HttpMethod.DELETE);
    _RemovePermission.setPath("/api/roles/roles/{roleId}/permissions/{permissionId}");
    res.addItem(_RemovePermission);
    var _GetRolePermissions = new ServiceMethod();
    _GetRolePermissions.setName("GetRolePermissions");
    _GetRolePermissions.setProtoLine(202);
    _GetRolePermissions.setProtoColumn(3);
    _GetRolePermissions.setRequestRef("hope.common.adaptor.Empty");
    _GetRolePermissions.setResponseRef("com.apihug.rad.api.role.RolePermissionSummary");
    _GetRolePermissions.setSchema(new Supplier<Operation>() {
      @Override
      public Operation get() {
        Operation res  = new Operation();
        res.setTags(Arrays.asList("role"));
        res.setSummary("获取角色权限");
        res.setDescription("获取角色的权限列表");
        res.setGet("/api/roles/roles/{roleId}/permissions");
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
        res.setQuestions(Arrays.asList("如何获取角色的权限列表？","返回什么格式的权限信息？"));
        return res;
      }
    }.get());
    _GetRolePermissions.setHttpMethod(ServiceMethod.HttpMethod.GET);
    _GetRolePermissions.setPath("/api/roles/roles/{roleId}/permissions");
    res.addItem(_GetRolePermissions);
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
    services.put("com.apihug.rad.api.tenant.TenantService", res);
  }

  private void initServices() {
    initServiceapi_auditAccessLogService();
    initServiceapi_customerCustomerAuthService();
    initServiceapi_customerCustomerService();
    initServiceapi_customerCustomerManagementService();
    initServiceapi_departmentDepartmentService();
    initServiceapi_departmentDepartmentEmployeeService();
    initServiceapi_menuMenuService();
    initServiceapi_metaApihugService();
    initServiceapi_organizationOrganizationService();
    initServiceapi_organizationCustomerOrganizationService();
    initServiceapi_permissionPermissionService();
    initServiceapi_roleRoleService();
    initServiceapi_tenantTenantService();
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
    res.setProtoLine(504);
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
    _username.setProtoLine(512);
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
    _password.setProtoLine(520);
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
    _email.setProtoLine(528);
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
    _status.setProtoLine(536);
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
    _defaultTenantId.setProtoLine(542);
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

  void initComponentapi_customerCurrentUserInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CurrentUserInfo");
    res.setName("CurrentUserInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(441);
    res.setProtoColumn(1);
    res.setProtoEntity("CurrentUserInfo");
    res.setDescription("当前客户完整信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CurrentUserInfo");
            res.setDescription("当前客户完整信息");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _user = new ComponentItem();
    _user.setClzName("com.apihug.rad.api.customer.CustomerInfo");
    _user.setName("user");
    _user.setFieldName("user");
    _user.setTag(1);
    _user.setProtoLine(449);
    _user.setProtoColumn(3);
    _user.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户基本信息");
        return res;
      }
    }.get());
    res.addItem(_user);
    ComponentItem _roles = new ComponentItem();
    _roles.setClzName("com.apihug.rad.api.customer.RoleInfo");
    _roles.setName("roles");
    _roles.setFieldName("roles");
    _roles.setTag(2);
    _roles.setProtoLine(453);
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
    _authorities.setProtoLine(457);
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
    _department.setProtoLine(461);
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
    ComponentItem _currentOrganization = new ComponentItem();
    _currentOrganization.setClzName("com.apihug.rad.api.customer.OrganizationInfo");
    _currentOrganization.setName("current_organization");
    _currentOrganization.setFieldName("currentOrganization");
    _currentOrganization.setTag(5);
    _currentOrganization.setProtoLine(465);
    _currentOrganization.setProtoColumn(3);
    _currentOrganization.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("当前组织信息");
        return res;
      }
    }.get());
    res.addItem(_currentOrganization);
    components.put("com.apihug.rad.api.customer.CurrentUserInfo", res);
  }

  void initComponentapi_customerCustomerDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CustomerDetail");
    res.setName("CustomerDetail");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(591);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerDetail");
    res.setDescription("客户详情信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CustomerDetail");
            res.setDescription("客户详情信息");
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
    _id.setProtoLine(599);
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
    _username.setProtoLine(606);
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
    _email.setProtoLine(613);
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
    _status.setProtoLine(620);
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
    _defaultTenantId.setProtoLine(626);
    _defaultTenantId.setProtoColumn(3);
    _defaultTenantId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("默认租户 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_defaultTenantId);
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(6);
    _createdAt.setProtoLine(632);
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
    _updatedAt.setProtoLine(638);
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
    components.put("com.apihug.rad.api.customer.CustomerDetail", res);
  }

  void initComponentapi_customerCustomerInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.CustomerInfo");
    res.setName("CustomerInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(402);
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
    _customerId.setProtoLine(409);
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
    _username.setProtoLine(417);
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
    _tenantId.setProtoLine(424);
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
    _roles.setProtoLine(432);
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
    _authorities.setProtoLine(436);
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
    res.setProtoLine(549);
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
    _id.setProtoLine(557);
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
    _username.setProtoLine(564);
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
    _email.setProtoLine(571);
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
    _status.setProtoLine(578);
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
    _tenantId.setProtoLine(584);
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
    res.setProtoLine(758);
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
    _id.setProtoLine(766);
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
    _deptCode.setProtoLine(772);
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
    _deptName.setProtoLine(779);
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
    _parentId.setProtoLine(786);
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
    res.setProtoLine(687);
    res.setProtoColumn(1);
    res.setProtoEntity("ForgotPasswordRequest");
    res.setDescription("找回密码请求");
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
    _email.setProtoLine(695);
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
    res.setProtoLine(291);
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
    _username.setProtoLine(299);
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
    _password.setProtoLine(307);
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
    _rememberMe.setProtoLine(315);
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
    res.setProtoLine(320);
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
    _accessToken.setProtoLine(328);
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
    _customerId.setProtoLine(335);
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
    _username.setProtoLine(343);
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
    ComponentItem _needsOrganizationSelection = new ComponentItem();
    _needsOrganizationSelection.setClzName("java.lang.Boolean");
    _needsOrganizationSelection.setName("needs_organization_selection");
    _needsOrganizationSelection.setFieldName("needsOrganizationSelection");
    _needsOrganizationSelection.setTag(4);
    _needsOrganizationSelection.setProtoLine(351);
    _needsOrganizationSelection.setProtoColumn(3);
    _needsOrganizationSelection.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否需要选择组织");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_needsOrganizationSelection);
    ComponentItem _organizations = new ComponentItem();
    _organizations.setClzName("com.apihug.rad.api.customer.OrganizationInfo");
    _organizations.setName("organizations");
    _organizations.setFieldName("organizations");
    _organizations.setTag(5);
    _organizations.setProtoLine(357);
    _organizations.setProtoColumn(3);
    _organizations.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户的组织列表");
        return res;
      }
    }.get());
    _organizations.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_organizations);
    ComponentItem _defaultOrganization = new ComponentItem();
    _defaultOrganization.setClzName("com.apihug.rad.api.customer.OrganizationInfo");
    _defaultOrganization.setName("default_organization");
    _defaultOrganization.setFieldName("defaultOrganization");
    _defaultOrganization.setTag(6);
    _defaultOrganization.setProtoLine(362);
    _defaultOrganization.setProtoColumn(3);
    _defaultOrganization.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("默认组织信息");
        return res;
      }
    }.get());
    res.addItem(_defaultOrganization);
    components.put("com.apihug.rad.api.customer.LoginResponse", res);
  }

  void initComponentapi_customerOrganizationInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.OrganizationInfo");
    res.setName("OrganizationInfo");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(368);
    res.setProtoColumn(1);
    res.setProtoEntity("OrganizationInfo");
    res.setDescription("组织信息（用于登录响应）\n"
            + "组织信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("OrganizationInfo");
            res.setDescription("组织信息");
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
    _id.setProtoLine(376);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _organizationCode = new ComponentItem();
    _organizationCode.setClzName("java.lang.String");
    _organizationCode.setName("organization_code");
    _organizationCode.setFieldName("organizationCode");
    _organizationCode.setTag(2);
    _organizationCode.setProtoLine(382);
    _organizationCode.setProtoColumn(3);
    _organizationCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织代码");
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
    res.addItem(_organizationCode);
    ComponentItem _organizationName = new ComponentItem();
    _organizationName.setClzName("java.lang.String");
    _organizationName.setName("organization_name");
    _organizationName.setFieldName("organizationName");
    _organizationName.setTag(3);
    _organizationName.setProtoLine(389);
    _organizationName.setProtoColumn(3);
    _organizationName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织名称");
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
    res.addItem(_organizationName);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(4);
    _isDefault.setProtoLine(396);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否默认组织");
        res.setExample("true");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    components.put("com.apihug.rad.api.customer.OrganizationInfo", res);
  }

  void initComponentapi_customerOrganizationList() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.OrganizationList");
    res.setName("OrganizationList");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(470);
    res.setProtoColumn(1);
    res.setProtoEntity("OrganizationList");
    res.setDescription("组织列表");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("OrganizationList");
            res.setDescription("组织列表");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _organizations = new ComponentItem();
    _organizations.setClzName("com.apihug.rad.api.customer.OrganizationInfo");
    _organizations.setName("organizations");
    _organizations.setFieldName("organizations");
    _organizations.setTag(1);
    _organizations.setProtoLine(478);
    _organizations.setProtoColumn(3);
    _organizations.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织列表");
        return res;
      }
    }.get());
    _organizations.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_organizations);
    ComponentItem _defaultOrganizationId = new ComponentItem();
    _defaultOrganizationId.setClzName("java.lang.Long");
    _defaultOrganizationId.setName("default_organization_id");
    _defaultOrganizationId.setFieldName("defaultOrganizationId");
    _defaultOrganizationId.setTag(2);
    _defaultOrganizationId.setProtoLine(482);
    _defaultOrganizationId.setProtoColumn(3);
    _defaultOrganizationId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("默认组织 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_defaultOrganizationId);
    components.put("com.apihug.rad.api.customer.OrganizationList", res);
  }

  void initComponentapi_customerResetPasswordRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.ResetPasswordRequest");
    res.setName("ResetPasswordRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(704);
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
    _token.setProtoLine(712);
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
    _password.setProtoLine(720);
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
    res.setProtoLine(729);
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
    _id.setProtoLine(737);
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
    _roleCode.setProtoLine(743);
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
    _roleName.setProtoLine(750);
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

  void initComponentapi_customerSearchCustomersRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.SearchCustomersRequest");
    res.setName("SearchCustomersRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(668);
    res.setProtoColumn(1);
    res.setProtoEntity("SearchCustomersRequest");
    res.setDescription("搜索客户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SearchCustomersRequest");
            res.setDescription("搜索客户请求");
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
    _keyword.setProtoLine(676);
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
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.customer.CustomerStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(2);
    _status.setProtoLine(681);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("客户状态筛选");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.customer.SearchCustomersRequest", res);
  }

  void initComponentapi_customerSwitchOrganizationRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.SwitchOrganizationRequest");
    res.setName("SwitchOrganizationRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(488);
    res.setProtoColumn(1);
    res.setProtoEntity("SwitchOrganizationRequest");
    res.setDescription("切换组织请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SwitchOrganizationRequest");
            res.setDescription("切换组织请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _organizationId = new ComponentItem();
    _organizationId.setClzName("java.lang.Long");
    _organizationId.setName("organization_id");
    _organizationId.setFieldName("organizationId");
    _organizationId.setTag(1);
    _organizationId.setProtoLine(496);
    _organizationId.setProtoColumn(3);
    _organizationId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("目标组织 ID");
        res.setExample("2");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_organizationId);
    components.put("com.apihug.rad.api.customer.SwitchOrganizationRequest", res);
  }

  void initComponentapi_customerUpdateCustomerRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.customer.UpdateCustomerRequest");
    res.setName("UpdateCustomerRequest");
    res.setProtoFrom("com/apihug/rad/api/customer/api.proto");
    res.setProtoLine(645);
    res.setProtoColumn(1);
    res.setProtoEntity("UpdateCustomerRequest");
    res.setDescription("更新客户请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UpdateCustomerRequest");
            res.setDescription("更新客户请求");
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
    _email.setProtoLine(653);
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
    _status.setTag(2);
    _status.setProtoLine(661);
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
    components.put("com.apihug.rad.api.customer.UpdateCustomerRequest", res);
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
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(1);
    _parentId.setProtoLine(122);
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
    _deptCode.setTag(2);
    _deptCode.setProtoLine(128);
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
    _deptName.setTag(3);
    _deptName.setProtoLine(136);
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
    _sortOrder.setTag(4);
    _sortOrder.setProtoLine(144);
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
    _managerId.setTag(5);
    _managerId.setProtoLine(149);
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
    _status.setTag(6);
    _status.setProtoLine(155);
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
    res.setProtoLine(238);
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
    _id.setProtoLine(246);
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
    _parentId.setProtoLine(253);
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
    _deptCode.setProtoLine(259);
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
    _deptName.setProtoLine(266);
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
    _sortOrder.setProtoLine(273);
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
    _managerId.setProtoLine(278);
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
    _status.setProtoLine(284);
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
    _createdAt.setProtoLine(290);
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
    res.setProtoLine(196);
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
    _id.setProtoLine(204);
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
    _parentId.setProtoLine(211);
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
    _deptCode.setProtoLine(217);
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
    _deptName.setProtoLine(224);
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
    _status.setProtoLine(231);
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
    res.setProtoLine(297);
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
    _department.setProtoLine(305);
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
    _children.setProtoLine(309);
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
    res.setProtoLine(162);
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
    _deptName.setProtoLine(170);
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
    _sortOrder.setProtoLine(178);
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
    _managerId.setProtoLine(183);
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
    _status.setProtoLine(189);
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

  void initComponentapi_departmentAddEmployeeRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.AddEmployeeRequest");
    res.setName("AddEmployeeRequest");
    res.setProtoFrom("com/apihug/rad/api/department/employee.proto");
    res.setProtoLine(91);
    res.setProtoColumn(1);
    res.setProtoEntity("AddEmployeeRequest");
    res.setDescription("添加员工请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AddEmployeeRequest");
            res.setDescription("添加员工请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _employeeId = new ComponentItem();
    _employeeId.setClzName("java.lang.Long");
    _employeeId.setName("employee_id");
    _employeeId.setFieldName("employeeId");
    _employeeId.setTag(1);
    _employeeId.setProtoLine(99);
    _employeeId.setProtoColumn(3);
    _employeeId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_employeeId);
    ComponentItem _departmentId = new ComponentItem();
    _departmentId.setClzName("java.lang.Long");
    _departmentId.setName("department_id");
    _departmentId.setFieldName("departmentId");
    _departmentId.setTag(2);
    _departmentId.setProtoLine(106);
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
    _position.setTag(3);
    _position.setProtoLine(113);
    _position.setProtoColumn(3);
    _position.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("职位");
        res.setExample("高级工程师");
        res.setMaxLength(100l);
        return res;
      }
    }.get());
    res.addItem(_position);
    components.put("com.apihug.rad.api.department.AddEmployeeRequest", res);
  }

  void initComponentapi_departmentDepartmentEmployeeList() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.DepartmentEmployeeList");
    res.setName("DepartmentEmployeeList");
    res.setProtoFrom("com/apihug/rad/api/department/employee.proto");
    res.setProtoLine(172);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentEmployeeList");
    res.setDescription("部门员工列表");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("DepartmentEmployeeList");
            res.setDescription("部门员工列表");
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
    _departmentId.setProtoLine(180);
    _departmentId.setProtoColumn(3);
    _departmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_departmentId);
    ComponentItem _employees = new ComponentItem();
    _employees.setClzName("com.apihug.rad.api.department.EmployeeInfo");
    _employees.setName("employees");
    _employees.setFieldName("employees");
    _employees.setTag(2);
    _employees.setProtoLine(186);
    _employees.setProtoColumn(3);
    _employees.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工列表");
        return res;
      }
    }.get());
    _employees.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_employees);
    components.put("com.apihug.rad.api.department.DepartmentEmployeeList", res);
  }

  void initComponentapi_departmentEmployeeInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.EmployeeInfo");
    res.setName("EmployeeInfo");
    res.setProtoFrom("com/apihug/rad/api/department/employee.proto");
    res.setProtoLine(191);
    res.setProtoColumn(1);
    res.setProtoEntity("EmployeeInfo");
    res.setDescription("员工信息");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("EmployeeInfo");
            res.setDescription("员工信息");
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
    _id.setProtoLine(199);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工 ID");
        res.setExample("1");
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
    _username.setProtoLine(205);
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
    ComponentItem _realName = new ComponentItem();
    _realName.setClzName("java.lang.String");
    _realName.setName("real_name");
    _realName.setFieldName("realName");
    _realName.setTag(3);
    _realName.setProtoLine(212);
    _realName.setProtoColumn(3);
    _realName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("真实姓名");
        res.setExample("张三");
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
    res.addItem(_realName);
    ComponentItem _email = new ComponentItem();
    _email.setClzName("java.lang.String");
    _email.setName("email");
    _email.setFieldName("email");
    _email.setTag(4);
    _email.setProtoLine(219);
    _email.setProtoColumn(3);
    _email.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("邮箱");
        res.setExample("zhangsan@example.com");
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
    ComponentItem _position = new ComponentItem();
    _position.setClzName("java.lang.String");
    _position.setName("position");
    _position.setFieldName("position");
    _position.setTag(5);
    _position.setProtoLine(225);
    _position.setProtoColumn(3);
    _position.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("职位");
        res.setExample("高级工程师");
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
    res.addItem(_position);
    ComponentItem _joinedAt = new ComponentItem();
    _joinedAt.setClzName("java.time.LocalDateTime");
    _joinedAt.setName("joined_at");
    _joinedAt.setFieldName("joinedAt");
    _joinedAt.setTag(6);
    _joinedAt.setProtoLine(231);
    _joinedAt.setProtoColumn(3);
    _joinedAt.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("加入部门时间");
        res.setExample("2024-01-15T10:30:00");
        res.setDateFormat(DateFormat.ISO_LOCAL_DATE_TIME);
        return res;
      }
    }.get());
    res.addItem(_joinedAt);
    components.put("com.apihug.rad.api.department.EmployeeInfo", res);
  }

  void initComponentapi_departmentRemoveEmployeeRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.RemoveEmployeeRequest");
    res.setName("RemoveEmployeeRequest");
    res.setProtoFrom("com/apihug/rad/api/department/employee.proto");
    res.setProtoLine(120);
    res.setProtoColumn(1);
    res.setProtoEntity("RemoveEmployeeRequest");
    res.setDescription("移除员工请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RemoveEmployeeRequest");
            res.setDescription("移除员工请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _employeeId = new ComponentItem();
    _employeeId.setClzName("java.lang.Long");
    _employeeId.setName("employee_id");
    _employeeId.setFieldName("employeeId");
    _employeeId.setTag(1);
    _employeeId.setProtoLine(128);
    _employeeId.setProtoColumn(3);
    _employeeId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_employeeId);
    components.put("com.apihug.rad.api.department.RemoveEmployeeRequest", res);
  }

  void initComponentapi_departmentTransferEmployeeRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.department.TransferEmployeeRequest");
    res.setName("TransferEmployeeRequest");
    res.setProtoFrom("com/apihug/rad/api/department/employee.proto");
    res.setProtoLine(136);
    res.setProtoColumn(1);
    res.setProtoEntity("TransferEmployeeRequest");
    res.setDescription("员工调岗请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("TransferEmployeeRequest");
            res.setDescription("员工调岗请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _employeeId = new ComponentItem();
    _employeeId.setClzName("java.lang.Long");
    _employeeId.setName("employee_id");
    _employeeId.setFieldName("employeeId");
    _employeeId.setTag(1);
    _employeeId.setProtoLine(144);
    _employeeId.setProtoColumn(3);
    _employeeId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_employeeId);
    ComponentItem _fromDepartmentId = new ComponentItem();
    _fromDepartmentId.setClzName("java.lang.Long");
    _fromDepartmentId.setName("from_department_id");
    _fromDepartmentId.setFieldName("fromDepartmentId");
    _fromDepartmentId.setTag(2);
    _fromDepartmentId.setProtoLine(151);
    _fromDepartmentId.setProtoColumn(3);
    _fromDepartmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("原部门 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_fromDepartmentId);
    ComponentItem _toDepartmentId = new ComponentItem();
    _toDepartmentId.setClzName("java.lang.Long");
    _toDepartmentId.setName("to_department_id");
    _toDepartmentId.setFieldName("toDepartmentId");
    _toDepartmentId.setTag(3);
    _toDepartmentId.setProtoLine(158);
    _toDepartmentId.setProtoColumn(3);
    _toDepartmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("目标部门 ID");
        res.setExample("2");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_toDepartmentId);
    ComponentItem _position = new ComponentItem();
    _position.setClzName("java.lang.String");
    _position.setName("position");
    _position.setFieldName("position");
    _position.setTag(4);
    _position.setProtoLine(165);
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
    components.put("com.apihug.rad.api.department.TransferEmployeeRequest", res);
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

  void initComponentapi_organizationDepartmentInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.DepartmentInfo");
    res.setName("DepartmentInfo");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(225);
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
    _id.setProtoLine(233);
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
    _deptCode.setProtoLine(239);
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
    _deptName.setProtoLine(246);
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
    ComponentItem _isPrimary = new ComponentItem();
    _isPrimary.setClzName("java.lang.Boolean");
    _isPrimary.setName("is_primary");
    _isPrimary.setFieldName("isPrimary");
    _isPrimary.setTag(4);
    _isPrimary.setProtoLine(253);
    _isPrimary.setProtoColumn(3);
    _isPrimary.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否主部门");
        res.setExample("true");
        return res;
      }
    }.get());
    res.addItem(_isPrimary);
    components.put("com.apihug.rad.api.organization.DepartmentInfo", res);
  }

  void initComponentapi_organizationDepartmentSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.DepartmentSummary");
    res.setName("DepartmentSummary");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(163);
    res.setProtoColumn(1);
    res.setProtoEntity("DepartmentSummary");
    res.setDescription("部门摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("DepartmentSummary");
            res.setDescription("部门摘要");
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
    _id.setProtoLine(171);
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
    _deptCode.setProtoLine(177);
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
    _deptName.setProtoLine(184);
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
    _parentId.setProtoLine(191);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父部门 ID");
        res.setExample("0");
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _sortOrder = new ComponentItem();
    _sortOrder.setClzName("java.lang.Integer");
    _sortOrder.setName("sort_order");
    _sortOrder.setFieldName("sortOrder");
    _sortOrder.setTag(5);
    _sortOrder.setProtoLine(196);
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
    ComponentItem _status = new ComponentItem();
    _status.setClzName("java.lang.String");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(6);
    _status.setProtoLine(201);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("部门状态");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.organization.DepartmentSummary", res);
  }

  void initComponentapi_organizationDepartmentTreeNode() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.DepartmentTreeNode");
    res.setName("DepartmentTreeNode");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(146);
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
    _department.setClzName("com.apihug.rad.api.organization.DepartmentSummary");
    _department.setName("department");
    _department.setFieldName("department");
    _department.setTag(1);
    _department.setProtoLine(154);
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
    _children.setClzName("com.apihug.rad.api.organization.DepartmentTreeNode");
    _children.setName("children");
    _children.setFieldName("children");
    _children.setTag(2);
    _children.setProtoLine(158);
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
    components.put("com.apihug.rad.api.organization.DepartmentTreeNode", res);
  }

  void initComponentapi_organizationOrganizationSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.OrganizationSummary");
    res.setName("OrganizationSummary");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(107);
    res.setProtoColumn(1);
    res.setProtoEntity("OrganizationSummary");
    res.setDescription("组织摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("OrganizationSummary");
            res.setDescription("组织摘要");
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
    _id.setProtoLine(115);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _organizationCode = new ComponentItem();
    _organizationCode.setClzName("java.lang.String");
    _organizationCode.setName("organization_code");
    _organizationCode.setFieldName("organizationCode");
    _organizationCode.setTag(2);
    _organizationCode.setProtoLine(121);
    _organizationCode.setProtoColumn(3);
    _organizationCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织代码");
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
    res.addItem(_organizationCode);
    ComponentItem _organizationName = new ComponentItem();
    _organizationName.setClzName("java.lang.String");
    _organizationName.setName("organization_name");
    _organizationName.setFieldName("organizationName");
    _organizationName.setTag(3);
    _organizationName.setProtoLine(128);
    _organizationName.setProtoColumn(3);
    _organizationName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织名称");
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
    res.addItem(_organizationName);
    ComponentItem _parentId = new ComponentItem();
    _parentId.setClzName("java.lang.Long");
    _parentId.setName("parent_id");
    _parentId.setFieldName("parentId");
    _parentId.setTag(4);
    _parentId.setProtoLine(135);
    _parentId.setProtoColumn(3);
    _parentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("父组织 ID");
        res.setExample("0");
        return res;
      }
    }.get());
    res.addItem(_parentId);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("java.lang.String");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(5);
    _status.setProtoLine(140);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织状态");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.organization.OrganizationSummary", res);
  }

  void initComponentapi_organizationOrganizationTreeNode() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.OrganizationTreeNode");
    res.setName("OrganizationTreeNode");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(90);
    res.setProtoColumn(1);
    res.setProtoEntity("OrganizationTreeNode");
    res.setDescription("组织树节点");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("OrganizationTreeNode");
            res.setDescription("组织树节点");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _organization = new ComponentItem();
    _organization.setClzName("com.apihug.rad.api.organization.OrganizationSummary");
    _organization.setName("organization");
    _organization.setFieldName("organization");
    _organization.setTag(1);
    _organization.setProtoLine(98);
    _organization.setProtoColumn(3);
    _organization.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织信息");
        return res;
      }
    }.get());
    res.addItem(_organization);
    ComponentItem _children = new ComponentItem();
    _children.setClzName("com.apihug.rad.api.organization.OrganizationTreeNode");
    _children.setName("children");
    _children.setFieldName("children");
    _children.setTag(2);
    _children.setProtoLine(102);
    _children.setProtoColumn(3);
    _children.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("子组织列表");
        return res;
      }
    }.get());
    _children.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_children);
    components.put("com.apihug.rad.api.organization.OrganizationTreeNode", res);
  }

  void initComponentapi_organizationSetDefaultOrganizationRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.SetDefaultOrganizationRequest");
    res.setName("SetDefaultOrganizationRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(260);
    res.setProtoColumn(1);
    res.setProtoEntity("SetDefaultOrganizationRequest");
    res.setDescription("设置默认组织请求\n"
            + "设置默认组织请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("SetDefaultOrganizationRequest");
            res.setDescription("设置默认组织请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    components.put("com.apihug.rad.api.organization.SetDefaultOrganizationRequest", res);
  }

  void initComponentapi_organizationUserDepartmentList() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.UserDepartmentList");
    res.setName("UserDepartmentList");
    res.setProtoFrom("com/apihug/rad/api/organization/api.proto");
    res.setProtoLine(207);
    res.setProtoColumn(1);
    res.setProtoEntity("UserDepartmentList");
    res.setDescription("用户部门列表");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("UserDepartmentList");
            res.setDescription("用户部门列表");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _departments = new ComponentItem();
    _departments.setClzName("com.apihug.rad.api.organization.DepartmentInfo");
    _departments.setName("departments");
    _departments.setFieldName("departments");
    _departments.setTag(1);
    _departments.setProtoLine(215);
    _departments.setProtoColumn(3);
    _departments.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("用户所属部门列表");
        return res;
      }
    }.get());
    _departments.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_departments);
    ComponentItem _primaryDepartmentId = new ComponentItem();
    _primaryDepartmentId.setClzName("java.lang.Long");
    _primaryDepartmentId.setName("primary_department_id");
    _primaryDepartmentId.setFieldName("primaryDepartmentId");
    _primaryDepartmentId.setTag(2);
    _primaryDepartmentId.setProtoLine(219);
    _primaryDepartmentId.setProtoColumn(3);
    _primaryDepartmentId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("主部门 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_primaryDepartmentId);
    components.put("com.apihug.rad.api.organization.UserDepartmentList", res);
  }

  void initComponentapi_organizationAddMemberRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.AddMemberRequest");
    res.setName("AddMemberRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(217);
    res.setProtoColumn(1);
    res.setProtoEntity("AddMemberRequest");
    res.setDescription("添加员工到组织请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AddMemberRequest");
            res.setDescription("添加员工到组织请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _customerId = new ComponentItem();
    _customerId.setClzName("java.lang.Integer");
    _customerId.setName("customer_id");
    _customerId.setFieldName("customerId");
    _customerId.setTag(1);
    _customerId.setProtoLine(225);
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
    _departmentId.setProtoLine(232);
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
    _position.setProtoLine(237);
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
    ComponentItem _employeeType = new ComponentItem();
    _employeeType.setClzName("com.apihug.rad.infra.organization.EmployeeTypeEnum");
    _employeeType.setName("employee_type");
    _employeeType.setFieldName("employeeType");
    _employeeType.setTag(4);
    _employeeType.setProtoLine(243);
    _employeeType.setProtoColumn(3);
    _employeeType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工类型");
        res.setExample("FULL_TIME");
        return res;
      }
    }.get());
    res.addItem(_employeeType);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(5);
    _isDefault.setProtoLine(248);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否默认组织");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    components.put("com.apihug.rad.api.organization.AddMemberRequest", res);
  }

  void initComponentapi_organizationAssignMemberMenusRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.AssignMemberMenusRequest");
    res.setName("AssignMemberMenusRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(287);
    res.setProtoColumn(1);
    res.setProtoEntity("AssignMemberMenusRequest");
    res.setDescription("分配员工菜单请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AssignMemberMenusRequest");
            res.setDescription("分配员工菜单请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _menuIds = new ComponentItem();
    _menuIds.setClzName("java.lang.Integer");
    _menuIds.setName("menu_ids");
    _menuIds.setFieldName("menuIds");
    _menuIds.setTag(1);
    _menuIds.setProtoLine(295);
    _menuIds.setProtoColumn(3);
    _menuIds.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("菜单 ID 列表");
        return res;
      }
    }.get());
    _menuIds.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_menuIds);
    components.put("com.apihug.rad.api.organization.AssignMemberMenusRequest", res);
  }

  void initComponentapi_organizationAssignMemberRolesRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.AssignMemberRolesRequest");
    res.setName("AssignMemberRolesRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(274);
    res.setProtoColumn(1);
    res.setProtoEntity("AssignMemberRolesRequest");
    res.setDescription("分配员工角色请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AssignMemberRolesRequest");
            res.setDescription("分配员工角色请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _roleIds = new ComponentItem();
    _roleIds.setClzName("java.lang.Integer");
    _roleIds.setName("role_ids");
    _roleIds.setFieldName("roleIds");
    _roleIds.setTag(1);
    _roleIds.setProtoLine(282);
    _roleIds.setProtoColumn(3);
    _roleIds.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("角色 ID 列表");
        return res;
      }
    }.get());
    _roleIds.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_roleIds);
    components.put("com.apihug.rad.api.organization.AssignMemberRolesRequest", res);
  }

  void initComponentapi_organizationCustomerOrganizationSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.CustomerOrganizationSummary");
    res.setName("CustomerOrganizationSummary");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(300);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerOrganizationSummary");
    res.setDescription("组织员工摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("CustomerOrganizationSummary");
            res.setDescription("组织员工摘要");
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
    _id.setProtoLine(308);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("ID");
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
    _customerId.setProtoLine(313);
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
    _customerUsername.setProtoLine(318);
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
    _customerEmail.setProtoLine(323);
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
    ComponentItem _organizationId = new ComponentItem();
    _organizationId.setClzName("java.lang.Long");
    _organizationId.setName("organization_id");
    _organizationId.setFieldName("organizationId");
    _organizationId.setTag(5);
    _organizationId.setProtoLine(328);
    _organizationId.setProtoColumn(3);
    _organizationId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织 ID");
        res.setExample("1");
        return res;
      }
    }.get());
    res.addItem(_organizationId);
    ComponentItem _organizationName = new ComponentItem();
    _organizationName.setClzName("java.lang.String");
    _organizationName.setName("organization_name");
    _organizationName.setFieldName("organizationName");
    _organizationName.setTag(6);
    _organizationName.setProtoLine(333);
    _organizationName.setProtoColumn(3);
    _organizationName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("组织名称");
        res.setExample("Acme 公司");
        return res;
      }
    }.get());
    res.addItem(_organizationName);
    ComponentItem _departmentId = new ComponentItem();
    _departmentId.setClzName("java.lang.Long");
    _departmentId.setName("department_id");
    _departmentId.setFieldName("departmentId");
    _departmentId.setTag(7);
    _departmentId.setProtoLine(338);
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
    _position.setProtoLine(343);
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
    ComponentItem _employeeType = new ComponentItem();
    _employeeType.setClzName("com.apihug.rad.infra.organization.EmployeeTypeEnum");
    _employeeType.setName("employee_type");
    _employeeType.setFieldName("employeeType");
    _employeeType.setTag(9);
    _employeeType.setProtoLine(348);
    _employeeType.setProtoColumn(3);
    _employeeType.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工类型");
        res.setExample("FULL_TIME");
        return res;
      }
    }.get());
    res.addItem(_employeeType);
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.organization.CustomerOrgStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(10);
    _status.setProtoLine(353);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("状态");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    ComponentItem _isDefault = new ComponentItem();
    _isDefault.setClzName("java.lang.Boolean");
    _isDefault.setName("is_default");
    _isDefault.setFieldName("isDefault");
    _isDefault.setTag(11);
    _isDefault.setProtoLine(358);
    _isDefault.setProtoColumn(3);
    _isDefault.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("是否默认组织");
        res.setExample("false");
        return res;
      }
    }.get());
    res.addItem(_isDefault);
    components.put("com.apihug.rad.api.organization.CustomerOrganizationSummary", res);
  }

  void initComponentapi_organizationGetOrganizationMembersRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.GetOrganizationMembersRequest");
    res.setName("GetOrganizationMembersRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(203);
    res.setProtoColumn(1);
    res.setProtoEntity("GetOrganizationMembersRequest");
    res.setDescription("============ 消息类型定义 ============\n"
            + "获取组织员工列表请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("GetOrganizationMembersRequest");
            res.setDescription("获取组织员工列表请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _status = new ComponentItem();
    _status.setClzName("com.apihug.rad.infra.organization.CustomerOrgStatusEnum");
    _status.setName("status");
    _status.setFieldName("status");
    _status.setTag(1);
    _status.setProtoLine(211);
    _status.setProtoColumn(3);
    _status.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("员工状态筛选");
        res.setExample("ACTIVE");
        return res;
      }
    }.get());
    res.addItem(_status);
    components.put("com.apihug.rad.api.organization.GetOrganizationMembersRequest", res);
  }

  void initComponentapi_organizationRemoveMemberRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.RemoveMemberRequest");
    res.setName("RemoveMemberRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(254);
    res.setProtoColumn(1);
    res.setProtoEntity("RemoveMemberRequest");
    res.setDescription("从组织移除员工请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RemoveMemberRequest");
            res.setDescription("从组织移除员工请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    components.put("com.apihug.rad.api.organization.RemoveMemberRequest", res);
  }

  void initComponentapi_organizationToggleMemberLockRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.organization.ToggleMemberLockRequest");
    res.setName("ToggleMemberLockRequest");
    res.setProtoFrom("com/apihug/rad/api/organization/customer_org.proto");
    res.setProtoLine(264);
    res.setProtoColumn(1);
    res.setProtoEntity("ToggleMemberLockRequest");
    res.setDescription("锁定/解锁员工请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("ToggleMemberLockRequest");
            res.setDescription("锁定/解锁员工请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    components.put("com.apihug.rad.api.organization.ToggleMemberLockRequest", res);
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
        res.setExample("user:create");
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
        res.setExample("创建用户");
        return res;
      }
    }.get());
    res.addItem(_permissionName);
    components.put("com.apihug.rad.api.permission.PermissionInfo", res);
  }

  void initComponentapi_roleAssignPermissionsRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.AssignPermissionsRequest");
    res.setName("AssignPermissionsRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(406);
    res.setProtoColumn(1);
    res.setProtoEntity("AssignPermissionsRequest");
    res.setDescription("分配权限请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("AssignPermissionsRequest");
            res.setDescription("分配权限请求");
            return res;
          }
        }.get());
        return res;
      }
    }.get());
    ComponentItem _permissionIds = new ComponentItem();
    _permissionIds.setClzName("java.lang.Long");
    _permissionIds.setName("permission_ids");
    _permissionIds.setFieldName("permissionIds");
    _permissionIds.setTag(1);
    _permissionIds.setProtoLine(414);
    _permissionIds.setProtoColumn(3);
    _permissionIds.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限 ID 列表");
        res.setExample("[1, 2, 3]");
        res.setEmpty(false);
        return res;
      }
    }.get());
    _permissionIds.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_permissionIds);
    components.put("com.apihug.rad.api.role.AssignPermissionsRequest", res);
  }

  void initComponentapi_roleCreateRoleRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.CreateRoleRequest");
    res.setName("CreateRoleRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(229);
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
    _roleCode.setProtoLine(237);
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
    _roleName.setProtoLine(245);
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
    _description.setProtoLine(253);
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
    _status.setProtoLine(260);
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

  void initComponentapi_rolePermissionInfo() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.PermissionInfo");
    res.setName("PermissionInfo");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(463);
    res.setProtoColumn(1);
    res.setProtoEntity("PermissionInfo");
    res.setDescription("权限信息");
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
    ComponentItem _id = new ComponentItem();
    _id.setClzName("java.lang.Long");
    _id.setName("id");
    _id.setFieldName("id");
    _id.setTag(1);
    _id.setProtoLine(471);
    _id.setProtoColumn(3);
    _id.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限 ID");
        res.setExample("1");
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_id);
    ComponentItem _permissionCode = new ComponentItem();
    _permissionCode.setClzName("java.lang.String");
    _permissionCode.setName("permission_code");
    _permissionCode.setFieldName("permissionCode");
    _permissionCode.setTag(2);
    _permissionCode.setProtoLine(477);
    _permissionCode.setProtoColumn(3);
    _permissionCode.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限代码");
        res.setExample("user:create");
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
    res.addItem(_permissionCode);
    ComponentItem _permissionName = new ComponentItem();
    _permissionName.setClzName("java.lang.String");
    _permissionName.setName("permission_name");
    _permissionName.setFieldName("permissionName");
    _permissionName.setTag(3);
    _permissionName.setProtoLine(484);
    _permissionName.setProtoColumn(3);
    _permissionName.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限名称");
        res.setExample("创建用户");
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
    res.addItem(_permissionName);
    components.put("com.apihug.rad.api.role.PermissionInfo", res);
  }

  void initComponentapi_roleRemovePermissionRequest() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RemovePermissionRequest");
    res.setName("RemovePermissionRequest");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(421);
    res.setProtoColumn(1);
    res.setProtoEntity("RemovePermissionRequest");
    res.setDescription("移除权限请求");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RemovePermissionRequest");
            res.setDescription("移除权限请求");
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
    _roleId.setProtoLine(429);
    _roleId.setProtoColumn(3);
    _roleId.setSchema(new Supplier<JSONSchema>() {
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
    res.addItem(_roleId);
    ComponentItem _permissionId = new ComponentItem();
    _permissionId.setClzName("java.lang.Long");
    _permissionId.setName("permission_id");
    _permissionId.setFieldName("permissionId");
    _permissionId.setTag(2);
    _permissionId.setProtoLine(436);
    _permissionId.setProtoColumn(3);
    _permissionId.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限 ID");
        res.setExample("1");
        res.setMinimum(1.0D);
        res.setEmpty(false);
        return res;
      }
    }.get());
    res.addItem(_permissionId);
    components.put("com.apihug.rad.api.role.RemovePermissionRequest", res);
  }

  void initComponentapi_roleRoleDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RoleDetail");
    res.setName("RoleDetail");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(333);
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
    _id.setProtoLine(341);
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
    _roleCode.setProtoLine(348);
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
    _roleName.setProtoLine(355);
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
    _description.setProtoLine(362);
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
    _status.setProtoLine(368);
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
    _createdAt.setProtoLine(374);
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
    _updatedAt.setProtoLine(380);
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

  void initComponentapi_roleRolePermissionSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RolePermissionSummary");
    res.setName("RolePermissionSummary");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(444);
    res.setProtoColumn(1);
    res.setProtoEntity("RolePermissionSummary");
    res.setDescription("角色权限摘要");
    res.setSchema(new Supplier<Schema>() {
      @Override
      public Schema get() {
        Schema res  = new Schema();
        res.setJsonSchema(new Supplier<JSONSchema>() {
          @Override
          public JSONSchema get() {
            JSONSchema res  = new JSONSchema();
            res.setTitle("RolePermissionSummary");
            res.setDescription("角色权限摘要");
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
    _roleId.setProtoLine(452);
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
    ComponentItem _permissions = new ComponentItem();
    _permissions.setClzName("com.apihug.rad.api.role.PermissionInfo");
    _permissions.setName("permissions");
    _permissions.setFieldName("permissions");
    _permissions.setTag(2);
    _permissions.setProtoLine(458);
    _permissions.setProtoColumn(3);
    _permissions.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("权限列表");
        return res;
      }
    }.get());
    _permissions.setComplex(ComponentItem.Complex.LIST);
    res.addItem(_permissions);
    components.put("com.apihug.rad.api.role.RolePermissionSummary", res);
  }

  void initComponentapi_roleRoleSummary() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.role.RoleSummary");
    res.setName("RoleSummary");
    res.setProtoFrom("com/apihug/rad/api/role/api.proto");
    res.setProtoLine(297);
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
    _id.setProtoLine(305);
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
    _roleCode.setProtoLine(312);
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
    _roleName.setProtoLine(319);
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
    _status.setProtoLine(326);
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
    res.setProtoLine(387);
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
    _keyword.setProtoLine(395);
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
    _status.setProtoLine(400);
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
    res.setProtoLine(267);
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
    _roleName.setProtoLine(275);
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
    _description.setProtoLine(283);
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
    _status.setProtoLine(290);
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
    res.setProtoLine(210);
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
    ComponentItem _maxUsers = new ComponentItem();
    _maxUsers.setClzName("java.lang.Integer");
    _maxUsers.setName("max_users");
    _maxUsers.setFieldName("maxUsers");
    _maxUsers.setTag(1);
    _maxUsers.setProtoLine(218);
    _maxUsers.setProtoColumn(3);
    _maxUsers.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("最大用户数");
        res.setExample("100");
        res.setMinimum(1.0D);
        return res;
      }
    }.get());
    res.addItem(_maxUsers);
    ComponentItem _maxStorageMb = new ComponentItem();
    _maxStorageMb.setClzName("java.lang.Long");
    _maxStorageMb.setName("max_storage_mb");
    _maxStorageMb.setFieldName("maxStorageMb");
    _maxStorageMb.setTag(2);
    _maxStorageMb.setProtoLine(224);
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
    _enabledModules.setProtoLine(230);
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
    _expiryDate.setProtoLine(235);
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
    res.setProtoLine(126);
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
    _tenantCode.setProtoLine(134);
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
    _tenantName.setProtoLine(142);
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
    _contactEmail.setProtoLine(150);
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
    _contactPhone.setProtoLine(158);
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
    _status.setProtoLine(165);
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
    components.put("com.apihug.rad.api.tenant.CreateTenantRequest", res);
  }

  void initComponentapi_tenantTenantDetail() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.api.tenant.TenantDetail");
    res.setName("TenantDetail");
    res.setProtoFrom("com/apihug/rad/api/tenant/api.proto");
    res.setProtoLine(278);
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
    _id.setProtoLine(286);
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
    _tenantCode.setProtoLine(293);
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
    _tenantName.setProtoLine(300);
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
    _contactEmail.setProtoLine(307);
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
    _contactPhone.setProtoLine(313);
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
    _status.setProtoLine(319);
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
    ComponentItem _maxUsers = new ComponentItem();
    _maxUsers.setClzName("java.lang.Integer");
    _maxUsers.setName("max_users");
    _maxUsers.setFieldName("maxUsers");
    _maxUsers.setTag(7);
    _maxUsers.setProtoLine(325);
    _maxUsers.setProtoColumn(3);
    _maxUsers.setSchema(new Supplier<JSONSchema>() {
      @Override
      public JSONSchema get() {
        JSONSchema res  = new JSONSchema();
        res.setDescription("最大用户数");
        res.setExample("100");
        return res;
      }
    }.get());
    res.addItem(_maxUsers);
    ComponentItem _maxStorageMb = new ComponentItem();
    _maxStorageMb.setClzName("java.lang.Long");
    _maxStorageMb.setName("max_storage_mb");
    _maxStorageMb.setFieldName("maxStorageMb");
    _maxStorageMb.setTag(8);
    _maxStorageMb.setProtoLine(330);
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
    ComponentItem _createdAt = new ComponentItem();
    _createdAt.setClzName("java.time.LocalDateTime");
    _createdAt.setName("created_at");
    _createdAt.setFieldName("createdAt");
    _createdAt.setTag(9);
    _createdAt.setProtoLine(335);
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
    res.setProtoLine(242);
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
    _id.setProtoLine(250);
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
    _tenantCode.setProtoLine(257);
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
    _tenantName.setProtoLine(264);
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
    _status.setProtoLine(271);
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
    res.setProtoLine(172);
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
    _tenantName.setProtoLine(180);
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
    _contactEmail.setProtoLine(188);
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
    _contactPhone.setProtoLine(196);
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
    _status.setProtoLine(203);
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

  void initComponentinfra_authAuthErrorEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.auth.AuthErrorEnum");
    res.setName("AuthErrorEnum");
    res.setProtoFrom("com/apihug/rad/infra/auth/constant.proto");
    res.setProtoLine(38);
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
        res.setTitle("ORGANIZATION_NOT_FOUND");
        res.setCode(10006003);
        res.setMessage("Organization not found");
        res.setMessage2("组织不存在");
        var error  = new Error();
        error.setSeverity(Error.Severity.FATAL);
        error.setPhase(Error.Phase.SERVICE);
        error.setTips("Check if the organization ID is correct");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("NO_ORGANIZATION_ACCESS");
        res.setCode(10006004);
        res.setMessage("No access to this organization");
        res.setMessage2("无权访问该组织");
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

  void initComponentinfra_authUserStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.auth.UserStatusEnum");
    res.setName("UserStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/auth/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("UserStatusEnum");
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
        res.setMessage2("未激活");
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
    components.put("com.apihug.rad.infra.auth.UserStatusEnum", res);
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
        error.setTips("Contract your admin or create a new customer");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_LOCK");
        res.setCode(10001024);
        res.setMessage("Customer not active");
        res.setMessage2("账户锁定");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Contract your admin");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("CUSTOMER_LOGIN_FAIL");
        res.setCode(10001025);
        res.setMessage("Login fail");
        res.setMessage2("登录失败");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Contract your admin, check your username and password");
        res.setError(error);
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("USER_ALREADY_EXISTS");
        res.setCode(10001026);
        res.setMessage("User already exists");
        res.setMessage2("用户已存在");
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

  void initComponentinfra_organizationCustomerOrgStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.organization.CustomerOrgStatusEnum");
    res.setName("CustomerOrgStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/organization/constant.proto");
    res.setProtoLine(62);
    res.setProtoColumn(1);
    res.setProtoEntity("CustomerOrgStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ACTIVE");
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
        res.setTitle("INACTIVE");
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
        res.setTitle("LOCKED");
        res.setCode(3);
        res.setMessage("locked");
        res.setMessage2("已锁定");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.organization.CustomerOrgStatusEnum", res);
  }

  void initComponentinfra_organizationEmployeeTypeEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.organization.EmployeeTypeEnum");
    res.setName("EmployeeTypeEnum");
    res.setProtoFrom("com/apihug/rad/infra/organization/constant.proto");
    res.setProtoLine(32);
    res.setProtoColumn(1);
    res.setProtoEntity("EmployeeTypeEnum");
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
    components.put("com.apihug.rad.infra.organization.EmployeeTypeEnum", res);
  }

  void initComponentinfra_organizationOrganizationStatusEnum() {
    Component res = new Component();
    res.setClzName("com.apihug.rad.infra.organization.OrganizationStatusEnum");
    res.setName("OrganizationStatusEnum");
    res.setProtoFrom("com/apihug/rad/infra/organization/constant.proto");
    res.setProtoLine(8);
    res.setProtoColumn(1);
    res.setProtoEntity("OrganizationStatusEnum");
    res.setEnumClz(true);
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORG_ACTIVE");
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
        res.setTitle("ORG_INACTIVE");
        res.setCode(2);
        res.setMessage("inactive");
        res.setMessage2("未激活");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORG_DISABLED");
        res.setCode(3);
        res.setMessage("disabled");
        res.setMessage2("禁用");
        return res;
      }
    }.get());
    components.put("com.apihug.rad.infra.organization.OrganizationStatusEnum", res);
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
        res.setTitle("ORGANIZATION_MEMBER_VIEW");
        res.setCode(22);
        res.setMessage("organization:member:view");
        res.setMessage2("查看组织员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORGANIZATION_MEMBER_ADD");
        res.setCode(23);
        res.setMessage("organization:member:add");
        res.setMessage2("添加组织员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORGANIZATION_MEMBER_REMOVE");
        res.setCode(24);
        res.setMessage("organization:member:remove");
        res.setMessage2("移除组织员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORGANIZATION_MEMBER_LOCK");
        res.setCode(25);
        res.setMessage("organization:member:lock");
        res.setMessage2("锁定组织员工");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORGANIZATION_MEMBER_ASSIGN_ROLE");
        res.setCode(26);
        res.setMessage("organization:member:assign_role");
        res.setMessage2("分配员工角色");
        return res;
      }
    }.get());
    res.addMeta(new Supplier<Meta>() {
      @Override
      public Meta get() {
        Meta res  = new Meta();
        res.setTitle("ORGANIZATION_MEMBER_ASSIGN_MENU");
        res.setCode(27);
        res.setMessage("organization:member:assign_menu");
        res.setMessage2("分配员工菜单");
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
        res.setTitle("TENANT_HAS_USERS");
        res.setCode(10004003);
        res.setMessage("Tenant has users");
        res.setMessage2("租户下有用户，无法删除");
        var error  = new Error();
        error.setSeverity(Error.Severity.WARN);
        error.setPhase(Error.Phase.DOMAIN);
        error.setTips("Remove all users from this tenant first");
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

  private void initComponents() {
    initComponentapi_auditAccessLogInfo();
    initComponentapi_auditAccessLogStatsResponse();
    initComponentapi_auditGetAccessLogStatsRequest();
    initComponentapi_auditPathStats();
    initComponentapi_auditSearchAccessLogsRequest();
    initComponentapi_customerCreateCustomerRequest();
    initComponentapi_customerCurrentUserInfo();
    initComponentapi_customerCustomerDetail();
    initComponentapi_customerCustomerInfo();
    initComponentapi_customerCustomerSummary();
    initComponentapi_customerDepartmentInfo();
    initComponentapi_customerForgotPasswordRequest();
    initComponentapi_customerLoginRequest();
    initComponentapi_customerLoginResponse();
    initComponentapi_customerOrganizationInfo();
    initComponentapi_customerOrganizationList();
    initComponentapi_customerResetPasswordRequest();
    initComponentapi_customerRoleInfo();
    initComponentapi_customerSearchCustomersRequest();
    initComponentapi_customerSwitchOrganizationRequest();
    initComponentapi_customerUpdateCustomerRequest();
    initComponentapi_departmentCreateDepartmentRequest();
    initComponentapi_departmentDepartmentDetail();
    initComponentapi_departmentDepartmentSummary();
    initComponentapi_departmentDepartmentTreeNode();
    initComponentapi_departmentUpdateDepartmentRequest();
    initComponentapi_departmentAddEmployeeRequest();
    initComponentapi_departmentDepartmentEmployeeList();
    initComponentapi_departmentEmployeeInfo();
    initComponentapi_departmentRemoveEmployeeRequest();
    initComponentapi_departmentTransferEmployeeRequest();
    initComponentapi_menuCreateMenuRequest();
    initComponentapi_menuMenuDetail();
    initComponentapi_menuMenuSummary();
    initComponentapi_menuMenuTreeNode();
    initComponentapi_menuSearchMenusRequest();
    initComponentapi_menuUpdateMenuRequest();
    initComponentapi_organizationDepartmentInfo();
    initComponentapi_organizationDepartmentSummary();
    initComponentapi_organizationDepartmentTreeNode();
    initComponentapi_organizationOrganizationSummary();
    initComponentapi_organizationOrganizationTreeNode();
    initComponentapi_organizationSetDefaultOrganizationRequest();
    initComponentapi_organizationUserDepartmentList();
    initComponentapi_organizationAddMemberRequest();
    initComponentapi_organizationAssignMemberMenusRequest();
    initComponentapi_organizationAssignMemberRolesRequest();
    initComponentapi_organizationCustomerOrganizationSummary();
    initComponentapi_organizationGetOrganizationMembersRequest();
    initComponentapi_organizationRemoveMemberRequest();
    initComponentapi_organizationToggleMemberLockRequest();
    initComponentapi_permissionPermissionInfo();
    initComponentapi_roleAssignPermissionsRequest();
    initComponentapi_roleCreateRoleRequest();
    initComponentapi_rolePermissionInfo();
    initComponentapi_roleRemovePermissionRequest();
    initComponentapi_roleRoleDetail();
    initComponentapi_roleRolePermissionSummary();
    initComponentapi_roleRoleSummary();
    initComponentapi_roleSearchRolesRequest();
    initComponentapi_roleUpdateRoleRequest();
    initComponentapi_tenantConfigureTenantRequest();
    initComponentapi_tenantCreateTenantRequest();
    initComponentapi_tenantTenantDetail();
    initComponentapi_tenantTenantSummary();
    initComponentapi_tenantUpdateTenantRequest();
    initComponentinfra_authAuthErrorEnum();
    initComponentinfra_authUserStatusEnum();
    initComponentinfra_customerCustomerStatusEnum();
    initComponentinfra_customerCustomerErrorEnum();
    initComponentinfra_departmentDepartmentErrorEnum();
    initComponentinfra_departmentDeptStatusEnum();
    initComponentinfra_menuMenuStatusEnum();
    initComponentinfra_menuMenuTypeEnum();
    initComponentinfra_menuMenuErrorEnum();
    initComponentinfra_organizationCustomerOrgStatusEnum();
    initComponentinfra_organizationEmployeeTypeEnum();
    initComponentinfra_organizationOrganizationStatusEnum();
    initComponentinfra_roleRoleStatusEnum();
    initComponentinfra_roleRoleErrorEnum();
    initComponentinfra_settingsRadAuthorityEnum();
    initComponentinfra_tenantTenantErrorEnum();
    initComponentinfra_tenantTenantStatusEnum();
  }
}
