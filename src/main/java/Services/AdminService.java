package Services;

import DAO.AdminDao;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceInterface.AdminServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminServiceInterface {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Optional<Admin> findbyId(Long id) {
        return adminDao.findById(id);
    }

    @Override
    public List<Admin> findall() {
        return adminDao.findAll();
    }

    @Override
    public int save(Admin admin) {

        if(admin!=null){
            adminDao.save(admin);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(Admin admin) {
        adminDao.delete(admin);

    }
}
