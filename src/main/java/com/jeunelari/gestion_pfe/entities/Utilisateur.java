package com.jeunelari.gestion_pfe.entities;
import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, 
        include = JsonTypeInfo.As.PROPERTY, 
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
        @JsonSubTypes.Type(value = Etudiant.class, name = "ETUDIANT"),
        @JsonSubTypes.Type(value = Enseignant.class, name = "ENSEIGNANT")
})
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String telephone;
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, ETUDIANT, ENSEIGNANT
    }
}