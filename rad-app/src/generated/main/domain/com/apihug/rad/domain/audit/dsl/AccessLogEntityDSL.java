// @formatter:off
package com.apihug.rad.domain.audit.dsl;

import com.apihug.rad.domain.audit.AccessLogEntity;
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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

@Generated("H.O.P.E. Infra Team")
public interface AccessLogEntityDSL extends DSL<AccessLogEntity> {
  Table table = Table.create("SYS_ACCESS_LOG").as("_sys_access_log");

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
  default Object[] parameters(AccessLogEntity entity, Object[] carrier, int beginIndex) {
    carrier[beginIndex + 0] = entity.getHttpMethod();
    carrier[beginIndex + 1] = entity.getRequestPath();
    carrier[beginIndex + 2] = entity.getRequestParams();
    carrier[beginIndex + 3] = entity.getResponseStatus();
    carrier[beginIndex + 4] = entity.getStartEpochTs();
    carrier[beginIndex + 5] = entity.getDurationMs();
    carrier[beginIndex + 6] = entity.getCustomerId();
    carrier[beginIndex + 7] = entity.getIpAddress();
    carrier[beginIndex + 8] = entity.getUserAgent();
    carrier[beginIndex + 9] = entity.getServiceName();
    carrier[beginIndex + 10] = entity.getMethodName();
    carrier[beginIndex + 11] = entity.getErrorCode();
    carrier[beginIndex + 12] = entity.getErrorMessage();
    carrier[beginIndex + 13] = entity.getChannel();
    carrier[beginIndex + 14] = entity.getCreatedBy();
    LocalDateTime _15 = entity.getCreatedAt();
    carrier[beginIndex + 15] = _15 == null ? null : Timestamp.valueOf(_15);
    carrier[beginIndex + 16] = entity.getPriority();
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
    return AccessLogEntity.class;
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
    	Map.entry("HTTPMETHOD", Domain.HttpMethod),
    	Map.entry("REQUESTPATH", Domain.RequestPath),
    	Map.entry("REQUESTPARAMS", Domain.RequestParams),
    	Map.entry("RESPONSESTATUS", Domain.ResponseStatus),
    	Map.entry("STARTEPOCHTS", Domain.StartEpochTs),
    	Map.entry("DURATIONMS", Domain.DurationMs),
    	Map.entry("CUSTOMERID", Domain.CustomerId),
    	Map.entry("IPADDRESS", Domain.IpAddress),
    	Map.entry("USERAGENT", Domain.UserAgent),
    	Map.entry("SERVICENAME", Domain.ServiceName),
    	Map.entry("METHODNAME", Domain.MethodName),
    	Map.entry("ERRORCODE", Domain.ErrorCode),
    	Map.entry("ERRORMESSAGE", Domain.ErrorMessage),
    	Map.entry("CHANNEL", Domain.Channel),
    	Map.entry("CREATEDBY", Domain.CreatedBy),
    	Map.entry("CREATEDAT", Domain.CreatedAt),
    	Map.entry("PRIORITY", Domain.Priority),
    	// Tenantable,
    	Map.entry("TENANTID", _Tenantable_.TENANT_ID),
    	Map.entry("TENANT_ID", _Tenantable_.TENANT_ID)
    );
  }

  interface Domain {
    ColumnMix HttpMethod = ColumnMix.of(table, 
    	new Column().setFieldName("httpMethod")
    		.setName("HTTP_METHOD")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("HTTP请求方法")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(10));

    ColumnMix RequestPath = ColumnMix.of(table, 
    	new Column().setFieldName("requestPath")
    		.setName("REQUEST_PATH")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("请求路径")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(500));

    ColumnMix RequestParams = ColumnMix.of(table, 
    	new Column().setFieldName("requestParams")
    		.setName("REQUEST_PARAMS")
    		.setClz("java.lang.String")
    		.setType(Types.CLOB)
    		.setDescription("脱敏后的请求参数JSON")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix ResponseStatus = ColumnMix.of(table, 
    	new Column().setFieldName("responseStatus")
    		.setName("RESPONSE_STATUS")
    		.setClz("java.lang.Integer")
    		.setType(Types.INTEGER)
    		.setDescription("HTTP响应状态码")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix StartEpochTs = ColumnMix.of(table, 
    	new Column().setFieldName("startEpochTs")
    		.setName("START_EPOCH_TS")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("start epoch timestamp")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("START_EPOCH_TS"));

    ColumnMix DurationMs = ColumnMix.of(table, 
    	new Column().setFieldName("durationMs")
    		.setName("DURATION_MS")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("请求耗时毫秒")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("DURATION_MS"));

    ColumnMix CustomerId = ColumnMix.of(table, 
    	new Column().setFieldName("customerId")
    		.setName("CUSTOMER_ID")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("客户ID")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix IpAddress = ColumnMix.of(table, 
    	new Column().setFieldName("ipAddress")
    		.setName("IP_ADDRESS")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("IP地址")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(45));

    ColumnMix UserAgent = ColumnMix.of(table, 
    	new Column().setFieldName("userAgent")
    		.setName("USER_AGENT")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("用户代理")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(500));

    ColumnMix ServiceName = ColumnMix.of(table, 
    	new Column().setFieldName("serviceName")
    		.setName("SERVICE_NAME")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("服务名称")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix MethodName = ColumnMix.of(table, 
    	new Column().setFieldName("methodName")
    		.setName("METHOD_NAME")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("方法名称")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(125));

    ColumnMix ErrorCode = ColumnMix.of(table, 
    	new Column().setFieldName("errorCode")
    		.setName("ERROR_CODE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("错误码")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(50));

    ColumnMix ErrorMessage = ColumnMix.of(table, 
    	new Column().setFieldName("errorMessage")
    		.setName("ERROR_MESSAGE")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("错误信息")
    		.setUpdatable(true)
    		.setNullable(true)
    		.setInsertable(true)
    		.setLength(500));

    ColumnMix Channel = ColumnMix.of(table, 
    	new Column().setFieldName("channel")
    		.setName("CHANNEL")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("渠道")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(16)
    		.setDefaultValue("CHANNEL"));

    ColumnMix CreatedBy = ColumnMix.of(table, 
    	new Column().setFieldName("createdBy")
    		.setName("CREATED_BY")
    		.setClz("java.lang.Long")
    		.setType(Types.BIGINT)
    		.setDescription("created by")
    		.setUpdatable(true)
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix CreatedAt = ColumnMix.of(table, 
    	new Column().setFieldName("createdAt")
    		.setName("CREATED_AT")
    		.setClz("java.time.LocalDateTime")
    		.setType(Types.TIMESTAMP)
    		.setDescription("created at timestamp")
    		.setInsertable(true)
    		.setLength(255));

    ColumnMix Priority = ColumnMix.of(table, 
    	new Column().setFieldName("priority")
    		.setName("PRIORITY")
    		.setClz("java.lang.String")
    		.setType(Types.VARCHAR)
    		.setDescription("priority of this method")
    		.setInsertable(true)
    		.setLength(255)
    		.setDefaultValue("PRIORITY"));

    List<ColumnMix> ALL = List.of(HttpMethod, RequestPath, RequestParams, ResponseStatus, StartEpochTs, DurationMs, CustomerId, IpAddress, UserAgent, ServiceName, MethodName, ErrorCode, ErrorMessage, Channel, CreatedBy, CreatedAt, Priority);

    ColumnMix Id = _Identifiable_.ID;

    ColumnMix TenantId = _Tenantable_.TENANT_ID;
  }

  interface Template {
    ParameterizedPreparedStatementSetter<AccessLogEntity> SETTER = 
    (ps, entity) -> {
    ps.setString(1, entity.getHttpMethod());
    ps.setString(2, entity.getRequestPath());
    ps.setString(3, entity.getRequestParams());
    ps.setInt(4, entity.getResponseStatus());
    ps.setLong(5, entity.getStartEpochTs());
    ps.setLong(6, entity.getDurationMs());
    ps.setLong(7, entity.getCustomerId());
    ps.setString(8, entity.getIpAddress());
    ps.setString(9, entity.getUserAgent());
    ps.setString(10, entity.getServiceName());
    ps.setString(11, entity.getMethodName());
    ps.setString(12, entity.getErrorCode());
    ps.setString(13, entity.getErrorMessage());
    ps.setString(14, entity.getChannel());
    ps.setLong(15, entity.getCreatedBy());
    ps.setTimestamp(16, Timestamp.valueOf(entity.getCreatedAt()));
    ps.setString(17, entity.getPriority());
    };

    RowMapper<AccessLogEntity> MAPPER = new RowMapper() {
      @Override
      public AccessLogEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final AccessLogEntity entity = new AccessLogEntity();
        entity.setId(rs.getLong(1));
        entity.setHttpMethod(rs.getString(2));
        entity.setRequestPath(rs.getString(3));
        entity.setRequestParams(rs.getString(4));
        entity.setResponseStatus(rs.getInt(5));
        entity.setStartEpochTs(rs.getLong(6));
        entity.setDurationMs(rs.getLong(7));
        entity.setCustomerId(rs.getLong(8));
        entity.setIpAddress(rs.getString(9));
        entity.setUserAgent(rs.getString(10));
        entity.setServiceName(rs.getString(11));
        entity.setMethodName(rs.getString(12));
        entity.setErrorCode(rs.getString(13));
        entity.setErrorMessage(rs.getString(14));
        entity.setChannel(rs.getString(15));
        entity.setCreatedBy(rs.getLong(16));
        Timestamp _17 = rs.getTimestamp(17);
        if (_17 != null) {
          entity.setCreatedAt(_17.toLocalDateTime());
        }
        entity.setPriority(rs.getString(18));
        entity.setTenantId(rs.getLong(19));
        return entity;
      }
    };
  }

  interface Segment {
    Comparison TENANT_EQUAL = _Tenantable_.TENANT_ID.column().isEqualTo(SQL.bindMarker());

    Comparison LIVE = null;
  }
}
