package com.jrsf.sales.rest;


import com.jrsf.sales.model.entity.Client;
import com.jrsf.sales.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("http://localhost:4200")
public class clientController {

    private final ClientRepository repository;

    @Autowired
    public clientController(ClientRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Client> findAll(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid Client client){
        return repository.save(client);
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository
                .findById(id)
                .map(client -> {
                    repository.delete(client);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid  Client clientUpdate){
        repository
                .findById(id)
                .map(client -> {
                    client.setName(clientUpdate.getName());
                    client.setNif(clientUpdate.getNif());
                    return repository.save(client);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
