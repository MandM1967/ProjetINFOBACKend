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
    private String emplacementsalle;
    private int capacite;
    @ManyToOne
    private Reservation reservation;
    @OneToMany(mappedBy = "salleconcernee")
    private List<Materiel> materieldispo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Materiel> getMaterieldispo() {
        return materieldispo;
    }

    public void setMaterieldispo(List<Materiel> materieldispo) {
        this.materieldispo = materieldispo;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getNumsalle() {
        return numsalle;
    }

    public void setNumsalle(String numsalle) {
        this.numsalle = numsalle;
    }

    public String getEmplacementsalle() {
        return emplacementsalle;
    }

    public void setEmplacementsalle(String emplacementsalle) {
        this.emplacementsalle = emplacementsalle;
    }




    public Salle() {
    }

}
