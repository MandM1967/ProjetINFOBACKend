package com.gestionsalle.demo.Services;

import com.gestionsalle.demo.DAO.ReservationDao;
import com.gestionsalle.demo.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestionsalle.demo.serviceInterface.ReservationServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ReservationService implements ReservationServiceInterface {
    @Autowired
    private ReservationDao reservationDao;
    @Override
    public Optional<Reservation> findbyid(long id) {
        return reservationDao.findById(id);
    }

    @Override
    public List<Reservation> findall() {
        return reservationDao.findAll();
    }

    @Override
    public int save(Reservation reservation) {
        if(reservation!=null){
            reservationDao.save(reservation);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(Reservation reservation) {
        reservationDao.delete(reservation);

    }

    @Override
    public Reservation findbyNumresrvation(int numreservation) {
        return reservationDao.findByNumreservation(numreservation);
    }


    public void deleteByNumresevation(int numreservation){
        reservationDao.delete(findbyNumresrvation(numreservation));
    }

}
