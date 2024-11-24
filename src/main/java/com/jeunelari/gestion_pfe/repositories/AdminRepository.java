package com.jeunelari.gestion_pfe.repositories;

import com.jeunelari.gestion_pfe.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByNomUtilisateur(String nomUtilisateur);
}