package com.jeunelari.gestion_pfe.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AnnonceDTO {
    private Long id;
    private String titre;
    private String contenu;
    private LocalDate date; // Utilisation de LocalDate au lieu de Date
}
