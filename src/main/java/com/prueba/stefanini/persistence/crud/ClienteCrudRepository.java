package com.prueba.stefanini.persistence.crud;

import com.prueba.stefanini.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
        List<Cliente> findByIdentificacionOrderByRazonAsc(String identificacion);

}
