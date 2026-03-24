// @formatter:off
package com.apihug.rad.domain.role.dsl;

import com.apihug.rad.domain.role.RoleMenuEntity;
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
public interface RoleMenuEntityDSL extends DSL<RoleMenuEntity> {
  Table table = Table.create("SYS_ROLE_MENU").as("_sys_role_menu");

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
  default Object[] parameters(RoleMenuEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getRoleId();
    carrier[beginIndex + 1] = entity.getMenuId();
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
    return RoleMenuEntity.class;
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
    	Map.entry("ROLEID", Domain.RoleId),
    	Map.entry("MENUID", Domain.MenuId)
    );
  }

  interface Domain {
    ColumnMix RoleId = ColumnMix.of(table, 
    	new Column().setFieldName("roleId")
    		.setName("ROLE_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("角色 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix MenuId = ColumnMix.of(table, 
    	new Column().setFieldName("menuId")
    		.setName("MENU_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("菜单 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    List<ColumnMix> ALL = List.of(RoleId, MenuId);

    ColumnMix Id = _Identifiable_.ID;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<RoleMenuEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getRoleId());
    ps.setLong(2, entity.getMenuId());
    };

    RowMapper<RoleMenuEntity> MAPPER = new RowMapper() {
      @Override
      public RoleMenuEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final RoleMenuEntity entity = new RoleMenuEntity();
        entity.setId(rs.getLong(1));
        entity.setRoleId(rs.getLong(2));
        entity.setMenuId(rs.getLong(3));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = null;

    Comparison LIVE = null;
  }
}
