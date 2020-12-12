package com.gestionsalle.demo.REST;

import com.gestionsalle.demo.Services.ReservationService;
import com.gestionsalle.demo.Services.ResponsableDepartementService;
import com.gestionsalle.demo.Services.SalleService;
import com.gestionsalle.demo.entity.Reservation;
import com.gestionsalle.demo.entity.ResponsableDepartement;
import com.gestionsalle.demo.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins ="http://localhost:3001" )
@RestController
@RequestMapping("/GRDS/ResponsableDepartement")

public class ResponsableDepartementRest {

    @Autowired
    private ResponsableDepartementService responsableDepartementService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private SalleService salleService;


    @GetMapping("/id/{id}")
    public Optional<ResponsableDepartement> findbyId(@PathVariable Long id) {
        return responsableDepartementService.findbyId(id);
    }

    @GetMapping("/")
    public List<ResponsableDepartement> findall() {
        return responsableDepartementService.findall();
    }

    @PostMapping("/save")
    public int save(@RequestBody ResponsableDepartement responsableDepartement) {
        return responsableDepartementService.save(responsableDepartement);
    }


    @DeleteMapping("/delete")
    public void delete(@RequestBody ResponsableDepartement responsabledepatement) {
        responsableDepartementService.delete(responsabledepatement);
    }
    @GetMapping("/findByLogin/{login}")
    public ResponsableDepartement findByLogin(@PathVariable String login) {
        return responsableDepartementService.findByLogin(login);
    }
    @GetMapping("/findByNometPrenom/{nom}/{prenom}")
    public ResponsableDepartement findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return responsableDepartementService.findByNomAndPrenom(nom, prenom);
    }
    @DeleteMapping("/deleteByLogin/{login}")
    public void deleteResponsableDepartementByLogin(@PathVariable String login){
        responsableDepartementService.deleteResponsableDepartementByLogin(login);
    }
    @PostMapping("/updateNomRD/{login}/{nom}")
    public void updateNomRD(@PathVariable String login,@PathVariable String nom){
        responsableDepartementService.updateNomRD(login,nom);
    }
    @PostMapping("/updatePrenomRD/{login}/{prenom}")
    public void updatePrenomRD(@PathVariable String login,@PathVariable String prenom) {
        responsableDepartementService.updatePrenomRD(login, prenom);
    }
    @PostMapping("/updateNumtelRD/{login}/{numtel}")
    public void updateNumtelRD(@PathVariable String login,@PathVariable String numtel) {
        responsableDepartementService.updateNumtelRD(login, numtel);
    }
    @PostMapping("/updatePasswordRD/{login}/{password}")
    public  void updatePasswordRD(@PathVariable String login,@PathVariable String password) {
        responsableDepartementService.updatePassworRD(login, password);
    }
    @GetMapping("/findAllreservations")
    public List<Reservation> findallreservations() {
        return reservationService.findall();
    }

    @GetMapping("/findSalleBycapacite/{capacite}")
    public List<Salle> findByCapaciteGreaterThanEqual(@PathVariable Integer capacite) {
        return salleService.findByCapaciteGreaterThanEqual(capacite);
    }
    @PostMapping("/updateRD/{id}")
    public ResponseEntity<ResponsableDepartement> updateResponsableDepatement(@PathVariable Long id,@RequestBody ResponsableDepartement responsableDepartement){
        return responsableDepartementService.updateResponsableDepatement(id,responsableDepartement);
    }






}
