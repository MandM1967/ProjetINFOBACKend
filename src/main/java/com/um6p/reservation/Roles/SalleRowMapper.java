package com.um6p.reservation.Roles;

import com.um6p.reservation.models.Salle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class SalleRowMapper implements RowMapper<Salle> {
    @Override
    public Salle mapRow(ResultSet resultSet, int i) throws SQLException {

        return new Salle(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("numsalle"),
                resultSet.getString("salletype"),
                resultSet.getInt("capacite"),
                resultSet.getDouble("rate"),
                new ArrayList<>());
    }
}
