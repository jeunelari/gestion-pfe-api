package com.jeunelari.gestion_pfe.repositories;


import com.jeunelari.gestion_pfe.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByNomUtilisateur(String nomUtilisateur);
}
