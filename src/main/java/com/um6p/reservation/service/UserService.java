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
    private  final SloteService sloteService;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder passwordEncoder, SloteService sloteService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.sloteService = sloteService;
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
        User user = userDao.getUserByUserName(userName);
        user.setSlots(sloteService.getSlotByUserName(userName));
        return user;
    }
    public List<User> getAllUser()
    {
        List<User> users = userDao.getAllUsers();
        users.forEach(u ->u.setSlots(sloteService.getSlotByUserName(u.getUserName())));
        return users;
    }


    public int deleteUser(String username) {
        sloteService.unsubscribeByUserName(username);
        return userDao.deleteUser(username);
    }
}
