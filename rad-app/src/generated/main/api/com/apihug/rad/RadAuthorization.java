// @formatter:off
package com.apihug.rad;

import com.apihug.rad.infra.settings.RadAuthorityEnum;
import hope.common.proto.swagger.Authorization;
import hope.common.proto.swagger.RBAC;
import java.lang.String;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Generated;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Generated("H.O.P.E. Infra Team")
public @interface RadAuthorization {
  /**
   * Whether this method is anonymous.
   */
  boolean anonymous() default false;

  /**
   * Low risk mode level
   */
  Authorization.LowLimitRiskyMode lowLimitRiskyMode() default Authorization.LowLimitRiskyMode.NONE;

  /**
   * Predefined role check type
   */
  RBAC.PredefinedRoleCheckerType predefinedRoleCheckerType(
      ) default RBAC.PredefinedRoleCheckerType.NONE;

  /**
   * How the roles and authorities are combined: {@code AND|OR}
   */
  RBAC.Combinator combinator() default RBAC.Combinator.AND;

  /**
   * Has any roles supports
   */
  String[] roles() default {};

  /**
   * {@code SpEL} expression
   */
  String expression() default "";

  /**
   * Has any authorities support
   */
  RadAuthorityEnum[] authorities() default {};
}
