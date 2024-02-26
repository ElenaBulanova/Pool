package com.example.pool.services;

import com.example.pool.dao.IRepoFine;
import com.example.pool.exceptions.RecordNotFoundException;
import com.example.pool.model.Fine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FineService {
    public final IRepoFine repo;
    public List<Fine> findAll() {
        return (List<Fine>) repo.findAll();
    }

    public Fine findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Fine save(Fine fine) {
        return repo.save(fine);
    }

    public Fine update(Fine fine) {
        Fine fineToUpdate = repo.findById(fine.getId()).get();
        fineToUpdate.setName(fine.getName());
        fineToUpdate.setCost(fine.getCost());
        return repo.save(fineToUpdate);
    }

    public Fine findByName(String name) {
        return repo.findByName(name);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
