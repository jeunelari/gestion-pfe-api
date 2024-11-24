package com.jeunelari.gestion_pfe.repositories;

import com.jeunelari.gestion_pfe.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}