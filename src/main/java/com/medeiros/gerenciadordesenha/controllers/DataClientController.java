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
@RequestMapping("/dataclient")
public class DataClientController {

    @Autowired
    DataClientServices services;

    @GetMapping("/{id}")
    public ResponseEntity<DataClient> findByid(@PathVariable Long id){
        DataClient obj = this.services.findById(id);

        return ResponseEntity.ok().body(obj);

    }

    @GetMapping("/data/{name}")
    public ResponseEntity<DataClient> findByName(@PathVariable String  name){
        DataClient obj = this.services.findByName(name);

        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    @Validated(DataClient.CreateDataClient.class)
    public ResponseEntity<DataClient> create( @Valid @RequestBody DataClient obj){
        this.services.create(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();

        return  ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    @Validated(DataClient.UpdateDataClient.class)
      public ResponseEntity<DataClient> update(@PathVariable Long id, @Valid @RequestBody DataClient obj){
        obj.setId(id);
        this.services.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);
    }


}



