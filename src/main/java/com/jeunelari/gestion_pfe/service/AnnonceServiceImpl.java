package com.jeunelari.gestion_pfe.service;

import com.jeunelari.gestion_pfe.dto.AnnonceDTO;
import com.jeunelari.gestion_pfe.entities.Annonce;
import com.jeunelari.gestion_pfe.mappers.AnnonceMapper;
import com.jeunelari.gestion_pfe.repositories.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private AnnonceMapper annonceMapper;

    @Override
    public AnnonceDTO creerAnnonce(AnnonceDTO annonceDTO) {
        if (annonceDTO.getId() != null && annonceDTO.getId() > 0) {
            throw new IllegalArgumentException("L'annonce ne doit pas avoir d'identifiant lors de la création.");
        }

        Annonce annonce = annonceMapper.toEntity(annonceDTO);
        annonce.setDatePublication(LocalDate.now()); // Fixe la date actuelle comme date de publication
        return annonceMapper.toDTO(annonceRepository.save(annonce));
    }


    @Override
    public AnnonceDTO modifierAnnonce(Long id, AnnonceDTO annonceDTO) {
        Annonce annonce = annonceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Annonce introuvable"));

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("L'identifiant de l'annonce est invalide.");
        }

        annonce.setTitre(annonceDTO.getTitre());
        annonce.setContenu(annonceDTO.getContenu());
        annonce.setDatePublication(annonceDTO.getDate());
        return annonceMapper.toDTO(annonceRepository.save(annonce));
    }


    @Override
    public void supprimerAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }

    @Override
    public List<AnnonceDTO> listerAnnonces() {
        return annonceRepository.findAll().stream().map(annonceMapper::toDTO).collect(Collectors.toList());
    }
}
