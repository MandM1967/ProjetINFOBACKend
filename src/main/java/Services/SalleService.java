package Services;

import DAO.SalleDao;
import entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import serviceInterface.SalleServiceInterface;

import java.util.List;
import java.util.Optional;

public class SalleService implements SalleServiceInterface {
    @Autowired
    private SalleDao salleDao;
    @Override
    public Optional<Salle> findbyId(Long id) {
        return salleDao.findById(id);
    }

    @Override
    public List<Salle> findall() {
        return salleDao.findAll();
    }

    @Override
    public int save(Salle salle) {
        if(salle!=null){
            salleDao.save(salle);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(Salle salle) {
        salleDao.delete(salle);

    }
}
