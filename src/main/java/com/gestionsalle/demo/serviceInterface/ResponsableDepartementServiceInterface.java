package com.gestionsalle.demo.serviceInterface;

import com.gestionsalle.demo.entity.ResponsableDepartement;

import java.util.List;
import java.util.Optional;

public interface ResponsableDepartementServiceInterface {
    public Optional<ResponsableDepartement> findbyId(Long id);
    public List<ResponsableDepartement> findall();
    public int save(ResponsableDepartement responsabledepatement);
    public void delete(ResponsableDepartement responsabledepatement);
    public ResponsableDepartement findByLogin(String login);
    public ResponsableDepartement findByNomAndPrenom(String nom, String prenom);
}
