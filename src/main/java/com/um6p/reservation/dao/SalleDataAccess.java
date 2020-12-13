package com.um6p.reservation.dao;

import com.um6p.reservation.models.Salle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public class SalleDataAccess implements SalleDao {
    private final JdbcTemplate jdbcTemplate;

    public SalleDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSalle(Salle salle) {
        String sql = "insert into salle values(?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                salle.getId().toString(),
                salle.getNumSalle(),
                salle.getSalleType(),
                salle.getCapacite(),
                salle.getRate());
    }

    @Override
    public int updateSalleById(UUID id, Salle salle) {
        String sql = "update salle set numsalle = ?, salletype=?,capacite = ? where id = ?";
        return jdbcTemplate.update(sql, salle.getNumSalle(), salle.getSalleType(), salle.getCapacite(), id.toString());
    }

    @Override
    public int deleteSalleById(UUID id) {
        String sql = "delete from salle where id =?";
        return jdbcTemplate.update(sql, id.toString());
    }

    @Override
    public int resetRates() {
        String sql = "update salle set rate =0";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int increaseRate(double in, UUID salleId) {
        String sql = "update salle set rate = rate + ? where id=?";
        return jdbcTemplate.update(sql, in, salleId);
    }
}
