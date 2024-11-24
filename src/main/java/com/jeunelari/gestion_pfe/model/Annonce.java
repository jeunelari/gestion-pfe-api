package com.jeunelari.gestion_pfe.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String contenu;

    private LocalDateTime datePublication;

    public void publierAnnonce(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
        this.datePublication = LocalDateTime.now();
    }
}
