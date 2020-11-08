package com.gestionsalle.demo.DAO;

import com.gestionsalle.demo.entity.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterielDao extends JpaRepository<Materiel,Long> {

    public List<Materiel> findAllByLibelle(String libelle);

}
