package com.um6p.reservation.api;

import com.um6p.reservation.models.Salle;
import com.um6p.reservation.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/salle")
public class SalleController {
    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSalle(@RequestBody Salle salle) {
        try {
            salleService.insertSalle(salle);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAll()
    {
        try {
            return ResponseEntity.ok().body(salleService.getAll());
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getSalleById(@PathVariable("id") UUID id)
    {
        try
        {
            return ResponseEntity.ok().body(salleService.getSalleById(id));
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSalleById(@PathVariable("id") UUID id, @RequestBody Salle salle)
    {
        try {
            salleService.updateSalleById(id, salle);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSalleById(@PathVariable("id") UUID id)
    {
        try {
            salleService.deleteSalleById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
