package serviceInterface;

import entity.ResponsableDepatement;
import entity.Salle;

import java.util.List;
import java.util.Optional;

public interface SalleServiceInterface {
    public Optional<Salle> findbyId(Long id);
    public List<Salle> findall();
    public int save(Salle salle);
    public void delete(Salle salle);
}
