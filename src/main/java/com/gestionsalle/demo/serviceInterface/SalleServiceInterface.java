package com.gestionsalle.demo.serviceInterface;

import com.gestionsalle.demo.entity.Materiel;
import com.gestionsalle.demo.entity.Salle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SalleServiceInterface {
    public Optional<Salle> findbyId(Long id);
    public List<Salle> findall();
    public int save(Salle salle);
    public void delete(Salle salle);
    public List<Salle> findByCapaciteGreaterThanEqual(Integer capacite);
    public Salle findByNumsalle(String numsalle);
    ResponseEntity<Salle> updateSalle(Long id, Salle salle);
    public Boolean disponible(Date d, Date f, Salle salle);
    public void deleteSalleByID(@PathVariable Long id);
}
