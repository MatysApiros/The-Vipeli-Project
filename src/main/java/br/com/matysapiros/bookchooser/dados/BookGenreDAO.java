package br.com.matysapiros.bookchooser.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public boolean SelectGenres(){
        String sql = "select * from genres;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new RuntimeException(excption);
        }
    }


}
