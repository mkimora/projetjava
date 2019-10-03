package com.kimoramoussa.kimora.model;

public class RegistrationUser {
    private String email;
    private String name;
    private String password;
    private String username;
    private String statut;
    private String telephone;


    public Long getProfil() {
        return profil;
    }

    public void setProfil(Long profil) {
        this.profil = profil;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    private Long profil;
    //pour récupèrer une clé étrangère
    private Compte compte;
    private Partenaire partenaire;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
