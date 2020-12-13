package com.um6p.reservation.api;

import com.um6p.reservation.models.Admin;
import com.um6p.reservation.models.User;
import com.um6p.reservation.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController( AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(
            value = "/admin",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity singUpAdmin(@RequestBody Admin admin)
    {
        try{

            authenticationService.signUpAdmin(admin);
        }catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    private ResponseEntity signUpUser(@RequestBody User user)
    {
        try{
            authenticationService.signUpUser(user);
        }catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "me")
    private ResponseEntity getMyInfo(Authentication user)
    {
        String username = user.getName();
        try
        {
            Admin admin = authenticationService.getAdminService().getAdmin(username);
            return ResponseEntity.ok().body(admin);
        }catch (Exception e)
        {
            e.printStackTrace();
            try {

                User u = authenticationService.getUserService().getUserByUserName(username);
                    return ResponseEntity.ok().body(u);
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return  ResponseEntity.badRequest().build();
    }
}
