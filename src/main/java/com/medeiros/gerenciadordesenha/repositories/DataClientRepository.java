package com.medeiros.gerenciadordesenha.repositories;

import com.medeiros.gerenciadordesenha.entities.DataClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataClientRepository extends JpaRepository<DataClient, Long> {
    Optional<DataClient> findByName(String name);

}
