package com.um6p.reservation.dao;

import com.um6p.reservation.models.Salle;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SalleDataAccess implements SalleDao{
    private final JdbcTemplate jdbcTemplate;

    public SalleDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSalle(Salle salle) {
        return 0;
    }

    @Override
    public int updateSalleById(UUID id, Salle salle) {
        return 0;
    }

    @Override
    public int deleteSalleById(UUID id) {
        return 0;
    }

    @Override
    public int resetRates() {
        return 0;
    }
}
