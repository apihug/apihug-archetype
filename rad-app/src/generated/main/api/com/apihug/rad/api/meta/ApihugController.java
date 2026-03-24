// @formatter:off
package com.apihug.rad.api.meta;

import hope.common.api.Result;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/meta/apihug_meta.proto",
    entity = "ApihugService",
    kind = Kind.RPC,
    line = 8,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class ApihugController {
  public static final String _SVC_NAME = "com.apihug.rad.api.meta.ApihugService";

  protected final ApihugService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public ApihugController(ApihugService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/apihug/meta/apis}
   * 	<p>{@code api information of this platform}
   */
  @GetMapping("/api/apihug/meta/apis")
  public ResponseEntity<Result<String>> apis() {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Apis, _ctx);
      _service.apis(builder);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.Apis, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Apis, exception);
      aspect().exception(Apis.Apis, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/apihug/meta/errors}
   * 	<p>{@code api errors information of this platform}
   */
  @GetMapping("/api/apihug/meta/errors")
  public ResponseEntity<Result<String>> errors() {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Errors, _ctx);
      _service.errors(builder);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.Errors, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Errors, exception);
      aspect().exception(Apis.Errors, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/apihug/meta/authorities}
   * 	<p>{@code api errors information of this platform}
   */
  @GetMapping("/api/apihug/meta/authorities")
  public ResponseEntity<Result<String>> authorities() {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Authorities, _ctx);
      _service.authorities(builder);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.Authorities, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Authorities, exception);
      aspect().exception(Apis.Authorities, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/apihug/meta/dictionaries}
   * 	<p>{@code api errors information of this platform}
   */
  @GetMapping("/api/apihug/meta/dictionaries")
  public ResponseEntity<Result<String>> dictionaries() {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Dictionaries, _ctx);
      _service.dictionaries(builder);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.Dictionaries, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Dictionaries, exception);
      aspect().exception(Apis.Dictionaries, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/apihug/meta/entities}
   * 	<p>{@code api errors information of this platform}
   */
  @GetMapping("/api/apihug/meta/entities")
  public ResponseEntity<Result<String>> entities() {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API");
    try {
      aspect().before(Apis.Entities, _ctx);
      _service.entities(builder);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.Entities, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.Entities, exception);
      aspect().exception(Apis.Entities, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext Apis = new ServiceMethodContext("com.apihug.rad.api.meta.ApihugService", "Apis", "/api/apihug/meta/apis", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext Errors = new ServiceMethodContext("com.apihug.rad.api.meta.ApihugService", "Errors", "/api/apihug/meta/errors", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext Authorities = new ServiceMethodContext("com.apihug.rad.api.meta.ApihugService", "Authorities", "/api/apihug/meta/authorities", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext Dictionaries = new ServiceMethodContext("com.apihug.rad.api.meta.ApihugService", "Dictionaries", "/api/apihug/meta/dictionaries", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext Entities = new ServiceMethodContext("com.apihug.rad.api.meta.ApihugService", "Entities", "/api/apihug/meta/entities", Priority.LOW, ServiceMethod.HttpMethod.GET);
  }
}
