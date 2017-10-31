package br.com.matysapiros.bookchooser.dados;

import br.com.matysapiros.bookchooser.negocios.Book;
import br.com.matysapiros.bookchooser.negocios.Genre;

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
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, book.getNome());
            statementmt.setString(2, String.valueOf(book.getNumeracao()));
            statementmt.setString(3, String.valueOf(book.getAvaliacao()));
            statementmt.setString(4, String.valueOf(book.getVezesLido()));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public List<Book> selectAllBooks(){
        String sql = "SELECT books.title, genres.genre, books_types.description FROM books_and_genres JOIN books ON books.book_id = books_and_genres.book_id join genres on genres.genre_id = books_and_genres.genre_id;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            ResultSet string = statementmt.executeQuery();
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
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setInt(1, id);
            ResultSet string = statementmt.executeQuery();
            string.next();
            book = mapFromResultSet(string);
            return book;
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public String selectBookByTitle(String title){
        String sql = "select * from books where title = ?";
        Book book = null;
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
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

    public boolean insertBookType(int bookID, int typeID){
        String sql = "update books set type_id = ? where book_id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql);){
            statementmt.setString(1, String.valueOf(bookID));
            statementmt.setString(2, String.valueOf(typeID));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public List<Genre> selectAllGenres(){
        String sql = "SELECT * FROM genres;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            ResultSet resultSet = statementmt.executeQuery();
            return mapResultSetToGenreList(resultSet);
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    private Genre mapFromResultSetGenres(ResultSet resultSet) throws SQLException {
        Genre genre = new Genre();
        genre.setGenreID(Integer.parseInt(resultSet.getString("genre_id")));
        genre.setGenre(resultSet.getString("genre"));
        return genre;
    }

    private List<Genre> mapResultSetToGenreList(ResultSet resultSet) throws SQLException {
        List<Genre> genres = new ArrayList<>();
        while (resultSet.next()) {
            genres.add(mapFromResultSetGenres(resultSet));
        }
        return genres;
    }
}
