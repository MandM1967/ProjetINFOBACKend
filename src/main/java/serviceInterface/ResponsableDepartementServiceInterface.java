package serviceInterface;

import entity.Admin;
import entity.ResponsableDepatement;

import java.util.List;
import java.util.Optional;

public interface ResponsableDepartementServiceInterface {
    public Optional<ResponsableDepatement> findbyId(Long id);
    public List<ResponsableDepatement> findall();
    public int save(ResponsableDepatement responsabledepatement);
    public void delete(ResponsableDepatement responsabledepatement);
}
