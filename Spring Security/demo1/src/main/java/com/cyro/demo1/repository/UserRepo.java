package com.cyro.demo1.repository;

import com.cyro.demo1.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {


    User findByUserName(String userName);
    User deleteByUserName(String userName);
}
