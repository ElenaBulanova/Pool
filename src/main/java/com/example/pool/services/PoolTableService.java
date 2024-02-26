package com.example.pool.services;

import com.example.pool.dao.IRepoPoolTable;
import com.example.pool.model.PoolTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.pool.exceptions.RecordNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PoolTableService {
    public final IRepoPoolTable repo;
    public List<PoolTable> findAll() {
        return (List<PoolTable>) repo.findAll();
    }

    public PoolTable findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public PoolTable save(PoolTable poolTable) {
        return repo.save(poolTable);
    }

    public PoolTable update(PoolTable poolTable) {
        PoolTable poolTableToUpdate = repo.findById(poolTable.getId()).get();
        poolTableToUpdate.setName(poolTable.getName());
        poolTableToUpdate.setPrice(poolTable.getPrice());
        return repo.save(poolTableToUpdate);
    }

    public PoolTable findByName(String name) {
        return repo.findByName(name);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
