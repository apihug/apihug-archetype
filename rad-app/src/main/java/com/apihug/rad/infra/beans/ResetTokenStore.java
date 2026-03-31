package com.apihug.rad.infra.beans;

/**
 * 密码重置 Token 存储抽象接口。
 *
 * <p>dev 环境使用内存缓存实现，其它环境使用 Redis 缓存实现。
 */
public interface ResetTokenStore {

  /**
   * 存储一个重置 token，关联到指定客户。
   *
   * @param token 重置 token（UUID 字符串）
   * @param customerId 客户 ID
   * @param expiryMinutes 过期时间（分钟）
   */
  void store(String token, Long customerId, long expiryMinutes);

  /**
   * 获取并移除 token 对应的客户 ID。
   *
   * <p>如果 token 不存在或已过期，返回 null。
   *
   * @param token 重置 token
   * @return 客户 ID，不存在或过期返回 null
   */
  Long removeAndGet(String token);
}
