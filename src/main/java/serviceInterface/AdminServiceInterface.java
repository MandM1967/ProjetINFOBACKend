package serviceInterface;

import entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminServiceInterface {
    public Optional<Admin> findbyId(Long id);
    public List<Admin> findall();
    public int save(Admin admin);
    public void delete(Admin admin);

}
