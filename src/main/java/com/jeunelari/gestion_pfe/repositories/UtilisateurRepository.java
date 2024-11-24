package com.jeunelari.gestion_pfe.repositories;

import com.jeunelari.gestion_pfe.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
}
