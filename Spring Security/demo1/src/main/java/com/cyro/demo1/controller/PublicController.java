package com.cyro.demo1.controller;

import com.cyro.demo1.entity.User;
import com.cyro.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/heath-check")
    public String healthCheck(){
        return  "OK";
    }

    @PostMapping("signup")
    public void signup(@RequestBody User user){
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        userService.saveNewUser(newUser);
    }

}