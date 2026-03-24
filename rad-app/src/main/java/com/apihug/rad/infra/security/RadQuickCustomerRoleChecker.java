// @formatter:off
package com.apihug.rad.infra.security;

import hope.common.spring.security.checker.QuickCustomerRoleChecker;
import java.lang.Override;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

/**
 * Quick checker for common built-in roles in the security framework.
 *
 * <p>Implements {@link QuickCustomerRoleChecker} interface, providing fast validation methods
 * for platform and organization level built-in roles. Extend this class to customize
 * role detection logic for domain-specific requirements.</p>
 *
 * <h3>Built-in Role Categories:</h3>
 * <table border="1">
 * <tr><th>Category</th><th>Methods</th></tr>
 * <tr><td>Platform Level</td><td>{@link #isPlatform}, {@link #isPlatformManager}, {@link #isPlatformOwner}</td></tr>
 * <tr><td>Organization Level</td><td>{@link #isOrigination}, {@link #isOriginationManager}, {@link #isOriginationOwner}</td></tr>
 * </table>
 *
 * <h3>Role Hierarchy:</h3>
 * <pre>
 * Platform Level:    Owner > Manager > Member
 * Organization Level: Owner > Manager > Member
 * </pre>
 *
 * <h3>Extension Example:</h3>
 * <pre>{@code
 * @Override
 * public boolean isPlatformManager(SchoolCustomer customer) {
 *  return customer.hasAnyRoles(List.of("PLATFORM_ADMIN", "PLATFORM_MANAGER"));
 * }
 * }</pre>
 *
 * @see com.apihug.rad.infra.security.RadCustomer
 * @see #com.apihug.rad.infra.security.RadSecurityCustomizer#
 */
@Component
@Generated("H.O.P.E. Infra Team")
public class RadQuickCustomerRoleChecker implements QuickCustomerRoleChecker<RadCustomer> {
  @Override
  public boolean isPlatform(RadCustomer customer) {
    return false;
  }

  @Override
  public boolean isPlatformManager(RadCustomer customer) {
    return false;
  }

  @Override
  public boolean isPlatformOwner(RadCustomer customer) {
    return false;
  }

  @Override
  public boolean isOrigination(RadCustomer customer) {
    return false;
  }

  @Override
  public boolean isOriginationManager(RadCustomer customer) {
    return false;
  }

  @Override
  public boolean isOriginationOwner(RadCustomer customer) {
    return false;
  }
}
