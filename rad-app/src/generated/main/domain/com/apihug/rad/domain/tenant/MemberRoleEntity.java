// @formatter:off
package com.apihug.rad.domain.tenant;

import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.wire.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Long;
import java.lang.Override;
import javax.annotation.Generated;

@Table(
    name = "SYS_MEMBER_ROLE",
    indexes = {
        @Index(name = "IDX_SYS_MEMBER_ROLE_MEMBER_ID", columnList = "MEMBER_ID"),
        @Index(name = "IDX_SYS_MEMBER_ROLE_ROLE_ID", columnList = "ROLE_ID")
    },
    uniqueConstraints = @UniqueConstraint(name = "UK_SYS_MEMBER_ROLE_MEMBER_ID_ROLE_ID", columnNames = {"MEMBER_ID", "ROLE_ID"})
)
@org.springframework.data.relational.core.mapping.Table("SYS_MEMBER_ROLE")
@Generated("H.O.P.E. Infra Team")
public final class MemberRoleEntity implements Identifiable<MemberRoleEntity> {
  @Id
  @org.springframework.data.annotation.Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  @Column(
      nullable = false,
      updatable = false,
      name = "ID",
      unique = true
  )
  @org.springframework.data.relational.core.mapping.Column("ID")
  @Description("Record ID")
  protected Long id;

  @org.springframework.data.relational.core.mapping.Column("MEMBER_ID")
  @Description("租户成员 ID (SYS_TENANT_MEMBER.id)")
  @Column(
      name = "MEMBER_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long memberId;

  @org.springframework.data.relational.core.mapping.Column("ROLE_ID")
  @Description("角色 ID (SYS_ROLE.id)")
  @Column(
      name = "ROLE_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long roleId;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public MemberRoleEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getMemberId() {
    return memberId;
  }

  public MemberRoleEntity setMemberId(Long memberId) {
    this.memberId = memberId;
    return this;
  }

  public Long getRoleId() {
    return roleId;
  }

  public MemberRoleEntity setRoleId(Long roleId) {
    this.roleId = roleId;
    return this;
  }
}
