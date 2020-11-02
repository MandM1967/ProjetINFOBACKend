package Services;

import DAO.AdminDao;
import DAO.MaterielDao;
import entity.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceInterface.MaterielServiceInterface;

import java.util.List;
import java.util.Optional;

@Service

public class MaterielService implements MaterielServiceInterface {
    @Autowired
    private MaterielDao materielDao;
    @Override
    public Optional<Materiel> findbyId(Long id) {
        return materielDao.findById(id);
    }

    @Override
    public List<Materiel> findall() {
        return materielDao.findAll();
    }

    @Override
    public int save(Materiel materiel) {
        if(materiel!=null){
            materielDao.save(materiel);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(Materiel materiel) {
        materielDao.delete(materiel);

    }
}
