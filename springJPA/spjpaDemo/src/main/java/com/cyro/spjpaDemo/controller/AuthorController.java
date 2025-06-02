package com.cyro.spjpaDemo.controller;

import com.cyro.spjpaDemo.model.Author;
import com.cyro.spjpaDemo.repo.AuthorRepo;
import com.cyro.spjpaDemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> allAuthors = authorService.getAllAuthors();
        return  new ResponseEntity<>(allAuthors, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createAuthor( @RequestBody Author author){
        Author createdAutor = authorService.createAuthor(author);
        return new ResponseEntity<>(createdAutor, HttpStatus.CREATED);
    }

}
