package com.example.pool.security.entities.db;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Authority.CLIENT_READ, Authority.TABLE_READ)),
    ADMIN(Set.of(Authority.CLIENT_READ, Authority.TABLE_READ, Authority.CLIENT_WRITE));
   // LOSER(Set.of(Authority.BROWSE));

    private Set<Authority> authorities;

    Role(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth.name()))
                .collect(Collectors.toSet());
    }
}
