package com.jeunelari.gestion_pfe.dto;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String motDePasse;
    private String role; // ADMIN, ETUDIANT, ENSEIGNANT
}