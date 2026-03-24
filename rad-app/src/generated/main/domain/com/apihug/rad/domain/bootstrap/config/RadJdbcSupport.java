// @formatter:off
package com.apihug.rad.domain.bootstrap.config;

import hope.common.spring.audit.AuditContext;
import hope.common.spring.data.persistence.context.PersistenceContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import javax.annotation.Generated;

@Generated("H.O.P.E. Infra Team")
public interface RadJdbcSupport {
  JdbcOperations jdbcTemplate();

  NamedParameterJdbcOperations namedJdbcTemplate();

  <Identify, Tenant> AuditContext<Identify, Tenant> auditContext();

  <Identify, Tenant> PersistenceContext<Identify, Tenant> persistenceContext();
}