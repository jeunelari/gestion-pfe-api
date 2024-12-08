package com.jeunelari.gestion_pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeunelari.gestion_pfe.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
