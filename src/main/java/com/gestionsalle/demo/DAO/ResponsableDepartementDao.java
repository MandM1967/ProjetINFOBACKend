package com.gestionsalle.demo.DAO;

import com.gestionsalle.demo.entity.ResponsableDepartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableDepartementDao extends JpaRepository<ResponsableDepartement,Long> {

    public ResponsableDepartement findByLogin(String login);
    public ResponsableDepartement findByNomAndPrenom(String nom, String prenom);



}
