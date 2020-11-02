package serviceInterface;

import entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationServiceInterface {
    public Optional<Reservation> findbyid(long id);
    public List<Reservation> findall();
    public int save(Reservation reservation);
    public void delete(Reservation reservation);
}
