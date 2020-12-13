package com.um6p.reservation.service;

import com.um6p.reservation.dao.SlotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SloteService {
    private  final SlotDao slotDao;

    @Autowired
    public SloteService(SlotDao slotDao) {
        this.slotDao = slotDao;
    }
}
