package com.cyro.demo_2.excepttions;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class GlobalCustomExceptionHandler {

//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<?> handleCustomException(CustomException customException){
//        return  new ResponseEntity<>(customException.message, HttpStatus.FORBIDDEN);
//    }
//
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<?> handleCustomException(RuntimeException runtimeException){
//        return  new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.FORBIDDEN);
//    }

}
