package com.cyro.spjpaDemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    @Indexed(unique = true, sparse = true, direction = IndexDirection.ASCENDING)
    private String name;

    @DBRef
    private Author author;
}
