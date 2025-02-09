package com.medeiros.gerenciadordesenha.entities;


public class Client {
    private String name,link, email, password;

    public Client(String email, String link, String name, String password) {
        this.email = email;
        this.link = link;
        this.name = name;
        this.password = password;
    }

    public String name() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String link() {
        return link;
    }

    public Client setLink(String link) {
        this.link = link;
        return this;
    }

    public String email() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String password() {
        return password;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }
}
