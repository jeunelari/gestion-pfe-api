package com.jeunelari.gestion_pfe.controller;

import lombok.Data;

@Data
public class LoginRequest {
    private String nomUtilisateur;
    private String motDePasse;
}
