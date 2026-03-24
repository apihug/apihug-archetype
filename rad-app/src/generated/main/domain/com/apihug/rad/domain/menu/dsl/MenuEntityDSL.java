// @formatter:off
package com.apihug.rad.domain.menu.dsl;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import com.apihug.rad.infra.menu.MenuTypeEnum;
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
public interface MenuEntityDSL extends DSL<MenuEntity> {
  Table table = Table.create("SYS_MENU").as("_sys_menu");

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
  default Object[] parameters(MenuEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getParentId();
    carrier[beginIndex + 1] = entity.getMenuCode();
    carrier[beginIndex + 2] = entity.getMenuName();
    carrier[beginIndex + 3] = entity.getPath();
    carrier[beginIndex + 4] = entity.getIcon();
    carrier[beginIndex + 5] = entity.getSortOrder();
    carrier[beginIndex + 6] = entity.getMenuType().name();
    carrier[beginIndex + 7] = entity.getPermissionCode();
    carrier[beginIndex + 8] = entity.getStatus().name();
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
    return MenuEntity.class;
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
    	Map.entry("MENUCODE", Domain.MenuCode),
    	Map.entry("MENUNAME", Domain.MenuName),
    	Map.entry("PATH", Domain.Path),
    	Map.entry("ICON", Domain.Icon),
    	Map.entry("SORTORDER", Domain.SortOrder),
    	Map.entry("MENUTYPE", Domain.MenuType),
    	Map.entry("PERMISSIONCODE", Domain.PermissionCode),
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
    		.setDescription("父菜单 ID")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("PARENT_ID"));

    ColumnMix MenuCode = ColumnMix.of(table, 
    	new Column().setFieldName("menuCode")
    		.setName("MENU_CODE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("菜单代码")
    		.setUpdatable(true)
    		.setUnique(true)
    		.setInsertable(true)
    		.setLength(50));

    ColumnMix MenuName = ColumnMix.of(table, 
    	new Column().setFieldName("menuName")
    		.setName("MENU_NAME")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("菜单名称")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(100));

    ColumnMix Path = ColumnMix.of(table, 
    	new Column().setFieldName("path")
    		.setName("PATH")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("菜单路径")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix Icon = ColumnMix.of(table, 
    	new Column().setFieldName("icon")
    		.setName("ICON")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("菜单图标")
    		.setUpdatable(true)
    		.setNullable(true)
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

    ColumnMix MenuType = ColumnMix.of(table, 
    	new Column().setFieldName("menuType")
    		.setName("MENU_TYPE")
    		.setClz("com.apihug.rad.infra.menu.MenuTypeEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("菜单类型")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("MENU_TYPE"));

    ColumnMix PermissionCode = ColumnMix.of(table, 
    	new Column().setFieldName("permissionCode")
    		.setName("PERMISSION_CODE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("关联的权限代码")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(100));

    ColumnMix Status = ColumnMix.of(table, 
    	new Column().setFieldName("status")
    		.setName("STATUS_CODE")
    		.setClz("com.apihug.rad.infra.menu.MenuStatusEnum")
    		.setType(Types.VARCHAR)
    		.setDescription("菜单状态")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(20)
    		.setEnumType(EnumType.STRING)
    		.setDefaultValue("STATUS_CODE"));

    List<ColumnMix> ALL = List.of(ParentId, MenuCode, MenuName, Path, Icon, SortOrder, MenuType, PermissionCode, Status);

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
    ParameterizedPreparedStatementSetter<MenuEntity> SETTER = 
    (ps, entity) -> {
    ps.setLong(1, entity.getParentId());
    ps.setString(2, entity.getMenuCode());
    ps.setString(3, entity.getMenuName());
    ps.setString(4, entity.getPath());
    ps.setString(5, entity.getIcon());
    ps.setInt(6, entity.getSortOrder());
    ps.setString(7, entity.getMenuType().name());
    ps.setString(8, entity.getPermissionCode());
    ps.setString(9, entity.getStatus().name());
    };

    RowMapper<MenuEntity> MAPPER = new RowMapper() {
      @Override
      public MenuEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final MenuEntity entity = new MenuEntity();
        entity.setId(rs.getLong(1));
        entity.setParentId(rs.getLong(2));
        entity.setMenuCode(rs.getString(3));
        entity.setMenuName(rs.getString(4));
        entity.setPath(rs.getString(5));
        entity.setIcon(rs.getString(6));
        entity.setSortOrder(rs.getInt(7));
        entity.setMenuType(MenuTypeEnum.NA.mapFromName(rs.getString(8)));
        entity.setPermissionCode(rs.getString(9));
        entity.setStatus(MenuStatusEnum.NA.mapFromName(rs.getString(10)));
        Timestamp _11 = rs.getTimestamp(11);
        if (_11 != null) {
          entity.setCreatedAt(_11.toLocalDateTime());
        }
        entity.setCreatedBy(rs.getLong(12));
        Timestamp _13 = rs.getTimestamp(13);
        if (_13 != null) {
          entity.setUpdatedAt(_13.toLocalDateTime());
        }
        entity.setUpdatedBy(rs.getLong(14));
        Boolean _15 = rs.getBoolean(15);
        if (_15 != null) {
        entity.setDeleted(_15);
        } else {
        entity.setDeleted(false);
        }
        Timestamp _16 = rs.getTimestamp(16);
        if (_16 != null) {
          entity.setDeletedAt(_16.toLocalDateTime());
        }
        entity.setDeletedBy(rs.getLong(17));
        entity.setVersion(rs.getLong(18));
        entity.setTenantId(rs.getLong(19));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = _Tenantable_.TENANT_ID.column().isEqualTo(SQL.bindMarker());

    Comparison LIVE = _Deletable_.DELETED.column().isEqualTo(SQL.literalOf(false));
  }
}
