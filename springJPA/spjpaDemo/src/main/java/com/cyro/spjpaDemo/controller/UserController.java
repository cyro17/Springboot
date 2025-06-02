package com.cyro.spjpaDemo.controller;

import com.cyro.spjpaDemo.service.UserService;
import com.cyro.spjpaDemo.model.Book;
import com.cyro.spjpaDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return  new ResponseEntity<>("all good! ", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return  new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getBooksByUserId")
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam String userId){
        List<Book> allBooks = userService.getBooksByUserId(userId);
        log.info(allBooks.toString());
        return  new ResponseEntity<>(allBooks, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return new  ResponseEntity("user saved", HttpStatus.ACCEPTED);
    }


}
