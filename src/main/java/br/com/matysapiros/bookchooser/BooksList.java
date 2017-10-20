package br.com.matysapiros.bookchooser;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BooksList {

    private List<Book> books;

    public BooksList() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
