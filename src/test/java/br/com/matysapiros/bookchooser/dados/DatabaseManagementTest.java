package br.com.matysapiros.bookchooser.dados;

import org.junit.Test;

public class DatabaseManagementTest {
    @Test
    public void selectBook() throws Exception {
        DatabaseManagement databaseManagement = new DatabaseManagement();
        org.junit.Assert.assertTrue(databaseManagement.selectBook("Eragon"));
    }

    @Test
    public void insertBook() throws Exception {
        DatabaseManagement databaseManagement = new DatabaseManagement();
        org.junit.Assert.assertTrue(databaseManagement.insertBook("Eragon",1,8.75,1));
    }

}