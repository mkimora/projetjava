package com.kimoramoussa.kimora.controller;


import com.kimoramoussa.kimora.model.Compte;
import com.kimoramoussa.kimora.model.RegistrationCompte;
import com.kimoramoussa.kimora.repository.CompteRepository;
import com.kimoramoussa.kimora.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(value ="/compte")
public class CompteController {


    //liste des comptes
    //Authorisation par défaut
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @GetMapping(value = "/listec")
    public List<Compte> liste(){

        return compteRepository.findAll();
    }

    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private CompteRepository compteRepository;

   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/addcompte",consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Compte addcompte(@RequestBody(required = false) Compte c) {

        final Calendar cal = Calendar.getInstance();
        final Random rand = new Random();
        final SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");

       cal.set(Calendar.YEAR, 2018);
       //cal.set()définira le champ donné de le Calendar sur la valeur donnée en tant que deuxième argument.
        //Il est utilisé ici pour définir l'année sur 2018 et le jour de l'année sur la valeur aléatoire.

       cal.set(Calendar.DAY_OF_YEAR, rand.nextInt(cal.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1);
       //cal.getActualMaximum(Calendar.DAY_OF_YEAR)renverra le numéro du dernier jour de l’année Calendardéfini dans ( 2018 dans ce code).
        //rand.nextInt()renverra un nombre compris entre 0 (inclus) et le numéro du dernier jour (exclusif). Vous devez ajouter 1car le champ Calendar.DAY_OF_YEARcommence à 1.
        //SimpleDateFormat est utilisé pour imprimer la date au format requis.

        //System.out.println(format.format(cal.getTime()));
        String num_compte = format.format(cal.getTime());
        c.setNum_compte(num_compte);
        c.setSolde_c(75000);

        //return veut dire arrête tout ce que tu fais et retourne moi ça
        return compteRepository.save(c);
    }

    }
