package com.jeunelari.gestion_pfe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    private Filiere filiere;
}