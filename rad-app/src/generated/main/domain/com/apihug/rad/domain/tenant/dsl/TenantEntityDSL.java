// @formatter:off
package com.apihug.rad.domain.tenant.dsl;

import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

@Generated("H.O.P.E. Infra Team")
public interface TenantEntityDSL extends DSL<TenantEntity> {
  Table table = Table.create("SYS_TENANT").as("_sys_tenant");

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
  default Object[] parameters(TenantEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getTenantCode();
    carrier[beginIndex + 1] = entity.getTenantName();
    carrier[beginIndex + 2] = entity.getContactEmail();
    carrier[beginIndex + 3] = entity.getContactPhone();
    carrier[beginIndex + 4] = entity.getStatus().name();
    carrier[beginIndex + 5] = entity.getMaxUsers();
    carrier[beginIndex + 6] = entity.getMaxStorageMb();
    LocalDateTime _7 = entity.getExpiryDate();
    carrier[beginIndex + 7] = _7 == null ? null : Timestamp.valueOf(_7);
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
    return TenantEntity.class;
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
    	Map.entry("TENANTCODE", Domain.TenantCode),
    	Map.entry("TENANTNAME", Domain.TenantName),
    	Map.entry("CONTACTEMAIL", Domain.ContactEmail),
    	Map.entry("CONTACTPHONE", Domain.ContactPhone),
    	Map.entry("STATUS", Domain.Status),
    	Map.entry("MAXUSERS", Domain.MaxUsers),
    	Map.entry("MAXSTORAGEMB", Domain.MaxStorageMb),
    	Map.entry("EXPIRYDATE", Domain.ExpiryDate),
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
    ColumnMix TenantCode = ColumnMix.of(table, 
    	new Column().setFieldName("tenantCode")
    		.setName("TENANT_CODE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("租户代码")
    		.setUpdatable(true)
    		.setUnique(true)
    		.setInsertable(true)
    		.setLength(50));

    ColumnMix TenantName = ColumnMix.of(table, 
    	new Column().setFieldName("tenantName")
    		.setName("TENANT_NAME")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("租户名称")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(100));

    ColumnMix ContactEmail = ColumnMix.of(table, 
    	new Column().setFieldName("contactEmail")
    		.setName("CONTACT_EMAIL")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("联系人邮箱")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(100));

    ColumnMix ContactPhone = ColumnMix.of(table, 
    	new Column().setFieldName("contactPhone")
    		.setName("CONTACT_PHONE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("联系人电话")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(20));

    ColumnMix Status = ColumnMix.of(table, 
    	new Column().setFieldName("status")
    		.setName("STATUS_CODE")
    		.setClz("com.apihug.rad.infra.tenant.TenantStatusEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("租户状态")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("STATUS_CODE"));

    ColumnMix MaxUsers = ColumnMix.of(table, 
    	new Column().setFieldName("maxUsers")
    		.setName("MAX_USERS")
    		.setClz("java.lang.Integer")
    		.setType(Types.INTEGER)
    		.setDescription("最大用户数")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("MAX_USERS"));

    ColumnMix MaxStorageMb = ColumnMix.of(table, 
    	new Column().setFieldName("maxStorageMb")
    		.setName("MAX_STORAGE_MB")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("最大存储空间（MB）")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("MAX_STORAGE_MB"));

    ColumnMix ExpiryDate = ColumnMix.of(table, 
    	new Column().setFieldName("expiryDate")
    		.setName("EXPIRY_DATE")
    		.setClz("java.time.LocalDateTime")
    		.setType(Types.TIMESTAMP)
    		.setDescription("到期时间")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    List<ColumnMix> ALL = List.of(TenantCode, TenantName, ContactEmail, ContactPhone, Status, MaxUsers, MaxStorageMb, ExpiryDate);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix CreatedAt = _Auditable_.CREATED_AT;

    ColumnMix CreatedBy = _Auditable_.CREATED_BY;

    ColumnMix UpdatedAt = _Auditable_.UPDATED_AT;

    ColumnMix UpdatedBy = _Auditable_.UPDATED_BY;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<TenantEntity> SETTER = 
    (ps, entity) -> {
    ps.setString(1, entity.getTenantCode());
    ps.setString(2, entity.getTenantName());
    ps.setString(3, entity.getContactEmail());
    ps.setString(4, entity.getContactPhone());
    ps.setString(5, entity.getStatus().name());
    ps.setInt(6, entity.getMaxUsers());
    ps.setLong(7, entity.getMaxStorageMb());
    ps.setTimestamp(8, Timestamp.valueOf(entity.getExpiryDate()));
    };

    RowMapper<TenantEntity> MAPPER = new RowMapper() {
      @Override
      public TenantEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final TenantEntity entity = new TenantEntity();
        entity.setId(rs.getLong(1));
        entity.setTenantCode(rs.getString(2));
        entity.setTenantName(rs.getString(3));
        entity.setContactEmail(rs.getString(4));
        entity.setContactPhone(rs.getString(5));
        entity.setStatus(TenantStatusEnum.NA.mapFromName(rs.getString(6)));
        entity.setMaxUsers(rs.getInt(7));
        entity.setMaxStorageMb(rs.getLong(8));
        Timestamp _9 = rs.getTimestamp(9);
        if (_9 != null) {
          entity.setExpiryDate(_9.toLocalDateTime());
        }
        Timestamp _10 = rs.getTimestamp(10);
        if (_10 != null) {
          entity.setCreatedAt(_10.toLocalDateTime());
        }
        entity.setCreatedBy(rs.getLong(11));
        Timestamp _12 = rs.getTimestamp(12);
        if (_12 != null) {
          entity.setUpdatedAt(_12.toLocalDateTime());
        }
        entity.setUpdatedBy(rs.getLong(13));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = null;

    Comparison LIVE = null;
  }
}
