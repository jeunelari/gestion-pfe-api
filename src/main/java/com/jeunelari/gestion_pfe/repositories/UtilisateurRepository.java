package com.jeunelari.gestion_pfe.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeunelari.gestion_pfe.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Recherche par nom d'utilisateur
    Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);
}
