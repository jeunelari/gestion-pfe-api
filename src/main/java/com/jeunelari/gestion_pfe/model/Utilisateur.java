package com.jeunelari.gestion_pfe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.InheritanceType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "utilisateur")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor 
public class Utilisateur {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "nom_utilisateur", nullable = false, unique = true, length = 50) 
    private String nomUtilisateur;

    @Column(name = "mot_de_passe", nullable = false, length = 100)
    private String motDePasse;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Column(name = "nom_complet", nullable = false, length = 100)
    private String nomComplet;
    
    
    
    public void seConnecter() {
       
    }

    public void changerMotDePasse(String nouveauMotDePasse) {
        this.motDePasse = nouveauMotDePasse;
    }
}
