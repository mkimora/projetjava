package com.kimoramoussa.kimora.controller;


import com.kimoramoussa.kimora.model.Compte;
import com.kimoramoussa.kimora.model.RegistrationCompte;
import com.kimoramoussa.kimora.model.User;
import com.kimoramoussa.kimora.repository.CompteRepository;
import com.kimoramoussa.kimora.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value ="/compte")
public class CompteController {


    //liste des comptes
    //Authorisation par défaut
    //@PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @GetMapping(value = "/listec")
    public List<Compte> liste(){

        return compteRepository.findAll();
    }

    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private CompteRepository compteRepository;

   //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/addcompte",consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Compte addcompte(@RequestBody(required = false) Compte c) {

        //        String nb;
//        nb = "MA"+(10000+(int) Math.random()*(99999-10000));
//        c.setNumeroCompte(nb);

        SimpleDateFormat formater = null;

        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String num_compte = formater.format(now);

        c.setNum_compte(num_compte);
        c.setSolde((double) 0);


        //return veut dire arrête tout ce que tu fais et retourne moi ça
        return compteRepository.save(c);
    }



    }
