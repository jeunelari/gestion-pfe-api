package com.jeunelari.gestion_pfe.service;

import com.jeunelari.gestion_pfe.dto.ClasseDTO;
import com.jeunelari.gestion_pfe.entities.Classe;
import com.jeunelari.gestion_pfe.entities.Filiere;
import com.jeunelari.gestion_pfe.mappers.ClasseMapper;
import com.jeunelari.gestion_pfe.repositories.ClasseRepository;
import com.jeunelari.gestion_pfe.repositories.FiliereRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private ClasseMapper classeMapper;

    @Override
    public ClasseDTO creerClasse(ClasseDTO classeDTO) {
        Filiere filiere = filiereRepository.findById(classeDTO.getFiliereId())
                .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
        Classe classe = classeMapper.toEntity(classeDTO, filiere);
        return classeMapper.toDTO(classeRepository.save(classe));
    }

    @Override
    public ClasseDTO modifierClasse(Long id, ClasseDTO classeDTO) {
        Classe classe = classeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Classe introuvable"));
        Filiere filiere = filiereRepository.findById(classeDTO.getFiliereId())
                .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
        classe.setNom(classeDTO.getNom());
        classe.setFiliere(filiere);
        return classeMapper.toDTO(classeRepository.save(classe));
    }

    @Override
    public void supprimerClasse(Long id) {
        classeRepository.deleteById(id);
    }

    @Override
    public List<ClasseDTO> listerClasses() {
        return classeRepository.findAll().stream().map(classeMapper::toDTO).collect(Collectors.toList());
    }
}
