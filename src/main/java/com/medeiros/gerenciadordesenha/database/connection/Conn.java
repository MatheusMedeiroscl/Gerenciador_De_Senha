package com.medeiros.gerenciadordesenha.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private static final String url = "jdbc:mysql://localhost:8080/gerenciador_de_senha";
    private static final String user = "root";
    private static final String password = "Rrm565756";

    private static Connection conn;

    public static  Connection getConn(){
        try{
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;

            }else {
                return conn;
            }

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR in connection database");
            return null;
        }

    }

}
