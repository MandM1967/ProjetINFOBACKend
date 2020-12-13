package com.um6p.reservation.api;

import com.um6p.reservation.models.Admin;
import com.um6p.reservation.models.User;
import com.um6p.reservation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")

public class AdminController {
    private final AdminService adminService;


    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity updateUser(@RequestBody Admin admin) {
        Admin u ;
        try {
            adminService.updateAdmin(admin);
            u = adminService.getAdmin(admin.getUserName());
        } catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(u);
    }

    @PutMapping(
            value = "/updatepassword"
    )
    private ResponseEntity updatePassword(Authentication user, @RequestParam("newpasswrd")String password)
    {
        String username = user.getName();
        try{
            adminService.updatePassword(username, password);
        }catch ( Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.ok().build();
    }
    @GetMapping("/getall")
    private ResponseEntity getAllUser() {
        try {
            List<Admin> users = adminService.getAllAdmins();
            return ResponseEntity.ok().body(users);
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
