
package es.citafacil.api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey secretKey;
    private final long expiration;

    public JwtService(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expiration) {

        byte[] keyBytes = Base64.getDecoder().decode(secret);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
        this.expiration = expiration;
    }

    public String generarToken(String email) {

        Date ahora = new Date();
        Date fechaExpiracion = new Date(
                ahora.getTime() + expiration);

        return Jwts.builder()
                .subject(email)
                .issuedAt(ahora)
                .expiration(fechaExpiracion)
                .signWith(secretKey)
                .compact();
    }
}
