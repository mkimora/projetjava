package com.kimoramoussa.kimora.controller;

import com.kimoramoussa.kimora.model.AccountUser;
import com.kimoramoussa.kimora.model.RegistrationUser;
import com.kimoramoussa.kimora.model.Role;
import com.kimoramoussa.kimora.model.User;
import com.kimoramoussa.kimora.repository.UserRepository;
import com.kimoramoussa.kimora.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value ="/user")
public class UserController {
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRepository userRepository;


    //liste des users
    //Authorisation par défaut
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/liste")
    public List<User> liste(){

        return userRepository.findAll();
    }

    @Autowired
    PasswordEncoder encoder;
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/add",consumes=(MediaType.APPLICATION_JSON_VALUE))
    public User add (@RequestBody(required = false)
                     RegistrationUser registrationUser) {
        User us = new User();
        us.setEmail(registrationUser.getEmail());
        us.setName(registrationUser.getName());
        us.setPassword(encoder.encode(registrationUser.getPassword()));
        us.setUsername(registrationUser.getUsername());
        us.setTelephone(registrationUser.getTelephone());
        us.setStatut("actif");
        us.setAdresse(registrationUser.getAdresse());
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(registrationUser.getProfil());
        roles.add(role);
        us.setRoles(roles);

        //pour connaitre la personne qui se connecte
        //User user = userDetailsService.getUserConnecte();
        //user.getPartenaire();
        //us.setPartenaire(user.getPartenaire());
        return userRepository.save(us);

    }

    //Bloquer l'utilisateur
   // public UserController(@PathVariable("id")long id) throws Exception{
       // User etat = userRepository.findById(id).orElseThrow(
                //()-> new Exception("Cet utilisateur n'existe pas")
        //);

        //if(statut.getUsername().equals("kim")){
        //return new ResponseEntity<>(statut.getUsername()+"Il ne peut être bloquer,c'est le super admin",
        //  HttpStatus.OK);
        //}
        //if (etat.getStatut().equals("actif")){
          //  etat.setStatut("bloquer");
           // userRepository.save(etat);
            //return new ResponseEntity<>(etat.getUsername()+ " a été bloqué", HttpStatus.OK);
        //}
        //else{
          //  etat.setStatut("bloquer");
            //userRepository.save(etat);
            //return new ResponseEntity<>(etat.getUsername()+ " a été débloqué", HttpStatus.OK);
        //}
    //}


    @PostMapping(value = "/compteUser",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> addCompteUser (@RequestBody(required = false) AccountUser accountUser){
        User user= userRepository.findByUsername(accountUser.getUsername()).orElseThrow();
        user.setUsername(accountUser.getUsername());
        user.setCompte(accountUser.getCompte());
        userRepository.save(user);

        return new ResponseEntity<>("Compte utilsateur ajouté avec succès", HttpStatus.OK);
    }


}



