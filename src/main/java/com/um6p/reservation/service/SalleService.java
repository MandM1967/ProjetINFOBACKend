package com.um6p.reservation.service;

import com.um6p.reservation.dao.SalleDao;
import com.um6p.reservation.models.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalleService  {
    private  final SalleDao salleDao;
    private  final SloteService sloteService;
    @Autowired
    public SalleService(SalleDao salleDao, SloteService sloteService) {
        this.salleDao = salleDao;
        this.sloteService = sloteService;
    }

    public int insertSalle(Salle salle) {
        salleDao.insertSalle(salle);
        sloteService.addSlots(salle.getId());
        return 1;
    }


    public int updateSalleById(UUID id, Salle salle) {
        return salleDao.updateSalleById(id, salle);
    }


    public int deleteSalleById(UUID id) {
        sloteService.deleteSlotBySalleId(id);
        return salleDao.deleteSalleById(id);

    }


    public int resetRates() {
        return salleDao.resetRates();
    }


    public int increaseRate(double in, UUID salleId) {
        return salleDao.increaseRate(in , salleId);
    }
    public List<Salle> getAll()
    {
        List<Salle> salles = salleDao.getAll();
        salles.forEach(salle -> salle.setSlots(sloteService.getSlotBySalleId(salle.getId())));
        return salles;
    }
    public  Salle getSalleById(UUID id)
    {
        Salle salle = salleDao.getSalleById(id);
        salle.setSlots(sloteService.getSlotBySalleId(salle.getId()));
        return  salle;
    }
}
