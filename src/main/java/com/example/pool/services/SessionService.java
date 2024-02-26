package com.example.pool.services;

import com.example.pool.dao.IRepoSession;
import com.example.pool.exceptions.RecordNotFoundException;
import com.example.pool.model.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    public final IRepoSession repo;
    public List<Session> findAll() {
        return (List<Session>) repo.findAll();
    }

    public Session findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Session save(Session session) {
        return repo.save(session);
    }

    public Session update(Session session) {
        Session sessionToUpdate = repo.findById(session.getId()).get();
        sessionToUpdate.setClient(session.getClient());
        sessionToUpdate.setStart(session.getStart());
        sessionToUpdate.setFinish(session.getFinish());
        sessionToUpdate.setPoolTable(session.getPoolTable());
        return repo.save(sessionToUpdate);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
