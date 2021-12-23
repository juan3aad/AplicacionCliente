package com.prueba.stefanini.persistence;

import com.prueba.stefanini.persistence.ClienteRepository;
import com.prueba.stefanini.persistence.crud.ClienteCrudRepository;
import com.prueba.stefanini.persistence.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClienteRepository {
    private ClienteCrudRepository clienteCrudRepository;
    public List<Cliente> getAll(){ return (List<Cliente>) clienteCrudRepository.findAll();  }
    public List<Cliente> getByCliente(String identificacion){
        return clienteCrudRepository.findByIdentificacionOrderByRazonAsc(identificacion);
    }
    public Optional<Cliente> getCliente(String identificacion){
        return clienteCrudRepository.findById(identificacion);
    }
    public Cliente save(Cliente cliente){
        return clienteCrudRepository.save(cliente);
    }
    public void delete(String identificacion){
        clienteCrudRepository.deleteById(identificacion);
    }



}
