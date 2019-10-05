package com.kimoramoussa.kimora.controller;

import com.kimoramoussa.kimora.model.*;
import com.kimoramoussa.kimora.repository.CompteRepository;
import com.kimoramoussa.kimora.repository.DepotRepository;
import com.kimoramoussa.kimora.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@CrossOrigin
@RequestMapping(value ="/depot")
public class DepotController {
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private DepotRepository depotRepository;
    @Autowired
    private CompteRepository compteRepository;

    @PostMapping(value = "/depotd",consumes = (MediaType.APPLICATION_JSON_VALUE))

    public ResponseEntity<String> depott(@RequestBody(required = false) RegistrationUser registrationUser) {
        Depot d = new Depot();

        d.setDate_depot(new Date());
        d.setMontant(registrationUser.getMontant());
        d.setCompte(registrationUser.getCompte());

        //User user=userDetailsService.getUserConnecte();
       // d.setUser(user);

        //ajout du montant du depot sur le solde du compte
        Compte c = compteRepository.findById(registrationUser.getCompte().getId()).orElseThrow();
        c.setSolde(c.getSolde()+d.getMontant());
        compteRepository.save(c);
        depotRepository.save(d);


        return new ResponseEntity<>("dépôt réussi   ", HttpStatus.OK);

    }
}
