// @formatter:off
package com.apihug.rad.infra.security;

import hope.common.spring.security.DefaultJwtCustomizer;
import hope.common.spring.security.HopeSecurityProperties;
import hope.common.spring.security.JwtCustomizer;
import hope.common.spring.security.JwtTrivialConfigurationProvider;
import java.lang.Class;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Component;

/**
 * JwtCustomizer responsible for user instance creation, anonymous identity management, and JWT
 * Token serialization.
 *
 * <p>As a core extension point of the ApiHug security framework, this class defines the complete
 * lifecycle management of {@link SchoolCustomer}, including identity creation and custom claim
 * handling during token encoding/decoding.
 *
 * <h3>Core Responsibilities:</h3>
 *
 * <table border="1">
 * <tr><th>Method</th><th>Responsibility</th></tr>
 * <tr><td>{@link #customer()}</td><td>Create blank user instance for authentication flow to populate</td></tr>
 * <tr><td>{@link #anonymousCustomer()}</td><td>Return anonymous user singleton for unauthenticated requests</td></tr>
 * <tr><td>{@link #prepareJwt}</td><td>Inject custom claims during JWT generation</td></tr>
 * <tr><td>{@link #postDecode}</td><td>Restore custom claims to user object during JWT parsing</td></tr>
 * </table>
 *
 * <h3>JWT Token Extension Flow:</h3>
 *
 * <pre>
 * Auth Success → prepareJwt() inject custom claims → Generate JWT
 *                                          ↓
 * Request Arrives → Parse JWT → tokenParse() restore claims → Build SchoolCustomer
 * </pre>
 *
 * <h3>Extension Example (Adding department info to Token):</h3>
 *
 * <pre>{@code
 * @Override
 * public void prepareJwt(JwtClaimsSet.Builder claim, com.apihug.rad.infra.security.RadCustomer customer) {
 *   claims.claim(ROLES, customer.getRoles());
 * }
 *
 * @Override
 * public com.apihug.rad.infra.security.RadCustomer postDecode(com.apihug.rad.infra.security.RadCustomer customer, Jwt jwt) {
 *   Map<String, Object> claims = jwt.getClaims();
 *   Long deptId = (Long)claims.get("departmentId");
 *   customer.setDepartmentId(deptId);
 *   //customer.setAuthorities(); pick from cache or extra system
 *   return customer;
 * }
 * }</pre>
 *
 * @see com.apihug.rad.infra.security.RadCustomer
 * @see com.apihug.rad.infra.security.AnonymousRadCustomer
 */
@Component
@Generated("H.O.P.E. Infra Team")
public class RadJwtCustomizer extends DefaultJwtCustomizer<RadCustomer> {

  private static final String CLAIM_ROLES = "roles";
  private static final String CLAIM_AUTHORITIES = "authorities";

  public RadJwtCustomizer(
      JwtDecoder jwtDecoder,
      JwtEncoder jwtEncoder,
      HopeSecurityProperties properties,
      ObjectProvider<JwtTrivialConfigurationProvider> jwtTrivialConfigurationProviders) {
    super(jwtDecoder, jwtEncoder, properties, jwtTrivialConfigurationProviders);
    DEFAULT.setDelegator(this);
  }

  @Override
  public RadCustomer customer() {
    return new RadCustomer();
  }

  @Override
  public RadCustomer anonymousCustomer() {
    return AnonymousRadCustomer.INSTANCE;
  }

  @Override
  public Class tenantClz() {
    return Long.class;
  }

  @Override
  public Class identifierClz() {
    return Long.class;
  }

  /**
   * Extension point for customizing the JWT claims during token preparation.
   * <p>
   * This method is invoked as part of the JWT building process, allowing subclasses to add
   * additional claims to the {@link JwtClaimsSet.Builder} based on the provided customer.
   * Typical use cases include injecting roles, authorities, tenant identifiers, or any other
   * custom attributes required by the consuming resource servers.
   * <p>
   * Example usage:
   * <pre>{@code
   *     //Add rules
   *     claims.claim(ROLES, customer.getRoles());
   *     //Add authorities
   *     claims.claim(PRIVILEGES, customer.getAuthorities());
   * </pre>
   * <p>
   *
   * @param claims   the {@link JwtClaimsSet.Builder} to which custom claims can be added
   * @param customer the customer entity (or DTO) containing data to be embedded in the JWT
   */
  @Override
  public void prepareJwt(JwtClaimsSet.Builder claim, RadCustomer customer) {
    if (customer.getRoles() != null && !customer.getRoles().isEmpty()) {
      claim.claim(CLAIM_ROLES, customer.getRoles());
    }
    if (customer.getAuthorities() != null && !customer.getAuthorities().isEmpty()) {
      claim.claim(CLAIM_AUTHORITIES, customer.getAuthorities());
    }
  }

