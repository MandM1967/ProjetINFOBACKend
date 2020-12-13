package com.um6p.reservation.service;

import com.um6p.reservation.dao.SalleDao;
import com.um6p.reservation.dao.SlotDao;
import com.um6p.reservation.models.Slot;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SloteService {
    private  final SlotDao slotDao;
    private final SalleDao salleService;

    @Autowired
    public SloteService(SlotDao slotDao, SalleDao salleService) {
        this.slotDao = slotDao;
        this.salleService = salleService;
    }

    @Async
    public void addSlots(UUID id) {
        LocalDate now = new LocalDate();
        long timeStampMillis = now.toDate().getTime() /1000;
        slotDao.deleteSlotBefore(timeStampMillis);

        LocalDate monday = now.plus(Period.ZERO.withDays(7)).withDayOfWeek(DateTimeConstants.MONDAY);
        long endTime = monday.toDate().getTime() /1000;
        System.out.println(endTime);
        long end = timeStampMillis + 7200;
        Slot slot ;
        while (end < endTime) {
            slot = new Slot(id,null,false,timeStampMillis,end);
            insertSlot(slot);
            timeStampMillis = end;

             end +=7200;

        }

    }

    public  int insertSlot(Slot slot)
    {
        return  slotDao.insertSlot(slot);
    }
    public int deleteSlotById(UUID slotId) {
        return slotDao.deleteSlotById(slotId);
    }
    public Slot getSlotById(UUID slotID)
    {
        return slotDao.getSlotById(slotID);
    }
    public int reserveSlotById(String userName, UUID id){
        Slot slot = getSlotById(id);
        if (!slot.isResesrved())
        {
            int nbSlot = countSlots(slot.getSalleID());
            salleService.increaseRate(1/nbSlot,slot.getSalleID());
            slotDao.reserveSlotById(userName,id);
            return  0;
        }
        else
            throw new IllegalArgumentException("slot reserved");
    }
    public int countSlots(UUID salleId)
    {
        return  slotDao.countSlots(salleId);
    }
    public List<Slot> getSlotBySalleId(UUID salleId) {
        return slotDao.getSlotBySalleId(salleId);
    }

    public List<Slot> getSlotByUserName(String userName) {
        return slotDao.getSlotByUserName(userName);
    }

    public int deleteSlotBySalleId(UUID id) {
        return  slotDao.deleteSloteBySalleId(id);
    }

    public  int unsubscribeById(UUID id){
        Slot slot = getSlotById(id);
        int nbSlot = countSlots(slot.getSalleID());
        salleService.increaseRate( - (1/nbSlot),slot.getSalleID());
        return slotDao.unsubscribeById(id);
    }

    public int unsubscribeByUserName(String username)
    {
        List<Slot> slots = getSlotByUserName(username);
        if (slots.size()  > 0)
        {
            int nbSlot = countSlots(slots.get(0).getSalleID());
            salleService.increaseRate(-(slots.size()/nbSlot),slots.get(0).getSalleID());
            slotDao.unsubscribeByUserName(username);
        }
        return  0;
    }
}
