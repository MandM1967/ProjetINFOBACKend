package com.um6p.reservation.service;

import com.um6p.reservation.dao.AdminDao;
import com.um6p.reservation.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdminService {
    private final AdminDao adminDao;
    private final PasswordEncoder passwordEncoder;
    private  final  SloteService sloteService;

    @Autowired
    public AdminService(AdminDao adminDao, PasswordEncoder passwordEncoder, SloteService sloteService) {
        this.adminDao = adminDao;
        this.passwordEncoder = passwordEncoder;
        this.sloteService = sloteService;
    }

    public UserDetails loadUserByUserName(String s) {
        return adminDao.getAdminByUserName(s);
    }

    public Admin getAdmin(String username)
    {
        Admin admin = adminDao.getAdminByUserName(username);
        admin.setSlots(sloteService.getSlotByUserName(username));
        return admin;
    }

    public int deleteAccount(String userName)
    {
        adminDao.deleteAdminById(userName);
        sloteService.unsubscribeByUserName(userName);
        return 1;
    }
    public int insertAdmin(Admin admin) throws SQLException {
        return adminDao.insertAdmin(admin);
    }

    public int updateAdmin(Admin admin) throws SQLException {
        return adminDao.updateAdmin(admin);

    }
    public int updatePassword(String userName, String newPassword)
    {
        newPassword = passwordEncoder.encode(newPassword);
        return adminDao.updatePassword(userName , newPassword);
    }
    public List<Admin> getAllAdmins()
    {
        List<Admin> admins = adminDao.getAllAdmin();
        admins.forEach(a -> a.setSlots(sloteService.getSlotByUserName(a.getUserName())));
        return admins;
    }
}
