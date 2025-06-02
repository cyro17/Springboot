package com.cyro.spring.security.demo_1.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api")
public class UserController {

    @GetMapping("health-check")
    public String healthCheck(){
        return  "ok!!";
    }

}
