package com.cyro.spjpaDemo.repo;

import com.cyro.spjpaDemo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book, String> {
}
