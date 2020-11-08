package com.gestionsalle.demo.Services;

import com.gestionsalle.demo.DAO.ResponsableDepartementDao;
import com.gestionsalle.demo.entity.ResponsableDepartement;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestionsalle.demo.serviceInterface.ResponsableDepartementServiceInterface;
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
    public int save(ResponsableDepartement responsabledepatement) {
        if(responsabledepatement!=null){
            responsableDepartementDao.save(responsabledepatement);
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

    public void deleteResponsableDepartementByLogin( String login){
         responsableDepartementDao.delete(findByLogin(login));
    }
}
