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
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateRendezVous;

    private Integer noteEnseignant;

    private String commentaires;

    private String statut;  // "PROGRAMME", "ANNULÉ", "TERMINÉ"

    public void mettreAjourCommentaire(String commentaire) {
        this.commentaires = commentaire;
    }

    public void annulerRendezVous() {
        this.statut = "ANNULÉ";
    }
}
