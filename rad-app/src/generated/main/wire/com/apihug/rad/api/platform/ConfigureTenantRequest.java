// @formatter:off
package com.apihug.rad.api.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import jakarta.validation.constraints.Min;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 配置租户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/platform/tenant.proto",
    entity = "ConfigureTenantRequest",
    kind = Kind.MESSAGE
)
public class ConfigureTenantRequest {
  private static final long serialVersionUID = 0L;

  @Min(1)
  protected Integer maxMembers;

  @Min(1)
  protected Long maxStorageMb;

  protected List<String> enabledModules;

  @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm:ss"
  )
  protected LocalDateTime expiryDate;

  public Integer getMaxMembers() {
    return maxMembers;
  }

  public ConfigureTenantRequest setMaxMembers(Integer maxMembers) {
    this.maxMembers = maxMembers;
    return this;
  }

  public Long getMaxStorageMb() {
    return maxStorageMb;
  }

  public ConfigureTenantRequest setMaxStorageMb(Long maxStorageMb) {
    this.maxStorageMb = maxStorageMb;
    return this;
  }

  public List<String> getEnabledModules() {
    return enabledModules;
  }

  public ConfigureTenantRequest setEnabledModules(List<String> enabledModules) {
    this.enabledModules = enabledModules;
    return this;
  }

  public LocalDateTime getExpiryDate() {
    return expiryDate;
  }

  public ConfigureTenantRequest setExpiryDate(LocalDateTime expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "ConfigureTenantRequest[" , "]")
    	.add("maxMembers=" + maxMembers)
    	.add("maxStorageMb=" + maxStorageMb)
    	.add("enabledModules=" + enabledModules)
    	.add("expiryDate=" + expiryDate)
        .toString();
  }
}
