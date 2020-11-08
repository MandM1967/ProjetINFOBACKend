package com.gestionsalle.demo.DAO;

import com.gestionsalle.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Long> {
    public Admin findByLogin(String login);
    public Admin findByNomAndPrenom(String nom, String prenom);



}
