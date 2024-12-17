package com.jeunelari.gestion_pfe.entities;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    
    @JsonFormat(pattern = "yyyy-MM-dd") // Assurez-vous du bon format
    private LocalDate datePublication; // Remplacez Date par LocalDate

}
