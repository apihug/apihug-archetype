// @formatter:off
package com.apihug.rad.domain.department.dsl;

import com.apihug.rad.domain.department.DepartmentEmployeeEntity;
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
public interface DepartmentEmployeeEntityDSL extends DSL<DepartmentEmployeeEntity> {
  Table table = Table.create("SYS_DEPARTMENT_EMPLOYEE").as("_sys_department_employee");

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
  default Object[] parameters(DepartmentEmployeeEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getEmployeeId();
    carrier[beginIndex + 1] = entity.getDepartmentId();
    carrier[beginIndex + 2] = entity.getPosition();
    carrier[beginIndex + 3] = entity.getIsPrimary();
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
    return DepartmentEmployeeEntity.class;
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
    	Map.entry("EMPLOYEEID", Domain.EmployeeId),
    	Map.entry("DEPARTMENTID", Domain.DepartmentId),
    	Map.entry("POSITION", Domain.Position),
    	Map.entry("ISPRIMARY", Domain.IsPrimary),
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
    ColumnMix EmployeeId = ColumnMix.of(table, 
    	new Column().setFieldName("employeeId")
    		.setName("EMPLOYEE_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("员工 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix DepartmentId = ColumnMix.of(table, 
    	new Column().setFieldName("departmentId")
    		.setName("DEPARTMENT_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("部门 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix Position = ColumnMix.of(table, 
    	new Column().setFieldName("position")
    		.setName("POSITION")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("职位")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(100));

    ColumnMix IsPrimary = ColumnMix.of(table, 
    	new Column().setFieldName("isPrimary")
    		.setName("IS_PRIMARY")
    		.setClz("java.lang.Boolean")
    		.setType(Types.TINYINT)
    		.setDescription("是否主部门")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("IS_PRIMARY"));

    List<ColumnMix> ALL = List.of(EmployeeId, DepartmentId, Position, IsPrimary);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix CreatedAt = _Auditable_.CREATED_AT;

    ColumnMix CreatedBy = _Auditable_.CREATED_BY;

    ColumnMix UpdatedAt = _Auditable_.UPDATED_AT;

    ColumnMix UpdatedBy = _Auditable_.UPDATED_BY;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<DepartmentEmployeeEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getEmployeeId());
    ps.setLong(2, entity.getDepartmentId());
    ps.setString(3, entity.getPosition());
    ps.setBoolean(4, entity.getIsPrimary());
    };

    RowMapper<DepartmentEmployeeEntity> MAPPER = new RowMapper() {
      @Override
      public DepartmentEmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final DepartmentEmployeeEntity entity = new DepartmentEmployeeEntity();
        entity.setId(rs.getLong(1));
        entity.setEmployeeId(rs.getLong(2));
        entity.setDepartmentId(rs.getLong(3));
        entity.setPosition(rs.getString(4));
        entity.setIsPrimary(rs.getBoolean(5));
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
