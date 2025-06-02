package com.cyro.springDataJPA.demo.controllers;

import com.cyro.springDataJPA.demo.dto.NewTeacherRequest;
import com.cyro.springDataJPA.demo.dto.UpdateGameOfStudent;
import com.cyro.springDataJPA.demo.entities.Student;
import com.cyro.springDataJPA.demo.entities.Teacher;
import com.cyro.springDataJPA.demo.services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try{
            Student savedStudent = studentService.createStudent(student);
            return  new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

        } catch (RuntimeException e) {
            throw new ResponseEntity<>(e, HttpStatus.BAD_REQUEST).getBody();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return  new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return  allStudents != null ?
                new ResponseEntity<>(allStudents, HttpStatus.OK) :
                new ResponseEntity<>("No data found !!", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllStudents(){
        studentService.deleteAllStudents();
        return  new ResponseEntity<>("Deleted all students !!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{roll}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long roll) {
        studentService.deleteStudentById(roll);
        return ResponseEntity.accepted().body("Deleted student with roll: " + roll);
    }

    @PatchMapping("/{roll}/teacher")
    public ResponseEntity<?> updateTeacher(@PathVariable Long roll,
                                           @RequestBody NewTeacherRequest newTeacherRequest){
        studentService.updateTeacherForStudent(roll, newTeacherRequest);
        return  new ResponseEntity<>("teacher updated", HttpStatus.OK);
    }

    @PatchMapping("/{roll}/games")
    public  ResponseEntity<?> updateGameOfStudent(@PathVariable Long roll,
                                                  @RequestBody UpdateGameOfStudent request){
        try {
            studentService.updateGamesForStudent(roll, request);
            return ResponseEntity.ok("Student games updated");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: " + e.getMessage());
        }
    }
}
