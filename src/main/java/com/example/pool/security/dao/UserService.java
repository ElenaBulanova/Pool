package com.example.pool.security.dao;

import com.example.pool.security.entities.db.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IRepoUser repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}
