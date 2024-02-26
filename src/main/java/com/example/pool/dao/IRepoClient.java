package com.example.pool.dao;

import com.example.pool.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface IRepoClient extends CrudRepository<Client, Integer> {
    Client findByName(String name);
}
