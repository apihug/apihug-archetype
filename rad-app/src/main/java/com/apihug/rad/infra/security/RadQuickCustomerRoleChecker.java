// @formatter:off
package com.apihug.rad.infra.security;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.security.checker.QuickCustomerRoleChecker;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

/**
 * Quick checker for common built-in roles in the security framework.
 *
 * <p>Implements {@link QuickCustomerRoleChecker} interface, providing fast validation methods for
 * platform and organization level built-in roles. Extend this class to customize role detection
 * logic for domain-specific requirements.
 *
 * <h3>Built-in Role Categories:</h3>
 *
 * <table border="1">
 * <tr><th>Category</th><th>Methods</th></tr>
 * <tr><td>Platform Level</td><td>{@link #isPlatform}, {@link #isPlatformManager}, {@link #isPlatformOwner}</td></tr>
 * <tr><td>Organization Level</td><td>{@link #isOrigination}, {@link #isOriginationManager}, {@link #isOriginationOwner}</td></tr>
 * </table>
 *
 * <h3>Role Hierarchy:</h3>
 *
 * <pre>
 * Platform Level:    Owner > Manager > Member
 * Organization Level: Owner > Manager > Member
 * </pre>
 *
 * <h3>Extension Example:</h3>
 *
 * <pre>{@code
 * @Override
 * public boolean isPlatformManager(SchoolCustomer customer) {
 *  return customer.hasAnyRoles(List.of("PLATFORM_ADMIN", "PLATFORM_MANAGER"));
 * }
 * }</pre>
 *
 * @see RadCustomer
 * @see RadSecurityCustomizer
 */
@Template(
    type = Template.Type.INFRA,
    infra = Template.Infra.QuickCustomerRoleChecker,
    usage = "extension of QuickCustomerRoleChecker support check of the predefined rules",
    percentage = 30)
@Component
@Generated("H.O.P.E. Infra Team")
public class RadQuickCustomerRoleChecker implements QuickCustomerRoleChecker<RadCustomer> {

  /**
   * Checks if the customer has any platform-level role (not NA).
   *
   * @param customer the customer to check; may be null
   * @return true if the customer has a valid platform role, false otherwise
   */
  @Override
  public boolean isPlatform(RadCustomer customer) {
    if (customer == null || customer.isAnonymous() || customer.getPlatformType() == null) {
      return false;
    }
    // Check the member's platform type flag
    return CustomerPlatformTypeEnum.NA != customer.getPlatformType();
  }

  /**
   * Checks if the customer has platform manager or owner role.
   *
   * <p>Platform managers have elevated privileges for platform-wide operations.
   *
   * @param customer the customer to check; may be null
   * @return true if the customer is a platform manager or owner, false otherwise
   */
  @Override
  public boolean isPlatformManager(RadCustomer customer) {
    if (customer == null || customer.isAnonymous() || customer.getPlatformType() == null) {
      return false;
    }
    switch (customer.getPlatformType()) {
      case MANAGER, OWNER -> {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the customer has platform owner role (highest platform privilege).
   *
   * @param customer the customer to check; may be null
   * @return true if the customer is a platform owner, false otherwise
   */
  @Override
  public boolean isPlatformOwner(RadCustomer customer) {
    if (customer == null || customer.isAnonymous() || customer.getPlatformType() == null) {
      return false;
    }
    return CustomerPlatformTypeEnum.OWNER == customer.getPlatformType();
  }

  /**
   * Checks if the customer has any tenant-level role (not NA).
   *
   * @param customer the customer to check; may be null
   * @return true if the customer has a valid tenant role, false otherwise
   */
  @Override
  public boolean isOrigination(RadCustomer customer) {
    if (customer == null || customer.isAnonymous() || customer.getTenantType() == null) {
      return false;
    }
    return MemberRoleEnum.NA != customer.getTenantType();
  }

  /**
   * Checks if the customer has tenant admin or owner role.
   *
   * <p>Tenant managers have elevated privileges within their tenant organization.
   *
   * @param customer the customer to check; may be null
   * @return true if the customer is a tenant admin or owner, false otherwise
   */
  @Override
  public boolean isOriginationManager(RadCustomer customer) {
    if (customer == null || customer.isAnonymous() || customer.getTenantType() == null) {
      return false;
    }
    switch (customer.getTenantType()) {
      case ADMIN, OWNER:
        return true;
    }
    return false;
  }

  /**
   * Checks if the customer has tenant owner role (highest tenant privilege).
   *
   * @param customer the customer to check; may be null
   * @return true if the customer is a tenant owner, false otherwise
   */
  @Override
  public boolean isOriginationOwner(RadCustomer customer) {
    if (customer == null || customer.isAnonymous() || customer.getTenantType() == null) {
      return false;
    }
    return MemberRoleEnum.OWNER == customer.getTenantType();
  }
}
