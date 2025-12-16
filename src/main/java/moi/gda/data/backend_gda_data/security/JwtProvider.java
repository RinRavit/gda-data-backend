package moi.gda.data.backend_gda_data.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {

  @Value("${jwt.secret}")
  private String secret;

  private SecretKey getKey() {
    return Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String generateToken(String email) {
    return Jwts.builder()
      .setSubject(email)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 86400000))
      .signWith(getKey())
      .compact();
  }

  public String getEmail(String token) {
    Claims claims = Jwts.parserBuilder()
      .setSigningKey(getKey())
      .build()
      .parseClaimsJws(token)
      .getBody();

    return claims.getSubject();
  }
}
