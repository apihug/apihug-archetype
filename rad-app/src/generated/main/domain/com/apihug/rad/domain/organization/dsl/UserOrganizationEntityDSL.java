// @formatter:off
package com.apihug.rad.domain.organization.dsl;

import com.apihug.rad.domain.organization.UserOrganizationEntity;
import hope.common.persistence.Column;
import hope.common.persistence.Types;
import hope.common.spring.data.persistence.repository.dsl.DSL;
import hope.common.spring.data.persistence.repository.sql.ColumnMix;
import hope.common.spring.data.persistence.wire.Auditable;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

@Generated("H.O.P.E. Infra Team")
public interface UserOrganizationEntityDSL extends DSL<UserOrganizationEntity> {
  Table table = Table.create("SYS_USER_ORGANIZATION").as("_sys_user_organization");

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
    return true;
  }

  @Override
  default Auditable auditable() {
    return _Auditable_.INSTANCE;
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
  default Object[] parameters(UserOrganizationEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getUserId();
    carrier[beginIndex + 1] = entity.getOrganizationId();
    carrier[beginIndex + 2] = entity.getIsDefault();
    carrier[beginIndex + 3] = entity.getDepartmentId();
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
    return UserOrganizationEntity.class;
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

  interface _Auditable_ extends Auditable {
    _Auditable_ INSTANCE = new _Auditable_() {};

    ColumnMix CREATED_AT = ColumnMix.of(table, 
    	new Column()
    		.setName("CREATED_AT")
    		.setFieldName("createdAt")
    		.setClz("java.time.LocalDateTime")
    		.setType(Types.TIMESTAMP)
    		.setUpdatable(false)
    		.setSortable(true)
    		.setDescription("Created time of the record"));

    ColumnMix CREATED_BY = ColumnMix.of(table, 
    	new Column()
    		.setName("CREATED_BY")
    		.setFieldName("createdBy")
    		.setClz("java.lang.Long")
    		.setType(Types.INTEGER)
    		.setDescription("Identify of who create the record"));

    ColumnMix UPDATED_AT = ColumnMix.of(table, 
    	new Column()
    		.setName("UPDATED_AT")
    		.setFieldName("updatedAt")
    		.setClz("java.time.LocalDateTime")
    		.setType(Types.TIMESTAMP)
    		.setSortable(true)
    		.setDescription("Updated time of the record"));

    ColumnMix UPDATED_BY = ColumnMix.of(table, 
    	new Column()
    		.setName("UPDATED_BY")
    		.setFieldName("updatedBy")
    		.setClz("java.lang.Long")
    		.setType(Types.INTEGER)
    		.setDescription("Identify of who update the record"));

    @Override
    default ColumnMix createdAt() {
      return CREATED_AT;
    }

    @Override
    default ColumnMix createdBy() {
      return CREATED_BY;
    }

    @Override
    default ColumnMix updatedAt() {
      return UPDATED_AT;
    }

    @Override
    default ColumnMix updatedBy() {
      return UPDATED_BY;
    }
  }

  interface ColumnsMap {
    Map<String, ColumnMix> field2Column = 
     Map.ofEntries(

    	Map.entry("ID", _Identifiable_.ID),
    	Map.entry("USERID", Domain.UserId),
    	Map.entry("ORGANIZATIONID", Domain.OrganizationId),
    	Map.entry("ISDEFAULT", Domain.IsDefault),
    	Map.entry("DEPARTMENTID", Domain.DepartmentId),
    	// Auditable,
    	Map.entry("CREATED_AT", _Auditable_.CREATED_AT),
    	Map.entry("CREATED_BY", _Auditable_.CREATED_BY),
    	Map.entry("UPDATED_AT", _Auditable_.UPDATED_AT),
    	Map.entry("UPDATED_BY", _Auditable_.UPDATED_BY),
    	Map.entry("CREATEDAT", _Auditable_.CREATED_AT),
    	Map.entry("CREATEDBY", _Auditable_.CREATED_BY),
    	Map.entry("UPDATEDAT", _Auditable_.UPDATED_AT),
    	Map.entry("UPDATEDBY", _Auditable_.UPDATED_BY)
    );
  }

  interface Domain {
    ColumnMix UserId = ColumnMix.of(table, 
    	new Column().setFieldName("userId")
    		.setName("USER_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("用户 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix OrganizationId = ColumnMix.of(table, 
    	new Column().setFieldName("organizationId")
    		.setName("ORGANIZATION_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("组织 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix IsDefault = ColumnMix.of(table, 
    	new Column().setFieldName("isDefault")
    		.setName("IS_DEFAULT")
    		.setClz("java.lang.Boolean")
    		.setType(Types.TINYINT)
    		.setDescription("是否默认组织")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("IS_DEFAULT"));

    ColumnMix DepartmentId = ColumnMix.of(table, 
    	new Column().setFieldName("departmentId")
    		.setName("DEPARTMENT_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("部门 ID")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    List<ColumnMix> ALL = List.of(UserId, OrganizationId, IsDefault, DepartmentId);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix CreatedAt = _Auditable_.CREATED_AT;

    ColumnMix CreatedBy = _Auditable_.CREATED_BY;

    ColumnMix UpdatedAt = _Auditable_.UPDATED_AT;

    ColumnMix UpdatedBy = _Auditable_.UPDATED_BY;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<UserOrganizationEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getUserId());
    ps.setLong(2, entity.getOrganizationId());
    ps.setBoolean(3, entity.getIsDefault());
    ps.setLong(4, entity.getDepartmentId());
    };

    RowMapper<UserOrganizationEntity> MAPPER = new RowMapper() {
      @Override
      public UserOrganizationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final UserOrganizationEntity entity = new UserOrganizationEntity();
        entity.setId(rs.getLong(1));
        entity.setUserId(rs.getLong(2));
        entity.setOrganizationId(rs.getLong(3));
        entity.setIsDefault(rs.getBoolean(4));
        entity.setDepartmentId(rs.getLong(5));
        Timestamp _6 = rs.getTimestamp(6);
        if (_6 != null) {
          entity.setCreatedAt(_6.toLocalDateTime());
        }
        entity.setCreatedBy(rs.getLong(7));
        Timestamp _8 = rs.getTimestamp(8);
        if (_8 != null) {
          entity.setUpdatedAt(_8.toLocalDateTime());
        }
        entity.setUpdatedBy(rs.getLong(9));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = null;

    Comparison LIVE = null;
  }
}
