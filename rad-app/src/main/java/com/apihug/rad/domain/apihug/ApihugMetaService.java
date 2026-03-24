package com.apihug.rad.domain.apihug;

import hope.common.meta.annotation.Template;
import hope.common.meta.artifact.Artifact;
import hope.common.meta.constant.authority.DomainAuthority;
import hope.common.meta.constant.dictionary.DomainDictionary;
import hope.common.meta.constant.error.DomainError;
import hope.common.runtime.RuntimeContext;
import hope.common.service.Module;
import hope.common.utils.PathResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import static java.nio.charset.StandardCharsets.UTF_8;

@SuppressWarnings("Duplicates")
@Service
@Template(type = Template.Type.SERVICE, usage = "Apihug meta information service", percentage = 100)
public class ApihugMetaService {

  protected static final String EMPTY = "{}";
  protected Logger logger = LoggerFactory.getLogger(ApihugMetaService.class);
  Lazy<String> apis = Lazy.of(this::loadApis);

  Lazy<String> authorities = Lazy.of(this::loadAuthorities);
  Lazy<String> dictionaries = Lazy.of(this::loadDictionaries);
  Lazy<String> errors = Lazy.of(this::loadErrors);
  Lazy<String> entities = Lazy.of(this::loadEntities);

  public String getApis() {
    return apis.get();
  }

  public String getAuthorities() {
    return authorities.get();
  }

  public String getDictionaries() {
    return dictionaries.get();
  }

  public String getErrors() {
    return errors.get();
  }

  public String getEntities() {
    return entities.get();
  }

  /**
   * @see DomainAuthority
   * @return
   */
  String loadAuthorities() {
    return loadResource("authorities");
  }

  /**
   * @see DomainDictionary
   * @return
   */
  String loadDictionaries() {
    return loadResource("dictionaries");
  }

  /**
   * @see DomainError
   * @return
   */
  String loadErrors() {
    return loadResource("errors");
  }

  /**
   * @see hope.common.service.persistence.PersistenceContext
   * @return
   */
  String loadEntities() {
    return loadResource("entities");
  }

  String loadResource(final String kind) {
    Module protoModule = RuntimeContext.INSTANCE.getModule();
    if (protoModule == null) {
      logger.error("No proto module linked, no resources for {}", kind);
      return EMPTY;
    }
    final Artifact artifact = protoModule.project().getArtifact();
    if (artifact == null) {
      logger.error("No artifact linked, no resources for {}", kind);
      return EMPTY;
    }
    String path = null;
    switch (kind) {
      case "entities" -> path = PathResolver.latestEntity(artifact);
      case "dictionaries" -> path = PathResolver.metaOfDictionaries(artifact);
      case "errors" -> path = PathResolver.metaOfErrors(artifact);
      case "authorities" -> path = PathResolver.metaOfAuthorities(artifact);
      case "apis" -> path = PathResolver.latestApiHug(artifact);
    }
    if (path != null) {
      try {
        return StreamUtils.copyToString(
            getClass().getClassLoader().getResource(path).openStream(), UTF_8);
      } catch (Throwable throwable) {
        logger.warn("FAIL_LOAD {}", path, throwable);
      }
    }
    return EMPTY;
  }

  String loadApis() {
    return loadResource("entities");
  }
}
