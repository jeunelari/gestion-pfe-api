package com.jeunelari.gestion_pfe.dto;

import lombok.Data;
import java.util.Date;

@Data
public class AnnonceDTO {
    private Long id;
    private String titre;
    private String contenu;
    private Date date;
}
