package com.prueba.stefanini.persistence.mapper;

import com.prueba.stefanini.domain.Client;
import com.prueba.stefanini.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "identificacion", target = "id"),
            @Mapping(source = "razon", target = "reason"),
            @Mapping(source = "contacto", target = "contact"),
            @Mapping(source = "region", target = "region"),
            @Mapping(source = "tipo", target = "type"),
    })
    Client toClient(Cliente cliente);
    List<Client>toClients(List<Cliente> clientes);
    @InheritInverseConfiguration
    Cliente toCliente(Client client);


}
