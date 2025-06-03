package com.cyro.demo1.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtValidationFilter extends OncePerRequestFilter {

    @Autowired @Lazy
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //extract the token
        String jwt = extractJwtFromRequest(request);

        if (request.getServletPath().equals("/public/generate-token")) {
            filterChain.doFilter(request, response);
            return;
        }

        if(jwt != null){
            Authentication authResults = authenticationManager.authenticate(new JwtAuthToken(jwt));
            if(authResults.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(authResults);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return  null;
    }
}
