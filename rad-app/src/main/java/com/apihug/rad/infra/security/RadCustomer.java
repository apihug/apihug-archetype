// @formatter:off
package com.apihug.rad.infra.security;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.security.internal.CustomerLongIdentifyLongTenant;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Generated;

/**
 * Rad system user identity entity carrying core information of authenticated users.
 *
 * <p>Extends {@code hope.common.spring.security.internal.CustomerLongIdentifyLongTenant}, defining
 * an identity model where both user ID and tenant ID are Long types. This class serves as the core
 * data carrier for RBAC (Role-Based Access Control) in the ApiHug security framework.
 *
 * <h3>Identity Attributes:</h3>
 *
 * <ul>
 *   <li><b>ID</b>: Unique user identifier (java.lang.Long type)
 *   <li><b>TenantId</b>: Tenant identifier supporting multi-tenant architecture (java.lang.Long
 *       type)
 *   <li><b>Account</b>: User account (login name)
 *   <li><b>Name</b>: User display name
 *   <li><b>Active</b>: Account activation status
 *   <li><b>Authorities</b>: Permission list (fine-grained permissions)
 *   <li><b>Roles</b>: Role list (role-aggregated permissions)
 * </ul>
 *
 * <h3>RBAC Permission Model:</h3>
 *
 * <pre>
 * User → Roles → Authorities (Permissions)
 * </pre>
 *
 * <h3>Lifecycle:</h3>
 *
 * <ol>
 *   <li>Instance created by framework after successful login authentication
 *   <li>Identity information passed between requests via JWT Token
 *   <li>Provides role and permission checking capabilities during authorization
 * </ol>
 *
 * @see AnonymousRadCustomer Anonymous user implementation
 * @see RadJwtCustomizer Responsible for creating and parsing user instances
 */
@Template(
    type = Template.Type.INFRA,
    infra = Template.Infra.Customer,
    usage = "extension of the customer add authorities and platform type support",
    percentage = 70)
@Generated("H.O.P.E. Infra Team")
public class RadCustomer extends CustomerLongIdentifyLongTenant<RadCustomer> {

  /** The platform-level role type of the customer within the entire platform ecosystem. */
  protected CustomerPlatformTypeEnum platformType = CustomerPlatformTypeEnum.NA;

  /** The set of granted authority strings for authorization and access control. */
  protected Set<String> authorities;

  /** The tenant-level role type of the customer within a specific tenant organization. */
  protected MemberRoleEnum tenantType = MemberRoleEnum.NA;

  @Override
  public Collection<String> getAuthorities() {
    return this.authorities != null ? this.authorities : Collections.emptySet();
  }

  @Override
  public RadCustomer setAuthorities(Collection<String> authorities) {
    this.authorities = authorities != null ? Set.copyOf(authorities) : Collections.emptySet();
    return this;
  }

  public CustomerPlatformTypeEnum getPlatformType() {
    return platformType;
  }

  public RadCustomer setPlatformType(CustomerPlatformTypeEnum platformType) {
    this.platformType = platformType;
    return this;
  }

  public MemberRoleEnum getTenantType() {
    return tenantType;
  }

  public RadCustomer setTenantType(MemberRoleEnum tenantType) {
    this.tenantType = tenantType;
    return this;
  }
}
