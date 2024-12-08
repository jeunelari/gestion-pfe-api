package com.jeunelari.gestion_pfe.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeunelari.gestion_pfe.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
