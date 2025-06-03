
package com.cyro.demo1.service;

import com.cyro.demo1.entity.User;
import com.cyro.demo1.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public User saveNewUser(User user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            User savedUser = userRepository.save(user);
            return savedUser;
        } catch (Exception e) {
            throw  new RuntimeException("User could not be saved! ");
        }
    }

    public boolean saveAdmin(User user){
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER", "ADMIN"));
            userRepository.save(user);
            return  true;
        } catch (Exception e){
            return  false;
        }
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return  userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return  userRepository.findById(id);
    }

    public boolean deleteById(ObjectId id){
        userRepository.deleteById(id);
        return true;
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public void login(String userName, String password) {

    }
}