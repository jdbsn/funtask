package com.mang.funtask.servicos;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Value("api.security.token.secret")
  private String secret;

  public String generateToken(String email) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      return JWT.create()
          .withIssuer("FunTask")
          .withSubject(email)
          .withExpiresAt(gerarTempoExpiracao())
          .sign(algorithm);
    } catch(JWTCreationException e) {
      throw new RuntimeException("Erro na geraçao do token.", e);
    }
  }

  public String validarToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      return JWT.require(algorithm)
              .withIssuer("FunTask")
              .build()
              .verify(token)
              .getSubject();
    } catch(JWTVerificationException e) {
      return "";
    }
  }

  public String recuperarEmail(String authHeader) {
    String token = authHeader.replace("Bearer ", "");

    return this.validarToken(token);
  }

  private Instant gerarTempoExpiracao() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }

}
