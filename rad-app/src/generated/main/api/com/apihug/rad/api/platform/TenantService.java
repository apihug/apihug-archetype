// @formatter:off
package com.apihug.rad.api.platform;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/platform/tenant.proto",
    entity = "TenantService",
    kind = Kind.RPC,
    line = 9,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface TenantService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM_MANAGER</li>
   * 	<li>Authorities: [TENANT_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/tenants/create}
   * 	<p>{@code 创建新租户}
   */
  default void createTenant(SimpleResultBuilder<TenantSummary> builder,
      CreateTenantRequest createTenantRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/tenants/get/{tenantId}}
   * 	<p>{@code 获取租户详情}
   */
  default void getTenant(SimpleResultBuilder<TenantDetail> builder, Long tenantId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM_MANAGER</li>
   * 	<li>Authorities: [TENANT_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/tenants/update/{tenantId}}
   * 	<p>{@code 更新租户信息}
   */
  default void updateTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      UpdateTenantRequest updateTenantRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [TENANT_DISABLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/tenants/{tenantId}/disable}
   * 	<p>{@code 停用租户}
   */
  default void disableTenant(SimpleResultBuilder<String> builder, Integer tenantId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [TENANT_CONFIGURE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/tenants/{tenantId}/configure}
   * 	<p>{@code 配置租户功能}
   */
  default void configureTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      ConfigureTenantRequest configureTenantRequest) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [TENANT_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/tenants/search}
   * 	<p>{@code 搜索租户（分页）}
   */
  default void searchTenants(PageableResultBuilder<TenantSummary> builder,
      SearchTenantsRequest searchTenantsRequest, PageRequest pageParameter) {
    builder.notImplemented();
  }
}
