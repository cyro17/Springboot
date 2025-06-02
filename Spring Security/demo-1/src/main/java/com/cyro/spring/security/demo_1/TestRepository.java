package com.cyro.spring.security.demo_1;

import com.cyro.spring.security.demo_1.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);

}
