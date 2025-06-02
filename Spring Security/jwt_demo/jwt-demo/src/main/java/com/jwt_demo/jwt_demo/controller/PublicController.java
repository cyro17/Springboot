package com.jwt_demo.jwt_demo.controller;

import com.jwt_demo.jwt_demo.Entity.User;
import com.jwt_demo.jwt_demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return  "ok ! ";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
        boolean saved = userService.saveUser(user);
        if(saved) return  new ResponseEntity<>("user created ! ", HttpStatus.CREATED);
        else return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    @GetMapping
//    public ResponseEntity<String> healthCheck(@RequestBody User user){
//
//    }
}
