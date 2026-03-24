// @formatter:off
package com.apihug.rad.domain.tenant.dsl;

import com.apihug.rad.domain.tenant.MemberRoleEntity;
import hope.common.persistence.Column;
import hope.common.persistence.Types;
import hope.common.spring.data.persistence.repository.dsl.DSL;
import hope.common.spring.data.persistence.repository.sql.ColumnMix;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

@Generated("H.O.P.E. Infra Team")
public interface MemberRoleEntityDSL extends DSL<MemberRoleEntity> {
  Table table = Table.create("SYS_MEMBER_ROLE").as("_sys_member_role");

  @Override
  default Table table() {
    return table;
  }

  @Override
  default boolean isIdentifiable() {
    return true;
  }

  @Override
  default ColumnMix idColumn() {
    return _Identifiable_.ID;
  }

  @Override
  default boolean isAuditable() {
    return false;
  }

  @Override
  default boolean isSoftDeletable() {
    return false;
  }

  @Override
  default boolean isVersionable() {
    return false;
  }

  @Override
  default boolean isTenantable() {
    return false;
  }

  @Override
  default Map<String, ColumnMix> fieldColumnMap() {
    return ColumnsMap.field2Column;
  }

  @Override
  default Object[] parameters(MemberRoleEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getMemberId();
    carrier[beginIndex + 1] = entity.getRoleId();
    return carrier;
  }

  @Override
  default String domain() {
    return "rad";
  }

  @Override
  default boolean isDefault() {
    return true;
  }

  @Override
  default Class domainClass() {
    return MemberRoleEntity.class;
  }

  interface _Identifiable_ {
    ColumnMix ID = ColumnMix.of(table, 
    	new Column()
    		.setName("ID")
    		.setFieldName("id")
    		.setClz("java.lang.Long")
    		.setUnique(true)
    		.setInsertable(false)
    		.setUpdatable(false)
    		.setSortable(true)
    		.setType(Types.BIGINT));
  }

  interface ColumnsMap {
    Map<String, ColumnMix> field2Column = 
     Map.ofEntries(

    	Map.entry("ID", _Identifiable_.ID),
    	Map.entry("MEMBERID", Domain.MemberId),
    	Map.entry("ROLEID", Domain.RoleId)
    );
  }

  interface Domain {
    ColumnMix MemberId = ColumnMix.of(table, 
    	new Column().setFieldName("memberId")
    		.setName("MEMBER_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("租户成员 ID (SYS_TENANT_MEMBER.id)")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix RoleId = ColumnMix.of(table, 
    	new Column().setFieldName("roleId")
    		.setName("ROLE_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("角色 ID (SYS_ROLE.id)")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    List<ColumnMix> ALL = List.of(MemberId, RoleId);

    ColumnMix Id = _Identifiable_.ID;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<MemberRoleEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getMemberId());
    ps.setLong(2, entity.getRoleId());
    };

    RowMapper<MemberRoleEntity> MAPPER = new RowMapper() {
      @Override
      public MemberRoleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final MemberRoleEntity entity = new MemberRoleEntity();
        entity.setId(rs.getLong(1));
        entity.setMemberId(rs.getLong(2));
        entity.setRoleId(rs.getLong(3));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = null;

    Comparison LIVE = null;
  }
}
