package DAO;

import entity.Admin;
import entity.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielDao extends JpaRepository<Materiel,Long> {

}