  /**
   * Extension point for enriching the customer object after a JWT has been successfully decoded.
   *
   * <p>This method is invoked following the decoding and validation of a JWT, providing an
   * opportunity to extract custom claims from the token and populate the corresponding fields of
   * the customer entity. Typical use cases include setting roles, privileges, tenant identifiers,
   * or any other custom attributes that were embedded in the JWT during token creation.
   *
   * <p>Example usage:
   *
   * <pre>{@code
   * Map<String, Object> claims = jwt.getClaims();
   * if (claims.containsKey(ROLES)) {
   *   customer.setRoles((Collection<String>) claims.get(ROLES));
   * }
   * if (claims.containsKey(PRIVILEGES)) {
   *   customer.setAuthorities((Collection<String>) claims.get(PRIVILEGES));
   * }
   * }</pre>
   *
   * <p>Implementations <strong>must</strong> override this method to provide the actual enrichment
   * logic. The default implementation throws {@link UnsupportedOperationException} to indicate that
   * it is intended to be implemented by runtime contexts.
   *
   * @param customer the customer entity (or DTO) to be enriched with data from the JWT
   * @param jwt the decoded JWT object containing the claims extracted from the token
   * @return the enriched customer instance (typically the same object, possibly modified)
   */
  @SuppressWarnings("unchecked")
  @Override
  public RadCustomer postDecode(RadCustomer customer, Jwt jwt) {
    Map<String, Object> claims = jwt.getClaims();
    if (claims.containsKey(CLAIM_ROLES)) {
      customer.setRoles((Collection<String>) claims.get(CLAIM_ROLES));
    }
    if (claims.containsKey(CLAIM_AUTHORITIES)) {
      customer.setAuthorities((Collection<String>) claims.get(CLAIM_AUTHORITIES));
    }
    return customer;
  }

  /**
   * Assigns the tenant identifier to the customer object in a type-safe manner.
   *
   * <p>This method is intended to be used after extracting the tenant ID from a JWT claim, where
   * the raw value may be of various numeric types (e.g., {@link Long}, {@link Integer}) or a {@link
   * String}. The implementation is responsible for converting the provided {@code tenantId} to the
   * appropriate type expected by the customer entity, thereby avoiding runtime {@link
   * ClassCastException} or other type mismatch issues.
   *
   * <p>The method is declared abstract to enforce that concrete subclasses provide a type‑safe
   * assignment strategy tailored to the specific {@code T} customer type.
   *
   * @param customer the customer instance (partially initialized) that will receive the tenant ID
   * @param tenantId the tenant identifier extracted from the JWT; may be a {@link Number}, {@link
   *     String}, or {@code null}
   */
  @Override
  protected void setTenantId(RadCustomer customer, Object tenantId) {
    customer.setTenantId(safe2Long(tenantId, 0L));
  }

  /**
   * Assigns the customer identifier to the customer object in a type-safe manner.
   *
   * <p>This method is intended to be used after extracting the customer ID from a JWT claim, where
   * the raw value may be of various numeric types (e.g., {@link Long}, {@link Integer}) or a
   * string. The implementation is responsible for converting the provided {@code customerId} to the
   * appropriate type expected by the customer entity, thereby avoiding runtime {@link
   * ClassCastException} or other type mismatch issues.
   *
   * <p>The method is declared abstract to enforce that concrete subclasses provide a type‑safe
   * assignment strategy tailored to the specific {@code T} customer type.
   *
   * @param customer the customer instance (partially initialized) that will receive the customer ID
   * @param customerId the customer identifier extracted from the JWT; may be a {@link Number},
   *     {@link String}, or {@code null}
   */
  @Override
  protected void setCustomerId(RadCustomer customer, Object customerId) {
    customer.setId(safe2Long(customerId, 0L));
  }

  /**
   * Extracts the raw JWT string from the incoming request.
   *
   * <p>This method determines the source from which the JWT should be retrieved. Common sources
   * include the HTTP {@code Authorization} header (default), a request parameter, or a cookie. The
   * implementation is designed to work across different web stacks: the {@code context} parameter
   * can be either a {@link org.springframework.http.server.reactive.ServerHttpRequest} (for
   * reactive applications) or a {@link jakarta.servlet.http.HttpServletRequest} (for servlet‑based
   * applications).
   *
   * <p>Subclasses may override this method to support alternative token locations, such as
   * extracting the token from a query parameter or a cookie instead of the default header.
   *
   * @param http the {@link HttpProtocolAdapter} providing protocol‑specific access methods
   * @param key the key used to locate the token (e.g., the header name, parameter name, or cookie
   *     name)
   * @param context the underlying request object; either a {@code ServerHttpRequest} for reactive
   *     stacks or an {@code HttpServletRequest} for servlet stacks
   * @return the raw JWT string, or {@code null} if the token is not present in the expected
   *     location
   */
  @Override
  public String jwtPicker(JwtCustomizer.HttpProtocolAdapter http, String key, Object context) {
    return http.header(key);
  }
}
