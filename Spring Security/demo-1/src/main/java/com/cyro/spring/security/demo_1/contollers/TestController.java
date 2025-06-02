package com.cyro.spring.security.demo_1.contollers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }
}
