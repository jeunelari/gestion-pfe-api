package com.jeunelari.gestion_pfe.service;

import com.jeunelari.gestion_pfe.dto.FiliereDTO;
import com.jeunelari.gestion_pfe.entities.Filiere;
import com.jeunelari.gestion_pfe.mappers.FiliereMapper;
import com.jeunelari.gestion_pfe.repositories.FiliereRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereServiceImpl implements FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private FiliereMapper filiereMapper;

    @Override
    public FiliereDTO creerFiliere(FiliereDTO filiereDTO) {
        Filiere filiere = filiereMapper.toEntity(filiereDTO);
        return filiereMapper.toDTO(filiereRepository.save(filiere));
    }

    @Override
    public FiliereDTO modifierFiliere(Long id, FiliereDTO filiereDTO) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
        filiere.setNom(filiereDTO.getNom());
        return filiereMapper.toDTO(filiereRepository.save(filiere));
    }

    @Override
    public void supprimerFiliere(Long id) {
        filiereRepository.deleteById(id);
    }

    @Override
    public List<FiliereDTO> listerFilieres() {
        return filiereRepository.findAll().stream().map(filiereMapper::toDTO).collect(Collectors.toList());
    }
}
