package com.gestionsalle.demo.serviceInterface;

import com.gestionsalle.demo.entity.ResponsableDepartement;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ResponsableDepartementServiceInterface {
    public Optional<ResponsableDepartement> findbyId(Long id);
    public List<ResponsableDepartement> findall();
    public int save(ResponsableDepartement responsableDepartement);
    public void delete(ResponsableDepartement responsabledepatement);
    public ResponsableDepartement findByLogin(String login);
    public ResponsableDepartement findByNomAndPrenom(String nom, String prenom);
    public void updateNomRD(String login, String nom);
    public void updatePrenomRD(String login, String prenom);
    public void updateNumtelRD(String login, String numtel);
    public void updatePassworRD(String login, String passwordAdmin);
    public ResponseEntity<ResponsableDepartement> updateResponsableDepatement(Long id, ResponsableDepartement responsableDepartement);
}
