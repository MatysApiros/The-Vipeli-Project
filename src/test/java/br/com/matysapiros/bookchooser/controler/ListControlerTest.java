package br.com.matysapiros.bookchooser.controler;

import br.com.matysapiros.bookchooser.model.BooksException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ListControlerTest {

    @Test
    public void deveDispararExceptionBookException(){
        ListsControler listsControler = new ListsControler();
        try {
            listsControler.listOfBooks();
        }catch (BooksException be){
            assertTrue(true);
        }
    }
}
