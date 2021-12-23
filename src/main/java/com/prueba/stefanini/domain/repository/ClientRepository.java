package com.prueba.stefanini.domain.repository;

import com.prueba.stefanini.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<List<Client>> getByClient(String id);
    Optional<Client> getClient(String id);
    Client save(Client client);
    void delete(String id);
}
