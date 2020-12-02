package com.gestionsalle.demo.serviceInterface;

import com.gestionsalle.demo.entity.Admin;
import com.gestionsalle.demo.entity.ResponsableDepartement;

import java.util.List;
import java.util.Optional;

public interface AdminServiceInterface {
    public Optional<Admin> findbyId(Long id);
    public List<Admin> findall();
    public int save(Admin admin);
    public void delete(Admin admin);
    public Admin findByLogin(String login);
    public Admin findByNomAndPrenom(String nom, String prenom);
    public void updateNomAdmin(String login, String nom);
    public void updatePrenomAdmin(String login, String prenom);
    public void updateNumtelAdmin(String login, String numtel);
    public void updatePasswordAdmin(String login, String passwordAdmin);




}
