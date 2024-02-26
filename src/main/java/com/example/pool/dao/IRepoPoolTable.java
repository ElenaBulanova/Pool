package com.example.pool.dao;

import com.example.pool.model.PoolTable;
import org.springframework.data.repository.CrudRepository;

public interface IRepoPoolTable extends CrudRepository<PoolTable, Integer> {
    PoolTable findByName(String name);
}
