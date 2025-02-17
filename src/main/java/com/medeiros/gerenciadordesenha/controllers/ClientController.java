package com.medeiros.gerenciadordesenha.controllers;


import com.medeiros.gerenciadordesenha.entities.DataClient;
import com.medeiros.gerenciadordesenha.services.DataClientServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/dataClient")
@Validated
public class ClientController {
    @Autowired
    private DataClientServices services;

    @GetMapping("/{id}")
    public ResponseEntity<DataClient> findById(@PathVariable Long id){
        DataClient obj = this.services.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DataClient> findById(@PathVariable String name){
        DataClient obj = this.services.findByName(name);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(DataClient.CreateData.class) // interface de validação criada no DataClient
    public ResponseEntity<Void> create(@Valid @RequestBody DataClient obj){

        //Builder que pega contexto do user para encontrar e gerar o user
        this.services.create(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }


    @PutMapping("/{id}")
    @Validated(DataClient.UpdateData.class)
    public ResponseEntity<Void> update(@Valid @RequestBody  DataClient obj, @PathVariable Long id){
        obj.setId(id);
        this.services.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.services.delete(id);

        return ResponseEntity.noContent().build();
    }


}
