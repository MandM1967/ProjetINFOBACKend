package com.um6p.reservation.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.um6p.reservation.Roles.ApplicationUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Admin implements UserDetails {

    private final String  firstName;
    private final String lastName;
    private final String email;
    private final Department department;
    private final  String phoneNumber;
    private  String password;
    private final String userName;

    @JsonProperty("slots")
    private  List<Slot> slots;

    public Admin(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName")  String lastName,
            @JsonProperty("email")   String email,
            @JsonProperty("department") String department,
            @JsonProperty("phoneNumber")  String phoneNumber,
            @JsonProperty("password")  String password,
            @JsonProperty("userName")  String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department =  Department.valueOf(department);
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;
        slots = new ArrayList();

    }

    public Admin(
            String firstName,
            String lastName,
            String email,
            Department department,
            String phoneNumber,
            String password,
            String userName,
            List<Slot> slots) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;
        this.slots = slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Department getDepartment() {
        return department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return ApplicationUserRole.ADMIN.getGrantedAuthorities();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
