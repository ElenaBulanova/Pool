package com.example.pool.security.dao;

import com.example.pool.security.entities.db.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRepoUser extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
