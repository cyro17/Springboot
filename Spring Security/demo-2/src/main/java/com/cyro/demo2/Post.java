package com.cyro.demo2;

import lombok.Data;

@Data
public class Post {
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;
}
