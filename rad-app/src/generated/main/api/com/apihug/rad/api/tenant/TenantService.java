// @formatter:off
package com.apihug.rad.api.tenant;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/tenant/api.proto",
    entity = "TenantService",
    kind = Kind.RPC,
    line = 11,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface TenantService {
  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_CREATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants}
   * 	<p>{@code 创建新租户}
   */
  default void createTenant(SimpleResultBuilder<TenantSummary> builder,
      CreateTenantRequest createTenantRequest) {
    builder.notImplemented();
  }

  /**
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}}
   * 	<p>{@code 获取租户详情}
   */
  default void getTenant(SimpleResultBuilder<TenantDetail> builder, Integer tenantId) {
    builder.notImplemented();
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>Authorities: [TENANT_UPDATE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}}
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
   * 	<li>Authorities: [TENANT_DISABLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/disable}
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
   * 	<li>Authorities: [TENANT_CONFIGURE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/tenants/tenants/{tenantId}/configure}
   * 	<p>{@code 配置租户功能}
   */
  default void configureTenant(SimpleResultBuilder<String> builder, Integer tenantId,
      ConfigureTenantRequest configureTenantRequest) {
    builder.notImplemented();
  }
}
