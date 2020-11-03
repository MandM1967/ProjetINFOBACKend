package REST;

import Services.ResponsableDepartementService;
import entity.ResponsableDepatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ResponsableDepartement")

public class ResponsableDepartementRest {

    @Autowired
    private ResponsableDepartementService responsableDepartementService;

    @GetMapping("/id/{id}")
    public Optional<ResponsableDepatement> findbyId(@PathVariable Long id) {
        return responsableDepartementService.findbyId(id);
    }

    @GetMapping("/")
    public List<ResponsableDepatement> findall() {
        return responsableDepartementService.findall();
    }

    @PostMapping("/")
    public int save(@RequestBody ResponsableDepatement responsabledepatement) {
        return responsableDepartementService.save(responsabledepatement);
    }

    @DeleteMapping("/{responsabledepatement}")
    public void delete(@RequestBody ResponsableDepatement responsabledepatement) {
        responsableDepartementService.delete(responsabledepatement);
    }



}
