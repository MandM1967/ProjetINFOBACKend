package com.gestionsalle.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"login"})})
public class Admin  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String login;
    private String nom;
    private String prenom;
    private String numtel;
    private String passwordadmin;
    @OneToMany(mappedBy = "admin")
    private List<Reservation> reservations;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPasswordadmin() {
        return passwordadmin;
    }

    public void setPasswordadmin(String passwordadmin) {
        this.passwordadmin = passwordadmin;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Admin() {
    }
}

