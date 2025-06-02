package com.cyro.demo1.controller;

import com.cyro.demo1.entity.User;
import com.cyro.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/heath-check")
    public String healthCheck(){
        return  "OK";
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllUsers(){
        List<User> all = userService.getAll();
        if(all != null && !all.isEmpty()) return  new ResponseEntity<>(all, HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("create-new-user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        boolean created =  userService.saveAdmin(user);
        if(created) return  new ResponseEntity<>("user created", HttpStatus.CREATED);
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

}