package com.medeiros.gerenciadordesenha.services;

import com.medeiros.gerenciadordesenha.entities.DataClient;
import com.medeiros.gerenciadordesenha.repositories.DataClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataClientServices {

    @Autowired
    private final DataClientRepository repository;

    public DataClientServices(DataClientRepository repository) {
        this.repository = repository;
    }

    public DataClient findById(Long id){
        Optional<DataClient> obj = this.repository.findById(id);

        return obj.orElseThrow(() -> new RuntimeException(
                "[ERROR] dados não encontrados {" + id + "}"
        ));
    }

    public DataClient findByName(String name){
        Optional<DataClient> obj = this.repository.findByName(name);

        return obj.orElseThrow(() -> new RuntimeException(
                "[ERROR] dados não encontrados {" + name + "}"
        ));
    }

    @Transactional
    public DataClient create(DataClient data){
        data.setId(null);
        data = repository.save(data);

        return data;
    }

    @Transactional
    public DataClient update(DataClient data){
        DataClient newObj = findById(data.getId()); // Busca o objeto no banco

        if (data.getEmail() != null){
            newObj.setEmail(data.getEmail());
        }
        if (data.getLink() != null){
            newObj.setLink(data.getLink());
        }
        if (data.getName() != null){
            newObj.setName(data.getName());
        }
        if (data.getPassword() != null){
            newObj.setPassword(data.getPassword());
        }

        return repository.save(newObj); // Aqui deve ser 'newObj', não 'data'
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
