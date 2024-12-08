package com.jeunelari.gestion_pfe.controller;

import com.jeunelari.gestion_pfe.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/connexion")
    public String login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getNomUtilisateur(), request.getMotDePasse())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Nom d'utilisateur ou mot de passe incorrect");
        }

        var userDetails = userDetailsService.loadUserByUsername(request.getNomUtilisateur());
        String role = userDetails.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun rôle trouvé pour l'utilisateur"));

        return jwtTokenUtil.generateToken(userDetails.getUsername(), role);
    }
}
