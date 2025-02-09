package com.medeiros.gerenciadordesenha.controllers;


import com.medeiros.gerenciadordesenha.database.connection.Conn;
import com.medeiros.gerenciadordesenha.entities.Client;

import java.sql.PreparedStatement;
public class ClientController {


    public void create(Client client){
        String sql = "INSERT INTO CLIENT (NOME, LINK, EMAIL, SENHA) VALUES (?,?,?,?)";
        PreparedStatement ps =  null;

        try{
            ps= Conn.getConn().prepareStatement(sql);
            ps.setString(1, client.name());
            ps.setString(2, client.link());
            ps.setString(3, client.email());
            ps.setString(4, client.password());

            ps.execute();
            ps.close();
            System.out.println("Execute Completed");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR in Execute");
        }


    }
}
