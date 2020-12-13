package com.um6p.reservation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Salle {
    private final UUID id;
    private final String numSalle;
    private final String salleType;
    private final int capacite;
    private final double rate;

    private  List<Slot> slots;

    public Salle(UUID id, String numSalle, String salleType, int capacite, double rate, List<Slot> slots) {
        this.id = id;
        this.numSalle = numSalle;
        this.salleType = salleType;
        this.capacite = capacite;
        this.rate = rate;
        this.slots = slots;
    }

    public Salle(
            @JsonProperty("numSalle") String numSalle,
                 @JsonProperty("salleType") String salleType,
                 @JsonProperty("capacite") int capacite)
    {
        this.rate = 0;
        this.salleType = salleType;
        this.numSalle = numSalle;
        this.capacite = capacite;
        this.id = UUID.randomUUID();
        slots = new ArrayList<>();
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public UUID getId() {
        return id;
    }

    public String getNumSalle() {
        return numSalle;
    }

    public String getSalleType() {
        return salleType;
    }

    public int getCapacite() {
        return capacite;
    }

    public double getRate() {
        return rate;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
