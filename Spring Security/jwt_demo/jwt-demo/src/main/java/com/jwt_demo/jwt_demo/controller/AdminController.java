package com.jwt_demo.jwt_demo.controller;

import com.jwt_demo.jwt_demo.Entity.User;
import com.jwt_demo.jwt_demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User user){
        boolean created = userService.saveUser(user);
        if(created)
            return new ResponseEntity<>("user registered", HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return  "ok ! ";
    }
}
