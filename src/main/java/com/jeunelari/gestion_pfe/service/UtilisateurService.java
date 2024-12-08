package com.jeunelari.gestion_pfe.service;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur creerUtilisateur(UtilisateurDTO utilisateurDTO);

    Utilisateur modifierUtilisateur(Long id, UtilisateurDTO utilisateurDTO);

    void supprimerUtilisateur(Long id);

    List<Utilisateur> listerUtilisateurs();
}
