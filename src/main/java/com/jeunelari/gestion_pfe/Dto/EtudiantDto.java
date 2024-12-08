package com.jeunelari.gestion_pfe.dto;

import lombok.Data;

@Data
public class EtudiantDTO extends UtilisateurDTO {
    private String matricule;
    private Long filiereId;
    private Long classeId;
}
