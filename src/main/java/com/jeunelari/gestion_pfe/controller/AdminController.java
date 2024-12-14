package com.jeunelari.gestion_pfe.controller;

import com.jeunelari.gestion_pfe.dto.UtilisateurDTO;
import com.jeunelari.gestion_pfe.entities.Utilisateur;
import com.jeunelari.gestion_pfe.repositories.UtilisateurRepository;
import com.jeunelari.gestion_pfe.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.jeunelari.gestion_pfe.dto.ClasseDTO;
import com.jeunelari.gestion_pfe.dto.FiliereDTO;
import com.jeunelari.gestion_pfe.dto.OptionDTO;
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

    public AdminController(OptionService optionService, ClasseService classeService, FiliereService filiereService) {
        this.optionService = optionService;
        this.classeService = classeService;
        this.filiereService = filiereService;
    }

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/utilisateurs/creer")
    public Utilisateur creerUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO.getRole() == null || utilisateurDTO.getNomUtilisateur() == null) {
            throw new IllegalArgumentException("Les informations de l'utilisateur sont incomplètes.");
        }

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
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("/utilisateurs/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
    }
    
 // Filiere endpoints
    @GetMapping("/filieres")
    public List<FiliereDTO> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @PostMapping("/filieres")
    public FiliereDTO createFiliere(@RequestBody FiliereDTO filiereDTO) {
        return filiereService.createFiliere(filiereDTO);
    }

    @PutMapping("/filieres/{id}")
    public FiliereDTO updateFiliere(@PathVariable Long id, @RequestBody FiliereDTO filiereDTO) {
        return filiereService.updateFiliere(id, filiereDTO);
    }

    @DeleteMapping("/filieres/{id}")
    public void deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
    }

 // Classe endpoints
    @GetMapping("/classes")
    public List<ClasseDTO> getAllClasses() {
        return classeService.getAllClasses();
    }

    @PostMapping("/classes")
    public ClasseDTO createClasse(@RequestBody ClasseDTO classeDTO) {
        return classeService.createClasse(classeDTO);
    }

    @PutMapping("/classes/{id}")
    public ClasseDTO updateClasse(@PathVariable Long id, @RequestBody ClasseDTO classeDTO) {
        return classeService.updateClasse(id, classeDTO);
    }

    @DeleteMapping("/classes/{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
    }
    
 // Option endpoints
    @GetMapping("/options")
    public List<OptionDTO> getAllOptions() {
        return optionService.getAllOptions();
    }

    @PostMapping("/options")
    public OptionDTO createOption(@RequestBody OptionDTO optionDTO) {
        return optionService.createOption(optionDTO);
    }

    @PutMapping("/options/{id}")
    public OptionDTO updateOption(@PathVariable Long id, @RequestBody OptionDTO optionDTO) {
        return optionService.updateOption(id, optionDTO);
    }

    @DeleteMapping("/options/{id}")
    public void deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
    }
}
