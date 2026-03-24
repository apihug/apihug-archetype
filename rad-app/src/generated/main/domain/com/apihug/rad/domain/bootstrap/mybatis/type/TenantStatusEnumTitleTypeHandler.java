// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis.type;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
import java.lang.Override;
import java.lang.String;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Generated;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.dynamic.sql.ParameterTypeConverter;

@Generated("H.O.P.E. Infra Team")
public class TenantStatusEnumTitleTypeHandler implements TypeHandler<TenantStatusEnum> {
  public static final ParameterTypeConverter<TenantStatusEnum, String> PTC = source -> source != null ? source.title() : null;

  @Override
  public void setParameter(PreparedStatement ps, int idx, TenantStatusEnum parameter,
      JdbcType jdbcType) throws SQLException {
    if (parameter != null) {
      ps.setString(idx, parameter.title());
    } else {
      ps.setString(idx, null);
    }
  }

  @Override
  public TenantStatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
    final String name = rs.getString(columnName);
    return TenantStatusEnum.NA.mapFromName(name);
  }

  @Override
  public TenantStatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
    final String name = rs.getString(columnIndex);
    return TenantStatusEnum.NA.mapFromName(name);
  }

  @Override
  public TenantStatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
    final String name = cs.getString(columnIndex);
    return TenantStatusEnum.NA.mapFromName(name);
  }
}
