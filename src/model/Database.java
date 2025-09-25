// package com.example.projetomanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe utilitária para gerenciar a conexão com o banco de dados.
 * Configurações simples para MySQL.
 */
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/projetodb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
