package com.example.pool.dao;

import com.example.pool.model.Session;
import org.springframework.data.repository.CrudRepository;

public interface IRepoSession extends CrudRepository<Session, Integer> {

}
