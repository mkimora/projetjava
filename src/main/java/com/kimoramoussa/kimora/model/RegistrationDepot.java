package com.kimoramoussa.kimora.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;

public class RegistrationDepot {

    private DateTimeFormat date_depot;
    private Double montant;


    public DateTimeFormat getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(DateTimeFormat date_depot) {
        this.date_depot = date_depot;
    }

    public void getMontant() {
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
