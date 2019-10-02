package com.kimoramoussa.kimora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "caissier_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")
    private User caissier_id;



    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger num_cni_bene;

    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger montant;

    @NotBlank
    @Size(min=3, max = 50)
    private String nom_envoyeur;

    @NotBlank
    @Size(min=3, max = 50)
    private String prenom_envoyeur;

    @NotBlank
    @Size(min=3, max = 50)
    private int tel_envoyeur;

    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger solde_anterieur;

    @NotBlank
    @Size(min=3, max = 50)
    private String nom_benef;

    @NotBlank
    @Size(min=3, max = 50)
    private String prenom_benef;


    @NotBlank
    @Size(min=3, max = 50)
    private String 	num_bene;

    @NotBlank
    @Size(min=3, max = 50)
    private int code;

    @NotBlank
    @Size(min=3, max = 50)
    private int frais;

    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger commission_wari;

    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger commission_partenaire;

    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger commission_etat;

    @NotBlank
    @Size(min=3, max = 50)
    private BigInteger total;

    @NotBlank
    @Size(min=3, max = 50)
    private String statut;

    @NotBlank
    @Size(min=3, max = 50)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date_retrait;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getNum_cni_bene() {
        return num_cni_bene;
    }

    public void setNum_cni_bene(BigInteger num_cni_bene) {
        this.num_cni_bene = num_cni_bene;
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public String getNom_envoyeur() {
        return nom_envoyeur;
    }

    public void setNom_envoyeur(String nom_envoyeur) {
        this.nom_envoyeur = nom_envoyeur;
    }

    public String getPrenom_envoyeur() {
        return prenom_envoyeur;
    }

    public void setPrenom_envoyeur(String prenom_envoyeur) {
        this.prenom_envoyeur = prenom_envoyeur;
    }

    public int getTel_envoyeur() {
        return tel_envoyeur;
    }

    public void setTel_envoyeur(int tel_envoyeur) {
        this.tel_envoyeur = tel_envoyeur;
    }

    public BigInteger getSolde_anterieur() {
        return solde_anterieur;
    }

    public void setSolde_anterieur(BigInteger solde_anterieur) {
        this.solde_anterieur = solde_anterieur;
    }

    public String getNom_benef() {
        return nom_benef;
    }

    public void setNom_benef(String nom_benef) {
        this.nom_benef = nom_benef;
    }

    public String getPrenom_benef() {
        return prenom_benef;
    }

    public void setPrenom_benef(String prenom_benef) {
        this.prenom_benef = prenom_benef;
    }

    public String getNum_bene() {
        return num_bene;
    }

    public void setNum_bene(String num_bene) {
        this.num_bene = num_bene;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }

    public BigInteger getCommission_wari() {
        return commission_wari;
    }

    public void setCommission_wari(BigInteger commission_wari) {
        this.commission_wari = commission_wari;
    }

    public BigInteger getCommission_partenaire() {
        return commission_partenaire;
    }

    public void setCommission_partenaire(BigInteger commission_partenaire) {
        this.commission_partenaire = commission_partenaire;
    }

    public BigInteger getCommission_etat() {
        return commission_etat;
    }

    public void setCommission_etat(BigInteger commission_etat) {
        this.commission_etat = commission_etat;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_retrait() {
        return date_retrait;
    }

    public void setDate_retrait(Date date_retrait) {
        this.date_retrait = date_retrait;
    }
}


