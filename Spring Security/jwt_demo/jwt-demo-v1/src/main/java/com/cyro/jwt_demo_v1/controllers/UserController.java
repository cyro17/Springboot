package com.cyro.jwt_demo_v1.controllers;

import com.cyro.jwt_demo_v1.dto.UserRequestDTO;
import com.cyro.jwt_demo_v1.entities.User;
import com.cyro.jwt_demo_v1.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/public/health")
    public ResponseEntity<?> healthCheck(){
        log.info("ok");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @GetMapping("/admin/health")
    public ResponseEntity<?> health(){
        log.info("user controller log");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/admin/check")
    public String check(){
        return  "ok";
    }


    @PostMapping("/public/signup")
    public ResponseEntity<?> createUser(@RequestBody User user){
        Boolean b = userService.saveUser(user);
        return Boolean.TRUE.equals(b) ? new ResponseEntity<>("user created", HttpStatus.CREATED) :
                new ResponseEntity<>("user already exist", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/public/signup-admin")
    public ResponseEntity<?> createAdmin(@RequestBody User user){
        Boolean b = userService.saveAdmin(user);
        return Boolean.TRUE.equals(b) ? new ResponseEntity<>("user created", HttpStatus.CREATED) :
                new ResponseEntity<>("user already exist", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.allUser();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }


}
