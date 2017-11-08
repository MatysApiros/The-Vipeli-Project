package br.com.matysapiros.bookchooser.database;

import br.com.matysapiros.bookchooser.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DatabaseConnection.getConexao();
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
            throw new BooksException("Erro ao listar livros");
        }
    }

    public boolean insertBookType(int bookID, int typeID){
        String sql = "update books set type_id = ? where book_id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(typeID));
            statementmt.setString(2, String.valueOf(bookID));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public boolean updateBookEvaluation(int bookID, double evaluation){
        String sql = "update books set avaliacao = ? where book_id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(evaluation));
            statementmt.setString(2, String.valueOf(bookID));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public boolean deleteBook(int bookId){
        String sql = "delete from books where book_id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(bookId));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
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

    public String selectBookByID(Integer id){
        String sql = "select * from books where book_id = ?";
        Book book = null;
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setInt(1, id);
            ResultSet string = statementmt.executeQuery();
            string.next();
            book = mapFromResultSet(string);
            return book.toString();
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    public List<Book> selectAllBooks(){
        String sql = "select * from books";
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

    private Book mapFromResultSet(ResultSet string) throws SQLException {
        Book book = new Book();
        book.setNome(string.getString("title"));
        book.setNumeracao(Integer.parseInt(string.getString("numeracao")));
        book.setAvaliacao(Double.parseDouble(string.getString("avaliacao")));
        book.setVezesLido(Integer.parseInt(string.getString("read_flag")));
        return book;
    }

    public List<BooksWithGenres> selectBooksAndGenres(Integer book_id){
        String sql = "SELECT books.title, genres.genre FROM books_and_genres JOIN books ON books.book_id = books_and_genres.book_id join genres on genres.genre_id = books_and_genres.genre_id where books.book_id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setInt(1, book_id);
            ResultSet string = statementmt.executeQuery();
            return mapResultSetToBooksAndGenresList(string);
        } catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }

    private List<BooksWithGenres> mapResultSetToBooksAndGenresList(ResultSet resultSet) throws SQLException {
        List<BooksWithGenres> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add((BooksWithGenres) mapFromResultSetBooksAndGenres(resultSet));
        }
        return books;
    }

    private Book mapFromResultSetBooksAndGenres(ResultSet string) throws SQLException {
        String title = "";
        String genre = "";
        title = string.getString("title");
        genre = string.getString("genre");
        BooksWithGenres booksWithGenres = new BooksWithGenres(title, genre);
        return booksWithGenres;
    }

    public List<Type> selectAllTypes(){
        String sql = "select * from books_types;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            ResultSet resultSet = statementmt.executeQuery();
            return mapResultSetToTypesList(resultSet);
        } catch (SQLException excption){
            throw new BooksException("Erro ao listar livros");
        }
    }

    private List<Type> mapResultSetToTypesList(ResultSet resultSet) throws SQLException {
        List<Type> types = new ArrayList<>();
        while (resultSet.next()) {
            types.add(mapFromResultSetTypes(resultSet));
        }
        return types;
    }

    private Type mapFromResultSetTypes(ResultSet resultSet) throws SQLException {
        Type type = new Type();
        type.setTypeId(Integer.parseInt(resultSet.getString("type_id")));
        type.setType(resultSet.getString("description"));
        return type;
    }
}
