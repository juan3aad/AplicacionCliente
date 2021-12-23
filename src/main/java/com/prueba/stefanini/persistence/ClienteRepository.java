package com.prueba.stefanini.persistence;

import com.prueba.stefanini.persistence.ClienteRepository;
import com.prueba.stefanini.persistence.crud.ClienteCrudRepository;
import com.prueba.stefanini.persistence.entity.Cliente;

import java.util.List;

public class ClienteRepository {
    private ClienteCrudRepository clienteCrudRepository;
    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }
}
