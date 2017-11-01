package br.com.matysapiros.bookchooser.controler;

import br.com.matysapiros.bookchooser.model.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookGenreDAO {
    private Connection connection;

    public BookGenreDAO() {
        this.connection = DatabaseConnetion.getConexao();
    }
    public boolean insertBookGenre(int bookID, int genreID){
        String sql = "insert into books_and_genres (book_id,genre_id) values(?,?);";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(bookID));
            statementmt.setString(2, String.valueOf(genreID));
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
