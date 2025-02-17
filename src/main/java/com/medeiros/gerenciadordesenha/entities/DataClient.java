package com.medeiros.gerenciadordesenha.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "data_client")
public class DataClient {
    public interface CreateData {};
    public interface UpdateData {};

    @NotBlank(groups = CreateData.class)
    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(groups = CreateData.class)
    @Column(name = "link")
    private String link;

    @NotBlank(groups = CreateData.class)
    @Column(name = "senha")
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
