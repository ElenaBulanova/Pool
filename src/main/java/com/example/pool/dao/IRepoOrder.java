package com.example.pool.dao;

import com.example.pool.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface IRepoOrder extends CrudRepository<Order, Integer> {

}
