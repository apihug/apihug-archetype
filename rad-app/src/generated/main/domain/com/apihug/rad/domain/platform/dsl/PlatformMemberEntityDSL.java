// @formatter:off
package com.apihug.rad.domain.platform.dsl;

import com.apihug.rad.domain.platform.PlatformMemberEntity;
import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import hope.common.persistence.Column;
import hope.common.persistence.EnumType;
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
public interface PlatformMemberEntityDSL extends DSL<PlatformMemberEntity> {
  Table table = Table.create("SYS_PLATFORM_MEMBER").as("_sys_platform_member");

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
  default Object[] parameters(PlatformMemberEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getCustomerId();
    carrier[beginIndex + 1] = entity.getPlatformRole().name();
    carrier[beginIndex + 2] = entity.getStatus().name();
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
    return PlatformMemberEntity.class;
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
    	Map.entry("CUSTOMERID", Domain.CustomerId),
    	Map.entry("PLATFORMROLE", Domain.PlatformRole),
    	Map.entry("STATUS", Domain.Status),
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
    ColumnMix CustomerId = ColumnMix.of(table, 
    	new Column().setFieldName("customerId")
    		.setName("CUSTOMER_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("客户 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix PlatformRole = ColumnMix.of(table, 
    	new Column().setFieldName("platformRole")
    		.setName("PLATFORM_ROLE")
    		.setClz("com.apihug.rad.infra.customer.CustomerPlatformTypeEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("平台角色（MEMBER/MANAGER/OWNER）")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("PLATFORM_ROLE"));

    ColumnMix Status = ColumnMix.of(table, 
    	new Column().setFieldName("status")
    		.setName("STATUS_CODE")
    		.setClz("com.apihug.rad.infra.platform.PlatformMemberStatusEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("平台成员状态")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("STATUS_CODE"));

    List<ColumnMix> ALL = List.of(CustomerId, PlatformRole, Status);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix CreatedAt = _Auditable_.CREATED_AT;

    ColumnMix CreatedBy = _Auditable_.CREATED_BY;

    ColumnMix UpdatedAt = _Auditable_.UPDATED_AT;

    ColumnMix UpdatedBy = _Auditable_.UPDATED_BY;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<PlatformMemberEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getCustomerId());
    ps.setString(2, entity.getPlatformRole().name());
    ps.setString(3, entity.getStatus().name());
    };

    RowMapper<PlatformMemberEntity> MAPPER = new RowMapper() {
      @Override
      public PlatformMemberEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final PlatformMemberEntity entity = new PlatformMemberEntity();
        entity.setId(rs.getLong(1));
        entity.setCustomerId(rs.getLong(2));
        entity.setPlatformRole(CustomerPlatformTypeEnum.NA.mapFromName(rs.getString(3)));
        entity.setStatus(PlatformMemberStatusEnum.NA.mapFromName(rs.getString(4)));
        Timestamp _5 = rs.getTimestamp(5);
        if (_5 != null) {
          entity.setCreatedAt(_5.toLocalDateTime());
        }
        entity.setCreatedBy(rs.getLong(6));
        Timestamp _7 = rs.getTimestamp(7);
        if (_7 != null) {
          entity.setUpdatedAt(_7.toLocalDateTime());
        }
        entity.setUpdatedBy(rs.getLong(8));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = null;

    Comparison LIVE = null;
  }
}
