package com.jeunelari.gestion_pfe.mappers;

import org.springframework.stereotype.Component;

import com.jeunelari.gestion_pfe.dto.AdminDTO;
import com.jeunelari.gestion_pfe.entities.Admin;

@Component
public class AdminMapper {
    public AdminDTO toDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setNom(admin.getNom());
        dto.setPrenom(admin.getPrenom());
        dto.setNomUtilisateur(admin.getNomUtilisateur());
        return dto;
    }
}