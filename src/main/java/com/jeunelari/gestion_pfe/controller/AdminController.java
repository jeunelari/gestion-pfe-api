package com.jeunelari.gestion_pfe.controller;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;
import com.jeunelari.gestion_pfe.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.jeunelari.gestion_pfe.dto.AnnonceDTO;
import com.jeunelari.gestion_pfe.dto.ClasseDTO;
import com.jeunelari.gestion_pfe.dto.FiliereDTO;
import com.jeunelari.gestion_pfe.dto.OptionDTO;
import com.jeunelari.gestion_pfe.service.AnnonceService;
import com.jeunelari.gestion_pfe.service.ClasseService;
import com.jeunelari.gestion_pfe.service.FiliereService;
import com.jeunelari.gestion_pfe.service.OptionService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final OptionService optionService;
    private final ClasseService classeService;
    private final FiliereService filiereService;
    private final AnnonceService annonceService;

    public AdminController(OptionService optionService, ClasseService classeService, FiliereService filiereService, AnnonceService annonceService) {
        this.optionService = optionService;
        this.classeService = classeService;
        this.filiereService = filiereService;
        this.annonceService = annonceService;

    }

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/utilisateurs/creer")
    public Utilisateur creerUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO.getRole() == null || utilisateurDTO.getNomUtilisateur() == null || utilisateurDTO.getMotDePasse() == null) {
            throw new IllegalArgumentException("Les informations de l'utilisateur sont incomplètes.");
        }

        // Encodage du mot de passe avant de l'enregistrer
        String motDePasseEncode = passwordEncoder.encode(utilisateurDTO.getMotDePasse());
        utilisateurDTO.setMotDePasse(motDePasseEncode); // Remplacer le mot de passe par la version encodée

        // Utiliser le service pour créer l'utilisateur
        Utilisateur utilisateur = utilisateurService.creerUtilisateur(utilisateurDTO);
        return utilisateur;
    }

    @GetMapping("/utilisateurs/lister")
    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @PutMapping("/utilisateurs/{id}")
    public Utilisateur modifierUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        if (utilisateur.getMotDePasse() != null) {
            // Encodage du mot de passe si modifié
            String motDePasseEncode = passwordEncoder.encode(utilisateur.getMotDePasse());
            utilisateur.setMotDePasse(motDePasseEncode); // Remplacer le mot de passe par la version encodée
        }

        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }
    
    @DeleteMapping("/utilisateurs/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
    }

    // CRUD Filière
    @PostMapping("/filieres/creer")
    public ResponseEntity<FiliereDTO> creerFiliere(@RequestBody FiliereDTO filiereDTO) {
        FiliereDTO nouvelleFiliere = filiereService.creerFiliere(filiereDTO);
        return ResponseEntity.ok(nouvelleFiliere);
    }
    
    @PutMapping("/filieres/modifier/{id}")
    public ResponseEntity<FiliereDTO> modifierFiliere(@PathVariable Long id, @RequestBody FiliereDTO filiereDTO) {
        FiliereDTO filiereModifiee = filiereService.modifierFiliere(id, filiereDTO);
        return ResponseEntity.ok(filiereModifiee);
    }

    @DeleteMapping("/filieres/supprimer/{id}")
    public ResponseEntity<Void> supprimerFiliere(@PathVariable Long id) {
        filiereService.supprimerFiliere(id);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/filieres/lister")
    public ResponseEntity<List<FiliereDTO>> listerFilieres() {
        List<FiliereDTO> filieres = filiereService.listerFilieres();
        return ResponseEntity.ok(filieres);
    }

    // CRUD Classe

    @PostMapping("/classes/creer")
    public ResponseEntity<ClasseDTO> creerClasse(@RequestBody ClasseDTO classeDTO) {
        ClasseDTO nouvelleClasse = classeService.creerClasse(classeDTO);
        return ResponseEntity.ok(nouvelleClasse);
    }

    @PutMapping("/classes/modifier/{id}")
    public ResponseEntity<ClasseDTO> modifierClasse(@PathVariable Long id, @RequestBody ClasseDTO classeDTO) {
        ClasseDTO classeModifiee = classeService.modifierClasse(id, classeDTO);
        return ResponseEntity.ok(classeModifiee);
    }

    @DeleteMapping("/classes/supprimer/{id}")
    public ResponseEntity<Void> supprimerClasse(@PathVariable Long id) {
        classeService.supprimerClasse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/classes/lister")
    public ResponseEntity<List<ClasseDTO>> listerClasses() {
        List<ClasseDTO> classes = classeService.listerClasses();
        return ResponseEntity.ok(classes);
    }

    // CRUD Option

    @PostMapping("/options/creer")
    public ResponseEntity<OptionDTO> creerOption(@RequestBody OptionDTO optionDTO) {
        OptionDTO nouvelleOption = optionService.creerOption(optionDTO);
        return ResponseEntity.ok(nouvelleOption);
    }

    @PutMapping("/options/modifier/{id}")
    public ResponseEntity<OptionDTO> modifierOption(@PathVariable Long id, @RequestBody OptionDTO optionDTO) {
        OptionDTO optionModifiee = optionService.modifierOption(id, optionDTO);
        return ResponseEntity.ok(optionModifiee);
    }

    @DeleteMapping("/options/supprimer/{id}")
    public ResponseEntity<Void> supprimerOption(@PathVariable Long id) {
        optionService.supprimerOption(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/options/lister")
    public ResponseEntity<List<OptionDTO>> listerOptions() {
        List<OptionDTO> options = optionService.listerOptions();
        return ResponseEntity.ok(options);
    }
    
 // CRUD Annonces
    @PostMapping("/annonces/creer")
    public ResponseEntity<AnnonceDTO> creerAnnonce(@RequestBody AnnonceDTO annonceDTO) {
        AnnonceDTO nouvelleAnnonce = annonceService.creerAnnonce(annonceDTO);
        return ResponseEntity.ok(nouvelleAnnonce);
    }

    @PutMapping("/annonces/modifier/{id}")
    public ResponseEntity<AnnonceDTO> modifierAnnonce(@PathVariable Long id, @RequestBody AnnonceDTO annonceDTO) {
        AnnonceDTO annonceModifiee = annonceService.modifierAnnonce(id, annonceDTO);
        return ResponseEntity.ok(annonceModifiee);
    }

    @DeleteMapping("/annonces/supprimer/{id}")
    public ResponseEntity<Void> supprimerAnnonce(@PathVariable Long id) {
        annonceService.supprimerAnnonce(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/annonces/lister")
    public ResponseEntity<List<AnnonceDTO>> listerAnnonces() {
        List<AnnonceDTO> annonces = annonceService.listerAnnonces();
        return ResponseEntity.ok(annonces);
    }

}
