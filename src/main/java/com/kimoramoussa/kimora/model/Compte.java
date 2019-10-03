package com.kimoramoussa.kimora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//pour respecter la convention de nomenclature d'une table
@Table(name = "compte", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "num_compte"
        })
})

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//partenaire_id = name dans la bdd
    @JoinColumn(name = "partenaire_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    @JsonIgnoreProperties("compte")
    //partenaire = nom dans la classe
    private Partenaire partenaire;

    @OneToMany(mappedBy ="compte")
    private List<Depot> depots;

    //@OneToMany(mappedBy ="compte")
    //private List<User> users;


    private String num_compte;

    private int solde_c;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    public int getSolde_c() {
        return solde_c;
    }

    public void setSolde_c(int solde_c) {
        this.solde_c = solde_c;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

}













