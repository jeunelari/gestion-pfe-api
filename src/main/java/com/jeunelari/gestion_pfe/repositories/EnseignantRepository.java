package com.jeunelari.gestion_pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeunelari.gestion_pfe.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
