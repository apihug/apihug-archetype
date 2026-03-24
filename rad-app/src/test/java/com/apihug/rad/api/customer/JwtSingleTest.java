package com.apihug.rad.api.customer;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.util.Base64;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;

public class JwtSingleTest {

  String jwtKey =
      "X8ZZgreZ0BpKqeGx2+h13QH7DegjLjTEG3iHCccdgUMZnc0UBvTqMcx9z1UvRhNT5KHZQ7HbpjvkvSoO3IOpcG/Hkw00mQh2ynYySV6x6HeDOQfMAYuy+2zDjjPi5pvvoBYfiFajkznjf5hHR8DNYjDo2NrjtS2VLEFisZsCuLs=";

  public JwtEncoder jwtEncoder() {
    return new NimbusJwtEncoder(new ImmutableSecret<>(getSecretKey()));
  }

  private SecretKey getSecretKey() {
    byte[] keyBytes = Base64.from(jwtKey).decode();
    return new SecretKeySpec(keyBytes, 0, keyBytes.length, "HS512");
  }

  @Test
  public void test_simple() {
    JwtClaimsSet.Builder claims = JwtClaimsSet.builder();

    Instant now = Instant.now();
    claims.issuer("self").issuedAt(now).subject("user_admin").expiresAt(now.plusSeconds(100));

    JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS512).build();
    String token =
        jwtEncoder().encode(JwtEncoderParameters.from(jwsHeader, claims.build())).getTokenValue();

    Assertions.assertThat(token).isNotNull();
  }
}
