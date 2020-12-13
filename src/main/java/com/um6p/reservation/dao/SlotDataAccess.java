package com.um6p.reservation.dao;

import com.um6p.reservation.Roles.SlotRowMapper;
import com.um6p.reservation.models.Slot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SlotDataAccess implements SlotDao {
    private final JdbcTemplate jdbcTemplate;

    public SlotDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSlot(Slot slot) {
        String sql = "insert into slot values(?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                slot.getId().toString(),
                slot.getSalleID().toString(),
                slot.getUserName(),
                slot.isResesrved(),
                slot.getStartAt(),
                slot.getEndAt());
    }

    @Override
    public int deleteSlotById(UUID slotId) {
        String sql  = "delete from slot where id = ?";
        return jdbcTemplate.update(sql, slotId.toString());
    }

    @Override
    public int deleteSlotBefore(long endTime)
    {
        String sql = "delete from slot where endat <= ?";
        return jdbcTemplate.update(sql);
    }

    @Override
    public boolean IsReserved(UUID id)
    {
        String sql = "select  isreserved from slot  where id = ?";
        return jdbcTemplate.queryForObject(sql,
                (reserltSet ,i)->
                {return reserltSet.getBoolean("isreserved");},
                id.toString());
    }


    @Override
    public int reserveSlotById(String userName, UUID id)
    {
        String sql = "update slot set username = ? ,isreserved = ? where id =?";
        return jdbcTemplate.update(sql,userName,true,id.toString());
    }

    @Override
    public Slot getSlotById(UUID id) {
        String sql = "select * from slot where id = ?";
        return jdbcTemplate.queryForObject(sql, new SlotRowMapper(),id.toString());
    }

    @Override
    public List<Slot> getSlotBySalleId(UUID salleId) {
        String sql = "select * from slot where salleid = ?";
        return  jdbcTemplate.query(sql, new SlotRowMapper(), salleId.toString());
    }

    @Override
    public List<Slot> getSlotByUserName(String userName) {

        String sql = "select * from slot where username = ?";
        return  jdbcTemplate.query(sql, new SlotRowMapper(), userName);
    }
}
