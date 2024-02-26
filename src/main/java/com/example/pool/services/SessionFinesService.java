package com.example.pool.services;

import com.example.pool.dao.IRepoOrder;
import com.example.pool.dao.IRepoSessionFines;
import com.example.pool.exceptions.RecordNotFoundException;
import com.example.pool.model.Order;
import com.example.pool.model.SessionFines;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionFinesService {
    public final IRepoSessionFines repo;
    public List<SessionFines> findAll() {
        return (List<SessionFines>) repo.findAll();
    }

    public SessionFines findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public SessionFines save(SessionFines sessionFines) {
        return repo.save(sessionFines);
    }

    public SessionFines update(SessionFines sessionFines) {
        SessionFines sessionFinesToUpdate = repo.findById(sessionFines.getId()).get();
        sessionFinesToUpdate.setSession(sessionFines.getSession());
        sessionFinesToUpdate.setFine(sessionFines.getFine());
        sessionFinesToUpdate.setCount(sessionFines.getCount());
        return repo.save(sessionFinesToUpdate);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
