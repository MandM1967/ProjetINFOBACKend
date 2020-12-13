package com.um6p.reservation.dao;


import com.um6p.reservation.models.Salle;

import java.util.List;
import java.util.UUID;

public interface SalleDao {
    int insertSalle(Salle salle);

    int updateSalleById(UUID id, Salle salle);

    int deleteSalleById(UUID id);

    int resetRates();

    int increaseRate(double in, UUID salleId);

    List<Salle> getAll();
    Salle getSalleById(UUID id);


}
