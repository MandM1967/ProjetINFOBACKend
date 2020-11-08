package com.gestionsalle.demo.REST;

import com.gestionsalle.demo.Services.MaterielService;
import com.gestionsalle.demo.entity.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/GRDS/Materiel")

public class MaterielRest {

    @Autowired
    private MaterielService materielService;

    @GetMapping("/id/{id}")
    public Optional<Materiel> findbyId(@PathVariable Long id) {
        return materielService.findbyId(id);
    }

    @GetMapping("/")
    public List<Materiel> findall() {
        return materielService.findall();
    }

    @PostMapping("/")
    public int save(@RequestBody Materiel materiel) {
        return materielService.save(materiel);
    }

    @DeleteMapping("/{materiel}")
    public void delete(@RequestBody Materiel materiel) {
        materielService.delete(materiel);
    }

    @GetMapping("/findAllByLibelle/{libelle}")
    public  List<Materiel> findfindAllByLibelle(String libelle) {
        return materielService.findAllByLibelle(libelle);
    }




}
