package br.com.matysapiros.bookchooser.controler;

import br.com.matysapiros.bookchooser.database.BookDAO;
import br.com.matysapiros.bookchooser.database.GenreDAO;
import br.com.matysapiros.bookchooser.model.*;
import java.util.ArrayList;
import java.util.List;

public class ListsControler{

    private BookDAO bookDAO = new BookDAO();
    private GenreDAO genreDAO = new GenreDAO();

    public List<Book> listOfBooks(){
        List<Book> books = new ArrayList<>();
        books = bookDAO.selectAllBooks();
        return books;
    }

    public List<Genre> listOfGenres(){
        List<Genre> genres = new ArrayList<>();
        genres = genreDAO.selectAllGenres();
        return genres;
    }

    public List<Type> listOfTypes(){
        List<Type> types = new ArrayList<>();
        types = bookDAO.selectAllTypes();
        return types;
    }
}
