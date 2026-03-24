// @formatter:off
package com.apihug.rad.domain.department.dsl;

import com.apihug.rad.domain.department.DepartmentEntity;
import com.apihug.rad.infra.department.DeptStatusEnum;
import hope.common.persistence.Column;
import hope.common.persistence.EnumType;
import hope.common.persistence.Types;
import hope.common.spring.data.persistence.repository.dsl.DSL;
import hope.common.spring.data.persistence.repository.sql.ColumnMix;
import hope.common.spring.data.persistence.wire.Auditable;
import hope.common.spring.data.persistence.wire.Deletable;
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
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

@Generated("H.O.P.E. Infra Team")
public interface DepartmentEntityDSL extends DSL<DepartmentEntity> {
  Table table = Table.create("SYS_DEPARTMENT").as("_sys_department");

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
    return true;
  }

  @Override
  default Deletable deletable() {
    return _Deletable_.INSTANCE;
  }

  @Override
  default boolean isVersionable() {
    return true;
  }

  @Override
  default ColumnMix versionColumn() {
    return _Versionable_.VERSION;
  }

  @Override
  default boolean isTenantable() {
    return true;
  }

  @Override
  default ColumnMix tenantColumn() {
    return _Tenantable_.TENANT_ID;
  }

  @Override
  default Map<String, ColumnMix> fieldColumnMap() {
    return ColumnsMap.field2Column;
  }

  @Override
  default Object[] parameters(DepartmentEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getParentId();
    carrier[beginIndex + 1] = entity.getDeptCode();
    carrier[beginIndex + 2] = entity.getDeptName();
    carrier[beginIndex + 3] = entity.getSortOrder();
    carrier[beginIndex + 4] = entity.getManagerId();
    carrier[beginIndex + 5] = entity.getStatus().name();
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
    return DepartmentEntity.class;
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

  interface _Deletable_ extends Deletable {
    _Deletable_ INSTANCE = new _Deletable_() {};

    ColumnMix DELETED = ColumnMix.of(table, 
    	new Column()
    		.setName("DELETED")
    		.setFieldName("deleted")
    		.setClz("java.lang.Boolean")
    		.setType(Types.BIT)
    		.setDescription("Deleted flag for soft delete"));

    ColumnMix DELETED_AT = ColumnMix.of(table, 
    	new Column()
    		.setName("DELETED_AT")
    		.setFieldName("deletedAt")
    		.setClz("java.time.LocalDateTime")
    		.setType(Types.TIMESTAMP)
    		.setDescription("Deleted timestamp of this record"));

    ColumnMix DELETED_BY = ColumnMix.of(table, 
    	new Column()
    		.setName("DELETED_BY")
    		.setFieldName("deletedBy")
    		.setClz("java.lang.Long")
    		.setType(Types.INTEGER)
    		.setDescription("Identify of who delete this record"));

    @Override
    default ColumnMix deleted() {
      return DELETED;
    }

    @Override
    default ColumnMix deletedAt() {
      return DELETED_AT;
    }

    @Override
    default ColumnMix deletedBy() {
      return DELETED_BY;
    }
  }

  interface _Versionable_ {
    ColumnMix VERSION = ColumnMix.of(table, 
    	new Column()
    		.setName("VERSION")
    		.setFieldName("version")
    		.setClz("java.lang.Long")
    		.setSortable(true)
    		.setType(Types.BIGINT));
  }

  interface _Tenantable_ {
    ColumnMix TENANT_ID = ColumnMix.of(table, 
    	new Column()
    		.setName("TENANT_ID")
    		.setFieldName("tenantId")
    		.setClz("java.lang.Long")
    		.setUpdatable(false)
    		.setType(Types.INTEGER));
  }

  interface ColumnsMap {
    Map<String, ColumnMix> field2Column = 
     Map.ofEntries(

    	Map.entry("ID", _Identifiable_.ID),
    	Map.entry("PARENTID", Domain.ParentId),
    	Map.entry("DEPTCODE", Domain.DeptCode),
    	Map.entry("DEPTNAME", Domain.DeptName),
    	Map.entry("SORTORDER", Domain.SortOrder),
    	Map.entry("MANAGERID", Domain.ManagerId),
    	Map.entry("STATUS", Domain.Status),
    	// Auditable,
    	Map.entry("CREATED_AT", _Auditable_.CREATED_AT),
    	Map.entry("CREATED_BY", _Auditable_.CREATED_BY),
    	Map.entry("UPDATED_AT", _Auditable_.UPDATED_AT),
    	Map.entry("UPDATED_BY", _Auditable_.UPDATED_BY),
    	Map.entry("CREATEDAT", _Auditable_.CREATED_AT),
    	Map.entry("CREATEDBY", _Auditable_.CREATED_BY),
    	Map.entry("UPDATEDAT", _Auditable_.UPDATED_AT),
    	Map.entry("UPDATEDBY", _Auditable_.UPDATED_BY),
    	// Deletable,
    	Map.entry("DELETED", _Deletable_.DELETED),
    	Map.entry("DELETEDAT", _Deletable_.DELETED_AT),
    	Map.entry("DELETEDBY", _Deletable_.DELETED_BY),
    	Map.entry("DELETED_AT", _Deletable_.DELETED_AT),
    	Map.entry("DELETED_BY", _Deletable_.DELETED_BY),
    	// Versionable,
    	Map.entry("VERSION", _Versionable_.VERSION),
    	// Tenantable,
    	Map.entry("TENANTID", _Tenantable_.TENANT_ID),
    	Map.entry("TENANT_ID", _Tenantable_.TENANT_ID)
    );
  }

  interface Domain {
    ColumnMix ParentId = ColumnMix.of(table, 
    	new Column().setFieldName("parentId")
    		.setName("PARENT_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("父部门 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("PARENT_ID"));

    ColumnMix DeptCode = ColumnMix.of(table, 
    	new Column().setFieldName("deptCode")
    		.setName("DEPT_CODE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("部门代码")
    		.setUpdatable(true)
    		.setUnique(true)
    		.setInsertable(true)
    		.setLength(50));

    ColumnMix DeptName = ColumnMix.of(table, 
    	new Column().setFieldName("deptName")
    		.setName("DEPT_NAME")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("部门名称")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(100));

    ColumnMix SortOrder = ColumnMix.of(table, 
    	new Column().setFieldName("sortOrder")
    		.setName("SORT_ORDER")
    		.setClz("java.lang.Integer")
    		.setType(Types.INTEGER)
    		.setDescription("排序顺序")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("SORT_ORDER"));

    ColumnMix ManagerId = ColumnMix.of(table, 
    	new Column().setFieldName("managerId")
    		.setName("MANAGER_ID")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("部门负责人 ID")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(50));

    ColumnMix Status = ColumnMix.of(table, 
    	new Column().setFieldName("status")
    		.setName("STATUS_CODE")
    		.setClz("com.apihug.rad.infra.department.DeptStatusEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("部门状态")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("STATUS_CODE"));

    List<ColumnMix> ALL = List.of(ParentId, DeptCode, DeptName, SortOrder, ManagerId, Status);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix CreatedAt = _Auditable_.CREATED_AT;

    ColumnMix CreatedBy = _Auditable_.CREATED_BY;

    ColumnMix UpdatedAt = _Auditable_.UPDATED_AT;

    ColumnMix UpdatedBy = _Auditable_.UPDATED_BY;

    ColumnMix Deleted = _Deletable_.DELETED;

    ColumnMix DeletedAt = _Deletable_.DELETED_AT;

    ColumnMix DeletedBy = _Deletable_.DELETED_BY;

    ColumnMix Version = _Versionable_.VERSION;

    ColumnMix TenantId = _Tenantable_.TENANT_ID;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<DepartmentEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getParentId());
    ps.setString(2, entity.getDeptCode());
    ps.setString(3, entity.getDeptName());
    ps.setInt(4, entity.getSortOrder());
    ps.setString(5, entity.getManagerId());
    ps.setString(6, entity.getStatus().name());
    };

    RowMapper<DepartmentEntity> MAPPER = new RowMapper() {
      @Override
      public DepartmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final DepartmentEntity entity = new DepartmentEntity();
        entity.setId(rs.getLong(1));
        entity.setParentId(rs.getLong(2));
        entity.setDeptCode(rs.getString(3));
        entity.setDeptName(rs.getString(4));
        entity.setSortOrder(rs.getInt(5));
        entity.setManagerId(rs.getString(6));
        entity.setStatus(DeptStatusEnum.NA.mapFromName(rs.getString(7)));
        Timestamp _8 = rs.getTimestamp(8);
        if (_8 != null) {
          entity.setCreatedAt(_8.toLocalDateTime());
        }
        entity.setCreatedBy(rs.getLong(9));
        Timestamp _10 = rs.getTimestamp(10);
        if (_10 != null) {
          entity.setUpdatedAt(_10.toLocalDateTime());
        }
        entity.setUpdatedBy(rs.getLong(11));
        Boolean _12 = rs.getBoolean(12);
        if (_12 != null) {
        entity.setDeleted(_12);
        } else {
        entity.setDeleted(false);
        }
        Timestamp _13 = rs.getTimestamp(13);
        if (_13 != null) {
          entity.setDeletedAt(_13.toLocalDateTime());
        }
        entity.setDeletedBy(rs.getLong(14));
        entity.setVersion(rs.getLong(15));
        entity.setTenantId(rs.getLong(16));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = _Tenantable_.TENANT_ID.column().isEqualTo(SQL.bindMarker());

    Comparison LIVE = _Deletable_.DELETED.column().isEqualTo(SQL.literalOf(false));
  }
}
