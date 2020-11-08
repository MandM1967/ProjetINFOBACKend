package com.gestionsalle.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"numreservation"})})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numreservation;
    @OneToMany(mappedBy = "reservation")
    private List<Salle> salles;
    private Date datereservation;
    @ManyToOne
    private ResponsableDepartement responsableDepartement;
    @ManyToOne
    private Admin admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public ResponsableDepartement getResponsableDepatement() {
        return responsableDepartement;
    }

    public void setResponsableDepatement(ResponsableDepartement responsableDepartement) {
        this.responsableDepartement = responsableDepartement;
    }

    public int getNumreservation() {
        return numreservation;
    }

    public void setNumreservation(int numreservation) {
        this.numreservation = numreservation;
    }

    public Date getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(Date datereservation) {
        this.datereservation = datereservation;
    }

    public ResponsableDepartement getResponsableDepartement() {
        return responsableDepartement;
    }

    public void setResponsableDepartement(ResponsableDepartement responsableDepartement) {
        this.responsableDepartement = responsableDepartement;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Reservation() {
    }
}
