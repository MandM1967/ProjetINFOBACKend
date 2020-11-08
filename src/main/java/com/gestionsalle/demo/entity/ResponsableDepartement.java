package com.gestionsalle.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"login"})})

public class ResponsableDepartement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String login;
    private String nom;
    private String prenom;
    private String numtel;
    private String Passwordresponsabledepartement;
    @OneToMany(mappedBy = "responsableDepartement")
    private List<Reservation> reservations;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getPasswordresponsabledepartement() {
        return Passwordresponsabledepartement;
    }

    public void setPasswordresponsabledepartement(String passwordresponsabledepartement) {
        Passwordresponsabledepartement = passwordresponsabledepartement;
    }

    public ResponsableDepartement() {
    }

    public ResponsableDepartement(Long id, String email, String nom, String prenom, String numtel, List<Reservation> reservations) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
        this.reservations = reservations;
    }
}
