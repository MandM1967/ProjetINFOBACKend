package com.um6p.reservation.api;

import com.um6p.reservation.models.User;
import com.um6p.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity updateUser(@RequestBody User user) {
        User u ;
        try {
            userService.updateUser(user);
            u = userService.getUserByUserName(user.getUserName());
        } catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(u);
    }
    @DeleteMapping(value = "/delete/{username}")
    private ResponseEntity deleteUser(@PathVariable("username") String username)
    {
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping(
            value = "/updatepassword"
    )
    private ResponseEntity updatePassword(Authentication user, @RequestParam("newpasswrd")String password)
    {
        String username = user.getName();
        try{
            userService.updatePassword(username, password);
        }catch ( Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.ok().build();
    }
    @GetMapping("/getall")
    private ResponseEntity getAllUser() {
        try {
            List<User> users = userService.getAllUser();
            return ResponseEntity.ok().body(users);
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
