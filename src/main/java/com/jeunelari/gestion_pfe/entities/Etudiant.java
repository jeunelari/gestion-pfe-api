package com.jeunelari.gestion_pfe.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Data;
import lombok.Data;


@Entity
@Data
public class Etudiant extends Utilisateur {
    private String matricule;

    @ManyToOne
    private Filiere filiere;

    @ManyToOne
    private Classe classe;
}