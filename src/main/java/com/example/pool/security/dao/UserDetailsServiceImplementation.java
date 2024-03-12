package com.example.pool.security.dao;

import com.example.pool.security.entities.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {
    private final IRepoUser repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return SecurityUser.fromEntity(
                repo.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("такого юзера в базе нет!"))
        );
    }
}
