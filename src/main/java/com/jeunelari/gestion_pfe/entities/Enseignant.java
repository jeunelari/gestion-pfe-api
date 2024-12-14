package com.jeunelari.gestion_pfe.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Enseignant extends Utilisateur {
    private String courriel;

    @ManyToMany
    private Set<Classe> classes;

    @ManyToOne
    private Filiere filiere;
}