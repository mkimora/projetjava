package com.kimoramoussa.kimora.controller;


import com.kimoramoussa.kimora.model.*;
import com.kimoramoussa.kimora.repository.PartenaireRepository;
import com.kimoramoussa.kimora.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value ="/parte")
public class PartenaireController {

    //liste des partenaires
    //Authorisation par défaut
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @GetMapping(value = "/listep")
    public List<Partenaire> liste(){

        return partenaireRepository.findAll();
    }


    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private PartenaireRepository partenaireRepository;

    @Autowired
    PasswordEncoder encoder;

    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @PostMapping(value = "/addparte",consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Partenaire addpartenaire(@RequestBody(required = false) RegistrationPartenaire registrationPartenaire) {
        Partenaire p = new Partenaire();
        p.setAdresse_u(registrationPartenaire.getAdresse_u());
        p.setEmail(registrationPartenaire.getEmail());
        p.setEtat_u("actif");
        p.setNinea(registrationPartenaire.getNinea());
        p.setNom_complet_u(registrationPartenaire.getNom_complet_u());
        p.setRaison_sociale(registrationPartenaire.getRaison_sociale());
        p.setTelephone(registrationPartenaire.getTelephone());
        p.setUsername(registrationPartenaire.getUsername());


        //User user = userDetailsService.getUserConnecte();
        //user.getPartenaire();
        //us.setPartenaire(user.getPartenaire());
        return partenaireRepository.save(p);

    }
}

