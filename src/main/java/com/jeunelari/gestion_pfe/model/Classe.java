package com.jeunelari.gestion_pfe.model;

import jakarta.persistence.*;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_classe", nullable = false, length = 50)
    private String nomClasse;
}
