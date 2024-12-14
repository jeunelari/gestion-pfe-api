package com.jeunelari.gestion_pfe.service;
import com.jeunelari.gestion_pfe.dto.FiliereDTO;
import com.jeunelari.gestion_pfe.entities.Filiere;
import com.jeunelari.gestion_pfe.mappers.FiliereMapper;
import com.jeunelari.gestion_pfe.repositories.FiliereRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FiliereService {
	private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;

    public FiliereService(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    public List<FiliereDTO> getAllFilieres() {
        return filiereRepository.findAll().stream().map(filiereMapper::toDTO).collect(Collectors.toList());
    }

    public FiliereDTO createFiliere(FiliereDTO filiereDTO) {
        Filiere filiere = filiereMapper.toEntity(filiereDTO);
        return filiereMapper.toDTO(filiereRepository.save(filiere));
    }

    public FiliereDTO updateFiliere(Long id, FiliereDTO filiereDTO) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Filiere introuvable"));
        filiere.setNom(filiereDTO.getNom());
        return filiereMapper.toDTO(filiereRepository.save(filiere));
    }

    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}
