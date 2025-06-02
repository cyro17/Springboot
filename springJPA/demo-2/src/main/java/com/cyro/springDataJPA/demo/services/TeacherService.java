package com.cyro.springDataJPA.demo.services;

import com.cyro.springDataJPA.demo.entities.Teacher;
import com.cyro.springDataJPA.demo.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public Teacher createTeacher(Teacher teacher){
        Teacher savedTeacher = teacherRepo.save(teacher);
        if(savedTeacher != null)
            return  savedTeacher;
        return  null;
    }

    public List<Teacher> getAllTeacher(){
        return  teacherRepo.findAll();
    }
}
