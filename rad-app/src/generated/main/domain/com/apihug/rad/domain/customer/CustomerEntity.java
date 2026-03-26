// @formatter:off
package com.apihug.rad.domain.customer;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.persistence.annotations.Description;
import hope.common.spring.data.persistence.Domain;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Generated;
import org.springframework.data.relational.core.mapping.Column;

@Table(
    name = "SYS_CUSTOMER",
    indexes = {
        @Index(name = "IDX_SYS_CUSTOMER_USERNAME", columnList = "USERNAME"),
        @Index(name = "IDX_SYS_CUSTOMER_EMAIL", columnList = "EMAIL")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_SYS_CUSTOMER_USERNAME", columnNames = "USERNAME"),
        @UniqueConstraint(name = "UK_SYS_CUSTOMER_EMAIL", columnNames = "EMAIL")
    }
)
@org.springframework.data.relational.core.mapping.Table("SYS_CUSTOMER")
@Generated("H.O.P.E. Infra Team")
public final class CustomerEntity extends Domain<CustomerEntity, Long, Long> {
  /**
   * Default value: 0
   */
  @Column("DEFAULT_TENANT_ID")
  @Description("所属租户ID, If this is null,this is solo customer")
  @jakarta.persistence.Column(
      name = "DEFAULT_TENANT_ID",
      insertable = true,
      updatable = true,
      length = 255
  )
  protected Long defaultTenantId;

  @Column("USERNAME")
  @Description("用户名")
  @jakarta.persistence.Column(
      name = "USERNAME",
      unique = true,
      insertable = true,
      updatable = true,
      length = 50
  )
  protected String username;

  @Column("PASSWORD_HASH")
  @Description("密码哈希值")
  @jakarta.persistence.Column(
      name = "PASSWORD_HASH",
      insertable = true,
      length = 255
  )
  protected String passwordHash;

  @Column("EMAIL")
  @Description("邮箱")
  @jakarta.persistence.Column(
      name = "EMAIL",
      nullable = true,
      unique = true,
      insertable = true,
      updatable = true,
      length = 100
  )
  protected String email;

  /**
   * Default value: ACTIVE
   */
  @Column("STATUS")
  @Enumerated(EnumType.STRING)
  @Description("状态")
  @jakarta.persistence.Column(
      name = "STATUS",
      insertable = true,
      updatable = true,
      length = 12
  )
  protected CustomerStatusEnum status;

  /**
   * Default value: NA
   */
  @Column("PLATFORM_TYPE")
  @Enumerated(EnumType.STRING)
  @Description("平台账号标志")
  @jakarta.persistence.Column(
      name = "PLATFORM_TYPE",
      insertable = true,
      updatable = true,
      length = 12
  )
  protected CustomerPlatformTypeEnum platformType;

  public Long getDefaultTenantId() {
    return defaultTenantId;
  }

  public CustomerEntity setDefaultTenantId(Long defaultTenantId) {
    this.defaultTenantId = defaultTenantId;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public CustomerEntity setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public CustomerEntity setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public CustomerEntity setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerStatusEnum getStatus() {
    return status;
  }

  public CustomerEntity setStatus(CustomerStatusEnum status) {
    this.status = status;
    return this;
  }

  public CustomerPlatformTypeEnum getPlatformType() {
    return platformType;
  }

  public CustomerEntity setPlatformType(CustomerPlatformTypeEnum platformType) {
    this.platformType = platformType;
    return this;
  }
}
