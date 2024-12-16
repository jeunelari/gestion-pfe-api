package com.jeunelari.gestion_pfe.service;


import com.jeunelari.gestion_pfe.dto.OptionDTO;
import com.jeunelari.gestion_pfe.entities.Filiere;
//import com.jeunelari.gestion_pfe.entities.Option;
//import com.jeunelari.gestion_pfe.mappers.OptionMapper;
//import com.jeunelari.gestion_pfe.repositories.FiliereRepository;
//import com.jeunelari.gestion_pfe.repositories.OptionRepository;

//import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.stream.Collectors;

//@Service
//public class OptionService {
//  private final OptionRepository optionRepository;
//  private final FiliereRepository filiereRepository;
//  private final OptionMapper optionMapper;

//  public OptionService(OptionRepository optionRepository, FiliereRepository filiereRepository, OptionMapper optionMapper) {
//      this.optionRepository = optionRepository;
//      this.filiereRepository = filiereRepository;
//      this.optionMapper = optionMapper;
//  }

//  public List<OptionDTO> getAllOptions() {
//      return optionRepository.findAll().stream().map(optionMapper::toDTO).collect(Collectors.toList());
//  }

//  public OptionDTO createOption(OptionDTO optionDTO) {
//      Filiere filiere = filiereRepository.findById(optionDTO.getFiliereId())
//              .orElseThrow(() -> new IllegalArgumentException("Filiere introuvable"));
//      Option option = optionMapper.toEntity(optionDTO, filiere);
//      return optionMapper.toDTO(optionRepository.save(option));
//  }

//  public OptionDTO updateOption(Long id, OptionDTO optionDTO) {
//      Option option = optionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Option introuvable"));
//      Filiere filiere = filiereRepository.findById(optionDTO.getFiliereId())
//              .orElseThrow(() -> new IllegalArgumentException("Filiere introuvable"));
//      option.setNom(optionDTO.getNom());
//      option.setFiliere(filiere);
//      return optionMapper.toDTO(optionRepository.save(option));
//  }

//  public void deleteOption(Long id) {
//      optionRepository.deleteById(id);
//  }
//}



import java.util.List;

public interface OptionService {
    OptionDTO creerOption(OptionDTO optionDTO);

    OptionDTO modifierOption(Long id, OptionDTO optionDTO);

    void supprimerOption(Long id);

    List<OptionDTO> listerOptions();
}
