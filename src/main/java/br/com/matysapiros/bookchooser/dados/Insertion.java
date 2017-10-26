package br.com.matysapiros.bookchooser.dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        }catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
}
