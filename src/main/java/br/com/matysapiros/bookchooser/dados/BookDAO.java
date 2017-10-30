package br.com.matysapiros.bookchooser.dados;

import br.com.matysapiros.bookchooser.negocios.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DatabaseConnetion.getConexao();
    }

    public boolean insertBook(Book book){
        String sql = "insert into books (title,numeracao,avaliacao,read_flag) values(?,?,?,?)";
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

    public List<Book> selectAllBooks(){
        String sql = "select * from books";
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            ResultSet string = statementmt.executeQuery();
            statementmt.close();
            return mapResultSetToBookList(string);
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    private List<Book> mapResultSetToBookList(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(mapFromResultSet(resultSet));
        }
        return books;
    }


    public Book selectBookByID(Integer id){
        String sql = "select * from books where book_id = ?";
        Book book = null;
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setInt(1, id);
            ResultSet string = statementmt.executeQuery();
            string.next();
            book = mapFromResultSet(string);
            statementmt.close();
            return book;
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public String selectBookByTitle(String title){
        String sql = "select * from books where title = ?";
        Book book = null;
        try{
            PreparedStatement statementmt = connection.prepareStatement(sql);
            statementmt.setString(1, title);
            ResultSet string = statementmt.executeQuery();
            string.next();
            book = mapFromResultSet(string);
            return book.toString();
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    private Book mapFromResultSet(ResultSet string) throws SQLException {
        Book book = new Book();
        book.setNome(string.getString("title"));
        book.setNumeracao(Integer.parseInt(string.getString("numeracao")));
        book.setAvaliacao(Double.parseDouble(string.getString("avaliacao")));
        book.setVezesLido(Integer.parseInt(string.getString("read_flag")));
        return book;
    }
}
