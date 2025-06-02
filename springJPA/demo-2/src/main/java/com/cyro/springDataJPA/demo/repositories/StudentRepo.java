package com.cyro.springDataJPA.demo.repositories;

import com.cyro.springDataJPA.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
