package DAO;

import entity.Admin;
import entity.ResponsableDepatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableDepartementDao extends JpaRepository<ResponsableDepatement,Long> {

}
