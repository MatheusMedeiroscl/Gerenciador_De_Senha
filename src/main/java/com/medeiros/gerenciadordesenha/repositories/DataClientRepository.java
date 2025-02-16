package com.medeiros.gerenciadordesenha.repositories;

import com.medeiros.gerenciadordesenha.entities.DataClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataClientRepository extends JpaRepository<DataClient, Long> {

    Optional<DataClient> findByUsername(String username);
}
