// @formatter:off
package com.apihug.rad.domain.bootstrap.config;

import hope.common.spring.data.config.HopeDataProperties;
import hope.common.spring.data.persistence.context.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Generated;

@Generated("H.O.P.E. Infra Team")
public class RadPersistenceContext implements PersistenceContext<Long, Long> {

  @Autowired(required = false)
  protected HopeDataProperties properties;

  @Override
  public Long defaultUserId() {
    return properties != null ? properties.getDefaultUserId() : 0L;
  }

  @Override
  public Long defaultTenant() {
    return properties != null ? properties.getDefaultTenantId() : 0L;
  }

  @Override
  public Class identifierClass() {
    return Long.class;
  }

  @Override
  public Class tenantClass() {
    return Long.class;
  }

  @Override
  public String domain() {
    return "rad";
  }

  @Override
  public boolean isDefault() {
    return true;
  }
}