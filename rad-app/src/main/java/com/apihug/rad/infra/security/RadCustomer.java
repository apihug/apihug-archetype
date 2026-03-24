// @formatter:off
package com.apihug.rad.infra.security;

import hope.common.spring.security.internal.CustomerLongIdentifyLongTenant;
import javax.annotation.Generated;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Rad system user identity entity carrying core information of authenticated users.
 *
 * <p>Extends {@code hope.common.spring.security.internal.CustomerLongIdentifyLongTenant}, defining an identity model where both
 * user ID and tenant ID are Long types. This class serves as the core data carrier for
 * RBAC (Role-Based Access Control) in the ApiHug security framework.</p>
 *
 * <h3>Identity Attributes:</h3>
 * <ul>
 * <li><b>ID</b>: Unique user identifier (java.lang.Long type)</li>
 * <li><b>TenantId</b>: Tenant identifier supporting multi-tenant architecture (java.lang.Long type)</li>
 * <li><b>Account</b>: User account (login name)</li>
 * <li><b>Name</b>: User display name</li>
 * <li><b>Active</b>: Account activation status</li>
 * <li><b>Authorities</b>: Permission list (fine-grained permissions)</li>
 * <li><b>Roles</b>: Role list (role-aggregated permissions)</li>
 * </ul>
 *
 * <h3>RBAC Permission Model:</h3>
 * <pre>
 * User → Roles → Authorities (Permissions)
 * </pre>
 *
 * <h3>Lifecycle:</h3>
 * <ol>
 * <li>Instance created by framework after successful login authentication</li>
 * <li>Identity information passed between requests via JWT Token</li>
 * <li>Provides role and permission checking capabilities during authorization</li>
 * </ol>
 *
 * @see com.apihug.rad.infra.security.AnonymousRadCustomer Anonymous user implementation
 * @see #SecurityCustomerContextCustomizer# Responsible for creating and parsing user instances
 */
@Generated("H.O.P.E. Infra Team")
public class RadCustomer extends CustomerLongIdentifyLongTenant<RadCustomer> {

    protected Set<String> authorities;

    @Override
    public Collection<String> getAuthorities() {
        return this.authorities != null ? this.authorities : Collections.emptySet();
    }

    public RadCustomer setAuthorities(Collection<String> authorities) {
        this.authorities = authorities != null ? Set.copyOf(authorities) : Collections.emptySet();
        return this;
    }
}
