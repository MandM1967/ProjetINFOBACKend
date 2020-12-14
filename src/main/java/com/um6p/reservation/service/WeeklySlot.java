package com.um6p.reservation.service;

import com.um6p.reservation.models.Salle;
import com.um6p.reservation.models.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeeklySlot {
    private final SloteService sloteService;
    private final SalleService salleService;

    @Autowired
    public WeeklySlot(SloteService sloteService, SalleService salleService) {
        this.sloteService = sloteService;
        this.salleService = salleService;
    }

    @Scheduled(cron = "0 0 0 ? * SUN ")
    public void reportCurrentTime() {
        List<Salle> salles = salleService.getAll();

        salles.forEach(s ->{
            sloteService.deleteSlotBySalleId(s.getId());
            sloteService.addSlots(s.getId());
        });
    }
}
