package com.cyro.springDataJPA.demo.dto;

import com.cyro.springDataJPA.demo.entities.Game;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateGameOfStudent {
    private Set<Game> gameNames;
}