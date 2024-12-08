package com.jeunelari.gestion_pfe.config;

import com.jeunelari.gestion_pfe.entities.Admin;
import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataInitializer {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdminUser() {
        if (utilisateurRepository.findByNomUtilisateur("admin").isEmpty()) {
            Admin admin = new Admin();
            admin.setNom("Admin");
            admin.setPrenom("Super");
            admin.setNomUtilisateur("admin");
            admin.setMotDePasse(passwordEncoder.encode("admin123")); // Mettez un mot de passe fort
            admin.setRole(Utilisateur.Role.ADMIN);

            utilisateurRepository.save(admin);
            System.out.println("Administrateur initialisé avec succès !");
        } else {
            System.out.println("Administrateur déjà présent dans la base de données.");
        }
    }
}
