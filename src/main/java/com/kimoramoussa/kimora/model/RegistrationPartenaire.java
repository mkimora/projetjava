package com.kimoramoussa.kimora.model;

import java.math.BigInteger;

public class RegistrationPartenaire {
//partenaire
    private String adresse_u;
    private String email;
    private String etat_u;
    private String ninea;
    private String nom_complet_u;
    private String raison_sociale;
    private String telephone;
    private String username;



    //user


    private String name;
    private String password;
    private String statut;
    private String adresse;
    private Long profil;




    //compte
    private int num_compte;
    private BigInteger solde_c;



    public String getAdresse_u() {
        return adresse_u;
    }

    public void setAdresse_u(String adresse_u) {
        this.adresse_u = adresse_u;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEtat_u() {
        return etat_u;
    }

    public void setEtat_u(String etat_u) {
        this.etat_u = etat_u;
    }

    public String getNinea() { return ninea; }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getNom_complet_u() {
        return nom_complet_u;
    }

    public void setNom_complet_u(String nom_complet_u) {
        this.nom_complet_u = nom_complet_u;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getProfil() {
        return profil;
    }

    public void setProfil(Long profil) {
        this.profil = profil;
    }

    public int getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(int num_compte) {
        this.num_compte = num_compte;
    }

    public BigInteger getSolde_c() {
        return solde_c;
    }

    public void setSolde_c(BigInteger solde_c) {
        this.solde_c = solde_c;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
