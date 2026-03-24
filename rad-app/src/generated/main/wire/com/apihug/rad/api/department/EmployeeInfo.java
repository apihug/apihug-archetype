// @formatter:off
package com.apihug.rad.api.department;

import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.NotEmpty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 员工信息
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "EmployeeInfo",
    kind = Kind.MESSAGE
)
public class EmployeeInfo {
  private static final long serialVersionUID = 0L;

  protected Long id;

  @NotEmpty
  protected String username;

  @NotEmpty
  protected String realName;

  protected String email;

  protected String position;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime joinedAt;

  public Long getId() {
    return id;
  }

  public EmployeeInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public EmployeeInfo setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getRealName() {
    return realName;
  }

  public EmployeeInfo setRealName(String realName) {
    this.realName = realName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public EmployeeInfo setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public EmployeeInfo setPosition(String position) {
    this.position = position;
    return this;
  }

  public LocalDateTime getJoinedAt() {
    return joinedAt;
  }

  public EmployeeInfo setJoinedAt(LocalDateTime joinedAt) {
    this.joinedAt = joinedAt;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "EmployeeInfo[" , "]")
    	.add("id=" + id)
    	.add("username=" + username)
    	.add("realName=" + realName)
    	.add("email=" + email)
    	.add("position=" + position)
    	.add("joinedAt=" + joinedAt)
        .toString();
  }
}
