package com.gestionsalle.demo.Services;

import com.gestionsalle.demo.DAO.SalleDao;
import com.gestionsalle.demo.entity.Reservation;
import com.gestionsalle.demo.entity.ResponsableDepartement;
import com.gestionsalle.demo.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestionsalle.demo.serviceInterface.SalleServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service

public class SalleService implements SalleServiceInterface {
    @Autowired
    private SalleDao salleDao;

    @Override
    public Optional<Salle> findbyId(Long id) {
        return salleDao.findById(id);
    }

    @Override
    public List<Salle> findall() {
        return salleDao.findAll();
    }

    @Override
    public int save(Salle salle) {
        salleDao.save(salle);
        return 1;
    }

    @Override
    public void delete(Salle salle) {
        salleDao.delete(salle);

    }

    @Override
    public List<Salle> findByCapaciteGreaterThanEqual(Integer capacite) {
        return salleDao.findByCapaciteGreaterThanEqual(capacite);
    }

    @Override
    public Salle findByNumsalle(String numsalle) {
        return salleDao.findByNumsalle(numsalle);
    }

    @Override
    public ResponseEntity<Salle> updateSalle(Long id, Salle salle) {
        Optional<Salle> ro1 = findbyId(id);
        Salle ro = ro1.get();
        ro.setCapacite(salle.getCapacite());
        ro.setEmplacementsalle(salle.getEmplacementsalle());
        ro.setNumsalle(salle.getNumsalle());
        ro.setTypesalle(salle.getTypesalle());
        Salle updatedSalle = salleDao.save(ro);
        return ResponseEntity.ok(updatedSalle);
    }

    @Override
    public void deleteSalleByID(@PathVariable Long id) {
        Optional<Salle> salle1 = salleDao.findById(id);
        Salle salle = salle1.get();
        salleDao.delete(salle);

    }
    @Override
    public Boolean disponible(Date d, Date f, Salle salle){
        for (Reservation reservation: salle.getReservations()){
            Date datedebut= reservation.getDateDebut();
            Date datefin=reservation.getDateFin();
            if (datedebut.after(d) || datefin.before(f) ){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
