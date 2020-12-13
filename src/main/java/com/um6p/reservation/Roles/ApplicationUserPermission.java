package com.um6p.reservation.Roles;

public enum ApplicationUserPermission {
    READ("read"),
    RESERVE("reserve"),
    ADDUSER("adduser");



    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}