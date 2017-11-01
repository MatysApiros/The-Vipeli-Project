package br.com.matysapiros.bookchooser.controler;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DatabaseConnetion {

    public static String status = "Não conectou...";

    public DatabaseConnetion() {

    }

    public static java.sql.Connection getConexao() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "projeto";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useSSL=false";
            String username = "root";
            String password = "admin";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("Status da conexão: Conexão efetuada com sucesso!");
            } else {
                status = ("Status da conexão: Não foi possível realizar a conexão com o banco!");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado não foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean closeConection() {
        try {
            DatabaseConnetion.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection openConection() {
        closeConection();
        return DatabaseConnetion.getConexao();
    }
}
