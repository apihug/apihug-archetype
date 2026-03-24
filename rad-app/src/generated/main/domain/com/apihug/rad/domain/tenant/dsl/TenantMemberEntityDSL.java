// @formatter:off
package com.apihug.rad.domain.tenant.dsl;

import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.infra.tenant.MemberRoleEnum;
import com.apihug.rad.infra.tenant.MemberTypeEnum;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
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
public interface TenantMemberEntityDSL extends DSL<TenantMemberEntity> {
  Table table = Table.create("SYS_TENANT_MEMBER").as("_sys_tenant_member");

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
  default Object[] parameters(TenantMemberEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getCustomerId();
    carrier[beginIndex + 1] = entity.getTenantId();
    carrier[beginIndex + 2] = entity.getIsDefault();
    carrier[beginIndex + 3] = entity.getMemberType().name();
    carrier[beginIndex + 4] = entity.getMemberRole().name();
    carrier[beginIndex + 5] = entity.getStatus().name();
    carrier[beginIndex + 6] = entity.getDepartmentId();
    carrier[beginIndex + 7] = entity.getPosition();
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
    return TenantMemberEntity.class;
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
    	Map.entry("TENANTID", Domain.TenantId),
    	Map.entry("ISDEFAULT", Domain.IsDefault),
    	Map.entry("MEMBERTYPE", Domain.MemberType),
    	Map.entry("MEMBERROLE", Domain.MemberRole),
    	Map.entry("STATUS", Domain.Status),
    	Map.entry("DEPARTMENTID", Domain.DepartmentId),
    	Map.entry("POSITION", Domain.Position),
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

    ColumnMix TenantId = ColumnMix.of(table, 
    	new Column().setFieldName("tenantId")
    		.setName("TENANT_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("租户 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix IsDefault = ColumnMix.of(table, 
    	new Column().setFieldName("isDefault")
    		.setName("IS_DEFAULT")
    		.setClz("java.lang.Boolean")
    		.setType(Types.TINYINT)
    		.setDescription("是否默认租户")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("IS_DEFAULT"));

    ColumnMix MemberType = ColumnMix.of(table, 
    	new Column().setFieldName("memberType")
    		.setName("MEMBER_TYPE")
    		.setClz("com.apihug.rad.infra.tenant.MemberTypeEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("成员类型（全职/兼职/外包/实习）")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("MEMBER_TYPE"));

    ColumnMix MemberRole = ColumnMix.of(table, 
    	new Column().setFieldName("memberRole")
    		.setName("MEMBER_ROLE")
    		.setClz("com.apihug.rad.infra.tenant.MemberRoleEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("成员角色（拥有者/管理员/普通成员）")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("MEMBER_ROLE"));

    ColumnMix Status = ColumnMix.of(table, 
    	new Column().setFieldName("status")
    		.setName("STATUS_CODE")
    		.setClz("com.apihug.rad.infra.tenant.TenantMemberStatusEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("在租户内的状态")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("STATUS_CODE"));

    ColumnMix DepartmentId = ColumnMix.of(table, 
    	new Column().setFieldName("departmentId")
    		.setName("DEPARTMENT_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("所属部门 ID")
    		.setUpdatable(true)
    		.setNullable(true)
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

    List<ColumnMix> ALL = List.of(CustomerId, TenantId, IsDefault, MemberType, MemberRole, Status, DepartmentId, Position);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix CreatedAt = _Auditable_.CREATED_AT;

    ColumnMix CreatedBy = _Auditable_.CREATED_BY;

    ColumnMix UpdatedAt = _Auditable_.UPDATED_AT;

    ColumnMix UpdatedBy = _Auditable_.UPDATED_BY;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<TenantMemberEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getCustomerId());
    ps.setLong(2, entity.getTenantId());
    ps.setBoolean(3, entity.getIsDefault());
    ps.setString(4, entity.getMemberType().name());
    ps.setString(5, entity.getMemberRole().name());
    ps.setString(6, entity.getStatus().name());
    ps.setLong(7, entity.getDepartmentId());
    ps.setString(8, entity.getPosition());
    };

    RowMapper<TenantMemberEntity> MAPPER = new RowMapper() {
      @Override
      public TenantMemberEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final TenantMemberEntity entity = new TenantMemberEntity();
        entity.setId(rs.getLong(1));
        entity.setCustomerId(rs.getLong(2));
        entity.setTenantId(rs.getLong(3));
        entity.setIsDefault(rs.getBoolean(4));
        entity.setMemberType(MemberTypeEnum.NA.mapFromName(rs.getString(5)));
        entity.setMemberRole(MemberRoleEnum.NA.mapFromName(rs.getString(6)));
        entity.setStatus(TenantMemberStatusEnum.NA.mapFromName(rs.getString(7)));
        entity.setDepartmentId(rs.getLong(8));
        entity.setPosition(rs.getString(9));
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
