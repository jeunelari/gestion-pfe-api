package com.jeunelari.gestion_pfe.repositories;

import com.jeunelari.gestion_pfe.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Enseignant findByNomUtilisateur(String nomUtilisateur);
}