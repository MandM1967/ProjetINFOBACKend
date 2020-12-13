package com.um6p.reservation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Slot {
    @JsonProperty("id")
     private final UUID id;
    @JsonProperty("salleId")
     private final UUID salleID;
    @JsonProperty("username")
     private final String userName;
    @JsonProperty("isReserved")
     private final boolean isResesrved;
    @JsonProperty("startAt")
     private final long startAt;
    @JsonProperty("endAt")
     private  final long endAt;


    public Slot(UUID salleID, String userName, boolean isResesrved, long startAt, long endAt) {
        this.salleID = salleID;
        this.userName = userName;
        this.isResesrved = isResesrved;
        this.startAt = startAt;
        this.endAt = endAt;
        this.id = UUID.randomUUID();
    }

    public Slot(UUID id, UUID salleID, String userName, boolean isResesrved, long startAt, long endAt) {
        this.id = id;
        this.salleID = salleID;
        this.userName = userName;
        this.isResesrved = isResesrved;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getSalleID() {
        return salleID;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isResesrved() {
        return isResesrved;
    }

    public long getStartAt() {
        return startAt;
    }

    public long getEndAt() {
        return endAt;
    }
}
