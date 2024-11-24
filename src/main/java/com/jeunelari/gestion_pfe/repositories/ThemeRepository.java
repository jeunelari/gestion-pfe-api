package com.jeunelari.gestion_pfe.repositories;


import com.jeunelari.gestion_pfe.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Theme findByTitre(String titre);
    Theme findByEtudiantId(Long etudiantId);
}
