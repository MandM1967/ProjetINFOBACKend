package com.um6p.reservation.dao;

import com.um6p.reservation.models.Slot;

import java.util.List;
import java.util.UUID;

public interface SlotDao {
    int insertSlot(Slot slot);

    int deleteSlotById(UUID slotId);

    int deleteSlotBefore(long endTime);

    boolean IsReserved( UUID id);

    int reserveSlotById(String userName, UUID id);

    Slot getSlotById(UUID id);

    List<Slot> getSlotBySalleId(UUID salleId);

    List<Slot> getSlotByUserName(String userName);
}
