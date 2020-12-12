package com.gestionsalle.demo.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"numreservation"})})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numreservation;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    private Salle salleReservee;
    private Date dateDebut;
    private Date dateFin;
    private String responsableDepartement;
    private String nomRD;
    private String typesalle;
    @ManyToOne
    private Admin admin;

    public Reservation() {
    }


    public String getResponsableDepartement() {
        return responsableDepartement;
    }

    public void setResponsableDepartement(String responsableDepartement) {
        this.responsableDepartement = responsableDepartement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumreservation() {
        return numreservation;
    }

    public void setNumreservation(int numreservation) {
        this.numreservation = numreservation;
    }

    public Salle getSalleReservee() {
        return salleReservee;
    }

    public void setSalleReservee(Salle salleReservee) {
        this.salleReservee = salleReservee;
    }


    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNomRD() {
        return nomRD;
    }

    public void setNomRD(String nomRD) {
        this.nomRD = nomRD;
    }

    public String getTypesalle() {
        return typesalle;
    }

    public void setTypesalle(String typesalle) {
        this.typesalle = typesalle;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
