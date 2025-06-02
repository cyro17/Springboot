package com.cyro.springDataJPA.demo.services;

import com.cyro.springDataJPA.demo.dto.NewTeacherRequest;
import com.cyro.springDataJPA.demo.dto.UpdateGameOfStudent;
import com.cyro.springDataJPA.demo.entities.Game;
import com.cyro.springDataJPA.demo.entities.Student;
import com.cyro.springDataJPA.demo.entities.Subject;
import com.cyro.springDataJPA.demo.entities.Teacher;
import com.cyro.springDataJPA.demo.repositories.GamesRepo;
import com.cyro.springDataJPA.demo.repositories.StudentRepo;
import com.cyro.springDataJPA.demo.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.LongToDoubleFunction;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private GamesRepo gamesRepo;

    public Student createStudent(Student student){
        Student savedStudent = studentRepo.save(student);
        return  savedStudent;
    }

    public List<Student> getAllStudents(){
        List<Student> all = studentRepo.findAll();
        if(all != null) return  all;
        return null;
    }

    public void deleteAllStudents(){
        studentRepo.deleteAllInBatch();
    }

    public void deleteStudentById(Long roll){
        System.out.println(roll);
        Student student = studentRepo.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found ! "));

        // remove teacher from student
        if(student.getTeacher() != null){
            student.getTeacher().getStudents().removeIf(s->s.getRoll().equals(roll));
            student.setTeacher(null);
        }
        studentRepo.delete(student);
    }

    public void updateTeacherForStudent(Long roll, NewTeacherRequest newTeacherRequest){
        Student student = studentRepo.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found in db !!"));
        if(student.getTeacher() != null) {
            student.setTeacher(null);
        }


        Optional<Teacher> teacherByName = teacherRepo.findByName(newTeacherRequest.getTeacherName());
        if(!teacherByName.isPresent()){
            Teacher newteacher = new Teacher();
            newteacher.setName(newTeacherRequest.getTeacherName());
            newteacher.getStudents().add(student);

            student.setTeacher(newteacher);

            teacherRepo.save(newteacher);
        }
        // if teacher is present in the database
        else {
            student.setTeacher(teacherByName.get());
        }

        studentRepo.save(student);

    }

    public  void updateGamesForStudent(Long roll, UpdateGameOfStudent request){
        Student student = studentRepo.findById(roll).orElseThrow(() -> new RuntimeException("Student not found"));

        Set<Game> games = request.getGameNames().stream()
                .map(name ->
                        gamesRepo.findByName(String.valueOf(name))
                                .orElseThrow(() -> new RuntimeException("game not found " + name))
                )
                .collect(Collectors.toSet());

        student.setGames(games);
        studentRepo.save(student);
    }






}
