package com.example.pool.dao;

import com.example.pool.model.Fine;
import org.springframework.data.repository.CrudRepository;

public interface IRepoFine extends CrudRepository<Fine, Integer> {
    Fine findByName(String name);
}
