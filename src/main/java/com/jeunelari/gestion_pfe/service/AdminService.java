package com.jeunelari.gestion_pfe.service;

import org.springframework.stereotype.Service;
import com.jeunelari.gestion_pfe.entities.Admin;
import com.jeunelari.gestion_pfe.repositories.AdminRepository;
import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin introuvable avec ID : " + id));
    }

    public void delete(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Admin introuvable avec ID : " + id);
        }
    }
}
