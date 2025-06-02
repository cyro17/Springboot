package com.cyro.springDataJPA.demo.repositories;

import com.cyro.springDataJPA.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GamesRepo extends JpaRepository<Game, Long> {
    Optional<Game> findByName(String name);
}
