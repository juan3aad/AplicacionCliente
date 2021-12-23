package com.prueba.stefanini.web.controller;

import com.prueba.stefanini.domain.Client;
import com.prueba.stefanini.domain.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    public List<Client> getAll(){
        return clientService.getAll();
    }

    public Optional<Client> getClient(String id){
        return clientService.getClient(id);
    }

    public Optional<List<Client>> getByClient (String id){
        return clientService.getByClient(id);
    }

    public Client save(Client client){
        return clientService.save(client);
    }

    public boolean delete(String id){
        return clientService.delete(id);
    }

}
