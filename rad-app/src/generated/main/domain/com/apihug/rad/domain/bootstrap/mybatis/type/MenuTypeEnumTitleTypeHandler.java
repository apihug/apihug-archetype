// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis.type;

import com.apihug.rad.infra.menu.MenuTypeEnum;
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
public class MenuTypeEnumTitleTypeHandler implements TypeHandler<MenuTypeEnum> {
  public static final ParameterTypeConverter<MenuTypeEnum, String> PTC = source -> source != null ? source.title() : null;

  @Override
  public void setParameter(PreparedStatement ps, int idx, MenuTypeEnum parameter, JdbcType jdbcType)
      throws SQLException {
    if (parameter != null) {
      ps.setString(idx, parameter.title());
    } else {
      ps.setString(idx, null);
    }
  }

  @Override
  public MenuTypeEnum getResult(ResultSet rs, String columnName) throws SQLException {
    final String name = rs.getString(columnName);
    return MenuTypeEnum.NA.mapFromName(name);
  }

  @Override
  public MenuTypeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
    final String name = rs.getString(columnIndex);
    return MenuTypeEnum.NA.mapFromName(name);
  }

  @Override
  public MenuTypeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
    final String name = cs.getString(columnIndex);
    return MenuTypeEnum.NA.mapFromName(name);
  }
}
