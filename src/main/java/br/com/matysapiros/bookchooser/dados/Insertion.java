package br.com.matysapiros.bookchooser.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insertion {
    private Connection connection;

    public Insertion() {
        this.connection = Conexao.getConexao();
    }

    public boolean insertBook(String nome, int numeracao, double avaliacao, int vezesLido){
        String sql = "insert into books (title,numeracao,avaliacao,read_flag) values(?,?,?,?);";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setString(1, nome);
            statementmt.setString(2, String.valueOf(numeracao));
            statementmt.setString(3, String.valueOf(avaliacao));
            statementmt.setString(4, String.valueOf(vezesLido));
            statementmt.execute();
            statementmt.close();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public boolean selectBook(String nome){
        String sql = "select * from books where title like ?";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setString(1, nome);
            ResultSet string = statementmt.executeQuery();
            while (string.next()) {
                String title = string.getString("title");
                System.out.println("Livro: " + title);
            }
            statementmt.execute();
            statementmt.close();
            return true;
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }
}
