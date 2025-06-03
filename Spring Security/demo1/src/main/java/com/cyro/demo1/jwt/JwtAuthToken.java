package com.cyro.demo1.jwt;

import lombok.Data;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthToken extends AbstractAuthenticationToken {

    private final String token;

    public JwtAuthToken(String token){
        super(null);
        this.token = token;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getToken() {
        return  this.token;
    }
}
