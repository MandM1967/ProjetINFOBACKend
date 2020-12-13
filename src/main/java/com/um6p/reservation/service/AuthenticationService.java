package com.um6p.reservation.service;

import com.um6p.reservation.models.Admin;
import com.um6p.reservation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Component
public class AuthenticationService implements UserDetailsService {
    private  final AdminService adminService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(AdminService adminService, UserService userService, PasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = null;
        try{
            user =   adminService.loadUserByUserName(s);
        }catch (Exception e)
        {
            e.printStackTrace();
            try{
                user = userService.loadUserByUserName(s);
            }catch (Exception ex)
            {
                ex.printStackTrace();
                throw new UsernameNotFoundException("invalid credentials");
            }
        }
        return user;
    }

    public int signUpAdmin(Admin admin) throws SQLException {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminService.insertAdmin(admin);
    }

    public int signUpUser(User user) throws SQLException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userService.insertUser(user);
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public UserService getUserService() {
        return userService;
    }
}
