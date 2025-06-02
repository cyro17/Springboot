package com.cyro.springDataJPA.demo.controllers;

import com.cyro.springDataJPA.demo.entities.Teacher;
import com.cyro.springDataJPA.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("ok ", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.createTeacher(teacher);
        return  savedTeacher != null ?
                new ResponseEntity<>(savedTeacher, HttpStatus.CREATED) :
                new ResponseEntity<>("bad request" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> getAllTeacher(){
        List<Teacher> allTeacher = teacherService.getAllTeacher();
        return  allTeacher != null ?
                new ResponseEntity<>(allTeacher, HttpStatus.OK ) :
                new ResponseEntity<>("no content found ", HttpStatus.NO_CONTENT);
    }
}
