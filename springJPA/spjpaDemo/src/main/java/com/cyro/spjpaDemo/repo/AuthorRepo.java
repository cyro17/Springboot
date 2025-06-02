package com.cyro.spjpaDemo.repo;

import com.cyro.spjpaDemo.model.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author, ObjectId> {
}
