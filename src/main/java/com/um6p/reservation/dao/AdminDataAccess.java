package com.um6p.reservation.dao;

import com.um6p.reservation.models.Admin;

import com.um6p.reservation.rowmappers.AdminRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class AdminDataAccess implements AdminDao{
    private final  JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertAdmin(Admin admin) throws SQLException {
        String sql = " insert into admin values(?,?,?,?,?,?,?)";
         return  jdbcTemplate.update(sql,
                admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail(),
                admin.getDepartment().toString(),
                admin.getUserName(),
                admin.getPassword(),
                admin.getPhoneNumber());

    }

    @Override
    public int deleteAdminById(String userName) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) throws SQLException {
        String sql = "update admin set firstname=? , lastname=? ,email=?,department=?  ,phonenumber = ? where username = ?";
       return jdbcTemplate.update(sql,
                admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail(),
                admin.getDepartment().toString(),
                admin.getPhoneNumber(),
                admin.getUserName());

    }

    @Override
    public Admin getAdminById(UUID id) {
        return  null;
    }

    @Override
    public int updatePassword(String userName, String newPassword) {
        String sql = "update admin set password = ? where username = ?";

        return jdbcTemplate.update(sql , newPassword, userName);
    }

    @Override
    public Admin getAdminByUserName(String userName) {
        String sql = "select * from admin where username = ?";
        return jdbcTemplate.queryForObject(sql,new AdminRowMapper(),userName);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return jdbcTemplate.query("select * from admin",new AdminRowMapper());
    }
}
