package REST;

import Services.SalleService;
import entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Salle")
public class SalleRest {

    @Autowired
    private SalleService salleService;

    @GetMapping("/id/{id}")
    public Optional<Salle> findbyId(@PathVariable Long id) {
        return salleService.findbyId(id);
    }

    @GetMapping("/")
    public List<Salle> findall() {
        return salleService.findall();
    }

    @PostMapping("/")
    public int save(@RequestBody Salle salle) {
        return salleService.save(salle);
    }

    @DeleteMapping("/{salle}")
    public void delete(@RequestBody Salle salle) {
        salleService.delete(salle);
    }


}
