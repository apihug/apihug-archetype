// @formatter:off
package com.apihug.rad.domain.bootstrap.mybatis.type;

import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
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
public class TenantMemberStatusEnumTitleTypeHandler implements TypeHandler<TenantMemberStatusEnum> {
  public static final ParameterTypeConverter<TenantMemberStatusEnum, String> PTC = source -> source != null ? source.title() : null;

  @Override
  public void setParameter(PreparedStatement ps, int idx, TenantMemberStatusEnum parameter,
      JdbcType jdbcType) throws SQLException {
    if (parameter != null) {
      ps.setString(idx, parameter.title());
    } else {
      ps.setString(idx, null);
    }
  }

  @Override
  public TenantMemberStatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
    final String name = rs.getString(columnName);
    return TenantMemberStatusEnum.NA.mapFromName(name);
  }

  @Override
  public TenantMemberStatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
    final String name = rs.getString(columnIndex);
    return TenantMemberStatusEnum.NA.mapFromName(name);
  }

  @Override
  public TenantMemberStatusEnum getResult(CallableStatement cs, int columnIndex) throws
      SQLException {
    final String name = cs.getString(columnIndex);
    return TenantMemberStatusEnum.NA.mapFromName(name);
  }
}
