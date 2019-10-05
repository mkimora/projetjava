package com.kimoramoussa.kimora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

@Entity
//pour respecter la convention de nomenclature d'une table
@Table(name = "depot")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //migration de user_id
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")
    private User users;

    //migration de compte_id
    @JoinColumn(name = "compte_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")
    private Compte compte;


    private BigInteger solde_anterieur;

    private BigInteger nouveau_solde;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date_depot;

    private Double montant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getSolde_anterieur() {
        return solde_anterieur;
    }

    public void setSolde_anterieur(BigInteger solde_anterieur) {
        this.solde_anterieur = solde_anterieur;
    }

    public BigInteger getNouveau_solde() {
        return nouveau_solde;
    }

    public void setNouveau_solde(BigInteger nouveau_solde) {
        this.nouveau_solde = nouveau_solde;
    }

    public Date getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(Date date_depot) {
        this.date_depot = date_depot;
    }

    public void setUser(User user) {
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Compte getCompte() {
        return compte;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setCompte(Compte compte) {
    }
}
