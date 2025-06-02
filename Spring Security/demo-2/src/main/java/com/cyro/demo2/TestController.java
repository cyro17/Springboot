package com.cyro.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService service;

    @GetMapping("health-check")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("ok!!!");
    }

    @GetMapping("fetch-all")
    public ResponseEntity<?> fetchAllPosts(){
        return new ResponseEntity<>(service.getPosts(), HttpStatus.OK);
    }

    @PostMapping("addPost")
    public ResponseEntity<?> addPost(@RequestBody Post post){
        Boolean boolResponse = service.addPost(post);
        if (boolResponse)
            return new ResponseEntity<>("post created!!", HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}