package com.cyro.spjpaDemo.controller;

import com.cyro.spjpaDemo.model.Book;
import com.cyro.spjpaDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return  new ResponseEntity<>("all good! ", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println(allBooks);
        return  new ResponseEntity<>(allBooks, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        boolean res = bookService.saveBook(book);
        if(res) return new ResponseEntity<>("book saved", HttpStatus.CREATED);
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);

    }
}
