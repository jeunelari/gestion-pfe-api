package com.jeunelari.gestion_pfe.service;

// import com.jeunelari.gestion_pfe.dto.ClasseDTO;
// import com.jeunelari.gestion_pfe.entities.Classe;
// import com.jeunelari.gestion_pfe.entities.Filiere;
// import com.jeunelari.gestion_pfe.mappers.ClasseMapper;
// import com.jeunelari.gestion_pfe.repositories.ClasseRepository;
// import com.jeunelari.gestion_pfe.repositories.FiliereRepository;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;

// @Service
// public class ClasseService {
// 	private final ClasseRepository classeRepository;
//     private final FiliereRepository filiereRepository;
//     private final ClasseMapper classeMapper;

//     public ClasseService(ClasseRepository classeRepository, FiliereRepository filiereRepository, ClasseMapper classeMapper) {
//         this.classeRepository = classeRepository;
//         this.filiereRepository = filiereRepository;
//         this.classeMapper = classeMapper;
//     }

//     public List<ClasseDTO> getAllClasses() {
//         return classeRepository.findAll().stream().map(classeMapper::toDTO).collect(Collectors.toList());
//     }

//     public ClasseDTO createClasse(ClasseDTO classeDTO) {
//         Filiere filiere = filiereRepository.findById(classeDTO.getFiliereId()).orElseThrow(() -> new IllegalArgumentException("Filiere introuvable"));
//         Classe classe = classeMapper.toEntity(classeDTO, filiere);
//         return classeMapper.toDTO(classeRepository.save(classe));
//     }
    
//     public ClasseDTO updateClasse(Long id, ClasseDTO classeDTO) {
//         Classe classe = classeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Classe introuvable"));
//         Filiere filiere = filiereRepository.findById(classeDTO.getFiliereId()).orElseThrow(() -> new IllegalArgumentException("Filiere introuvable"));
//         classe.setNom(classeDTO.getNom());
//         classe.setFiliere(filiere);
//         return classeMapper.toDTO(classeRepository.save(classe));
//     }

//     public void deleteClasse(Long id) {
//         classeRepository.deleteById(id);
//     }
// }


import com.jeunelari.gestion_pfe.dto.ClasseDTO;

import java.util.List;

public interface ClasseService {
    ClasseDTO creerClasse(ClasseDTO classeDTO);

    ClasseDTO modifierClasse(Long id, ClasseDTO classeDTO);

    void supprimerClasse(Long id);

    List<ClasseDTO> listerClasses();
}

