package com.cyro.spjpaDemo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("authors")
@Data
public class Author {
    @Id
    private ObjectId id;

    @Indexed(unique = true, sparse = true, direction = IndexDirection.ASCENDING)
    private String name;

    @DBRef
    private List<Book> books= new ArrayList<>();
}
