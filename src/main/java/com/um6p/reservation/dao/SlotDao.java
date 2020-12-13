package com.um6p.reservation.dao;

import com.um6p.reservation.models.Slot;

import java.util.UUID;

public interface SlotDao {
    int insertSlot(Slot slot);
    int deleteSlot(Slot slot);
    int updateSlot(Slot slot);
    int reserveSlotById(String userName, UUID userId,UUID id);

}
