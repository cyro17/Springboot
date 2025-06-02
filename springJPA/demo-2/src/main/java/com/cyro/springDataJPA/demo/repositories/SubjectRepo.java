package com.cyro.springDataJPA.demo.repositories;

import com.cyro.springDataJPA.demo.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
