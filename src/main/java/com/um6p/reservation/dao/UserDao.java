package com.um6p.reservation.dao;

import com.um6p.reservation.models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface UserDao {
    int insertUser(User user) throws SQLException;
    int updateUser(User user);
    int updatePassword(String userName, String newPassword);
    User getUserById(UUID id);
    User getUserByUserName(String userName);
    List<User> getAllUsers();
}
