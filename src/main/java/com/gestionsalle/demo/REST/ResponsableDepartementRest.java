package com.gestionsalle.demo.REST;

import com.gestionsalle.demo.Services.ResponsableDepartementService;
import com.gestionsalle.demo.entity.ResponsableDepartement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/GRDS/ResponsableDepartement")

public class ResponsableDepartementRest {

    @Autowired
    private ResponsableDepartementService responsableDepartementService;

    @GetMapping("/id/{id}")
    public Optional<ResponsableDepartement> findbyId(@PathVariable Long id) {
        return responsableDepartementService.findbyId(id);
    }

    @GetMapping("/")
    public List<ResponsableDepartement> findall() {
        return responsableDepartementService.findall();
    }

    @PostMapping("/save")
    public int save(@RequestBody ResponsableDepartement responsabledepatement) {
        return responsableDepartementService.save(responsabledepatement);
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




}
