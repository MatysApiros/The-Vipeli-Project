package br.com.matysapiros.bookchooser.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DatabaseConnetion.getConexao();
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

    public boolean selectAllBooks(){
        String sql = "select * from books";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            ResultSet string = statementmt.executeQuery();
            while (string.next()) {
                String title = string.getString("title");
                String id = string.getString("book_id");
                String numeracao = string.getString("numeracao");
                String avaliacao =  string.getString("avaliacao");
                String vezesLido = string.getString("read_flag");
                System.out.println("Book: " + title + "\n" + "Book ID:" + id + "\n" + "Numeration: " + numeracao + "\n" + "Evaluation: " + avaliacao + "\n" + "Read Count: " + vezesLido + "\n");
            }
            statementmt.execute();
            statementmt.close();
            return true;
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public boolean selectBookByName(String nome){
        String sql = "select * from books where title like ?";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setString(1, nome);
            ResultSet string = statementmt.executeQuery();
            while (string.next()) {
                String title = string.getString("title");
                String id = string.getString("book_id");
                String numeracao = string.getString("numeracao");
                String avaliacao =  string.getString("avaliacao");
                String vezesLido = string.getString("read_flag");
                System.out.println("Book: " + title + "\n" + "Book ID:" + id + "\n" + "Numeration: " + numeracao + "\n" + "Evaluation: " + avaliacao + "\n" + "Read Count: " + vezesLido);
            }
            statementmt.execute();
            statementmt.close();
            return true;
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public boolean selectBookByID(int book_id){
        String sql = "select * from books where book_id = ?";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setString(1, String.valueOf(book_id));
            ResultSet string = statementmt.executeQuery();
            while (string.next()) {
                String title = string.getString("title");
                String id = string.getString("book_id");
                String numeracao = string.getString("numeracao");
                String avaliacao =  string.getString("avaliacao");
                String vezesLido = string.getString("read_flag");
                System.out.println("Book: " + title + "\n" + "Book ID:" + id + "\n" + "Numeration: " + numeracao + "\n" + "Evaluation: " + avaliacao + "\n" + "Read Count: " + vezesLido);
            }
            statementmt.execute();
            statementmt.close();
            return true;
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }
}
