package com.um6p.reservation.dao;

import com.um6p.reservation.Roles.SalleRowMapper;
import com.um6p.reservation.models.Salle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class SalleDataAccess implements SalleDao {
    private final JdbcTemplate jdbcTemplate;

    public SalleDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSalle(Salle salle) {
        String sql = "insert into salle values(?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                salle.getId(),
                salle.getNumSalle(),
                salle.getSalleType(),
                salle.getCapacite(),
                salle.getRate());
    }

    @Override
    public int updateSalleById(UUID id, Salle salle) {
        String sql = "update salle set numsalle = ?, salletype=?,capacite = ? where id = ?";
        return jdbcTemplate.update(sql, salle.getNumSalle(), salle.getSalleType(), salle.getCapacite(), id);
    }

    @Override
    public int deleteSalleById(UUID id) {
        String sql = "delete from salle where id =?";
        return jdbcTemplate.update(sql, id);
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

    @Override
    public List<Salle> getAll() {
        String sql = "select * from salle ";
        return jdbcTemplate.query(sql, new SalleRowMapper());
    }

    @Override
    public Salle getSalleById(UUID id) {
        String sql = "select * from salle where id = ?";
        return jdbcTemplate.queryForObject(sql, new SalleRowMapper(), id);
    }
}
