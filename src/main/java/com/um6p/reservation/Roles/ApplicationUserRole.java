package com.um6p.reservation.Roles;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.um6p.reservation.Roles.ApplicationUserPermission.*;


public enum ApplicationUserRole {

    ADMIN(Sets.newHashSet(Lists.list(READ,RESERVE,ADDUSER))),
    USER(Sets.newHashSet(Lists.list(READ,RESERVE)));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
           permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}