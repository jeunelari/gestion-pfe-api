package com.jeunelari.gestion_pfe.model;

import jakarta.persistence.*;

@Entity
public class Etudiant extends Utilisateur {

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    
    
    public void proposerTheme() {
    }

    public void demanderTutorat() {
    }
}

