package com.cyro.spjpaDemo.service;

import com.cyro.spjpaDemo.model.Author;
import com.cyro.spjpaDemo.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;


    public List<Author> getAllAuthors(){
        return  authorRepo.findAll();
    }

    public Author createAuthor(Author author){
        Author savedAuthor = authorRepo.save(author);
        return savedAuthor;
    }


}
