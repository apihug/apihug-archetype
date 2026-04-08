package com.apihug.rad.infra.beans;

import hope.common.meta.annotation.Template;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Password encoder using Spring Security's BCrypt implementation.
 *
 * <p>BCrypt is a strong password hashing function that includes:
 *
 * <ul>
 *   <li>Built-in salt generation and storage
 *   <li>Configurable work factor (log rounds)
 *   <li>Resistance to rainbow table attacks
 * </ul>
 */
@Service
@Template(
    type = Template.Type.UTILS,
    usage = "BCrypt password encoder for security",
    percentage = 100,
    dependencies = {
      @Template.Dependency(
          groupId = "org.springframework.security",
          artifactId = "spring-security-crypto"),
    })
public class PasswordEncoder {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public PasswordEncoder() {
    // Default strength of 10 provides good balance between security and performance
    this.bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
  }

  /**
   * Encode the raw password using BCrypt.
   *
   * @param rawPassword the raw password to encode
   * @return the encoded password with BCrypt
   */
  public String encode(CharSequence rawPassword) {
    return bCryptPasswordEncoder.encode(rawPassword);
  }

  /**
   * Verify the encoded password obtained from storage matches the submitted raw password.
   *
   * @param rawPassword the raw password to encode and match
   * @param encodedPassword the encoded password from storage to compare with
   * @return true if the raw password, after encoding, matches the encoded password from storage
   */
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
  }

  /**
   * Returns true if the encoded password should be encoded again for better security. BCrypt
   * doesn't typically need re-encoding unless the strength parameter changes.
   *
   * @param encodedPassword the encoded password to check
   * @return false (BCrypt doesn't support upgrade encoding)
   */
  public boolean upgradeEncoding(String encodedPassword) {
    return false;
  }
}
