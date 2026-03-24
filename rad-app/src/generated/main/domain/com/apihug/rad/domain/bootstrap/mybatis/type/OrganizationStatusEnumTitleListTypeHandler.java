// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis.type;

import com.apihug.rad.infra.organization.OrganizationStatusEnum;
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
public class OrganizationStatusEnumTitleListTypeHandler implements TypeHandler<List<OrganizationStatusEnum>> {
  public static final ParameterTypeConverter<List<OrganizationStatusEnum>, String> PTC = source -> (source != null &&  !source.isEmpty()) ? source.stream().map(it -> it.name()).collect(Collectors.joining(",")) : null;

  private static final List<OrganizationStatusEnum> _map(String name) {
    if (name == null || name.isEmpty()) {
      return null;
    }
    final List<OrganizationStatusEnum> res = new ArrayList<>();
    for (String each : name.split(",")) {
      OrganizationStatusEnum mapped = OrganizationStatusEnum.NA.mapFromName(each);
      if (OrganizationStatusEnum.NA != mapped) {
        res.add(mapped);
      }
    }
    return res;
  }

  @Override
  public void setParameter(PreparedStatement ps, int idx, List<OrganizationStatusEnum> parameter,
      JdbcType jdbcType) throws SQLException {
    if (parameter != null && !parameter.isEmpty()) {
      ps.setString(idx, PTC.convert(parameter));
    } else {
      ps.setString(idx, null);
    }
  }

  @Override
  public List<OrganizationStatusEnum> getResult(ResultSet rs, String columnName) throws
      SQLException {
    return _map(rs.getString(columnName));
  }

  @Override
  public List<OrganizationStatusEnum> getResult(ResultSet rs, int columnIndex) throws SQLException {
    return _map(rs.getString(columnIndex));
  }

  @Override
  public List<OrganizationStatusEnum> getResult(CallableStatement cs, int columnIndex) throws
      SQLException {
    return _map(cs.getString(columnIndex));
  }
}
