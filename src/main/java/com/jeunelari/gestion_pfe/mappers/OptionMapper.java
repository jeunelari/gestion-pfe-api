package com.jeunelari.gestion_pfe.mappers;

import com.jeunelari.gestion_pfe.dto.OptionDTO;
import com.jeunelari.gestion_pfe.entities.Filiere;
import com.jeunelari.gestion_pfe.entities.Option;
import org.springframework.stereotype.Component;

@Component
public class OptionMapper {
    public OptionDTO toDTO(Option option) {
        OptionDTO dto = new OptionDTO();
        dto.setId(option.getId());
        dto.setNom(option.getNom());
        dto.setFiliereId(option.getFiliere().getId());
        return dto;
    }

    public Option toEntity(OptionDTO dto, Filiere filiere) {
        Option option = new Option();
        option.setId(dto.getId());
        option.setNom(dto.getNom());
        option.setFiliere(filiere);
        return option;
    }
}