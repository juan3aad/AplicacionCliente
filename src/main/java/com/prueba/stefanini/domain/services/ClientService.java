package com.prueba.stefanini.domain.services;

import com.prueba.stefanini.domain.Client;
import com.prueba.stefanini.domain.repository.ClientRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(String id){
        return clientRepository.getClient(id);
    }

    public Optional<List<Client>> getByClient(String id){
        return clientRepository.getByClient(id);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public boolean delete(String id){
        return getClient(id).map(client -> {
            clientRepository.delete(id);
            return true;
        }).orElse(false);
    }

}
