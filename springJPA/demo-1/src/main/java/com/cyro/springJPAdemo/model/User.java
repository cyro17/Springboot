package com.cyro.springJPAdemo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Data
public class User {
    @Id
    private int userId;

    private String name;
    private String role;

}
