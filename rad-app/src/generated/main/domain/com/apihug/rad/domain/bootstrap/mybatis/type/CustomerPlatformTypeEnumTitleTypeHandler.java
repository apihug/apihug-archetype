// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis.type;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
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
public class CustomerPlatformTypeEnumTitleTypeHandler implements TypeHandler<CustomerPlatformTypeEnum> {
  public static final ParameterTypeConverter<CustomerPlatformTypeEnum, String> PTC = source -> source != null ? source.title() : null;

  @Override
  public void setParameter(PreparedStatement ps, int idx, CustomerPlatformTypeEnum parameter,
      JdbcType jdbcType) throws SQLException {
    if (parameter != null) {
      ps.setString(idx, parameter.title());
    } else {
      ps.setString(idx, null);
    }
  }

  @Override
  public CustomerPlatformTypeEnum getResult(ResultSet rs, String columnName) throws SQLException {
    final String name = rs.getString(columnName);
    return CustomerPlatformTypeEnum.NA.mapFromName(name);
  }

  @Override
  public CustomerPlatformTypeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
    final String name = rs.getString(columnIndex);
    return CustomerPlatformTypeEnum.NA.mapFromName(name);
  }

  @Override
  public CustomerPlatformTypeEnum getResult(CallableStatement cs, int columnIndex) throws
      SQLException {
    final String name = cs.getString(columnIndex);
    return CustomerPlatformTypeEnum.NA.mapFromName(name);
  }
}
