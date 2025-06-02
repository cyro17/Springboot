package com.cyro.spjpaDemo.service;

import com.cyro.spjpaDemo.model.Book;
import com.cyro.spjpaDemo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();

    }

    public boolean saveBook(Book book){
        Book savedBook = bookRepo.save(book);
        if (savedBook != null) return  true;
        return false;
    }

}
