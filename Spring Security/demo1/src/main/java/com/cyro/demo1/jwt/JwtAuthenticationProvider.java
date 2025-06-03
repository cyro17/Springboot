package com.cyro.demo1.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class JwtAuthenticationProvider implements AuthenticationProvider {

    private JwtUtil jwtUtil;
    private UserDetailsService userDetailsService;

    public JwtAuthenticationProvider(JwtUtil jwtUtil, UserDetailsService userDetailsService){
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = ((JwtAuthToken) authentication).getToken();
        String userName = jwtUtil.getUsernameFromToken(token);
        if(userName == null ) throw new BadCredentialsException("Invalid JWT Token ");

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthToken.class.isAssignableFrom(authentication);
    }
}
