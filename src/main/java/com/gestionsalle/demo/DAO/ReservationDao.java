package com.gestionsalle.demo.DAO;

import com.gestionsalle.demo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationDao extends JpaRepository<Reservation,Long> {

    public Reservation findByNumreservation(int numreservation);


}
