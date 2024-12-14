package com.jeunelari.gestion_pfe.mappers;
import com.jeunelari.gestion_pfe.dto.ClasseDTO;
import com.jeunelari.gestion_pfe.entities.Classe;
import com.jeunelari.gestion_pfe.entities.Filiere;
import org.springframework.stereotype.Component;
@Component
public class ClasseMapper {
    public ClasseDTO toDTO(Classe classe) {
        ClasseDTO dto = new ClasseDTO();
        dto.setId(classe.getId());
        dto.setNom(classe.getNom());
        dto.setFiliereId(classe.getFiliere() != null ? classe.getFiliere().getId() : null);
        return dto;
    }

    public Classe toEntity(ClasseDTO dto, Filiere filiere) {
        Classe classe = new Classe();
        classe.setId(dto.getId());
        classe.setNom(dto.getNom());
        classe.setFiliere(filiere);
        return classe;
    }
}