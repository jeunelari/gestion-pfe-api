package com.jeunelari.gestion_pfe.model;

import jakarta.persistence.*;

@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_filiere", nullable = false, length = 50)
    private String nomFiliere;
}
