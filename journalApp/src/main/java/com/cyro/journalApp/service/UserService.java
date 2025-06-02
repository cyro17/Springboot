package com.cyro.journalApp.service;

import com.cyro.journalApp.entity.User;
import com.cyro.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
    private UserRepository userRepository;

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public boolean saveNewUser(User user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
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

    public String verify(User user){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
            );
            return jwtService.generateToken(user.getUserName());
        } catch (AuthenticationException e) {
            return "Authentication failed!!!";

        }
    }
}