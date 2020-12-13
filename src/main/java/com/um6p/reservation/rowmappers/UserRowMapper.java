package com.um6p.reservation.rowmappers;

import com.um6p.reservation.models.Department;
import com.um6p.reservation.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getString("email"),
                Department.valueOf(resultSet.getString("department")),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("username"),
                new ArrayList<>());
    }
}
