package com.gestionsalle.demo.Services;

import antlr.ASTNULLType;
import com.gestionsalle.demo.DAO.AdminDao;
import com.gestionsalle.demo.DAO.ResponsableDepartementDao;
import com.gestionsalle.demo.entity.Admin;
import com.gestionsalle.demo.entity.ResponsableDepartement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionsalle.demo.serviceInterface.AdminServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminServiceInterface {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ResponsableDepartementDao responsableDepartementDao ;

    @Override
    public Optional<Admin> findbyId(Long id) {
        return adminDao.findById(id);
    }

    @Override
    public List<Admin> findall() {
        return adminDao.findAll();
    }


    @Override
    public int save(Admin admin) {

        if(admin!=null ){
            adminDao.save(admin);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(Admin admin) {
        adminDao.delete(admin);

    }

    @Override
    public Admin findByLogin(String login) {
        return adminDao.findByLogin(login);
    }

    @Override
    public Admin findByNomAndPrenom(String nom, String prenom) {
        return adminDao.findByNomAndPrenom(nom,prenom);
    }
    @Override
    public void updateNomAdmin(String login, String nom){
        adminDao.findByLogin(login).setNom(nom);
        adminDao.save(findByLogin(login));

    }
    @Override
    public void updatePrenomAdmin(String login, String prenom) {
        adminDao.findByLogin(login).setPrenom(prenom);
        adminDao.save(findByLogin(login));
    }
    @Override
    public void updateNumtelAdmin(String login, String numtel) {
        adminDao.findByLogin(login).setNumtel(numtel);
        adminDao.save(findByLogin(login));
    }
    @Override
    public void updatePasswordAdmin(String login, String passwordAdmin){
        adminDao.findByLogin(login).setPasswordadmin(passwordAdmin);
        adminDao.save(findByLogin(login)) ;
    }

    }







