package com.jeunelari.gestion_pfe.mappers;

import com.jeunelari.gestion_pfe.dto.AnnonceDTO;
import com.jeunelari.gestion_pfe.entities.Annonce;
import org.springframework.stereotype.Component;

@Component
public class AnnonceMapper {
    public AnnonceDTO toDTO(Annonce annonce) {
        AnnonceDTO dto = new AnnonceDTO();
        dto.setId(annonce.getId());
        dto.setTitre(annonce.getTitre());
        dto.setContenu(annonce.getContenu());
        dto.setDate(annonce.getDate());
        return dto;
    }

    public Annonce toEntity(AnnonceDTO dto) {
        Annonce annonce = new Annonce();
        annonce.setId(dto.getId());
        annonce.setTitre(dto.getTitre());
        annonce.setContenu(dto.getContenu());
        annonce.setDate(dto.getDate());
        return annonce;
    }
}
