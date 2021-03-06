package com.prueba.stefanini.web.controller;

import com.prueba.stefanini.domain.Client;
import com.prueba.stefanini.domain.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/clients/")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client>getClient(@PathVariable("id") String id){
        return clientService.getClient(id)
                .map(client -> new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/client/{id}")
    public Optional<List<Client>> getByClient (@PathVariable("id") String id){
        return clientService.getByClient(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        if(clientService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable("id") String id){
        return clientService.getClient(id).map(client1 ->
        {
            client1.setId(client.getId());
            client1.setReason(client.getReason());
            client1.setRegion(client.getRegion());
            client1.setContact(client.getContact());
            client1.setType(client.getType());

            return new ResponseEntity<>(clientService.save(client1), HttpStatus.CREATED);


        }).orElseGet(() ->{
            client.setId(id);
            return new ResponseEntity<>(clientService.save(client),HttpStatus.NOT_FOUND);
        });
    }


}
