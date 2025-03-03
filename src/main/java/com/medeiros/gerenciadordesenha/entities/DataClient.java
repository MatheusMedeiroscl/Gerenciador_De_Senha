package com.medeiros.gerenciadordesenha.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.*;

@Entity
@Table(name = DataClient.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class DataClient {

    public interface CreateDataClient { } // Validação para criação
    public interface UpdateDataClient { } // Validação para atualização

    public static final String TABLE_NAME = "data_client";

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotNull(groups = CreateDataClient.class)
    @NotEmpty(groups = CreateDataClient.class)
    @Size(groups = CreateDataClient.class, min = 2, max = 100)
    private String name;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateDataClient.class)
    @NotEmpty(groups = CreateDataClient.class)
    @Size(groups = CreateDataClient.class, min = 5, max = 100)
    private String email;

    @Column(name = "link", length = 255)
    @Size(groups = { CreateDataClient.class, UpdateDataClient.class }, max = 255)
    private String link;

    @JsonProperty(access = Access.WRITE_ONLY) // Garante que a senha só será escrita, nunca retornada na API
    @Column(name = "password", length = 60, nullable = false)
    @NotNull(groups = { CreateDataClient.class, UpdateDataClient.class })
    @NotEmpty(groups = { CreateDataClient.class, UpdateDataClient.class })
    @Size(groups = { CreateDataClient.class, UpdateDataClient.class }, min = 8, max = 60)
    private String password;


    public @NotNull(groups = CreateDataClient.class) @NotEmpty(groups = CreateDataClient.class) @Size(groups = CreateDataClient.class, min = 2, max = 100) String getName() {
        return name;
    }

    public void setName(@NotNull(groups = CreateDataClient.class) @NotEmpty(groups = CreateDataClient.class) @Size(groups = CreateDataClient.class, min = 2, max = 100) String name) {
        this.name = name;
    }

    public @NotNull(groups = CreateDataClient.class) @NotEmpty(groups = CreateDataClient.class) @Size(groups = CreateDataClient.class, min = 5, max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(groups = CreateDataClient.class) @NotEmpty(groups = CreateDataClient.class) @Size(groups = CreateDataClient.class, min = 5, max = 100) String email) {
        this.email = email;
    }

    public @NotNull(groups = {CreateDataClient.class, UpdateDataClient.class}) @NotEmpty(groups = {CreateDataClient.class, UpdateDataClient.class}) @Size(groups = {CreateDataClient.class, UpdateDataClient.class}, min = 8, max = 60) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(groups = {CreateDataClient.class, UpdateDataClient.class}) @NotEmpty(groups = {CreateDataClient.class, UpdateDataClient.class}) @Size(groups = {CreateDataClient.class, UpdateDataClient.class}, min = 8, max = 60) String password) {
        this.password = password;
    }

    public @Size(groups = {CreateDataClient.class, UpdateDataClient.class}, max = 255) String getLink() {
        return link;
    }

    public void setLink(@Size(groups = {CreateDataClient.class, UpdateDataClient.class}, max = 255) String link) {
        this.link = link;
    }
}
