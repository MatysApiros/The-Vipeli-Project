package br.com.matysapiros.bookchooser.dados;

import br.com.matysapiros.bookchooser.negocios.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DatabaseConnetion.getConexao();
    }

    public boolean insertBook(Book book){
        String sql = "insert into books (title,numeracao,avaliacao,read_flag) values(?,?,?,?);";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setString(1, book.getNome());
            statementmt.setString(2, String.valueOf(book.getNumeracao()));
            statementmt.setString(3, String.valueOf(book.getAvaliacao()));
            statementmt.setString(4, String.valueOf(book.getVezesLido()));
            statementmt.execute();
            statementmt.close();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public boolean selectAllBooks(){
                Book book = new Book();
        String sql = "select * from books";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            ResultSet string = statementmt.executeQuery();
            while (string.next()) {
                book.setNome(string.getString("title"));
                book.setId(Integer.parseInt(string.getString("book_id")));
                book.setGenre(string.getNString("genre"));
                book.setNumeracao(Integer.parseInt(string.getString("numeracao")));
                book.setAvaliacao(Integer.parseInt(string.getString("avaliacao")));
                book.setVezesLido(Integer.parseInt(string.getString("read_flag")));
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
