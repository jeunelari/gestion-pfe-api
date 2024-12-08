package com.jeunelari.gestion_pfe.mappers;

import java.util.stream.Collectors;

import com.jeunelari.gestion_pfe.dto.EnseignantDTO;
import com.jeunelari.gestion_pfe.entities.Classe;
import com.jeunelari.gestion_pfe.entities.Enseignant;

public class EnseignantMapper {

    // Convertir un Enseignant en EnseignantDTO
    public static EnseignantDTO toDTO(Enseignant enseignant) {
        EnseignantDTO dto = new EnseignantDTO();
        dto.setNom(enseignant.getNom());
        dto.setPrenom(enseignant.getPrenom());
        dto.setNomUtilisateur(enseignant.getNomUtilisateur());
        dto.setRole(enseignant.getRole().name());
        dto.setFiliereId(enseignant.getFiliere() != null ? enseignant.getFiliere().getId() : null);

        // Correction : Utilisation de "setClasseIds" pour correspondre à la propriété correcte
        dto.setClasseIds(enseignant.getClasses()
                .stream()
                .map(Classe::getId)
                .collect(Collectors.toSet())); // Collecte dans un Set pour correspondre au type
        return dto;
    }

    // Convertir un EnseignantDTO en Enseignant (entité)
    public static Enseignant toEntity(EnseignantDTO dto) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(dto.getNom());
        enseignant.setPrenom(dto.getPrenom());
        enseignant.setNomUtilisateur(dto.getNomUtilisateur());
        enseignant.setRole(Enseignant.Role.valueOf(dto.getRole()));
        return enseignant;
    }
}
