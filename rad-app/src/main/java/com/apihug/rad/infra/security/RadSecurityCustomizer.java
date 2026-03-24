// @formatter:off
package com.apihug.rad.infra.security;

import hope.common.service.runtime.Resource;
import hope.common.spring.security.HopeSecurityProperties;
import hope.common.spring.security.SecurityContext;
import hope.common.spring.security.SecurityCustomizer;
import hope.common.spring.security.checker.Checker;
import java.lang.Override;
import java.util.function.Supplier;
import javax.annotation.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 *
 * Security configuration customizer defining global access control policies
 * and resource-level permission override rules.
 *
 * <p>Implements {@link SecurityCustomizer} interface, serving as the core configuration
 * entry point for the ApiHug security framework, providing two levels of access control:</p>
 *
 * <h3>Configuration Levels:</h3>
 * <ol>
 * <li><b>Global Policy</b>: Define default access behavior for unconfigured resources via {@link #all}</li>
 * <li><b>Path Override</b>: Fine-grained permission control for specific resources via {@link #path}</li>
 * </ol>
 *
 * <h3>Default Access Policies (configured via hope.security.default-access-style):</h3>
 * <table border="1">
 * <tr><th>Policy</th><th>Behavior</th><th>Use Case</th></tr>
 * <tr><td>PASS</td><td>Anonymous access</td><td>Public APIs, non-sensitive data</td></tr>
 * <tr><td>LOGIN</td><td>Requires login</td><td>Regular business endpoints</td></tr>
 * <tr><td>ACTIVE</td><td>Requires active account</td><td>Sensitive operations</td></tr>
 * <tr><td>DENY</td><td>Deny access</td><td>Default deny, explicit allow</td></tr>
 * </table>
 *
 * <h3>Usage Examples:</h3>
 * <pre>{@code
 * // Example 1: Permit login endpoint
 * securityContext.exactly("/api/v1/auth/login").permit();
 *
 * // Example 2: API paths require login
 * securityContext.start("/api/v1").needLogin();
 *
 * // Example 3: Custom permission checker
 * securityContext.start("/api/v1/admin").security(new Checker() {
 *  public boolean isGranted(Resource path, Customer identify, Map ctx) {
 *      return identify.hasAnyRoles(List.of("ADMIN"));
 *  }
 * });
 * }</pre>
 *
 * @see hope.common.spring.security.SecurityContext
 * @see com.apihug.rad.infra.security.RadQuickCustomerRoleChecker
 *
 */
@Component
@Generated("H.O.P.E. Infra Team")
public class RadSecurityCustomizer implements SecurityCustomizer {
  protected final HopeSecurityProperties securityProperties;

  public RadSecurityCustomizer(ObjectProvider<HopeSecurityProperties> propertiesProvider) {
    this.securityProperties = propertiesProvider.getIfAvailable();
  }

  @Override
  public void all(SecurityContext securityContext) {
    // Please follow guide below to customize security behaviour as you like:

    /**
      * 1. Default access control behaviour for undefined resource, control by `hope.security.default-access-style`<br>
      *
      * <ul>
      *   <li>PASS: Any resources have no {@link hope.common.service.api.Authorization} defined will
      *       be passed with no authorization checker; Meaning it is anonymous
      *   <li>DENY: Any resources have no {@link hope.common.service.api.Authorization} will be
      *       denied, this is default behaviour
      *   <li>LOGIN: Any resources have no {@link hope.common.service.api.Authorization} defined will
      *       need login authorization at least
      *   <li>ACTIVE: Any resource have no {@link hope.common.service.api.Authorization} defined will
      *       need active login authorization at least, restrict than {@code LOGIN}
      * </ul>
      */
      if (securityProperties != null) {
        securityProperties.getDefaultAccessStyle().handle(securityContext);
      }

    /**
      * 2. Access control behaviour for specific resource<br>
      * Resource with path {@code /login } should pass with no authorization check <br>
      * <code>
      *     securityContext.exactly("/login").permit();
      * </code>
      */

    /**
      * 3. Complex customized access control behaviour<br>
      * Any resource path start with {@code /api/v1 } apply by specific check logic, you can also
      * use {@code ant} style match <br>
      * <code>
      *     securityContext.start("/api/v1").security(new Checker() {
      *       @Override
      *       public boolean isGranted(Resource path, Customer identify, Map ctx) {
      *         //Specific logic:
      *         return false;
      *       }
      *      });
      * </code>
      */

  }

  @Override
  public Supplier path(SecurityContext securityContext, Resource resource,
      Supplier<Checker> predefined, boolean isDefault) {
    // TODO add your path security customized overwrite here;
    return predefined;
  }
}
