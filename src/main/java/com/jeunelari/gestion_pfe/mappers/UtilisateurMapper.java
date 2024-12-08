package com.jeunelari.gestion_pfe.mappers;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Utilisateur;


import com.jeunelari.gestion_pfe.entities.*;

public class UtilisateurMapper {

    public Utilisateur convertirDtoEnUtilisateur(UtilisateurDTO dto) {
        Utilisateur utilisateur;

        switch (dto.getRole().toUpperCase()) {
            case "ADMIN":
                utilisateur = new Admin();
                break;
            case "ETUDIANT":
                utilisateur = new Etudiant();
                break;
            case "ENSEIGNANT":
                utilisateur = new Enseignant();
                break;
            default:
                throw new IllegalArgumentException("Role inconnu : " + dto.getRole());
        }

        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setNomUtilisateur(dto.getNomUtilisateur());
        utilisateur.setMotDePasse(dto.getMotDePasse());
        utilisateur.setRole(Utilisateur.Role.valueOf(dto.getRole().toUpperCase()));

        return utilisateur;
    }
}
