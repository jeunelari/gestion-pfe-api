package com.jeunelari.gestion_pfe.dto;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String telephone;
    private String motDePasse;
    private String role;

    // Champs spécifiques pour les rôles
    private String matricule; // ETUDIANT
    private Long filiereId;   // ETUDIANT & ENSEIGNANT
    private Long classeId;    // ETUDIANT
    private String courriel;  // ENSEIGNANT
}
