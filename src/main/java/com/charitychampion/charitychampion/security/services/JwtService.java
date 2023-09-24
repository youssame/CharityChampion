package com.charitychampion.charitychampion.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    // TODO : Add in properties
    @Value("${app.security.secret.key}")
    private String SECRET_KEY;
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

    private byte[] getJwtKey() {
        byte[] decoder = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decoder).getEncoded();
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

}
