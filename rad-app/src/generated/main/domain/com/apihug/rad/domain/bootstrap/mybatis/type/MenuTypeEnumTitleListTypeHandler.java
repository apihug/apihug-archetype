// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis.type;

import com.apihug.rad.infra.menu.MenuTypeEnum;
import java.lang.Override;
import java.lang.String;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.dynamic.sql.ParameterTypeConverter;

@Generated("H.O.P.E. Infra Team")
public class MenuTypeEnumTitleListTypeHandler implements TypeHandler<List<MenuTypeEnum>> {
  public static final ParameterTypeConverter<List<MenuTypeEnum>, String> PTC = source -> (source != null &&  !source.isEmpty()) ? source.stream().map(it -> it.name()).collect(Collectors.joining(",")) : null;

  private static final List<MenuTypeEnum> _map(String name) {
    if (name == null || name.isEmpty()) {
      return null;
    }
    final List<MenuTypeEnum> res = new ArrayList<>();
    for (String each : name.split(",")) {
      MenuTypeEnum mapped = MenuTypeEnum.NA.mapFromName(each);
      if (MenuTypeEnum.NA != mapped) {
        res.add(mapped);
      }
    }
    return res;
  }

  @Override
  public void setParameter(PreparedStatement ps, int idx, List<MenuTypeEnum> parameter,
      JdbcType jdbcType) throws SQLException {
    if (parameter != null && !parameter.isEmpty()) {
      ps.setString(idx, PTC.convert(parameter));
    } else {
      ps.setString(idx, null);
    }
  }

  @Override
  public List<MenuTypeEnum> getResult(ResultSet rs, String columnName) throws SQLException {
    return _map(rs.getString(columnName));
  }

  @Override
  public List<MenuTypeEnum> getResult(ResultSet rs, int columnIndex) throws SQLException {
    return _map(rs.getString(columnIndex));
  }

  @Override
  public List<MenuTypeEnum> getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return _map(cs.getString(columnIndex));
  }
}
