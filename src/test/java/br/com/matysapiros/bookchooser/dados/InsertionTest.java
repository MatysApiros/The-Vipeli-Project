package br.com.matysapiros.bookchooser.dados;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionTest {
    @Test
    public void selectBook() throws Exception {
        Insertion insertion = new Insertion();
        org.junit.Assert.assertTrue(insertion.selectBook("Eragon"));
    }

    @Test
    public void insertBook() throws Exception {
        Insertion insertion = new Insertion();
        org.junit.Assert.assertTrue(insertion.insertBook("Eragon",1,8.75,1));
    }

}