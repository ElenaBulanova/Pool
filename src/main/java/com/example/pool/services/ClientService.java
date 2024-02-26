package com.example.pool.services;

import com.example.pool.dao.IRepoClient;
import com.example.pool.exceptions.RecordNotFoundException;
import com.example.pool.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    public final   IRepoClient repo;
    public List<Client> findAll() {
        return (List<Client>) repo.findAll();
    }

    public Client findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Client save(Client client) {
        return repo.save(client);
    }

    public Client update(Client client) {
        Client clientToUpdate = repo.findById(client.getId()).get();
        clientToUpdate.setName(client.getName());
        clientToUpdate.setPhone(client.getPhone());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setBirthday(client.getBirthday());
        return repo.save(clientToUpdate);
    }

    public Client findByName(String name) {
        return repo.findByName(name);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
