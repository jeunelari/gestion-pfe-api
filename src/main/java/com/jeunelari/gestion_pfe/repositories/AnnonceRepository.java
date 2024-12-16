package com.jeunelari.gestion_pfe.repositories;

import com.jeunelari.gestion_pfe.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}
