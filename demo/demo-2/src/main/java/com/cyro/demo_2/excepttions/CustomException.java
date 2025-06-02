package com.cyro.demo_2.excepttions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException {

    HttpStatusCode statusCode;
    @Getter
    public String message;

    public  CustomException(HttpStatus status, String message){
        this.statusCode = status;
        this.message = message;

    }

    public HttpStatusCode getStatus() {
        return  this.statusCode;
    }

    public String message(){return  this.message;}
}
