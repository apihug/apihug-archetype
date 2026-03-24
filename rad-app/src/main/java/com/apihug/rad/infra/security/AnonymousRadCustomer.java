// @formatter:off
package com.apihug.rad.infra.security;

import hope.common.spring.security.internal.ImmutableCustomer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import javax.annotation.Generated;

/**
 *
 * Singleton implementation representing an unauthenticated visitor identity.
 *
 * <p>This class serves as the user identity for all unauthenticated requests in the system,
 * using the singleton pattern ({@link #INSTANCE}) to ensure global uniqueness.
 * All mutation operations throw exceptions to guarantee immutability of the anonymous identity.</p>
 *
 * <h3>Key Features:</h3>
 * <ul>
 * <li><b>Singleton Pattern</b>: Provides a globally unique anonymous user instance via {@link #INSTANCE}</li>
 * <li><b>Immutability</b>: All setter methods throw exceptions to prevent illegal modifications</li>
 * <li><b>Permission Isolation</b>: No roles or authorities; {@link #hasAnyAuthorities} and
 *    {@link #hasAnyRoles} always return false</li>
 * </ul>
 *
 * <h3>Use Cases:</h3>
 * <ul>
 * <li>Identity for public API endpoints (e.g., login, registration endpoints that don't require authentication)</li>
 * <li>Determining if the current user is logged in via {@code customer.isAnonymous()}</li>
 * <li>Default deny strategy during permission checks</li>
 * </ul>
 *
 * @see com.apihug.rad.infra.security.RadCustomer
 * @see com.apihug.rad.infra.security.RadSecurityCustomerContextCustomizer#anonymous()
 */
@Generated("H.O.P.E. Infra Team")
public class AnonymousRadCustomer extends RadCustomer {
  public static final AnonymousRadCustomer INSTANCE = new AnonymousRadCustomer();

  @Override
  public Long getTenantId() {
    throw ImmutableCustomer.ImmutableExceptions.getTenantId;
  }

  @Override
  public Long getId() {
    throw ImmutableCustomer.ImmutableExceptions.getId;
  }

  @Override
  public boolean isActive() {
    return false;
  }

  @Override
  public boolean isAnonymous() {
    return true;
  }

  @Override
  public boolean hasAnyAuthorities(Collection<String> authorities) {
    return false;
  }

  @Override
  public boolean hasAnyRoles(Collection<String> roles) {
    return false;
  }

  @Override
  public boolean hasNoAuthority() {
    return true;
  }

  @Override
  public boolean hasNoRole() {
    return true;
  }

  @Override
  public AnonymousRadCustomer setId(Long id) {
    throw ImmutableCustomer.ImmutableExceptions.setId;
  }

  @Override
  public AnonymousRadCustomer setTenantId(Long tenantId) {
    throw ImmutableCustomer.ImmutableExceptions.setTenantId;
  }

  @Override
  public AnonymousRadCustomer setAccount(String account) {
    throw ImmutableCustomer.ImmutableExceptions.setAccount;
  }

  @Override
  public AnonymousRadCustomer setActive(boolean active) {
    throw ImmutableCustomer.ImmutableExceptions.setActive;
  }

  @Override
  public AnonymousRadCustomer setAuthorities(Collection<String> authorities) {
    throw ImmutableCustomer.ImmutableExceptions.setAuthorities;
  }

  @Override
  public AnonymousRadCustomer setName(String name) {
    throw ImmutableCustomer.ImmutableExceptions.setName;
  }

  @Override
  public AnonymousRadCustomer setRoles(Collection<String> roles) {
    throw ImmutableCustomer.ImmutableExceptions.setRoles;
  }
}
