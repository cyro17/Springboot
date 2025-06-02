package com.cyro.spjpaDemo.service;

import com.cyro.spjpaDemo.model.Book;
import com.cyro.spjpaDemo.model.User;
import com.cyro.spjpaDemo.repo.BookRepo;
import com.cyro.spjpaDemo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;

    public List<User> getAllUsers(){
        return  userRepo.findAll();
    }

    public User saveUser(User user){
        return  userRepo.save(user);
    }

    public List<Book> getBooksByUserId(String userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            return user.getBooks(); // Assuming @DBRef fetches the books
        }
        return null;
    }

    public void addBooksToUser(String userID, List<String> bookIds){
        User user = userRepo.findById(userID).orElse(null);
        if(user == null)
            throw new RuntimeException("User not found");
        List<Book> books = bookRepo.findAllById(bookIds);
        if(user.getBooks() == null) user.setBooks(new ArrayList<>());

        user.getBooks().addAll(books);
        userRepo.save(user);
    }

}
