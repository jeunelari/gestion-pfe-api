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
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private String statut;  // "PROPOSE", "VALIDE", "REJETE"

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;  // Lien avec l'étudiant qui a proposé le thème

    private LocalDateTime dateProposition;

    public void validerTheme() {
        this.statut = "VALIDE";
    }

    public void rejeterTheme() {
        this.statut = "REJETE";
    }
}
