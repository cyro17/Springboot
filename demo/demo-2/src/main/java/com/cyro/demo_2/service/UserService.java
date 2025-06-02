package com.cyro.demo_2.service;

import com.cyro.demo_2.entity.User;
import com.cyro.demo_2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user) {
        try{
            userRepo.save(user);
        } catch (Exception e){
            //
        }
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
