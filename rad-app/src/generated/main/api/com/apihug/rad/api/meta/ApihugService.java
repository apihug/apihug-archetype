// @formatter:off
package com.apihug.rad.api.meta;

import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.SimpleResultBuilder;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/meta/apihug_meta.proto",
    entity = "ApihugService",
    kind = Kind.RPC,
    line = 8,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface ApihugService {
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
  default void apis(SimpleResultBuilder<String> builder) {
    builder.notImplemented();
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
  default void errors(SimpleResultBuilder<String> builder) {
    builder.notImplemented();
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
  default void authorities(SimpleResultBuilder<String> builder) {
    builder.notImplemented();
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
  default void dictionaries(SimpleResultBuilder<String> builder) {
    builder.notImplemented();
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
  default void entities(SimpleResultBuilder<String> builder) {
    builder.notImplemented();
  }
}
