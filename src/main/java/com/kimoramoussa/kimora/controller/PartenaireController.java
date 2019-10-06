package com.kimoramoussa.kimora.controller;


import com.kimoramoussa.kimora.model.*;
import com.kimoramoussa.kimora.repository.PartenaireRepository;
import com.kimoramoussa.kimora.repository.CompteRepository;
import com.kimoramoussa.kimora.repository.UserRepository;
import com.kimoramoussa.kimora.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@CrossOrigin
@RequestMapping(value ="/parte")
public class PartenaireController {

    //liste des partenaires
    //Authorisation par défaut
    //@PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @GetMapping(value = "/listep")
    public List<Partenaire> liste(){

        return partenaireRepository.findAll();
    }


    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private PartenaireRepository partenaireRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private UserRepository userRepository;


    @Autowired
    PasswordEncoder encoder;

    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @PostMapping(value = "/addparte",consumes = (MediaType.APPLICATION_JSON_VALUE))
    //Ajout partenaire
    public Partenaire addpartenaire(@RequestBody(required = false) RegistrationPartenaire registrationPartenaire ) {
        Partenaire p = new Partenaire();
        p.setAdresse_u(registrationPartenaire.getAdresse_u());
        p.setEmail(registrationPartenaire.getEmail());
        p.setEtat_u("actif");
        p.setNinea(registrationPartenaire.getNinea());
        p.setNom_complet_u(registrationPartenaire.getNom_complet_u());
        p.setRaison_sociale(registrationPartenaire.getRaison_sociale());
        p.setTelephone(registrationPartenaire.getTelephone());
        p.setUsername(registrationPartenaire.getUsername());
        partenaireRepository.save(p);


        //Ajout compte
        Compte c = new Compte();
        SimpleDateFormat formater = null;

        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String num_compte = formater.format(now);

        c.setNum_compte(num_compte);
        c.setSolde((double) 0);
        c.setPartenaire(p);
        compteRepository.save(c);



        //Ajout User
        User us = new User();
        us.setEmail(registrationPartenaire.getEmail());
        us.setName(registrationPartenaire.getName());
        us.setPassword(encoder.encode(registrationPartenaire.getPassword()));
        us.setUsername(registrationPartenaire.getUsername());
        us.setTelephone(registrationPartenaire.getTelephone());
        us.setStatut("actif");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(registrationPartenaire.getProfil());
        roles.add(role);
        us.setRoles(roles);
        us.setPartenaire(p);
        us.setCompte(c);
        userRepository.save(us);

        //pour connaitre la personne qui se connecte
       // User user = userDetailsService.getUserConnecte();
       // user.getPartenaire();
       // us.setPartenaire(user.getPartenaire());


        return partenaireRepository.save(p);
    }

}

