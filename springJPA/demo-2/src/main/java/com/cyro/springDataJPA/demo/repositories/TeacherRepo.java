package com.cyro.springDataJPA.demo.repositories;

import com.cyro.springDataJPA.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByName(String name);
}
