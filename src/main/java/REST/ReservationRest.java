package REST;

import Services.ReservationService;
import entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Reservation")
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

    @PostMapping("/")
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping("/{reservation}")
    public void delete(@RequestBody Reservation reservation) {
        reservationService.delete(reservation);
    }



}
