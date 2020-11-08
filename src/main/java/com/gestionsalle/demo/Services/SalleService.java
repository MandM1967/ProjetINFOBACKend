package com.gestionsalle.demo.Services;

import com.gestionsalle.demo.DAO.SalleDao;
import com.gestionsalle.demo.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestionsalle.demo.serviceInterface.SalleServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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







}
