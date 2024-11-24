package com.jeunelari.gestion_pfe.repositories;


import com.jeunelari.gestion_pfe.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    Annonce findByTitre(String titre);
}

