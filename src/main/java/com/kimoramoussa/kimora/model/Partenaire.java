//migration de id_partenaire vers l'entité compte
package com.kimoramoussa.kimora.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//pour respecter la convention de nomenclature d'une table
@Table(name = "partenaire", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String 	adresse_u;

    private String email;

    private String etat_u;

    private String ninea;

    private String nom_complet_u;

    private String raison_sociale;

    private String telephone;

    private String username;



    @OneToMany(mappedBy ="partenaire")
    //pour récupèrer la liste de comptes dans partenaire
    private List<Compte> comptes;

    //@OneToMany(mappedBy ="user")
    //private List<User> users;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_complet_u() {
        return nom_complet_u;
    }

    public void setNom_complet_u(String nom_complet_u) {
        this.nom_complet_u = nom_complet_u;
    }

    public String getAdresse_u() {
        return adresse_u;
    }

    public void setAdresse_u(String adresse_u) {
        this.adresse_u = adresse_u;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getEtat_u() {
        return etat_u;
    }

    public void setEtat_u(String etat_u) {
        this.etat_u = etat_u;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
