package com.um6p.reservation.dao;

import com.um6p.reservation.models.Admin;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface AdminDao {
    int insertAdmin(Admin admin) throws SQLException;
    int deleteAdminById(String userName);
    int updateAdmin(Admin Admin) throws SQLException;
    Admin getAdminById(UUID id);
    int updatePassword(String userName, String newPassword);
    Admin getAdminByUserName(String userName);
    List<Admin> getAllAdmin();
}
