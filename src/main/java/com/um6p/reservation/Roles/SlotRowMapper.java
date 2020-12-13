package com.um6p.reservation.Roles;

import com.um6p.reservation.models.Slot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SlotRowMapper implements RowMapper<Slot> {
    @Override
    public Slot mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Slot(
                UUID.fromString(resultSet.getString("id")),
                UUID.fromString(resultSet.getString("salleid")),
                resultSet.getString("userName"),
                resultSet.getBoolean("isreserved"),
                resultSet.getLong("startat"),
                resultSet.getLong("endat"));
    }
}
