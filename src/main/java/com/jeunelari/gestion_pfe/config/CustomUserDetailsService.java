package com.jeunelari.gestion_pfe.config;

import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));

        // Ajout du rôle comme autorité
        return new org.springframework.security.core.userdetails.User(
                utilisateur.getNomUtilisateur(),
                utilisateur.getMotDePasse(),
                List.of(new SimpleGrantedAuthority(utilisateur.getRole().name())) // Autorité basée sur le rôle
        );
    }
}
