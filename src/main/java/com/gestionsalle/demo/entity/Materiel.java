package com.gestionsalle.demo.entity;

import javax.persistence.*;

@Entity
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Salle salleconcernee;
    private String libelle;
    private int quantite;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Salle getSalleconcernee() {
        return salleconcernee;
    }

    public void setSalleconcernee(Salle salleconcernee) {
        this.salleconcernee = salleconcernee;
    }


    public Materiel() {
    }
}
