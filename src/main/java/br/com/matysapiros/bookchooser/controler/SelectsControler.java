package br.com.matysapiros.bookchooser.controler;

import br.com.matysapiros.bookchooser.database.BookDAO;

public class SelectsControler {

    private BookDAO bookDAO = new BookDAO();
    private String book;

    public String selectBookByTitle(String title){
        return book = bookDAO.selectBookByTitle(title);
    }

    public String selectBookByID(int bookId){
        return book = bookDAO.selectBookByID(bookId);
    }
}
