// @formatter:off
package com.apihug.rad;

import com.apihug.rad.wire.api.RadApiModule;
import hope.common.runtime.RuntimeApplication;
import hope.common.runtime.RuntimeContext;
import hope.common.spring.RuntimeContextInitializer;
import java.lang.Override;
import java.util.function.Supplier;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Component
@Generated("H.O.P.E. Infra Team")
public class RadRuntimeContextInitializer extends RuntimeContextInitializer {
  @Override
  protected void init() {
    RuntimeContext runTimeCtx = RuntimeContext.INSTANCE;
    runTimeCtx.setDomain("rad");
    runTimeCtx.setModule(new RadApiModule());
    runTimeCtx.setRuntimeApplication(new Supplier<RuntimeApplication>() {
      @Override
      public RuntimeApplication get() {
        RuntimeApplication res  = new RuntimeApplication();
        res.setDescription("apihug rapid application development template");
        res.setName("rad-app");
        res.setVersion("0.1.1-SNAPSHOT");
        return res;
      }
    }.get());
    runTimeCtx.setStubBuildTime("2026-03-24 17:50:23");
  }
}
