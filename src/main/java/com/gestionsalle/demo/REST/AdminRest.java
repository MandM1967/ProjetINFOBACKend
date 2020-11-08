package com.gestionsalle.demo.REST;

import com.gestionsalle.demo.Services.AdminService;
import com.gestionsalle.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/GRDS/Admin")
public class AdminRest {

    @Autowired
    private AdminService adminService;

    @GetMapping("/id/{id}")
    public Optional<Admin> findbyId(@PathVariable Long id) {
        return adminService.findbyId(id);
    }
    @GetMapping("/")
    public List<Admin> findall() {
        return adminService.findall();
    }

    @PostMapping("/save")
    public int save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @DeleteMapping("/delete/{admin}")
    public void delete(@RequestBody Admin admin) {
        adminService.delete(admin);
    }

    @GetMapping("/findByLogin/{login}")
    public Admin findByLogin(@PathVariable String login) {
        return  adminService.findByLogin(login);
    }
    @GetMapping("/findByNomAndPrenom/{nom}/{prenom}")
    public Admin findByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom) {
        return adminService.findByNomAndPrenom(nom, prenom);
    }
    @PostMapping("/updateNomAdmin/{login}/{nom}")
    public void updateNomAdmin(@PathVariable String login,@PathVariable String nom){
        adminService.updateNomAdmin(login,nom);
    }
    @PostMapping("/updatePrenomAdmin/{login}/{prenom}")
     public void updatePrenomAdmin(@PathVariable String login,@PathVariable String prenom) {
        adminService.updatePrenomAdmin(login, prenom);
    }
    @PostMapping("/updateNumtelAdmin/{login}/{numtel}")
    public void updateNumtelAdmin(@PathVariable String login,@PathVariable String numtel) {
        adminService.updateNumtelAdmin(login, numtel);
    }










}
