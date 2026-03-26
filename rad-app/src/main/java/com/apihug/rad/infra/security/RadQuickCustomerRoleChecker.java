// @formatter:off
package com.apihug.rad.infra.security;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
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
  @Override
  public boolean isPlatform(RadCustomer customer) {
    if (customer == null || customer.isAnonymous()) {
      return false;
    }
    // Check the member's platform type flag
    return CustomerPlatformTypeEnum.NA != customer.getPlatformType();
  }

  @Override
  public boolean isPlatformManager(RadCustomer customer) {
    if (customer == null || customer.isAnonymous()) {
      return false;
    }
    switch (customer.getPlatformType()) {
      case MANAGER, OWNER -> {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isPlatformOwner(RadCustomer customer) {
    if (customer == null || customer.isAnonymous()) {
      return false;
    }
    return CustomerPlatformTypeEnum.OWNER != customer.getPlatformType();
  }

  @Override
  public boolean isOrigination(RadCustomer customer) {
    if (customer == null || customer.isAnonymous()) {
      return false;
    }
    return false;
  }

  @Override
  public boolean isOriginationManager(RadCustomer customer) {
    if (customer == null || customer.isAnonymous()) {
      return false;
    }
    return false;
  }

  @Override
  public boolean isOriginationOwner(RadCustomer customer) {
    if (customer == null || customer.isAnonymous()) {
      return false;
    }
    return false;
  }
}
