package com.apihug.rad.infra.beans;

import hope.common.meta.annotation.Template;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 基于内存的密码重置 Token 存储（dev 环境使用）。
 *
 * <p>使用 ConcurrentHashMap 存储 token → 客户 ID 的映射，
 * 适用于开发、测试环境。应用重启后所有 token 失效。
 */
@Template(type = Template.Type.SERVICE, usage = "In-memory reset token store for dev environment", percentage = 100)
@Component
@Profile({"dev", "test"})
public class InMemoryResetTokenStore implements ResetTokenStore {

  private final ConcurrentHashMap<String, TokenEntry> store = new ConcurrentHashMap<>();

  private record TokenEntry(Long customerId, LocalDateTime expiresAt) {}

  @Override
  public void store(String token, Long customerId, long expiryMinutes) {
    LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(expiryMinutes);
    store.put(token, new TokenEntry(customerId, expiresAt));
  }

  @Override
  public Long removeAndGet(String token) {
    TokenEntry entry = store.remove(token);
    if (entry == null) {
      return null;
    }
    if (LocalDateTime.now().isAfter(entry.expiresAt())) {
      return null;
    }
    return entry.customerId();
  }
}
