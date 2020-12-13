package com.um6p.reservation.Roles;

public enum ApplicationUserPermission {
    READ("user:read"),
    RESERVE("slot:reserve"),
    ADDUSER("user:add");



    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}