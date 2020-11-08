package com.gestionsalle.demo.DAO;

import com.gestionsalle.demo.entity.Materiel;
import com.gestionsalle.demo.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalleDao extends JpaRepository<Salle,Long> {


    public List<Salle> findByCapaciteGreaterThanEqual(Integer capacite);
    public Salle findByNumsalle(String numsalle);
    }
