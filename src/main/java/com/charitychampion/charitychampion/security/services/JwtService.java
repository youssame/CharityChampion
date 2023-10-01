package com.charitychampion.charitychampion.security.services;

import com.charitychampion.charitychampion.security.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    // TODO : Add in properties
    @Value("${app.security.secret.key}")
    private String SECRET_KEY;
    @Value("${app.security.refresh.expiration}")
    private long REFRESH_EXPIRATION;
    @Value("${app.security.token.expiration}")
    private long TOKEN_EXPIRATION;
    public String extractUsername(String token) {
        return this.extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = this.extractClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractClaims(String token) {
        return (Claims) Jwts
                .parserBuilder()
                .setSigningKey(getJwtKey())
                .build()
                .parse(token)
                .getBody();
    }

    private Key getJwtKey() {
        byte[] decoder = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }

    public boolean isTokenValid(UserDetails userDetails, String token) {
        String userName = this.extractUsername(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }

    public String generateRefreshToken(User user) {
        return this.buildToken(new HashMap<>(), user, REFRESH_EXPIRATION);
    }
    public String generateToken(User user) {
        return this.buildToken(new HashMap<>(), user, TOKEN_EXPIRATION);
    }
    private String buildToken(Map<String, Object> extraClaims,
                              UserDetails userDetails,
                              long expiration) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getJwtKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
