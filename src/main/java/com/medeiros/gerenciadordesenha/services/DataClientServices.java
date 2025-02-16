package com.medeiros.gerenciadordesenha.services;

import com.fasterxml.jackson.databind.DatabindException;
import com.medeiros.gerenciadordesenha.entities.DataClient;
import com.medeiros.gerenciadordesenha.repositories.DataClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //usa das funções do repository
public class DataClientServices {
    @Autowired
    private DataClientRepository repository;

    public DataClient findById(Long id){
        Optional<DataClient> dataClient = this.repository.findById(id);

        return dataClient.orElseThrow(() -> new RuntimeException(
                "[ERROR IN DATACLIENTSERVICES] - dados do cliente não foram encontrados  " + id
        ));
    }

    public DataClient findByName(String name){
        Optional<DataClient> dataClient = repository.findByUsername(name);

        return dataClient.orElseThrow(() -> new RuntimeException(
                "[ERROR IN DATACLIENTSERVICES] - dados do cliente não foram encontrados" + name
        ));
    }

    @Transactional
    public DataClient create(DataClient obj){
        obj.setId(null);
        obj = this.repository.save(obj);

        return obj;
    }

    @Transactional
    public DataClient update(DataClient obj){
        DataClient newObj = findById(obj.getId());
        newObj = obj;

        return this.repository.save(newObj);
    }

    public void delete(Long id){
        DataClient obj = findById(id);

        try {
            this.repository.delete(obj);
            System.out.println("dados do Cliente apagados com sucesso");
        }catch (Exception e){
            System.out.println("[ERROR IN DATACLIENTSERVICES] - não foi possivel deletar os dados do client: " + e);
        }

    }}
