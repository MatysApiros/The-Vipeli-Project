package br.com.matysapiros.bookchooser.model;

public class BooksException extends RuntimeException{

    private String mensagem;

    public BooksException(String msg){
        super(msg);
        this.mensagem = msg;
    }

}
