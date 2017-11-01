package br.com.matysapiros.bookchooser.controler;

import org.junit.Test;

public class DatabaseManagementTest {
    @Test
    public void insertBookGenreTest(){
        DatabaseManagement databaseManagement = new DatabaseManagement();
        org.junit.Assert.assertTrue(databaseManagement.insertBookGenre(1,6));
    }

    @Test
    public void insertBookGenreTest2(){
        DatabaseManagement databaseManagement = new DatabaseManagement();
        org.junit.Assert.assertTrue(databaseManagement.insertBookGenre(1,33));
    }

    @Test
    public void insertBookTypeTest(){
        DatabaseManagement databaseManagement = new DatabaseManagement();
        org.junit.Assert.assertTrue(databaseManagement.insertBookType(1,4));
    }
}