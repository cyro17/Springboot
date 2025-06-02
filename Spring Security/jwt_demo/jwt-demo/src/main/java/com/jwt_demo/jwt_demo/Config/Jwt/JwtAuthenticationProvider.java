package com.jwt_demo.jwt_demo.Config.Jwt;

import com.jwt_demo.jwt_demo.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;


public class JwtAuthenticationProvider implements AuthenticationProvider {

    private JwtUtil jwtUtil;
    private UserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationProvider(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String token =((JwtAuthToken) authentication).getToken();
        String userName = jwtUtil.validateTokenAndExtractUserName(token);
        if(userName == null) throw new BadCredentialsException("Invalid JWT token");

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthToken.class.isAssignableFrom(authentication);
    }
}
