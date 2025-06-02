package com.cyro.spjpaDemo.repo;

import com.cyro.spjpaDemo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepo extends MongoRepository<User, String >{
    User findByEmail(String email);
}
