package br.com.matysapiros.bookchooser.controler;

import br.com.matysapiros.bookchooser.database.BookDAO;
import br.com.matysapiros.bookchooser.model.BooksWithGenres;
import java.util.ArrayList;
import java.util.List;

public class SelectsControler {

    private BookDAO bookDAO = new BookDAO();
    private List<BooksWithGenres> booksWithGenres = new ArrayList<>();
    private String book;

    public String selectBookByTitle(String title) {
        return book = bookDAO.selectBookByTitle(title);
    }

    public String selectBookByID(int bookId) {
        return book = bookDAO.selectBookByID(bookId);
    }

    public List<BooksWithGenres> selectBookWithGenre(Integer bookId) {
        return booksWithGenres = bookDAO.selectBooksAndGenres(bookId);
    }
}
