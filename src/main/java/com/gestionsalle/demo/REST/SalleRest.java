package com.gestionsalle.demo.REST;

import com.gestionsalle.demo.Services.SalleService;
import com.gestionsalle.demo.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/GRDS/Salle")
public class SalleRest {

    @Autowired
    private SalleService salleService;

    @GetMapping("/id/{id}")
    public Optional<Salle> findbyId(@PathVariable Long id) {
        return salleService.findbyId(id);
    }

    @GetMapping("/Numsalle/{numsalle}")
    public Salle findByNumsalle(@PathVariable String numsalle) {
        return salleService.findByNumsalle(numsalle);
    }

    @GetMapping("/capacite/{capacite}")
    public List<Salle> findByCapaciteGreaterThanEqual(@PathVariable Integer capacite) {
        return salleService.findByCapaciteGreaterThanEqual(capacite);
    }

    @GetMapping("/")
    public List<Salle> findall() {
        return salleService.findall();
    }

    @PostMapping("/save")
    public int save(@RequestBody Salle salle) {
        return salleService.save(salle);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Salle salle) {
        salleService.delete(salle);
    }

    @DeleteMapping("/deleteSalleByNumsalle/{numsalle}")
    public void deleteSalleByNumsalle(@PathVariable String numsalle){
        salleService.delete(findByNumsalle(numsalle));
    }





}
