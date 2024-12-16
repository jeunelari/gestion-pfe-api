package com.jeunelari.gestion_pfe.service;

import com.jeunelari.gestion_pfe.dto.AnnonceDTO;

import java.util.List;

public interface AnnonceService {
    AnnonceDTO creerAnnonce(AnnonceDTO annonceDTO);

    AnnonceDTO modifierAnnonce(Long id, AnnonceDTO annonceDTO);

    void supprimerAnnonce(Long id);

    List<AnnonceDTO> listerAnnonces();
}
