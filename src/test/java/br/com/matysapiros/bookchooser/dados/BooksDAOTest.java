package br.com.matysapiros.bookchooser.dados;

import br.com.matysapiros.bookchooser.negocios.Book;
import org.junit.Test;

public class BooksDAOTest {
    /*
    @Test
    public void selectBook() throws Exception {
        BookDAO bookDAO = new BookDAO();

        org.junit.Assert.assertTrue(bookDAO.selectBook());
    }

    @Test
    public void selectBook2() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.selectBookByName("Eldest"));
    }

    @Test
    public void selectBook3() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.selectBookByName("Brisingr"));
    }

    @Test
    public void selectBook4() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.selectBookByName("Herança"));
    }
    */
    @Test
    public void selectBookByID() throws Exception {
        BookDAO bookDAO = new BookDAO();
        Book book = new Book("Herança",4,1.00,0);
        org.junit.Assert.assert(book.equals(bookDAO.selectBookByID(7)));
    }
    /*
    @Test
    public void selectAllBooks() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.selectAllBooks());
    }
    */
    @Test
    public void insertBook() throws Exception {
        BookDAO bookDAO = new BookDAO();
        Book book = new Book("1984",1,9.50,1);
        org.junit.Assert.assertTrue(bookDAO.insertBook(book));
    }
    /*
    @Test
    public void insertBook2() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.insertBook("Eldest",2,7.5,1));
    }

    @Test
    public void insertBook3() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.insertBook("Brisingr",3,8.25,1));
    }

    @Test
    public void insertBook4() throws Exception {
        BookDAO bookDAO = new BookDAO();
        org.junit.Assert.assertTrue(bookDAO.insertBook("Herança",4, 1,0));
    }
    */
}