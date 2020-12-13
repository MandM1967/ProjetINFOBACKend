package com.um6p.reservation.rowmappers;

import com.um6p.reservation.models.Admin;
import com.um6p.reservation.models.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminRowMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Admin(
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getString("email"),
                Department.valueOf(resultSet.getString("department")),
                resultSet.getString("phonenumber"),
                resultSet.getString("password"),
                resultSet.getString("username"),
                new ArrayList<>());
    }
}
