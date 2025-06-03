package com.cyro.demo1.jwt;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private Key key;

    @Value("${jwt.secret}")
    public void setJwtSecret(String secret){
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Autowired @Lazy
    private AuthenticationManager authenticationManager;

    public String generateToken(String username, long expTime){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expTime * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


//    public String verify(String username, String password){
//        try {
//            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//            if( authenticate.isAuthenticated()){
//                String token = this.generateToken(username, 15);
//                return token;
//            }else{
//                throw new RuntimeException("Authentication failed..");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Invalid username or password", e);
//        }
//    }

    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .verifyWith((SecretKey) key)
                    .build()
                    .parseSignedClaims(token);
            return true;

        } catch (JwtException  | IllegalArgumentException e ) {
            return  false;
        }
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
