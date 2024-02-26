package com.example.pool.services;

import com.example.pool.dao.IRepoOrder;
import com.example.pool.exceptions.RecordNotFoundException;
import com.example.pool.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    public final IRepoOrder repo;
    public List<Order> findAll() {
        return (List<Order>) repo.findAll();
    }

    public Order findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Order save(Order order) {
        return repo.save(order);
    }

    public Order update(Order order) {
        Order orderToUpdate = repo.findById(order.getId()).get();
        orderToUpdate.setOrderDate(order.getOrderDate());
        orderToUpdate.setStartTime(order.getStartTime());
        orderToUpdate.setDuration(order.getDuration());
        orderToUpdate.setClient(order.getClient());
        orderToUpdate.setPoolTable(order.getPoolTable());
        return repo.save(orderToUpdate);
    }



    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
