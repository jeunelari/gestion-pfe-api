package com.jeunelari.gestion_pfe.repositories;

import com.jeunelari.gestion_pfe.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}