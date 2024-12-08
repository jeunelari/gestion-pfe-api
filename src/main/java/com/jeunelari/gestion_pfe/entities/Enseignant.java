package com.jeunelari.gestion_pfe.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;

@Entity
@Data
public class Enseignant extends Utilisateur {
    @ManyToMany
    private Set<Classe> classes;

    @ManyToOne
    private Filiere filiere;
}