package com.prueba.stefanini.persistence;

import com.prueba.stefanini.domain.Client;
import com.prueba.stefanini.domain.repository.ClientRepository;

import com.prueba.stefanini.persistence.crud.ClienteCrudRepository;
import com.prueba.stefanini.persistence.entity.Cliente;
import com.prueba.stefanini.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;
@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper mapper;
    @Override
    public List<Client> getAll(){
        List<Cliente> clientes=(List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(clientes);
    }
    @Override
    public Optional <List<Client>> getByClient(String id){
        List<Cliente> clientes= clienteCrudRepository.findByIdentificacionOrderByRazonAsc(id);
        return Optional.of(mapper.toClients(clientes));
    }
    @Override
    public Optional<Client>getClient(String id){
        return clienteCrudRepository.findById(id).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente= mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));

    }

    public void delete(String id){
        clienteCrudRepository.deleteById(id);
    }



}
