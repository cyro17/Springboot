package com.cyro.jwt_demo_v1.services;

import com.cyro.jwt_demo_v1.dto.UserRequestDTO;
import com.cyro.jwt_demo_v1.entities.User;
import com.cyro.jwt_demo_v1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Boolean saveUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Boolean saveAdmin(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("ADMIN"));
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public List<User> allUser(){
        return  userRepo.findAll();
    }
}
