package com.jeunelari.gestion_pfe.mappers;

import com.jeunelari.gestion_pfe.dto.FiliereDTO;
import com.jeunelari.gestion_pfe.entities.Filiere;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {
    public FiliereDTO toDTO(Filiere filiere) {
        FiliereDTO dto = new FiliereDTO();
        dto.setId(filiere.getId());
        dto.setNom(filiere.getNom());
        return dto;
    }

    public Filiere toEntity(FiliereDTO dto) {
        Filiere filiere = new Filiere();
        filiere.setId(dto.getId());
        filiere.setNom(dto.getNom());
        return filiere;
    }
}