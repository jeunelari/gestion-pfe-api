package com.jeunelari.gestion_pfe.dto;

import java.util.Set;

import lombok.Data;

@Data
public class EnseignantDTO extends UtilisateurDTO {
    private Long filiereId;
    private Set<Long> classeIds;
}
