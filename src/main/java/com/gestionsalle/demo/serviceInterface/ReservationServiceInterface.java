package com.gestionsalle.demo.serviceInterface;

import com.gestionsalle.demo.entity.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationServiceInterface {
    public Optional<Reservation> findbyid(long id);
    public List<Reservation> findall();
    public int save(Reservation reservation);
    public void delete(Reservation reservation);
    public Reservation findbyNumresrvation(int numreservation);

}
