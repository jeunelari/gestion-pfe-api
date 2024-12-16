package com.jeunelari.gestion_pfe.service;

import com.jeunelari.gestion_pfe.dto.OptionDTO;
import com.jeunelari.gestion_pfe.entities.Filiere;
import com.jeunelari.gestion_pfe.entities.Option;
import com.jeunelari.gestion_pfe.mappers.OptionMapper;
import com.jeunelari.gestion_pfe.repositories.FiliereRepository;
import com.jeunelari.gestion_pfe.repositories.OptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private OptionMapper optionMapper;

    @Override
    public OptionDTO creerOption(OptionDTO optionDTO) {
        Filiere filiere = filiereRepository.findById(optionDTO.getFiliereId())
                .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
        Option option = optionMapper.toEntity(optionDTO, filiere);
        return optionMapper.toDTO(optionRepository.save(option));
    }

    @Override
    public OptionDTO modifierOption(Long id, OptionDTO optionDTO) {
        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Option introuvable"));
        Filiere filiere = filiereRepository.findById(optionDTO.getFiliereId())
                .orElseThrow(() -> new IllegalArgumentException("Filière introuvable"));
        option.setNom(optionDTO.getNom());
        option.setFiliere(filiere);
        return optionMapper.toDTO(optionRepository.save(option));
    }

    @Override
    public void supprimerOption(Long id) {
        optionRepository.deleteById(id);
    }

    @Override
    public List<OptionDTO> listerOptions() {
        return optionRepository.findAll().stream().map(optionMapper::toDTO).collect(Collectors.toList());
    }
}
