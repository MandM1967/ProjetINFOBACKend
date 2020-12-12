package com.gestionsalle.demo.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"numsalle"})})
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numsalle;
    private String typesalle;
    private String emplacementsalle;
    private int capacite;
    @ManyToOne
    private Reservation reservation;
    @OneToMany(mappedBy = "salleReservee")
    private List<Reservation> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumsalle() {
        return numsalle;
    }

    public void setNumsalle(String numsalle) {
        this.numsalle = numsalle;
    }

    public String getTypesalle() {
        return typesalle;
    }

    public void setTypesalle(String typesalle) {
        this.typesalle = typesalle;
    }

    public String getEmplacementsalle() {
        return emplacementsalle;
    }

    public void setEmplacementsalle(String emplacementsalle) {
        this.emplacementsalle = emplacementsalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Salle() {
    }
}
