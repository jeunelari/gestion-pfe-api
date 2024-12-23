package com.jeunelari.gestion_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Admin;
import com.jeunelari.gestion_pfe.entities.Classe;
import com.jeunelari.gestion_pfe.entities.Enseignant;
import com.jeunelari.gestion_pfe.entities.Etudiant;
import com.jeunelari.gestion_pfe.entities.Filiere;
import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.ClasseRepository;
import com.jeunelari.gestion_pfe.repositories.FiliereRepository;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private ClasseRepository classeRepository;

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

        // Déterminer le rôle et construire l'utilisateur
        switch (Utilisateur.Role.valueOf(utilisateurDTO.getRole().toUpperCase())) {
            case ADMIN:
                utilisateur = new Admin();
                break;

            case ETUDIANT:
                utilisateur = creerEtudiant(utilisateurDTO);
                break;

            case ENSEIGNANT:
                utilisateur = creerEnseignant(utilisateurDTO);
                break;

            default:
                throw new IllegalArgumentException("Rôle non reconnu : " + utilisateurDTO.getRole());
        }

        // Champs communs
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setNomUtilisateur(utilisateurDTO.getNomUtilisateur());
        utilisateur.setTelephone(utilisateurDTO.getTelephone());
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
        utilisateur.setRole(Utilisateur.Role.valueOf(utilisateurDTO.getRole().toUpperCase()));

        return utilisateurRepository.save(utilisateur);
    }

    private Etudiant creerEtudiant(UtilisateurDTO utilisateurDTO) {
        Etudiant etudiant = new Etudiant();
        etudiant.setMatricule(utilisateurDTO.getMatricule());

        // Charger et associer la Filière
        if (utilisateurDTO.getFiliereId() != null) {
            Filiere filiere = filiereRepository.findById(utilisateurDTO.getFiliereId())
                    .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
            etudiant.setFiliere(filiere);
        }

        // Charger et associer la Classe
        if (utilisateurDTO.getClasseId() != null) {
            Classe classe = classeRepository.findById(utilisateurDTO.getClasseId())
                    .orElseThrow(() -> new IllegalArgumentException("Classe introuvable"));
            etudiant.setClasse(classe);
        }

        return etudiant;
    }

    private Enseignant creerEnseignant(UtilisateurDTO utilisateurDTO) {
        Enseignant enseignant = new Enseignant();
        enseignant.setCourriel(utilisateurDTO.getCourriel());

        // Charger et associer la Filière
        if (utilisateurDTO.getFiliereId() != null) {
            Filiere filiere = filiereRepository.findById(utilisateurDTO.getFiliereId())
                    .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
            enseignant.setFiliere(filiere);
        }

        return enseignant;
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

        // Mise à jour spécifique selon le rôle
        if (utilisateur instanceof Etudiant) {
            Etudiant etudiant = (Etudiant) utilisateur;
            etudiant.setMatricule(utilisateurDTO.getMatricule());

            if (utilisateurDTO.getFiliereId() != null) {
                Filiere filiere = filiereRepository.findById(utilisateurDTO.getFiliereId())
                        .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
                etudiant.setFiliere(filiere);
            }

            if (utilisateurDTO.getClasseId() != null) {
                Classe classe = classeRepository.findById(utilisateurDTO.getClasseId())
                        .orElseThrow(() -> new IllegalArgumentException("Classe introuvable"));
                etudiant.setClasse(classe);
            }
        } else if (utilisateur instanceof Enseignant) {
            Enseignant enseignant = (Enseignant) utilisateur;
            enseignant.setCourriel(utilisateurDTO.getCourriel());

            if (utilisateurDTO.getFiliereId() != null) {
                Filiere filiere = filiereRepository.findById(utilisateurDTO.getFiliereId())
                        .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
                enseignant.setFiliere(filiere);
            }
        }

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
