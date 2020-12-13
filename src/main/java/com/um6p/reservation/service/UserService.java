package com.um6p.reservation.service;

import com.um6p.reservation.dao.UserDao;
import com.um6p.reservation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetails loadUserByUserName(String s) {
        return userDao.getUserByUserName(s);
    }
    public int insertUser(User user) throws SQLException {
        return userDao.insertUser(user);
    }
    public int updateUser(User user)
    {
        return userDao.updateUser(user);
    }
    public int updatePassword(String userName, String newPassword)
    {
        newPassword = passwordEncoder.encode(newPassword);
        return userDao.updatePassword(userName,newPassword);
    }
    public User getUserByUserName(String userName)
    {
        return userDao.getUserByUserName(userName);
    }
    public List<User> getAllUser()
    {
        return userDao.getAllUsers();
    }


    public int deleteUser(String username) {
        return userDao.deleteUser(username);
    }
}
