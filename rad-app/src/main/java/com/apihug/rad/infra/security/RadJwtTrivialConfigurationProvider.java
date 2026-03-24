// @formatter:off
package com.apihug.rad.infra.security;

import hope.common.spring.security.JwtTrivialConfigurationProvider;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.stereotype.Component;

@Component
@Generated("H.O.P.E. Infra Team")
public class RadJwtTrivialConfigurationProvider implements JwtTrivialConfigurationProvider {
  /**
   * Returns the MAC (Message Authentication Code) algorithm used for signing JWTs.
   *
   * <p>This method provides the algorithm configuration for JWT signing when a symmetric key (HMAC)
   * is used. By default, {@link MacAlgorithm#HS512} is selected, which offers a strong security
   * level with a 512-bit key. Subclasses may override this method to specify a different algorithm
   * (e.g., {@link MacAlgorithm#HS256} or {@link MacAlgorithm#HS384}) based on security requirements
   * or compatibility needs.
   *
   * <p>The algorithm is typically used by the {@link
   * org.springframework.security.oauth2.jwt.JwtEncoder} to sign tokens and by the {@link
   * org.springframework.security.oauth2.jwt.JwtDecoder} to verify the signature. It must match the
   * algorithm configured on both sides.
   *
   * @return the MAC algorithm to be used for JWT signing and verification
   */
  @Override
  public MacAlgorithm getMacAlgorithm() {
    return JwtTrivialConfigurationProvider.super.getMacAlgorithm();
  }

  /**
   * Handles JWT processing exceptions, providing an extension point to transform or enrich
   * the raw exception before it propagates.
   * <p>
   * This method is invoked when an exception occurs during JWT decoding or validation
   * (e.g., signature mismatch, expiration, malformed token). Subclasses may override it
   * to perform custom error handling, such as logging, translating the exception into a
   * domain-specific exception, or wrapping it in a more meaningful error type.
   * <p>
   * By default, the method does nothing, allowing the original exception to propagate.
   * Overriding implementations may throw a custom runtime exception to replace the
   * original one, or simply perform side effects like logging.
   * <p>
   * Example usage that categorizes the error based on the exception message:
   * <pre>{@code
   * @Override
   * public void jwtException(Exception rawException, String token) {
   *   if (rawException.getMessage().contains("Invalid signature")) {
   *       throw new InvalidTokenSignatureException("Invalid token signature");
   *   } else if (rawException.getMessage().contains("Jwt expired at")) {
   *       throw new TokenExpiredException("Token has expired");
   *   } else if (rawException.getMessage().contains("Invalid JWT serialization") ||
   *              rawException.getMessage().contains("Malformed token") ||
   *              rawException.getMessage().contains("Invalid unsecured/JWS/JWE")) {
   *       throw new MalformedTokenException("Token format is invalid");
   *   } else {
   *       throw new JwtProcessingException("Unexpected JWT error", rawException);
   *   }
   * }
   * }</pre>
   *
   * @param rawException the original exception thrown during JWT decoding or validation
   * @param token        the raw JWT string that caused the exception (may be {@code null}
   *                   if not available)
   * @throws RuntimeException implementations may throw custom runtime exceptions to
   *                        replace or wrap the original exception
   */
  @Override
  public void jwtException(Exception rawException, String token) {
  }
}
