// @formatter:off
package com.apihug.rad.api.meta;

import com.apihug.rad.domain.apihug.ApihugMetaService;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.springframework.stereotype.Service;

@Template(
    type = Template.Type.SERVICE,
    usage = "Apihug self module meta informationService",
    percentage = 100)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/meta/apihug_meta.proto",
    entity = "ApihugService",
    kind = Kind.RPC,
    line = 8,
    column = 1)
public class ApihugServiceImpl implements ApihugService {

  final ApihugMetaService apihugMetaService;

  public ApihugServiceImpl(ApihugMetaService apihugMetaService) {
    this.apihugMetaService = apihugMetaService;
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>PredefinedRoleCheckerType: PLATFORM
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/apihug/meta/apis}
   *     <p>{@code api information of this platform}
   * @see ApihugService#apis
   */
  @Override
  public void apis(SimpleResultBuilder<String> builder) {
    builder.payload(apihugMetaService.getApis());
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>PredefinedRoleCheckerType: PLATFORM
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/apihug/meta/errors}
   *     <p>{@code api errors information of this platform}
   * @see ApihugService#errors
   */
  @Override
  public void errors(SimpleResultBuilder<String> builder) {
    builder.payload(apihugMetaService.getErrors());
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>PredefinedRoleCheckerType: PLATFORM
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/apihug/meta/authorities}
   *     <p>{@code api errors information of this platform}
   * @see ApihugService#authorities
   */
  @Override
  public void authorities(SimpleResultBuilder<String> builder) {
    builder.payload(apihugMetaService.getAuthorities());
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>PredefinedRoleCheckerType: PLATFORM
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/apihug/meta/dictionaries}
   *     <p>{@code api errors information of this platform}
   * @see ApihugService#dictionaries
   */
  @Override
  public void dictionaries(SimpleResultBuilder<String> builder) {
    builder.payload(apihugMetaService.getDictionaries());
  }

  /**
   * Authorization:
   *
   * <ul>
   *   <li>PredefinedRoleCheckerType: PLATFORM
   * </ul>
   *
   * @apiNote
   *     <p>{@code /api/apihug/meta/entities}
   *     <p>{@code api errors information of this platform}
   * @see ApihugService#entities
   */
  @Override
  public void entities(SimpleResultBuilder<String> builder) {
    builder.payload(apihugMetaService.getEntities());
  }
}
