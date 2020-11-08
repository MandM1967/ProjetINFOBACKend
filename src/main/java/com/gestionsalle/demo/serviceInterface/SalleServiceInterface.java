package com.gestionsalle.demo.serviceInterface;

import com.gestionsalle.demo.entity.Materiel;
import com.gestionsalle.demo.entity.Salle;

import java.util.List;
import java.util.Optional;

public interface SalleServiceInterface {
    public Optional<Salle> findbyId(Long id);
    public List<Salle> findall();
    public int save(Salle salle);
    public void delete(Salle salle);
    public List<Salle> findByCapaciteGreaterThanEqual(Integer capacite);
    public Salle findByNumsalle(String numsalle);



}
