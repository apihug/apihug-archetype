// @formatter:off
package com.apihug.rad;

import com.apihug.rad.wire.api.RadApiModule;
import hope.common.spring.security.SecurityContext;
import java.lang.Override;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Component
@Generated("H.O.P.E. Infra Team")
public class RadSecurityContext extends SecurityContext<RadApiModule> {
  @Override
  protected RadApiModule module() {
    return new RadApiModule();
  }
}
