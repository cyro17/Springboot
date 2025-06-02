package com.cyro.demo2;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@org.springframework.stereotype.Service
public class TestService {

    RestClient restClient = RestClient.builder().build();

    public Post getPosts(){
        Post post = restClient.get()
                .uri("https://fakestoreapi.com/products/1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Post.class);
        return post;
    }

    public Boolean addPost(Post post){
        ResponseEntity<Void> bodilessEntity = restClient.post()
                .uri("https://fakestoreapi.com/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .toBodilessEntity();

        System.out.println(bodilessEntity);
        return true;
    }


}
