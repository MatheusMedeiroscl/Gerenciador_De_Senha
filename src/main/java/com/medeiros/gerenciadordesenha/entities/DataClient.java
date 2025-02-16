package com.medeiros.gerenciadordesenha.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "data_client")
public class DataClient {
    private String name,link,email,senha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
