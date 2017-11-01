package br.com.matysapiros.bookchooser.model;

public class BooksAndGenres extends Book{

    private String nome;
    private String genero;

    public BooksAndGenres(String nome, String genero){
        this.nome = nome;
        this.genero = genero;
    }

    public BooksAndGenres(){

    }

    public String getNome() {
        return nome;
    }

    public String getGenre() {
        return genre;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return ("Nome: " + nome + "\nGênero: " + genero);
    }
}
