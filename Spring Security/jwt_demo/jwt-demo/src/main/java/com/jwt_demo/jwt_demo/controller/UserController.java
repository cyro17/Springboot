package com.jwt_demo.jwt_demo.controller;

import com.jwt_demo.jwt_demo.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping
    public ResponseEntity<?> greeting(@RequestBody User user){
        return  new ResponseEntity<>("Hey ! " + user.getUserName(), HttpStatus.OK);
    }



    @GetMapping("/healthCheck")
    public String healthCheck(){
        return  "ok ! ";
    }

}
