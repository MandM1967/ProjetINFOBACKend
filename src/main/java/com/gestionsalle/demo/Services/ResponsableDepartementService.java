package com.gestionsalle.demo.Services;

import com.gestionsalle.demo.DAO.ResponsableDepartementDao;
import com.gestionsalle.demo.entity.ResponsableDepartement;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestionsalle.demo.serviceInterface.ResponsableDepartementServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ResponsableDepartementService implements ResponsableDepartementServiceInterface {
    @Autowired
    private ResponsableDepartementDao responsableDepartementDao;
    @Override
    public Optional<ResponsableDepartement> findbyId(Long id) {
        return responsableDepartementDao.findById(id);
    }

    @Override
    public List<ResponsableDepartement> findall() {
        return responsableDepartementDao.findAll();
    }

    @Override
    public int save(ResponsableDepartement responsableDepartement) {

        if(responsableDepartement!=null){
            responsableDepartementDao.save(responsableDepartement);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(ResponsableDepartement responsabledepatement) {
        responsableDepartementDao.delete(responsabledepatement);

    }

    @Override
    public ResponsableDepartement findByLogin(String login) {
        return responsableDepartementDao.findByLogin(login);
    }

    @Override
    public ResponsableDepartement findByNomAndPrenom(String nom, String prenom) {
        return responsableDepartementDao.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public void updateNomRD(String login, String nom) {
        responsableDepartementDao.findByLogin(login).setNom(nom);
        responsableDepartementDao.save(findByLogin(login));

    }

    @Override
    public void updatePrenomRD(String login, String prenom) {
        responsableDepartementDao.findByLogin(login).setPrenom(prenom);
        responsableDepartementDao.save(findByLogin(login));

    }

    @Override
    public void updateNumtelRD(String login, String numtel) {
        responsableDepartementDao.findByLogin(login).setNumtel(numtel);
        responsableDepartementDao.save(findByLogin(login));

    }

    @Override
    public void updatePassworRD(String login, String passwordAdmin) {
        responsableDepartementDao.findByLogin(login).setPasswordresponsabledepartement(passwordAdmin);
        responsableDepartementDao.save(findByLogin(login)) ;

    }

    @Override
    public ResponseEntity<ResponsableDepartement> updateResponsableDepatement(Long id, ResponsableDepartement responsableDepartement) {
        Optional<ResponsableDepartement> ro1=findbyId(id);
        ResponsableDepartement ro = ro1.get();
        ro.setEmail(responsableDepartement.getEmail());
        ro.setLogin(responsableDepartement.getLogin());
        ro.setNom(responsableDepartement.getNom());
        ro.setPrenom(responsableDepartement.getPrenom());
        ro.setNumtel(responsableDepartement.getNumtel());
        ro.setPasswordresponsabledepartement(responsableDepartement.getPasswordresponsabledepartement());
        ResponsableDepartement updatedResposableDepartement= responsableDepartementDao.save(ro);
        return ResponseEntity.ok(updatedResposableDepartement);
    }

    public void deleteResponsableDepartementByLogin( String login){
         responsableDepartementDao.delete(findByLogin(login));
    }

}
