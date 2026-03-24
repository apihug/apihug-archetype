// @formatter:off
package com.apihug.rad.infra.spa;

import java.lang.Integer;
import javax.annotation.Generated;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

/**
 * Configuration for Single Page Application (SPA) routing support.
 *
 * <p>Registers a {@link SpaFilter} to handle client-side routing by forwarding
 *
 * <p>non-API requests to the SPA entry point (typically index.html).
 *
 * <p>To temporarily disable SPA functionality during development or troubleshooting, comment out
 * the {@code @Configuration} annotation above.
 *
 * <p>Configuration notes:
 *
 * <ul>
 * <li>{@code proxyBeanMethods = false} - Optimizes bean creation for configuration classes
 * <li>{@code @Lazy(false)} - Ensures eager initialization of the filter
 * <li>{@code @ConditionalOnWebApplication(type = SERVLET)} - Only activates in SERVLET web
 *    applications
 * <li>{@code @Order(Integer.MIN_VALUE)} - Sets filter to run first in the chain
 * </ul>
 */
@Configuration(
    proxyBeanMethods = false
)
@Lazy(false)
@ConditionalOnWebApplication(
    type = ConditionalOnWebApplication.Type.SERVLET
)
@Generated("H.O.P.E. Infra Team")
public class SpaConfigurer {
  @Bean
  @Order(Integer.MIN_VALUE)
  public SpaFilter spaWebFilter() {
    return new SpaFilter();
  }
}
