package com.um6p.reservation.api;

import com.um6p.reservation.service.SloteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/slot")
public class SlotController {
    private  final SloteService sloteService;

    public SlotController(SloteService sloteService) {
        this.sloteService = sloteService;
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity reserve(Authentication user, @PathVariable("id") UUID id)
    {
        try{
            String username = user.getName();
            sloteService.reserveSlotById(username,  id);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/unsubscribe/{id}")
    public ResponseEntity unsubscribe( @PathVariable("id") UUID id)
    {
        try{

            sloteService.unsubscribeById( id);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.notFound().build();
        }
    }
}
