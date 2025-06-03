package com.cyro.demo1.controller;

import com.cyro.demo1.dto.LoginRequest;
import com.cyro.demo1.entity.User;
import com.cyro.demo1.jwt.JwtUtil;
import com.cyro.demo1.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/health")
    public String healthCheck(){
        return  "OK";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup( @RequestBody User user){
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        User savedUser = userService.saveNewUser(newUser);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new RuntimeException("Invalid Credetials");
        }

        return  new ResponseEntity<>(
                jwtUtil.generateToken(loginRequest.getUserName(), 15), HttpStatus.ACCEPTED
        );
    }
}