package com.jeunelari.gestion_pfe.repositories;


import com.jeunelari.gestion_pfe.model.RendezVous;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    RendezVous findByDateRendezVous(LocalDateTime dateRendezVous);
}
