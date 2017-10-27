package br.com.matysapiros.bookchooser.dados;

import br.com.matysapiros.bookchooser.negocios.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    private Connection connection;
    EnumBookDAO enumBookDAO;

    public BookDAO() {
        this.connection = DatabaseConnetion.getConexao();
    }

    public boolean insertBook(Book book){
        String sql = enumBookDAO.getComandoSQL();
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
}
