package com.jeunelari.gestion_pfe.controller;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;
import com.jeunelari.gestion_pfe.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/utilisateurs/creer")
    public Utilisateur creerUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO.getRole() == null || utilisateurDTO.getNomUtilisateur() == null) {
            throw new IllegalArgumentException("Les informations de l'utilisateur sont incomplètes.");
        }

        // Utiliser le service pour créer l'utilisateur
        Utilisateur utilisateur = utilisateurService.creerUtilisateur(utilisateurDTO);
        return utilisateur;
    }


    @GetMapping("/utilisateurs/lister")
    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @PutMapping("/utilisateurs/{id}")
    public Utilisateur modifierUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("/utilisateurs/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
    }
}
