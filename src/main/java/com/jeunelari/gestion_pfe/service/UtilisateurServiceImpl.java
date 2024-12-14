package com.jeunelari.gestion_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Admin;
import com.jeunelari.gestion_pfe.entities.Enseignant;
import com.jeunelari.gestion_pfe.entities.Etudiant;
import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Utilisateur creerUtilisateur(UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO.getRole() == null || utilisateurDTO.getNomUtilisateur() == null) {
            throw new IllegalArgumentException("Les informations de l'utilisateur sont incomplètes.");
        }

        Utilisateur utilisateur;
        switch (Utilisateur.Role.valueOf(utilisateurDTO.getRole().toUpperCase())) {
            case ADMIN:
                utilisateur = new Admin();
                break;
            case ETUDIANT:
                utilisateur = new Etudiant();
                break;
            case ENSEIGNANT:
                utilisateur = new Enseignant();
                break;
            default:
                throw new IllegalArgumentException("Rôle non reconnu : " + utilisateurDTO.getRole());
        }

        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setNomUtilisateur(utilisateurDTO.getNomUtilisateur());
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
        utilisateur.setRole(Utilisateur.Role.valueOf(utilisateurDTO.getRole().toUpperCase()));

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur modifierUtilisateur(Long id, UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setNomUtilisateur(utilisateurDTO.getNomUtilisateur());
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
        utilisateur.setRole(Utilisateur.Role.valueOf(utilisateurDTO.getRole().toUpperCase()));

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    
}
