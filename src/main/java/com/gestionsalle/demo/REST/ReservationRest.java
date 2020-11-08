package com.gestionsalle.demo.REST;

import com.gestionsalle.demo.Services.ReservationService;
import com.gestionsalle.demo.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/GRDS/Reservation")
public class ReservationRest {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/id/{id}")
    public Optional<Reservation> findbyid(@PathVariable long id) {
        return reservationService.findbyid(id);
    }

    @GetMapping("/")
    public List<Reservation> findall() {
        return reservationService.findall();
    }

    @PostMapping("/save")
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping("/delete/{reservation}")
    public void delete(@RequestBody Reservation reservation) {
        reservationService.delete(reservation);
    }

    @GetMapping("/findByNumreservation/{numreservation}")
    public Reservation findByNumreservation(@PathVariable int numreservation){
        return reservationService.findbyNumresrvation(numreservation);
    }
    @DeleteMapping("/deleteByNumreservation/{numreservation}")
    public void deleteByNumreservation(@PathVariable int numreservation){
        reservationService.deleteByNumresevation(numreservation);
    }
    @GetMapping("/findByDatereservation/datereservation")
    public List<Reservation> findAllByDatereservation(@PathVariable Date datereservation){
       return reservationService.findAllByDatereservation(datereservation);
    }



}
