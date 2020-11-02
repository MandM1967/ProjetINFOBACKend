package Services;

import DAO.ResponsableDepartementDao;
import entity.ResponsableDepatement;
import org.springframework.beans.factory.annotation.Autowired;
import serviceInterface.ResponsableDepartementServiceInterface;

import java.util.List;
import java.util.Optional;

public class ResponsableDepartementService implements ResponsableDepartementServiceInterface {
    @Autowired
    private ResponsableDepartementDao responsableDepartementDao;
    @Override
    public Optional<ResponsableDepatement> findbyId(Long id) {
        return responsableDepartementDao.findById(id);
    }

    @Override
    public List<ResponsableDepatement> findall() {
        return responsableDepartementDao.findAll();
    }

    @Override
    public int save(ResponsableDepatement responsabledepatement) {
        if(responsabledepatement!=null){
            responsableDepartementDao.save(responsabledepatement);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(ResponsableDepatement responsabledepatement) {
        responsableDepartementDao.delete(responsabledepatement);

    }
}
