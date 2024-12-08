package com.jeunelari.gestion_pfe.mappers;


import com.jeunelari.gestion_pfe.dto.EtudiantDTO;
import com.jeunelari.gestion_pfe.entities.Etudiant;

public class EtudiantMapper {
    public static EtudiantDTO toDTO(Etudiant etudiant) {
        EtudiantDTO dto = new EtudiantDTO();
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setNomUtilisateur(etudiant.getNomUtilisateur());
        dto.setRole(etudiant.getRole().name());
        dto.setMatricule(etudiant.getMatricule());
        dto.setClasseId(etudiant.getClasse().getId());
        dto.setFiliereId(etudiant.getFiliere().getId());
        return dto;
    }
}