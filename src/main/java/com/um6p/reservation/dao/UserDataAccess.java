package com.um6p.reservation.dao;

import com.um6p.reservation.models.User;
import com.um6p.reservation.rowmappers.AdminRowMapper;
import com.um6p.reservation.rowmappers.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDataAccess implements UserDao{
   private final  JdbcTemplate jdbcTemplate;

   @Autowired
    public UserDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(User user) throws SQLException {
        String sql = " insert into ruser values(?,?,?,?,?,?,?)";
        return  jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getDepartment().toString(),
                user.getUserName(),
                user.getPassword(),
                user.getPhoneNumber());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update ruser set firstname=? , lastname=? ,email=?,department=?  ,phonenumber = ? where username = ?";
        return jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getDepartment().toString(),
                user.getPhoneNumber(),
                user.getUserName());
    }

    @Override
    public int updatePassword(String userName, String newPassword) {
        String sql = "update ruser set password = ? where username = ?";

        return jdbcTemplate.update(sql , newPassword, userName);
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        String sql = "select * from ruser where username = ?";
        return jdbcTemplate.queryForObject(sql,new UserRowMapper(),userName);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from ruser",new UserRowMapper());

    }

    @Override
    public int deleteUser(String username) {
       String sql = "delete from ruser where username =?";

        return jdbcTemplate.update(sql,username);
    }
}
